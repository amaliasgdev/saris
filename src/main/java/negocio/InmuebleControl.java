package negocio;

import datos.dao.ClienteDAO;
import datos.dao.EmpleadoDAO;
import datos.dao.EstadoInmuebleDAO;
import datos.dao.InmuebleDAO;
import entidades.Cliente;
import entidades.Empleado;
import entidades.EstadoInmueble;
import entidades.Inmueble;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InmuebleControl {

    private final InmuebleDAO INMUEBLE_DAO;
    private final ClienteDAO CLIENTE_DAO;
    private final EmpleadoDAO EMPLEADO_DAO;
    private final EstadoInmuebleDAO ESTADO_DAO;
    private DefaultTableModel modeloTabla;
    private Cliente cliente;
    private Empleado empleado;
    private EstadoInmueble estado;

    public InmuebleControl() {
        INMUEBLE_DAO = new InmuebleDAO();
        CLIENTE_DAO = new ClienteDAO();
        EMPLEADO_DAO = new EmpleadoDAO();
        ESTADO_DAO = new EstadoInmuebleDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<Inmueble> inmuebles = new ArrayList();
        inmuebles.addAll(INMUEBLE_DAO.select(texto));
        String[] titulos = {"ID", "TIPO", "DIRECCIÓN", "PROVINCIA", "LOCALIDAD", "ZONA", "OPERACION",
            "PRECIO VENTA", "HONORARIOS", "ID CAPTADOR", "CAPTADOR", "ID PROPIETARIO", "DNI PROP", "NOMBRE PROP",
            "APELL PROP", "TFNO PROPIETARIO", "ESTADO"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[17];
        for (Inmueble item : inmuebles) {
            registro[0] = Integer.toString(item.getIdInmueble());
            registro[1] = item.getTipoInmueble();
            registro[2] = item.getDireccion();
            registro[3] = item.getProvincia();
            registro[4] = item.getLocalidad();
            registro[5] = item.getZona();
            registro[6] = item.getTipoOperacion();
            registro[7] = Double.toString(item.getPrecioVenta());
            registro[8] = Double.toString(item.getHonorarios());
            //DATOS EMPLEADO Y PROPIETARIO
            int idPropietario = item.getIdPropietario();
            cliente = CLIENTE_DAO.selectById(idPropietario);
            int idCaptador = cliente.getIdComercial();
            empleado = EMPLEADO_DAO.selectById(idCaptador);
            registro[9] = Integer.toString(idCaptador);
            registro[10] = empleado.getNombre() + " " + empleado.getApellidos();
            registro[11] = Integer.toString(item.getIdPropietario());
            registro[12] = cliente.getNumeroDocumento();
            registro[13] = cliente.getNombre();
            registro[14] = cliente.getApellidos();
            registro[15] = cliente.getNumeroDocumento();
            //ESTADO INMUEBLE
            int idEstado = item.getIdEstado();
            estado = ESTADO_DAO.selectById(idEstado);
            registro[16] = estado.getEstado();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listar(String texto, String disponibilidad) {
        List<Inmueble> inmuebles = new ArrayList();
        inmuebles.addAll(INMUEBLE_DAO.selectEstado(texto, disponibilidad));
        String[] titulos = {"ID", "TIPO", "DIRECCIÓN", "PROVINCIA", "LOCALIDAD", "ZONA", "OPERACION",
            "PRECIO VENTA", "HONORARIOS", "ID CAPTADOR", "CAPTADOR", "ID PROPIETARIO", "DNI PROPIETARIO", "NOMBRE PROPIETARIO",
            "APELLIDOS", "TFNO PROPIETARIO", "ESTADO", "TIPO DOCUM"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[18];
        for (Inmueble item : inmuebles) {
            registro[0] = Integer.toString(item.getIdInmueble());
            registro[1] = item.getTipoInmueble();
            registro[2] = item.getDireccion();
            registro[3] = item.getProvincia();
            registro[4] = item.getLocalidad();
            registro[5] = item.getZona();
            registro[6] = item.getTipoOperacion();
            registro[7] = Double.toString(item.getPrecioVenta());
            registro[8] = Double.toString(item.getHonorarios());
            //DATOS EMPLEADO Y PROPIETARIO
            int idPropietario = item.getIdPropietario();
            cliente = CLIENTE_DAO.selectById(idPropietario);
            int idCaptador = cliente.getIdComercial();
            empleado = EMPLEADO_DAO.selectById(idCaptador);
            registro[9] = Integer.toString(idCaptador);
            registro[10] = empleado.getNombre() + " " + empleado.getApellidos();
            registro[11] = Integer.toString(item.getIdPropietario());
            registro[12] = cliente.getNumeroDocumento();
            registro[13] = cliente.getNombre();
            registro[14] = cliente.getApellidos();
            registro[15] = cliente.getNumeroDocumento();
            //ESTADO INMUEBLE
            int idEstado = item.getIdEstado();
            estado = ESTADO_DAO.selectById(idEstado);
            registro[16] = estado.getEstado();
            registro[17] = cliente.getTipoDocumento();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listar(String tipo, String provincia, String localidad, String zona, String disponibilidad) {
        List<Inmueble> inmuebles = new ArrayList();
        inmuebles.addAll(INMUEBLE_DAO.select(tipo, provincia, localidad, zona, disponibilidad));
        String[] titulos = {"ID", "TIPO", "DIRECCIÓN", "PROVINCIA", "LOCALIDAD", "ZONA", "OPERACION",
            "PRECIO VENTA", "HONORARIOS", "ID CAPTADOR", "CAPTADOR", "ID PROPIETARIO", "DNI PROPIETARIO", "PROPIETARIO",
            "TFNO PROPIETARIO", "ESTADO"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[16];
        for (Inmueble item : inmuebles) {
            registro[0] = Integer.toString(item.getIdInmueble());
            registro[1] = item.getTipoInmueble();
            registro[2] = item.getDireccion();
            registro[3] = item.getProvincia();
            registro[4] = item.getLocalidad();
            registro[5] = item.getZona();
            registro[6] = item.getTipoOperacion();
            registro[7] = Double.toString(item.getPrecioVenta());
            registro[8] = Double.toString(item.getHonorarios());
            //DATOS EMPLEADO Y PROPIETARIO
            int idPropietario = item.getIdPropietario();
            cliente = CLIENTE_DAO.selectById(idPropietario);
            int idCaptador = cliente.getIdComercial();
            empleado = EMPLEADO_DAO.selectById(idCaptador);
            registro[9] = Integer.toString(idCaptador);
            registro[10] = empleado.getNombre() + " " + empleado.getApellidos();
            registro[11] = Integer.toString(idPropietario);
            registro[12] = cliente.getNumeroDocumento();
            registro[13] = cliente.getNombre() + " " + cliente.getApellidos();
            registro[14] = cliente.getTelefono();
            //ESTADO INMUEBLE
            int idEstado = item.getIdEstado();
            estado = ESTADO_DAO.selectById(idEstado);
            registro[15] = estado.getEstado();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String nuevoInmueble(Inmueble inmueble) {
        if (INMUEBLE_DAO.existe(inmueble.getDireccion())) {
            return "El inmueble ya existe.";
        } else {           
            if (INMUEBLE_DAO.insert(inmueble)) {
                return "OK";
            } else {
                return "Error al insertar el inmueble";
            }
        }
    }

    public String eliminarInmueble(int idInmueble) {
        Inmueble inmueble = INMUEBLE_DAO.selectById(idInmueble);
        if (INMUEBLE_DAO.delete(inmueble)) {
            return "OK";
        } else {
            return "Error. No puede eliminar el inmueble";
        }
    }

    public String modificarInmueble(Inmueble inmueble) {
        if (INMUEBLE_DAO.update(inmueble)) {
            return "OK";
        } else {
            return "Error en la actualización del inmueble.";
        }
    }

    public String modificarEstado(int id, int nuevoEstado) {
        Inmueble inmueble = INMUEBLE_DAO.selectById(id);
        if (INMUEBLE_DAO.updateEstado(inmueble, nuevoEstado)) {
            return "OK";
        } else {
            return "Error en la actualización del estado del inmueble.";
        }
    }

}
