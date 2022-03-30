package entidades;

public class TipoCliente {
    
    private int idTipoCliente;
    private String nombreTipo;

    public TipoCliente() {
    }

    public TipoCliente(int idTipoCliente, String tipo) {
        this.idTipoCliente = idTipoCliente;
        this.nombreTipo = tipo;
    }

    public int getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
