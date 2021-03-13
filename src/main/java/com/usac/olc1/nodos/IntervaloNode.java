package com.usac.olc1.nodos;
import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.SymbolTableManager;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.TypeError;

import java.util.ArrayList;

public class IntervaloNode extends Node {
    Node arg1; //inicio
    Node arg2; //final

    int line;
    int column;

    @Override
    public Object execute(SymbolTableManager table, Tree tree) {

        char inicio = (char) arg1.execute(table, tree);
        char fin = (char) arg2.execute(table, tree);

        ArrayList<Character> result = new ArrayList<Character>();

        // Convertiendo a ASCCI
        int asciiInicio = (int) inicio;
        int asciiFinal = (int) fin;

        // Validando que los limites sean correctos
        if (asciiInicio >= asciiFinal) {
            //Agregando al arbol el error
            String descripcion = "Limites incorrectos.<br>Conflicto con valores: [" + inicio + "~" + fin + "]" ;
            ExceptionST error = new ExceptionST(TypeError.typesError.SEMANTICO.toString(), descripcion, line, column);
            tree.exceptions.add(error);
            //Agregando a consola error
            String errorString = "[ERROR SEMANTICO] " + "Limites incorrectos. Conflicto con valores: [" + inicio + "~" + fin + "]";
            tree.console.add(errorString);
            return error;
        } else {
            // Recorriendo el intervalo
            for (int i = asciiInicio; i <= asciiFinal; i++) {
                System.out.print((char) i + ", ");
                result.add((char) i);
            }
            System.out.println("");
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
