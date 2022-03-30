package negocio;

import datos.dao.RolDAO;
import entidades.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RolControl {

    private final RolDAO ROL_DAO;
    private DefaultTableModel modeloTabla;

    public RolControl() {
        this.ROL_DAO = new RolDAO();
    }

    public DefaultTableModel listar() {
        List<Rol> lista = new ArrayList();
        lista.addAll(ROL_DAO.select());
        
        String[] titulos = {"CODIGO", "NOMBRE"};
        this.modeloTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] registro = new String[2];
        for (Rol item : lista) {
            registro[0] = String.valueOf(item.getIdRol());
            registro[1] = item.getNombreRol();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

}
