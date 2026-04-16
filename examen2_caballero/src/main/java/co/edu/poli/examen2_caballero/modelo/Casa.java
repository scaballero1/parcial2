package co.edu.poli.examen2_caballero.modelo;

public class Casa extends Inmueble {

    private int cantidadPisos;

    public Casa(String numero, String fechaCompra, String estado, Propietario propietario, int cantidadPisos) {
        super(numero, fechaCompra, estado, propietario);
        this.cantidadPisos = cantidadPisos;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }
}