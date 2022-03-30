package entidades;

public class Inmueble {
    
    private int idInmueble;
    private String tipoInmueble;
    private String direccion;
    private String provincia;
    private String localidad;
    private String zona;
    private String tipoOperacion;
    private double precioVenta;
    private double honorarios;   
    private int idPropietario;  
    private int idEstado;

    public Inmueble() {
    }

    //constructor para modificar el inmueble
    public Inmueble(int idInmueble, String tipo, String direccion, String provincia, String localidad, 
            String zona, String tipoOperacion, double precioVenta, double honorarios,  
            int propietarioId, int idEstado) {
        this.idInmueble = idInmueble;
        this.tipoInmueble = tipo;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
        this.zona = zona;
        this.tipoOperacion = tipoOperacion;
        this.precioVenta = precioVenta;
        this.honorarios = honorarios;        
        this.idPropietario = propietarioId;
        this.idEstado = idEstado;
    }
    
    //constructor para insertar un inmueble
    public Inmueble(String tipo, String direccion, String provincia, String localidad, String zona, 
            String tipoOperacion, double precioVenta, double honorarios, int propietarioId, int idEstado) {
        this.tipoInmueble = tipo;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
        this.zona = zona;
        this.tipoOperacion = tipoOperacion;
        this.precioVenta = precioVenta;
        this.honorarios = honorarios;        
        this.idPropietario = propietarioId;
        this.idEstado = idEstado;
    }

    
    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(double honorarios) {
        this.honorarios = honorarios;
    }

   
    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }


    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    
}
