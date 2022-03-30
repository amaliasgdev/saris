package presentacion;

import entidades.Llamada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.TableRowSorter;
import negocio.LlamadaControl;
import negocio.ClienteControl;
import negocio.EmpleadoControl;
import presentacion.utiles.Comunes;

public class FrmListadoLlamadas extends javax.swing.JInternalFrame {

    private final LlamadaControl LLAMADA_CONTROL;
    private final EmpleadoControl EMPLEADO_CONTROL;
    private final ClienteControl CLIENTE_CONTROL;
    private Llamada llamada;
    private java.sql.Date fechaHoySql;
    public JFrame contenedor;

    public FrmListadoLlamadas() {
        initComponents();
        LLAMADA_CONTROL = new LlamadaControl();
        EMPLEADO_CONTROL = new EmpleadoControl();
        CLIENTE_CONTROL = new ClienteControl();
        tabLlamadas.setEnabledAt(1, false);
        tabLlamadas.setEnabledAt(2, false);
        Comunes.llenarComboboxGenerico(Comunes.MEDIO, cboMedio);
        Comunes.llenarComboboxGenerico(Comunes.TIPO_OPERACION, cboTipoOperacion);
        Comunes.llenarComboboxGenerico(Comunes.ZONA, cboZona);
        Comunes.llenarComboboxGenerico(Comunes.MEDIO, cboMedioM);
        Comunes.llenarComboboxGenerico(Comunes.TIPO_OPERACION, cboTipoOperacionM);
        Comunes.llenarComboboxGenerico(Comunes.ZONA, cboZonaM);
        this.obtenerFecha();
        String fechaString = txtFecha.getText();
        fechaHoySql = this.obtenerFechaSql(fechaString);
        txtIdVendedorMo.setVisible(false);
        txtIdLlamada.setVisible(false);
        txtIdVendedor.setVisible(false);
        this.listar(fechaHoySql);
    }

    private void obtenerFecha() {
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = format.format(hoy);
        txtFecha.setText(fecha);
    }

    private java.sql.Date obtenerFechaSql(String fecha) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        java.sql.Date fechaSql = null;
        try {
            date = format.parse(fecha);
            long d = date.getTime();
            fechaSql = new java.sql.Date(d);
        } catch (ParseException ex) {
            Comunes.mensaje(ex.getMessage(), "error");
        }
        return fechaSql;
    }

    private void listar(java.sql.Date fechaSql) {
        tablaLlamadas.setModel(LLAMADA_CONTROL.listar(fechaSql));
        TableRowSorter ordenable = new TableRowSorter(tablaLlamadas.getModel());
        tablaLlamadas.setRowSorter(ordenable);

        tablaVendedores.setModel(EMPLEADO_CONTROL.listarNombresId("Ventas", fechaSql));
        TableRowSorter ordenable1 = new TableRowSorter(tablaVendedores.getModel());
        tablaVendedores.setRowSorter(ordenable1);

        tablaMedios.setModel(LLAMADA_CONTROL.listarTablaLlamadaMedios(fechaSql));
        TableRowSorter ordenable2 = new TableRowSorter(tablaMedios.getModel());
        tablaMedios.setRowSorter(ordenable2);

        this.txtNumeroTotal.setText(String.valueOf(tablaLlamadas.getRowCount()));
        int[] columnasOcultasLlamadas = {0, 5};
        int[] columnasOcultasVendedores = {0};
        Comunes.ocultarColumnas(tablaLlamadas, columnasOcultasLlamadas);
        Comunes.ocultarColumnas(tablaVendedores, columnasOcultasVendedores);

    }

    private void listar(java.sql.Date inicioSql, java.sql.Date finSql) {
        tablaLlamadas2.setModel(LLAMADA_CONTROL.listar(inicioSql, finSql));
        TableRowSorter ordenable = new TableRowSorter(tablaLlamadas2.getModel());
        tablaLlamadas2.setRowSorter(ordenable);
        txtNumeroTotal.setText(String.valueOf(tablaLlamadas2.getRowCount()));

        tablaVendedores2.setModel(EMPLEADO_CONTROL.listarNombresId("Ventas", inicioSql, finSql));
        TableRowSorter ordenable1 = new TableRowSorter(tablaVendedores2.getModel());
        tablaVendedores2.setRowSorter(ordenable1);

        tablaMedios2.setModel(LLAMADA_CONTROL.listarTablaLlamadaMedios(inicioSql, finSql));
        TableRowSorter ordenable2 = new TableRowSorter(tablaMedios2.getModel());
        tablaMedios2.setRowSorter(ordenable2);

        this.txtNumeroTotal2.setText(String.valueOf(tablaLlamadas2.getRowCount()));
        int[] columnasOcultasLlamadas = {0, 5};
        int[] columnasOcultasVendedores = {0};
        Comunes.ocultarColumnas(tablaLlamadas2, columnasOcultasLlamadas);
        Comunes.ocultarColumnas(tablaVendedores2, columnasOcultasVendedores);
    }   

    private void limpiar() {
        cboMedio.setSelectedIndex(0);
        cboZona.setSelectedIndex(0);
        cboTipoOperacion.setSelectedIndex(0);
        txtVendedor.setText("");
        txtIdVendedor.setText("");
        txtMedioM.setText("");
        txtZonaM.setText("");
        txtTipoM.setText("");
        txtIdLlamada.setText("");
        txtVendedorMo.setText("");
        txtIdVendedor.setText("");
        txtVendedorM.setText("");
        cboMedioM.setSelectedIndex(0);
        cboZonaM.setSelectedIndex(0);
        cboTipoOperacionM.setSelectedIndex(0);
        txtVendedorM.setText("");
        txtIdLlamada.setText("");
        txtIdVendedorMo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        tabLlamadas = new javax.swing.JTabbedPane();
        panelFondo1 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroTelefono = new javax.swing.JTextField();
        btnListado = new javax.swing.JButton();
        btnBuscarTelefono = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtNumeroTotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        panelTablaLlamadas1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLlamadas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboMedio = new javax.swing.JComboBox<>();
        cboZona = new javax.swing.JComboBox<>();
        cboTipoOperacion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        panelMedios1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMedios = new javax.swing.JTable();
        panelLlamadas1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        txtVendedor = new javax.swing.JTextField();
        btnBuscarVendedor = new javax.swing.JButton();
        txtIdVendedor = new javax.swing.JTextField();
        panelFondo2 = new javax.swing.JPanel();
        panelFormulario2 = new javax.swing.JPanel();
        txtFechaM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelValoresAntiguos2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMedioM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtZonaM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTipoM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVendedorM = new javax.swing.JTextField();
        panelValoresNuevos2 = new javax.swing.JPanel();
        cboMedioM = new javax.swing.JComboBox<>();
        cboZonaM = new javax.swing.JComboBox<>();
        cboTipoOperacionM = new javax.swing.JComboBox<>();
        txtVendedorMo = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelBotones2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        txtIdLlamada = new javax.swing.JTextField();
        txtIdVendedorMo = new javax.swing.JTextField();
        panelFondo3 = new javax.swing.JPanel();
        panelFondoParcial3 = new javax.swing.JPanel();
        panelTotalLlamadas3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaLlamadas2 = new javax.swing.JTable();
        panelLlamadasMedios3 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaMedios2 = new javax.swing.JTable();
        panelLlamadasVendedores3 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaVendedores2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        txtNumeroTotal2 = new javax.swing.JTextField();
        panelBotones3 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnBuscarFechas = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jdcFin = new com.toedter.calendar.JDateChooser();

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setTitle("Llamadas");

        tabLlamadas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones.setPreferredSize(new java.awt.Dimension(176, 402));
        panelBotones.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Búsqueda Nº Telefono:");
        panelBotones.add(jLabel1);
        jLabel1.setBounds(10, 20, 150, 20);

        txtNumeroTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNumeroTelefono.setMaximumSize(new java.awt.Dimension(5, 18));
        panelBotones.add(txtNumeroTelefono);
        txtNumeroTelefono.setBounds(10, 50, 150, 27);

        btnListado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/listado.png"))); // NOI18N
        btnListado.setText("Listado Global");
        btnListado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnListado.setBorderPainted(false);
        btnListado.setMaximumSize(new java.awt.Dimension(155, 41));
        btnListado.setMinimumSize(new java.awt.Dimension(155, 41));
        btnListado.setPreferredSize(new java.awt.Dimension(155, 41));
        btnListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoActionPerformed(evt);
            }
        });
        panelBotones.add(btnListado);
        btnListado.setBounds(10, 160, 155, 41);

        btnBuscarTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBuscarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/buscar.png"))); // NOI18N
        btnBuscarTelefono.setText("Buscar");
        btnBuscarTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarTelefono.setBorderPainted(false);
        btnBuscarTelefono.setMaximumSize(new java.awt.Dimension(155, 41));
        btnBuscarTelefono.setMinimumSize(new java.awt.Dimension(155, 41));
        btnBuscarTelefono.setPreferredSize(new java.awt.Dimension(155, 41));
        btnBuscarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTelefonoActionPerformed(evt);
            }
        });
        panelBotones.add(btnBuscarTelefono);
        btnBuscarTelefono.setBounds(10, 100, 155, 41);

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
        panelBotones.add(btnModificar);
        btnModificar.setBounds(10, 220, 155, 41);

        txtNumeroTotal.setEditable(false);
        txtNumeroTotal.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroTotal.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelBotones.add(txtNumeroTotal);
        txtNumeroTotal.setBounds(130, 290, 28, 19);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setText("Total Llamadas:");
        panelBotones.add(jLabel14);
        jLabel14.setBounds(20, 290, 90, 15);

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(204, 204, 204));
        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("FECHA");

        panelTablaLlamadas1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL LLAMADAS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTablaLlamadas1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaLlamadas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaLlamadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaLlamadas.setRowHeight(20);
        jScrollPane2.setViewportView(tablaLlamadas);

        javax.swing.GroupLayout panelTablaLlamadas1Layout = new javax.swing.GroupLayout(panelTablaLlamadas1);
        panelTablaLlamadas1.setLayout(panelTablaLlamadas1Layout);
        panelTablaLlamadas1Layout.setHorizontalGroup(
            panelTablaLlamadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLlamadas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelTablaLlamadas1Layout.setVerticalGroup(
            panelTablaLlamadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLlamadas1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Medio (*):");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Zona (*):");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Tipo de Operacion(*):");

        cboMedio.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cboZona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cboTipoOperacion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Vendedor(*):");

        panelMedios1.setBorder(javax.swing.BorderFactory.createTitledBorder("Total llamadas por medios"));
        panelMedios1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaMedios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jScrollPane3.setViewportView(tablaMedios);

        javax.swing.GroupLayout panelMedios1Layout = new javax.swing.GroupLayout(panelMedios1);
        panelMedios1.setLayout(panelMedios1Layout);
        panelMedios1Layout.setHorizontalGroup(
            panelMedios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMedios1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMedios1Layout.setVerticalGroup(
            panelMedios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedios1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLlamadas1.setBorder(javax.swing.BorderFactory.createTitledBorder("Total llamadas por vendedores"));
        panelLlamadas1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaVendedores.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaVendedores);

        javax.swing.GroupLayout panelLlamadas1Layout = new javax.swing.GroupLayout(panelLlamadas1);
        panelLlamadas1.setLayout(panelLlamadas1Layout);
        panelLlamadas1Layout.setHorizontalGroup(
            panelLlamadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLlamadas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLlamadas1Layout.setVerticalGroup(
            panelLlamadas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLlamadas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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

        txtVendedor.setBackground(new java.awt.Color(204, 204, 204));
        txtVendedor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnBuscarVendedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarVendedor.setText("...");
        btnBuscarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVendedorActionPerformed(evt);
            }
        });

        txtIdVendedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelFondo1Layout = new javax.swing.GroupLayout(panelFondo1);
        panelFondo1.setLayout(panelFondo1Layout);
        panelFondo1Layout.setHorizontalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo1Layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondo1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFondo1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(95, 95, 95)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(panelFondo1Layout.createSequentialGroup()
                                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelFondo1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuscarVendedor))
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboMedio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboTipoOperacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtVendedor))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)))
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMedios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelLlamadas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo1Layout.createSequentialGroup()
                .addComponent(panelTablaLlamadas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelFondo1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {panelLlamadas1, panelMedios1});

        panelFondo1Layout.setVerticalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFondo1Layout.createSequentialGroup()
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo1Layout.createSequentialGroup()
                                .addComponent(panelLlamadas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelMedios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(panelFondo1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(panelTablaLlamadas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelFondo1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTipoOperacion, txtVendedor});

        panelFondo1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panelLlamadas1, panelMedios1});

        tabLlamadas.addTab("Registrar Llamadas", panelFondo1);

        txtFechaM.setEditable(false);
        txtFechaM.setBackground(new java.awt.Color(204, 204, 204));
        txtFechaM.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtFechaM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtFechaM.setMaximumSize(new java.awt.Dimension(5, 18));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Fecha:");

        panelValoresAntiguos2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valores Antiguos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        panelValoresAntiguos2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel3.setText("Medio (*):");

        txtMedioM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setText("Zona (*):");

        txtZonaM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setText("Tipo de Operacion(*):");

        txtTipoM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setText("Vendedor (*):");

        txtVendedorM.setEditable(false);
        txtVendedorM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelValoresAntiguos2Layout = new javax.swing.GroupLayout(panelValoresAntiguos2);
        panelValoresAntiguos2.setLayout(panelValoresAntiguos2Layout);
        panelValoresAntiguos2Layout.setHorizontalGroup(
            panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValoresAntiguos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtZonaM, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipoM, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVendedorM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txtMedioM))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelValoresAntiguos2Layout.setVerticalGroup(
            panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValoresAntiguos2Layout.createSequentialGroup()
                .addGroup(panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMedioM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtZonaM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(panelValoresAntiguos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtVendedorM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        panelValoresNuevos2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valores Nuevos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        panelValoresNuevos2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtVendedorMo.setEditable(false);
        txtVendedorMo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSeleccionar.setText("...");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel4.setText("Medio (*):");

        jLabel15.setText("Zona (*):");

        jLabel16.setText("Tipo de Operacion(*):");

        jLabel17.setText("Vendedor (*):");

        javax.swing.GroupLayout panelValoresNuevos2Layout = new javax.swing.GroupLayout(panelValoresNuevos2);
        panelValoresNuevos2.setLayout(panelValoresNuevos2Layout);
        panelValoresNuevos2Layout.setHorizontalGroup(
            panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValoresNuevos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(5, 5, 5)
                .addGroup(panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboMedioM, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboZonaM, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboTipoOperacionM, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVendedorMo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
                .addGap(46, 46, 46))
        );
        panelValoresNuevos2Layout.setVerticalGroup(
            panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValoresNuevos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMedioM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboZonaM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(20, 20, 20)
                .addGroup(panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTipoOperacionM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(panelValoresNuevos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVendedorMo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar)
                    .addComponent(jLabel17))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFormulario2Layout = new javax.swing.GroupLayout(panelFormulario2);
        panelFormulario2.setLayout(panelFormulario2Layout);
        panelFormulario2Layout.setHorizontalGroup(
            panelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormulario2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormulario2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66)
                        .addComponent(txtFechaM, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelValoresAntiguos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelValoresNuevos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(368, Short.MAX_VALUE))
        );
        panelFormulario2Layout.setVerticalGroup(
            panelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormulario2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFormulario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelValoresAntiguos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelValoresNuevos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        panelFormulario2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panelValoresAntiguos2, panelValoresNuevos2});

        panelBotones2.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones2.setMaximumSize(new java.awt.Dimension(176, 402));
        panelBotones2.setMinimumSize(new java.awt.Dimension(176, 402));
        panelBotones2.setPreferredSize(new java.awt.Dimension(176, 402));

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/guardar.png"))); // NOI18N
        btnActualizar.setText("Guardar Cambios");
        btnActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.setBorderPainted(false);
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

        txtIdLlamada.setEditable(false);
        txtIdLlamada.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtIdVendedorMo.setEditable(false);
        txtIdVendedorMo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout panelBotones2Layout = new javax.swing.GroupLayout(panelBotones2);
        panelBotones2.setLayout(panelBotones2Layout);
        panelBotones2Layout.setHorizontalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotones2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotones2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotones2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdVendedorMo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        panelBotones2Layout.setVerticalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdVendedorMo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelBotones2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtIdLlamada, txtIdVendedorMo});

        javax.swing.GroupLayout panelFondo2Layout = new javax.swing.GroupLayout(panelFondo2);
        panelFondo2.setLayout(panelFondo2Layout);
        panelFondo2Layout.setHorizontalGroup(
            panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo2Layout.createSequentialGroup()
                .addComponent(panelBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormulario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelFondo2Layout.setVerticalGroup(
            panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
            .addGroup(panelFondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFormulario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabLlamadas.addTab("Modificar", panelFondo2);

        panelFondo3.setLayout(null);

        panelTotalLlamadas3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL LLAMADAS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTotalLlamadas3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaLlamadas2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaLlamadas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tablaLlamadas2);

        javax.swing.GroupLayout panelTotalLlamadas3Layout = new javax.swing.GroupLayout(panelTotalLlamadas3);
        panelTotalLlamadas3.setLayout(panelTotalLlamadas3Layout);
        panelTotalLlamadas3Layout.setHorizontalGroup(
            panelTotalLlamadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalLlamadas3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTotalLlamadas3Layout.setVerticalGroup(
            panelTotalLlamadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalLlamadas3Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLlamadasMedios3.setBorder(javax.swing.BorderFactory.createTitledBorder("Total llamadas por medios"));
        panelLlamadasMedios3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaMedios2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jScrollPane9.setViewportView(tablaMedios2);

        javax.swing.GroupLayout panelLlamadasMedios3Layout = new javax.swing.GroupLayout(panelLlamadasMedios3);
        panelLlamadasMedios3.setLayout(panelLlamadasMedios3Layout);
        panelLlamadasMedios3Layout.setHorizontalGroup(
            panelLlamadasMedios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLlamadasMedios3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLlamadasMedios3Layout.setVerticalGroup(
            panelLlamadasMedios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLlamadasMedios3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLlamadasVendedores3.setBorder(javax.swing.BorderFactory.createTitledBorder("Total llamadas por vendedores"));
        panelLlamadasVendedores3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaVendedores2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaVendedores2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(tablaVendedores2);

        javax.swing.GroupLayout panelLlamadasVendedores3Layout = new javax.swing.GroupLayout(panelLlamadasVendedores3);
        panelLlamadasVendedores3.setLayout(panelLlamadasVendedores3Layout);
        panelLlamadasVendedores3Layout.setHorizontalGroup(
            panelLlamadasVendedores3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLlamadasVendedores3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLlamadasVendedores3Layout.setVerticalGroup(
            panelLlamadasVendedores3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLlamadasVendedores3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel22.setText("Total Nº Llamadas:");

        txtNumeroTotal2.setEditable(false);
        txtNumeroTotal2.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroTotal2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroTotal2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroTotal2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelFondoParcial3Layout = new javax.swing.GroupLayout(panelFondoParcial3);
        panelFondoParcial3.setLayout(panelFondoParcial3Layout);
        panelFondoParcial3Layout.setHorizontalGroup(
            panelFondoParcial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoParcial3Layout.createSequentialGroup()
                .addComponent(panelLlamadasVendedores3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelLlamadasMedios3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelFondoParcial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(txtNumeroTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelFondoParcial3Layout.createSequentialGroup()
                .addComponent(panelTotalLlamadas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        panelFondoParcial3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {panelLlamadasMedios3, panelLlamadasVendedores3});

        panelFondoParcial3Layout.setVerticalGroup(
            panelFondoParcial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoParcial3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoParcial3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoParcial3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumeroTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelLlamadasMedios3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLlamadasVendedores3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(panelTotalLlamadas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelFondoParcial3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panelLlamadasMedios3, panelLlamadasVendedores3});

        panelFondo3.add(panelFondoParcial3);
        panelFondoParcial3.setBounds(2, 97, 950, 480);

        panelBotones3.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones3.setPreferredSize(new java.awt.Dimension(176, 402));

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.setBorderPainted(false);
        btnVolver.setMaximumSize(new java.awt.Dimension(155, 41));
        btnVolver.setMinimumSize(new java.awt.Dimension(155, 41));
        btnVolver.setPreferredSize(new java.awt.Dimension(155, 41));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnBuscarFechas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBuscarFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/buscar.png"))); // NOI18N
        btnBuscarFechas.setText("Buscar");
        btnBuscarFechas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarFechas.setBorderPainted(false);
        btnBuscarFechas.setMaximumSize(new java.awt.Dimension(155, 41));
        btnBuscarFechas.setMinimumSize(new java.awt.Dimension(155, 41));
        btnBuscarFechas.setPreferredSize(new java.awt.Dimension(155, 41));
        btnBuscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechasActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("DESDE: ");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("HASTA: ");

        javax.swing.GroupLayout panelBotones3Layout = new javax.swing.GroupLayout(panelBotones3);
        panelBotones3.setLayout(panelBotones3Layout);
        panelBotones3Layout.setHorizontalGroup(
            panelBotones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel27)
                .addGap(10, 10, 10)
                .addComponent(jdcFin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBuscarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBotones3Layout.setVerticalGroup(
            panelBotones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones3Layout.createSequentialGroup()
                .addGroup(panelBotones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotones3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jdcFin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotones3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBuscarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotones3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotones3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelBotones3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))))
                .addGap(36, 36, 36))
        );

        panelFondo3.add(panelBotones3);
        panelBotones3.setBounds(0, 0, 930, 97);

        tabLlamadas.addTab("Listado", panelFondo3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabLlamadas, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabLlamadas, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.limpiar();
        tabLlamadas.setEnabledAt(0, true);
        tabLlamadas.setEnabledAt(1, false);
        tabLlamadas.setSelectedIndex(0);
        this.listar(this.fechaHoySql);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtVendedorMo.getText().isEmpty()) {
            Comunes.mensaje("Debes ingresar un vendedor", "warning");
            txtVendedorMo.requestFocus();
            return;
        }
        int idLlamada = Integer.parseInt(txtIdLlamada.getText());
        String medio = cboMedioM.getSelectedItem().toString();
        String zona = cboZonaM.getSelectedItem().toString();
        String tipoOperacion = cboTipoOperacionM.getSelectedItem().toString();
        int idVendedor = Integer.parseInt(txtIdVendedorMo.getText());
        String fecha = txtFechaM.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        try {
            date = format.parse(fecha);
            long d = date.getTime();
            java.sql.Date fechaSql = new java.sql.Date(d);
            llamada = new Llamada(idLlamada, fechaSql, medio, zona, tipoOperacion, idVendedor);
            String respuesta = LLAMADA_CONTROL.modificarLlamada(llamada);
            if (respuesta.equals("OK")) {
                Comunes.mensaje("Llamada modificada", "ok");
            } else {
                Comunes.mensaje(respuesta, "error");
            }
            this.limpiar();
            this.listar(fechaHoySql);
        } catch (ParseException ex) {
            Comunes.mensaje(ex.getMessage(), "error");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, null, null, null, null, this, null, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoActionPerformed
        tabLlamadas.setEnabledAt(0, false);
        tabLlamadas.setEnabledAt(1, false);
        tabLlamadas.setEnabledAt(2, true);
        tabLlamadas.setSelectedIndex(2);
        this.listar(this.fechaHoySql);
        this.listar(null, null);
    }//GEN-LAST:event_btnListadoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtVendedor.getText().isEmpty()) {
            Comunes.mensaje("Debes ingresar un vendedor","warning");
            txtVendedorMo.requestFocus();
            return;
        }
        String medio = cboMedio.getSelectedItem().toString();
        String zona = cboZona.getSelectedItem().toString();
        String tipoOperacion = cboTipoOperacion.getSelectedItem().toString();
        int idVendedor = Integer.parseInt(txtIdVendedor.getText());
        String fecha = txtFecha.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        try {
            date = format.parse(fecha);
            long d = date.getTime();
            java.sql.Date fechaSql = new java.sql.Date(d);
            llamada = new Llamada(fechaSql, medio, zona, tipoOperacion, idVendedor);
            String respuesta = LLAMADA_CONTROL.nuevaLlamada(llamada);
            if (respuesta.equals("OK")) {
                Comunes.mensaje("Llamada registrada", "ok");
            } else {
                Comunes.mensaje(respuesta, "error");
            }
            this.limpiar();
            this.listar(fechaHoySql);
        } catch (ParseException ex) {
            Comunes.mensaje(ex.getMessage(), "error");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVendedorActionPerformed
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, null, null, null, null, this,null,null, true);
        frm.toFront();
    }//GEN-LAST:event_btnBuscarVendedorActionPerformed

    private void btnBuscarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTelefonoActionPerformed
        String telefono = txtNumeroTelefono.getText();
        if (!CLIENTE_CONTROL.existe(telefono)) {
            Comunes.mensaje("El cliente no está registrado", "ok");
        } else {
            String captador = CLIENTE_CONTROL.buscarComercial(telefono);
            Comunes.mensaje("El cliente ya está registrado a nombre de " + captador.toUpperCase(), "warning");
        }
    }//GEN-LAST:event_btnBuscarTelefonoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tablaLlamadas.getSelectedRowCount() == 1) {
            String idLlamada = String.valueOf(tablaLlamadas.getValueAt(tablaLlamadas.getSelectedRow(), 0));
            String medio = String.valueOf(tablaLlamadas.getValueAt(tablaLlamadas.getSelectedRow(), 2));
            String zona = String.valueOf(tablaLlamadas.getValueAt(tablaLlamadas.getSelectedRow(), 3));
            String tipoOperacion = String.valueOf(tablaLlamadas.getValueAt(tablaLlamadas.getSelectedRow(), 4));
            String vendedorId = String.valueOf(tablaLlamadas.getValueAt(tablaLlamadas.getSelectedRow(), 5));
            String vendedorNombre = String.valueOf(tablaLlamadas.getValueAt(tablaLlamadas.getSelectedRow(), 6));
            txtFechaM.setText(txtFecha.getText());
            txtMedioM.setText(medio);
            txtZonaM.setText(zona);
            txtTipoM.setText(tipoOperacion);
            txtIdLlamada.setText(idLlamada);
            txtIdVendedor.setText(vendedorId);
            txtVendedorM.setText(vendedorNombre);
            //ir a la pestaña de modificar
            tabLlamadas.setEnabledAt(0, false);
            tabLlamadas.setEnabledAt(1, true);
            tabLlamadas.setSelectedIndex(1);

        } else {
            Comunes.mensaje("Seleccione una llamada", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        jdcInicio.setDate(null);
        jdcFin.setDate(null);

        this.listar(null, null);

        tabLlamadas.setEnabledAt(0, true);
        tabLlamadas.setEnabledAt(1, false);
        tabLlamadas.setEnabledAt(2, false);
        tabLlamadas.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechasActionPerformed
        if (jdcInicio.getDate() == null || jdcFin.getDate() == null) {
            Comunes.mensaje("Debe selecionar un rango de fechas", "warning");
        } else if (jdcInicio.getDate().after(jdcFin.getDate())) {
            Comunes.mensaje("La fecha 'Desde' debe ser inferior a la fecha 'Hasta'", "warning");
        } else {
            Date date1 = jdcInicio.getDate();
            long dateInicio = date1.getTime();
            java.sql.Date dateInicioSql = new java.sql.Date(dateInicio);

            Date date2 = jdcFin.getDate();
            long dateFin = date2.getTime();
            java.sql.Date dateFinSql = new java.sql.Date(dateFin);

            listar(dateInicioSql, dateFinSql);
        }
    }//GEN-LAST:event_btnBuscarFechasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarFechas;
    private javax.swing.JButton btnBuscarTelefono;
    private javax.swing.JButton btnBuscarVendedor;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListado;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboMedio;
    private javax.swing.JComboBox<String> cboMedioM;
    private javax.swing.JComboBox<String> cboTipoOperacion;
    private javax.swing.JComboBox<String> cboTipoOperacionM;
    private javax.swing.JComboBox<String> cboZona;
    private javax.swing.JComboBox<String> cboZonaM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private com.toedter.calendar.JDateChooser jdcFin;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotones2;
    private javax.swing.JPanel panelBotones3;
    private javax.swing.JPanel panelFondo1;
    private javax.swing.JPanel panelFondo2;
    private javax.swing.JPanel panelFondo3;
    private javax.swing.JPanel panelFondoParcial3;
    private javax.swing.JPanel panelFormulario2;
    private javax.swing.JPanel panelLlamadas1;
    private javax.swing.JPanel panelLlamadasMedios3;
    private javax.swing.JPanel panelLlamadasVendedores3;
    private javax.swing.JPanel panelMedios1;
    private javax.swing.JPanel panelTablaLlamadas1;
    private javax.swing.JPanel panelTotalLlamadas3;
    private javax.swing.JPanel panelValoresAntiguos2;
    private javax.swing.JPanel panelValoresNuevos2;
    private javax.swing.JTabbedPane tabLlamadas;
    private javax.swing.JTable tablaLlamadas;
    private javax.swing.JTable tablaLlamadas2;
    private javax.swing.JTable tablaMedios;
    private javax.swing.JTable tablaMedios2;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTable tablaVendedores2;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaM;
    private javax.swing.JTextField txtIdLlamada;
    public javax.swing.JTextField txtIdVendedor;
    public javax.swing.JTextField txtIdVendedorMo;
    private javax.swing.JTextField txtMedioM;
    private javax.swing.JTextField txtNumeroTelefono;
    private javax.swing.JTextField txtNumeroTotal;
    private javax.swing.JTextField txtNumeroTotal2;
    private javax.swing.JTextField txtTipoM;
    public javax.swing.JTextField txtVendedor;
    private javax.swing.JTextField txtVendedorM;
    public javax.swing.JTextField txtVendedorMo;
    private javax.swing.JTextField txtZonaM;
    // End of variables declaration//GEN-END:variables
}
