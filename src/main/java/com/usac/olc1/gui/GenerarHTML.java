package com.usac.olc1.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.usac.olc1.st.Tree;

public class GenerarHTML {

    public void crearHtmlError(Tree tree) {        
        String RUTA_ARCHIVO = "salidas/html/error.html";
        File archivo = new File(RUTA_ARCHIVO);

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
            if(!tree.exceptions.isEmpty()){
                for (int i = 0; i <= tree.exceptions.size() - 1; i++) {         
                    String tipoError = tree.exceptions.get(i).getTipo().toLowerCase();
                    String description = tree.exceptions.get(i).getDescripcion();
                    int line = tree.exceptions.get(i).getFila() + 1;
                    int column = tree.exceptions.get(i).getColumna() + 1;
                    e.write("\t\t\t\t<tr>\n");
                    e.write("\t\t\t\t\t<td>" + i + "</td>\n");
                    e.write("\t\t\t\t\t<td>" + tipoError + "</td>\n"); 
                    e.write("\t\t\t\t\t<td>" + description + "</td>\n");
                    e.write("\t\t\t\t\t<td>" + line + "</td>\n"); 
                    e.write("\t\t\t\t\t<td>" + column + "</td>\n");
                    e.write("\t\t\t\t</tr>\n\n");
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
            if (!tree.exceptions.isEmpty()) {
                System.out.println("Mostrando el Archivo HTML de Errores...");
                File paginaWeb = new File(RUTA_ARCHIVO);
                Desktop.getDesktop().open(paginaWeb);
            }

        } catch (IOException e) {
            System.out.println("Error al escribir el Archivo de HTLM: " + e);
        }

    }
}
