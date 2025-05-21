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
  private JButton runButton;

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

    JScrollPane inputScroll = new JScrollPane(inputArea);
    inputScroll.setBorder(BorderFactory.createTitledBorder("Código fuente"));

    JScrollPane outputScroll = new JScrollPane(outputArea);
    outputScroll.setBorder(BorderFactory.createTitledBorder("Resultado"));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.add(runButton);

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

  public static void main(String[] args) {
    SwingUtilities.invokeLater(LanguageIDE::new);
  }
}
