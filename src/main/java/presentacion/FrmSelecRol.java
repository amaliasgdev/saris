package presentacion;

import javax.swing.table.TableRowSorter;
import negocio.RolControl;
import presentacion.utiles.Comunes;

public class FrmSelecRol extends javax.swing.JDialog {

    private final RolControl ROL_CONTROL;
    private FrmNuevoDpto nuevoDepartamento;
    private FrmListadoDptos listadoDepartamento;

    public FrmSelecRol(java.awt.Frame parent, FrmNuevoDpto frm, FrmListadoDptos frm2, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        ROL_CONTROL = new RolControl();
        this.nuevoDepartamento = frm;
        this.listadoDepartamento = frm2;
        this.setTitle("Seleccione tipo de acceso");
        this.listar();
        this.setVisible(true);
    }

    private void listar() {
        tablaAcceso.setModel(ROL_CONTROL.listar());
        TableRowSorter ordenable = new TableRowSorter(tablaAcceso.getModel());
        tablaAcceso.setRowSorter(ordenable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAcceso = new javax.swing.JTable();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaAcceso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaAcceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAcceso.setRowHeight(20);
        jScrollPane1.setViewportView(tablaAcceso);

        btnOk.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 123, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        if (nuevoDepartamento != null) {
            if (tablaAcceso.getSelectedRowCount() == 1) {
                String idRol = String.valueOf(tablaAcceso.getValueAt(tablaAcceso.getSelectedRow(), 0));
                String nombre = String.valueOf(tablaAcceso.getValueAt(tablaAcceso.getSelectedRow(), 1));
                this.nuevoDepartamento.txtIdRol.setText(idRol);
                this.nuevoDepartamento.txtTipoRol.setText(nombre);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un departamento", "error");
            }
        } else if (listadoDepartamento != null) {
            if (tablaAcceso.getSelectedRowCount() == 1) {
                String idRol = String.valueOf(tablaAcceso.getValueAt(tablaAcceso.getSelectedRow(), 0));
                String nombre = String.valueOf(tablaAcceso.getValueAt(tablaAcceso.getSelectedRow(), 1));
                this.listadoDepartamento.txtIdAcceso.setText(idRol);
                this.listadoDepartamento.txtTipoAcceso.setText(nombre);
                this.setVisible(false);
            } else {
                Comunes.mensaje("Debe seleccionar un departamento", "error");
            }
        }

    }//GEN-LAST:event_btnOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAcceso;
    // End of variables declaration//GEN-END:variables
}
