package entidades;

public class Rol {
    
    private int idRol;
    private String nombreRol;

    public Rol() {
    }
    
    public Rol(int idRol, String nombre) {
        this.idRol = idRol;
        this.nombreRol = nombre;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
}
