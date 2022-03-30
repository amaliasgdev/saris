package presentacion;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import negocio.EmpleadoControl;

public class FrmEscritorio extends javax.swing.JFrame {

    public FrmEscritorio() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.tipoAcceso();
    }

    public void centrarVentanas(JInternalFrame frm) {
        int ancho = (jdpEscritorio.getWidth() / 2) - frm.getWidth() / 2;
        int alto = (jdpEscritorio.getHeight() / 2) - frm.getHeight() / 2;
        if (frm.isShowing()) {
            frm.setLocation(ancho, alto);
        } else {
            jdpEscritorio.add(frm);
            frm.setLocation(ancho, alto);
            frm.show();
        }
    }

    //Tipo de rol de usuario
    private void tipoAcceso() {
        switch (EmpleadoControl.tipoAcceso) {
            case 1:
                //rol Director
                menuDepartamentos.setEnabled(true);
                menuEmpleados.setEnabled(true);
                menuLlamadas.setEnabled(true);
                menuClientes.setEnabled(true);
                menuInmuebles.setEnabled(true);
                menuVentas.setEnabled(true);
                menuComisiones.setEnabled(true);
                jMenuItemPassword.setVisible(false);
                break;
            case 2:
                //rol Secretarias
                menuDepartamentos.setEnabled(false);
                menuEmpleados.setEnabled(true);
                menuLlamadas.setEnabled(false);
                menuClientes.setEnabled(true);
                menuInmuebles.setEnabled(true);
                menuVentas.setEnabled(true);
                menuComisiones.setEnabled(false); 
                jMenuItemNuevoEmpleado.setEnabled(false); 
                jMenuItemNuevoInmueble.setEnabled(false); 
                break;
            case 3:
                //rol Contabilidad
                menuDepartamentos.setEnabled(true);
                menuEmpleados.setEnabled(true);
                menuLlamadas.setEnabled(false);
                menuClientes.setEnabled(false);
                menuInmuebles.setEnabled(false);
                menuVentas.setEnabled(false);
                menuComisiones.setEnabled(true);
                jMenuItemPassword.setVisible(false);
                break;
            case 4:
                //rol Centralita  
                menuDepartamentos.setEnabled(false);
                menuEmpleados.setEnabled(true);
                menuLlamadas.setEnabled(true);
                menuClientes.setEnabled(false);
                menuInmuebles.setEnabled(false);
                menuVentas.setEnabled(false);
                menuComisiones.setEnabled(false); 
                jMenuItemNuevoEmpleado.setEnabled(false);         
                break;
            case 5:
                //rol Comerciales
                menuDepartamentos.setEnabled(false);
                menuEmpleados.setEnabled(true);
                menuLlamadas.setEnabled(false);
                menuClientes.setEnabled(true);
                menuInmuebles.setEnabled(true);
                menuVentas.setEnabled(false);
                menuComisiones.setEnabled(false);
                jMenuItemNuevoEmpleado.setEnabled(false);                
                break;
            case 6:
                //rol SuperUsuario
                menuDepartamentos.setEnabled(true);
                menuEmpleados.setEnabled(true);
                menuLlamadas.setEnabled(true);
                menuClientes.setEnabled(true);
                menuInmuebles.setEnabled(true);
                menuVentas.setEnabled(true);
                menuComisiones.setEnabled(true);                
                break;
            default:
                //no se logea
                menuDepartamentos.setEnabled(false);
                menuEmpleados.setEnabled(false);
                menuLlamadas.setEnabled(false);
                menuClientes.setEnabled(false);
                menuInmuebles.setEnabled(false);
                menuVentas.setEnabled(false);
                menuComisiones.setEnabled(false);
                jMenuItemPassword.setVisible(false);
                JOptionPane.showMessageDialog(this, "Debe logearse para acceder a la aplicación", null, JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/iconos/warning.png"));
                break;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Image imagen = new ImageIcon(getClass().getResource("/presentacion/iconos/fondoSaris.png")).getImage();
        jdpEscritorio = new javax.swing.JDesktopPane(){
            /*@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(46,106,141));
                g.fillRect(0, 0, getWidth(), getHeight());
            }*/
            public void paintChildren(Graphics g){
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                super.paintChildren(g);
            }

        };
        menuBar = new javax.swing.JMenuBar();
        menuDepartamentos = new javax.swing.JMenu();
        jMenuItemNuevoDep = new javax.swing.JMenuItem();
        jMenuItemListadoDepartamentos = new javax.swing.JMenuItem();
        jMenuItemTipoAcceso = new javax.swing.JMenuItem();
        jMenuItemPassword = new javax.swing.JMenuItem();
        menuEmpleados = new javax.swing.JMenu();
        jMenuItemNuevoEmpleado = new javax.swing.JMenuItem();
        jMenuItemListadoEmpleados = new javax.swing.JMenuItem();
        menuLlamadas = new javax.swing.JMenu();
        jMenuItemListadoLlamadas = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        jMenuItemNuevoCliente = new javax.swing.JMenuItem();
        jMenuItemListadoClientes = new javax.swing.JMenuItem();
        menuInmuebles = new javax.swing.JMenu();
        jMenuItemNuevoInmueble = new javax.swing.JMenuItem();
        jMenuItemListadoInmDis = new javax.swing.JMenuItem();
        jMenuItemInmRet = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        jMenuItemNuevaVenta = new javax.swing.JMenuItem();
        jMenuItemListadoVentas = new javax.swing.JMenuItem();
        menuComisiones = new javax.swing.JMenu();
        jMenuItemListadoComisiones = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        menuDepartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/departamento.png"))); // NOI18N
        menuDepartamentos.setText("Departamentos");
        menuDepartamentos.setIconTextGap(10);

        jMenuItemNuevoDep.setText("Nuevo Departamento");
        jMenuItemNuevoDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoDepActionPerformed(evt);
            }
        });
        menuDepartamentos.add(jMenuItemNuevoDep);

        jMenuItemListadoDepartamentos.setText("Listado de Departamentos");
        jMenuItemListadoDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoDepartamentosActionPerformed(evt);
            }
        });
        menuDepartamentos.add(jMenuItemListadoDepartamentos);

        jMenuItemTipoAcceso.setText("Tipos de Acceso");
        jMenuItemTipoAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipoAccesoActionPerformed(evt);
            }
        });
        menuDepartamentos.add(jMenuItemTipoAcceso);

        jMenuItemPassword.setText("Cambiar contraseñas");
        jMenuItemPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPasswordActionPerformed(evt);
            }
        });
        menuDepartamentos.add(jMenuItemPassword);

        menuBar.add(menuDepartamentos);

        menuEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/usuario.png"))); // NOI18N
        menuEmpleados.setText("Empleados");
        menuEmpleados.setIconTextGap(10);

        jMenuItemNuevoEmpleado.setText("Nuevo Empleado");
        jMenuItemNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleados.add(jMenuItemNuevoEmpleado);

        jMenuItemListadoEmpleados.setText("Listado de Empleados");
        jMenuItemListadoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoEmpleadosActionPerformed(evt);
            }
        });
        menuEmpleados.add(jMenuItemListadoEmpleados);

        menuBar.add(menuEmpleados);

        menuLlamadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/llamadas.png"))); // NOI18N
        menuLlamadas.setText("Llamadas");
        menuLlamadas.setIconTextGap(10);

        jMenuItemListadoLlamadas.setText("Listado de Llamadas");
        jMenuItemListadoLlamadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoLlamadasActionPerformed(evt);
            }
        });
        menuLlamadas.add(jMenuItemListadoLlamadas);

        menuBar.add(menuLlamadas);

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/cliente.png"))); // NOI18N
        menuClientes.setText("Clientes");
        menuClientes.setIconTextGap(10);

        jMenuItemNuevoCliente.setText("Nuevo Cliente");
        jMenuItemNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoClienteActionPerformed(evt);
            }
        });
        menuClientes.add(jMenuItemNuevoCliente);

        jMenuItemListadoClientes.setText("Listado de Clientes");
        jMenuItemListadoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoClientesActionPerformed(evt);
            }
        });
        menuClientes.add(jMenuItemListadoClientes);

        menuBar.add(menuClientes);

        menuInmuebles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/inmuebles.png"))); // NOI18N
        menuInmuebles.setText("Inmuebles");
        menuInmuebles.setIconTextGap(10);

        jMenuItemNuevoInmueble.setText("Nuevo Inmueble");
        jMenuItemNuevoInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoInmuebleActionPerformed(evt);
            }
        });
        menuInmuebles.add(jMenuItemNuevoInmueble);

        jMenuItemListadoInmDis.setText("Listado Inmuebles Disponibles");
        jMenuItemListadoInmDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoInmDisActionPerformed(evt);
            }
        });
        menuInmuebles.add(jMenuItemListadoInmDis);

        jMenuItemInmRet.setText("Listado Inmuebles Retirados");
        jMenuItemInmRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInmRetActionPerformed(evt);
            }
        });
        menuInmuebles.add(jMenuItemInmRet);

        menuBar.add(menuInmuebles);

        menuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/ventas.png"))); // NOI18N
        menuVentas.setText("Ventas");
        menuVentas.setIconTextGap(10);

        jMenuItemNuevaVenta.setText("Nueva Venta");
        jMenuItemNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevaVentaActionPerformed(evt);
            }
        });
        menuVentas.add(jMenuItemNuevaVenta);

        jMenuItemListadoVentas.setText("Listado Ventas");
        jMenuItemListadoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoVentasActionPerformed(evt);
            }
        });
        menuVentas.add(jMenuItemListadoVentas);

        menuBar.add(menuVentas);

        menuComisiones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/comisiones.png"))); // NOI18N
        menuComisiones.setText("Comisiones");
        menuComisiones.setIconTextGap(10);

        jMenuItemListadoComisiones.setText("Listado Comisiones");
        jMenuItemListadoComisiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoComisionesActionPerformed(evt);
            }
        });
        menuComisiones.add(jMenuItemListadoComisiones);

        menuBar.add(menuComisiones);

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.setIconTextGap(10);
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalirMouseClicked(evt);
            }
        });
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemListadoDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoDepartamentosActionPerformed
        FrmListadoDptos frm = new FrmListadoDptos();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemListadoDepartamentosActionPerformed

    private void menuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_menuSalirMouseClicked

    private void jMenuItemListadoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoEmpleadosActionPerformed
        FrmListadoEmpleados frm = new FrmListadoEmpleados();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemListadoEmpleadosActionPerformed

    private void jMenuItemNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoEmpleadoActionPerformed
        FrmNuevoEmpleado frm = new FrmNuevoEmpleado();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemNuevoEmpleadoActionPerformed

    private void jMenuItemNuevoDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoDepActionPerformed
        FrmNuevoDpto frm = new FrmNuevoDpto();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemNuevoDepActionPerformed

    private void jMenuItemNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoClienteActionPerformed
        FrmNuevoCliente frm = new FrmNuevoCliente();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemNuevoClienteActionPerformed

    private void jMenuItemListadoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoClientesActionPerformed
        FrmListadoClientes frm = new FrmListadoClientes();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemListadoClientesActionPerformed

    private void jMenuItemListadoInmDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoInmDisActionPerformed
        FrmListadoInmDisp frm = new FrmListadoInmDisp();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemListadoInmDisActionPerformed

    private void jMenuItemNuevoInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoInmuebleActionPerformed
        FrmNuevoInmueble frm = new FrmNuevoInmueble();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemNuevoInmuebleActionPerformed

    private void jMenuItemNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevaVentaActionPerformed
        FrmNuevaVenta frm = new FrmNuevaVenta();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemNuevaVentaActionPerformed

    private void jMenuItemListadoComisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoComisionesActionPerformed
        FrmListadoComisiones frm = new FrmListadoComisiones();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemListadoComisionesActionPerformed

    private void jMenuItemListadoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoVentasActionPerformed
        FrmListadoVentas frm = new FrmListadoVentas();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemListadoVentasActionPerformed

    private void jMenuItemInmRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInmRetActionPerformed
        FrmListadoInmRet frm = new FrmListadoInmRet();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemInmRetActionPerformed

    private void jMenuItemListadoLlamadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoLlamadasActionPerformed
        FrmListadoLlamadas frm = new FrmListadoLlamadas();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemListadoLlamadasActionPerformed

    private void jMenuItemTipoAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipoAccesoActionPerformed
        FrmListadoRol frm = new FrmListadoRol();
        jdpEscritorio.add(frm).setVisible(true);
    }//GEN-LAST:event_jMenuItemTipoAccesoActionPerformed

    private void jMenuItemPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPasswordActionPerformed
        FrmListadoPass frm = new FrmListadoPass();
        this.centrarVentanas(frm);
    }//GEN-LAST:event_jMenuItemPasswordActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmEscritorio().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItemInmRet;
    private javax.swing.JMenuItem jMenuItemListadoClientes;
    private javax.swing.JMenuItem jMenuItemListadoComisiones;
    private javax.swing.JMenuItem jMenuItemListadoDepartamentos;
    private javax.swing.JMenuItem jMenuItemListadoEmpleados;
    private javax.swing.JMenuItem jMenuItemListadoInmDis;
    private javax.swing.JMenuItem jMenuItemListadoLlamadas;
    private javax.swing.JMenuItem jMenuItemListadoVentas;
    private javax.swing.JMenuItem jMenuItemNuevaVenta;
    private javax.swing.JMenuItem jMenuItemNuevoCliente;
    private javax.swing.JMenuItem jMenuItemNuevoDep;
    private javax.swing.JMenuItem jMenuItemNuevoEmpleado;
    private javax.swing.JMenuItem jMenuItemNuevoInmueble;
    private javax.swing.JMenuItem jMenuItemPassword;
    private javax.swing.JMenuItem jMenuItemTipoAcceso;
    private javax.swing.JDesktopPane jdpEscritorio;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuComisiones;
    private javax.swing.JMenu menuDepartamentos;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuInmuebles;
    private javax.swing.JMenu menuLlamadas;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenu menuVentas;
    // End of variables declaration//GEN-END:variables
}
