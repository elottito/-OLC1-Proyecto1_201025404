package com.usac.olc1.analizadores.run;

public class RunSintactico {

    public static void main(String[] args) {
        String[] opciones = new String[7];
        opciones[0] = "-destdir"; // Seleccionamos la opción de dirección de destino
        opciones[1] = "src/main/java/com/usac/olc1/analizadores"; // Ubicacion para las siguientes clases
        opciones[2] = "-symbols"; // Seleccionamos la opción de nombre de archivo simbolos
        opciones[3] = "TSymbol"; // Nombre de la clase de Tabla de Simblos
        opciones[4] = "-parser"; // Seleccionar la opcion de clase parser
        opciones[5] = "Sintactico"; // Nombre de la clase del Analizador Sintactico
        opciones[6] = "src/main/java/com/usac/olc1/analizadores/jflex_cup/Sintactico.cup"; // Ubicacion de Archivo CUP
        try {
            java_cup.Main.main(opciones);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

}
