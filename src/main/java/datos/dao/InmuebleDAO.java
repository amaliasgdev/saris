package datos.dao;

import java.sql.Connection;
import entidades.Inmueble;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datos.conexion.Conexion;

public class InmuebleDAO implements CrudInterface<Inmueble> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private List<Inmueble> inmuebles;
    private Inmueble inmueble;
    private boolean respuesta;

    public InmuebleDAO() {

    }

    @Override
    public List<Inmueble> select(String texto) {
        conn = Conexion.getConnection();
        inmuebles = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT i.id, i.tipo, i.direccion, i.provincia, i.localidad, i.zona, i.tipo_operacion, i.precio_venta, "
                    + "i.honorarios, i.propietario_id, i.estado_id "
                    + "FROM inmuebles i "
                    + "WHERE i.direccion LIKE ? "
                    + "ORDER BY i.id");
            pstm.setString(1, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tipoInmueble = rs.getString(2);
                String direccion = rs.getString(3);
                String provincia = rs.getString(4);
                String localidad = rs.getString(5);
                String zona = rs.getString(6);
                String tipoOperacion = rs.getString(7);
                double precioVenta = rs.getDouble(8);
                double honorarios = rs.getDouble(9);
                int propietarioId = rs.getInt(10);
                int estadoId = rs.getInt(11);
                inmueble = new Inmueble(id, tipoInmueble, direccion, provincia, localidad, zona, tipoOperacion, precioVenta, honorarios, propietarioId, estadoId);
                inmuebles.add(inmueble);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return inmuebles;
    }

    public List<Inmueble> selectEstado(String texto, String disponibilidad) {
        conn = Conexion.getConnection();
        inmuebles = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT i.id, i.tipo, i.direccion, i.provincia, i.localidad, i.zona, i.tipo_operacion, i.precio_venta, "
                    + "i.honorarios, i.propietario_id, i.estado_id, es.estado "
                    + "FROM inmuebles i "
                    + "JOIN estado_inmuebles es ON i.estado_id=es.id "
                    + "WHERE es.estado=? AND i.direccion LIKE ? "
                    + "ORDER BY i.id");
            pstm.setString(1, disponibilidad);
            pstm.setString(2, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tipoInmueble = rs.getString(2);
                String direccion = rs.getString(3);
                String provincia = rs.getString(4);
                String localidad = rs.getString(5);
                String zona = rs.getString(6);
                String tipoOperacion = rs.getString(7);
                double precioVenta = rs.getDouble(8);
                double honorarios = rs.getDouble(9);
                int propietarioId = rs.getInt(10);
                int estadoId = rs.getInt(11);
                inmueble = new Inmueble(id, tipoInmueble, direccion, provincia, localidad, zona, tipoOperacion, precioVenta, honorarios, propietarioId, estadoId);
                inmuebles.add(inmueble);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return inmuebles;
    }

    //Seleccionar desde Combobox
    public List<Inmueble> select(String tipo, String provincia, String localidad, String zona, String disponibilidad) {
        conn = Conexion.getConnection();
        inmuebles = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT i.id, i.tipo, i.direccion, i.provincia, i.localidad, i.zona, i.tipo_operacion, i.precio_venta, "
                    + "i.honorarios, i.propietario_id, i.estado_id, es.estado "
                    + "FROM inmuebles i "
                    + "JOIN estado_inmuebles es ON i.estado_id=es.id "
                    + "WHERE i.tipo=? "
                    + "AND i.provincia=? "
                    + "AND i.localidad=? "
                    + "AND i.zona=? "
                    + "AND es.estado=? "
                    + "ORDER BY i.id");
            pstm.setString(1, tipo);
            pstm.setString(2, provincia);
            pstm.setString(3, localidad);
            pstm.setString(4, zona);
            pstm.setString(5, disponibilidad);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tipoInmueble = rs.getString(2);
                String direccion = rs.getString(3);
                String prov = rs.getString(4);
                String loc = rs.getString(5);
                String zon = rs.getString(6);
                String tipoOperacion = rs.getString(7);
                double precioVenta = rs.getDouble(8);
                double honorarios = rs.getDouble(9);
                int propietarioId = rs.getInt(10);
                int estadoId = rs.getInt(11);
                inmueble = new Inmueble(id, tipoInmueble, direccion, prov, loc, zon, tipoOperacion,
                        precioVenta, honorarios, propietarioId, estadoId);
                inmuebles.add(inmueble);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return inmuebles;

    }

    @Override
    public boolean insert(Inmueble inmueble) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            String sql = "INSERT INTO inmuebles(tipo, direccion, provincia, localidad, zona, "
                    + "tipo_operacion, precio_venta, honorarios, "
                    + "propietario_id, estado_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, inmueble.getTipoInmueble());
            pstm.setString(2, inmueble.getDireccion());
            pstm.setString(3, inmueble.getProvincia());
            pstm.setString(4, inmueble.getLocalidad());
            pstm.setString(5, inmueble.getZona());
            pstm.setString(6, inmueble.getTipoOperacion());
            pstm.setDouble(7, inmueble.getPrecioVenta());
            pstm.setDouble(8, inmueble.getHonorarios());
            pstm.setInt(9, inmueble.getIdPropietario());
            pstm.setInt(10, inmueble.getIdEstado());
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
    public boolean update(Inmueble inmueble) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE inmuebles SET tipo=?, direccion=?, provincia=?, localidad=?, zona=?, "
                    + " tipo_operacion=?, precio_venta=?, honorarios=?, "
                    + "propietario_id=?, estado_id=? WHERE id=?");
            pstm.setString(1, inmueble.getTipoInmueble());
            pstm.setString(2, inmueble.getDireccion());
            pstm.setString(3, inmueble.getProvincia());
            pstm.setString(4, inmueble.getLocalidad());
            pstm.setString(5, inmueble.getZona());
            pstm.setString(6, inmueble.getTipoOperacion());
            pstm.setDouble(7, inmueble.getPrecioVenta());
            pstm.setDouble(8, inmueble.getHonorarios());
            pstm.setInt(9, inmueble.getIdPropietario());
            pstm.setInt(10, inmueble.getIdEstado());
            pstm.setInt(11, inmueble.getIdInmueble());
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

    //Modificar el estado a vendido cuando se registra una venta
    public boolean updateEstado(Inmueble inmueble, int idEstado) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE inmuebles SET estado_id=? WHERE id=?");
            pstm.setInt(1, idEstado);
            pstm.setInt(2, inmueble.getIdInmueble());
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

    @Override
    public boolean delete(Inmueble inmueble) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            String sql = "DELETE FROM inmuebles WHERE id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, inmueble.getIdInmueble());
            respuesta = (pstm.executeUpdate() > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return respuesta;

    }

    @Override
    public Inmueble selectById(int idInmueble) {
        conn = Conexion.getConnection();          
        try {
            pstm = conn.prepareStatement("SELECT i.id, i.tipo, i.direccion, i.provincia, i.localidad, i.zona, "
                    + "i.tipo_operacion, i.precio_venta, i.honorarios, i.propietario_id, i.estado_id "
                    + "FROM inmuebles i WHERE i.id = ?");
            pstm.setInt(1, idInmueble);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tipo = rs.getString(2);
                String direccion = rs.getString(3);
                String provincia = rs.getString(4);
                String localidad = rs.getString(5);
                String zona = rs.getString(6);
                String tipoOperacion = rs.getString(7);
                Double precioVenta = rs.getDouble(8);
                Double honorarios = rs.getDouble(9);
                int idPropietario = rs.getInt(10);
                int estadoId = rs.getInt(11);   
                inmueble = new Inmueble(idInmueble, tipo, direccion, provincia, localidad, 
                        zona, tipoOperacion, precioVenta, honorarios, idPropietario, estadoId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return inmueble;
    }

    //METODO PROPIO PARA COMPROBAR SI YA EXISTE LA DIRECCION Y NO DUPLICAR INMUEBLES
    public boolean existe(String direccion) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            pstm = conn.prepareStatement("SELECT direccion FROM inmuebles WHERE direccion=?");
            pstm.setString(1, direccion);
            rs = pstm.executeQuery();
            rs.next();
            if (rs.getRow() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return respuesta;
    }

}
