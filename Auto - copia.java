package rentar.vehiculo;

import rentar.propiedadEnum.EstadoVehiculo;
import rentar.propiedadEnum.SistemaAudio;
import rentar.propiedadEnum.TipoDeTransmision;

public abstract class Auto extends Vehiculo {
    private SistemaAudio sistemaAudio;
    private boolean controlCrucero;
    private int bolsasDeAire;

    public Auto(String patente, String marca, String modelo, int anio, int kilometraje, String color,
            int capacidadPasajeros, TipoDeTransmision tipoDeTransmision, boolean aireAcondicionado,
            EstadoVehiculo estado, SistemaAudio sistemaAudio, boolean controlCrucero, int bolsasDeAire) {
        super(patente, marca, modelo, anio, kilometraje, color, capacidadPasajeros, tipoDeTransmision,
                aireAcondicionado, estado);
        this.sistemaAudio = sistemaAudio;
        this.controlCrucero = controlCrucero;
        this.bolsasDeAire = bolsasDeAire;
    }

    public SistemaAudio getSistemaAudio() {
        return sistemaAudio;
    }

    public void setSistemaAudio(SistemaAudio sistemaAudio) {
        this.sistemaAudio = sistemaAudio;
    }

    public boolean isControlCrucero() {
        return controlCrucero;
    }

    public void setControlCrucero(boolean controlCrucero) {
        this.controlCrucero = controlCrucero;
    }

    public int getBolsasDeAire() {
        return bolsasDeAire;
    }

    public void setBolsasDeAire(int bolsasDeAire) {
        this.bolsasDeAire = bolsasDeAire;
    }
}

