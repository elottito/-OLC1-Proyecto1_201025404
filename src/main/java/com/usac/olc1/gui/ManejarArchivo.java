package com.usac.olc1.gui;

import com.usac.olc1.st.Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ManejoArchivo
 */
public class ManejarArchivo {

    private String path = "";
    private String EXTENSION = "olc";

    public Tree arbol;

    /**
     * Se utiliza cuando se seleccione la opcion de ABRIR ARCHIVO Aqui solo voy a
     * mostrar la ventana para que se pueda abrir el archivo Y va a regresar la ruta
     * en donde se encuentre
     */
    public void abrirArchivo() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Compi1 *" + EXTENSION, EXTENSION);
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);
        int opcion = archivo.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            setPath(archivo.getSelectedFile().toString());
            Consola.println("Path: " + getPath());
        }
    }

    /**
     * Devuelve la ruta del archivo
     * 
     * @return path
     */
    public String getPath() {
        System.out.println("Ruta Archivo: " + path);
        return path;
    }

    /**
     * Modifica el nombre de la ruta del archivo
     * 
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * En este metodo se sobre-escribre el archivo ya abierto, desde la ruta que se
     * obtuvo antes Para guardar el archivo se va a llenar con un arreglo
     * 
     * @param texto
     */
    public void guardarArchivo(String texto) {
        File archivo = new File(getPath());
        String[] lineas = texto.split("\n");
        try (FileWriter e = new FileWriter(archivo)) {
            for (String s : lineas) {
                e.write(s + "\n");
            }
            Consola.println("Archivo Guardado exitosamente");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * En este metodo se guarda un archivo nuevo, tiene la misma funcion que
     * guardarArchivo Pero en este metodo, se escoge donde se va a guardar el
     * archivo
     * 
     * @param texto
     */
    public void guardarArchivoComo(String texto) {
        // Mostrar donde se va a guardar el archivo
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*" + EXTENSION, EXTENSION);
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);
        int opcion = archivo.showSaveDialog(null);

        // Comprueba si ha presionado el boton de aceptar
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String ruta = archivo.getSelectedFile().toString();

            // Si se escribe la extension, se omite para guardar
            if (ruta.contains(EXTENSION)) {
                ruta = ruta.replace("." + EXTENSION, "");
            }

            // Se crea una nueva ruta, en donde está ubicado el archivo
            setPath(ruta + "." + EXTENSION);
            guardarArchivo(texto);
        }
    }

    /**
     * Devuelve el texto contenido del Archivo
     * 
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
            System.out.println("Excepcion: " + e);
        }
        return strTexto;
    }    
}