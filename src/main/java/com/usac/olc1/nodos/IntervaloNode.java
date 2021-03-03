package com.usac.olc1.nodos;
import com.usac.olc1.gui.Consola;

import java.util.ArrayList;

public class IntervaloNode extends Node {
    Node arg1; //inicio
    Node arg2; //final

    @Override
    public Object execute() {

        char inicio = (char) arg1.execute();
        char fin = (char) arg2.execute();
        ArrayList<Character> result = new ArrayList<Character>();

        // Convertiendo a ASCCI
        int asciiInicio = (int) inicio;
        int asciiFinal = (int) fin;

        // Validando que los limites sean correctos
        if (asciiInicio > asciiFinal) {
            Consola.println("[Error Semantico] -> Limites incorrectos");
            return null;
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

    public IntervaloNode(Node arg1, Node arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        // System.out.println("Constructor IntervaloNode ->" + begin + " - " + end);
    }

}
