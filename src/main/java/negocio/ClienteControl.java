package negocio;

import datos.dao.ClienteDAO;
import datos.dao.EmpleadoDAO;
import datos.dao.TipoClienteDAO;
import entidades.Cliente;
import entidades.Empleado;
import entidades.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteControl {

    private final ClienteDAO CLIENTE_DAO;
    private final EmpleadoDAO EMPLEADO_DAO;
    private final TipoClienteDAO TIPO_CLIENTE_DAO;
    private TipoCliente tipoCliente;
    private Empleado empleado;
    private DefaultTableModel modeloTabla;
    private List<Cliente> clientes;

    public ClienteControl() {
        CLIENTE_DAO = new ClienteDAO();
        EMPLEADO_DAO = new EmpleadoDAO();
        TIPO_CLIENTE_DAO = new TipoClienteDAO();
    }

    public DefaultTableModel listar(String texto) {

        clientes = new ArrayList();
        clientes.addAll(CLIENTE_DAO.select(texto));
        String[] titulos = {"ID", "NOMBRE", "APELLIDOS", "TIPO", "NºDOCUMENTO", "PROP/COMP", "DIRECCIÓN",
            "EMAIL", "TELEFONO", "ID COMERCIAL", "COMERCIAL"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[11];
        for (Cliente item : clientes) {
            registro[0] = Integer.toString(item.getIdCliente());
            registro[1] = item.getNombre();
            registro[2] = item.getApellidos();
            registro[3] = item.getTipoDocumento();
            registro[4] = item.getNumeroDocumento();
            int idTipoCliente = item.getIdTipoCliente();
            tipoCliente = TIPO_CLIENTE_DAO.selectById(idTipoCliente);
            registro[5] = tipoCliente.getNombreTipo();
            registro[6] = item.getDireccion();
            registro[7] = item.getEmail();
            registro[8] = item.getTelefono();
            registro[9] = Integer.toString(item.getIdComercial());
            int empleadoId = item.getIdComercial();
            empleado = EMPLEADO_DAO.selectById(empleadoId);
            registro[10] = empleado.getNombre() + " " + empleado.getApellidos();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String eliminarCliente(int idPersona) {

        Cliente persona = CLIENTE_DAO.selectById(idPersona);
        if (CLIENTE_DAO.delete(persona)) {
            return "OK";
        } else {
            return "Error. No puede eliminar al cliente\nEl cliente tiene datos asociados";
        }
    }
   
    public String nuevoCliente(Cliente cliente) {
        if (CLIENTE_DAO.existe(cliente.getTelefono())) {
            return "El registro ya existe.";
        } else {   
            if (CLIENTE_DAO.insert(cliente)) {
                return "OK";
            } else {
                return "Error al registar el cliente";
            }
        }
    }

    public String modificarCliente(Cliente cliente){
        if (CLIENTE_DAO.update(cliente)) {
            return "OK";
        } else {
            return "Error en la actualización.";
        }
    }

    public Cliente selectByID(int idCliente) {
        Cliente persona = new Cliente();
        try {
            persona = CLIENTE_DAO.selectById(idCliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay ningun codigo de usuario con ese nombre");
        }
        return persona;
    }

    public boolean existe(String telefono) {
        return CLIENTE_DAO.existe(telefono);
    }

    public String buscarComercial(String telefono) {
        return CLIENTE_DAO.buscarComercial(telefono);
    }
}
