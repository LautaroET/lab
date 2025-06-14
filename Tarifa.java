package rentar.costo;

import java.math.BigDecimal;

import rentar.exception.NoSePuedeCalcularException;

public class Tarifa implements Costo {
    private String tipoVehiculo;
    private BigDecimal temporada;
    private int duracionMinimaDias;
    private BigDecimal precioBaseDiario;

    public Tarifa(String tipoVehiculo, BigDecimal temporada, int duracionMinimaDias, BigDecimal precioBaseDiario) {
        this.tipoVehiculo = tipoVehiculo;
        this.temporada = temporada;
        this.duracionMinimaDias = duracionMinimaDias;
        this.precioBaseDiario = precioBaseDiario;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public BigDecimal getTemporada() {
        return temporada;
    }

    public void setTemporada(BigDecimal temporada) {
        this.temporada = temporada;
    }

    public int getDuracionMinimaDias() {
        return duracionMinimaDias;
    }

    public void setDuracionMinimaDias(int duracionMinimaDias) {
        this.duracionMinimaDias = duracionMinimaDias;
    }

    public BigDecimal getPrecioBaseDiario() {
        return precioBaseDiario;
    }

    public void setPrecioBaseDiario(BigDecimal precioBaseDiario) {
        this.precioBaseDiario = precioBaseDiario;
    }

    @Override
    public BigDecimal calcularCosto(int dia) throws NoSePuedeCalcularException {
        if (dia >= this.duracionMinimaDias) {
            BigDecimal costoBase = this.precioBaseDiario.multiply(BigDecimal.valueOf(dia));
            return costoBase.multiply(this.temporada); // temporada como factor multiplicador
        } else {
            throw new NoSePuedeCalcularException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        Tarifa other = (Tarifa) obj;
        return this.tipoVehiculo.equals(other.getTipoVehiculo());
    }

    

}
