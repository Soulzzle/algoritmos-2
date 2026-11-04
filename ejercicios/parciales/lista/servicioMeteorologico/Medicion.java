package parciales.lista.servicioMeteorologico;

public class Medicion {
    private Ciudad ciudad;
    private double temperatura;
    private EstadoMedicion estado;

    public Ciudad getCiudad() {
        return ciudad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public EstadoMedicion getEstado() {
        return estado;
    }
}
