package presentacion;

import javax.swing.table.TableRowSorter;
import negocio.EmpleadoControl;
import presentacion.utiles.Comunes;

public class FrmSelecEmpleado extends javax.swing.JDialog {

    private final EmpleadoControl EMPLEADO_CONTROL;
    private FrmNuevoCliente nuevoCliente;
    private FrmListadoClientes listadoClientes;
    private FrmNuevaVenta nuevaVenta;
    private FrmListadoVentas listadoVentas;
    private FrmListadoLlamadas listadoLlamadas;
    private FrmNuevoEmpleado nuevoEmpleado;
    private FrmListadoEmpleados listadoEmpleados;

    public FrmSelecEmpleado(java.awt.Frame parent, FrmNuevoCliente frm, FrmListadoClientes frm2,
            FrmNuevaVenta frm3, FrmListadoVentas frm4, FrmListadoLlamadas frm5,
            FrmNuevoEmpleado frm6, FrmListadoEmpleados frm7, boolean modal) {
        super(parent, modal);
        EMPLEADO_CONTROL = new EmpleadoControl();
        initComponents();
        this.setLocationRelativeTo(null);
        this.nuevoCliente = frm;
        this.listadoClientes = frm2;
        this.nuevaVenta = frm3;
        this.listadoVentas = frm4;
        this.listadoLlamadas = frm5;
        this.nuevoEmpleado = frm6;
        this.listadoEmpleados = frm7;
        this.setTitle("Seleccione un usuario");
        if (this.nuevoCliente != null || this.listadoClientes != null) {
            this.listar("Captación", "Ventas");
        } else if (this.nuevaVenta != null) {
            this.listar("Secretaría");
        } else if (this.listadoVentas != null) {
            this.listar("Secretaría");
        } else if (this.listadoLlamadas != null) {
            this.listar("Ventas");
        } else {
            this.listar("");
        }
        this.setVisible(true);
    }

    private void listar(String texto) {
        tablaEmpleados.setModel(EMPLEADO_CONTROL.listar(texto));
        TableRowSorter ordenable = new TableRowSorter(tablaEmpleados.getModel());
        tablaEmpleados.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 6, 8, 9};
        Comunes.ocultarColumnas(tablaEmpleados, columnasOcultas);
    }

    private void listar(String dep1, String dep2) {
        tablaEmpleados.setModel(EMPLEADO_CONTROL.listar(dep1, dep2));
        TableRowSorter ordenable = new TableRowSorter(tablaEmpleados.getModel());
        tablaEmpleados.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 6, 8, 9};
        Comunes.ocultarColumnas(tablaEmpleados, columnasOcultas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE EMPLEADOS\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaEmpleados.setRowHeight(20);
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Búsqueda:");

        txtNombreBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombreBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/seleccionar.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeleccionar.setBorderPainted(false);
        btnSeleccionar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnSeleccionar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnSeleccionar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtNombreBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (nuevoCliente != null) {
            if (tablaEmpleados.getSelectedRowCount() == 1) {
                String idComercial = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
                String nombreComercial = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
                String apellidosComercial = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
                this.nuevoCliente.txtIdComercialCliente.setText(idComercial);
                this.nuevoCliente.txtComercial.setText(nombreComercial + " " + apellidosComercial);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un comercial", "error");
            }
        } else if (listadoClientes != null) {
            if (tablaEmpleados.getSelectedRowCount() == 1) {
                String idCaptador = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
                String nombreCaptador = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
                String apellidosCaptador = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
                this.listadoClientes.txtIdCaptador.setText(idCaptador);
                this.listadoClientes.txtCaptador.setText(nombreCaptador + " " + apellidosCaptador);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un captador", "error");
            }
        } else if (nuevaVenta != null) {
            if (tablaEmpleados.getSelectedRowCount() == 1) {
                String idUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
                String nombreUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
                String apellidosUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
                this.nuevaVenta.txtIdSecretaria.setText(idUsuario);
                this.nuevaVenta.txtSecretaria.setText(nombreUsuario + " " + apellidosUsuario);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar una secretaria", "error");
            }
        } else if (listadoVentas != null) {
            if (tablaEmpleados.getSelectedRowCount() == 1) {
                String idUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
                String nombreUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
                String apellidosUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
                this.nuevaVenta.txtIdSecretaria.setText(idUsuario);
                this.nuevaVenta.txtSecretaria.setText(nombreUsuario + " " + apellidosUsuario);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar una secretaria", "error");
            }
        } else if (listadoLlamadas != null) {
            if (tablaEmpleados.getSelectedRowCount() == 1) {
                String idUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
                String nombreUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
                String apellidosUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
                this.listadoLlamadas.txtIdVendedor.setText(idUsuario);
                this.listadoLlamadas.txtVendedor.setText(nombreUsuario + " " + apellidosUsuario);
                this.listadoLlamadas.txtIdVendedorMo.setText(idUsuario);
                this.listadoLlamadas.txtVendedorMo.setText(nombreUsuario + " " + apellidosUsuario);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un vendedor", "error");
            }
        } else if (nuevoEmpleado != null) {
            if (tablaEmpleados.getSelectedRowCount() == 1) {
                String idJefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
                String nombreJefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
                String apellidosJefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
                this.nuevoEmpleado.txtIdJefe.setText(idJefe);
                this.nuevoEmpleado.txtJefe.setText(nombreJefe + " " + apellidosJefe);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un jefe", "error");
            }
        } else if (listadoEmpleados != null) {
            if (tablaEmpleados.getSelectedRowCount() == 1) {
                String idJefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
                String nombreJefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
                String apellidosJefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
                this.listadoEmpleados.txtIdJefe.setText(idJefe);
                this.listadoEmpleados.txtJefe.setText(nombreJefe + " " + apellidosJefe);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un jefe", "error");
            }
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtNombreBuscar;
    // End of variables declaration//GEN-END:variables
}
