package com.usac.olc1.gui;
import com.usac.olc1.App;
import com.usac.olc1.analizadores.AnalizadorLexico;
import com.usac.olc1.analizadores.AnalizadorSintactico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ManejoArchivo
 */
public class ManejarArchivo {

    private String path = "";
    String extensionArchivo = "olc";
    int contador;

    /**
     * Se utiliza cuando se seleccione la opcion de ABRIR ARCHIVO
     * Aqui solo voy a mostrar la ventana para que se pueda abrir el archivo
     * Y va a regresar la ruta en donde se encuentre
     */
    public void abrirArchivo() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Compi1 *" + extensionArchivo, extensionArchivo);
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);
        int opcion = archivo.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            setPath(archivo.getSelectedFile().toString());
        }
    }
    
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
     * En este metodo se sobre-escribre el archivo ya abierto, desde la ruta que se obtuvo antes
     * Para guardar el archivo se va a llenar con un arreglo
     * @param linea 
     */
    public void guardarArchivo(String[] linea) {
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter(getPath());
            pw = new PrintWriter(fichero);
            for (String linea1 : linea) {
                pw.println(linea1); // Aqui se agrega linea por linea
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } 
    }
 
    /**
     * En este metodo se guarda un archivo nuevo, tiene la misma funcion que guardarARchivo
     * Pero en este metodo, se coloca donde se va a guardar el archivo
     * @param linea 
     */
    public void guardarArchivoComo(String[] linea) {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*" + extensionArchivo, extensionArchivo);
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);
        int opcion = archivo.showSaveDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
            String ruta = archivo.getSelectedFile().toString();
            if (ruta.contains(extensionArchivo)) { // Si se escribe la extension, se omite para guardar
                ruta = ruta.replace("." + extensionArchivo, "");
            }
            FileWriter fichero = null;
            PrintWriter pw;
            try {
                setPath(ruta + "." + extensionArchivo); // Se crea una nueva ruta, en donde está ubicado el archivo
                fichero = new FileWriter(getPath());
                pw = new PrintWriter(fichero);
                for (String linea1 : linea) {
                    pw.println(linea1); // Aqui se agrega linea por linea
                }
            } catch (IOException e) {
                System.out.println("Error: " + e);
                System.out.println("El Archivo No existe:");
            } 
        }
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
     * Verifica si existen errores
     * @return 
     */
    Boolean hayErrores() {
        if (App.listaErrores.isEmpty()) {
            System.out.println("No hay Errores");
            Consola.println("No hay errores lexicos o sintacticos");
            return false;
        } else {
            System.out.println("Si hay Errores");
            Consola.println("Hay Errores - Verificar Reporte HTML");
            return true;
        }
    }

    /**
     * Ejecuta los Analisis Lexicos y Sintacticos
     * @param texto codigo del archivo
     */
    public void correrArchivo(String texto) {
        try {          
            Consola.println("Iniciar Analisis...");
            AnalizadorLexico miScanner = new AnalizadorLexico(new BufferedReader(new StringReader(texto)));
            AnalizadorSintactico miParser = new AnalizadorSintactico(miScanner);
            miParser.parse();
            Consola.println("Fin Analisis");
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Error al correr el Analisis: " + ex);
        }
    }
}