package presentacion;

import entidades.Cliente;
import javax.swing.JFrame;
import javax.swing.table.TableRowSorter;
import negocio.ClienteControl;
import negocio.EmpleadoControl;
import negocio.TipoClienteControl;
import presentacion.utiles.Comunes;

public class FrmListadoClientes extends javax.swing.JInternalFrame {

    private final ClienteControl CLIENTE_CONTROL;
    private final TipoClienteControl TIPO_CONTROL;
    private Cliente cliente;
    public JFrame contenedor;

    public FrmListadoClientes() {
        initComponents();
        CLIENTE_CONTROL = new ClienteControl();
        TIPO_CONTROL = new TipoClienteControl();
        Comunes.llenarComboboxTipos(TIPO_CONTROL.listar(), cboTipoCliente);
        tabClientes.setEnabledAt(1, false);
        Comunes.llenarComboboxGenerico(Comunes.TIPO_DOCUMENTO, cboTipoDocumento);
        this.listar("");
        txtIdCaptador.setVisible(false);
        txtId.setVisible(false);
        if (EmpleadoControl.tipoAcceso != 6) { // Si no es el administrador no muestra el boton de eliminar
            btnEliminar.setVisible(false);
        }
    }

    private void listar(String texto) {
        tablaPersonas.setModel(CLIENTE_CONTROL.listar(texto));
        TableRowSorter ordenable = new TableRowSorter(tablaPersonas.getModel());
        tablaPersonas.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 9};
        Comunes.ocultarColumnas(tablaPersonas, columnasOcultas);
    }

    private void limpiar() {
        txtId.setText("");
        cboTipoCliente.setSelectedIndex(0);
        txtNombre.setText("");
        txtApellidos.setText("");
        cboTipoDocumento.setSelectedIndex(0);
        txtNumeroDocumento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtCaptador.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabClientes = new javax.swing.JTabbedPane();
        panelFondo1 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        txtNombreBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        panelFondo2 = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cboTipoCliente = new javax.swing.JComboBox<>();
        txtCaptador = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboTipoDocumento = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroDocumento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblComercial = new javax.swing.JLabel();
        panelBotones2 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtIdCaptador = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado Clientes");

        tabClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones.setPreferredSize(new java.awt.Dimension(176, 402));

        txtNombreBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombreBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Búsqueda:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setBorderPainted(false);
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("(Por nombre, apellidos, dni,");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setText("tipo cliente, teléfono)");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(13, 13, 13)
                .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE CLIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTabla.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaPersonas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPersonas.setRowHeight(20);
        jScrollPane1.setViewportView(tablaPersonas);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelFondo1Layout = new javax.swing.GroupLayout(panelFondo1);
        panelFondo1.setLayout(panelFondo1Layout);
        panelFondo1Layout.setHorizontalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFondo1Layout.setVerticalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );

        tabClientes.addTab("Listado", panelFondo1);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Tipo de Cliente (*):");

        cboTipoCliente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtCaptador.setEditable(false);
        txtCaptador.setBackground(new java.awt.Color(204, 204, 204));
        txtCaptador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtCaptador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionar.setText("...");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Nombre (*):");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Apellidos (*):");

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtApellidos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Tipo Documento:");

        cboTipoDocumento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Número de Documento:");

        txtNumeroDocumento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroDocumento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("Dirección:");

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDireccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Teléfono (*):");

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblComercial.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblComercial.setText("Captador (*):");

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(lblComercial)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFormularioLayout.createSequentialGroup()
                                .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblComercial))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelBotones2.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones2.setPreferredSize(new java.awt.Dimension(176, 402));

        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/volver.png"))); // NOI18N
        btnAtras.setText("Volver al Listado");
        btnAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtras.setBorderPainted(false);
        btnAtras.setMaximumSize(new java.awt.Dimension(155, 41));
        btnAtras.setMinimumSize(new java.awt.Dimension(155, 41));
        btnAtras.setPreferredSize(new java.awt.Dimension(155, 41));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

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

        txtIdCaptador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelBotones2Layout = new javax.swing.GroupLayout(panelBotones2);
        panelBotones2.setLayout(panelBotones2Layout);
        panelBotones2Layout.setHorizontalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotones2Layout.createSequentialGroup()
                        .addComponent(txtIdCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotones2Layout.createSequentialGroup()
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))
                        .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotones2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtId, txtIdCaptador});

        panelBotones2Layout.setVerticalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(317, Short.MAX_VALUE))
        );

        panelBotones2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtId, txtIdCaptador});

        javax.swing.GroupLayout panelFondo2Layout = new javax.swing.GroupLayout(panelFondo2);
        panelFondo2.setLayout(panelFondo2Layout);
        panelFondo2Layout.setHorizontalGroup(
            panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo2Layout.createSequentialGroup()
                .addComponent(panelBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        panelFondo2Layout.setVerticalGroup(
            panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo2Layout.createSequentialGroup()
                .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
            .addComponent(panelBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );

        tabClientes.addTab("Modificar", panelFondo2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabClientes)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabClientes)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtNombreBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaPersonas.getSelectedRowCount() == 1) {
            String idPersona = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 1));
            String apellidos = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 2));
            if (Comunes.preguntar("Desea eliminar al cliente: " + nombre.toUpperCase() + " " + apellidos.toUpperCase() + "?")) {
                String resp = this.CLIENTE_CONTROL.eliminarCliente(Integer.parseInt(idPersona));
                if (resp.equals("OK")) {
                    Comunes.mensaje("Cliente eliminado", "ok");
                    this.listar("");
                } else {
                    Comunes.mensaje(resp, "error");
                }
            }
        } else {
            Comunes.mensaje("Seleccione un cliente a eliminar", "error");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        txtNumeroDocumento.setText("Desconocido");
        txtDireccion.setText("Desconocido");
        txtEmail.setText("Desconocido");
        if (tablaPersonas.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 1));
            String apellidos = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 2));
            String numeroDocumento = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 4));
            String direccion = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 6));
            String email = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 7));
            String telefono = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 8));
            String captador = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 10));
            String idCaptador = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 9));
            String tipoCliente = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 5));
            int posicionTipoCliente = Comunes.getPosicionComboBoxTipos(TIPO_CONTROL.listar(), tipoCliente);
            String tipoDocumento = String.valueOf(tablaPersonas.getValueAt(tablaPersonas.getSelectedRow(), 3));
            int posicionTipoDocumento = Comunes.getPosicionComboBoxGenerico(Comunes.TIPO_DOCUMENTO, tipoDocumento);

            txtId.setText(id);
            txtNombre.setText(nombre);
            txtApellidos.setText(apellidos);
            txtNumeroDocumento.setText(numeroDocumento);
            txtDireccion.setText(direccion);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            txtCaptador.setText(captador);
            txtIdCaptador.setText(idCaptador);
            cboTipoCliente.setSelectedIndex(posicionTipoCliente);
            cboTipoDocumento.setSelectedIndex(posicionTipoDocumento);

            tabClientes.setEnabledAt(0, false);
            tabClientes.setEnabledAt(1, true);
            tabClientes.setSelectedIndex(1);
        } else {
            Comunes.mensaje("Seleccione un cliente para actualizar", "error");
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        limpiar();
        tabClientes.setEnabledAt(0, true);
        tabClientes.setEnabledAt(1, false);
        tabClientes.setSelectedIndex(0);
        this.listar("");
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtNombre.getText().trim().length() == 0 || txtNombre.getText().length() > 25) {
            Comunes.mensaje("Debes ingresar un nombre y no debe ser mayor de 25 caracteres", "warning");
            txtNombre.requestFocus();
            return;
        }
        if (txtApellidos.getText().trim().length() == 0 || txtApellidos.getText().length() > 45) {
            Comunes.mensaje("Debes ingresar los apellidos y no deben ser mayor de 45 caracteres", "warning");
            txtApellidos.requestFocus();
            return;
        }
        if (txtNumeroDocumento.getText().length() > 15) { // Campo no obligatorio
            Comunes.mensaje("El número de documento no debe ser mayor de 15 caracteres", "warning");
            txtNumeroDocumento.requestFocus();
            return;
        }
        if (txtDireccion.getText().length() > 75) { // Campo no obligatorio
            Comunes.mensaje("La dirección no debe ser mayor de 75 caracteres", "warning");
            txtDireccion.requestFocus();
            return;
        }
        if (txtEmail.getText().length() > 30) {// Campo no obligatorio
            Comunes.mensaje("El email no debe ser mayor de 30 caracteres", "warning");
            txtEmail.requestFocus();
            return;
        }
        if (txtTelefono.getText().trim().length() == 0 || txtTelefono.getText().length() > 9) {
            Comunes.mensaje("Debes ingresar un telefono y no debe ser mayor de 9 caracteres", "warning");
            txtTelefono.requestFocus();
            return;
        }
        if (txtCaptador.getText().isEmpty()) {
            Comunes.mensaje("Debes ingresar un captador", "warning");
            txtCaptador.requestFocus();
            return;
        }
        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String tipoDocumento = cboTipoDocumento.getSelectedItem().toString();
        String numeroDocumento = txtNumeroDocumento.getText();
        String tipo = cboTipoCliente.getSelectedItem().toString();
        int tipoPersona = 0;
        if (tipo.equals("Propietario")) {
            tipoPersona = 1;
        } else if (tipo.equals("Comprador")) {
            tipoPersona = 1;
        }
        String direccion = txtDireccion.getText();
        String email = txtEmail.getText();
        String telefono = txtTelefono.getText();
        int idComercial = Integer.parseInt(txtIdCaptador.getText());

        cliente = new Cliente(nombre, apellidos, tipoDocumento, numeroDocumento, tipoPersona, direccion, email, telefono, idComercial);
        String resp = CLIENTE_CONTROL.modificarCliente(cliente);
        
        if (resp.equals("OK")) {
            Comunes.mensaje("Cliente actualizado correctamente", "ok");
            tabClientes.setEnabledAt(0, true);
            tabClientes.setEnabledAt(1, false);
            tabClientes.setSelectedIndex(0);
            this.listar("");
        } else {
            Comunes.mensaje(resp, "error");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, null, this, null, null, null, null, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        this.listar("");
    }//GEN-LAST:event_btnDeseleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cboTipoCliente;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblComercial;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotones2;
    private javax.swing.JPanel panelFondo1;
    private javax.swing.JPanel panelFondo2;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTabbedPane tabClientes;
    private javax.swing.JTable tablaPersonas;
    private javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCaptador;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    public javax.swing.JTextField txtIdCaptador;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreBuscar;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
