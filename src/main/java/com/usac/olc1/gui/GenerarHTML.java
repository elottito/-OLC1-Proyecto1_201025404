package com.usac.olc1.gui;

import com.usac.olc1.App;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarHTML {

    public void crearHtmlError() {
        String rutaArchivo = "salidas/html/error.html";
        System.out.println("Generando el Archivo HTML de Errores");
        File archivo = new File(rutaArchivo);

        try (FileWriter e = new FileWriter(archivo)) {
            // Inicio de HTML
            e.write("<!DOCTYPE html>\n");
            e.write("<html lang=\"es\">\n\n");
            e.write("<head>\n");
            e.write("\t<meta charset=\"UTF-8\">\n");
            e.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
            e.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            e.write("\t<title>Proyecto 1</title>\n");
            e.write("\t<link href=\"css/contenido.css\" type=\"text/css\" rel=\"stylesheet\">\n");
            e.write("</head>\n\n");
            e.write("<body>\n");
            e.write("\t<div class=\"contenedor\">\n");
            e.write("\t\t<span class=\"titulo\">Proyecto 1 - Regexive</span>\n");
            e.write("\t</div>\n");

            // Tabla Error
            e.write("\t<div class=\"tabla\">\n");
            e.write("\t\t<table>\n");
            e.write("\t\t\t<caption class=\"subtitulo\">Resumen de Errores</caption>\n");
            e.write("\t\t\t<thead>\n");
            e.write("\t\t\t\t<tr>\n");
            e.write("\t\t\t\t\t<th scope=\"col\">No</th>\n");
            e.write("\t\t\t\t\t<th scope=\"col\">Tipo Error</th>\n");
            e.write("\t\t\t\t\t<th scope=\"col\">Descripcion</th>\n");
            e.write("\t\t\t\t\t<th scope=\"col\">Fila</th>\n");
            e.write("\t\t\t\t\t<th scope=\"col\">Columna</th>\n");
            e.write("\t\t\t\t</tr>\n");
            e.write("\t\t\t</thead>\n");
            e.write("\t\t\t<tbody>\n");

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
            e.write("\t\t\t\t<!-- Fin de Tabla de Errores -->\n");
            e.write("\t\t\t</tbody>\n");
            e.write("\t\t</table>\n");
            e.write("\t</div>\n\n");
            e.write("</body>\n");
            e.write("</html>");

            // Se Muestran la pagina creada si tiene errores
            if (!App.listaErrores.isEmpty()) {
                File paginaWeb = new File(rutaArchivo);
                Desktop.getDesktop().open(paginaWeb);
            }

        } catch (IOException e) {
            System.out.println("Error al escribir el Archivo de HTLM: " + e);
        }

    }
}
