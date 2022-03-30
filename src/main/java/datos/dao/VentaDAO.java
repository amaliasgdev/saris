package datos.dao;

import entidades.Venta;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import datos.conexion.Conexion;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class VentaDAO implements CrudInterface<Venta> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private List<Venta> ventas;
    private Venta venta;
    private boolean respuesta;

    public VentaDAO() {

    }

    @Override
    public List<Venta> select(String texto) {
        conn = Conexion.getConnection();
        ventas = new ArrayList<>();
        try {
            pstm = conn.prepareStatement("SELECT v.id, v.numero_factura, v.inmueble_id, "
                    + "v.secretaria_id, v.comprador_id, v.hon_finales, v.fecha_venta, i.direccion "
                    + "FROM ventas v "
                    + "JOIN inmuebles i ON v.inmueble_id=i.id "
                    + "WHERE i.direccion LIKE ? "
                    + "OR v.numero_factura=? "
                    + "ORDER BY v.numero_factura");
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, texto);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String numeroFactura = rs.getString(2);
                int inmuebleId = rs.getInt(3);
                int secretariaId = rs.getInt(4);
                int compradorId = rs.getInt(5);
                double total = rs.getDouble(6);
                Date fecha = rs.getDate(7);
                venta = new Venta(id, numeroFactura, inmuebleId, secretariaId,
                        compradorId, total, fecha);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return ventas;
    }

    public List<Venta> selectProduccion(Date inicio, Date fin) {
        conn = Conexion.getConnection();
        ventas = new ArrayList<>();
        try {
            pstm = conn.prepareStatement("SELECT v.id, v.numero_factura, v.inmueble_id "
                    + "v.secretaria_id, v.comprador_id, v.hon_finales,v.fecha_venta "
                    + "FROM ventas v "
                    + "WHERE v.fecha_venta >=? AND v.fecha_venta <=? "
                    + "ORDER BY v.fecha_venta");
            pstm.setDate(1, inicio);
            pstm.setDate(2, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String numeroFactura = rs.getString(2);
                int inmuebleId = rs.getInt(3);
                int secretariaId = rs.getInt(4);
                int compradorId = rs.getInt(5);
                double honorarios = rs.getDouble(6);
                Date fecha = rs.getDate(7);
                venta = new Venta(id, numeroFactura, inmuebleId, secretariaId,
                        compradorId, honorarios, fecha);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return ventas;
    }

    @Override
    public boolean insert(Venta venta) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            String sql = "INSERT INTO ventas(inmueble_id, numero_factura, secretaria_id, "
                    + "comprador_id, hon_finales, fecha_venta) "
                    + "VALUES (?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, venta.getIdInmueble());
            pstm.setString(2, venta.getNumeroFactura());
            pstm.setInt(3, venta.getIdSecretaria());
            pstm.setInt(4, venta.getIdComprador());
            pstm.setDouble(5, venta.getHonFinales());
            pstm.setDate(6, venta.getFecha());
            //ejecutamos la sentencia. Da 1 si se ejecuta correctamente
            int cantidad = pstm.executeUpdate();
            //si da 1 ha sido agregado
            respuesta = (cantidad > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return respuesta;
    }

    @Override
    public boolean update(Venta venta) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE ventas SET numero_factura=?, inmueble_id=?, secretaria_id=?, "
                    + "comprador_id=?, hon_finales=?, fecha_venta=? WHERE id=?");
            pstm.setString(1, venta.getNumeroFactura());
            pstm.setInt(2, venta.getIdInmueble());
            pstm.setInt(3, venta.getIdSecretaria());
            pstm.setInt(4, venta.getIdComprador());
            pstm.setDouble(5, venta.getHonFinales());
            pstm.setDate(6, venta.getFecha());
            pstm.setInt(7, venta.getIdVenta());
            if (pstm.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return respuesta;
    }

    //metodo que lista las comisiones entre fechas
    public List<Venta> selectComisionesProduccion(Date inicio, Date fin) {
        conn = Conexion.getConnection();
        ventas = new ArrayList<>();
        try {
            pstm = conn.prepareStatement("SELECT v.fecha_venta , v.inmueble_id, "
                    + "v.secretaria_id, v.comprador_id, v.hon_finales "
                    + "FROM ventas v "
                    + "WHERE v.fecha_venta >=? AND v.fecha_venta <=?");
            pstm.setDate(1, inicio);
            pstm.setDate(2, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Date fecha = rs.getDate(1);
                int inmuebleId = rs.getInt(2);
                int secretariaId = rs.getInt(3);
                int compradorId = rs.getInt(4);
                double comision = rs.getDouble(5);
                venta = new Venta(fecha, inmuebleId, secretariaId, compradorId, comision);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return ventas;
    }

    public double calcularProduccionMes(Date inicio, Date fin) {
        conn = Conexion.getConnection();
        double produccionMes = 0;
        try {
            pstm = conn.prepareStatement("SELECT SUM(hon_finales) FROM ventas WHERE fecha_venta>=? and fecha_venta<=?");
            pstm.setDate(1, inicio);
            pstm.setDate(2, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                produccionMes = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return produccionMes;
    }

    public int numeroPisos(Date inicio, Date fin) {
        conn = Conexion.getConnection();
        int numeroPisos = 0;
        try {
            pstm = conn.prepareStatement("SELECT COUNT(*) FROM ventas WHERE fecha_venta>=? and fecha_venta<=?");
            pstm.setDate(1, inicio);
            pstm.setDate(2, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                numeroPisos = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return numeroPisos;
    }

    public int numeroPisosEmpleado(Date inicio, Date fin, int idEmpleado) {
        conn = Conexion.getConnection();
        int numeroPisos = 0;
        try {
            pstm = conn.prepareStatement("SELECT COUNT(*), propietario.comercial_id, comprador.comercial_id "
                    + "FROM ventas v "
                    + "JOIN inmuebles i ON v.inmueble_id=i.id "
                    + "JOIN clientes propietario ON i.propietario_id=propietario.id "
                    + "JOIN clientes comprador ON v.comprador_id=comprador.id "
                    + "WHERE (v.secretaria_id=? OR propietario.comercial_id=? OR comprador.comercial_id=?) "
                    + "AND (fecha_venta>=? and fecha_venta<=?)");
            pstm.setInt(1, idEmpleado);//secretaria
            pstm.setInt(2, idEmpleado);//captador
            pstm.setInt(3, idEmpleado);//vendedor
            pstm.setDate(4, inicio);
            pstm.setDate(5, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                numeroPisos = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return numeroPisos;
    }

    public double calcularComisionEmpleado(Date inicio, Date fin, int idEmpleado) {
        conn = Conexion.getConnection();
        double comision = 0;
        try {
            pstm = conn.prepareStatement("SELECT sum(v.hon_finales), propietario.comercial_id, comprador.comercial_id "
                    + "FROM ventas v "
                    + "JOIN inmuebles i ON v.inmueble_id=i.id "
                    + "JOIN clientes propietario ON i.propietario_id=propietario.id "
                    + "JOIN clientes comprador ON v.comprador_id=comprador.id "
                    + "WHERE (v.secretaria_id=? OR propietario.comercial_id=? OR comprador.comercial_id=?) "
                    + "AND (fecha_venta>=? and fecha_venta<=?)");
            pstm.setInt(1, idEmpleado);//secretaria
            pstm.setInt(2, idEmpleado);//captador
            pstm.setInt(3, idEmpleado);//vendedor
            pstm.setDate(4, inicio);
            pstm.setDate(5, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                comision = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return comision;
    }

    //metodo para calcular las comisiones de captadores, vendedores y secretarias
    public List<Venta> selectComisionesUsuario(Date inicio, Date fin, int idEmpleado) {
        conn = Conexion.getConnection();
        ventas = new ArrayList<>();
        try {
            pstm = conn.prepareStatement("SELECT v.fecha_venta, v.inmueble_id, v.secretaria_id,"
                    + " v.comprador_id, v.hon_finales, propietario.comercial_id,comprador.comercial_id "
                    + "FROM ventas v "
                    + "JOIN inmuebles i ON v.inmueble_id=i.id "
                    + "JOIN clientes propietario ON i.propietario_id=propietario.id "
                    + "JOIN clientes comprador ON v.comprador_id=comprador.id "
                    + "WHERE (v.secretaria_id=? OR propietario.comercial_id=? OR comprador.comercial_id=?) "
                    + "AND (v.fecha_venta>=? and v.fecha_venta<=?)");
            //captador, vendedor, secretaria
            pstm.setInt(1, idEmpleado);
            pstm.setInt(2, idEmpleado);
            pstm.setInt(3, idEmpleado);
            pstm.setDate(4, inicio);
            pstm.setDate(5, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Date fecha = rs.getDate(1);
                int inmuebleId = rs.getInt(2);
                int secretariaId = rs.getInt(3);
                int compradorId = rs.getInt(4);
                double comision = rs.getDouble(5);
                venta = new Venta(fecha, inmuebleId, secretariaId, compradorId, comision);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return ventas;
    }

    //metodo que comprueba si la factura esta duplicada
    public boolean facturaDuplicada(String numFactura) {
        conn = Conexion.getConnection();
        respuesta = true;
        try {
            pstm = conn.prepareStatement("SELECT * FROM ventas WHERE numero_factura=?");
            pstm.setString(1, numFactura);
            rs = pstm.executeQuery();
            respuesta = rs.next(); //Si hay alguna algún resultado (alguna factura con ese numero) me dará true            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return respuesta;
    }

    public void generarFactura(int id) {
        //Creamos objeto de tipo JasperReport 
        //El archivo .jrxml es para el diseño, pero el .jasper es el que necesitamos ya que está compilado
        JasperReport factura;
        conn = Conexion.getConnection();
        //Creamos un Map para poder pasarle parámetros, en este caso el id de la venta
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        //Direccion de donde está alojado el archivo compilado que se cargará en el objeto JR
        String path = "src\\datos\\reportes\\Factura.jasper";

        try {
            //Aqui usamos el archivo compilado Jasper. Debemos castear todo a Jasper Report
            factura = (JasperReport) JRLoader.loadObjectFromFile(path);
            //Ahora llenamos el reporte con la informacion
            //Le pasamos:  el archivo jasper, los parametros y la fuente de datos/conexion  
            JasperPrint imprimir = JasperFillManager.fillReport(factura, map, conn);
            //Ahora se crea la vista del reporte. 
            //Le pasamo un 'false' porque si cerramos la ventana se cierra toda la app
            JasperViewer vista = new JasperViewer(imprimir, false);
            //para que se pueda cerrar 'DISPOSE_ON_CLOSE'
            vista.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            //Mostrar como visible
            vista.setVisible(true);
        } catch (JRException ex) {
            ex.getMessage();
        }
    }

    @Override
    public boolean delete(Venta object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //LAS VENTAS-FACTURAS NO SE BORRAN. SOLO PUEDE HACERSE UN ABONO O FACTURA DE RECTIFICACIÓN
    }

    @Override
    public Venta selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
