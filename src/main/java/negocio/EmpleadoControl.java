package negocio;

import datos.dao.DepartamentoDAO;
import datos.dao.LlamadaDAO;
import datos.dao.EmpleadoDAO;
import entidades.Departamento;
import entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadoControl {

    private final EmpleadoDAO EMPLEADO_DAO;
    private final DepartamentoDAO DEPARTAMENTO_DAO;
    private Departamento departamento;
    private Empleado empleado;
    private List<Empleado> empleados;
    private DefaultTableModel modeloTabla;
    public static int tipoAcceso;

    public EmpleadoControl() {
        EMPLEADO_DAO = new EmpleadoDAO();
        DEPARTAMENTO_DAO = new DepartamentoDAO();
        departamento = new Departamento();
        empleado = new Empleado();
    }

    public DefaultTableModel listar(String texto) {
        empleados = new ArrayList();
        empleados.addAll(EMPLEADO_DAO.select(texto));

        String[] titulos = {"ID", "NOMBRE", "APELLIDOS", "EXT", "EMAIL", "TELÉFONO",
            "ID DEPARTAMENTO", "DPTO", "ID JEFE", "JEFE DPTO"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] registro = new String[10];

        for (Empleado item : empleados) {
            registro[0] = Integer.toString(item.getIdEmpleado());
            registro[1] = item.getNombre();
            registro[2] = item.getApellidos();
            registro[3] = item.getExtension();
            registro[4] = item.getEmail();
            registro[5] = item.getTelefono();
            //Departamento
            int idDepartamento = item.getIdDepartamento();
            departamento = DEPARTAMENTO_DAO.selectById(idDepartamento);
            registro[6] = Integer.toString(idDepartamento);
            registro[7] = departamento.getNombre();
            //Jefe Empleado
            int idJefe = item.getIdJefe();
            empleado = EMPLEADO_DAO.selectById(idJefe);
            registro[8] = Integer.toString(item.getIdJefe());
            registro[9] = empleado.getNombre() + " " + empleado.getApellidos();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listar(String dep1, String dep2) {
        empleados = new ArrayList();
        empleados.addAll(EMPLEADO_DAO.select(dep1, dep2));
        String[] titulos = {"ID", "NOMBRE", "APELLIDOS", "EXT", "EMAIL", "TELÉFONO",
            "ID DEPARTAMENTO", "DPTO", "ID JEFE", "JEFE DPTO"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[10];

        for (Empleado item : empleados) {
            registro[0] = Integer.toString(item.getIdEmpleado());
            registro[1] = item.getNombre();
            registro[2] = item.getApellidos();
            registro[3] = item.getExtension();
            registro[4] = item.getEmail();
            registro[5] = item.getTelefono();
            //Departamento
            int idDepartamento = item.getIdDepartamento();
            this.departamento = DEPARTAMENTO_DAO.selectById(idDepartamento);
            registro[6] = Integer.toString(idDepartamento);
            registro[7] = departamento.getNombre();
            //Jefe Empleado
            int idJefe = item.getIdJefe();
            empleado = EMPLEADO_DAO.selectById(idJefe);
            registro[8] = Integer.toString(item.getIdJefe());
            registro[9] = empleado.getNombre() + " " + empleado.getApellidos();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    //Lista los nombres de los usuarios segun el parametro (departamento) para las comisiones
    public DefaultTableModel listarNombres(String departamento) {
        empleados = new ArrayList();
        empleados.addAll(EMPLEADO_DAO.selectNombres(departamento));
        String[] titulos = {"ID", "NOMBRE", "APELLIDOS", "DPTO", "%"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] registro = new String[5];
        for (Empleado item : empleados) {
            registro[0] = Integer.toString(item.getIdEmpleado());
            registro[1] = item.getNombre();
            registro[2] = item.getApellidos();
            //DEPARTAMENTO
            int idDepartamento = item.getIdDepartamento();
            this.departamento = DEPARTAMENTO_DAO.selectById(idDepartamento);
            registro[3] = this.departamento.getNombre();
            registro[4] = Float.toString(this.departamento.getPorcentaje());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listarPass(String texto) {
        List<Empleado> usuarios = new ArrayList();
        usuarios.addAll(EMPLEADO_DAO.selectPass(texto));
        String[] titulos = {"ID", "DEPARTAMENTO", "NOMBRE", "APELLIDOS", "EMAIL", "PASSWORD"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[6];
        for (Empleado item : usuarios) {
            registro[0] = Integer.toString(item.getIdEmpleado());
            //DEPARTAMENTO
            int idDepartamento = item.getIdDepartamento();
            this.departamento = DEPARTAMENTO_DAO.selectById(idDepartamento);
            registro[1] = this.departamento.getNombre();
            registro[2] = item.getNombre();
            registro[3] = item.getApellidos();
            registro[4] = item.getEmail();
            registro[5] = item.getPassword();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    //listar nombre empleados para mostrar en "Llamadas"
    public DefaultTableModel listarNombresId(String texto, java.sql.Date fecha) {
        empleados = new ArrayList();
        empleados.addAll(EMPLEADO_DAO.select("Ventas"));
        String[] titulos = {"ID", "NOMBRE", "NUMERO DE LLAMADAS"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[3];
        for (Empleado item : empleados) {
            int idVendedor = item.getIdEmpleado();
            registro[0] = Integer.toString(idVendedor);
            registro[1] = item.getNombre() + " " + item.getApellidos();
            LlamadaDAO llamada = new LlamadaDAO();
            registro[2] = Integer.toString(llamada.numeroLlamadas(idVendedor, fecha));
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }
    //listar nombre empleados para mostrar en "Llamadas"
    public DefaultTableModel listarNombresId(String texto, java.sql.Date inicio, java.sql.Date fin) {
        empleados = new ArrayList();
        empleados.addAll(EMPLEADO_DAO.select("Ventas"));
        String[] titulos = {"ID", "NOMBRE", "NUMERO DE LLAMADAS"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[3];
        for (Empleado item : empleados) {
            int idVendedor = item.getIdEmpleado();
            registro[0] = Integer.toString(idVendedor);
            registro[1] = item.getNombre() + " " + item.getApellidos();
            LlamadaDAO llamada = new LlamadaDAO();
            registro[2] = Integer.toString(llamada.numeroLlamadas(idVendedor, inicio, fin));
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String eliminarEmpleado(Empleado empleado) {
        if (EMPLEADO_DAO.delete(empleado)) {
            return "OK";
        } else {
            return "Error. No puede eliminar al usuario";
        }
    }

    public String nuevoEmpleado(Empleado empleado) {
        if (EMPLEADO_DAO.existe(empleado.getEmail())) {
            return "El registro ya existe.";
        } else {            
            if (EMPLEADO_DAO.insert(empleado)) {
                return "OK";
            } else {
                return "Error al ingresar el nuevo empleado";
            }
        }
    }
    
    public String nuevoEmpleadoJefe(Empleado empleado) {
        if (EMPLEADO_DAO.existe(empleado.getEmail())) {
            return "El registro ya existe.";
        } else {           
            if (EMPLEADO_DAO.insertUsuarioJefe(empleado)) {
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }
    }

    public String modificarEmpleado(Empleado empleado) {       
        if (EMPLEADO_DAO.update(empleado)) {
            return "OK";
        } else {
            return "El empleado no se ha podido modificar";
        }
    }    
    
    public String modificarEmpleadoJefe(Empleado empleado) {    
        if (EMPLEADO_DAO.updateUsuarioJefe(empleado)) {
            return "OK";
        } else {
            return "El empleado no se ha podido modificar";
        }
    }

    public String modificarPassword(Empleado empleado) {       
        if (EMPLEADO_DAO.updatePassword(empleado)) {
            return "OK";
        } else {
            return "Error al atualizar la contraseña";
        }
    }


    public Empleado selectByID(int idUsuario) {
        empleado = EMPLEADO_DAO.selectById(idUsuario);
        return empleado;
    }

    public int login(String emailLogin, String passwordLogin) {
        int acceso = 0;
        if (EMPLEADO_DAO.existe(emailLogin)) {
            empleado = EMPLEADO_DAO.login(emailLogin);
            String password = empleado.getPassword();
            int idDepartamento = empleado.getIdDepartamento();
            departamento = this.DEPARTAMENTO_DAO.selectById(idDepartamento);
            int idRol = departamento.getIdRol();
            if (password.equals(passwordLogin)) { //si coincide la password introducida con la almacenada en la BD                
                tipoAcceso = idRol;
                acceso = 1;// accede a la aplicación
                JOptionPane.showMessageDialog(null, "Nombre empleado: " + (empleado.getNombre() + " " + empleado.getApellidos()) + "\nDepartamento: " + departamento.getNombre());
            } else {
                acceso = 2;
            }
        } else {
            //No hay usuario con ese email
            acceso = 3;
        }
        return acceso;
    }

}
