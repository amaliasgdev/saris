package presentacion;

import entidades.Departamento;
import javax.swing.JFrame;
import javax.swing.table.TableRowSorter;
import negocio.DepartamentoControl;
import negocio.EmpleadoControl;
import presentacion.utiles.Comunes;

public class FrmListadoDptos extends javax.swing.JInternalFrame {

    private final DepartamentoControl DEPARTAMENTO_CONTROL;
    private Departamento departamento;
    public JFrame contenedor;

    public FrmListadoDptos() {
        initComponents();
        DEPARTAMENTO_CONTROL = new DepartamentoControl();
        txtIdDepartamento.setVisible(false);
        txtIdAcceso.setVisible(false);
        tabDepartamentos.setEnabledAt(1, false);
        this.listar("");
        if (EmpleadoControl.tipoAcceso != 6) { // Si no es el administrador no muestra el boton de eliminar
            btnEliminar.setVisible(false);
        }
    }

    private void listar(String texto) {
        tablaDepartamentos.setModel(DEPARTAMENTO_CONTROL.listar(texto));
        //Para que la tabla sea ordenable haciendo click en la cabecera de las columnas 
        TableRowSorter ordenable = new TableRowSorter(tablaDepartamentos.getModel());
        tablaDepartamentos.setRowSorter(ordenable);
        int[] columnasOcultas = {0, 2};
        Comunes.ocultarColumnas(tablaDepartamentos, columnasOcultas);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtTipoAcceso.setText("");
        txtPorcentaje.setText("");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabDepartamentos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDepartamentos = new javax.swing.JTable();
        panelFondo2 = new javax.swing.JPanel();
        panelBotonesM = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        txtIdDepartamento = new javax.swing.JTextField();
        txtIdAcceso = new javax.swing.JTextField();
        panelFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTipoAcceso = new javax.swing.JTextField();
        txtPorcentaje = new javax.swing.JTextField();
        btnAcceso = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Departamentos");
        setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        tabDepartamentos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones.setPreferredSize(new java.awt.Dimension(176, 402));

        txtBusqueda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        lblBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBusqueda.setText("Búsqueda:");

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

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelBotonesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscar, btnDeseleccionar, btnEliminar, btnModificar});

        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnDeseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelBotonesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscar, btnDeseleccionar, btnEliminar, btnModificar});

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTADO DE DEPARTAMENTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelTabla.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        tablaDepartamentos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaDepartamentos.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {} ){

        }
    );
    tablaDepartamentos.setRowHeight(20);
    jScrollPane2.setViewportView(tablaDepartamentos);

    javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
    panelTabla.setLayout(panelTablaLayout);
    panelTablaLayout.setHorizontalGroup(
        panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelTablaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addContainerGap())
    );
    panelTablaLayout.setVerticalGroup(
        panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelTablaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
            .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    tabDepartamentos.addTab("Listado", jPanel2);

    panelBotonesM.setBackground(new java.awt.Color(46, 106, 141));
    panelBotonesM.setPreferredSize(new java.awt.Dimension(176, 402));

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

    txtIdDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtIdDepartamento.setEnabled(false);

    txtIdAcceso.setEditable(false);
    txtIdAcceso.setBackground(new java.awt.Color(204, 204, 204));
    txtIdAcceso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

    javax.swing.GroupLayout panelBotonesMLayout = new javax.swing.GroupLayout(panelBotonesM);
    panelBotonesM.setLayout(panelBotonesMLayout);
    panelBotonesMLayout.setHorizontalGroup(
        panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBotonesMLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtIdAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(52, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesMLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAtras))
            .addContainerGap())
    );

    panelBotonesMLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnAtras});

    panelBotonesMLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtIdAcceso, txtIdDepartamento});

    panelBotonesMLayout.setVerticalGroup(
        panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBotonesMLayout.createSequentialGroup()
            .addGap(36, 36, 36)
            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(25, 25, 25)
            .addComponent(btnAtras)
            .addGap(92, 92, 92)
            .addGroup(panelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtIdAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(129, Short.MAX_VALUE))
    );

    panelBotonesMLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnActualizar, btnAtras});

    panelBotonesMLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtIdAcceso, txtIdDepartamento});

    lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    lblNombre.setText("Nombre(*):");

    lblAcceso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    lblAcceso.setText("Tipo Acceso(*):");

    lblPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    lblPorcentaje.setText("Porcentaje(*):");

    txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    txtTipoAcceso.setEditable(false);
    txtTipoAcceso.setBackground(new java.awt.Color(204, 204, 204));
    txtTipoAcceso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtTipoAcceso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    txtPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    txtPorcentaje.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    btnAcceso.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
    btnAcceso.setText("...");
    btnAcceso.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAccesoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
    panelFormulario.setLayout(panelFormularioLayout);
    panelFormularioLayout.setHorizontalGroup(
        panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelFormularioLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblPorcentaje)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAcceso))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtTipoAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(btnAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(70, Short.MAX_VALUE))
    );
    panelFormularioLayout.setVerticalGroup(
        panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelFormularioLayout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombre)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblAcceso)
                .addComponent(txtTipoAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAcceso))
            .addGap(22, 22, 22)
            .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblPorcentaje)
                .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(50, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout panelFondo2Layout = new javax.swing.GroupLayout(panelFondo2);
    panelFondo2.setLayout(panelFondo2Layout);
    panelFondo2Layout.setHorizontalGroup(
        panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelFondo2Layout.createSequentialGroup()
            .addComponent(panelBotonesM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 141, Short.MAX_VALUE))
    );
    panelFondo2Layout.setVerticalGroup(
        panelFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelBotonesM, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        .addGroup(panelFondo2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    tabDepartamentos.addTab("Modificar", panelFondo2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabDepartamentos)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaDepartamentos.getSelectedRowCount() == 1) {
            String idDepartamento = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 0));
            int idDpto = Integer.parseInt(idDepartamento);
            String nombreDepartamento = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 1));
            String rol = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 2));
            int idRol = Integer.valueOf(rol);
            String porcentajeString = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 4));
            float porcentaje = Float.parseFloat(porcentajeString);
            
            //si la respuesta es 0 es que SI (indice 0)            
            if(Comunes.preguntar("Deseas eliminar el departamento : " + nombreDepartamento.toUpperCase() + " ?")){
                departamento = new Departamento(idDpto, nombreDepartamento, idRol, porcentaje);
                String resp = this.DEPARTAMENTO_CONTROL.eliminarDepartamento(departamento);
                if (resp.equals("OK")) {
                    Comunes.mensaje("Departamento eliminado correctamente", "ok");
                    this.listar("");
                } else {
                    Comunes.mensaje(resp, "error");
                }
            }
        } else {
            Comunes.mensaje("Seleccione un departamento", "error");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tablaDepartamentos.getSelectedRowCount() == 1) {
            String idDepartamento = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 1));
            String idAcceso = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 2));
            String tipoAcceso = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 3));
            String porcentaje = String.valueOf(tablaDepartamentos.getValueAt(tablaDepartamentos.getSelectedRow(), 4));
            txtIdDepartamento.setText(idDepartamento);
            txtIdAcceso.setText(idAcceso);
            txtTipoAcceso.setText(tipoAcceso);
            txtNombre.setText(nombre);
            txtPorcentaje.setText(porcentaje);

            tabDepartamentos.setEnabledAt(0, false);
            tabDepartamentos.setEnabledAt(1, true);
            tabDepartamentos.setSelectedIndex(1);

        } else {
            Comunes.mensaje("Seleccione un departamento", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtBusqueda.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        this.listar("");
    }//GEN-LAST:event_btnDeseleccionarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Validaciones
        if (txtNombre.getText().trim().length() == 0 || txtNombre.getText().length() > 25) {
            Comunes.mensaje("Debes ingresar el nombre del departamento y no debe ser mayor de 25 caracteres", "warning");
            txtNombre.requestFocus();
            return;
        }
        if (txtTipoAcceso.getText().length() == 0) {
            Comunes.mensaje("Debes introdcir un tipo de acceso", "warning");
            txtNombre.requestFocus();
            return;
        }
        //Comprobacion que el porcentaje es numerico, no este vacio, no sea más de porcentaje max
        //Comprobar que no esté vacío
        try {
            if (txtPorcentaje.getText().trim().length() == 0) {
                Comunes.mensaje("Debes introducir un porcentaje", "warning");
                txtPorcentaje.requestFocus();
                return;
            }
            //Comprobar que el porcentaje es numérico
            String porcentajeString = txtPorcentaje.getText().trim();
            boolean esNumerico = Comunes.esNumerico(porcentajeString);
            if (!esNumerico) {
                Comunes.mensaje("Debes introducir un porcentaje numerico", "warning");
                txtPorcentaje.requestFocus();
                return;
            }
            if (txtPorcentaje.getText().trim().length() > 4 || Float.valueOf(txtPorcentaje.getText().trim()) > Comunes.PORCENTAJE_MAXIMO) {
                Comunes.mensaje("Debes introducir un porcentaje correcto\nMáximo pocentaje: " + Comunes.PORCENTAJE_MAXIMO, "warning");
                txtPorcentaje.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Comunes.mensaje("Debes introducir un porcentaje correcto. Formato: XX.XX ", "warning");
            txtPorcentaje.requestFocus();
            return;
        }
        int idDepartamento = Integer.parseInt(txtIdDepartamento.getText());
        String nombreDepartamento = txtNombre.getText().trim();
        int idRol = Integer.parseInt(txtIdAcceso.getText());
        float porcentaje = Float.parseFloat(txtPorcentaje.getText().trim());

        departamento = new Departamento(idDepartamento, nombreDepartamento, idRol, porcentaje);
        String resultado = DEPARTAMENTO_CONTROL.modificarDepartamento(departamento);
        if (resultado.equals("OK")) {
            this.listar("");
            Comunes.mensaje("Departamento registrado correctamente", "ok");
            tabDepartamentos.setEnabledAt(0, true);
            tabDepartamentos.setEnabledAt(1, false);
            tabDepartamentos.setSelectedIndex(0);
        } else if (resultado.equals("El departamento ya existe")) {
            Comunes.mensaje("Ya hay un departamento con ese nombre", "warning");
        } else {
            Comunes.mensaje("Error al registrar el departamento", "error");
        }
        limpiar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        tabDepartamentos.setEnabledAt(0, true);
        tabDepartamentos.setEnabledAt(1, false);
        tabDepartamentos.setSelectedIndex(0);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccesoActionPerformed
        FrmSelecRol frm = new FrmSelecRol(contenedor, null, this, true);
        frm.toFront();
    }//GEN-LAST:event_btnAccesoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceso;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotonesM;
    private javax.swing.JPanel panelFondo2;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTabbedPane tabDepartamentos;
    private javax.swing.JTable tablaDepartamentos;
    private javax.swing.JTextField txtBusqueda;
    public javax.swing.JTextField txtIdAcceso;
    private javax.swing.JTextField txtIdDepartamento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPorcentaje;
    public javax.swing.JTextField txtTipoAcceso;
    // End of variables declaration//GEN-END:variables
}
