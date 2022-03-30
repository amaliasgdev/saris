package entidades;

import java.sql.Date;

public class Llamada {
    
    private int idLlamada;
    private Date fecha;
    private String medio;
    private String zona;
    private String tipo;
    private int idVendedor;
    private int numeroLlamadas;

    //constructor para calcular el numero de llamadas por medio
    public Llamada(String medio, int numeroLlamadas) {
        this.medio = medio;
        this.numeroLlamadas = numeroLlamadas;
    }
    
    //constructor para insertar llamada
    public Llamada(Date fecha, String medio, String zona, String tipo, int idVendedor) {
        this.fecha = fecha;
        this.medio = medio;
        this.zona = zona;
        this.tipo = tipo;
        this.idVendedor = idVendedor;
    }

    //constructor para modificar llamada
    public Llamada(int id, Date fecha, String medio, String zona, String tipo, int idVendedor) {
        this.idLlamada = id;
        this.fecha = fecha;
        this.medio = medio;
        this.zona = zona;
        this.tipo = tipo;
        this.idVendedor = idVendedor;
    }    
   
    public int getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }   

    public int getNumeroLlamadas() {
        return numeroLlamadas;
    }

    public void setNumeroLlamadas(int numeroLlamadas) {
        this.numeroLlamadas = numeroLlamadas;
    }
    
}
