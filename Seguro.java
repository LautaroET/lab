package rentar.costo;

import java.math.BigDecimal;

import rentar.exception.NoSePuedeCalcularException;

public class Seguro implements Costo {
    private String nombre;
    private String descripcion;
    private BigDecimal costoDiario;

    public Seguro(String nombre, String descripcion, BigDecimal costoDiario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoDiario = costoDiario;
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

    public BigDecimal getCostoDiario() {
        return costoDiario;
    }

    public void setCostoDiario(BigDecimal costoDiario) {
        this.costoDiario = costoDiario;
    }

    @Override
    public BigDecimal calcularCosto(int dia) throws NoSePuedeCalcularException {
        if (dia > 0) {
            return this.costoDiario.multiply(BigDecimal.valueOf(dia));
        } else {
            throw new NoSePuedeCalcularException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        Seguro other = (Seguro) obj;
        return this.getNombre().equals(other.getNombre());
    }

}
