package rentar.vehiculo;

public class Caja {
    private boolean cobertor;
    private double longitud;

    public Caja(boolean cobertor, double longitud) {
        this.cobertor = cobertor;
        this.longitud = longitud;
    }

    public boolean isCobertor() {
        return cobertor;
    }

    public void setCobertor(boolean cobertor) {
        this.cobertor = cobertor;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object obj) {
        Caja caja = (Caja) obj;
        return cobertor == caja.cobertor && Double.compare(caja.longitud, longitud) == 0;
    }
}


