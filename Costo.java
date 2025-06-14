package rentar.costo;

import java.math.BigDecimal;

import rentar.exception.NoSePuedeCalcularException;

public interface Costo {
    public BigDecimal calcularCosto(int dia) throws NoSePuedeCalcularException;
}

