package rentar.mantenimiento;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import rentar.exception.ExistenteException;
import rentar.exception.InexistenteException;
import rentar.exception.vehiculoEnMantenimiento;
import rentar.vehiculo.Vehiculo;

public class RegistroDeMantenimiento {
    private List<Mantenimiento>listaMantenimiento;
    public RegistroDeMantenimiento (){
        this.listaMantenimiento= new LinkedList<>();
    }
    
    public void agregarMantenimiento(Mantenimiento mantenimiento) throws ExistenteException {
        if (listaMantenimiento.contains(mantenimiento)) { 
            throw new ExistenteException();
        }
        this.listaMantenimiento.add(mantenimiento);
    }

    public void eliminarMantenimiento(Mantenimiento mantenimiento) throws InexistenteException {
        if (!listaMantenimiento.remove(mantenimiento)) {
            throw new InexistenteException();
        }
    }

    public Boolean buscarMantenimiento(Mantenimiento mantenimiento) throws InexistenteException {
        for (Mantenimiento buscar : listaMantenimiento) {
            if (buscar.equals(mantenimiento)) {
                return true;
            }
        }
        throw new InexistenteException();
    }

    public void modificarMantenimiento(Mantenimiento nuevaMantenimiento) throws InexistenteException ,ExistenteException{
        eliminarMantenimiento(nuevaMantenimiento);
        agregarMantenimiento(nuevaMantenimiento);
    }

    public List<Mantenimiento> getListaMantenimiento() {
        return listaMantenimiento;
    }

    public Boolean vehiculoNoEstaEnMantenimiento(Vehiculo vehiculo, LocalDate fechaABuscar)
            throws vehiculoEnMantenimiento {
        for (Mantenimiento mantenimiento : listaMantenimiento) {
            if (mantenimiento.getVehiculo().equals(vehiculo)) {
                boolean estaDentroDelRango = (fechaABuscar.isEqual(mantenimiento.getFechaInicio())
                        || fechaABuscar.isAfter(mantenimiento.getFechaInicio())) &&
                        (fechaABuscar.isEqual(mantenimiento.getFechaFinal())
                                || fechaABuscar.isBefore(mantenimiento.getFechaFinal()));

                if (estaDentroDelRango) {
                    throw new vehiculoEnMantenimiento();
                }
            }
        }
        return true;
    }

    public List<Mantenimiento> buscarMantenimientosPorVehiculo(Vehiculo vehiculo){
        return listaMantenimiento.stream()
        .filter(m -> m.getVehiculo().equals(vehiculo))
        .collect(Collectors.toList());
    }

    public List<Vehiculo> vehiculosEnMantenimiento(LocalDate fecha) {
    return listaMantenimiento.stream()
        .filter(m -> (fecha.isEqual(m.getFechaInicio()) || fecha.isAfter(m.getFechaInicio())) &&
                    (fecha.isEqual(m.getFechaFinal()) || fecha.isBefore(m.getFechaFinal())))
        .map(Mantenimiento::getVehiculo)
        .distinct()
        .collect(Collectors.toList());
}


}
