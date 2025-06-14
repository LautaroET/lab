package rentar.vehiculo;

import rentar.propiedadEnum.EstadoVehiculo;
import rentar.propiedadEnum.TipoDeTransmision;

public abstract class Vehiculo {

    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private int kilometraje;
    private String color;
    private int capacidadPasajeros;
    private TipoDeTransmision tipoDeTransmision;
    private boolean aireAcondicionado;
    private EstadoVehiculo estado;

    public Vehiculo(String patente, String marca, String modelo, int anio, int kilometraje, String color,
            int capacidadPasajeros, TipoDeTransmision tipoDeTransmision, boolean aireAcondicionado,
            EstadoVehiculo estado) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.color = color;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tipoDeTransmision = tipoDeTransmision;
        this.aireAcondicionado = aireAcondicionado;
        this.estado = estado;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public TipoDeTransmision getTipoDeTransmision() {
        return tipoDeTransmision;
    }

    public void setTipoDeTransmision(TipoDeTransmision tipoDeTransmision) {
        this.tipoDeTransmision = tipoDeTransmision;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public boolean isVehiculoDiponible() {
        return this.getEstado() == EstadoVehiculo.DISPONIBLE;
    }

    @Override
    public boolean equals(Object obj) {
        Vehiculo other = (Vehiculo) obj;
        return patente.equals(other.patente);
    }

}