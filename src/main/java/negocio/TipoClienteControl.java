package negocio;

import entidades.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import datos.dao.TipoClienteDAO;

public class TipoClienteControl {

    private final TipoClienteDAO TIPO_CLIENTE_DAO;

    public TipoClienteControl() {
        this.TIPO_CLIENTE_DAO = new TipoClienteDAO();
    }

    public List<TipoCliente> listar() {
        List<TipoCliente> tipos = new ArrayList();
        try {
            tipos = TIPO_CLIENTE_DAO.select();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return tipos;
    }

}
