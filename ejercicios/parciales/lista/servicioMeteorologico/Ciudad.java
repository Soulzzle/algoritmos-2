package parciales.lista.servicioMeteorologico;

import java.util.Objects;

public class Ciudad {
    //ATRIBUTOS
    private String nombre;
    private String provincia;

    @Override 
    public boolean equals(Object o){
        if (o == null || o.getClass() != getClass()){
            return false;
        }

        Ciudad that = (Ciudad) o;
        return (Objects.equals(this.nombre, that.nombre) && Objects.equals(this.provincia, that.provincia));
    }

    @Override 
    public int hashCode(){
        return Objects.hash(nombre, provincia);
    }

    //GETTERS
    public String getNombre(){
        return nombre;
    }

    public String getProvincia(){
        return provincia;
    }
}
