package negocio;

import datos.dao.EmpleadoDAO;
import datos.dao.LlamadaDAO;
import entidades.Empleado;
import entidades.Llamada;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class LlamadaControl {

    private final LlamadaDAO LLAMADA_DAO;
    private final EmpleadoDAO EMPLEADO_DAO;
    private DefaultTableModel modeloTabla;
    private Empleado empleado;    

    public LlamadaControl() {
        LLAMADA_DAO = new LlamadaDAO();
        EMPLEADO_DAO = new EmpleadoDAO();
    }

    public DefaultTableModel listar(Date dia) {
        List<Llamada> lista = new ArrayList();
        lista.addAll(LLAMADA_DAO.select(dia));

        String[] titulos = {"ID", "FECHA", "MEDIO", "ZONA", "TIPO OPERACION", "VENDEDOR_ID", "VENDEDOR"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] registro = new String[7];

        for (Llamada item : lista) {
            registro[0] = String.valueOf(item.getIdLlamada());
            Date fecha = item.getFecha();
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFactura = fmt.format(fecha);
            registro[1] = fechaFactura;
            registro[2] = item.getMedio();
            registro[3] = item.getZona();
            registro[4] = item.getTipo();
            registro[5] = String.valueOf(item.getIdVendedor());
            //EMPLEADO
            int empleadoId = item.getIdVendedor();
            empleado = EMPLEADO_DAO.selectById(empleadoId);
            registro[6] = empleado.getNombre() + " " + empleado.getApellidos();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listar(Date inicio, Date fin) {
        List<Llamada> lista = new ArrayList();
        lista.addAll(LLAMADA_DAO.select(inicio, fin));
        String[] titulos = {"ID", "FECHA", "MEDIO", "ZONA", "TIPO OPERACION", "VENDEDOR_ID", "VENDEDOR"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] registro = new String[7];

        for (Llamada item : lista) {
            registro[0] = String.valueOf(item.getIdLlamada());
            Date fecha = item.getFecha();
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            String fechaFactura = fmt.format(fecha);
            registro[1] = fechaFactura;
            registro[2] = item.getMedio();
            registro[3] = item.getZona();
            registro[4] = item.getTipo();
            registro[5] = String.valueOf(item.getIdVendedor());
             //EMPLEADO
            int empleadoId = item.getIdVendedor();
            empleado = EMPLEADO_DAO.selectById(empleadoId);
            registro[6] = empleado.getNombre() + " " + empleado.getApellidos();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listarTablaLlamadaMedios(java.sql.Date fecha) {
        List<Llamada> lista = new ArrayList();
        lista.addAll(LLAMADA_DAO.tablaLlamadasMedios(fecha));
        String[] titulos = {"MEDIO", "NUMERO LLAMADAS"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[2];
        for (Llamada item : lista) {
            registro[0] = item.getMedio();
            registro[1] = String.valueOf(item.getNumeroLlamadas());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listarTablaLlamadaMedios(java.sql.Date inicio, java.sql.Date fin) {
        List<Llamada> lista = new ArrayList();
        lista.addAll(LLAMADA_DAO.tablaLlamadasMedios(inicio, fin));
        String[] titulos = {"MEDIO", "NUMERO LLAMADAS"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] registro = new String[2];
        for (Llamada item : lista) {
            registro[0] = item.getMedio();
            registro[1] = String.valueOf(item.getNumeroLlamadas());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public int numeroLlamadas(int idVendedor, Date fecha) {
        return LLAMADA_DAO.numeroLlamadas(idVendedor, fecha);
    }

    public String nuevaLlamada(Llamada llamada) {       
        if (LLAMADA_DAO.insert(llamada)) {
            return "OK";
        } else {
            return "Error al guardar la llamada";
        }
    }

    public String modificarLlamada(Llamada llamada) {       
        if (LLAMADA_DAO.update(llamada)) {
            return "OK";
        } else {
            return "Error en la actualización de la llamada";
        }
    }
}
