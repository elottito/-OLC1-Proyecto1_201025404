package com.usac.olc1.gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;

public class Consola {
    
    public static JTextArea consola;
    
    public static void init(JTextArea txt) {
        txt.setText("Regexive - Consola:\n");
        consola = txt;
    }

    public static String simpleDate (){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
     public static void println(String s, String info) {
        print("[" + simpleDate() + "][" + info + "] " + s + "\n");
    }

    public static void println(String s) {                
        print("[" + simpleDate() + "] " + s + "\n");
    }

    public static void print(String s) {
        consola.setText(consola.getText() + s);
    }

    public static void reset() {
        consola.setText("Regexive - Consola:\n");
    }
    
}
