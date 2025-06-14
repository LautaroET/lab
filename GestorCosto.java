package rentar.costo;

import java.util.LinkedList;
import java.util.List;

import rentar.exception.ExistenteException;
import rentar.exception.InexistenteException;

public class GestorCosto {
    private List<Costo> listaCosto;

    public GestorCosto() {
        this.listaCosto = new LinkedList<>();
    }

    public boolean agregarNuevoCosto(Costo nuevoCosto) throws ExistenteException {
        if (nuevoCosto instanceof Tarifa) {
            Tarifa nuevaTarifa = (Tarifa) nuevoCosto;
            for (Costo costoExistente : listaCosto) {
                if (costoExistente instanceof Tarifa && ((Tarifa) costoExistente).getTipoVehiculo().equals(nuevaTarifa.getTipoVehiculo())) {
                    throw new ExistenteException(); 
                }
            }
        } else if (nuevoCosto instanceof Seguro) {
            Seguro nuevoSeguro = (Seguro) nuevoCosto;
            for (Costo costoExistente : listaCosto) {
                if (costoExistente instanceof Seguro && ((Seguro) costoExistente).getNombre().equals(nuevoSeguro.getNombre())) {
                    throw new ExistenteException(); 
                }
            }
        } else if (nuevoCosto instanceof ServicioExtra) {
            ServicioExtra nuevoServicioExtra = (ServicioExtra) nuevoCosto;
            for (Costo costoExistente : listaCosto) {
                if (costoExistente instanceof ServicioExtra && ((ServicioExtra) costoExistente).getNombre().equals(nuevoServicioExtra.getNombre())) {
                    throw new ExistenteException(); 
                }
            }
        } else if (nuevoCosto instanceof CostoVehiculo) { 
            CostoVehiculo nuevoCostoVehiculo = (CostoVehiculo) nuevoCosto;
            for (Costo costoExistente : listaCosto) {
                if (costoExistente instanceof CostoVehiculo && ((CostoVehiculo) costoExistente).getTipoVehiculo().equals(nuevoCostoVehiculo.getTipoVehiculo())) {
                    throw new ExistenteException(); 
                }
            }
        }
        return this.listaCosto.add(nuevoCosto);
    }

    public void eliminarCosto(Costo costoAEliminar) throws InexistenteException {
        if (!listaCosto.remove(costoAEliminar)) {
            throw new InexistenteException();
        }
    }

    public boolean modificarCosto(Costo costoModificado) throws InexistenteException {
        for (int i = 0; i < listaCosto.size(); i++) {
            Costo costoExistente = listaCosto.get(i);
            if (costoExistente.equals(costoModificado)) {
                listaCosto.set(i, costoModificado);
                return true;
            }
        }
        throw new InexistenteException();
    }

    public Costo buscarCosto(Costo costoABuscar) throws InexistenteException {
        for (Costo costo : listaCosto) {
            if (costo.equals(costoABuscar)) {
                return costo;
            }
        }
        throw new InexistenteException();
    }

    public List<Seguro> getListaCostoSeguro() {
        List<Seguro> seguros = new LinkedList<>();
        for (Costo costo : listaCosto) {
            if (costo instanceof Seguro) {
                seguros.add((Seguro) costo);
            }
        }
        return seguros;
    }

    public List<ServicioExtra> getListaCostoServicioExtra() {
        List<ServicioExtra> serviciosExtras = new LinkedList<>();
        for (Costo costo : listaCosto) {
            if (costo instanceof ServicioExtra) {
                serviciosExtras.add((ServicioExtra) costo);
            }
        }
        return serviciosExtras;
    }

    public List<Tarifa> getListaCostoTarifa() {
        List<Tarifa> tarifas = new LinkedList<>();
        for (Costo costo : listaCosto) {
            if (costo instanceof Tarifa) {
                tarifas.add((Tarifa) costo);
            }
        }
        return tarifas;
    }

    public List<CostoVehiculo> getListaCostoVehiculo() {
        List<CostoVehiculo> costosVehiculo = new LinkedList<>();
        for (Costo costo : listaCosto) {
            if (costo instanceof CostoVehiculo) {
                costosVehiculo.add((CostoVehiculo) costo);
            }
        }
        return costosVehiculo;
    }

    public List<Costo> getListaTotal() {
        return new LinkedList<>(this.listaCosto);
    }
}


