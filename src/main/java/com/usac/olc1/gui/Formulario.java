/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.olc1.gui;

import com.formdev.flatlaf.FlatLightLaf;
import com.usac.olc1.App;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;

/**
 *
 * @author elottito
 */
public class Formulario extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static ManejarArchivo manejo = new ManejarArchivo();
    private static String strDirectorio;

    public Formulario() {
        //Look and Feel - FlatLigh Laf
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            System.out.println("Iniciando Look and Feel - FlatLight Laf");
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        initComponents();
        setComponents();
        
    }

    private void setComponents(){
        Consola.init(txtConsola);
    }
    
    private void salirAplicacion() {
        // Salir de la Aplicacions
        if (javax.swing.JOptionPane.showConfirmDialog(
                null, "¿Desea Salir de la Aplicación?",
                "Aplicación", javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE) == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void abrirArchivo() {
        // Abrir Archivo
        manejo.abrirArchivo(); // Se abre la venta de dialogo para abrir archivos
        String path = manejo.getPath(); // Se obtiene la ruta, de donde se abrio el archivo
        String texto = manejo.getTexto(path); // Se obtiene toda la información que tenga el texto
        txtCode.setText(texto);
        Consola.println("Path: " + manejo.getPath());
    }

    private void nuevoArchivo() {
        // Se limpian los cuadros de texto
        txtCode.setText("");
        manejo.setPath(strDirectorio);

    }

    private void guardarArchivo() {
        /* Se verifica, si el fichero ya existe o si se va a crear uno nuevo */
        String ruta = manejo.getPath();
        if (ruta.equals("")) { // Primero se verifica si la ruta, ya existe
            System.out.println("Es un nuevo Archivo a crear"); // Como No existe la ruta, entonces se guardara un archivo nuevo
            Consola.println("Nuevo archivo a crear");
            try {
                // Se obtiene todo el texto y se guarda
                manejo.guardarArchivoComo(convertirEnLineas(txtCode.getText()));
                System.out.println("Archivo Guardado Exitosamente");
                Consola.println("Archivo guardado exitosamente");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            // Ya existe la ruta, entonces se guarda nuevamente con el mismo nombre de la ruta el archivo - Se sobrescribe
            try {
                // Se sobreescribiria si se hizo algun cambios
                manejo.guardarArchivo(convertirEnLineas(txtCode.getText()));
                System.out.println("Archivo Guardado Exitosamente");
                Consola.println("Archivo guardado exitosamente");
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    private void guardarComoArchivo() {
        // Se va a guardar como un nuevo archivo
        try {
            manejo.guardarArchivoComo(convertirEnLineas(txtCode.getText()));
            System.out.println("Archivo Guardado Como Exitosamente");
            Consola.println("Archivo Guardado como exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private Boolean verificarArchivoExiste() {
        Boolean estado;
        // Aqui se verifica, si el fichero ya existe o si se va a crear uno nuevo
        // Esto se ejecuta hasta cuando se realiza el analisis lexico
        String ruta = this.manejo.getPath();
        // Primero se verifica la ruta, que si ya existe
        if (ruta == null || ruta.equals("")) {
            System.out.println("No se ha cargado ningun archivo");
            Consola.println("No se ha cargado ningun archivo");
            if (javax.swing.JOptionPane.showConfirmDialog(null, "¿Desea Guardar un archivo nuevo?", "Aplicación",
                    javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE) == javax.swing.JOptionPane.YES_OPTION) {
                // Se tendria que verificar si hay algun valor en el textArea y se puede guardar
                // No existe la ruta, entonces se guardara un archivo nuevo
                try {
                    manejo.guardarArchivoComo(convertirEnLineas(txtCode.getText()));
                    estado = true;
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                    estado = false;
                }
            } else {
                estado = false;
            }

        } else {
            // Ya existe la ruta, entonces se guarda nuevamente con el mismo nombre de la ruta el archivo - Se sobrescribe
            System.out.println("Ya hay un archivo abierto,");
            try {
                // Se sobreescribiria si se hizo algun cambios
                manejo.guardarArchivo(convertirEnLineas(txtCode.getText()));
                estado = true;
            } catch (Exception e) {
                System.out.println("Error: " + e);
                estado = false;
            }

        }
        return estado;
    }

    private String[] convertirEnLineas(String todoElTexto) {
        return todoElTexto.split("\n");
    }

    private void generarAutomata() {
        // Mandar los datos para EL SCANNER
        App.listaErrores.clear();

        // Primero se verifica: Si el archivo ya existe o si se va guardar uno nuevo
        if (Boolean.TRUE.equals(verificarArchivoExiste())) {
            manejo.guardarArchivo(convertirEnLineas(txtCode.getText()));
            manejo.correrArchivo(txtCode.getText()); // Si el archivo es creado, se corre el analizador lexico
            javax.swing.JOptionPane.showMessageDialog(null, "Analisis Léxico y Sintactico Finalizado", "Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Mostrar errores en pagina HTML
        GenerarHTML gh = new GenerarHTML();
        gh.crearHtmlError();
        manejo.hayErrores();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCode = new javax.swing.JTextArea();
        lblUbicacion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        lblConsola = new javax.swing.JLabel();
        lblUbicacion1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBarra = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenuItem();
        menuAbrir = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenuItem();
        menuGuardarComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        menuAnalizar = new javax.swing.JMenu();
        menuAutomata = new javax.swing.JMenuItem();
        menuAnalizarCadena = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto 1 - Regexive");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frmPrincipal"); // NOI18N

        txtCode.setColumns(20);
        txtCode.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtCode.setRows(5);
        txtCode.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCodeCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(txtCode);

        lblUbicacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUbicacion.setText("Linea: 0 Columna: 0");

        txtConsola.setEditable(false);
        txtConsola.setColumns(20);
        txtConsola.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtConsola.setRows(5);
        jScrollPane2.setViewportView(txtConsola);

        lblConsola.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblConsola.setText("Consola de Salida");

        lblUbicacion1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUbicacion1.setText("Archivo de Entrada:");

        menuBarra.setText("Archivo");

        menuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuNuevo.setText("Nuevo");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoActionPerformed(evt);
            }
        });
        menuBarra.add(menuNuevo);

        menuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuAbrir.setText("Abrir...");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        menuBarra.add(menuAbrir);

        menuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuGuardar.setText("Guardar");
        menuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarActionPerformed(evt);
            }
        });
        menuBarra.add(menuGuardar);

        menuGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuGuardarComo.setText("Guardar como...");
        menuGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarComoActionPerformed(evt);
            }
        });
        menuBarra.add(menuGuardarComo);
        menuBarra.add(jSeparator1);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuBarra.add(menuSalir);

        jMenuBar1.add(menuBarra);

        menuAnalizar.setText("Analizar");

        menuAutomata.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuAutomata.setText("Generar Automata");
        menuAutomata.setToolTipText("Analiza el archivo de entrada, genera los AFN, AFD");
        menuAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAutomataActionPerformed(evt);
            }
        });
        menuAnalizar.add(menuAutomata);

        menuAnalizarCadena.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuAnalizarCadena.setText("Analizar Cadenas");
        menuAnalizarCadena.setToolTipText("Evalua las expresiones regulares, genera un JSON de salida");
        menuAnalizar.add(menuAnalizarCadena);

        jMenuBar1.add(menuAnalizar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblConsola)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUbicacion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addComponent(lblUbicacion))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUbicacion)
                    .addComponent(lblUbicacion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConsola)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        this.abrirArchivo();
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void menuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoActionPerformed
        this.nuevoArchivo();
    }//GEN-LAST:event_menuNuevoActionPerformed

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
        this.guardarArchivo();
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void menuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarComoActionPerformed
        this.guardarComoArchivo();
    }//GEN-LAST:event_menuGuardarComoActionPerformed

    private void txtCodeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCodeCaretUpdate
        // Evento que Obtiene la Coordenada (fila y columna) del Texto
        int pos = evt.getDot();
        try {
            int row = txtCode.getLineOfOffset(pos) + 1;
            int col = pos - txtCode.getLineStartOffset(row - 1) + 1;
            lblUbicacion.setText("Línea: " + row + " Columna: " + col);
        } catch (BadLocationException exc) {
            System.out.println(exc);
        }
    }//GEN-LAST:event_txtCodeCaretUpdate

    private void menuAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAutomataActionPerformed
        this.generarAutomata();
    }//GEN-LAST:event_menuAutomataActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        this.salirAplicacion();
    }//GEN-LAST:event_menuSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Look and Feel - FlatLigh
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Formulario().setVisible(true);
            System.out.println("Run");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblConsola;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JLabel lblUbicacion1;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenu menuAnalizar;
    private javax.swing.JMenuItem menuAnalizarCadena;
    private javax.swing.JMenuItem menuAutomata;
    private javax.swing.JMenu menuBarra;
    private javax.swing.JMenuItem menuGuardar;
    private javax.swing.JMenuItem menuGuardarComo;
    private javax.swing.JMenuItem menuNuevo;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTextArea txtCode;
    private javax.swing.JTextArea txtConsola;
    // End of variables declaration//GEN-END:variables
}
