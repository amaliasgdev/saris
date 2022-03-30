package presentacion;

import negocio.EstadoInmuebleControl;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import negocio.InmuebleControl;
import entidades.EstadoInmueble;
import entidades.Inmueble;
import java.util.List;
import presentacion.utiles.Comunes;

public class FrmNuevoInmueble extends javax.swing.JInternalFrame {

    private final InmuebleControl INMUEBLE_CONTROL;
    private final EstadoInmuebleControl ESTADO_CONTROL;
    private Inmueble inmueble;
    public JFrame contenedor;

    public FrmNuevoInmueble() {
        initComponents();
        INMUEBLE_CONTROL = new InmuebleControl();
        ESTADO_CONTROL = new EstadoInmuebleControl();
        this.llenarComboboxGenerico(Comunes.TIPO_INMUEBLE, cboTipoBuscar);
        this.llenarComboboxGenerico(Comunes.PROVINCIA, cboProvinciaBuscar);
        this.llenarComboboxGenerico(Comunes.LOCALIDAD_MADRID, cboLocalidadBuscar);
        this.llenarComboboxGenerico(Comunes.ZONA, cboZona);
        this.llenarComboboxGenerico(Comunes.TIPO_OPERACION, cboTipoOperacion);
        this.llenarComboboxTipos(ESTADO_CONTROL.listar(), cboEstado);
        txtIdPropietario.setVisible(false);
        txtIdCaptador.setVisible(false);
    }

    private void limpiar() {
        cboTipoBuscar.setSelectedIndex(0);
        txtDireccion.setText("");
        cboZona.setSelectedIndex(0);
        cboLocalidadBuscar.setSelectedIndex(0);
        cboProvinciaBuscar.setSelectedIndex(0);
        cboTipoOperacion.setSelectedIndex(0);
        txtPrecioVenta.setText("");
        txtHonorarios.setText("");
        txtNombrePropietario.setText("");
        txtDniPropietario.setText("");
        txtCaptador.setText("");
        cboEstado.setSelectedIndex(0);
        txtPorcentaje.setText("");
    }

    private void llenarComboboxGenerico(String[] array, JComboBox<String> comboBox) {
        for (String i : array) {
            comboBox.addItem(i);
        }
    }

    private void llenarComboboxTipos(List<EstadoInmueble> estados, JComboBox<String> comboBox) {
        for (EstadoInmueble i : estados) {
            comboBox.addItem(i.getEstado());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        txtIdPropietario = new javax.swing.JTextField();
        txtIdCaptador = new javax.swing.JTextField();
        panelFormularioInmueble = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboTipoBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cboZona = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboProvinciaBuscar = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboTipoOperacion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtHonorarios = new javax.swing.JTextField();
        cboLocalidadBuscar = new javax.swing.JComboBox<>();
        btnCalculadora = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnSeleccionarPropietario = new javax.swing.JButton();
        txtNombrePropietario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDniPropietario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCaptador = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo Inmueble");

        jPanel2.setBackground(new java.awt.Color(46, 106, 141));
        jPanel2.setMaximumSize(new java.awt.Dimension(176, 402));
        jPanel2.setMinimumSize(new java.awt.Dimension(176, 402));
        jPanel2.setPreferredSize(new java.awt.Dimension(176, 402));

        btnBorrar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/limpiar.png"))); // NOI18N
        btnBorrar.setText("Limpiar Formulario");
        btnBorrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrar.setBorderPainted(false);
        btnBorrar.setMaximumSize(new java.awt.Dimension(155, 41));
        btnBorrar.setMinimumSize(new java.awt.Dimension(155, 41));
        btnBorrar.setPreferredSize(new java.awt.Dimension(155, 41));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        Guardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/guardar.png"))); // NOI18N
        Guardar.setText("Guardar");
        Guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Guardar.setBorderPainted(false);
        Guardar.setMaximumSize(new java.awt.Dimension(155, 41));
        Guardar.setMinimumSize(new java.awt.Dimension(155, 41));
        Guardar.setPreferredSize(new java.awt.Dimension(155, 41));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        txtIdPropietario.setEditable(false);
        txtIdPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtIdCaptador.setEditable(false);
        txtIdCaptador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(282, Short.MAX_VALUE))
        );

        panelFormularioInmueble.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS INMUEBLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelFormularioInmueble.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setText("Tipo Inmueble(*): ");

        cboTipoBuscar.setBackground(new java.awt.Color(204, 204, 204));
        cboTipoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("Dirección (*):");

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        cboZona.setBackground(new java.awt.Color(204, 204, 204));
        cboZona.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Provincia (*):");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Zona (*):");

        cboProvinciaBuscar.setBackground(new java.awt.Color(204, 204, 204));
        cboProvinciaBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("Localidad (*):");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Tipo Operación (*):");

        cboTipoOperacion.setBackground(new java.awt.Color(204, 204, 204));
        cboTipoOperacion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Precio Venta (*):");

        txtPrecioVenta.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setText("Estado (*):");

        cboEstado.setBackground(new java.awt.Color(204, 204, 204));
        cboEstado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Honorarios:");

        txtHonorarios.setEditable(false);
        txtHonorarios.setBackground(new java.awt.Color(204, 204, 204));
        txtHonorarios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        cboLocalidadBuscar.setBackground(new java.awt.Color(204, 204, 204));
        cboLocalidadBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        btnCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/calculadora.png"))); // NOI18N
        btnCalculadora.setText("Calcular");
        btnCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculadoraActionPerformed(evt);
            }
        });

        jLabel14.setText("Porcentaje(*):");

        txtPorcentaje.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelFormularioInmuebleLayout = new javax.swing.GroupLayout(panelFormularioInmueble);
        panelFormularioInmueble.setLayout(panelFormularioInmuebleLayout);
        panelFormularioInmuebleLayout.setHorizontalGroup(
            panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(15, 15, 15)
                        .addComponent(cboTipoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                        .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addGap(25, 25, 25)
                        .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion)
                            .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboProvinciaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCalculadora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                                        .addComponent(cboLocalidadBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormularioInmuebleLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtHonorarios, txtPrecioVenta});

        panelFormularioInmuebleLayout.setVerticalGroup(
            panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioInmuebleLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTipoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(16, 16, 16)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(cboLocalidadBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboProvinciaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelFormularioInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculadora)
                    .addComponent(jLabel14)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormularioInmuebleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTipoBuscar, cboTipoOperacion, cboZona});

        panelFormularioInmuebleLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboEstado, txtHonorarios, txtPrecioVenta});

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PROPIETARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel13.setText("DATOS PROPIETARIO");

        btnSeleccionarPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarPropietario.setText("...");
        btnSeleccionarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPropietarioActionPerformed(evt);
            }
        });

        txtNombrePropietario.setEditable(false);
        txtNombrePropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtNombrePropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setText("Nombre y Apellidos (*): ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Número de Documento (*):");

        txtDniPropietario.setEditable(false);
        txtDniPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtDniPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Captador (*):");

        txtCaptador.setEditable(false);
        txtCaptador.setBackground(new java.awt.Color(204, 204, 204));
        txtCaptador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDniPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtCaptador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeleccionarPropietario)
                            .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 280, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnSeleccionarPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDniPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFormularioInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelFormularioInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
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
                Comunes.mensaje("Debes introducir un precio numerico", "warning");
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
            }              //Comprobar que lo que se ha introducido en el campo "honorarios" es numérico 
            String precioString = txtHonorarios.getText().trim();
            boolean esNumerico = Comunes.esNumerico(precioString);
            if (!esNumerico) {
                Comunes.mensaje("Debes introducir los honorarios en formato numerico", "warning");
                txtHonorarios.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            Comunes.mensaje( "Debes introducir los honorarios en formato correcto", "warning");
            txtHonorarios.requestFocus();
            return;
        }
        String tipo = cboTipoBuscar.getSelectedItem().toString();
        String direccion = txtDireccion.getText().trim();
        String provincia = cboProvinciaBuscar.getSelectedItem().toString();
        String localidad = cboLocalidadBuscar.getSelectedItem().toString();
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
        inmueble = new Inmueble(tipo, direccion, provincia, localidad, zona, tipoOperacion, precioVenta, honorarios, idPropietario, estado);
        String respuesta = INMUEBLE_CONTROL.nuevoInmueble(inmueble);
        if (respuesta.equals("OK")) {
            this.limpiar();
            dispose();//cierra la ventana
            Comunes.mensaje("Inmueble insertado correctamente", "ok");
        } else {
            Comunes.mensaje(respuesta, "error");
        }

    }//GEN-LAST:event_GuardarActionPerformed

    private void btnSeleccionarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPropietarioActionPerformed
        // TODO add your handling code here:
        FrmSelecCliente frm = new FrmSelecCliente(contenedor, null, null, this, null, closable);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarPropietarioActionPerformed

    private void btnCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculadoraActionPerformed
        // TODO add your handling code here:
        try {
            double precioVenta = Double.parseDouble(txtPrecioVenta.getText());
            String porcentajeString = txtPorcentaje.getText();
            double porcentaje = Double.parseDouble(porcentajeString);
            //Redondear a dos digitos
            double honorarios = Math.round((precioVenta * porcentaje / 100) * 100.0) / 100.0;
            String honStrings = String.valueOf(honorarios);
            txtHonorarios.setText(honStrings);
        } catch (NumberFormatException e) {
            Comunes.mensaje("Error formato cantidades introducidas", "error");
        }
    }//GEN-LAST:event_btnCalculadoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCalculadora;
    private javax.swing.JButton btnSeleccionarPropietario;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboLocalidadBuscar;
    private javax.swing.JComboBox<String> cboProvinciaBuscar;
    private javax.swing.JComboBox<String> cboTipoBuscar;
    private javax.swing.JComboBox<String> cboTipoOperacion;
    private javax.swing.JComboBox<String> cboZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelFormularioInmueble;
    public javax.swing.JTextField txtCaptador;
    private javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtDniPropietario;
    private javax.swing.JTextField txtHonorarios;
    public javax.swing.JTextField txtIdCaptador;
    public javax.swing.JTextField txtIdPropietario;
    public javax.swing.JTextField txtNombrePropietario;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
