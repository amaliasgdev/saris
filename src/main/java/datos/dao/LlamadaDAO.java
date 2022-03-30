package datos.dao;

import java.sql.Date;
import entidades.Llamada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datos.conexion.Conexion;

public class LlamadaDAO implements CrudInterface<Llamada> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private List<Llamada> llamadas;    
    private boolean respuesta;

    public LlamadaDAO() {

    }

    public List<Llamada> select(Date dia) {
        conn = Conexion.getConnection();
        llamadas = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT l.id, l.fecha, l.medio, l.zona, l.tipo_operacion, l.vendedor_id "
                    + "FROM llamadas l "
                    + "WHERE l.fecha=? "
                    + "ORDER BY l.id");
            pstm.setDate(1, dia);
            rs = pstm.executeQuery();
            while (rs.next()) {
                llamadas.add(new Llamada(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return llamadas;
    }

    //Sobrecarga de metodos
    public List<Llamada> select(Date inicio, Date fin) {
        conn = Conexion.getConnection();
        llamadas = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT l.id, l.fecha, l.medio, l.zona, l.tipo_operacion, l.vendedor_id "
                    + "FROM llamadas l "
                    + "WHERE l.fecha BETWEEN ? AND ? "
                    + "ORDER BY l.id");
            pstm.setDate(1, inicio);
            pstm.setDate(2, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                llamadas.add(new Llamada(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return llamadas;
    }

    @Override
    public boolean insert(Llamada llamada) {
        conn = Conexion.getConnection();
        this.respuesta = false;

        try {
            String sql = "INSERT INTO llamadas(fecha, medio, zona, tipo_operacion, vendedor_id) VALUES (?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setDate(1, llamada.getFecha());
            pstm.setString(2, llamada.getMedio());
            pstm.setString(3, llamada.getZona());
            pstm.setString(4, llamada.getTipo());
            pstm.setInt(5, llamada.getIdVendedor());
            //ejecutamos la sentencia. Da 1 si se ejecuta correctamente
            int cantidad = pstm.executeUpdate();
            //si da 1 ha sido agregado
            respuesta = (cantidad > 0);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return this.respuesta;
    }

    @Override
    public boolean update(Llamada llamada) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE llamadas SET medio=?, zona=?, tipo_operacion=?, vendedor_id=? WHERE id=?");
            pstm.setString(1, llamada.getMedio());
            pstm.setString(2, llamada.getZona());
            pstm.setString(3, llamada.getTipo());
            pstm.setInt(4, llamada.getIdVendedor());
            pstm.setInt(5, llamada.getIdLlamada());
            if (pstm.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return this.respuesta;
    }

    //sobrecarga de metodos
    //metodo para calcular el numero de llamadas segun vendedor en el dia actual
    public int numeroLlamadas(int idVendedor, java.sql.Date fecha) {
        conn = Conexion.getConnection();
        int numero = 0;
        try {
            pstm = conn.prepareStatement("SELECT COUNT(*) FROM llamadas WHERE vendedor_id=? AND fecha=?");
            pstm.setInt(1, idVendedor);
            pstm.setDate(2, fecha);
            rs = pstm.executeQuery();
            if (rs.next()) {
                numero = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return numero;
    }

    //metodo para calcular el numero de llamadas segun vendedor entre dos fechas
    public int numeroLlamadas(int idVendedor, java.sql.Date inicio, java.sql.Date fin) {
        conn = Conexion.getConnection();
        int numero = 0;
        try {
            pstm = conn.prepareStatement("SELECT COUNT(*) FROM llamadas WHERE fecha BETWEEN ? AND ? AND vendedor_id=?");
            pstm.setDate(1, inicio);
            pstm.setDate(2, fin);
            pstm.setInt(3, idVendedor);
            rs = pstm.executeQuery();
            if (rs.next()) {
                numero = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return numero;
    }

    //sobrecarga
    //metodo para calcular el numero de llamadas por medio en el mismo dia
    public List<Llamada> tablaLlamadasMedios(java.sql.Date fecha) {
        conn = Conexion.getConnection();
        llamadas = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT medio, COUNT(*) FROM llamadas WHERE fecha=? GROUP BY medio");
            pstm.setDate(1, fecha);
            rs = pstm.executeQuery();
            while (rs.next()) {
                llamadas.add(new Llamada(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return llamadas;
    }

    //sobrecarga
    //metodo para calcular el numero de llamadas por medio entra fechas
    public List<Llamada> tablaLlamadasMedios(java.sql.Date inicio, java.sql.Date fin) {
        conn = Conexion.getConnection();
        llamadas = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT medio, COUNT(*) FROM llamadas WHERE fecha BETWEEN ? AND ? GROUP BY medio");
            pstm.setDate(1, inicio);
            pstm.setDate(2, fin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                llamadas.add(new Llamada(rs.getString(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return llamadas;
    }

    //Se seleccionan solo por fechas
    @Override
    public List<Llamada> select(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      //Las llamadas no se pueden eliminar
    @Override
    public boolean delete(Llamada object) {      
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Llamada selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
