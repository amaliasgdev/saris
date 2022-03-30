package presentacion;

import entidades.Empleado;
import javax.swing.JFrame;
import negocio.EmpleadoControl;
import presentacion.utiles.Comunes;

public class FrmNuevoEmpleado extends javax.swing.JInternalFrame {

    private final EmpleadoControl EMPLEADO_CONTROL;
    private Empleado empleado;
    public JFrame contenedor;

    public FrmNuevoEmpleado() {
        EMPLEADO_CONTROL = new EmpleadoControl();
        initComponents();
        txtIdJefe.setVisible(false);
        txtIdDepartamentoUsuario.setVisible(false);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDepartamento.setText("");
        txtTelefono.setText("");
        txtExtension.setText("");
        txtEmail.setText("");
        txtContrasenia.setText("");
        txtIdDepartamentoUsuario.setText("");
        txtIdJefe.setText("");
        txtJefe.setText("");
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
        txtContrasenia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtExtension = new javax.swing.JTextField();
        btnSeleccionarDepartamento = new javax.swing.JButton();
        txtDepartamento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtJefe = new javax.swing.JTextField();
        btnSeleccionarJefe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        txtIdDepartamentoUsuario = new javax.swing.JTextField();
        txtIdJefe = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo empleado");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Nombre(*):");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Apellidos(*):");

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtApellidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Departamento(*):");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Teléfono(*):");

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Email(*):");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Contraseña(*):");

        txtContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtContrasenia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Extensión(*):");

        txtExtension.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtExtension.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSeleccionarDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarDepartamento.setText("...");
        btnSeleccionarDepartamento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 153), null, null));
        btnSeleccionarDepartamento.setBorderPainted(false);
        btnSeleccionarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarDepartamentoActionPerformed(evt);
            }
        });

        txtDepartamento.setEditable(false);
        txtDepartamento.setBackground(new java.awt.Color(204, 204, 204));
        txtDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("Jefe Departamento:");

        txtJefe.setEditable(false);
        txtJefe.setBackground(new java.awt.Color(204, 204, 204));
        txtJefe.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtJefe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSeleccionarJefe.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarJefe.setText("...");
        btnSeleccionarJefe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 153), null, null));
        btnSeleccionarJefe.setBorderPainted(false);
        btnSeleccionarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarJefeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtExtension, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJefe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleccionarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDepartamento, txtJefe});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSeleccionarDepartamento, btnSeleccionarJefe});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnSeleccionarDepartamento))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionarJefe))
                    .addComponent(jLabel8))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSeleccionarDepartamento, btnSeleccionarJefe, txtApellidos, txtContrasenia, txtDepartamento, txtEmail, txtExtension, txtJefe, txtNombre, txtTelefono});

        jPanel2.setBackground(new java.awt.Color(46, 106, 141));
        jPanel2.setPreferredSize(new java.awt.Dimension(176, 405));

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

        txtIdDepartamentoUsuario.setEditable(false);

        txtIdJefe.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdDepartamentoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdDepartamentoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtIdJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            Comunes.mensaje("Debes ingresar los apellidos y no deben ser mayores de 45 caracteres", "warning");
            txtApellidos.requestFocus();
            return;
        }
        if (txtTelefono.getText().length() != 9) {
            Comunes.mensaje("Debes ingresar teléfono valido de 9 caracteres", "warning");
            txtTelefono.requestFocus();
            return;
        }
        if (txtExtension.getText().trim().length() == 0 || txtExtension.getText().length() > 3) {
            Comunes.mensaje("Debes ingresar una extension y no debe ser mayor de 3 caracteres", "warning");
            txtExtension.requestFocus();
            return;
        }
        if (txtEmail.getText().trim().length() == 0 || txtEmail.getText().length() > 30) {
            Comunes.mensaje("Debes ingresar un email y no debe ser mayor de 30 caracteres", "warning");
            txtEmail.requestFocus();
            return;
        }
        if (!txtEmail.getText().matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$")) {
            Comunes.mensaje("El email no tiene un formato correcto", "warning");
            txtEmail.requestFocus();
            return;
        }
        if (txtContrasenia.getText().trim().length() == 0 || txtContrasenia.getText().length() > 45) {
            Comunes.mensaje("Debes ingresar una contraseña y no debe ser mayor de 45 caracteres", "warning");
            txtContrasenia.requestFocus();
            return;
        }
        if (txtDepartamento.getText().isEmpty()) {
            Comunes.mensaje("Debes ingresar un departamento", "warning");
            txtIdDepartamentoUsuario.requestFocus();
            return;
        }
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        int idDepartamento = Integer.parseInt(txtIdDepartamentoUsuario.getText());
        String telefono = txtTelefono.getText().trim();
        String extension = txtExtension.getText().trim();
        String email = txtEmail.getText().trim();
        String contrasenia = txtContrasenia.getText().trim();
        int jefeId = Integer.parseInt(txtIdJefe.getText());

        empleado = new Empleado(nombre, apellidos, telefono, extension, email, contrasenia, jefeId, idDepartamento);
        String respuesta;
        if (txtJefe.getText().isEmpty()) {
            respuesta = EMPLEADO_CONTROL.nuevoEmpleado(empleado);
        } else {
            respuesta = EMPLEADO_CONTROL.nuevoEmpleadoJefe(empleado);
        }
        if (respuesta.equals("OK")) {
            Comunes.mensaje("Empleado insertado correctamente", "ok");
            limpiar();
        } else {
            Comunes.mensaje(respuesta, "error");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSeleccionarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarDepartamentoActionPerformed
        FrmSelecDpto frm = new FrmSelecDpto(contenedor, this, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarDepartamentoActionPerformed

    private void btnSeleccionarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarJefeActionPerformed
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, null, null, null, null, null, this, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarJefeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionarDepartamento;
    private javax.swing.JButton btnSeleccionarJefe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtContrasenia;
    public javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtExtension;
    public javax.swing.JTextField txtIdDepartamentoUsuario;
    public javax.swing.JTextField txtIdJefe;
    public javax.swing.JTextField txtJefe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
