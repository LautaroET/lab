package rentar.costo;

import java.math.BigDecimal;

import rentar.exception.NoSePuedeCalcularException;

public class ServicioExtra implements Costo {
    private String nombre;
    private String descripcion;
    private BigDecimal costo;

    public ServicioExtra(String nombre, String descripcion, BigDecimal costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    @Override
    public BigDecimal calcularCosto(int dia) throws NoSePuedeCalcularException {
        if (dia > 0) {
            return this.costo.multiply(BigDecimal.valueOf(dia));
        } else {
            throw new NoSePuedeCalcularException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        ServicioExtra other = (ServicioExtra) obj;
        return this.getNombre().equals(other.getNombre());
    }

}
