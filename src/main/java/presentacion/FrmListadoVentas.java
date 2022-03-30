package presentacion;

import entidades.Venta;
import negocio.VentaControl;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.TableRowSorter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import presentacion.utiles.Comunes;

public class FrmListadoVentas extends javax.swing.JInternalFrame {

    private final VentaControl VENTA_CONTROL;
    private Venta venta;
    public JFrame contenedor;

    public FrmListadoVentas() {
        initComponents();
        VENTA_CONTROL = new VentaControl();
        tabVentas.setEnabledAt(1, false);
        txtId.setVisible(false);
        txtIdSecretaria.setVisible(false);
        txtIdCaptador.setVisible(false);
        txtIdVendedor.setVisible(false);
        txtIdInmueble.setVisible(false);
        txtIdComprador.setVisible(false);
        txtIdPropietario.setVisible(false);
        this.listar("");
    }

    private void listar(String texto) {
        tablaVentas.setModel(VENTA_CONTROL.listar(texto));
        TableRowSorter ordenable = new TableRowSorter(tablaVentas.getModel());
        tablaVentas.setRowSorter(ordenable);

        double totalProduccion = 0;
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            String comisionString = (String) tablaVentas.getValueAt(i, 22);
            double comision = Double.parseDouble(comisionString);
            totalProduccion += comision;
        }
        double totalHonorariosRedondeo = Math.round(totalProduccion * 100.0) / 100.0;
        String honorarios = Double.toString(totalHonorariosRedondeo);
        txtTotalComisiones.setText(honorarios.concat("€"));
        int numeroOperaciones = tablaVentas.getRowCount();
        txtTotalOperaciones.setText(String.valueOf(numeroOperaciones));
        int[] columnasOcultas = {0, 2, 6, 8, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        Comunes.ocultarColumnas(tablaVentas, columnasOcultas);
    }

    private void listarProduccion(java.sql.Date inicio, java.sql.Date fin) {
        tablaVentas.setModel(VENTA_CONTROL.listar(inicio, fin));
        TableRowSorter ordenable = new TableRowSorter(tablaVentas.getModel());
        tablaVentas.setRowSorter(ordenable);

        if (tablaVentas.getRowCount() == 0) {
            Comunes.mensaje("No se ha encontrado ninguna venta entre esas fechas", "error");
        }
        double totalProduccion = 0;
        for (int i = 0; i < tablaVentas.getRowCount(); i++) {
            String comisionString = (String) tablaVentas.getValueAt(i, 22);
            double comision = Double.parseDouble(comisionString);
            totalProduccion += comision;
        }
        double totalHonorariosRedondeo = Math.round(totalProduccion * 100.0) / 100.0;
        String honorarios = Double.toString(totalHonorariosRedondeo);
        txtTotalComisiones.setText(honorarios.concat("€"));
        int numeroOperaciones = tablaVentas.getRowCount();
        txtTotalOperaciones.setText(String.valueOf(numeroOperaciones));
        int[] columnasOcultas = {0, 2, 6, 8, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        Comunes.ocultarColumnas(tablaVentas, columnasOcultas);
    }

    private void limpiar() {
        txtId.setText("");
        txtTipoOperacion.setText("");
        txtNumeroFactura.setText("");
        txtIdInmueble.setText("");
        txtIdSecretaria.setText("");
        txtSecretaria.setText("");
        txtIdCaptador.setText("");
        txtCaptador.setText("");
        txtIdVendedor.setText("");
        txtVendedor.setText("");
        txtIdComprador.setText("");
        txtNombreComprador.setText("");
        txtApellidosComprador.setText("");
        txtNumeroDocumentoComprador.setText("");
        txtIdPropietario.setText("");
        txtNombrePropietario.setText("");
        txtApellidosPropietario.setText("");
        txtNumeroDocumentoPropietario.setText("");
        txtTipoInmueble.setText("");
        txtDireccion.setText("");
        txtHonorarios.setText("");
        jdcFechaVenta.setDate(null);
        txtTotalRecibido.setText("");
        txtIva.setText("");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabVentas = new javax.swing.JTabbedPane();
        panelFondo = new javax.swing.JPanel();
        panelBotones1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnGenerarFactura = new javax.swing.JButton();
        btnDatosPropietario = new javax.swing.JButton();
        btnDatosComprador = new javax.swing.JButton();
        panelFechas = new javax.swing.JPanel();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jdcFin = new com.toedter.calendar.JDateChooser();
        btnSeleccionarFechas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotalOperaciones = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotalComisiones = new javax.swing.JTextField();
        panelTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        panelBotones2 = new javax.swing.JPanel();
        btnGuardarCambios = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtIdSecretaria = new javax.swing.JTextField();
        txtIdVendedor = new javax.swing.JTextField();
        txtIdComprador = new javax.swing.JTextField();
        txtIdPropietario = new javax.swing.JTextField();
        txtIdInmueble = new javax.swing.JTextField();
        txtIdCaptador = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        panelDatosPropietario = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtNombrePropietario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTipoDocumentacionPropietario = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtNumeroDocumentoPropietario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtApellidosPropietario = new javax.swing.JTextField();
        panelDatosComprador = new javax.swing.JPanel();
        btnSeleccionarComprador = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtNombreComprador = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtNumeroDocumentoComprador = new javax.swing.JTextField();
        txtTipoDocumentacionComprador = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtApellidosComprador = new javax.swing.JTextField();
        panelDatosOperacion = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnSeleccionarPropietario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSecretaria = new javax.swing.JTextField();
        btnSeleccionarSecretaria = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCaptador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTipoOperacion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTipoInmueble = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtHonorarios = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jdcFechaVenta = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTotalRecibido = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado Ventas");

        tabVentas.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N

        panelBotones1.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones1.setPreferredSize(new java.awt.Dimension(176, 402));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Búsqueda(*):");

        txtNombreBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombreBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNombreBuscar.setMaximumSize(new java.awt.Dimension(5, 18));

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

        btnDeseleccionar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnDeseleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/volver.png"))); // NOI18N
        btnDeseleccionar.setText("Deseleccionar");
        btnDeseleccionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeseleccionar.setBorderPainted(false);
        btnDeseleccionar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnDeseleccionar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnDeseleccionar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnDeseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeseleccionarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setText("(Por direccion o nº factura)");

        btnGenerarFactura.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btnGenerarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/factura.png"))); // NOI18N
        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarFactura.setBorderPainted(false);
        btnGenerarFactura.setMaximumSize(new java.awt.Dimension(155, 41));
        btnGenerarFactura.setMinimumSize(new java.awt.Dimension(155, 41));
        btnGenerarFactura.setPreferredSize(new java.awt.Dimension(155, 41));
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });

        btnDatosPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnDatosPropietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/iconCliente.png"))); // NOI18N
        btnDatosPropietario.setText("Datos Propietario");
        btnDatosPropietario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnDatosPropietario.setBorderPainted(false);
        btnDatosPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosPropietarioActionPerformed(evt);
            }
        });

        btnDatosComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnDatosComprador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/iconCliente.png"))); // NOI18N
        btnDatosComprador.setText("Datos Comprador");
        btnDatosComprador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnDatosComprador.setBorderPainted(false);
        btnDatosComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosCompradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotones1Layout = new javax.swing.GroupLayout(panelBotones1);
        panelBotones1.setLayout(panelBotones1Layout);
        panelBotones1Layout.setHorizontalGroup(
            panelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelBotones1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscar, btnDatosComprador, btnDatosPropietario, btnDeseleccionar, btnGenerarFactura, btnModificar});

        panelBotones1Layout.setVerticalGroup(
            panelBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addGap(6, 6, 6)
                .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnDatosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnDatosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotones1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscar, btnDatosComprador, btnDatosPropietario, btnDeseleccionar, btnGenerarFactura, btnModificar});

        panelFechas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONAR FECHAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelFechas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jdcInicio.setDateFormatString("dd-MM-yyyy");

        jdcFin.setDateFormatString("dd-MM-yyyy");

        btnSeleccionarFechas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarFechas.setText("Buscar");
        btnSeleccionarFechas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSeleccionarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarFechasbtnSeleccionarFechasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setText("Desde:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Hasta:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel9.setText("Número de Operaciones:");

        txtTotalOperaciones.setEditable(false);
        txtTotalOperaciones.setBackground(new java.awt.Color(204, 204, 204));
        txtTotalOperaciones.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel10.setText("Total Comisiones: ");

        txtTotalComisiones.setEditable(false);
        txtTotalComisiones.setBackground(new java.awt.Color(204, 204, 204));
        txtTotalComisiones.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotalComisiones.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout panelFechasLayout = new javax.swing.GroupLayout(panelFechas);
        panelFechas.setLayout(panelFechasLayout);
        panelFechasLayout.setHorizontalGroup(
            panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFin, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        panelFechasLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jdcFin, jdcInicio});

        panelFechasLayout.setVerticalGroup(
            panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSeleccionarFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtTotalOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtTotalComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jdcInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jdcFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE VENTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTabla.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaVentas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaVentas.setRowHeight(20);
        jScrollPane2.setViewportView(tablaVentas);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addComponent(panelBotones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
            .addComponent(panelBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        tabVentas.addTab("Listado", panelFondo);

        panelBotones2.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones2.setPreferredSize(new java.awt.Dimension(176, 366));

        btnGuardarCambios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/guardar.png"))); // NOI18N
        btnGuardarCambios.setText("Guardar");
        btnGuardarCambios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarCambios.setBorderPainted(false);
        btnGuardarCambios.setMaximumSize(new java.awt.Dimension(155, 41));
        btnGuardarCambios.setMinimumSize(new java.awt.Dimension(155, 41));
        btnGuardarCambios.setPreferredSize(new java.awt.Dimension(155, 41));
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotones2Layout = new javax.swing.GroupLayout(panelBotones2);
        panelBotones2.setLayout(panelBotones2Layout);
        panelBotones2Layout.setHorizontalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBotones2Layout.setVerticalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(391, Short.MAX_VALUE))
        );

        panelDatosPropietario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PROPIETARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelDatosPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel30.setText("Nombre (*):");

        txtNombrePropietario.setEditable(false);
        txtNombrePropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtNombrePropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombrePropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setText("Tipo Documentación (*):");

        txtTipoDocumentacionPropietario.setEditable(false);
        txtTipoDocumentacionPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtTipoDocumentacionPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTipoDocumentacionPropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel31.setText("Número Documento (*):");

        txtNumeroDocumentoPropietario.setEditable(false);
        txtNumeroDocumentoPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroDocumentoPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroDocumentoPropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setText("Apellidos(*):");

        txtApellidosPropietario.setEditable(false);
        txtApellidosPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidosPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtApellidosPropietario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelDatosPropietarioLayout = new javax.swing.GroupLayout(panelDatosPropietario);
        panelDatosPropietario.setLayout(panelDatosPropietarioLayout);
        panelDatosPropietarioLayout.setHorizontalGroup(
            panelDatosPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPropietarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosPropietarioLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoDocumentacionPropietario))
                    .addGroup(panelDatosPropietarioLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosPropietarioLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDocumentoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosPropietarioLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelDatosPropietarioLayout.setVerticalGroup(
            panelDatosPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPropietarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel11)
                    .addComponent(txtApellidosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelDatosPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtNumeroDocumentoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtTipoDocumentacionPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosPropietarioLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtApellidosPropietario, txtNumeroDocumentoPropietario});

        panelDatosComprador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS COMPRADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelDatosComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        btnSeleccionarComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarComprador.setText("...");
        btnSeleccionarComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCompradorActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel32.setText("Seleccionar Comprador (*):");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel34.setText("Nombre(*):");

        txtNombreComprador.setEditable(false);
        txtNombreComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombreComprador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel36.setText("Tipo Documentación (*):");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel37.setText("Número Documento (*):");

        txtNumeroDocumentoComprador.setEditable(false);
        txtNumeroDocumentoComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroDocumentoComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroDocumentoComprador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtTipoDocumentacionComprador.setEditable(false);
        txtTipoDocumentacionComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtTipoDocumentacionComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTipoDocumentacionComprador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setText("Apellidos(*):");

        txtApellidosComprador.setEditable(false);
        txtApellidosComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidosComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtApellidosComprador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelDatosCompradorLayout = new javax.swing.GroupLayout(panelDatosComprador);
        panelDatosComprador.setLayout(panelDatosCompradorLayout);
        panelDatosCompradorLayout.setHorizontalGroup(
            panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeleccionarComprador))
                    .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                        .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipoDocumentacionComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroDocumentoComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelDatosCompradorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtNumeroDocumentoComprador, txtTipoDocumentacionComprador});

        panelDatosCompradorLayout.setVerticalGroup(
            panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosCompradorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(10, 10, 10)
                .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtApellidosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(txtNombreComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtNumeroDocumentoComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(txtTipoDocumentacionComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosCompradorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtNumeroDocumentoComprador, txtTipoDocumentacionComprador});

        panelDatosOperacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA OPERACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelDatosOperacion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel16.setText("Seleccionar Inmueble");

        btnSeleccionarPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarPropietario.setText("...");
        btnSeleccionarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPropietarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Secretaria (*):");

        txtSecretaria.setEditable(false);
        txtSecretaria.setBackground(new java.awt.Color(204, 204, 204));
        txtSecretaria.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtSecretaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSeleccionarSecretaria.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarSecretaria.setText("...");
        btnSeleccionarSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarSecretariaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Captador");

        txtCaptador.setEditable(false);
        txtCaptador.setBackground(new java.awt.Color(204, 204, 204));
        txtCaptador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtCaptador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Vendedor (*):");

        txtVendedor.setEditable(false);
        txtVendedor.setBackground(new java.awt.Color(204, 204, 204));
        txtVendedor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Tipo de Operación (*):");

        txtTipoOperacion.setEditable(false);
        txtTipoOperacion.setBackground(new java.awt.Color(204, 204, 204));
        txtTipoOperacion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTipoOperacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel20.setText("Inmueble (*):");

        txtTipoInmueble.setEditable(false);
        txtTipoInmueble.setBackground(new java.awt.Color(204, 204, 204));
        txtTipoInmueble.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTipoInmueble.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(new java.awt.Color(204, 204, 204));
        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel28.setText("Honorarios");

        txtHonorarios.setEditable(false);
        txtHonorarios.setBackground(new java.awt.Color(204, 204, 204));
        txtHonorarios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtHonorarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel21.setText("Fecha Venta");

        jdcFechaVenta.setDateFormatString("dd-MM-yyyy");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("IVA");

        txtIva.setEditable(false);
        txtIva.setBackground(new java.awt.Color(204, 204, 204));
        txtIva.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtIva.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel15.setText("Total Recibido");

        txtTotalRecibido.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotalRecibido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtTotalRecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalRecibidoKeyTyped(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel22.setText("Nº Factura");

        txtNumeroFactura.setEditable(false);
        txtNumeroFactura.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroFactura.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelDatosOperacionLayout = new javax.swing.GroupLayout(panelDatosOperacion);
        panelDatosOperacion.setLayout(panelDatosOperacionLayout);
        panelDatosOperacionLayout.setHorizontalGroup(
            panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosOperacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosOperacionLayout.createSequentialGroup()
                        .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDatosOperacionLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccionarPropietario)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jdcFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosOperacionLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSeleccionarSecretaria)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(txtVendedor)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosOperacionLayout.createSequentialGroup()
                        .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosOperacionLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btnCalcular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosOperacionLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );

        panelDatosOperacionLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtHonorarios, txtIva, txtTotalRecibido});

        panelDatosOperacionLayout.setVerticalGroup(
            panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosOperacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(btnSeleccionarPropietario)
                        .addComponent(jLabel3)
                        .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(10, 10, 10)
                .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarSecretaria)
                    .addComponent(txtSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtTotalRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosOperacionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHonorarios, txtIva, txtTotalRecibido});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelDatosOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtIdSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelDatosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(panelDatosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtId, txtIdCaptador, txtIdComprador, txtIdInmueble, txtIdPropietario, txtIdSecretaria, txtIdVendedor});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelDatosOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelDatosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(panelDatosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addComponent(panelBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        tabVentas.addTab("Modificar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabVentas)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabVentas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        this.listar("");
        jdcInicio.setDate(null);
        jdcFin.setDate(null);
    }//GEN-LAST:event_btnDeseleccionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tablaVentas.getSelectedRowCount() == 1) {
            String numeroFactura = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 1));
            String tipoOperacion = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 3));
            String tipoInmueble = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 4));
            String direccion = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 5));
            String secretaria = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 7));
            String captador = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 9));
            String vendedor = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 11));
            //COMPRADOR
            String idComprador = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 12));
            String nombreComprador = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 13));
            String apellidosComprador = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 14));
            String tipoDocComprador = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 15));
            String dniComprador = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 16));
            //DATOS PROPIETARIO
            String idPropietario = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 17));
            String nombrePropietario = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 18));
            String apellidosPropietario = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 19));
            String tipoDocPropietario = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 20));
            String dniPropietario = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 21));
            //HONORARIOS
            String honorarios = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 22));
            String iva = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 23));
            String total = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 24));
            String fecha = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 25));
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = format.parse(fecha);
                jdcFechaVenta.setDate(date);
            } catch (ParseException ex) {
                Comunes.mensaje(ex.getMessage(), "error");
            }
            String id = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0));
            String idSecretaria = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 6));
            String idCaptador = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 8));
            String idVendedor = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 10));
            String idInmueble = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 2));

            txtId.setText(id);
            txtIdSecretaria.setText(idSecretaria);
            txtIdVendedor.setText(idVendedor);
            txtIdComprador.setText(idComprador);
            txtIdPropietario.setText(idPropietario);
            txtIdInmueble.setText(idInmueble);
            txtIdCaptador.setText(idCaptador);

            txtNumeroFactura.setText(numeroFactura);
            txtSecretaria.setText(secretaria);
            txtCaptador.setText(captador);
            txtVendedor.setText(vendedor);
            txtNombreComprador.setText(nombreComprador);
            txtApellidosComprador.setText(apellidosComprador);
            txtTipoDocumentacionComprador.setText(tipoDocComprador);
            txtNumeroDocumentoComprador.setText(dniComprador);
            txtNombrePropietario.setText(nombrePropietario);
            txtApellidosPropietario.setText(apellidosPropietario);
            txtTipoDocumentacionPropietario.setText(tipoDocPropietario);
            txtNumeroDocumentoPropietario.setText(dniPropietario);
            txtTipoOperacion.setText(tipoOperacion);
            txtTipoInmueble.setText(tipoInmueble);
            txtDireccion.setText(direccion);
            txtHonorarios.setText(honorarios);
            txtIva.setText(iva);
            txtTotalRecibido.setText(total);

            tabVentas.setEnabledAt(0, false);
            tabVentas.setEnabledAt(1, true);
            tabVentas.setSelectedIndex(1);
        } else {
            Comunes.mensaje("Seleccione una operacion de venta para modificar", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtNombreBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarFechasbtnSeleccionarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarFechasbtnSeleccionarFechasActionPerformed
        if (jdcInicio.getDate() == null || jdcFin.getDate() == null) {
            Comunes.mensaje("Seleccione fechas", "error");
        } else if (jdcInicio.getDate().after(jdcFin.getDate())) {
            Comunes.mensaje("La fecha de inicio no puede ser posterior a la fecha fin", "error");
        } else {
            Date date1 = jdcInicio.getDate();
            long dateInicio = date1.getTime();
            java.sql.Date dateInicioSql = new java.sql.Date(dateInicio);

            Date date2 = jdcFin.getDate();
            long dateFin = date2.getTime();
            java.sql.Date dateFinSql = new java.sql.Date(dateFin);

            this.listarProduccion(dateInicioSql, dateFinSql);
        }
    }//GEN-LAST:event_btnSeleccionarFechasbtnSeleccionarFechasActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.limpiar();
        tabVentas.setEnabledAt(0, true);
        tabVentas.setEnabledAt(1, false);
        tabVentas.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        if (txtSecretaria.getText().isEmpty()) {
            Comunes.mensaje("Debes seleccionar una secretaria", "warning");
            txtSecretaria.requestFocus();
            return;
        }
        if (txtVendedor.getText().isEmpty()) {
            Comunes.mensaje("Debes seleccionar un vendedor", "warning");
            txtVendedor.requestFocus();
            return;
        }
        if (txtNombreComprador.getText().isEmpty()) {
            Comunes.mensaje("Debes seleccionar un comprador", "warning");
            txtNombreComprador.requestFocus();
            return;
        }
        if (txtNombrePropietario.getText().isEmpty()) {
            Comunes.mensaje("Debes seleccionar un inmueble", "warning");
            txtNombrePropietario.requestFocus();
            return;
        }
        if (!jdcFechaVenta.isValid()) {
            Comunes.mensaje("Debes seleccionar una fecha de venta", "warning");
            jdcFechaVenta.requestFocus();
            return;
        }
        if (txtNumeroFactura.getText().trim().length() == 0 || txtNumeroFactura.getText().length() > 8) {
            Comunes.mensaje("Debe introducir numero de factura y no debe ser mayor de 8 caracteres", "warning");
            txtNumeroFactura.requestFocus();
            return;
        }
        try {
            if (txtTotalRecibido.getText().trim().length() == 0 || txtTotalRecibido.getText().length() > 13) {
                Comunes.mensaje("Debes ingresar el total de la venta", "warning");
                txtHonorarios.requestFocus();
                return;
            }              //Comprobar que los honoriarios es numérico
            String precioString = txtHonorarios.getText().trim();
            boolean esNumerico = Comunes.esNumerico(precioString);
            if (!esNumerico) {
                Comunes.mensaje("Debes introducir los honorarios en formato numerico", "warning");
                txtHonorarios.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Comunes.mensaje("Debes introducir los honorarios en formato correcto", "warning");
            txtHonorarios.requestFocus();
            return;
        }
        if (txtNumeroFactura.getText().isEmpty()) {
            Comunes.mensaje("Debe introducir los honorarios", "warning");
            txtNumeroFactura.requestFocus();
            return;
        }
        int idVenta = Integer.valueOf(txtId.getText());
        int inmuebleId = Integer.valueOf(txtIdInmueble.getText());
        String numeroFactura = txtNumeroFactura.getText();
        String idSecretaria = txtIdSecretaria.getText();
        int secretariaId = Integer.parseInt(idSecretaria);       
        int compradorId = Integer.valueOf(txtIdComprador.getText());
        String honString = txtHonorarios.getText();
        double honorarios = Double.parseDouble(honString);
        Date date = jdcFechaVenta.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);

        venta = new Venta(idVenta, numeroFactura,inmuebleId,secretariaId,
                compradorId, honorarios, fecha);
        String respuesta = VENTA_CONTROL.modificarVenta(venta);

        if (respuesta.equals("OK")) {
            this.limpiar();
            this.listar("");
            Comunes.mensaje("Venta actualizada correctamente", "ok");
        } else {
            Comunes.mensaje(respuesta, "error");
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        if (tablaVentas.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0));
            int idVenta = Integer.parseInt(id);
            VENTA_CONTROL.generarFactura(idVenta);
        } else {
            Comunes.mensaje("Debes selecionar una operación", "error");
        }
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    private void btnSeleccionarCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCompradorActionPerformed
        FrmSelecCliente frm = new FrmSelecCliente(contenedor, null, this, null, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarCompradorActionPerformed

    private void btnSeleccionarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPropietarioActionPerformed
        FrmSelecInmueble frm = new FrmSelecInmueble(contenedor, null, this, closable);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarPropietarioActionPerformed

    private void btnSeleccionarSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarSecretariaActionPerformed
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, null, null, null, this, null,null, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarSecretariaActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        String totalString = txtTotalRecibido.getText();
        double total = Double.parseDouble(totalString);        
        double baseImponible = VENTA_CONTROL.calcularBaseImponible(total);
        double iva = VENTA_CONTROL.calcularIva(baseImponible);
        txtHonorarios.setText(String.valueOf(baseImponible));
        txtIva.setText(String.valueOf(iva));
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnDatosPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosPropietarioActionPerformed
        if (tablaVentas.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 17));
            int idPropietario = Integer.parseInt(id);
            FrmDatosPropietario frm = new FrmDatosPropietario(contenedor, null, null, this, idPropietario, true);
            frm.toFront();

        } else {
            Comunes.mensaje("Seleccione un inmueble", "error");
        }
    }//GEN-LAST:event_btnDatosPropietarioActionPerformed

    private void btnDatosCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosCompradorActionPerformed
        if (tablaVentas.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 12));
            int idPropietario = Integer.parseInt(id);
            FrmDatosComprador frm = new FrmDatosComprador(contenedor, this, idPropietario, true);
            frm.toFront();

        } else {
            Comunes.mensaje("Seleccione un inmueble", "error");
        }
    }//GEN-LAST:event_btnDatosCompradorActionPerformed

    private void txtTotalRecibidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalRecibidoKeyTyped
        txtHonorarios.setText("");
        txtIva.setText("");
        Comunes.mensaje("Recalcule los honorarios", "warning");
    }//GEN-LAST:event_txtTotalRecibidoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnDatosComprador;
    private javax.swing.JButton btnDatosPropietario;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionarComprador;
    private javax.swing.JButton btnSeleccionarFechas;
    private javax.swing.JButton btnSeleccionarPropietario;
    private javax.swing.JButton btnSeleccionarSecretaria;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFechaVenta;
    private com.toedter.calendar.JDateChooser jdcFin;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JPanel panelBotones1;
    private javax.swing.JPanel panelBotones2;
    private javax.swing.JPanel panelDatosComprador;
    private javax.swing.JPanel panelDatosOperacion;
    private javax.swing.JPanel panelDatosPropietario;
    private javax.swing.JPanel panelFechas;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTabbedPane tabVentas;
    private javax.swing.JTable tablaVentas;
    public javax.swing.JTextField txtApellidosComprador;
    public javax.swing.JTextField txtApellidosPropietario;
    public javax.swing.JTextField txtCaptador;
    public javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtHonorarios;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtIdCaptador;
    public javax.swing.JTextField txtIdComprador;
    public javax.swing.JTextField txtIdInmueble;
    public javax.swing.JTextField txtIdPropietario;
    public javax.swing.JTextField txtIdSecretaria;
    public javax.swing.JTextField txtIdVendedor;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombreBuscar;
    public javax.swing.JTextField txtNombreComprador;
    public javax.swing.JTextField txtNombrePropietario;
    public javax.swing.JTextField txtNumeroDocumentoComprador;
    public javax.swing.JTextField txtNumeroDocumentoPropietario;
    protected javax.swing.JTextField txtNumeroFactura;
    public javax.swing.JTextField txtSecretaria;
    public javax.swing.JTextField txtTipoDocumentacionComprador;
    public javax.swing.JTextField txtTipoDocumentacionPropietario;
    public javax.swing.JTextField txtTipoInmueble;
    public javax.swing.JTextField txtTipoOperacion;
    private javax.swing.JTextField txtTotalComisiones;
    private javax.swing.JTextField txtTotalOperaciones;
    private javax.swing.JTextField txtTotalRecibido;
    public javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
