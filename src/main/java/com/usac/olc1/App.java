package com.usac.olc1;

import com.usac.olc1.gui.Formulario;
import com.usac.olc1.nodos.Errores;
import java.util.ArrayList;

/**
 * Universidad de San Carlos de Guatemala
 * Facultad de Ingenieria
 * Organizacion de Lenguajes y Compiladores 1
 * 2021 Primer Semestre
 * Proyecto 1 - Regexive
 * 
 * @author Otto Estevez
 * @version 1.0
 * @since 2021-02-26
 */
public class App {
    // Lista de Errores
    public static ArrayList<Errores> listaErrores = new ArrayList<Errores>();
    public static void main( String[] args )
    {
        //Mostrando el formulario
        Formulario frm = new Formulario();
        frm.setVisible(true);   
    }
}
