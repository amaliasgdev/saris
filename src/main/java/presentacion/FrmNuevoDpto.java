package presentacion;

import entidades.Departamento;
import javax.swing.JFrame;
import negocio.DepartamentoControl;
import presentacion.utiles.Comunes;

public class FrmNuevoDpto extends javax.swing.JInternalFrame {

    private final DepartamentoControl DEPARTAMENTO_CONTROL;
    private Departamento departamento;
    public JFrame contenedor;

    public FrmNuevoDpto() {
        initComponents();
        DEPARTAMENTO_CONTROL = new DepartamentoControl();
        txtIdJefeDepartamento.setVisible(false);
        txtIdRol.setVisible(false);
    }

    private void limpiar() {
        txtNombre.setText("");  
        txtTipoRol.setText("");
        txtPorcentaje.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtIdJefeDepartamento = new javax.swing.JTextField();
        txtIdRol = new javax.swing.JTextField();
        panelFondo = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTipoRol = new javax.swing.JTextField();
        btnAcceso = new javax.swing.JButton();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 255), null, null));
        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo Departamento");

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));

        btnBorrar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/limpiar.png"))); // NOI18N
        btnBorrar.setText("Limpiar Formulario");
        btnBorrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrar.setBorderPainted(false);
        btnBorrar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnBorrar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnBorrar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setBorderPainted(false);
        btnGuardar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnGuardar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnGuardar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtIdJefeDepartamento.setEditable(false);
        txtIdJefeDepartamento.setBackground(new java.awt.Color(204, 204, 204));

        txtIdRol.setEditable(false);
        txtIdRol.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addComponent(txtIdJefeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBorrar, btnGuardar});

        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdJefeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotonesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBorrar, btnGuardar});

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Nombre Departamento(*):");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Porcentaje sobre Comisiones(*):");

        txtPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPorcentaje.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Tipo de Acceso(*):");

        txtTipoRol.setEditable(false);
        txtTipoRol.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTipoRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnAcceso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnAcceso.setText("...");
        btnAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 144, Short.MAX_VALUE))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtTipoRol))
                        .addGap(18, 18, 18)
                        .addComponent(btnAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTipoRol, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAcceso)))
                .addGap(20, 20, 20)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        panelFormularioLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtNombre, txtPorcentaje});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validaciones
        if (txtNombre.getText().trim().length() == 0 || txtNombre.getText().length() > 25) {
            Comunes.mensaje("Debes ingresar el nombre del departamento y no debe ser mayor de 25 caracteres", "warning");
            txtNombre.requestFocus();
            return;
        }
        if (txtTipoRol.getText().length() == 0 ) {
            Comunes.mensaje("Debes introdcir un tipo de acceso", "warning");
            txtNombre.requestFocus();
            return;
        }        
        //Comprobacion que el porcentaje es numerico, no este vacio, no sea más de porcentaje max
        //Comprobar que no esté vacío
        try {
            if (txtPorcentaje.getText().trim().length() == 0) {
                Comunes.mensaje("Debes introducir un porcentaje", "warning");
                txtPorcentaje.requestFocus();
                return;
            }
            //Comprobar que el porcentaje es numérico
            String porcentajeString = txtPorcentaje.getText().trim();
            boolean esNumerico = Comunes.esNumerico(porcentajeString);
            if (!esNumerico) {
                Comunes.mensaje("Debes introducir un porcentaje numerico", "warning");
                txtPorcentaje.requestFocus();
                return;
            }
            if (txtPorcentaje.getText().trim().length() > 4 || Float.valueOf(txtPorcentaje.getText().trim()) > Comunes.PORCENTAJE_MAXIMO) {
                Comunes.mensaje("Debes introducir un porcentaje correcto\nMáximo pocentaje: " + Comunes.PORCENTAJE_MAXIMO, "warning");
                txtPorcentaje.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Comunes.mensaje("Debes introducir un porcentaje correcto. Formato: XX.XX ", "warning");
            txtPorcentaje.requestFocus();
            return;
        }
        String nombreDepartamento = txtNombre.getText().trim();       
        int idRol = Integer.parseInt(txtIdRol.getText());
        float porcentaje = Float.parseFloat(txtPorcentaje.getText().trim());
        
        departamento = new Departamento(nombreDepartamento, idRol, porcentaje);
        String resultado = DEPARTAMENTO_CONTROL.nuevoDepartamento(departamento);
        
        if (resultado.equals("OK")) { 
            dispose();//cierra la ventana
            Comunes.mensaje("Departamento registrado correctamente", "ok");
        } else if (resultado.equals("El departamento ya existe")) {
            Comunes.mensaje("Ya hay un departamento con ese nombre", "error");
        } else {
            Comunes.mensaje(resultado, "error");
        }
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccesoActionPerformed
        FrmSelecRol frm = new FrmSelecRol(contenedor, this,null, true);
        frm.toFront();        
    }//GEN-LAST:event_btnAccesoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceso;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelFormulario;
    public javax.swing.JTextField txtIdJefeDepartamento;
    public javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPorcentaje;
    public javax.swing.JTextField txtTipoRol;
    // End of variables declaration//GEN-END:variables
}
