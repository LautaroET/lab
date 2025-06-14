package rentar.vehiculo;

import rentar.propiedadEnum.SistemaVentilacionTrasera;
import rentar.propiedadEnum.EstadoVehiculo;
import rentar.propiedadEnum.RevestimientoInterior;
import rentar.propiedadEnum.TipoDePuertasTraseras;
import rentar.propiedadEnum.TipoDeTransmision;

public abstract class Furgoneta extends Vehiculo {
    private boolean puertaLateralCorrediza;
    private double alturaInterior;
    private TipoDePuertasTraseras tipoPuertasTraseras;
    private RevestimientoInterior revestimientoInterior;
    private int anclajesCarga;
    private boolean escalonAccesoTrasero;
    private SistemaVentilacionTrasera sistemaVentilacionTrasera;

    

    public Furgoneta(String patente, String marca, String modelo, int anio, int kilometraje, String color,
            int capacidadPasajeros, TipoDeTransmision tipoDeTransmision, boolean aireAcondicionado,
            EstadoVehiculo estado, boolean puertaLateralCorrediza, double alturaInterior,
            TipoDePuertasTraseras tipoPuertasTraseras, RevestimientoInterior revestimientoInterior, int anclajesCarga,
            boolean escalonAccesoTrasero, SistemaVentilacionTrasera sistemaVentilacionTrasera) {
        super(patente, marca, modelo, anio, kilometraje, color, capacidadPasajeros, tipoDeTransmision,
                aireAcondicionado, estado);
        this.puertaLateralCorrediza = puertaLateralCorrediza;
        this.alturaInterior = alturaInterior;
        this.tipoPuertasTraseras = tipoPuertasTraseras;
        this.revestimientoInterior = revestimientoInterior;
        this.anclajesCarga = anclajesCarga;
        this.escalonAccesoTrasero = escalonAccesoTrasero;
        this.sistemaVentilacionTrasera = sistemaVentilacionTrasera;
    }

    public boolean isPuertaLateralCorrediza() {
        return puertaLateralCorrediza;
    }

    public void setPuertaLateralCorrediza(boolean puertaLateralCorrediza) {
        this.puertaLateralCorrediza = puertaLateralCorrediza;
    }

    public double getAlturaInterior() {
        return alturaInterior;
    }

    public void setAlturaInterior(double alturaInterior) {
        this.alturaInterior = alturaInterior;
    }

    public TipoDePuertasTraseras getTipoPuertasTraseras() {
        return tipoPuertasTraseras;
    }

    public void setTipoPuertasTraseras(TipoDePuertasTraseras tipoPuertasTraseras) {
        this.tipoPuertasTraseras = tipoPuertasTraseras;
    }

    public RevestimientoInterior getRevestimientoInterior() {
        return revestimientoInterior;
    }

    public void setRevestimientoInterior(RevestimientoInterior revestimientoInterior) {
        this.revestimientoInterior = revestimientoInterior;
    }

    public int getAnclajesCarga() {
        return anclajesCarga;
    }

    public void setAnclajesCarga(int anclajesCarga) {
        this.anclajesCarga = anclajesCarga;
    }

    public boolean isEscalonAccesoTrasero() {
        return escalonAccesoTrasero;
    }

    public void setEscalonAccesoTrasero(boolean escalonAccesoTrasero) {
        this.escalonAccesoTrasero = escalonAccesoTrasero;
    }

    public SistemaVentilacionTrasera getSistemaVentilacionTrasera() {
        return sistemaVentilacionTrasera;
    }

    public void setSistemaVentilacionTrasera(SistemaVentilacionTrasera sistemaVentilacionTrasera) {
        this.sistemaVentilacionTrasera = sistemaVentilacionTrasera;
    }
}



