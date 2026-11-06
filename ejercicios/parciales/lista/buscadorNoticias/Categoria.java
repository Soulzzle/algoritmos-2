package parciales.lista.buscadorNoticias;

import java.util.Objects;

public class Categoria {
    private String nombre;
    private String descripcion;

    /*
     * post: inicializa la categoria con el nombre y la
     *       descripción indicadas.
     */
    public Categoria(String nombre, String descripcion) {
        if (nombre == null || descripcion == null || nombre.isEmpty() || descripcion.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override 
    public boolean equals(Object o){
        if (o == null || o.getClass() != getClass()){
            return false;
        }

        Categoria that = (Categoria) o;
        return Objects.equals(this.nombre, that.nombre); 
    }

    @Override 
    public int hashCode(){
        return Objects.hashCode(nombre);
    }

    /*
     * post: devuelve el nombre que la identifica.
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * post: devuelve la descripción de la categoria.
     */
    public String getDescripcion() {
        return descripcion;
    }
}
