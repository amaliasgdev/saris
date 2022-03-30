package datos.dao;

import entidades.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datos.conexion.Conexion;

public class DepartamentoDAO implements CrudInterface<Departamento> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private List<Departamento> departamentos;
    private Departamento departamento;
    private boolean respuesta;

    public DepartamentoDAO() {

    }

    @Override
    public List<Departamento> select(String nombre) {
        conn = Conexion.getConnection();
        departamentos = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT id, nombre, rol_id, porcentaje "
                    + "FROM departamentos d "
                    + "WHERE d.nombre LIKE ? ORDER BY d.id");
            pstm.setString(1, "%" + nombre + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                departamentos.add(new Departamento(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return departamentos;
    }

    @Override
    public boolean insert(Departamento departamento) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            String sql = "INSERT INTO departamentos(nombre, rol_id, porcentaje) VALUES (?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, departamento.getNombre());
            pstm.setInt(2, departamento.getIdRol());
            pstm.setFloat(3, departamento.getPorcentaje());
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
        return this.respuesta;
    }

    @Override
    public boolean update(Departamento departamento) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE departamentos SET nombre=?, rol_id=?, porcentaje=? WHERE id=?");
            pstm.setString(1, departamento.getNombre());
            pstm.setInt(2, departamento.getIdRol());
            pstm.setFloat(3, departamento.getPorcentaje());
            pstm.setInt(4, departamento.getIdDepartamento());
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

    @Override
    public boolean delete(Departamento departamento) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        int idDepartamento = departamento.getIdDepartamento();
        try {
            String sql = "DELETE FROM departamentos WHERE id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idDepartamento);
            this.respuesta = (pstm.executeUpdate() > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return this.respuesta;
    }

    //Comprobar si existe el departamento cuando demos unos de alta
    public boolean existe(String nombre) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            pstm = conn.prepareStatement("SELECT nombre FROM departamentos WHERE nombre=?");
            pstm.setString(1, nombre);
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
        return this.respuesta;
    }

    @Override
    public Departamento selectById(int id) {
        conn = Conexion.getConnection();
        try {
            pstm = conn.prepareStatement("SELECT id, nombre, porcentaje, rol_id FROM departamentos WHERE id=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idDepartamento = rs.getInt(1);
                String nombre = rs.getString(2);
                float porcentaje = rs.getFloat(3);
                int rolId = rs.getInt(4);
                departamento = new Departamento(idDepartamento, nombre, rolId, porcentaje);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return departamento;
    }

}
