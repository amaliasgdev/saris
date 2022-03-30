package presentacion;

import entidades.Cliente;
import java.awt.Color;
import javax.swing.JFrame;
import negocio.ClienteControl;
import negocio.TipoClienteControl;
import presentacion.utiles.Comunes;

public class FrmNuevoCliente extends javax.swing.JInternalFrame {

    private final ClienteControl CLIENTE_CONTROL;
    private final TipoClienteControl TIPO_CONTROL;
    private Cliente cliente;
    public JFrame contenedor;

    public FrmNuevoCliente() {
        initComponents();
        CLIENTE_CONTROL = new ClienteControl();
        TIPO_CONTROL = new TipoClienteControl();
        Comunes.llenarComboboxTipos(TIPO_CONTROL.listar(), cboTipoCliente);
        Comunes.llenarComboboxGenerico(Comunes.TIPO_DOCUMENTO, cboTipoDocumento);
        txtNumeroDocumento.setText("Desconocido");
        txtDireccion.setText("Desconocido");        
        txtIdComercialCliente.setVisible(false);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellidos.setText("");
        cboTipoCliente.setSelectedIndex(0);
        cboTipoDocumento.setSelectedIndex(0);
        txtNumeroDocumento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtComercial.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboTipoDocumento = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroDocumento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboTipoCliente = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtComercial = new javax.swing.JTextField();
        btnSeleccionarCaptador = new javax.swing.JButton();
        txtIdComercialCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo Cliente");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Nombre (*):");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Apellidos (*):");

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtApellidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Tipo Documento:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Telefono (*):");

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Email(*):");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Comercial (*):");

        cboTipoDocumento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Nº Documento:");

        txtNumeroDocumento.setBackground(new java.awt.Color(247, 245, 149));
        txtNumeroDocumento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNumeroDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNumeroDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroDocumentoFocusLost(evt);
            }
        });
        txtNumeroDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroDocumentoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Tipo de Cliente (*):");

        cboTipoCliente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Dirección:");

        txtDireccion.setBackground(new java.awt.Color(247, 245, 149));
        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        txtComercial.setBackground(new java.awt.Color(204, 204, 204));
        txtComercial.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtComercial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSeleccionarCaptador.setText("...");
        btnSeleccionarCaptador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCaptadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEmail)
                        .addGap(246, 246, 246))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionarCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdComercialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboTipoDocumento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnSeleccionarCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdComercialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel2.setBackground(new java.awt.Color(46, 106, 141));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBorrar, btnGuardar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBorrar, btnGuardar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().trim().length() == 0 || txtNombre.getText().length() > 25) {
            Comunes.mensaje("Debes ingresar un nombre y no debe ser mayor de 25 caracteres", "warning");
            txtNombre.requestFocus();
            return;
        }
        if (txtApellidos.getText().trim().length() == 0 || txtApellidos.getText().length() > 45) {
            Comunes.mensaje("Debes ingresar los apellidos y no deben ser mayor de 45 caracteres", "warning");
            txtApellidos.requestFocus();
            return;
        }
        if (txtNumeroDocumento.getText().length() > 15) { // Campo no obligatorio
            Comunes.mensaje("El número de documento no debe ser mayor de 15 caracteres", "warning");
            txtNumeroDocumento.requestFocus();
            return;
        }
        if (txtDireccion.getText().length() > 75) { // Campo no obligatorio
            Comunes.mensaje("La dirección no debe ser mayor de 75 caracteres", "warning");
            txtDireccion.requestFocus();
            return;
        }
        if (txtEmail.getText().length() > 30) {// Campo no obligatorio
            Comunes.mensaje("El email no debe ser mayor de 30 caracteres", "warning");
            txtEmail.requestFocus();
            return;
        }

        if (!txtEmail.getText().matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$")) {
            Comunes.mensaje("El email no tiene un formato correcto", "warning");
            txtEmail.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().length() == 0 || txtTelefono.getText().length() > 9) {
            Comunes.mensaje("Debes ingresar un telefono y no debe ser mayor de 9 caracteres", "warning");
            txtTelefono.requestFocus();
            return;
        }
        if (txtComercial.getText().isEmpty()) {
            Comunes.mensaje("Debes ingresar un captador", "warning");
            txtComercial.requestFocus();
            return;
        }
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String tipoDocumento = cboTipoDocumento.getSelectedItem().toString().trim();
        String numeroDocumento = txtNumeroDocumento.getText().trim();
        String tipo = cboTipoCliente.getSelectedItem().toString();
        int tipoPersona = 0;
        if (tipo.equals("Propietario")) {
            tipoPersona = 1;
        } else if (tipo.equals("Comprador")) {
            tipoPersona = 1;
        }
        String direccion = txtDireccion.getText().trim();
        String email = txtEmail.getText().trim();
        String telefono = txtTelefono.getText().trim();
        int idComercial = Integer.parseInt(txtIdComercialCliente.getText());

        cliente = new Cliente(nombre, apellidos, tipoDocumento, numeroDocumento, tipoPersona, direccion, email, telefono, idComercial);

        String respuesta = CLIENTE_CONTROL.nuevoCliente(cliente);

        if (respuesta.equals("OK")) {
            this.limpiar();
            dispose();//cierra la ventana
            Comunes.mensaje("Cliente insertado correctamente", "ok");
        } else {
            Comunes.mensaje(respuesta, "error");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSeleccionarCaptadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCaptadorActionPerformed
        // TODO add your handling code here:
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, this, null, null, null, null, null, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarCaptadorActionPerformed

    private void txtNumeroDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDocumentoKeyTyped
        // TODO add your handling code here:        
        txtNumeroDocumento.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtNumeroDocumentoKeyTyped

    private void txtNumeroDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroDocumentoFocusLost
        // TODO add your handling code here:
        if (txtNumeroDocumento.getText().isEmpty()) {
            txtNumeroDocumento.setBackground(new Color(247, 245, 149));
            txtNumeroDocumento.setText("Desconocido");
        }
    }//GEN-LAST:event_txtNumeroDocumentoFocusLost

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:        
        txtDireccion.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        // TODO add your handling code here:
        if (txtDireccion.getText().isEmpty()) {
            txtDireccion.setBackground(new Color(247, 245, 149));
            txtDireccion.setText("Desconocido");
        }
    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtNumeroDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroDocumentoFocusGained
        // TODO add your handling code here:
        txtNumeroDocumento.setText("");
    }//GEN-LAST:event_txtNumeroDocumentoFocusGained

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        // TODO add your handling code here:
        txtDireccion.setText("");
    }//GEN-LAST:event_txtDireccionFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionarCaptador;
    private javax.swing.JComboBox<String> cboTipoCliente;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtComercial;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtIdComercialCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
