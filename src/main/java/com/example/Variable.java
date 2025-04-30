package com.example;

public class Variable {
    public enum Tipo {
        INT, FLOAT, STRING, BOOLEAN
    }
    public Tipo tipo;
    public Object valor;

    public Variable(Tipo tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
