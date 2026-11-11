package parciales.lista.mejoresAlumnos;

import java.util.ArrayList;
import java.util.List;

public class Profesor {

    /*
     * Busca los mejores alumnos de cada materia segun su promedio de notas.
     *
     * pre:  alumnos y promedios no son nulos. Cada Nota de promedios es el
     *       promedio de un alumno (identificado por su padron) en una materia.
     * post: devuelve una nueva lista con el alumno de mayor promedio de cada
     *       materia. Si en una materia hay empate, se incluyen todos los
     *       empatados. Un alumno que es el mejor en varias materias aparece
     *       una sola vez.
     */
    public List<Alumno> buscarMejoresAlumnos(List<Alumno> alumnos, List<Nota> promedios) {
        if (alumnos == null || promedios == null) {
            throw new IllegalArgumentException("Las listas no pueden ser nulas");
        }

        List<Alumno> mejoresAlumnos = new ArrayList<>();
        for (Nota promedio : promedios) {
            if (esElMejorDeSuMateria(promedio, promedios)) {
                Alumno alumno = buscarAlumno(alumnos, promedio.getPadron());
                if (alumno != null && !mejoresAlumnos.contains(alumno)) {
                    mejoresAlumnos.add(alumno);
                }
            }
        }

        return mejoresAlumnos;
    }

    /*
     * post: devuelve true si ningun otro promedio de la misma materia
     *       supera al promedio dado.
     */
    private boolean esElMejorDeSuMateria(Nota promedio, List<Nota> promedios) {
        for (Nota otro : promedios) {
            if (otro.getMateria().equals(promedio.getMateria()) && otro.getValor() > promedio.getValor()) {
                return false;
            }
        }

        return true;
    }

    /*
     * post: devuelve el alumno con el padron indicado, o null si no esta
     *       en la lista.
     */
    private Alumno buscarAlumno(List<Alumno> alumnos, int padron) {
        for (Alumno alumno : alumnos) {
            if (alumno.getPadron() == padron) {
                return alumno;
            }
        }

        return null;
    }
}
