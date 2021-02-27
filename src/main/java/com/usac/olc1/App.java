package com.usac.olc1;

/**
 * Universidad de San Carlos de Guatemala
 * Facultad de Ingenieria
 * Organizacion de Lenguajes y Compiladores 1
 * 2021 Primer Semestre
 * Proyecto 1 - Regexive
 * 
 * @author Otto Estevez
 * @version 1.0
 * @since 2021-02-26
 */
public class App 
{
    public static void main( String[] args )
    {
        //Ruta de Archivo de Pruebas
        String strRuta = "C:\\pruebas\\archivo.olc";
        ManejoArchivo ma = new ManejoArchivo();
        String strTexto = ma.getTexto(strRuta);
        System.out.println(strTexto);
        ma.correrArchivo(strTexto);
        
    }
}
