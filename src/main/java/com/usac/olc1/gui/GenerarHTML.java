package com.usac.olc1.gui;

import com.usac.olc1.App;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarHTML {

    public void crearHtmlError() {
        String rutaArchivo = "archivos/html/error.html";
        System.out.println("Generando el Archivo HTML de Errores");
        File archivo = new File(rutaArchivo);

        try (FileWriter e = new FileWriter(archivo)) {
            // Inicio de HTML
            e.write("" + "<!DOCTYPE html>\n" + "<html lang=\"es\">\n\n" + "<head>\n" + "\t<meta charset=\"UTF-8\">\n"
                    + "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "\t<title>Proyecto 1</title>\n"
                    + "\t<link href=\"css/contenido.css\" type=\"text/css\" rel=\"stylesheet\">\n" + "</head>\n\n"
                    + "<body>\n" + "\t<div class=\"contenedor\">\n" + "\t\t<span class=\"titulo\">Proyecto 1 - Regexive</span>\n"
                    + "\t</div>\n" + "\t<div class=\"tabla\">\n" + "\t\t<table>\n"
                    + "\t\t\t<caption class=\"subtitulo\"> Resumen de Errores</caption>\n" + "\t\t\t<thead>\n"
                    + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<th scope=\"col\">No</th>\n"
                    + "\t\t\t\t\t<th scope=\"col\">Lexema</th>\n" + "\t\t\t\t\t<th scope=\"col\">Descripcion</th>\n"
                    + "\t\t\t\t\t<th scope=\"col\">Fila</th>\n" + "\t\t\t\t\t<th scope=\"col\">Columna</th>\n"
                    + "\t\t\t\t</tr>\n" + "\t\t\t</thead>\n" + "\t\t\t<tbody>\n");

            // T A B L A E R R O R
            // Aqui inicia el Listado de Datos que se van a mostrar para la TABLA
            e.write("\t\t\t\t<!-- Aqui se colocan los datos para la tabla -->\n");
            int contador = 1;

            if (!App.listaErrores.isEmpty()) {
                for (int i = 0; i < App.listaErrores.size(); i++) {
                    e.write("\t\t\t\t<tr>\n");
                    e.write("\t\t\t\t\t<td>" + contador + "</td>\n");
                    e.write("\t\t\t\t\t<td>" + App.listaErrores.get(i).lexema + "</td>\n"); // lexema
                    e.write("\t\t\t\t\t<td>" + App.listaErrores.get(i).descripcion + "</td>\n"); // descp
                    e.write("\t\t\t\t\t<td>" + App.listaErrores.get(i).fila + "</td>\n"); // fila
                    e.write("\t\t\t\t\t<td>" + App.listaErrores.get(i).columna + "</td>\n"); // columna
                    e.write("\t\t\t\t</tr>\n\n");
                    contador++;
                }
            }

            // Cierre de Etiquetas
            e.write("\t\t\t\t<!-- Fin de Tabla de Errores -->\n" + "\t\t\t</tbody>\n" + "\t\t</table>\n"
                    + "\t</div>\n\n" + "</body>\n" + "</html>");

            // Se Muestran la pagina creada si tiene errores
            if (!App.listaErrores.isEmpty()){
                File paginaWeb = new File(rutaArchivo);
                Desktop.getDesktop().open(paginaWeb);
            }
            
        } catch (IOException e) {
            System.out.println("Error al escribir el Archivo de HTLM: " + e);
        }

    }
}
