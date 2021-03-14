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

    /**
     * Inicia el Analisis <i>lexico, sintactico y semantico</i>
     * @param texto codigo del archivo
     */
    public void ejecutarAnalisis(String texto) {
        try {
            Consola.println("-> Iniciando Analisis...");
            // Generando jFlex y Cup
            Lexico lexico = new Lexico(new BufferedReader(new StringReader(texto)));
            Sintactico sintactico = new Sintactico(lexico);

            // Creando Tabla de Simbolos
            SymbolTableManager table = new SymbolTableManager();
            table.Init();
            table.openContext();
            
            // Creando Tree
            Object obj = (Object) sintactico.parse().value;
            Tree tree = (Tree) obj;
            
            // Primera Pasada al Arbol
            for (Node inst : tree.instructions) {
                inst.execute(table, tree);
            }

            // Cerrando la Tabla
            table.closeContext();
            Consola.println("-> Fin de Analisis");

            // Mostrar Errores 
            this.showErrores(tree);

            // Mensaje de Informacion
            javax.swing.JOptionPane.showMessageDialog(null, "Analisis Léxico y Sintactico Finalizado", "Información",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Error al correr el Analisis -->" + ex);
        }
    }


    /*
    private void printLog(Tree tree) {
        Consola.println("Consola LOG...");
        for (int i = 0; i <= tree.console.size() - 1; i++) {
            Consola.println(tree.console.get(i));
        }
    }
    */

    private void showErrores(Tree tree) {
        GenerarHTML g = new GenerarHTML();
        g.crearHtmlError(tree);
    }

}
