package presentacion;

import javax.swing.table.TableRowSorter;
import negocio.ClienteControl;
import presentacion.utiles.Comunes;

public class FrmSelecCliente extends javax.swing.JDialog {

    private final ClienteControl CLIENTE_CONTROL;
    private final FrmNuevaVenta nuevaVenta;
    private final FrmListadoVentas listadoVentas;
    private FrmNuevoInmueble nuevoInmueble;
    private FrmListadoInmDisp listadoInmueble;

    public FrmSelecCliente(java.awt.Frame parent, FrmNuevaVenta frm, FrmListadoVentas frm2,
            FrmNuevoInmueble frm3, FrmListadoInmDisp frm4, boolean modal) {
        super(parent, modal);
        initComponents();
        CLIENTE_CONTROL = new ClienteControl();
        this.setLocationRelativeTo(null);
        this.nuevaVenta = frm;
        this.listadoVentas = frm2;
        this.nuevoInmueble = frm3;
        this.listadoInmueble = frm4;
        if (this.nuevoInmueble != null || this.listadoInmueble != null) {
            this.listar("Propietario");
            this.setTitle("Seleccione Propietario");
        }
        if (this.nuevaVenta != null || this.listadoVentas != null) {
            this.listar("Comprador");
            this.setTitle("Seleccione Comprador");
        }
        this.setVisible(true);
    }

    private void listar(String texto) {
        tablaPersonas.setModel(CLIENTE_CONTROL.listar(texto));
        TableRowSorter ordenable = new TableRowSorter(tablaPersonas.getModel());
        tablaPersonas.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 9};
        Comunes.ocultarColumnas(tablaPersonas, columnasOcultas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(131, 131, 131))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE CLIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaPersonas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPersonas.setRowHeight(20);
        jScrollPane1.setViewportView(tablaPersonas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        this.listar(txtNombreBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        if (nuevaVenta != null) {
            if (tablaPersonas.getSelectedRowCount() == 1) {
                String id = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 0));
                String nombre = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 1));
                String apellidos = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 2));
                String tipoDocumento = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 3));
                String dni = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 4));
                String idVendedor = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 9));
                String nombreVendedor = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 10));
                this.nuevaVenta.txtNombreComprador.setText(nombre);
                this.nuevaVenta.txtApellidosComprador.setText(apellidos);
                this.nuevaVenta.txtTipoDocumentacionComprador.setText(tipoDocumento);
                this.nuevaVenta.txtNumeroDocumentoComprador.setText(dni);
                this.nuevaVenta.txtIdComprador.setText(id);
                this.nuevaVenta.txtIdVendedor.setText(idVendedor);
                this.nuevaVenta.txtVendedor.setText(nombreVendedor);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un cliente", "error");
            }
        } else if (listadoVentas != null) {
            if (tablaPersonas.getSelectedRowCount() == 1) {
                String id = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 0));
                String nombre = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 1));
                String apellidos = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 2));
                String tipoDocumento = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 3));
                String dni = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 4));
                this.listadoVentas.txtNombreComprador.setText(nombre);
                this.listadoVentas.txtApellidosComprador.setText(apellidos);
                this.listadoVentas.txtTipoDocumentacionComprador.setText(tipoDocumento);
                this.listadoVentas.txtNumeroDocumentoComprador.setText(dni);
                this.listadoVentas.txtIdComprador.setText(id);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un cliente", "error");
            }
        } else if (nuevoInmueble != null) {
            if (tablaPersonas.getSelectedRowCount() == 1) {
                String id = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 0));
                String nombre = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 1));
                String apellidos = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 2));
                String dni = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 4));
                String idCaptador = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 9));
                String captador = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 10));
                String nombreCompleto = nombre + " " + apellidos;
                this.nuevoInmueble.txtNombrePropietario.setText(nombreCompleto);
                this.nuevoInmueble.txtDniPropietario.setText(dni);
                this.nuevoInmueble.txtIdPropietario.setText(id);
                this.nuevoInmueble.txtCaptador.setText(captador);
                this.nuevoInmueble.txtIdCaptador.setText(idCaptador);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un cliente", "error");
            }
        } else if (listadoInmueble != null) {
            if (tablaPersonas.getSelectedRowCount() == 1) {
                String id = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 0));
                String nombre = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 1));
                String apellidos = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 2));
                String dni = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 4));
                String idCaptador = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 9));
                String captador = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 10));
                String nombreCompleto = nombre + " " + apellidos;
                this.listadoInmueble.txtNombrePropietario.setText(nombreCompleto);
                this.listadoInmueble.txtDniPropietario.setText(dni);
                this.listadoInmueble.txtIdPropietario.setText(id);
                this.listadoInmueble.txtCaptador.setText(captador);
                this.listadoInmueble.txtIdCaptador.setText(idCaptador);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un cliente", "error");
            }
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPersonas;
    private javax.swing.JTextField txtNombreBuscar;
    // End of variables declaration//GEN-END:variables
}
