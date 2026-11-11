package parciales.lista.spotify;

public class Cancion {
    private String nombre;
    private String genero;
    private double duracion;

    /*
     * post: inicializa la canción con el nombre, el género y la
     *       duración (en minutos) indicados.
     */
    public Cancion(String nombre, String genero, double duracion) {
        if (nombre == null || nombre.isEmpty() || genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("El nombre y el género no pueden ser nulos o vacíos");
        }
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser positiva");
        }
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
    }

    /*
     * post: devuelve el nombre de la canción
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * post: devuelve el género de la canción
     */
    public String getGenero() {
        return genero;
    }

    /*
     * post: devuelve la duración de la canción
     */
    public double getDuracion() {
        return duracion;
    }
}
