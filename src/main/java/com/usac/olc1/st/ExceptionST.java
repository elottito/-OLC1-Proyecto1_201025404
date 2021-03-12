package com.usac.olc1.st;

/**
 * Clase para almacenar errores: lexicos, sintacticos, semanticos
 */
public class ExceptionST {
    String tipo;
    String descripcion;
    int fila;
    int columna;
    
    /**
     * Devuelve un objeto con la excepcion
     * @param tipo          Tipo de Error: lexico, sintactico, semantico
     * @param descripcion   Descripcion del error
     * @param fila          Fila del Error
     * @columna             Columna del Error
     */
    public ExceptionST(String tipo, String descripcion, int fila, int columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }


    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
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

    
}
