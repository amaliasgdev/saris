package presentacion;

import entidades.Empleado;
import javax.swing.table.TableRowSorter;
import negocio.EmpleadoControl;
import presentacion.utiles.Comunes;

public class FrmListadoPass extends javax.swing.JInternalFrame {

    private final EmpleadoControl EMPLEADO_CONTROL;
    private Empleado empleado;

    public FrmListadoPass() {
        initComponents();
        EMPLEADO_CONTROL = new EmpleadoControl();
        txtId.setVisible(false);
        this.listar("");
    }

    private void listar(String texto) {
        tablaUsuarios.setModel(EMPLEADO_CONTROL.listarPass(texto));
        TableRowSorter ordenable = new TableRowSorter(tablaUsuarios.getModel());
        tablaUsuarios.setRowSorter(ordenable);
        int[] colum = {0};
        Comunes.ocultarColumnas(tablaUsuarios, colum);
    }

    private void limpiar() {
        txtId.setText("");
        txtNombreDepartamento.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
        txtPass.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPassword = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        panelFondo2 = new javax.swing.JPanel();
        panelBotonesM = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        panelFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNombreDepartamento = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modificar Password");
        setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        tabPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones.setPreferredSize(new java.awt.Dimension(176, 402));

        txtBusqueda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setBorderPainted(false);
        btnModificar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnModificar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnModificar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setBorderPainted(false);
        btnBuscar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnBuscar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnBuscar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBusqueda.setText("Búsqueda:");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelBotonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscar, btnModificar});

        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotonesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscar, btnModificar});

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE EMPLEADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTabla.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {} ){

        }
    );
    tablaUsuarios.setRowHeight(20);
    jScrollPane2.setViewportView(tablaUsuarios);

    javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
    panelTabla.setLayout(panelTablaLayout);
    panelTablaLayout.setHorizontalGroup(
        panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelTablaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
            .addContainerGap())
    );
    panelTablaLayout.setVerticalGroup(
        panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelTablaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(26, Short.MAX_VALUE))
    );

    tabPassword.addTab("Listado", jPanel2);

    panelBotonesM.setBackground(new java.awt.Color(46, 106, 141));
    panelBotonesM.setPreferredSize(new java.awt.Dimension(176, 402));

    btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/guardar.png"))); // NOI18N
    btnActualizar.setText("Guardar Cambios");
    btnActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    btnActualizar.setBorderPainted(false);
    btnActualizar.setMaximumSize(new java.awt.Dimension(155, 41));
    btnActualizar.setMinimumSize(new java.awt.Dimension(155, 41));
    btnActualizar.setPreferredSize(new java.awt.Dimension(155, 41));
    btnActualizar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnActualizarActionPerformed(evt);
        }
    });

    btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/volver.png"))); // NOI18N
    btnAtras.setText("Volver al Listado");
    btnAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    btnAtras.setBorderPainted(false);
    btnAtras.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAtrasActionPerformed(evt);
        }
    });

    txtId.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtId.setEnabled(false);

    javax.swing.GroupLayout panelBotonesMLayout = new javax.swing.GroupLayout(panelBotonesM);
    panelBotonesM.setLayout(panelBotonesMLayout);
    panelBotonesMLayout.setHorizontalGroup(
        panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBotonesMLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBotonesMLayout.createSequentialGroup()
                    .addGroup(panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtras))
                    .addGap(0, 11, Short.MAX_VALUE))
                .addGroup(panelBotonesMLayout.createSequentialGroup()
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );

    panelBotonesMLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnAtras});

    panelBotonesMLayout.setVerticalGroup(
        panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBotonesMLayout.createSequentialGroup()
            .addGap(36, 36, 36)
            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(25, 25, 25)
            .addComponent(btnAtras)
            .addGap(32, 32, 32)
            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    panelBotonesMLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar, btnAtras});

    lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    lblNombre.setText("Nombre:");

    lblAcceso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    lblAcceso.setText("Email: ");

    lblPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    lblPorcentaje.setText("Contraseña:");

    txtNombre.setEditable(false);
    txtNombre.setBackground(new java.awt.Color(204, 204, 204));
    txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    txtNombreDepartamento.setEditable(false);
    txtNombreDepartamento.setBackground(new java.awt.Color(204, 204, 204));
    txtNombreDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtNombreDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    txtPass.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtPass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    jLabel1.setText("Departamento:");

    txtEmail.setEditable(false);
    txtEmail.setBackground(new java.awt.Color(204, 204, 204));
    txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
    panelFormulario.setLayout(panelFormularioLayout);
    panelFormularioLayout.setHorizontalGroup(
        panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelFormularioLayout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPorcentaje)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
            .addContainerGap(38, Short.MAX_VALUE))
    );
    panelFormularioLayout.setVerticalGroup(
        panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(txtNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addGap(20, 20, 20)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombre)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblAcceso)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblPorcentaje)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(55, 55, 55))
    );

    javax.swing.GroupLayout panelFondo2Layout = new javax.swing.GroupLayout(panelFondo2);
    panelFondo2.setLayout(panelFondo2Layout);
    panelFondo2Layout.setHorizontalGroup(
        panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelFondo2Layout.createSequentialGroup()
            .addComponent(panelBotonesM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 182, Short.MAX_VALUE))
    );
    panelFondo2Layout.setVerticalGroup(
        panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelBotonesM, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        .addGroup(panelFondo2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(123, Short.MAX_VALUE))
    );

    tabPassword.addTab("Modificar", panelFondo2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabPassword)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabPassword)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tablaUsuarios.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0));
            String nombreDepartamento = String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1));
            String nombre = String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2));
            String apellidos = String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3));
            String email = String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 4));
            String pass = String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 5));
            txtId.setText(id);
            txtNombreDepartamento.setText(nombreDepartamento);
            txtNombre.setText(nombre + " " + apellidos);
            txtEmail.setText(email);
            txtPass.setText(pass);

            tabPassword.setEnabledAt(0, false);
            tabPassword.setEnabledAt(1, true);
            tabPassword.setSelectedIndex(1);

        } else {
            Comunes.mensaje("Seleccione un usuario", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtBusqueda.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Validaciones   
        if (txtPass.getText().length() == 0 || txtPass.getText().length() > 45) {
            Comunes.mensaje("Debes introducir una contraseña y no debe ser superior a 45 caracteres", "warning");
            txtPass.requestFocus();
            return;
        }
        int idUsuario = Integer.parseInt(txtId.getText());
        String pass = txtPass.getText().trim();
        empleado = new Empleado(idUsuario, pass);
        String resultado = EMPLEADO_CONTROL.modificarPassword(empleado);
        if (resultado.equals("OK")) {
            this.listar("");
            limpiar();
            tabPassword.setEnabledAt(0, true);
            tabPassword.setEnabledAt(1, false);
            tabPassword.setSelectedIndex(0);
            Comunes.mensaje("Contraseña actualizada correctamente", "ok");
        } else {
            Comunes.mensaje(resultado, "error");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        tabPassword.setEnabledAt(0, true);
        tabPassword.setEnabledAt(1, false);
        tabPassword.setSelectedIndex(0);
    }//GEN-LAST:event_btnAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotonesM;
    private javax.swing.JPanel panelFondo2;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTabbedPane tabPassword;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtBusqueda;
    public javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNombreDepartamento;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
