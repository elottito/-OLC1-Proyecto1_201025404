package com.usac.olc1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import com.usac.olc1.analizadores.AnalizadorLexico;
import com.usac.olc1.analizadores.AnalizadorSintactico;

/**
 * ManejoArchivo
 */
public class ManejoArchivo {

    private String path = "";

    /**
     * Devuelve la ruta del archivo
     * @return path
     */
    public String getPath() {
        System.out.println("Ruta Archivo: " + path);
        return path;
    }

    /**
     * Modifica el nombre de la ruta del archivo
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Devuelve el texto contenido del Archivo
     * @param path Ruta del Archivo
     * @return texto Texto del Archivo 
     */
    public String getTexto(String path) {
        String strTexto = "";
        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            StringBuilder sbTexto;
            BufferedReader br = new BufferedReader(fr);
            sbTexto = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sbTexto.append(linea);
                sbTexto.append("\n");
            }
            strTexto = sbTexto.toString();
        } catch (IOException e) {
            System.out.println("Excepcion: " +e );
        }
        return strTexto;
    }

    /**
     * Ejecuta los Analisis Lexicos y Sintacticos
     * @param texto codigo del archivo
     */
    public void correrArchivo(String texto) {
        limpiarListas();
        try {
            System.out.println("---------------------------------------");
            System.out.println("          A N A L I Z A D O R          ");
            System.out.println("---------------------------------------");
            AnalizadorLexico miScanner = new AnalizadorLexico(new BufferedReader(new StringReader(texto)));
            AnalizadorSintactico miParser = new AnalizadorSintactico(miScanner);
            miParser.parse();
            System.out.println("--------------   F I N   --------------");
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Error al correr el Analisis: " + ex);
        }

    }

    public void limpiarListas() {
        System.out.println("Limpiar Listas");
    }
}