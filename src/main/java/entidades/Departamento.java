package entidades;

public class Departamento {
    
    private int idDepartamento;
    private String nombre;
    private int idRol;   
    private float porcentaje;    

    public Departamento() {
    }   

    public Departamento(String nombre, int rolId, float porcentaje) {
        this.nombre = nombre;
        this.idRol = rolId;
        this.porcentaje = porcentaje;
    }
    
    //constructor para eliminar departamentos
    public Departamento(int idDepartamento, String nombre, int idRol, float porcentaje) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.idRol = idRol;        
        this.porcentaje = porcentaje;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }    
}
