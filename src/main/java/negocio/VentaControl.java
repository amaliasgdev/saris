package negocio;

import datos.dao.ClienteDAO;
import datos.dao.EmpleadoDAO;
import datos.dao.InmuebleDAO;
import datos.dao.VentaDAO;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Inmueble;
import entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class VentaControl {

    private final VentaDAO VENTA_DAO;
    private final EmpleadoDAO EMPLEADO_DAO;
    private final ClienteDAO CLIENTE_DAO;
    private final InmuebleDAO INMUEBLE_DAO;
    private DefaultTableModel modeloTabla;
    private Empleado captador, vendedor, secretaria;
    private Cliente propietario, comprador;
    private Inmueble inmueble;   
    private List<Venta> ventas;

    public VentaControl() {
        VENTA_DAO = new VentaDAO();
        EMPLEADO_DAO = new EmpleadoDAO();
        INMUEBLE_DAO = new InmuebleDAO();
        CLIENTE_DAO = new ClienteDAO();
    }

    public DefaultTableModel listar(String texto) {
        ventas = new ArrayList();
        ventas.addAll(VENTA_DAO.select(texto));
        String[] titulos = {"ID", "N.FACTURA", "INMUEBLE ID", "OPERACION", "TIPO", "DIRECCIÓN", "SECRETARIA_ID", "SECRETARIA",
            "CAPTADOR ID", "CAPTADOR", "VENDEDOR ID", "VENDEDOR", "COMPRADOR ID", "N.COMPRADOR", "A.COMPRADOR", "TIPO DOCUMENTACION", "DNI COMPRADOR",
            "PROPIETARIO ID", "N.PROPIETARIO", "A.PROPIETARIO", "TIPO DOCUMENTACION", "DNI PROPIETARIO", "HONORARIOS", "IVA", "TOTAL", "FECHA VENTA"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[26];
        for (Venta item : ventas) {
            registro[0] = Integer.toString(item.getIdVenta());
            registro[1] = item.getNumeroFactura();
            //DATOS INMUEBLE_DAO
            int idInmueble = item.getIdInmueble();
            inmueble = INMUEBLE_DAO.selectById(idInmueble);
            registro[2] = Integer.toString(idInmueble);
            registro[3] = inmueble.getTipoOperacion();
            registro[4] = inmueble.getTipoInmueble();
            registro[5] = inmueble.getDireccion();
            //EMPLEADOS
            //Secretaria
            registro[6] = Integer.toString(item.getIdSecretaria());
            int idSecretaria = Integer.parseInt(registro[6]);
            secretaria = EMPLEADO_DAO.selectById(idSecretaria);
            registro[7] = secretaria.getNombre() + " " + secretaria.getApellidos();
            //Captador - Por el Propietario
            int idPropietario = inmueble.getIdPropietario();
            propietario = CLIENTE_DAO.selectById(idPropietario);
            int idCaptador = propietario.getIdComercial();
            captador = EMPLEADO_DAO.selectById(idCaptador);
            registro[8] = Integer.toString(idCaptador);
            registro[9] = captador.getNombre() + " " + captador.getApellidos();
            //Vendedor - Por el Comprador
            int idComprador = item.getIdComprador();
            registro[10] = Integer.toString(idComprador);
            comprador = CLIENTE_DAO.selectById(idComprador);
            int idVendedor = comprador.getIdComercial();
            vendedor = EMPLEADO_DAO.selectById(idVendedor);
            registro[11] = vendedor.getNombre() + " " + vendedor.getApellidos();
            //CLIENTES 
            //Comprador
            registro[12] = Integer.toString(item.getIdComprador());
            registro[13] = comprador.getNombre();
            registro[14] = comprador.getApellidos();
            registro[15] = comprador.getTipoDocumento();
            registro[16] = comprador.getNumeroDocumento();
            //Propietario 
            registro[17] = Integer.toString(idPropietario);
            registro[18] = propietario.getNombre();
            registro[19] = propietario.getApellidos();
            registro[20] = propietario.getTipoDocumento();
            registro[21] = propietario.getNumeroDocumento();
            registro[22] = Double.toString(item.getHonFinales());
            //IVA Y TOTAL
            double honFinales = item.getHonFinales();
            double iva = (double) Math.round((honFinales * 0.21) * 100) / 100;
            double total = (double) Math.round((honFinales * 1.21) * 100) / 100;
            registro[23] = Double.toString(iva);
            registro[24] = Double.toString(total);
            Date fecha = item.getFecha();
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFactura = fmt.format(fecha);
            registro[25] = fechaFactura;
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listar(Date inicio, Date fin) {
        ventas = new ArrayList();
        ventas.addAll(VENTA_DAO.selectProduccion(inicio, fin));
        String[] titulos = {"ID", "N.FACTURA", "INMUEBLE ID", "OPERACION", "TIPO", "DIRECCIÓN", "SECRETARIA_ID", "SECRETARIA",
            "CAPTADOR ID", "CAPTADOR", "VENDEDOR ID", "VENDEDOR", "COMPRADOR ID", "N.COMPRADOR", "A.COMPRADOR", "TIPO DOCUMENTACION", "DNI COMPRADOR",
            "PROPIETARIO ID", "N.PROPIETARIO", "A.PROPIETARIO", "TIPO DOCUMENTACION", "DNI PROPIETARIO", "HONORARIOS", "IVA", "TOTAL", "FECHA VENTA"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[26];
        for (Venta item : ventas) {
            registro[0] = Integer.toString(item.getIdVenta());
            registro[1] = item.getNumeroFactura();
            //DATOS INMUEBLE_DAO
            int idInmueble = item.getIdInmueble();
            inmueble = INMUEBLE_DAO.selectById(idInmueble);
            registro[2] = Integer.toString(idInmueble);
            registro[3] = inmueble.getTipoOperacion();
            registro[4] = inmueble.getTipoInmueble();
            registro[5] = inmueble.getDireccion();
            //EMPLEADOS
            //Secretaria
            registro[6] = Integer.toString(item.getIdSecretaria());
            int idSecretaria = Integer.parseInt(registro[6]);
            secretaria = EMPLEADO_DAO.selectById(idSecretaria);
            registro[7] = secretaria.getNombre() + " " + secretaria.getApellidos();
            //Captador - Por el Propietario
            int idPropietario = inmueble.getIdPropietario();
            propietario = CLIENTE_DAO.selectById(idPropietario);
            int idCaptador = propietario.getIdComercial();
            captador = EMPLEADO_DAO.selectById(idCaptador);
            registro[8] = Integer.toString(idCaptador);
            registro[9] = captador.getNombre() + " " + captador.getApellidos();
            //Vendedor - Por el Comprador
            int idComprador = item.getIdComprador();
            registro[10] = Integer.toString(idComprador);
            comprador = CLIENTE_DAO.selectById(idComprador);
            int idVendedor = comprador.getIdComercial();
            vendedor = EMPLEADO_DAO.selectById(idVendedor);
            registro[11] = vendedor.getNombre() + " " + vendedor.getApellidos();
            //CLIENTES 
            //Comprador
            registro[12] = Integer.toString(item.getIdComprador());
            registro[13] = comprador.getNombre();
            registro[14] = comprador.getApellidos();
            registro[15] = comprador.getTipoDocumento();
            registro[16] = comprador.getNumeroDocumento();
            //Propietario 
            registro[17] = Integer.toString(idPropietario);
            registro[18] = propietario.getNombre();
            registro[19] = propietario.getApellidos();
            registro[20] = propietario.getTipoDocumento();
            registro[21] = propietario.getNumeroDocumento();
            registro[22] = Double.toString(item.getHonFinales());
            //IVA Y TOTAL
            double honFinales = item.getHonFinales();
            double iva = (double) Math.round((honFinales * 0.21) * 100) / 100;
            double total = (double) Math.round((honFinales * 1.21) * 100) / 100;
            registro[23] = Double.toString(iva);
            registro[24] = Double.toString(total);
            Date fecha = item.getFecha();
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFactura = fmt.format(fecha);
            registro[25] = fechaFactura;
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String nuevaVenta(Venta venta) {    
        if (VENTA_DAO.insert(venta)) {
            return "OK";
        } else {
            return "Error al insertar la venta";
        }
    }

    public String modificarVenta(Venta venta) {      
        if (VENTA_DAO.update(venta)) {
            return "OK";
        } else {
            return "Error en la actualización de la venta";
        }
    }

    //COMISIONES
    public DefaultTableModel listarComisionesProduccion(Date inicio, Date fin) {
        ventas = new ArrayList();
        ventas.addAll(VENTA_DAO.selectComisionesProduccion(inicio, fin));
        String[] titulos = {"FECHA VENTA", "TIPO", "DIRECCIÓN", "CAPTADOR",
            "VENDEDOR", "SECRETARIA", "HONORARIOS",};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[7];
        for (Venta item : ventas) {
            Date fecha = item.getFecha();
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFactura = fmt.format(fecha);
            registro[0] = fechaFactura;
            //INMUEBLE
            int idInmueble = item.getIdInmueble();
            inmueble = INMUEBLE_DAO.selectById(idInmueble);
            registro[1] = inmueble.getTipoInmueble();
            registro[2] = inmueble.getDireccion();
            //CAPTADOR POR PROPIETARIO DEL INMUEBLE_DAO
            int idpropietario = inmueble.getIdPropietario();
            propietario = CLIENTE_DAO.selectById(idpropietario);
            int idCaptador = propietario.getIdComercial();
            captador = EMPLEADO_DAO.selectById(idCaptador);
            registro[3] = captador.getNombre() + " " + captador.getApellidos();
            //DATOS VENDEDOR POR COMPRADOR
            int idComprador = item.getIdComprador();
            comprador = CLIENTE_DAO.selectById(idComprador);
            int idVendedor = comprador.getIdComercial();
            vendedor = EMPLEADO_DAO.selectById(idVendedor);
            registro[4] = vendedor.getNombre() + " " + vendedor.getApellidos();
            int idSecretaria = item.getIdSecretaria();
            secretaria = EMPLEADO_DAO.selectById(idSecretaria);
            registro[5] = secretaria.getNombre() + " " + secretaria.getApellidos();
            registro[6] = Double.toString(item.getHonFinales());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public double calcularProduccionMes(Date inicio, Date fin) {
        return VENTA_DAO.calcularProduccionMes(inicio, fin);
    }

    public int numeroPisos(Date inicio, Date fin) {
        return VENTA_DAO.numeroPisos(inicio, fin);
    }

    public int numeroPisosEmpleado(Date inicio, Date fin, int id) {
        return VENTA_DAO.numeroPisosEmpleado(inicio, fin, id);
    }

    public DefaultTableModel listarComisionesUsuario(Date inicio, Date fin, int idUsuario) {
        ventas = new ArrayList();
        ventas.addAll(VENTA_DAO.selectComisionesUsuario(inicio, fin, idUsuario));    
        
        String[] titulos = {"FECHA VENTA", "TIPO", "DIRECCIÓN", "CAPTADOR",
            "VENDEDOR", "SECRETARIA", "HONORARIOS",};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[7];
        for (Venta item : ventas) {
            Date fecha = item.getFecha();
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFactura = fmt.format(fecha);
            registro[0] = fechaFactura;
            //INMUEBLE
            int idInmueble = item.getIdInmueble();
            inmueble = INMUEBLE_DAO.selectById(idInmueble);
            registro[1] = inmueble.getTipoInmueble();
            registro[2] = inmueble.getDireccion();
            //CAPTADOR POR PROPIETARIO DEL INMUEBLE_DAO
            int idpropietario = inmueble.getIdPropietario();
            propietario = CLIENTE_DAO.selectById(idpropietario);
            int idCaptador = propietario.getIdComercial();
            captador = EMPLEADO_DAO.selectById(idCaptador);
            registro[3] = captador.getNombre() + " " + captador.getApellidos();
            //DATOS VENDEDOR POR COMPRADOR
            int idComprador = item.getIdComprador();
            comprador = CLIENTE_DAO.selectById(idComprador);
            int idVendedor = comprador.getIdComercial();
            vendedor = EMPLEADO_DAO.selectById(idVendedor);
            registro[4] = vendedor.getNombre() + " " + vendedor.getApellidos();
            int idSecretaria = item.getIdSecretaria();
            secretaria = EMPLEADO_DAO.selectById(idSecretaria);
            registro[5] = secretaria.getNombre() + " " + secretaria.getApellidos();
            registro[6] = Double.toString(item.getHonFinales());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public double calcularProduccionEmpleado(Date inicio, Date fin, int idUsuario) {
        double produccion = VENTA_DAO.calcularComisionEmpleado(inicio, fin, idUsuario);
        return produccion;
    }

    public double calcularNetoEmpleado(double produccion, double porcentaje) {
        double comision = produccion * porcentaje / 100;
        double comRedondeo = Math.round(comision * 100.0) / 100.0; //redondear a dos digitos la prod
        return comRedondeo;
    }

    public boolean facturaDuplicada(String numFactura) {
        return VENTA_DAO.facturaDuplicada(numFactura);
    }

    public void generarFactura(int id) {
        VENTA_DAO.generarFactura(id);
    }

    public java.sql.Date fechaInicio(String mes, String año) {
        int mesInicio = 0;
        switch (mes) {
            case "Enero" ->
                mesInicio = 12;
            case "Febrero" ->
                mesInicio = 1;
            case "Marzo" ->
                mesInicio = 2;
            case "Abril" ->
                mesInicio = 3;
            case "Mayo" ->
                mesInicio = 4;
            case "Junio" ->
                mesInicio = 5;
            case "Julio" ->
                mesInicio = 6;
            case "Agosto" ->
                mesInicio = 7;
            case "Septiembre" ->
                mesInicio = 8;
            case "Octubre" ->
                mesInicio = 9;
            case "Noviembre" ->
                mesInicio = 10;
            case "Diciembre" ->
                mesInicio = 11;
            default -> {
            }
        }
        String fechaInicioProduccion = año + "-" + mesInicio + "-16";
        java.sql.Date dateInicioSql = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fecha1 = format.parse(fechaInicioProduccion);
            long date1 = fecha1.getTime();
            dateInicioSql = new java.sql.Date(date1);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return dateInicioSql;
    }

    public java.sql.Date fechaFin(String mes, String año) {
        int mesFin = 0;
        switch (mes) {
            case "Enero" ->
                mesFin = 1;
            case "Febrero" ->
                mesFin = 2;
            case "Marzo" ->
                mesFin = 3;
            case "Abril" ->
                mesFin = 4;
            case "Mayo" ->
                mesFin = 5;
            case "Junio" ->
                mesFin = 6;
            case "Julio" ->
                mesFin = 7;
            case "Agosto" ->
                mesFin = 8;
            case "Septiembre" ->
                mesFin = 9;
            case "Octubre" ->
                mesFin = 10;
            case "Noviembre" ->
                mesFin = 11;
            case "Diciembre" ->
                mesFin = 12;
            default -> {
            }
        }
        String fechaFinProduccion = año + "-" + mesFin + "-15";
        java.sql.Date dateFinSql = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fecha2 = format.parse(fechaFinProduccion);
            long date2 = fecha2.getTime();
            dateFinSql = new java.sql.Date(date2);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return dateFinSql;
    }

    public double calcularBaseImponible(double total) {
        return Math.round((total / 1.21) * 100.0) / 100.0;
    }
    
    public double calcularIva(double baseImponible) {
        return Math.round((baseImponible * 0.21) * 100.0) / 100.0;
    }

}
