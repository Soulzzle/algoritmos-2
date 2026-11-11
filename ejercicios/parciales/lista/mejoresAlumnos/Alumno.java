package parciales.lista.mejoresAlumnos;

public class Alumno {
    private String nombre;
    private int padron;

    /*
     * post: inicializa el alumno con el nombre y el padron indicados.
     */
    public Alumno(String nombre, int padron) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
        this.padron = padron;
    }

    // Devuelve el nombre del alumno
    public String getNombre() {
        return this.nombre;
    }

    // Devuelve el padron del alumno
    public int getPadron() {
        return this.padron;
    }
}
