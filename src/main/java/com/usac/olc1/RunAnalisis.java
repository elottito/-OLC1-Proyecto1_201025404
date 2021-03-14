package com.usac.olc1;

import java.io.BufferedReader;
import java.io.StringReader;

import com.usac.olc1.analizadores.Lexico;
import com.usac.olc1.analizadores.Sintactico;
import com.usac.olc1.gui.Consola;
import com.usac.olc1.gui.GenerarHTML;
import com.usac.olc1.nodos.Node;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;

public class RunAnalisis {

    public Tree tree;

    /**
     * Inicia el Analisis lexico, sintactico y semantico
     * @param codigo codigo del archivo
     */
    public void ejecutarAnalisis(String codigo) {
        try {
            Consola.println("-> Iniciando Analisis...");
            // Generando jFlex y Cup
            Lexico lexico = new Lexico(new BufferedReader(new StringReader(codigo)));
            Sintactico sintactico = new Sintactico(lexico);

            // Creando Tabla de Simbolos
            SymbolTableManager table = new SymbolTableManager();
            table.Init();
            table.openContext();
            
            // Creando Tree
            Object obj = (Object) sintactico.parse().value;
            tree = (Tree) obj;
            
            // Primera Pasada al Arbol
            for (Node inst : tree.instructions) {
                inst.execute(table, tree);
            }

            // Mostrar Log y Errores 
            this.printLog(tree); 
            this.showErrores(tree); 

             // Cerrando la Tabla
             table.closeContext();
             Consola.println("-> Fin de Analisis");

            // Mensaje de Informacion
            javax.swing.JOptionPane.showMessageDialog(null, "Analisis Léxico y Sintactico Finalizado", "Información",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Error al correr el Analisis -->" + ex);
        }
    }

    private void showErrores(Tree tree) {
        GenerarHTML g = new GenerarHTML();
        g.crearHtmlError(tree);
    }

    private void printLog(Tree tree) {
        for (int i = 0; i < tree.console.size(); i++) {
            Consola.println(tree.console.get(i));
        }
    }
    

}
