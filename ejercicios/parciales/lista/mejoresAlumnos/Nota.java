package parciales.lista.mejoresAlumnos;

public class Nota {
    private int padron;
    private String materia;
    private double valor;

    /*
     * post: inicializa la nota del alumno con el padron indicado
     *       en la materia dada. El valor debe estar entre 0 y 10.
     */
    public Nota(int padron, String materia, double valor) {
        if (materia == null || materia.isEmpty()) {
            throw new IllegalArgumentException("La materia no puede ser nula o vacía");
        }
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
        this.padron = padron;
        this.materia = materia;
        this.valor = valor;
    }

    // Devuelve el padron
    public int getPadron() {
        return padron;
    }

    // Devuelve el nombre de la materia
    public String getMateria() {
        return materia;
    }

    // Devuelve la nota entre 0 y 10
    public double getValor() {
        return valor;
    }
}
