package negocio;

import entidades.EstadoInmueble;
import java.util.ArrayList;
import java.util.List;
import datos.dao.EstadoInmuebleDAO;

public class EstadoInmuebleControl {

    private final EstadoInmuebleDAO ESTADO_INMUEBLE_DAO;

    public EstadoInmuebleControl() {
        this.ESTADO_INMUEBLE_DAO = new EstadoInmuebleDAO();
    }

    public List<EstadoInmueble> listar() {
        List<EstadoInmueble> estados = new ArrayList();
        try {
            estados = ESTADO_INMUEBLE_DAO.select();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return estados;
    }

}
