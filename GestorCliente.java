package rentar.persona.cliente;

import java.util.LinkedList;
import java.util.List;
import rentar.exception.ExistenteException;
import rentar.exception.InexistenteException;

public class GestorCliente {
    private final List<Cliente> listaCliente;

    public GestorCliente() {
        this.listaCliente = new LinkedList<>();
    }

    public void agregarCliente(Cliente nuevo) throws ExistenteException {
        if (listaCliente.contains(nuevo)) {
            throw new ExistenteException();
        }
        listaCliente.addFirst(nuevo);
    }

    public void eliminarCliente(Integer documento) throws InexistenteException {
        Cliente cliente = buscarCliente(documento);
        listaCliente.remove(cliente);
    }

    public Cliente buscarCliente(Integer documento) throws InexistenteException {
        return listaCliente.stream()
            .filter(c -> c.getDocumento().equals(documento))
            .findFirst()
            .orElseThrow(InexistenteException::new);
    }

    public void modificarCliente(Cliente nuevoCliente) throws InexistenteException {
        Cliente existente = buscarCliente(nuevoCliente.getDocumento());
        listaCliente.remove(existente);
        listaCliente.addFirst(nuevoCliente);
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }
}

