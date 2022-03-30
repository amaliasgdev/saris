package datos.dao;

import entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import datos.conexion.Conexion;

public class EmpleadoDAO implements CrudInterface<Empleado> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;    
    private List<Empleado> empleados;
    private Empleado empleado;
    private boolean respuesta;

    public EmpleadoDAO() {

    }

    @Override
    public List<Empleado> select(String texto) {
        conn = Conexion.getConnection();
        empleados = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT e.id, e.departamento_id, e.nombre, e.apellidos, e.telefono, "
                    + "e.extension, e.email,e.jefe_id "
                    + "FROM empleados e "
                    + "INNER JOIN departamentos d ON e.departamento_id=d.id "
                    + "LEFT JOIN empleados jefe ON e.jefe_id=jefe.id "
                    + "WHERE e.nombre LIKE ? "
                    + "OR e.apellidos LIKE ? "
                    + "OR d.nombre LIKE ? ORDER BY e.id");
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt(1);
                int idDepartamento = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellidos = rs.getString(4);
                String telefono = rs.getString(5);
                String extension = rs.getString(6);
                String email = rs.getString(7);
                int jefeId = rs.getInt(8);
                empleado = new Empleado(idEmpleado, idDepartamento, nombre, apellidos,telefono, extension, email, jefeId);                
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return empleados;
    }

    public List<Empleado> select(String dep1, String dep2) {
        conn = Conexion.getConnection();
        empleados = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT e.id, e.departamento_id, e.nombre, "
                    + "e.apellidos, e.telefono, e.extension, e.email, e.jefe_id "
                    + "FROM empleados e "
                    + "INNER JOIN departamentos d ON e.departamento_id=d.id "
                    + "LEFT JOIN empleados jefe ON e.jefe_id=jefe.id "
                    + "WHERE d.nombre LIKE ? "
                    + "OR d.nombre LIKE ? "
                    + "ORDER BY e.id");
            pstm.setString(1, "%" + dep1 + "%");
            pstm.setString(2, "%" + dep2 + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt(1);
                int idDepartamento = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellidos = rs.getString(4);
                String telefono = rs.getString(5);
                String extension = rs.getString(6);
                String email = rs.getString(7);
                int jefeId = rs.getInt(8);
                empleado = new Empleado(idEmpleado, idDepartamento, nombre, apellidos,telefono, extension, email, jefeId);                
                empleados.add(empleado);               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return empleados;
    }

    public List<Empleado> selectPass(String texto) {
        conn = Conexion.getConnection();
        empleados = new ArrayList();
        try {
            //Desencriptacion contraseña usuario
            //Forma de desenencriptar: cast(AES_DECRYPT(valor, key)as char)
            //Contraseña: M$Das34fdD          
            pstm = conn.prepareStatement("SELECT e.id, e.departamento_id, e.nombre, e.apellidos, e.email, "
                    + "cast(AES_DECRYPT(e.password, 'M$Das34fdD')as char) AS password, d.nombre "
                    + "FROM empleados e "
                    + "INNER JOIN departamentos d ON e.departamento_id=d.id "
                    + "WHERE e.nombre LIKE ? "
                    + "OR e.apellidos LIKE ? "
                    + "OR d.nombre LIKE ? "
                    + "ORDER BY e.id");
            pstm.setString(1, "%" + texto + "%");
            pstm.setString(2, "%" + texto + "%");
            pstm.setString(3, "%" + texto + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt(1);
                int idDepartamento = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellidos = rs.getString(4);
                String email = rs.getString(5);
                String password = rs.getString(6);
                empleado = new Empleado(idEmpleado, idDepartamento, nombre, apellidos, email, password);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return empleados;
    }

    //Lista los nombres de los usuarios segun el parametro (departamento) para las comisiones
    public List<Empleado> selectNombres(String departamento) {
        conn = Conexion.getConnection();
        empleados = new ArrayList();
        try {
            pstm = conn.prepareStatement("SELECT e.id, e.departamento_id, e.nombre, e.apellidos "
                    + "FROM empleados e "
                    + "INNER JOIN departamentos d "
                    + "ON e.departamento_id=d.id "
                    + "WHERE d.nombre LIKE ? ORDER BY e.id");
            pstm.setString(1, "%" + departamento + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt(1);
                int idDepartamento =rs.getInt(2); 
                String nombre = rs.getString(3);
                String apellidos = rs.getString(4);
                empleado = new Empleado(idEmpleado, nombre, apellidos, idDepartamento);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return empleados;
    }

    //Insertar usuario cuando no introduce nombre jefe
    @Override
    public boolean insert(Empleado empleado) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            //Encriptación del password con Cifrado AES. 
            //Tiene dos parametros: (value, key)
            //Forma de encriptar: AES_ENCRYPT(value, key)
            //Clave: M$Das34fdD
            String sql = "INSERT INTO empleados(departamento_id, nombre, apellidos, telefono, extension, email, password) "
                    + "VALUES (?,?, ?,?,?,?, AES_ENCRYPT(?,'M$Das34fdD'))";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, empleado.getIdDepartamento());
            pstm.setString(2, empleado.getNombre());
            pstm.setString(3, empleado.getApellidos());
            pstm.setString(4, empleado.getTelefono());
            pstm.setString(5, empleado.getExtension());
            pstm.setString(6, empleado.getEmail());
            pstm.setString(7, empleado.getPassword());
            //ejecutamos la sentencia. Da 1 si se ejecuta correctamente
            int cantidad = pstm.executeUpdate();
            //si da 1 ha sido agregado
            this.respuesta = (cantidad > 0);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return this.respuesta;
    }

    //Insertar usuario cuando si introduce nombre jefe
    public boolean insertUsuarioJefe(Empleado usuario) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            String sql = "INSERT INTO empleados(departamento_id, nombre, apellidos, telefono, extension, "
                    + "email, password, jefe_id) VALUES (?,?,?,?,?,?,AES_ENCRYPT(?,'M$Das34fdD'),?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, usuario.getIdDepartamento());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApellidos());
            pstm.setString(4, usuario.getTelefono());
            pstm.setString(5, usuario.getExtension());
            pstm.setString(6, usuario.getEmail());
            pstm.setString(7, usuario.getPassword());
            pstm.setInt(8, usuario.getIdJefe());
            //ejecutamos la sentencia. Da 1 si se ejecuta correctamente
            int cantidad = pstm.executeUpdate();
            //si da 1 ha sido agregado
            this.respuesta = (cantidad > 0);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return this.respuesta;
    }

    @Override
    public boolean update(Empleado usuario) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE empleados SET departamento_id =?, "
                    + "nombre=?, apellidos=?, telefono=?, extension=?, email=? WHERE id=?");
            pstm.setInt(1, usuario.getIdDepartamento());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApellidos());
            pstm.setString(4, usuario.getTelefono());
            pstm.setString(5, usuario.getExtension());
            pstm.setString(6, usuario.getEmail());
            pstm.setInt(7, usuario.getIdEmpleado());
            if (pstm.executeUpdate() > 0) {
                this.respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return this.respuesta;
    }

    public boolean updateUsuarioJefe(Empleado usuario) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE empleados SET departamento_id =?, "
                    + "nombre=?, apellidos=?, telefono=?, extension=?, email=?, jefe_id=? WHERE id=?");
            pstm.setInt(1, usuario.getIdDepartamento());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApellidos());
            pstm.setString(4, usuario.getTelefono());
            pstm.setString(5, usuario.getExtension());
            pstm.setString(6, usuario.getEmail());
            pstm.setInt(7, usuario.getIdJefe());
            pstm.setInt(8, usuario.getIdEmpleado());
            if (pstm.executeUpdate() > 0) {
                this.respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(conn);
        }
        return this.respuesta;
    }

    public boolean updatePassword(Empleado usuario) {
        conn = Conexion.getConnection();
        this.respuesta = false;
        try {
            pstm = conn.prepareStatement("UPDATE empleados SET password=AES_ENCRYPT(?,'M$Das34fdD') WHERE id=?");
            pstm.setString(1, usuario.getPassword());
            pstm.setInt(2, usuario.getIdEmpleado());
            if (pstm.executeUpdate() > 0) {
                this.respuesta = true;
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
    public boolean delete(Empleado object) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            String sql = "DELETE FROM empleados WHERE id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, object.getIdEmpleado());
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
    public Empleado selectById(int idEmpleado) {
        conn = Conexion.getConnection();
        try {
            pstm = conn.prepareStatement("SELECT e.id, e.departamento_id, e.nombre, e.apellidos, e.telefono,e.extension, "
                    + "e.email, e.jefe_id "
                    + "FROM empleados e WHERE e.id =?");
            pstm.setInt(1, idEmpleado);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int departamentoId = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellidos = rs.getString(4);
                String telefono = rs.getString(5);
                String extension = rs.getString(6);
                String email = rs.getString(7);                
                int jefeId = rs.getInt(8);
                empleado = new Empleado(id, departamentoId,nombre, apellidos, telefono, extension, email, jefeId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return empleado;
    }

    //METODO PROPIO PARA COMPROBAR SI EXISTE UN USUARIO Y NO DUPLICITAR EN ALTAS
    public boolean existe(String email) {
        conn = Conexion.getConnection();
        respuesta = false;
        try {
            pstm = conn.prepareStatement("SELECT email FROM empleados WHERE email=?");
            pstm.setString(1, email);
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

    // OBTENER ID DEL USUARIO PARA DAR DE ALTA UN CLIENTE
    public int getIdUsuario(String nombreEmpleado, String apellidosEmpleado) {
        conn = Conexion.getConnection();
        int codigoUsuario = 0;
        try {
            pstm = conn.prepareStatement("SELECT id FROM empleados WHERE nombre=? AND apellidos=?");
            pstm.setString(1, nombreEmpleado);
            pstm.setString(2, apellidosEmpleado);
            rs = pstm.executeQuery();
            while (rs.next()) {
                codigoUsuario = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return codigoUsuario;
    }

    // OBTENER PORCENTAJE PARA COMISIONES
    public double getPorcentajeUsuario(int idDepartamento) {
        conn = Conexion.getConnection();
        double porcentaje = 0;
        try {
            pstm = conn.prepareStatement("SELECT porcentaje FROM departamentos WHERE id=?");
            pstm.setInt(1, idDepartamento);
            rs = pstm.executeQuery();
            while (rs.next()) {
                porcentaje = rs.getDouble("porcentaje");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return porcentaje;
    }

    public Empleado login(String emailLogin) {
        conn = Conexion.getConnection();
        try {
            pstm = conn.prepareStatement("SELECT e.departamento_id, e.nombre, e.apellidos, cast(AES_DECRYPT(e.password, 'M$Das34fdD')as char) AS password, d.nombre, d.rol_id "
                    + "FROM empleados e "
                    + "JOIN departamentos d "
                    + "ON e.departamento_id=d.id "
                    + "WHERE e.email=?");
            pstm.setString(1, emailLogin);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idDepartamento = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);              
                String password = rs.getString(4);
                empleado = new Empleado(nombre, apellidos, password, idDepartamento);                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.close(pstm);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return empleado;
    }
}
