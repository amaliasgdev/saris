package datos.dao;

import entidades.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datos.conexion.Conexion;

public class RolDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private List<Rol> roles;
    private Rol rol;

    public RolDAO() {

    }

    public List<Rol> select() {
        conn = Conexion.getConnection();
        roles = new ArrayList();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id, nombre FROM roles");
            while (rs.next()) {
                roles.add(new Rol(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return roles;
    }

    public Rol selectById(int id) {
        conn = Conexion.getConnection();
        rol = new Rol();
        try {
            pstmt = conn.prepareStatement("SELECT id, nombre FROM roles WHERE id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                rol.setIdRol(rs.getInt(1));
                rol.setNombreRol(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstmt);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return rol;
    }

}
