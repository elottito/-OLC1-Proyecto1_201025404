package com.usac.olc1.generadores; 

import java.io.File;

public class GenerarLexico 
{
    public static void main(String[] args) {
        //Ruta del archivo JFLEX
        String path="src/main/java/com/usac/olc1/analizadores/Scan.jflex";
        File file=new File(path);
        jflex.Main.generate(file);
    } 
}