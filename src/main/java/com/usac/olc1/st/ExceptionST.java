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
    
}
