package presentacion;

import entidades.Venta;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import negocio.InmuebleControl;
import negocio.VentaControl;
import presentacion.utiles.Comunes;


public class FrmNuevaVenta extends javax.swing.JInternalFrame {

    private final VentaControl VENTA_CONTROL;
    private final InmuebleControl INMUEBLE_CONTROL;
    private Venta venta;
    public JFrame contenedor;
   
    public FrmNuevaVenta() {
        initComponents();
        VENTA_CONTROL = new VentaControl();
        INMUEBLE_CONTROL = new InmuebleControl();
        txtIdSecretaria.setVisible(false);
        txtIdCaptador.setVisible(false);
        txtIdVendedor.setVisible(false);
        txtIdInmueble.setVisible(false);
        txtIdComprador.setVisible(false);
        txtIdPropietario.setVisible(false);
        this.txtAñoFactura.setText(this.obtenerAño());
        this.txtMesFactura.setText(this.obtenerMes());
    }

    private void limpiar() {
        txtDigitosFactura.setText("");
        txtIdInmueble.setText("");
        txtIdSecretaria.setText("");
        txtIdCaptador.setText("");
        txtIdVendedor.setText("");
        txtIdPropietario.setText("");
        txtIdComprador.setText("");
        txtCaptador.setText("");
        txtNombreComprador.setText("");
        txtApellidosComprador.setText("");
        txtSecretaria.setText("");
        txtVendedor.setText("");
        txtTipoDocumentacionComprador.setText("");
        txtNumeroDocumentoComprador.setText("");
        txtNombrePropietario.setText("");
        txtApellidosPropietario.setText("");
        txtTipoDocumentacionPropietario.setText("");
        txtNumeroDocumentoPropietario.setText("");
        txtTipoOperacion.setText("");
        txtTipoInmueble.setText("");
        txtDireccion.setText("");
        txtHonorarios.setText("");
        txtTotalRecibido.setText("");
        txtIva.setText("");
        jdcFechaVenta.setDate(null); //limpia la fecha
    }

    private String obtenerAño() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int año = calendar.get(Calendar.YEAR);
        String añoActual = String.valueOf(año);
        return añoActual;
    }

    private String obtenerMes() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int mes = calendar.get(Calendar.MONTH) + 1;
        String mesActual = String.format("%02d", mes);
        return mesActual;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtIdPropietario = new javax.swing.JTextField();
        txtIdInmueble = new javax.swing.JTextField();
        txtIdCaptador = new javax.swing.JTextField();
        txtIdSecretaria = new javax.swing.JTextField();
        txtIdVendedor = new javax.swing.JTextField();
        txtIdComprador = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtNombrePropietario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtApellidosPropietario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTipoDocumentacionPropietario = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNumeroDocumentoPropietario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSeleccionarComprador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreComprador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellidosComprador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTipoDocumentacionComprador = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNumeroDocumentoComprador = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnSeleccionarPropietario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSecretaria = new javax.swing.JTextField();
        btnSeleccionarSecretaria = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTipoOperacion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTipoInmueble = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtHonorarios = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jdcFechaVenta = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        txtAñoFactura = new javax.swing.JTextField();
        txtMesFactura = new javax.swing.JTextField();
        txtDigitosFactura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalRecibido = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCaptador = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nueva Venta");

        panelBotones.setBackground(new java.awt.Color(46, 106, 141));
        panelBotones.setPreferredSize(new java.awt.Dimension(176, 366));
        panelBotones.setLayout(null);

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
        panelBotones.add(btnBorrar);
        btnBorrar.setBounds(11, 40, 155, 41);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        panelBotones.add(btnGuardar);
        btnGuardar.setBounds(11, 106, 155, 41);
        panelBotones.add(txtIdPropietario);
        txtIdPropietario.setBounds(26, 262, 50, 20);
        panelBotones.add(txtIdInmueble);
        txtIdInmueble.setBounds(82, 262, 50, 20);
        panelBotones.add(txtIdCaptador);
        txtIdCaptador.setBounds(26, 300, 50, 20);
        panelBotones.add(txtIdSecretaria);
        txtIdSecretaria.setBounds(82, 300, 50, 20);
        panelBotones.add(txtIdVendedor);
        txtIdVendedor.setBounds(26, 338, 50, 20);
        panelBotones.add(txtIdComprador);
        txtIdComprador.setBounds(82, 338, 50, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PROPIETARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setText("Nombre (*):");

        txtNombrePropietario.setEditable(false);
        txtNombrePropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtNombrePropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombrePropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setText("Apellidos (*):");

        txtApellidosPropietario.setEditable(false);
        txtApellidosPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidosPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtApellidosPropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setText("Tipo Documentación (*):");

        txtTipoDocumentacionPropietario.setEditable(false);
        txtTipoDocumentacionPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtTipoDocumentacionPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTipoDocumentacionPropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel15.setText("Número Documento (*):");

        txtNumeroDocumentoPropietario.setEditable(false);
        txtNumeroDocumentoPropietario.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroDocumentoPropietario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroDocumentoPropietario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoDocumentacionPropietario)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDocumentoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtApellidosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTipoDocumentacionPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtNumeroDocumentoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS COMPRADOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        btnSeleccionarComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSeleccionarComprador.setText("...");
        btnSeleccionarComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCompradorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setText("Seleccionar Comprador (*):");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Nombre (*):");

        txtNombreComprador.setEditable(false);
        txtNombreComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNombreComprador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setText("Apellidos (*):");

        txtApellidosComprador.setEditable(false);
        txtApellidosComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidosComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtApellidosComprador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Tipo Documentación (*):");

        txtTipoDocumentacionComprador.setEditable(false);
        txtTipoDocumentacionComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtTipoDocumentacionComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTipoDocumentacionComprador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setText("Número Documento (*):");

        txtNumeroDocumentoComprador.setEditable(false);
        txtNumeroDocumentoComprador.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroDocumentoComprador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtNumeroDocumentoComprador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeleccionarComprador))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTipoDocumentacionComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDocumentoComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtNombreComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtApellidosComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTipoDocumentacionComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumeroDocumentoComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA OPERACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
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

        btnSeleccionarSecretaria.setText("...");
        btnSeleccionarSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarSecretariaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Vendedor (*):");

        txtVendedor.setEditable(false);
        txtVendedor.setBackground(new java.awt.Color(204, 204, 204));
        txtVendedor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Tipo de Operación (*):");

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

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel19.setText("Honorarios Finales(*)");

        txtHonorarios.setEditable(false);
        txtHonorarios.setBackground(new java.awt.Color(204, 204, 204));
        txtHonorarios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtHonorarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel21.setText("Fecha Venta(*)");

        jdcFechaVenta.setDateFormatString("yyyy-MM-dd");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel22.setText("Nº Factura(*)");

        txtAñoFactura.setEditable(false);
        txtAñoFactura.setBackground(new java.awt.Color(204, 204, 204));
        txtAñoFactura.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtAñoFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtMesFactura.setEditable(false);
        txtMesFactura.setBackground(new java.awt.Color(204, 204, 204));
        txtMesFactura.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtMesFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtDigitosFactura.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDigitosFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setText("IVA(*)");

        txtIva.setEditable(false);
        txtIva.setBackground(new java.awt.Color(204, 204, 204));
        txtIva.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtIva.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setText("Total Recibido(*)");

        txtTotalRecibido.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotalRecibido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/calculadora.png"))); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCalcular.setMaximumSize(new java.awt.Dimension(155, 41));
        btnCalcular.setMinimumSize(new java.awt.Dimension(155, 41));
        btnCalcular.setPreferredSize(new java.awt.Dimension(155, 41));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Captador(*)");

        txtCaptador.setEditable(false);
        txtCaptador.setBackground(new java.awt.Color(204, 204, 204));
        txtCaptador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtCaptador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAñoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMesFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDigitosFactura)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSeleccionarSecretaria)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccionarPropietario)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jdcFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtHonorarios, txtIva, txtTotalRecibido});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDigitosFactura, txtMesFactura});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(btnSeleccionarPropietario))
                    .addComponent(jdcFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCaptador, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSeleccionarSecretaria)
                        .addComponent(txtSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAñoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtMesFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDigitosFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotalRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHonorarios, txtIva, txtTotalRecibido});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //VALIDACIONES
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
        if (jdcFechaVenta.getDate() == null) {
            Comunes.mensaje("Debes introducir una fecha de venta", "warning");
            jdcFechaVenta.requestFocus();
            return;
        }
        if (txtDigitosFactura.getText().trim().length() == 0 || txtDigitosFactura.getText().length() > 2) {
            Comunes.mensaje("Debe introducir los digitos de la factura y no pueden ser más de 2 caracteres", "warning");
            txtDigitosFactura.requestFocus();
            return;
        }
        try {
            if (txtHonorarios.getText().trim().length() == 0 || txtHonorarios.getText().length() > 13) {
                Comunes.mensaje("Debes ingresar los honorarios de la venta", "warning");
                txtHonorarios.requestFocus();
                return;
            } //Comprobar que los honoriarios es numérico
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
        int inmuebleId = Integer.valueOf(txtIdInmueble.getText());
        String año = txtAñoFactura.getText();
        String mes = txtMesFactura.getText();
        String digitos = txtDigitosFactura.getText();
        String numeroFactura = año + mes + digitos;
        String idSecretaria = txtIdSecretaria.getText();
        int secretariaId = Integer.parseInt(idSecretaria);
        int compradorId = Integer.valueOf(txtIdComprador.getText());
        String totalHonorarios = txtHonorarios.getText();
        double honorarios = Double.parseDouble(totalHonorarios);
        Date date = jdcFechaVenta.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        
        venta = new Venta(inmuebleId, numeroFactura, secretariaId, compradorId, honorarios, fecha);

        if (!VENTA_CONTROL.facturaDuplicada(numeroFactura)) {
            String respuesta = VENTA_CONTROL.nuevaVenta(venta);
            if (respuesta.equals("OK")) {
                this.limpiar();
                Comunes.mensaje("Venta insertada correctamente", "ok");
                String respuestaEstado = INMUEBLE_CONTROL.modificarEstado(inmuebleId, 2); //2 = vendido
                if (respuestaEstado.equals("OK")) {
                    Comunes.mensaje("El inmueble se ha registado como 'Vendido'", "ok");
                    dispose();
                } else {
                    Comunes.mensaje(respuestaEstado, "error");
                }
            } else {
                Comunes.mensaje(respuesta, "error");
            }
        } else {
            Comunes.mensaje("El número de factura ya existe", "error");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSeleccionarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPropietarioActionPerformed
        FrmSelecInmueble frm = new FrmSelecInmueble(contenedor, this, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarPropietarioActionPerformed

    private void btnSeleccionarSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarSecretariaActionPerformed
        FrmSelecEmpleado frm = new FrmSelecEmpleado(contenedor, null, null, this, null, null, null, null, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarSecretariaActionPerformed

    private void btnSeleccionarCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCompradorActionPerformed
        FrmSelecCliente frm = new FrmSelecCliente(contenedor, this, null, null, null, closable);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarCompradorActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try {
            String totalString = txtTotalRecibido.getText();
            double total = Double.parseDouble(totalString);
            double baseImponible = VENTA_CONTROL.calcularBaseImponible(total);
            double iva = VENTA_CONTROL.calcularIva(baseImponible);
            txtHonorarios.setText(String.valueOf(baseImponible));
            txtIva.setText(String.valueOf(iva));
        } catch (NumberFormatException e) {
            Comunes.mensaje("Error formato cantidades introducidas", "error");
        }
    }//GEN-LAST:event_btnCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionarComprador;
    private javax.swing.JButton btnSeleccionarPropietario;
    private javax.swing.JButton btnSeleccionarSecretaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdcFechaVenta;
    private javax.swing.JPanel panelBotones;
    public javax.swing.JTextField txtApellidosComprador;
    public javax.swing.JTextField txtApellidosPropietario;
    protected javax.swing.JTextField txtAñoFactura;
    public javax.swing.JTextField txtCaptador;
    protected javax.swing.JTextField txtDigitosFactura;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtHonorarios;
    public javax.swing.JTextField txtIdCaptador;
    public javax.swing.JTextField txtIdComprador;
    public javax.swing.JTextField txtIdInmueble;
    public javax.swing.JTextField txtIdPropietario;
    public javax.swing.JTextField txtIdSecretaria;
    public javax.swing.JTextField txtIdVendedor;
    private javax.swing.JTextField txtIva;
    protected javax.swing.JTextField txtMesFactura;
    public javax.swing.JTextField txtNombreComprador;
    public javax.swing.JTextField txtNombrePropietario;
    public javax.swing.JTextField txtNumeroDocumentoComprador;
    public javax.swing.JTextField txtNumeroDocumentoPropietario;
    public javax.swing.JTextField txtSecretaria;
    public javax.swing.JTextField txtTipoDocumentacionComprador;
    public javax.swing.JTextField txtTipoDocumentacionPropietario;
    public javax.swing.JTextField txtTipoInmueble;
    public javax.swing.JTextField txtTipoOperacion;
    private javax.swing.JTextField txtTotalRecibido;
    public javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
