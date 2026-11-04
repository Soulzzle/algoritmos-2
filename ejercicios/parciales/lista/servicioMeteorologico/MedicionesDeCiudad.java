package parciales.lista.servicioMeteorologico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MedicionesDeCiudad {
    private Ciudad ciudad;
    private List<Medicion> mediciones;

    public MedicionesDeCiudad(Medicion medicion){
        if (medicion == null){
            throw new IllegalArgumentException("medicion no puede ser null");
        }

        this.ciudad = medicion.getCiudad();
        this.mediciones = new ArrayList<>();
        this.mediciones.add(medicion);
    }

    @Override 
    public boolean equals(Object o){
        if (o == null || o.getClass() != getClass()){
            return false;
        }

        MedicionesDeCiudad that = (MedicionesDeCiudad) o;
        return Objects.equals(this.ciudad, that.ciudad);
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(ciudad);
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public List<Medicion> getMediciones() {
        return mediciones;
    }
}
