package rentar.vehiculo;

import rentar.propiedadEnum.EstadoVehiculo;
import rentar.propiedadEnum.ModoConduccion;
import rentar.propiedadEnum.TipoDeTransmision;

public abstract class Suvs extends Vehiculo {
    private boolean traccionIntegral;
    private int numeroFilasAsientos;
    private boolean sistemaNavegacion;
    private ModoConduccion modosDeConduccion;
    private boolean asistenciaEstacionamiento;

    

    public Suvs(String patente, String marca, String modelo, int anio, int kilometraje, String color,
            int capacidadPasajeros, TipoDeTransmision tipoDeTransmision, boolean aireAcondicionado,
            EstadoVehiculo estado, boolean traccionIntegral, int numeroFilasAsientos, boolean sistemaNavegacion,
            ModoConduccion modosDeConduccion, boolean asistenciaEstacionamiento) {
        super(patente, marca, modelo, anio, kilometraje, color, capacidadPasajeros, tipoDeTransmision,
                aireAcondicionado, estado);
        this.traccionIntegral = traccionIntegral;
        this.numeroFilasAsientos = numeroFilasAsientos;
        this.sistemaNavegacion = sistemaNavegacion;
        this.modosDeConduccion = modosDeConduccion;
        this.asistenciaEstacionamiento = asistenciaEstacionamiento;
    }

    public boolean isTraccionIntegral() {
        return traccionIntegral;
    }

    public void setTraccionIntegral(boolean traccionIntegral) {
        this.traccionIntegral = traccionIntegral;
    }

    public int getNumeroFilasAsientos() {
        return numeroFilasAsientos;
    }

    public void setNumeroFilasAsientos(int numeroFilasAsientos) {
        this.numeroFilasAsientos = numeroFilasAsientos;
    }

    public boolean isSistemaNavegacion() {
        return sistemaNavegacion;
    }

    public void setSistemaNavegacion(boolean sistemaNavegacion) {
        this.sistemaNavegacion = sistemaNavegacion;
    }

    public ModoConduccion getModosDeConduccion() {
        return modosDeConduccion;
    }

    public void setModosDeConduccion(ModoConduccion modosDeConduccion) {
        this.modosDeConduccion = modosDeConduccion;
    }

    public boolean isAsistenciaEstacionamiento() {
        return asistenciaEstacionamiento;
    }

    public void setAsistenciaEstacionamiento(boolean asistenciaEstacionamiento) {
        this.asistenciaEstacionamiento = asistenciaEstacionamiento;
    }
}






