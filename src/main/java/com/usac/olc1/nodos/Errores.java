package com.usac.olc1.nodos;

public class Errores {
    public int fila;
    public int columna;
    public String lexema;
    public String descripcion;

    /**
     * 
     * @param fila
     * @param columna
     * @param lexema
     * @param descripcion
     */
    public Errores (int fila, int columna, String lexema, String descripcion) {
        this.fila = fila;
        this.columna = columna;
        this.lexema = lexema;
        this.descripcion = descripcion;
    }

    public int getFila() {
        return this.fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getLexema() {
        return this.lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
