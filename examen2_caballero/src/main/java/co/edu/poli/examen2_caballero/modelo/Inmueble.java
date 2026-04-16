package co.edu.poli.examen2_caballero.modelo;

public abstract class Inmueble {

    protected String numero;
    protected String fechaCompra;
    protected String estado;
    protected Propietario propietario;

    public Inmueble() {}

    public Inmueble(String numero, String fechaCompra, String estado, Propietario propietario) {
        this.numero = numero;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.propietario = propietario;
    }

    // Getters y setters

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}