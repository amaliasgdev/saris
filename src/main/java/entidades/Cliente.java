package entidades;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private int idTipoCliente;   
    private String direccion;
    private String email;
    private String telefono;
    private int idComercial;
    

    public Cliente() {
    }

    //Constructor para insertar 
    public Cliente(String nombre, String apellidos, String tipoDocumento, String numeroDocumento, int idTipoCliente, String direccion, 
            String email, String telefono, int idComercial) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.idTipoCliente = idTipoCliente;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.idComercial = idComercial;
    }

    //constructor para modificar 
    public Cliente(int idPersona, String nombre, String apellidos, String tipoDocumento, String numeroDocumento, int idTipoCliente, String direccion, String email, String telefono, int idComercial) {
        this.idCliente = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.idTipoCliente = idTipoCliente;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.idComercial = idComercial;
    }

    //contructor para listar persona
    public Cliente(int idPersona, String nombre, String apellidos, String tipoDocumento, String numeroDocumento, String direccion, String email, String telefono, int idComercial) {
        this.idCliente = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;        
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.idComercial = idComercial;        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(int idComercial) {
        this.idComercial = idComercial;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", idTipoCliente=" + idTipoCliente + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + ", idComercial=" + idComercial + '}';
    }


    
    
}
