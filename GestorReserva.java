package rentar.reserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import rentar.exception.ExistenteException;
import rentar.exception.InexistenteException;
import rentar.exception.VehiculoNoDisponibleParaReserva;
import rentar.exception.vehiculoNoEstaEnReserva;
import rentar.vehiculo.Vehiculo;

public class GestorReserva {
    private List<ReservaVehiculo> listaReserva;

    public GestorReserva() {
        this.listaReserva = new LinkedList<>();
    }

    public void agregarReserva(ReservaVehiculo reserva)
            throws ExistenteException, VehiculoNoDisponibleParaReserva {
        if (listaReserva.contains(reserva)) {
            throw new ExistenteException();
        }
        if (!isVehiculoDisponibleParaReserva(reserva.getVehiculo(), reserva.getFechaInicio(), reserva.getFechaFin(),
                null)) {
            throw new VehiculoNoDisponibleParaReserva();
        }
        this.listaReserva.addFirst(reserva);
    }

    public void eliminarReserva(LocalDate fecha, LocalTime horario) throws InexistenteException {
        ReservaVehiculo reserva = buscarReservaVehiculo(fecha, horario);
        listaReserva.remove(reserva);
    }

    public ReservaVehiculo buscarReservaVehiculo(LocalDate fecha, LocalTime horario) throws InexistenteException {
        for (ReservaVehiculo reserva : listaReserva) {
            if (reserva.getFechaInicio().equals(fecha) && reserva.getHorarioInicio().equals(horario)) {
                return reserva;
            }
        }
        throw new InexistenteException();
    }

    public void modificarReserva(ReservaVehiculo nuevaReserva)
            throws InexistenteException, VehiculoNoDisponibleParaReserva {
        if (!isVehiculoDisponibleParaReserva(nuevaReserva.getVehiculo(), nuevaReserva.getFechaInicio(),
                nuevaReserva.getFechaFin(), nuevaReserva)) {
            throw new VehiculoNoDisponibleParaReserva();
        }

        ReservaVehiculo reservaExistente = buscarReservaVehiculo(
                nuevaReserva.getFechaInicio(),
                nuevaReserva.getHorarioInicio());
        listaReserva.remove(reservaExistente);
        listaReserva.addFirst(nuevaReserva);
    }

    public boolean isVehiculoDisponibleParaReserva(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin,
            ReservaVehiculo reservaAExcluir) {
        for (ReservaVehiculo reservaExistente : listaReserva) {
            if (reservaAExcluir != null && reservaExistente.equals(reservaAExcluir)) {
                continue;
            }
            boolean seSuperponen = !fechaInicio.isAfter(reservaExistente.getFechaFin()) &&
                    !fechaFin.isBefore(reservaExistente.getFechaInicio());

            if (reservaExistente.getVehiculo().equals(vehiculo) && seSuperponen) {
                return false;
            }
        }
        return true;
    }

    public boolean vehiculoEnReserva(Vehiculo vehiculo, LocalDate fechaABuscar) throws vehiculoNoEstaEnReserva {
    for (ReservaVehiculo reserva : listaReserva) {
        if (reserva.getVehiculo().equals(vehiculo)) {
            boolean estaDentroDelRango = (fechaABuscar.isEqual(reserva.getFechaInicio())
                    || fechaABuscar.isAfter(reserva.getFechaInicio())) &&
                    (fechaABuscar.isEqual(reserva.getFechaFin())
                            || fechaABuscar.isBefore(reserva.getFechaFin()));
            if (estaDentroDelRango) {
                return true;
            }
        }
    }
    throw new vehiculoNoEstaEnReserva();
}


    public List<ReservaVehiculo> consultarReservasVehiculoEnIntervalo(Vehiculo vehiculo, LocalDate fechaInicio,
            LocalDate fechaFin) {
        return listaReserva.stream()
                .filter(reserva -> reserva.getVehiculo().equals(vehiculo))
                .filter(reserva -> !fechaInicio.isAfter(reserva.getFechaFin())
                        && !fechaFin.isBefore(reserva.getFechaInicio()))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> consultarVehiculosDisponiblesEnIntervalo(List<Vehiculo> todosLosVehiculos,
            LocalDate fechaInicio, LocalDate fechaFin) {
        return todosLosVehiculos.stream()
                .filter(vehiculo -> isVehiculoDisponibleParaReserva(vehiculo, fechaInicio, fechaFin, null))
                .collect(Collectors.toList());
    }

    public List<ReservaVehiculo> consultarReservasPorCliente(rentar.persona.cliente.Cliente cliente) {
        return listaReserva.stream()
                .filter(reserva -> reserva.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public List<ReservaVehiculo> getListaReserva() {
        return listaReserva;
    }

}








