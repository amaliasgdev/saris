package presentacion;

import entidades.Inmueble;
import negocio.EstadoInmuebleControl;
import javax.swing.JFrame;
import javax.swing.table.TableRowSorter;
import negocio.EmpleadoControl;
import negocio.InmuebleControl;
import presentacion.utiles.Comunes;

public class FrmListadoInmDisp extends javax.swing.JInternalFrame {

    private final InmuebleControl INMUEBLE_CONTROL;
    private final EstadoInmuebleControl ESTADO_CONTROL;
    private Inmueble inmueble;
    public JFrame contenedor;

    public FrmListadoInmDisp() {
        initComponents();
        INMUEBLE_CONTROL = new InmuebleControl();
        ESTADO_CONTROL = new EstadoInmuebleControl();
        tabInmuebles.setEnabledAt(1, false);
        txtId.setVisible(false);
        txtIdPropietario.setVisible(false);
        txtIdCaptador.setVisible(false);
        //ComboBox Primera Pestaña
        Comunes.llenarComboboxGenerico(Comunes.TIPO_INMUEBLE, cboTipoBuscar);
        Comunes.llenarComboboxGenerico(Comunes.PROVINCIA, cboProvinciaBuscar);
        Comunes.llenarComboboxGenerico(Comunes.LOCALIDAD_MADRID, cboLocalidadBuscar);
        Comunes.llenarComboboxGenerico(Comunes.ZONA, cboZonaBuscar);
        //ComboBox Segunda Pestaña        
        Comunes.llenarComboboxGenerico(Comunes.TIPO_INMUEBLE, cboTipoInmueble);
        Comunes.llenarComboboxGenerico(Comunes.PROVINCIA, cboProvincia);
        Comunes.llenarComboboxGenerico(Comunes.LOCALIDAD_MADRID, cboLocalidad);
        Comunes.llenarComboboxGenerico(Comunes.ZONA, cboZona);
        Comunes.llenarComboboxGenerico(Comunes.TIPO_OPERACION, cboTipoOperacion);
        Comunes.llenarComboboxEstados(ESTADO_CONTROL.listar(), cboEstado);
        this.listar("", "Disponible");
        if (EmpleadoControl.tipoAcceso != 6) { // Si no es el administrador no muestra el boton de eliminar
            btnEliminar.setVisible(false);
        }
    }

    private void listar(String texto, String disponibilidad) {
        tablaInmuebles.setModel(INMUEBLE_CONTROL.listar(texto, disponibilidad));
        TableRowSorter ordenable = new TableRowSorter(tablaInmuebles.getModel());
        tablaInmuebles.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 9, 11, 12, 13, 14, 15, 16};
        Comunes.ocultarColumnas(tablaInmuebles, columnasOcultas);
    }

    private void listar(String tipo, String provincia, String localidad, String zona, String disponibilidad) {
        tablaInmuebles.setModel(INMUEBLE_CONTROL.listar(tipo, provincia, localidad, zona, disponibilidad));
        TableRowSorter ordenable = new TableRowSorter(tablaInmuebles.getModel());
        tablaInmuebles.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 9, 11, 12, 13, 14, 15};
        Comunes.ocultarColumnas(tablaInmuebles, columnasOcultas);
    }   

    private void limpiar() {
        cboTipoInmueble.setSelectedIndex(0);
        txtDireccion.setText("");
        cboProvincia.setSelectedIndex(0);
        cboLocalidad.setSelectedIndex(0);
        cboZona.setSelectedIndex(0);
        cboTipoOperacion.setSelectedIndex(0);
        txtPrecioVenta.setText("");
        txtHonorarios.setText("");
        txtDniPropietario.setText("");
        cboEstado.setSelectedIndex(0);
        txtNombrePropietario.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabInmuebles = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInmuebles = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();
        btnDatosPropietario = new javax.swing.JButton();
        panelBusqueda = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cboTipoBuscar = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboProvinciaBuscar = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboLocalidadBuscar = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cboZonaBuscar = new javax.swing.JComboBox<>();
        btnIr = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelFormularioInmueble = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboTipoInmueble = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cboProvincia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboZona = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboTipoOperacion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtHonorarios = new javax.swing.JTextField();
        cboLocalidad = new javax.swing.JComboBox<>();
        jPanelFormularioProp = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnSeleccionarPropietario = new javax.swing.JButton();
        txtNombrePropietario = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtDniPropietario = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCaptador = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnVolverListado = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtIdPropietario = new javax.swing.JTextField();
        txtIdCaptador = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado Inmuebles Disponibles");

        tabInmuebles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE INMUEBLES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTabla.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaInmuebles.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInmuebles.setRowHeight(20);
        jScrollPane1.setViewportView(tablaInmuebles);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones.setMaximumSize(new java.awt.Dimension(176, 504));
        panelBotones.setMinimumSize(new java.awt.Dimension(176, 504));
        panelBotones.setPreferredSize(new java.awt.Dimension(176, 504));

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

        btnEliminar.setBackground(new java.awt.Color(250, 16, 20));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setBorderPainted(false);
        btnEliminar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnEliminar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnEliminar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        btnDatosPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnDatosPropietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/iconCliente.png"))); // NOI18N
        btnDatosPropietario.setText("Datos Propietario");
        btnDatosPropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnDatosPropietario.setBorderPainted(false);
        btnDatosPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosPropietarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDatosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDatosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BÚSQUEDA DE INMUEBLES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel15.setText("Tipo");

        cboTipoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setText("Provincia");

        cboProvinciaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setText("Localidad");

        cboLocalidadBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setText("Zona");

        cboZonaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        btnIr.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnIr.setText("Ir");
        btnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(5, 5, 5)
                .addComponent(cboTipoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(5, 5, 5)
                .addComponent(cboProvinciaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(5, 5, 5)
                .addComponent(cboLocalidadBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(5, 5, 5)
                .addComponent(cboZonaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnIr)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cboZonaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cboLocalidadBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cboProvinciaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cboTipoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        tabInmuebles.addTab("Listado", jPanel1);

        jPanel4.setLayout(null);
        jPanel4.add(jLabel2);
        jLabel2.setBounds(945, 29, 49, 0);

        panelFormularioInmueble.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS INMUEBLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelFormularioInmueble.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("Tipo Inmueble(*): ");

        cboTipoInmueble.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Dirección (*):");

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        cboProvincia.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Provincia (*):");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Zona (*):");

        cboZona.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("Localidad (*):");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Tipo Operación (*):");

        cboTipoOperacion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cboTipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Venta", "Alquiler" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Precio Venta (*):");

        txtPrecioVenta.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setText("Estado (*):");

        cboEstado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Honorarios (*):");

        txtHonorarios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        cboLocalidad.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout panelFormularioInmuebleLayout = new javax.swing.GroupLayout(panelFormularioInmueble);
        panelFormularioInmueble.setLayout(panelFormularioInmuebleLayout);
        panelFormularioInmuebleLayout.setHorizontalGroup(
            panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                        .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioInmuebleLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(43, 43, 43)
                                        .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelFormularioInmuebleLayout.setVerticalGroup(
            panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(15, 15, 15)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(cboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.add(panelFormularioInmueble);
        panelFormularioInmueble.setBounds(182, 21, 763, 210);

        jPanelFormularioProp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PROPIETARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanelFormularioProp.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel16.setText("DATOS PROPIETARIO");

        btnSeleccionarPropietario.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btnSeleccionarPropietario.setText("...");
        btnSeleccionarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPropietarioActionPerformed(evt);
            }
        });

        txtNombrePropietario.setEditable(false);
        txtNombrePropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtNombrePropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel30.setText("Nombre y Apellidos (*): ");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel31.setText("Número de Documento (*):");

        txtDniPropietario.setEditable(false);
        txtDniPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtDniPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel32.setText("Captador (*):");

        txtCaptador.setEditable(false);
        txtCaptador.setBackground(new java.awt.Color(204, 204, 204));
        txtCaptador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanelFormularioPropLayout = new javax.swing.GroupLayout(jPanelFormularioProp);
        jPanelFormularioProp.setLayout(jPanelFormularioPropLayout);
        jPanelFormularioPropLayout.setHorizontalGroup(
            jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioPropLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormularioPropLayout.createSequentialGroup()
                        .addComponent(txtDniPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarPropietario))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelFormularioPropLayout.setVerticalGroup(
            jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormularioPropLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(btnSeleccionarPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addGroup(jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFormularioPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDniPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jPanel4.add(jPanelFormularioProp);
        jPanelFormularioProp.setBounds(182, 249, 760, 161);

        jPanel5.setBackground(new java.awt.Color(46, 106, 141));
        jPanel5.setMaximumSize(new java.awt.Dimension(176, 402));
        jPanel5.setMinimumSize(new java.awt.Dimension(176, 402));
        jPanel5.setPreferredSize(new java.awt.Dimension(176, 544));

        btnVolverListado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnVolverListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/volver.png"))); // NOI18N
        btnVolverListado.setText("Volver al Listado");
        btnVolverListado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolverListado.setBorderPainted(false);
        btnVolverListado.setMaximumSize(new java.awt.Dimension(155, 41));
        btnVolverListado.setMinimumSize(new java.awt.Dimension(155, 41));
        btnVolverListado.setPreferredSize(new java.awt.Dimension(155, 41));
        btnVolverListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverListadoActionPerformed(evt);
            }
        });

        btnGuardarCambios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/guardar.png"))); // NOI18N
        btnGuardarCambios.setText("GuardarCambios");
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

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtIdPropietario.setEditable(false);
        txtIdPropietario.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N

        txtIdCaptador.setEditable(false);
        txtIdCaptador.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVolverListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtId)
                        .addGap(36, 36, 36)
                        .addComponent(txtIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCaptador, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtId, txtIdCaptador, txtIdPropietario});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnVolverListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(366, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5);
        jPanel5.setBounds(0, 0, 176, 630);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabInmuebles.addTab("Modificar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabInmuebles)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tabInmuebles, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtBuscar.getText(), "Disponible");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaInmuebles.getSelectedRowCount() == 1) {
            String idInmueble = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 0));
            String direccion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 2));
            if(Comunes.preguntar("Deseas eliminar el inmueble: " + direccion.toUpperCase() + " ?")){
                String resp = this.INMUEBLE_CONTROL.eliminarInmueble(Integer.parseInt(idInmueble));
                if (resp.equals("OK")) {
                    Comunes.mensaje("Inmueble eliminado correctamente", "ok");
                    this.listar("", "Disponible");
                } else {
                    Comunes.mensaje(resp, "error");
                }
            }
        } else {
            Comunes.mensaje("Seleccione un inmueble a eliminar", "error");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tablaInmuebles.getSelectedRowCount() == 1) {
            //Busco el String dentro del ComboBox y con un for (getPosicionComboBoxGenerico) busco la posicion y
            //situo el ComboBox de Modificar en la misma posicion
            String idInmueble = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 0));
            String tipoInmueble = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 1));
            int posiciontipoInmueble = Comunes.getPosicionComboBoxGenerico(Comunes.TIPO_INMUEBLE, tipoInmueble);
            String direccion = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 2));
            String provincia = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 3));
            int posicionProvincia = Comunes.getPosicionComboBoxGenerico(Comunes.PROVINCIA, provincia);
            String localidad = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 4));
            int posicionLocalidad = Comunes.getPosicionComboBoxGenerico(Comunes.LOCALIDAD_MADRID, localidad);
            String zona = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 5));
            int posicionZona = Comunes.getPosicionComboBoxGenerico(Comunes.ZONA, zona);
            String precioVenta = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 7));
            String honorarios = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 8));
            String idCaptador = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 9));
            String nombreCaptador = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 10));
            String idPropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 11));
            String dniPropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 12));
            String nombrePropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 13));
            String apellidosPropietario = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 14));
            String nombreCompletoProp = nombrePropietario + " " + apellidosPropietario;
            String estado = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 15));
            int posicionEstado = Comunes.getPosicionComboBoxEstados(ESTADO_CONTROL.listar(), estado);

            txtId.setText(idInmueble);
            cboTipoInmueble.setSelectedIndex(posiciontipoInmueble);
            txtDireccion.setText(direccion);
            cboLocalidad.setSelectedIndex(posicionLocalidad);
            cboProvincia.setSelectedIndex(posicionProvincia);
            cboZona.setSelectedIndex(posicionZona);
            txtPrecioVenta.setText(precioVenta);
            txtHonorarios.setText(honorarios);
            txtIdPropietario.setText(idPropietario);
            txtIdCaptador.setText(idCaptador);
            txtDniPropietario.setText(dniPropietario);
            txtNombrePropietario.setText(nombreCompletoProp);
            txtCaptador.setText(nombreCaptador);
            cboEstado.setSelectedIndex(posicionEstado);

            tabInmuebles.setEnabledAt(0, false);
            tabInmuebles.setEnabledAt(1, true);
            tabInmuebles.setSelectedIndex(1);
        } else {
            Comunes.mensaje("Seleccione un inmueble para modificar", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        this.listar("", "Disponible");
    }//GEN-LAST:event_btnDeseleccionarActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
        String tipoInmueble = cboTipoBuscar.getSelectedItem().toString();
        String provincia = cboProvinciaBuscar.getSelectedItem().toString();
        String localidad = cboLocalidadBuscar.getSelectedItem().toString();
        String zona = cboZonaBuscar.getSelectedItem().toString();
        this.listar(tipoInmueble, provincia, localidad, zona, "Disponible");
        if (tablaInmuebles.getRowCount() == 0) {
            Comunes.mensaje("No se ha encontrado ningún inmueble", "warning");
        }
    }//GEN-LAST:event_btnIrActionPerformed

    private void btnSeleccionarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPropietarioActionPerformed
        FrmSelecCliente frm = new FrmSelecCliente(contenedor, null, null, null, this, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarPropietarioActionPerformed

    private void btnVolverListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverListadoActionPerformed
        this.limpiar();
        tabInmuebles.setEnabledAt(0, true);
        tabInmuebles.setEnabledAt(1, false);
        tabInmuebles.setSelectedIndex(0);
        this.listar("", "Disponible");
    }//GEN-LAST:event_btnVolverListadoActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        if (txtDireccion.getText().trim().length() == 0 || txtDireccion.getText().length() > 75) {
            Comunes.mensaje("Debes ingresar una dirección y no debe ser mayor de 75 caracteres", "warning");
            txtDireccion.requestFocus();
            return;
        }
        if (txtNombrePropietario.getText().isEmpty()) { // Campo no obligatorio
            Comunes.mensaje("Debes elegir los datos del propietario", "warning");
            txtDireccion.requestFocus();
            return;
        }
        try {
            if (txtPrecioVenta.getText().trim().length() == 0) {
                Comunes.mensaje("Debes introducir un precio de venta", "warning");
                txtPrecioVenta.requestFocus();
                return;
            }
            //Comprobar que el precio es numérico
            String precioString = txtPrecioVenta.getText().trim();
            boolean esNumerico = Comunes.esNumerico(precioString);
            if (!esNumerico) {
                Comunes.mensaje("Debes introducir una cantidad numerico", "warning");
                txtPrecioVenta.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Comunes.mensaje("Debes introducir el precio en formato correcto", "warning");
            txtPrecioVenta.requestFocus();
            return;
        }
        try {
            if (txtHonorarios.getText().trim().length() == 0 || txtHonorarios.getText().length() > 13) {
                Comunes.mensaje("Debes ingresar los honorarios de la venta", "warning");
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
            txtPrecioVenta.requestFocus();
            return;
        }
        int idInmueble = Integer.parseInt(txtId.getText());
        String tipo = cboTipoInmueble.getSelectedItem().toString();
        String direccion = txtDireccion.getText();
        String provincia = cboProvincia.getSelectedItem().toString();
        String localidad = cboLocalidad.getSelectedItem().toString();
        String zona = cboZona.getSelectedItem().toString();
        String tipoOperacion = cboTipoOperacion.getSelectedItem().toString();
        double precioVenta = Double.valueOf(txtPrecioVenta.getText());
        double honorarios = Double.valueOf(txtHonorarios.getText());
        int idPropietario = Integer.parseInt(txtIdPropietario.getText());        
        String estadoString = cboEstado.getSelectedItem().toString();
        int estado = 0;
        if (estadoString.equals("Disponible")) {
            estado = 1;
        } else if (estadoString.equals("Vendido")) {
            estado = 2;
        } else if (estadoString.equals("Retirado")) {
            estado = 3;
        }

        inmueble = new Inmueble(idInmueble, tipo, direccion, provincia, localidad, zona, tipoOperacion, precioVenta, honorarios, idPropietario, estado);
        String respuesta = INMUEBLE_CONTROL.modificarInmueble(inmueble);

        if (respuesta.equals("OK")) {
            this.limpiar();
            Comunes.mensaje("Inmueble modificado correctamente", "ok");
            tabInmuebles.setEnabledAt(0, true);
            tabInmuebles.setEnabledAt(1, false);
            tabInmuebles.setSelectedIndex(0);
            this.listar("", "Disponible");
        } else {
            Comunes.mensaje(respuesta, "error");
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnDatosPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosPropietarioActionPerformed
        if (tablaInmuebles.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 11));
            int idPropietario = Integer.parseInt(id);
            FrmDatosPropietario frm = new FrmDatosPropietario(contenedor, null, this, null, idPropietario, true);
            frm.toFront();
        } else {
            Comunes.mensaje("Seleccione un inmueble", "error");
        }
    }//GEN-LAST:event_btnDatosPropietarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDatosPropietario;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnIr;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionarPropietario;
    private javax.swing.JButton btnVolverListado;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboLocalidad;
    private javax.swing.JComboBox<String> cboLocalidadBuscar;
    private javax.swing.JComboBox<String> cboProvincia;
    private javax.swing.JComboBox<String> cboProvinciaBuscar;
    private javax.swing.JComboBox<String> cboTipoBuscar;
    private javax.swing.JComboBox<String> cboTipoInmueble;
    private javax.swing.JComboBox<String> cboTipoOperacion;
    private javax.swing.JComboBox<String> cboZona;
    private javax.swing.JComboBox<String> cboZonaBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelFormularioProp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelFormularioInmueble;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTabbedPane tabInmuebles;
    private javax.swing.JTable tablaInmuebles;
    private javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCaptador;
    private javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtDniPropietario;
    private javax.swing.JTextField txtHonorarios;
    private javax.swing.JTextField txtId;
    public javax.swing.JTextField txtIdCaptador;
    public javax.swing.JTextField txtIdPropietario;
    public javax.swing.JTextField txtNombrePropietario;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
