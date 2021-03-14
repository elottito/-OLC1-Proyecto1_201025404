package com.usac.olc1.nodos;

import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.TypeError;

import java.util.ArrayList;

public class IntervaloNode extends Node {
    Node arg1; // inicio
    Node arg2; // final

    int line;
    int column;

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {
        ArrayList<String> result = new ArrayList<String>();

        // Obteniendo el valor
        String strInicio = (String) arg1.execute(table, tree);
        String strFin = (String) arg2.execute(table, tree);

        // Conviertiendo a tipo CHAR
        char charInicio = strInicio.toString().charAt(0);
        char charFin = strFin.toString().charAt(0);

        // Convertiendo a ASCCI
        int asciiInicio = (int) charInicio;
        int asciiFinal = (int) charFin;

        // Validando que los limites sean correctos
        if (asciiInicio >= asciiFinal) {
            // Agregando al arbol el error
            String descripcion = "Limites incorrectos.<br>Conflicto con el rango de valores: <b>[" + strInicio + "~"
                    + strFin + "]</b>";
            String tipo = TypeError.typesError.SEMANTICO.toString();
            ExceptionST error = new ExceptionST(tipo, descripcion, line, column);
            tree.exceptions.add(error);

            // Agregando a consola error
            String errorString = "[ERROR SEMANTICO] " + "Limites incorrectos. Conflicto con valores: [" + strInicio
                    + "~" + strFin + "]";
            tree.console.add(errorString);
            // return error;
            return result;
        } else {
            // Recorriendo el intervalo
            for (int i = asciiInicio; i <= asciiFinal; i++) {
                // System.out.print((char) i + ", ");
                // Agregando los caracteres al result
                result.add(Character.toString((char) i));
            }
        }
        return result;
    }

    public IntervaloNode(Node arg1, Node arg2, int line, int column) {
        super(arg1.type, line, column);
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.line = line;
        this.column = column;
    }

}
