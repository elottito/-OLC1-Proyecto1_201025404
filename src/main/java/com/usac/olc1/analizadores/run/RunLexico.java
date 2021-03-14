package com.usac.olc1.analizadores.run;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class RunLexico {

    public static void main(String[] args) {
        // Ruta del archivo JFLEX
        String pathFlex = "src/main/java/com/usac/olc1/analizadores/jflex_cup/Lexico.jflex";
        File file = new File(pathFlex);
        jflex.Main.generate(file);

        // Moviendo el Archivo Generado JAVA
        Path origen = Paths.get("src/main/java/com/usac/olc1/analizadores/jflex_cup/Lexico.java");
        Path destino = Paths.get("src/main/java/com/usac/olc1/analizadores/Lexico.java");

        try {
            Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}