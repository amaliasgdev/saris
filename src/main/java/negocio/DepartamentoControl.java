package negocio;

import datos.dao.DepartamentoDAO;
import datos.dao.RolDAO;
import entidades.Departamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DepartamentoControl {

    private final DepartamentoDAO DEPARTAMENTO_DAO;
    private final RolDAO ROL_DAO;
    private List<Departamento> departamentos;
    private DefaultTableModel modeloTabla;
    
    public DepartamentoControl() {
        DEPARTAMENTO_DAO = new DepartamentoDAO();
        ROL_DAO = new RolDAO();
    }

    public DefaultTableModel listar(String nombre) {
        departamentos = new ArrayList();
        departamentos.addAll(DEPARTAMENTO_DAO.select(nombre));

        String[] titulos = {"ID", "NOMBRE", "ID ROL", "ROL", "PORCENTAJE"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] registro = new String[5];

        for (Departamento item : departamentos) {
            registro[0] = String.valueOf(item.getIdDepartamento());
            registro[1] = item.getNombre();
            registro[2] = String.valueOf(item.getIdRol());
            int idRol = item.getIdRol();           
            String nombreRol = ROL_DAO.selectById(idRol).getNombreRol();
            registro[3] = nombreRol;
            registro[4] = String.valueOf(item.getPorcentaje());
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String nuevoDepartamento(Departamento departamento) {
        if (DEPARTAMENTO_DAO.existe(departamento.getNombre())) {
            return "El departamento ya existe";
        } else {               
            if (DEPARTAMENTO_DAO.insert(departamento)) {
                return "OK";
            } else {
                return "Error al registar el departamento";
            }
        }
    }

    public String modificarDepartamento(Departamento departamento) {       
        if (DEPARTAMENTO_DAO.update(departamento)) {
            return "OK";
        } else {
            return "Error en la actualización.";
        }
    }

    public String eliminarDepartamento(Departamento departamento) {       
        if (DEPARTAMENTO_DAO.delete(departamento)) {
            return "OK";
        } else {
            return "Error. No puede eliminar el departamento\nEl departamento contiene usuarios";
        }
    }

}
