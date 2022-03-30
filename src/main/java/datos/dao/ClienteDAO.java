package datos.dao;

import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datos.conexion.Conexion;

public class ClienteDAO implements CrudInterface<Cliente> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private List<Cliente> clientes;
    private Cliente cliente;
    private boolean respuesta;

    public ClienteDAO() {
        cliente = new Cliente();
    }

    @Override
    public List<Cliente> select(String texto) {
        conn = Conexion.getConnection();
        clientes = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT c.id, c.nombre, c.apellidos, c.tipo_documento, c.numero_documento, "
                    + "c.tipo_cliente, c.direccion, c.email, c.telefono, c.comercial_id, t.tipo "
                    + "FROM clientes c "
                    + "INNER JOIN tipo_clientes t ON c.tipo_cliente=t.id "
                    + "WHERE c.nombre LIKE ? "
                    + "OR c.apellidos LIKE ? "
                    + "OR c.numero_documento LIKE ? "
                    + "OR t.tipo LIKE ?"
                    + "OR c.telefono LIKE ?"
                    + "ORDER BY c.id");
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
            pstm.setString(4, "%" + texto + "%");
            pstm.setString(5, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String tipoDocumento = rs.getString(4);
                String numDocumento = rs.getString(5);
                int tipoCliente = rs.getInt(6);
                String direccion = rs.getString(7);
                String email = rs.getString(8);
                String telefono = rs.getString(9);
                int idComercial = rs.getInt(10);
                cliente = new Cliente(id, nombre, apellidos, tipoDocumento, numDocumento, tipoCliente, direccion, email, telefono, idComercial);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return clientes;
    }

    @Override
    public boolean insert(Cliente persona) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            String sql = "INSERT INTO clientes(nombre, apellidos, tipo_documento, numero_documento, tipo_cliente, direccion, email, "
                    + "telefono, comercial_id) VALUES (?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, persona.getNombre());
            pstm.setString(2, persona.getApellidos());
            pstm.setString(3, persona.getTipoDocumento());
            pstm.setString(4, persona.getNumeroDocumento());
            pstm.setInt(5, persona.getIdTipoCliente());
            pstm.setString(6, persona.getDireccion());
            pstm.setString(7, persona.getEmail());
            pstm.setString(8, persona.getTelefono());
            pstm.setInt(9, persona.getIdComercial());
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
        return respuesta;
    }

    @Override
    public boolean update(Cliente cliente) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE clientes SET nombre=?, apellidos=?, tipo_documento=?, numero_documento=?, "
                    + "tipo_cliente=?, direccion=?, email=?, telefono=?, comercial_id=? WHERE id=?");
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellidos());
            pstm.setString(3, cliente.getTipoDocumento());
            pstm.setString(4, cliente.getNumeroDocumento());
            pstm.setInt(5, cliente.getIdTipoCliente());
            pstm.setString(6, cliente.getDireccion());
            pstm.setString(7, cliente.getEmail());
            pstm.setString(8, cliente.getTelefono());
            pstm.setInt(9, cliente.getIdComercial());
            pstm.setInt(10, cliente.getIdCliente());
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
    public boolean delete(Cliente persona) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            String sql = "DELETE FROM clientes WHERE id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, persona.getIdCliente());
            respuesta = (pstm.executeUpdate() > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return respuesta;
    }

    //metodo que retorna un objeto usuario y poder sacar datos de el con getters
    @Override
    public Cliente selectById(int idCliente) {
        conn = Conexion.getConnection();
        try {
            pstm = conn.prepareStatement("SELECT c.id, c.nombre, c.apellidos, c.tipo_documento, "
                    + "c.numero_documento, c.tipo_cliente, c.direccion, c.email, c.telefono, c.comercial_id "
                    + "FROM clientes c "
                    + "WHERE c.id = ?");
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                String tipoDocumento = rs.getString(4);
                String numeroDocumento = rs.getString(5);
                int tipoCliente = rs.getInt(6);
                String direccion = rs.getString(7);
                String email = rs.getString(8);
                String telefono = rs.getString(9);
                int idComercial = rs.getInt(10);
                cliente.setIdCliente(id);
                cliente.setNombre(nombre);
                cliente.setApellidos(apellidos);
                cliente.setTipoDocumento(tipoDocumento);
                cliente.setNumeroDocumento(numeroDocumento);
                cliente.setIdTipoCliente(tipoCliente);
                cliente.setDireccion(direccion);
                cliente.setEmail(email);
                cliente.setTelefono(telefono);
                cliente.setIdComercial(idComercial);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return cliente;
    }

    //metodo para comprobar si el cliente ya existe y no se duplique
    public boolean existe(String telefono) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            pstm = conn.prepareStatement("SELECT telefono FROM clientes WHERE telefono=?");
            pstm.setString(1, telefono);
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

    //metodo para saber a qué usuario pertenece el cliente
    public String buscarComercial(String telefono) {
        conn = Conexion.getConnection();
        String usuario = "";
        try {
            pstm = conn.prepareStatement("SELECT e.nombre, e.apellidos "
                    + "FROM clientes c "
                    + "JOIN empleados e "
                    + "ON e.id = c.comercial_id "
                    + "WHERE c.telefono=?");
            pstm.setString(1, telefono);
            rs = pstm.executeQuery();
            while (rs.next()) {
                usuario = rs.getString(1) + " " + rs.getString(2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return usuario;
    }
}
