package presentacion;

import entidades.Empleado;
import javax.swing.JFrame;
import javax.swing.table.TableRowSorter;
import negocio.EmpleadoControl;
import presentacion.utiles.Comunes;

public class FrmListadoEmpleados extends javax.swing.JInternalFrame {

    private final EmpleadoControl EMPLEADO_CONTROL;
    private Empleado empleado;
    public JFrame contenedor;

    public FrmListadoEmpleados() {
        initComponents();
        EMPLEADO_CONTROL = new EmpleadoControl();
        this.listar("");
        tabUsuarios.setEnabledAt(1, false);
        txtIdUsuario.setVisible(false);
        txtIdDepartamento.setVisible(false);
        txtIdJefe.setVisible(false);
        if (EmpleadoControl.tipoAcceso != 6) { // Si no es el administrador no muestra el boton de eliminar
            btnEliminar.setVisible(false);
        }
        if (EmpleadoControl.tipoAcceso != 1 && EmpleadoControl.tipoAcceso != 3 && EmpleadoControl.tipoAcceso != 6) { // si no es administrador,director o contabilidad
            btnModificar.setVisible(false);
        }
    }

    private void listar(String texto) {
        tablaEmpleados.setModel(EMPLEADO_CONTROL.listar(texto));
        TableRowSorter ordenable = new TableRowSorter(tablaEmpleados.getModel());
        tablaEmpleados.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 6, 8, 9};
        Comunes.ocultarColumnas(tablaEmpleados, columnasOcultas);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtExtension.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtJefe.setText("");
        txtDepartamento.setText("");
        txtIdDepartamento.setText("");
        txtIdUsuario.setText("");
        txtIdJefe.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabUsuarios = new javax.swing.JTabbedPane();
        panelFondo1 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        panelFondo2 = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtExtension = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        btnSelecDepartamento = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtJefe = new javax.swing.JTextField();
        btnSeleccionarJefe = new javax.swing.JButton();
        panelBotones2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        txtIdDepartamento = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();
        txtIdJefe = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado Empleados");

        tabUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones.setPreferredSize(new java.awt.Dimension(176, 402));
        panelBotones.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Búsqueda(*):");
        panelBotones.add(jLabel1);
        jLabel1.setBounds(10, 20, 150, 20);

        txtNombreBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombreBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNombreBuscar.setMaximumSize(new java.awt.Dimension(5, 18));
        panelBotones.add(txtNombreBuscar);
        txtNombreBuscar.setBounds(10, 70, 150, 27);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("(*Nombre, apellidos o dpto)");
        panelBotones.add(jLabel7);
        jLabel7.setBounds(10, 40, 160, 20);

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
        panelBotones.add(btnBuscar);
        btnBuscar.setBounds(10, 120, 155, 41);

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
        btnModificar.setBounds(10, 240, 155, 41);

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
        panelBotones.add(btnEliminar);
        btnEliminar.setBounds(10, 300, 155, 41);

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
        panelBotones.add(btnDeseleccionar);
        btnDeseleccionar.setBounds(10, 180, 155, 41);

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE EMPLEADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTabla.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaEmpleados.setRowHeight(20);
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelFondo1Layout = new javax.swing.GroupLayout(panelFondo1);
        panelFondo1.setLayout(panelFondo1Layout);
        panelFondo1Layout.setHorizontalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo1Layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFondo1Layout.setVerticalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabUsuarios.addTab("Listado", panelFondo1);

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNombre.setMaximumSize(new java.awt.Dimension(5, 18));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Nombre(*):");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Apellidos(*):");

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtApellidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Teléfono(*):");

        txtExtension.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtExtension.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Teléfono(*):");

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Email(*):");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Departamento(*):");

        txtDepartamento.setEditable(false);
        txtDepartamento.setBackground(new java.awt.Color(204, 204, 204));
        txtDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSelecDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSelecDepartamento.setText("...");
        btnSelecDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecDepartamentoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("Jefe Departamento:");

        txtJefe.setEditable(false);
        txtJefe.setBackground(new java.awt.Color(204, 204, 204));
        txtJefe.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtJefe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSeleccionarJefe.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarJefe.setText("...");
        btnSeleccionarJefe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSeleccionarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarJefeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtJefe, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelecDepartamento)
                            .addComponent(btnSeleccionarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        panelFormularioLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDepartamento, txtJefe});

        panelFormularioLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSelecDepartamento, btnSeleccionarJefe});

        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(btnSelecDepartamento)
                        .addGap(41, 41, 41))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSeleccionarJefe))
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormularioLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDepartamento, txtJefe});

        panelFormularioLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSelecDepartamento, btnSeleccionarJefe});

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

        txtIdDepartamento.setEditable(false);
        txtIdDepartamento.setBackground(new java.awt.Color(255, 255, 255));
        txtIdDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtIdUsuario.setEditable(false);
        txtIdUsuario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtIdJefe.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

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
                        .addGap(18, 18, 18)
                        .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBotones2Layout.createSequentialGroup()
                                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotones2Layout.setVerticalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotones2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addGroup(panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );

        javax.swing.GroupLayout panelFondo2Layout = new javax.swing.GroupLayout(panelFondo2);
        panelFondo2.setLayout(panelFondo2Layout);
        panelFondo2Layout.setHorizontalGroup(
            panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo2Layout.createSequentialGroup()
                .addComponent(panelBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(676, 676, 676))
        );
        panelFondo2Layout.setVerticalGroup(
            panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelBotones2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        tabUsuarios.addTab("Modificar", panelFondo2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabUsuarios)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.limpiar();
        tabUsuarios.setEnabledAt(0, true);
        tabUsuarios.setEnabledAt(1, false);
        tabUsuarios.setSelectedIndex(0);
        this.listar("");
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtDepartamento.getText().isEmpty()) {
            Comunes.mensaje("Debes ingresar un departamento", "warning");
            txtDepartamento.requestFocus();
            return;
        }
        if (txtNombre.getText().trim().length() == 0 || txtNombre.getText().length() > 25) {
            Comunes.mensaje("Debes ingresar un nombre y no debe ser mayor de 25 caracteres", "warning");
            txtNombre.requestFocus();
            return;
        }
        if (txtApellidos.getText().trim().length() == 0 || txtApellidos.getText().length() > 45) {
            Comunes.mensaje("Debes ingresar los apellidos y no deben ser mayores de 45 caracteres", "warning");
            txtApellidos.requestFocus();
            return;
        }
        if (txtEmail.getText().trim().length() == 0 || txtEmail.getText().length() > 9) {
            Comunes.mensaje("Debes ingresar telefono y no debe ser mayor de 9 caracteres", "warning");
            txtEmail.requestFocus();
            return;
        }
        if (txtExtension.getText().trim().length() == 0 || txtExtension.getText().length() > 3) {
            Comunes.mensaje("Debes ingresar una extension y no debe ser mayor de 3 caracteres", "warning");
            txtExtension.requestFocus();
            return;
        }
        if (txtTelefono.getText().trim().length() == 0 || txtTelefono.getText().length() > 30) {
            Comunes.mensaje("Debes ingresar un email y no debe ser mayor de 30 caracteres", "warning");
            txtTelefono.requestFocus();
            return;
        }
        int idUsuario = Integer.parseInt(txtIdUsuario.getText());
        int idDepartamento = Integer.parseInt(txtIdDepartamento.getText());
        String nombreUsuario = txtNombre.getText();
        String apellidosUsuario = txtApellidos.getText();
        String telefono = txtEmail.getText();
        String extension = txtExtension.getText();
        String email = txtTelefono.getText();
        int jefeId = Integer.parseInt(txtIdJefe.getText());
        empleado = new Empleado(idUsuario, idDepartamento, nombreUsuario, apellidosUsuario, telefono,
                extension, email, jefeId);
        String respuesta;
        if (txtJefe.getText().isEmpty()) {
            respuesta = EMPLEADO_CONTROL.modificarEmpleado(empleado);
        } else {
            respuesta = EMPLEADO_CONTROL.modificarEmpleadoJefe(empleado);
        }
        if (respuesta.equals("OK")) {
            Comunes.mensaje("Empleado actualizado correctamente", "ok");
            limpiar();
            tabUsuarios.setEnabledAt(0, true);
            tabUsuarios.setEnabledAt(1, false);
            tabUsuarios.setSelectedIndex(0);
            this.listar("");
            this.limpiar();
        } else {
            Comunes.mensaje(respuesta, "error");
        }        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_btnDeseleccionarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tablaEmpleados.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
            int idUsuario = Integer.valueOf(id);
            String nombre = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
            String apellidos = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
            String extension = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 3));
            String email = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 4));
            String telefono = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 5));
            String idDepartamentoString = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 6));
            int idDepartamento = Integer.valueOf(idDepartamentoString);
            String idJefeString = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 8));
            int idJefe = Integer.valueOf(idJefeString);
            String nombreUsuario = nombre + " " + apellidos;
            empleado = new Empleado(idUsuario, idDepartamento, nombre, apellidos, telefono, extension,
                        email, idJefe);
            if (Comunes.preguntar("Deseas eliminar al trabajador: " + nombreUsuario.toUpperCase() + " ?")) {
                String resp = EMPLEADO_CONTROL.eliminarEmpleado(empleado);
                if (resp.equals("OK")) {
                    Comunes.mensaje("Trabajador eliminado correctamente", "ok");
                    this.listar("");
                } else {
                    Comunes.mensaje(resp, "error");
                }
            }
        } else {
            Comunes.mensaje("Seleccione un trabajador a eliminar", "warning");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (tablaEmpleados.getSelectedRowCount() == 1) {
            String idUsuario = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1));
            String apellidos = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2));
            String extension = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 3));
            String email = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 4));
            String telefono = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 5));
            String idDepartamento = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 6));
            String departamento = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 7));
            String idJefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 8));
            String jefe = String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 9));

            txtIdUsuario.setText(idUsuario);
            txtNombre.setText(nombre);
            txtApellidos.setText(apellidos);
            txtExtension.setText(extension);
            txtEmail.setText(telefono);
            txtTelefono.setText(email);
            txtIdDepartamento.setText(idDepartamento);
            txtDepartamento.setText(departamento);
            txtIdJefe.setText(idJefe);
            txtJefe.setText(jefe);

            tabUsuarios.setEnabledAt(0, false);
            tabUsuarios.setEnabledAt(1, true);
            tabUsuarios.setSelectedIndex(1);
        } else {
            Comunes.mensaje("Seleccione un empleado para actualizar", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        this.listar(txtNombreBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarJefeActionPerformed
        // TODO add your handling code here:
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, null, null, null, null, null, null, this, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarJefeActionPerformed

    private void btnSelecDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecDepartamentoActionPerformed
        // TODO add your handling code here:
        FrmSelecDpto frm = new FrmSelecDpto(contenedor, null, this, true);
        frm.toFront();
    }//GEN-LAST:event_btnSelecDepartamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSelecDepartamento;
    private javax.swing.JButton btnSeleccionarJefe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotones2;
    private javax.swing.JPanel panelFondo1;
    private javax.swing.JPanel panelFondo2;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTabbedPane tabUsuarios;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtExtension;
    public javax.swing.JTextField txtIdDepartamento;
    public javax.swing.JTextField txtIdJefe;
    private javax.swing.JTextField txtIdUsuario;
    public javax.swing.JTextField txtJefe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreBuscar;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
