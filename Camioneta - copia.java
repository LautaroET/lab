package rentar.vehiculo;

import rentar.propiedadEnum.EstadoVehiculo;
import rentar.propiedadEnum.TipoCabina;
import rentar.propiedadEnum.TipoDeTransmision;

public  abstract class Camioneta extends Vehiculo {
    private double capacidadCarga;
    private boolean dobleTraccion;
    private TipoCabina tipoCabina;
    private Caja caja;
    private boolean suspensionDelanteraIndependiente;
    private boolean suspensionTraseraIndependiente;
    private boolean asistenciaPendiente;

    

    public Camioneta(String patente, String marca, String modelo, int anio, int kilometraje, String color,
            int capacidadPasajeros, TipoDeTransmision tipoDeTransmision, boolean aireAcondicionado,
            EstadoVehiculo estado, double capacidadCarga, boolean dobleTraccion, TipoCabina tipoCabina, Caja caja,
            boolean suspensionDelanteraIndependiente, boolean suspensionTraseraIndependiente,
            boolean asistenciaPendiente) {
        super(patente, marca, modelo, anio, kilometraje, color, capacidadPasajeros, tipoDeTransmision,
                aireAcondicionado, estado);
        this.capacidadCarga = capacidadCarga;
        this.dobleTraccion = dobleTraccion;
        this.tipoCabina = tipoCabina;
        this.caja = caja;
        this.suspensionDelanteraIndependiente = suspensionDelanteraIndependiente;
        this.suspensionTraseraIndependiente = suspensionTraseraIndependiente;
        this.asistenciaPendiente = asistenciaPendiente;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public boolean isDobleTraccion() {
        return dobleTraccion;
    }

    public void setDobleTraccion(boolean dobleTraccion) {
        this.dobleTraccion = dobleTraccion;
    }

    public TipoCabina getTipoCabina() {
        return tipoCabina;
    }

    public void setTipoCabina(TipoCabina tipoCabina) {
        this.tipoCabina = tipoCabina;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public boolean isSuspensionDelanteraIndependiente() {
        return suspensionDelanteraIndependiente;
    }

    public void setSuspensionDelanteraIndependiente(boolean suspensionDelanteraIndependiente) {
        this.suspensionDelanteraIndependiente = suspensionDelanteraIndependiente;
    }

    public boolean isSuspensionTraseraIndependiente() {
        return suspensionTraseraIndependiente;
    }

    public void setSuspensionTraseraIndependiente(boolean suspensionTraseraIndependiente) {
        this.suspensionTraseraIndependiente = suspensionTraseraIndependiente;
    }

    public boolean isAsistenciaPendiente() {
        return asistenciaPendiente;
    }

    public void setAsistenciaPendiente(boolean asistenciaPendiente) {
        this.asistenciaPendiente = asistenciaPendiente;
    }
}



