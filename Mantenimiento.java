package rentar.mantenimiento;

import java.time.LocalDate;
import rentar.vehiculo.Vehiculo;

public class Mantenimiento {
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String detalle;
    
    
    public Mantenimiento(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFinal, String detalle) {
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.detalle = detalle;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public boolean equals(Object obj) {
        Mantenimiento aComparar = (Mantenimiento) obj;
        return this.getFechaInicio().equals(aComparar.getFechaInicio()) &&
            this.getFechaFinal().equals(aComparar.getFechaFinal()) &&
            this.getVehiculo().equals(aComparar.getVehiculo());
    }
    
}

