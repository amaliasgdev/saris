package entidades;

import java.sql.Date;

public class Venta {

    private int idVenta;
    private String numeroFactura;
    private int idInmueble; 
    private int idSecretaria; 
    private int idComprador;    
    private double honFinales;    
    private Date fecha;

    public Venta(int idVenta, String numeroFactura, int inmuebleId, int secretariaId, int compradorId, double honFinales, Date fecha) {
        this.idVenta = idVenta;
        this.numeroFactura = numeroFactura;
        this.idInmueble = inmuebleId;
        this.idSecretaria = secretariaId;
        this.idComprador = compradorId;
        this.honFinales = honFinales;        
        this.fecha = fecha;
    }

    public Venta(Date fecha, int inmuebleId, int secretariaId, int compradorId, double honFinales) {
        this.idSecretaria = secretariaId;
        this.idComprador = compradorId;
        this.idInmueble = inmuebleId;
        this.honFinales = honFinales;
        this.fecha = fecha;
    }

    public Venta(int inmuebleId, String numeroFactura, int secretariaId, int compradorId, double honFinales, Date fecha) {
        this.numeroFactura = numeroFactura;
        this.idInmueble = inmuebleId;
        this.idSecretaria = secretariaId;
        this.idComprador = compradorId;
        this.honFinales = honFinales;       
        this.fecha = fecha;
    }   
    
  

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public int getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(int idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public double getHonFinales() {
        return honFinales;
    }

    public void setHonFinales(double honFinales) {
        this.honFinales = honFinales;
    }   

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", numeroFactura=" + numeroFactura + ", idInmueble=" + idInmueble + ", idSecretaria=" + idSecretaria + ", idComprador=" + idComprador + ", honFinales=" + honFinales + ", fecha=" + fecha + '}';
    }

    
    
}
