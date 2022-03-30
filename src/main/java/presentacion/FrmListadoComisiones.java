package presentacion;

import javax.swing.table.TableRowSorter;
import negocio.EmpleadoControl;
import negocio.VentaControl;
import java.sql.Date;
import presentacion.utiles.Comunes;

public class FrmListadoComisiones extends javax.swing.JInternalFrame {

    private final VentaControl VENTA_CONTROL;
    private final EmpleadoControl EMPLEADO_CONTROL;

    public FrmListadoComisiones() {
        initComponents();
        VENTA_CONTROL = new VentaControl();
        EMPLEADO_CONTROL = new EmpleadoControl();
        this.setTitle("Comisiones");
        this.listarUsuarios();
        Comunes.llenarComboboxGenerico(Comunes.MES, cboMes);
        Comunes.llenarComboboxGenerico(Comunes.AÑO, cboAño);
        this.mostarTotalProduccion(false);
        this.mostarTotalesUsuarios(false);
        int[] columnasOcultas = {0};
        Comunes.ocultarColumnas(tablaCaptacion, columnasOcultas);
        Comunes.ocultarColumnas(tablaVentas, columnasOcultas);
        Comunes.ocultarColumnas(tablaSecretaria, columnasOcultas);
    }

    private void listarUsuarios() {
        tablaCaptacion.setModel(EMPLEADO_CONTROL.listarNombres("captacion"));
        TableRowSorter ordenable = new TableRowSorter(tablaCaptacion.getModel());
        tablaCaptacion.setRowSorter(ordenable);

        tablaVentas.setModel(EMPLEADO_CONTROL.listarNombres("ventas"));
        TableRowSorter ordenable2 = new TableRowSorter(tablaVentas.getModel());
        tablaVentas.setRowSorter(ordenable2);

        tablaSecretaria.setModel(EMPLEADO_CONTROL.listarNombres("secretaria"));
        TableRowSorter ordenable3 = new TableRowSorter(tablaSecretaria.getModel());
        tablaSecretaria.setRowSorter(ordenable3);
    }

    private void listarProduccion(java.sql.Date inicio, java.sql.Date fin) {
        tablaComisionesVentas.setModel(VENTA_CONTROL.listarComisionesProduccion(inicio, fin));
        TableRowSorter ordenable = new TableRowSorter(tablaComisionesVentas.getModel());
        tablaComisionesVentas.setRowSorter(ordenable);
    }

    private void listarProduccionUsuario(java.sql.Date inicio, java.sql.Date fin, int idVendedor) {
        tablaComisionesVentas.setModel(VENTA_CONTROL.listarComisionesUsuario(inicio, fin, idVendedor));
        TableRowSorter ordenable = new TableRowSorter(tablaComisionesVentas.getModel());
        tablaComisionesVentas.setRowSorter(ordenable);
    }

    private void mostarTotalProduccion(boolean visible) {
        lblTotalMes.setVisible(visible);
        lblPorcentaje.setVisible(false);
        lblNetoComision.setVisible(false);
        lblNumeroPisos.setVisible(visible);
        txtTotalProduccionMes.setVisible(visible);
        txtPorcentaje.setVisible(false);
        txtNetoComision.setVisible(false);
        txtNumeroPisos.setVisible(visible);
    }

    private void mostarTotalesUsuarios(boolean visible) {
        lblTotalMes.setVisible(visible);
        lblPorcentaje.setVisible(visible);
        lblNetoComision.setVisible(visible);
        lblNumeroPisos.setVisible(visible);
        txtTotalProduccionMes.setVisible(visible);
        txtPorcentaje.setVisible(visible);
        txtNetoComision.setVisible(visible);
        txtNumeroPisos.setVisible(visible);
    }

    private void limpiar() {
        this.listarProduccion(null, null);
        this.mostarTotalesUsuarios(false);
        tablaCaptacion.getSelectionModel().clearSelection();
        tablaVentas.getSelectionModel().clearSelection();
        tablaSecretaria.getSelectionModel().clearSelection();
    }

    private void calcularProduccionMes(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        double totalProduccion = VENTA_CONTROL.calcularProduccionMes(fechaInicio, fechaFin);
        txtTotalProduccionMes.setText(String.valueOf(totalProduccion).concat("€"));
    }

    private void numeroPisos(java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        int numeroPisos = VENTA_CONTROL.numeroPisos(fechaInicio, fechaFin);
        txtNumeroPisos.setText(String.valueOf(numeroPisos));
    }

    private void calcularComisionEmpleado(Date inicio, Date fin, int idEmpleado, double porcentaje) {
        String mes = cboMes.getSelectedItem().toString();
        double producion = VENTA_CONTROL.calcularProduccionEmpleado(inicio, fin, idEmpleado);
        if (producion == 0) {
            //si no tiene produccion sale mensaje
            this.mostarTotalesUsuarios(false);
            Comunes.mensaje("El empleado no tiene comisiones en la producción de " + mes.toUpperCase(), "warning");
        } else {
            double comision = VENTA_CONTROL.calcularNetoEmpleado(producion, porcentaje);
            int numeroPisos = VENTA_CONTROL.numeroPisosEmpleado(inicio, fin, idEmpleado);
            txtTotalProduccionMes.setText(String.valueOf(producion).concat("€"));
            txtPorcentaje.setText(String.valueOf(porcentaje).concat("%"));
            txtNetoComision.setText(String.valueOf(comision).concat("€"));
            txtNumeroPisos.setText(String.valueOf(numeroPisos));
        }
    }

    private void calcularComisionJefe(Date inicio, Date fin, double porcentaje) {
        String mes = cboMes.getSelectedItem().toString();
        double producion = VENTA_CONTROL.calcularProduccionMes(inicio, fin);
        if (producion == 0) {
            //si no tiene produccion sale mensaje
            this.mostarTotalesUsuarios(false);
            Comunes.mensaje("El empleado no tiene comisiones en la producción de " + mes.toUpperCase(), "warning");
        } else {
            double comision = VENTA_CONTROL.calcularNetoEmpleado(producion, porcentaje);
            int numeroPisos = VENTA_CONTROL.numeroPisos(inicio, fin);
            txtTotalProduccionMes.setText(String.valueOf(producion).concat("€"));
            txtPorcentaje.setText(String.valueOf(porcentaje).concat("%"));
            txtNetoComision.setText(String.valueOf(comision).concat("€"));
            txtNumeroPisos.setText(String.valueOf(numeroPisos));
        }
    }

    private java.sql.Date fechaInicio() {
        String mes = cboMes.getSelectedItem().toString();
        String año = cboAño.getSelectedItem().toString();
        java.sql.Date fechaInicio = VENTA_CONTROL.fechaInicio(mes, año);
        return fechaInicio;
    }

    private java.sql.Date fechaFin() {
        String mes = cboMes.getSelectedItem().toString();
        String año = cboAño.getSelectedItem().toString();
        java.sql.Date fechaFin = VENTA_CONTROL.fechaFin(mes, año);
        return fechaFin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboAño = new javax.swing.JComboBox<>();
        btnSeleccionar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCalculoCaptacion = new javax.swing.JButton();
        btnTablaVentas = new javax.swing.JButton();
        btnTablaSecretaria = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCaptacion = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaSecretaria = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComisionesVentas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        lblTotalMes = new javax.swing.JLabel();
        txtTotalProduccionMes = new javax.swing.JTextField();
        lblPorcentaje = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        lblNetoComision = new javax.swing.JLabel();
        txtNetoComision = new javax.swing.JTextField();
        lblNumeroPisos = new javax.swing.JLabel();
        txtNumeroPisos = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1200, 565));

        jPanel2.setBackground(new java.awt.Color(46, 106, 141));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("PRODUCCIÓN MES:");

        cboMes.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("AÑO:");

        cboAño.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionar.setText("Listar Produccion Total");
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

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnLimpiar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnLimpiar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCalculoCaptacion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnCalculoCaptacion.setText("Comision Captador");
        btnCalculoCaptacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCalculoCaptacion.setBorderPainted(false);
        btnCalculoCaptacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoCaptacionActionPerformed(evt);
            }
        });

        btnTablaVentas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnTablaVentas.setText("Comision Vendedor");
        btnTablaVentas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTablaVentas.setBorderPainted(false);
        btnTablaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaVentasActionPerformed(evt);
            }
        });

        btnTablaSecretaria.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnTablaSecretaria.setText("Comision Secretaria");
        btnTablaSecretaria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTablaSecretaria.setBorderPainted(false);
        btnTablaSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaSecretariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCalculoCaptacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTablaVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTablaSecretaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(119, 119, 119)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTablaVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCalculoCaptacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnTablaSecretaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EQUIPO CAPTACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel4.setMaximumSize(new java.awt.Dimension(375, 200));
        jPanel4.setMinimumSize(new java.awt.Dimension(375, 200));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        tablaCaptacion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaCaptacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCaptacion.setRowHeight(20);
        tablaCaptacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tablaCaptacion);

        jPanel4.add(jScrollPane2);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EQUIPO VENTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(375, 200));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        tablaVentas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaVentas.setRowHeight(20);
        jScrollPane3.setViewportView(tablaVentas);

        jPanel5.add(jScrollPane3);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SECRETARÍA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(400, 201));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        tablaSecretaria.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaSecretaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaSecretaria.setRowHeight(20);
        jScrollPane4.setViewportView(tablaSecretaria);

        jPanel6.add(jScrollPane4);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCCIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaComisionesVentas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaComisionesVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaComisionesVentas.setRowHeight(20);
        jScrollPane1.setViewportView(tablaComisionesVentas);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lblTotalMes.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblTotalMes.setText("Total Producción Mes");

        txtTotalProduccionMes.setEditable(false);
        txtTotalProduccionMes.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotalProduccionMes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalProduccionMes.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblPorcentaje.setText("Porcentaje");

        txtPorcentaje.setEditable(false);
        txtPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPorcentaje.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblNetoComision.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblNetoComision.setText("Neto Comisión");

        txtNetoComision.setEditable(false);
        txtNetoComision.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNetoComision.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalMes)
                    .addComponent(lblPorcentaje)
                    .addComponent(lblNetoComision))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalProduccionMes)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNetoComision, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalProduccionMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPorcentaje)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNetoComision)
                    .addComponent(txtNetoComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNumeroPisos.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblNumeroPisos.setText("Número total de pisos:");

        txtNumeroPisos.setEditable(false);
        txtNumeroPisos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNumeroPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumeroPisos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 366, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroPisos)
                            .addComponent(txtNumeroPisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        this.listarProduccion(this.fechaInicio(), this.fechaFin());
        this.mostarTotalProduccion(true);
        this.calcularProduccionMes(this.fechaInicio(), this.fechaFin());
        this.numeroPisos(this.fechaInicio(), this.fechaFin());
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCalculoCaptacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoCaptacionActionPerformed
        tablaVentas.getSelectionModel().clearSelection();
        tablaSecretaria.getSelectionModel().clearSelection();
        if (tablaCaptacion.getSelectedRowCount() == 1) {
            String idCaptador = String.valueOf(tablaCaptacion.getValueAt(tablaCaptacion.getSelectedRow(), 0));
            int id = Integer.valueOf(idCaptador);
            String nombreDepartamento = String.valueOf(tablaCaptacion.getValueAt(tablaCaptacion.getSelectedRow(), 3));
            String pocentajeString = String.valueOf(tablaCaptacion.getValueAt(tablaCaptacion.getSelectedRow(), 4));
            double porcentaje = Double.valueOf(pocentajeString);

            if (nombreDepartamento.equals("Captacion")) {
                this.mostarTotalesUsuarios(true);
                this.listarProduccionUsuario(this.fechaInicio(), this.fechaFin(), id);
                this.calcularComisionEmpleado(this.fechaInicio(), this.fechaFin(), id, porcentaje);                
            } else {
                this.mostarTotalesUsuarios(true);
                this.listarProduccion(this.fechaInicio(), this.fechaFin());
                this.calcularComisionJefe(this.fechaInicio(), this.fechaFin(), porcentaje);
            }

        } else {
            Comunes.mensaje("Seleccione un captador", "error");
        }
    }//GEN-LAST:event_btnCalculoCaptacionActionPerformed

    private void btnTablaSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaSecretariaActionPerformed
        tablaCaptacion.getSelectionModel().clearSelection();
        tablaVentas.getSelectionModel().clearSelection();
        if (tablaSecretaria.getSelectedRowCount() == 1) {
            String idSecretaria = String.valueOf(tablaSecretaria.getValueAt(tablaSecretaria.getSelectedRow(), 0));
            int id = Integer.valueOf(idSecretaria);
            String pocentajeString = String.valueOf(tablaSecretaria.getValueAt(tablaSecretaria.getSelectedRow(), 4));
            double porcentaje = Double.valueOf(pocentajeString);
            
            this.mostarTotalesUsuarios(true);
            this.listarProduccionUsuario(this.fechaInicio(), this.fechaFin(), id);      
            this.calcularComisionEmpleado(this.fechaInicio(), this.fechaFin(), id, porcentaje);  
        } else {
            Comunes.mensaje("Seleccione una secretaria", "error");
        }
    }//GEN-LAST:event_btnTablaSecretariaActionPerformed

    private void btnTablaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaVentasActionPerformed
        tablaCaptacion.getSelectionModel().clearSelection();
        tablaSecretaria.getSelectionModel().clearSelection();
        if (tablaVentas.getSelectedRowCount() == 1) {
            String idVendedor = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0));
            int id = Integer.valueOf(idVendedor);
            String nombreDepartamento = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 3));
            String pocentajeString = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 4));
            double porcentaje = Double.valueOf(pocentajeString);

            if (nombreDepartamento.equals("Ventas")) {
                this.mostarTotalesUsuarios(true);
                this.listarProduccionUsuario(this.fechaInicio(), this.fechaFin(), id);
                this.calcularComisionEmpleado(this.fechaInicio(), this.fechaFin(), id, porcentaje);                
            } else {   //si no es de Ventas es Jefe de Ventas y sobre todo lo vendido esa producción
                this.mostarTotalesUsuarios(true);
                this.listarProduccion(this.fechaInicio(), this.fechaFin());
                this.calcularComisionJefe(this.fechaInicio(), this.fechaFin(), porcentaje);                
            }
        } else {
            Comunes.mensaje("Seleccione un vendedor", "error");
        }
    }//GEN-LAST:event_btnTablaVentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculoCaptacion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnTablaSecretaria;
    private javax.swing.JButton btnTablaVentas;
    private javax.swing.JComboBox<String> cboAño;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNetoComision;
    private javax.swing.JLabel lblNumeroPisos;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblTotalMes;
    private javax.swing.JTable tablaCaptacion;
    private javax.swing.JTable tablaComisionesVentas;
    private javax.swing.JTable tablaSecretaria;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtNetoComision;
    private javax.swing.JTextField txtNumeroPisos;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtTotalProduccionMes;
    // End of variables declaration//GEN-END:variables
}
