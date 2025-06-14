package rentar.vehiculo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import rentar.exception.ExistenteException;
import rentar.exception.InexistenteException;
import rentar.vehiculo.vehiculoCombustion.AutoCombustion;
import rentar.vehiculo.vehiculoCombustion.CamionetaCombustion;
import rentar.vehiculo.vehiculoCombustion.FurgonetaCombustion;
import rentar.vehiculo.vehiculoCombustion.SuvsCombustion;
import rentar.vehiculo.vehiculoCombustion.VehiculoCombustion;
import rentar.vehiculo.vehiculoElectrico.AutoElectrico;
import rentar.vehiculo.vehiculoElectrico.CamionetaElectrica;
import rentar.vehiculo.vehiculoElectrico.FurgonetaElectrica;
import rentar.vehiculo.vehiculoElectrico.SuvsElectrico;
import rentar.vehiculo.vehiculoElectrico.VehiculoElectrico;

public class CatalogoVehiculo {
    private List<Vehiculo> listaVehiculo;

    public CatalogoVehiculo() {
        this.listaVehiculo = new LinkedList<>();
    }

    public void agregarVehiculo(Vehiculo nuevo) throws ExistenteException {
        for (Vehiculo var : listaVehiculo) {
            if (var.equals(nuevo)) {
                throw new ExistenteException();
            }
        }
        this.listaVehiculo.addFirst(nuevo);
    }

    public void eliminarVehiculo(String patente) throws InexistenteException {

        Vehiculo vehiculoEncontrado = buscarVehiculo(patente);

        listaVehiculo.remove(vehiculoEncontrado);
    }

    public Vehiculo buscarVehiculo(String patente) throws InexistenteException {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo var : listaVehiculo) {
            if (var.getPatente().equals(patente)) {
                vehiculoEncontrado = var;
                break;
            }
        }
        if (vehiculoEncontrado == null) {
            throw new InexistenteException();
        }
        return vehiculoEncontrado;
    }

    public void modificarVehiculo(Vehiculo nuevoVehiculo) throws InexistenteException {
        Vehiculo vehiculoEncontrado = buscarVehiculo(nuevoVehiculo.getPatente());
        listaVehiculo.remove(vehiculoEncontrado);
        listaVehiculo.addFirst(nuevoVehiculo);
    }

    public List<Vehiculo> listarVehiculosElectricos() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof VehiculoElectrico)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosCombustion() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof VehiculoCombustion)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosAutoElectricos() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof AutoElectrico)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosCamionetaElectricos() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof CamionetaElectrica)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosFurgonetaElectricos() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof FurgonetaElectrica)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosSuvsElectricos() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof SuvsElectrico)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosAutoCombustion() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof AutoCombustion)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosCamionetaCombustion() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof CamionetaCombustion)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosFurgonetaCombustion() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof FurgonetaCombustion)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarVehiculosSuvsCombustion() {
        return listaVehiculo.stream()
                .filter(v -> v instanceof SuvsCombustion)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

}
