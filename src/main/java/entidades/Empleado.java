package entidades;

public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String extension;
    private String email;
    private String password;
    private int idDepartamento;
    private int idJefe;

    public Empleado() {
    }
    
    //Constructor para modificar password
    public Empleado(int idEmpleado, String password) {
        this.idEmpleado = idEmpleado;
        this.password = password;
    }

    //Constructir para listar nombres
    public Empleado(int idEmpleado, String nombre, String apellidos, int idDepartamento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idDepartamento = idDepartamento;
    }
    
    //contructor para el login
    public Empleado(String nombre, String apellidos, String password, int idDepartamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.idDepartamento = idDepartamento;
    }
     
    //constructor con todos parametros menos password para listar y selectById
    public Empleado(int idEmpleado, int idDepartamento, String nombre, String apellidos, String telefono, String extension, String email, int idJefe) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.extension = extension;
        this.email = email;
        this.idDepartamento = idDepartamento;
        this.idJefe = idJefe;
    }

    //constructor para insertar nuevo empelado sin jefe
    public Empleado(String nombre, String apellidos, String telefono, String extension, String email, String password, int idDepartamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.extension = extension;
        this.email = email;
        this.password = password;
        this.idDepartamento = idDepartamento;
    }
    
    //constructor para insertar nuevo empelado con jefe
    public Empleado(String nombre, String apellidos, String telefono, String extension, String email, String password, 
            int idJefe, int idDepartamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.extension = extension;
        this.email = email;
        this.password = password;
        this.idDepartamento = idDepartamento;
        this.idJefe = idJefe;
    }

    //constructor para modificar empleado
    public Empleado(int idEmpleado, String nombre, String apellidos, String telefono, String extension, String email, int idDepartamento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.extension = extension;
        this.email = email;
        this.idDepartamento = idDepartamento;
    }

    //contructor para modificar contraseña
    public Empleado(int idEmpleado, int idDepartamento, String nombre, String apellidos, String email, String password) {
        this.idEmpleado = idEmpleado;
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

}
