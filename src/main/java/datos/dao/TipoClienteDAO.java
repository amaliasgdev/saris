package datos.dao;

import entidades.TipoCliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import datos.conexion.Conexion;
import java.sql.PreparedStatement;

public class TipoClienteDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstm;
    private ResultSet rs;
    private List<TipoCliente> tipos;
    private TipoCliente tipo;

    public TipoClienteDAO() {
    }

    public List<TipoCliente> select() {
        conn = Conexion.getConnection();
        tipos = new ArrayList();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id, tipo FROM tipo_clientes");
            while (rs.next()) {
                tipos.add(new TipoCliente(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return tipos;
    }

    public TipoCliente selectById(int id) {
        conn = Conexion.getConnection();
        tipo = new TipoCliente();
        try {            
            pstm = conn.prepareStatement("SELECT id, tipo FROM tipo_clientes WHERE id=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idTipo = rs.getInt(1);
                String tipoCliente = rs.getString(2);
                tipo.setIdTipoCliente(idTipo);
                tipo.setNombreTipo(tipoCliente);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return tipo;
    }
}
