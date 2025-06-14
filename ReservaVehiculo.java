package rentar.reserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import rentar.costo.Costo;
import rentar.costo.GestorCosto;
import rentar.exception.NoSePuedeCalcularException;
import rentar.exception.ReservaFinalizadaException;
import rentar.exception.ReservaNoIniciadaException;
import rentar.exception.VehiculoNoDisponibleParaReserva;
import rentar.persona.cliente.Cliente;
import rentar.propiedadEnum.EstadoVehiculo;
import rentar.vehiculo.Vehiculo;

public class ReservaVehiculo {
    private LocalDate fechaInicio;
    private LocalTime horarioInicio;
    private LocalDate fechaFin;
    private LocalTime horarioFin;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private GestorCosto gestorCosto;

    public ReservaVehiculo(LocalDate fechaInicio, LocalTime horarioInicio, LocalDate fechaFin, LocalTime horarioFin,
            Vehiculo vehiculo, Cliente cliente, GestorCosto gestorCosto) {
        this.fechaInicio = fechaInicio;
        this.horarioInicio = horarioInicio;
        this.fechaFin = fechaFin;
        this.horarioFin = horarioFin;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.gestorCosto = gestorCosto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(LocalTime horarioFin) {
        this.horarioFin = horarioFin;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public GestorCosto getGestorCosto() {
        return gestorCosto;
    }

    public void setGestorCosto(GestorCosto gestorCosto) {
        this.gestorCosto = gestorCosto;
    }

    private int calcularDiasReserva() {
            return (int) java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        }


    public BigDecimal calcularCostoTotal() throws NoSePuedeCalcularException {
        int dias = calcularDiasReserva();
        BigDecimal total = BigDecimal.ZERO;

        if (gestorCosto.getListaTotal().isEmpty()) {
            throw new NoSePuedeCalcularException();
        }

        for (Costo costo : gestorCosto.getListaTotal()) {
            total = total.add(costo.calcularCosto(dias));
        }

        if (total.compareTo(BigDecimal.ZERO) == 0) {
            throw new NoSePuedeCalcularException();
        }

        return total;
    }


        public void cambiarEstadoReservado()
        throws ReservaNoIniciadaException,ReservaFinalizadaException,VehiculoNoDisponibleParaReserva {
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            LocalDateTime inicioReserva = LocalDateTime.of(this.fechaInicio, this.horarioInicio);
            LocalDateTime finReserva = LocalDateTime.of(this.fechaFin, this.horarioFin);
            if (this.getVehiculo().isVehiculoDiponible() &&
                !fechaHoraActual.isBefore(inicioReserva) &&
                fechaHoraActual.isBefore(finReserva)) {
                this.vehiculo.setEstado(EstadoVehiculo.RENTADO);
            } else if (fechaHoraActual.isBefore(inicioReserva)) {
                throw new ReservaNoIniciadaException();
            } else if (!fechaHoraActual.isBefore(finReserva)) { 
                throw new ReservaFinalizadaException();
            } else {
                throw new VehiculoNoDisponibleParaReserva();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ReservaVehiculo)) return false;
            ReservaVehiculo aComparar = (ReservaVehiculo) o;
            return this.getFechaInicio().equals(aComparar.getFechaInicio())
                && this.getHorarioInicio().equals(aComparar.getHorarioInicio())
                && this.getVehiculo().equals(aComparar.getVehiculo())
                && this.getCliente().equals(aComparar.getCliente());
        }
}

