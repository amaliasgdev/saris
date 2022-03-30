package datos.dao;

import entidades.EstadoInmueble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import datos.conexion.Conexion;

public class EstadoInmuebleDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private List<EstadoInmueble> estados;
    private EstadoInmueble estado;

    public EstadoInmuebleDAO() {
    }

    public List<EstadoInmueble> select() {
        conn = Conexion.getConnection();
        estados = new ArrayList();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id, estado FROM estado_inmuebles");
            while (rs.next()) {
                estados.add(new EstadoInmueble(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return estados;
    }

    public EstadoInmueble selectById(int id) {
        conn = Conexion.getConnection();
        estado = new EstadoInmueble();
        try {
            pstmt = conn.prepareStatement("SELECT id, estado FROM estado_inmuebles WHERE id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                estado.setIdEstado(rs.getInt(1));
                estado.setEstado(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstmt);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return estado;
    }

}
