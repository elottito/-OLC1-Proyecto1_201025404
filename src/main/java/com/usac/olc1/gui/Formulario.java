/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.olc1.gui;

import com.formdev.flatlaf.FlatLightLaf;
import com.usac.olc1.RunAnalisis;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;

public class Formulario extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ManejarArchivo manejo = new ManejarArchivo();
    private RunAnalisis runAnalisis = new RunAnalisis();

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
    }

    private void nuevoArchivo() {
        // Se limpian el cuadro de texto y la ruta
        txtCode.setText("");
        manejo.setPath("");

    }

    private void guardarArchivo() {
        // Verificar si el fichero ya existe o crear uno nuevo
        if (manejo.getPath().isEmpty()) { 
            // No existe la ruta, crear un archivo nuevo
            manejo.guardarArchivoComo(txtCode.getText());
        } else {
            // Ya existe la ruta, sobrescribir el archivo
           manejo.guardarArchivo(txtCode.getText());
        }
    }

    /**
     * Verifica si el ya existe el archivo 
     * o si se debe guardar para poder analizarlo
     * @return existe
     */
    private boolean verificarArchivoExiste() {
        boolean existe;
         // Se verifica, si el fichero ya existe o si se va a crear uno nuevo 
        if (manejo.getPath().isEmpty()) {
            // No existe la ruta, entonces se guardara un archivo nuevo
            Consola.println("Nuevo archivo a crear");
            if (javax.swing.JOptionPane.showConfirmDialog(null, "¿Desea Guardar un archivo nuevo?", "Aplicación",
                    javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE) == javax.swing.JOptionPane.YES_OPTION) {
                // Crear un archivo nuevo
                manejo.guardarArchivoComo(txtCode.getText());
                existe = true;
            } else {
                existe = false;
            }
        } else {
            // Se sobrescribe el archivo
            Consola.println("Sobrescribiendo archivo");
            manejo.guardarArchivo(txtCode.getText());
            existe = true;
        }
        return existe;
    }

    private void generarAutomata() {
        // Primero se verifica: Si el archivo ya existe o si se va guardar uno nuevo
        if (verificarArchivoExiste()) {
            // Mandar los datos para EL SCANNER
            Consola.println("Sobrescribiendo archivo");
            runAnalisis.ejecutarAnalisis(txtCode.getText());
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConsola)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUbicacion1)
                        .addGap(426, 426, 426)
                        .addComponent(lblUbicacion)
                        .addGap(46, 46, 46))))
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
        manejo.guardarArchivoComo(txtCode.getText());
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
