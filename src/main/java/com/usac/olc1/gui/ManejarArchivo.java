package com.usac.olc1.gui;

import com.usac.olc1.App;
import com.usac.olc1.analizadores.AnalizadorLexico;
import com.usac.olc1.analizadores.AnalizadorSintactico;
import com.usac.olc1.nodos.DeclareConjunto;
import com.usac.olc1.nodos.ErrorNode;
import com.usac.olc1.nodos.Node;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Map;
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

    /**
     * Reporte de Errores
     * 
     * @param texto
     */
    private void reporteErrores() {
        GenerarHTML gh = new GenerarHTML();
        gh.crearHtmlError();
        if (App.listaErrores.isEmpty()) {
            Consola.println("No hay errores lexicos o sintacticos");
        } else {
            Consola.println("Hay Errores - Verificar Reporte HTML");
        }
    }

    /**
     * Ejecuta los Analisis Lexicos y Sintacticos
     * 
     * @param texto codigo del archivo
     */
    public void ejecutarAnalisis(String texto) {
        try {
            Consola.println("-> Iniciando Analisis...");

            AnalizadorLexico lexico = new AnalizadorLexico(new BufferedReader(new StringReader(texto)));
            AnalizadorSintactico sintactico = new AnalizadorSintactico(lexico);

            // Creando Tabla de Simbolos
            SymbolTableManager table = new SymbolTableManager();
            Object obj = (Object) sintactico.parse().value;
            App.tree.arbol = (Tree) obj;
            //Tree tree = (Tree) obj;

            // Primera Pasada al Arbol
            for (Node inst : App.tree.arbol.instructions) {
                // if (inst instanceof DeclareConjunto){
                inst.execute(table, App.tree.arbol);
                // }
            }

            // Consola LOG
            /*
            Consola.println("Consola LOG...");
            for (int i = 0; i <= tree.console.size() - 1; i++) {
                Consola.println(tree.console.get(i));
            }
            */

            // Errores
            /*
            for (Node inst : tree.instructions) {
                if (inst instanceof ErrorNode) {
                    inst.execute(table, tree);
                    System.out.println("Errores....");
                }
            }
            */

            for (int i = 0; i <= App.tree.arbol.exceptions.size() - 1; i++) {
                // Consola.println( tree.consoexcle.get(i) );
                String tipoError = App.tree.arbol.exceptions.get(i).getTipo();
                String description = App.tree.arbol.exceptions.get(i).getDescripcion();
                int line = App.tree.arbol.exceptions.get(i).getFila();
                int column = App.tree.arbol.exceptions.get(i).getColumna();

                System.out.println("Error:       " + i);
                System.out.println("Tipo:        " + tipoError);
                System.out.println("Descripcion: " + description);
                System.out.println("Fila:        " + line);
                System.out.println("Columna:     " + column);

            }

            Consola.println("-> Fin de Analisis");

            // Mensaje de Informacion
            javax.swing.JOptionPane.showMessageDialog(null, "Analisis Léxico y Sintactico Finalizado", "Información",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

            // Mostrar errores en pagina HTML
            //reporteErrores();

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Error al correr el Analisis -->" + ex);
        }
    }
}