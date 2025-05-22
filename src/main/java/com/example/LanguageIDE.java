package com.example;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import java.io.*;

public class LanguageIDE extends JFrame {

  private JTextArea inputArea;
  private JTextArea outputArea;
  private JButton runButton,runButtonPy, runButtonCSharp;
  private JButton exportPyButton, exportCSharpButton,exportMyLanguageButton;

  public LanguageIDE() {
    setTitle("Lenguaje Custom IDE");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800, 600);
    setLocationRelativeTo(null);

    initComponents();
    initDragAndDrop();

    setVisible(true);
  }

  private void initComponents() {
    inputArea = new JTextArea();
    outputArea = new JTextArea();
    outputArea.setEditable(false);

    runButton = new JButton("Ejecutar");
    runButton.addActionListener(e -> ejecutarCodigo());
    runButtonPy = new JButton("Convertir a .py");
    runButtonPy.addActionListener(e -> convertirAPython());

    // runButton.addActionListener(e -> ejecutarConvertirPy());
    runButtonCSharp = new JButton("Convertir a .c#");
    runButtonCSharp.addActionListener(e -> convertirACSharp());
    exportPyButton = new JButton("Exportar .py");
exportPyButton.addActionListener(e -> exportarPython());
exportCSharpButton = new JButton("Exportar .c#");
exportCSharpButton.addActionListener(e -> exportarCSharp());
    exportMyLanguageButton = new JButton("Exportar .kys");
    exportMyLanguageButton.addActionListener(e -> exportarMyLanguage());


    JScrollPane inputScroll = new JScrollPane(inputArea);
    inputScroll.setBorder(BorderFactory.createTitledBorder("Código fuente"));

    JScrollPane outputScroll = new JScrollPane(outputArea);
    outputScroll.setBorder(BorderFactory.createTitledBorder("Resultado"));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.add(runButton);
    buttonPanel.add(runButtonPy);
    buttonPanel.add(runButtonCSharp);
    buttonPanel.add(exportPyButton);
    buttonPanel.add(exportCSharpButton);
    buttonPanel.add(exportMyLanguageButton);

    setLayout(new BorderLayout());
    add(inputScroll, BorderLayout.CENTER);
    add(outputScroll, BorderLayout.SOUTH);
    add(buttonPanel, BorderLayout.NORTH);

    outputScroll.setPreferredSize(new Dimension(800, 200));
  }

  private void initDragAndDrop() {
    new DropTarget(inputArea, new DropTargetAdapter() {
      @Override
      public void drop(DropTargetDropEvent evt) {
        try {
          evt.acceptDrop(DnDConstants.ACTION_COPY);
          Transferable transferable = evt.getTransferable();
          java.util.List<File> droppedFiles = (java.util.List<File>) transferable
              .getTransferData(DataFlavor.javaFileListFlavor);

          for (File file : droppedFiles) {
            if (file.getName().endsWith(".kys")) {
              String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
              inputArea.setText(content);
              outputArea.setText("Archivo cargado: " + file.getName());
            } else {
              outputArea.setText("Archivo no compatible: " + file.getName());
            }
          }
        } catch (Exception ex) {
          outputArea.setText("Error al leer el archivo: " + ex.getMessage());
        }
      }
    });
  }

  private void convertirAPython() {
  String codigo = inputArea.getText();
  try {
    CharStream input = CharStreams.fromString(codigo);
    LanguageLexer lexer = new LanguageLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    LanguageParser parser = new LanguageParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
          int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException("Error de sintaxis en línea " + line + ":" + charPositionInLine + " - " + msg);
      }
    });

    LanguageParser.ProgramContext tree = parser.program();
    LanguageToPythonVisitor pyVisitor = new LanguageToPythonVisitor();
    String pythonCode = pyVisitor.visit(tree);

    outputArea.setText(pythonCode);
  } catch (Exception e) {
    outputArea.setText("Error:\n" + e.getMessage());
  }
}
private void convertirACSharp() {
  String codigo = inputArea.getText();
  try {
    CharStream input = CharStreams.fromString(codigo);
    LanguageLexer lexer = new LanguageLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    LanguageParser parser = new LanguageParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
          int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException("Error de sintaxis en línea " + line + ":" + charPositionInLine + " - " + msg);
      }
    });

    LanguageParser.ProgramContext tree = parser.program();
    LanguageToCSharpVisitor csVisitor = new LanguageToCSharpVisitor();
    String csharpCode = csVisitor.visit(tree);

    outputArea.setText(csharpCode);
  } catch (Exception e) {
    outputArea.setText("Error:\n" + e.getMessage());
  }
}
private void exportarPython() {
  String codigo = inputArea.getText();
  try {
    CharStream input = CharStreams.fromString(codigo);
    LanguageLexer lexer = new LanguageLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    LanguageParser parser = new LanguageParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
          int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException("Error de sintaxis en línea " + line + ":" + charPositionInLine + " - " + msg);
      }
    });

    LanguageParser.ProgramContext tree = parser.program();
    LanguageToPythonVisitor pyVisitor = new LanguageToPythonVisitor();
    String pythonCode = pyVisitor.visit(tree);

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar como");
    fileChooser.setSelectedFile(new File("codigo.py"));
    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
      File fileToSave = fileChooser.getSelectedFile();
      try (FileWriter fw = new FileWriter(fileToSave)) {
        fw.write(pythonCode);
        outputArea.setText("Archivo .py exportado: " + fileToSave.getAbsolutePath());
      }
    }
  } catch (Exception e) {
    outputArea.setText("Error:\n" + e.getMessage());
  }
}
private void exportarCSharp() {
  String codigo = inputArea.getText();
  try {
    CharStream input = CharStreams.fromString(codigo);
    LanguageLexer lexer = new LanguageLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    LanguageParser parser = new LanguageParser(tokens);

    parser.removeErrorListeners();
    parser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
          int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException("Error de sintaxis en línea " + line + ":" + charPositionInLine + " - " + msg);
      }
    });

    LanguageParser.ProgramContext tree = parser.program();
    LanguageToCSharpVisitor csVisitor = new LanguageToCSharpVisitor();
    String csharpCode = csVisitor.visit(tree);

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar como");
    fileChooser.setSelectedFile(new File("codigo.cs"));
    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
      File fileToSave = fileChooser.getSelectedFile();
      try (FileWriter fw = new FileWriter(fileToSave)) {
        fw.write(csharpCode);
        outputArea.setText("Archivo .c# exportado: " + fileToSave.getAbsolutePath());
      }
    }
  } catch (Exception e) {
    outputArea.setText("Error:\n" + e.getMessage());
  }
}

  private void ejecutarCodigo() {
    String codigo = inputArea.getText();
    try {
      CharStream input = CharStreams.fromString(codigo);
      LanguageLexer lexer = new LanguageLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      LanguageParser parser = new LanguageParser(tokens);

      // Captura errores de sintaxis
      parser.removeErrorListeners();
      parser.addErrorListener(new BaseErrorListener() {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
            int line, int charPositionInLine, String msg, RecognitionException e) {
          throw new RuntimeException("Error de sintaxis en línea " + line + ":" + charPositionInLine + " - " + msg);
        }
      });

      LanguageParser.ProgramContext tree = parser.program();
      LanguageCustomVisitor visitor = new LanguageCustomVisitor();
      Object result = visitor.visit(tree);

      outputArea.setText("Ejecución correcta.:\n");
    } catch (Exception e) {
      outputArea.setText("Error:\n" + e.getMessage());
    }
  }
  private void exportarMyLanguage() {
    String codigo = inputArea.getText();
    try {
        // Validate the syntax before saving
        CharStream input = CharStreams.fromString(codigo);
        LanguageLexer lexer = new LanguageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                    int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException("Error de sintaxis en línea " + line + ":" + charPositionInLine + " - " + msg);
            }
        });

        // Verify syntax is correct by parsing
        parser.program();

        // If no syntax errors, proceed to save
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como");
        fileChooser.setSelectedFile(new File("codigo.kys"));
        
        // Add file filter for .kys files
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".kys") || f.isDirectory();
            }
            public String getDescription() {
                return "Archivos de Lenguaje Custom (.kys)";
            }
        });

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // Add .kys extension if not present
            if (!fileToSave.getName().toLowerCase().endsWith(".kys")) {
                fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".kys");
            }
            
            try (FileWriter fw = new FileWriter(fileToSave)) {
                fw.write(codigo);
                outputArea.setText("Archivo .kys exportado: " + fileToSave.getAbsolutePath());
            }
        }
    } catch (Exception e) {
        outputArea.setText("Error:\n" + e.getMessage());
    }
}

  public static void main(String[] args) {
    SwingUtilities.invokeLater(LanguageIDE::new);
  }
}
