package presentacion;

import javax.swing.table.TableRowSorter;
import negocio.InmuebleControl;
import presentacion.utiles.Comunes;

public class FrmSelecInmueble extends javax.swing.JDialog {

    private final InmuebleControl INMUEBLE_CONTROL;
    private FrmNuevaVenta nuevaVenta;
    private FrmListadoVentas listadoVentas;

    public FrmSelecInmueble(java.awt.Frame parent, FrmNuevaVenta frm, FrmListadoVentas frm2, boolean modal) {
        super(parent, modal);        
        INMUEBLE_CONTROL = new InmuebleControl();
        initComponents();
        this.setLocationRelativeTo(null);
        this.nuevaVenta = frm;
        this.listadoVentas = frm2;
        this.setTitle("Seleccione Inmueble");
        this.listar("", "Disponible");
        this.setVisible(true);
    }

    private void listar(String texto, String disponibilidad) {
        tablaInmuebles.setModel(INMUEBLE_CONTROL.listar(texto, disponibilidad));
        TableRowSorter ordenable = new TableRowSorter(tablaInmuebles.getModel());
        tablaInmuebles.setRowSorter(ordenable);
        int[] columnasOcultas = {0,9,11,12,15,16,17};
        Comunes.ocultarColumnas(tablaInmuebles, columnasOcultas);
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInmuebles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Búsqueda por dirección:");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO INMUEBLES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tablaInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInmuebles.setRowHeight(20);
        jScrollPane1.setViewportView(tablaInmuebles);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap())
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
        this.listar(txtBuscar.getText(), "Disponible");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (this.nuevaVenta != null) {
            if (tablaInmuebles.getSelectedRowCount() == 1) {
                String idInmueble = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 0));
                String tipoInmueble = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 1));
                String direccion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 2));
                String tipoOperacion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 6));
                String honorarios = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 8));    
                String idCaptador = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 9));
                String nombreCaptador = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 10));
                String idProp = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 11)); 
                String nombrePropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 13)); 
                String apellidosPropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 14)); 
                String tipoDocumentacion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 17));
                String numeroDocPropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 12));

                this.nuevaVenta.txtIdInmueble.setText(idInmueble);
                this.nuevaVenta.txtIdCaptador.setText(idCaptador);
                this.nuevaVenta.txtCaptador.setText(nombreCaptador);
                this.nuevaVenta.txtIdPropietario.setText(idProp);
                this.nuevaVenta.txtHonorarios.setText(honorarios);
                this.nuevaVenta.txtNombrePropietario.setText(nombrePropietario);
                this.nuevaVenta.txtApellidosPropietario.setText(apellidosPropietario);
                this.nuevaVenta.txtTipoDocumentacionPropietario.setText(tipoDocumentacion);
                this.nuevaVenta.txtNumeroDocumentoPropietario.setText(numeroDocPropietario);
                this.nuevaVenta.txtTipoOperacion.setText(tipoOperacion);
                this.nuevaVenta.txtTipoInmueble.setText(tipoInmueble);
                this.nuevaVenta.txtDireccion.setText(direccion);

                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un cliente", "error");
            }
        } else if (this.listadoVentas != null) {
            if (tablaInmuebles.getSelectedRowCount() == 1) {
                String idInmueble = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 0));
                String tipoInmueble = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 1));
                String direccion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 2));
                String tipoOperacion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 6));
                String idCaptador = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 9));                
                String nombreCaptador = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 10));
                String idProp = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 11));                
                String nombrePropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 13)); 
                String apellidosPropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 14)); 
                String tipoDocumentacion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 17));
                String numeroDocPropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 12));

                this.listadoVentas.txtIdInmueble.setText(idInmueble);
                this.listadoVentas.txtIdCaptador.setText(idCaptador);
                this.listadoVentas.txtCaptador.setText(nombreCaptador);
                this.listadoVentas.txtIdPropietario.setText(idProp);
                this.listadoVentas.txtNombrePropietario.setText(nombrePropietario);
                this.listadoVentas.txtApellidosPropietario.setText(apellidosPropietario);
                this.listadoVentas.txtTipoDocumentacionPropietario.setText(tipoDocumentacion);
                this.listadoVentas.txtNumeroDocumentoPropietario.setText(numeroDocPropietario);
                this.listadoVentas.txtTipoOperacion.setText(tipoOperacion);
                this.listadoVentas.txtTipoInmueble.setText(tipoInmueble);
                this.listadoVentas.txtDireccion.setText(direccion);

                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un cliente", "error");
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
    private javax.swing.JTable tablaInmuebles;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
