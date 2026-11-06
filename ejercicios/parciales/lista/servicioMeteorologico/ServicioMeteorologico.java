package parciales.lista.servicioMeteorologico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServicioMeteorologico {
    /**
     * Buscar las ciudades cuya amplitud térmica sea mayor a amplitudMinima.
     * La amplitud térmica de una ciudad se calcula como la diferencia entre la mayor y la menor
     * temperatura registradas en sus mediciones en estado VALIDA.
     * Solo deben considerarse las ciudades con al menos cantidadMinimaDeMediciones mediciones
     * válidas.
     * Una misma ciudad puede aparecer en varias mediciones, pero en el resultado debe
     * aparecer una única vez.
     * La lista debe estar ordenada de mayor a menor amplitud térmica.
     * Solo deben considerarse ciudades de alguna de las provincias indicadas en provincias.
     */
    public List<Ciudad> buscarCiudadesConMayorAmplitudTermica(List<Medicion> mediciones, List<String> provincias, int cantidadMinimaDeMediciones, double amplitudMinima){
        List<MedicionesDeCiudad> medicionesDeCiudades = new ArrayList<>();
        for (Medicion medicion : mediciones){
            if (esMedicionValida(medicion)){
                agregarMedicionDeCiudad(medicion, medicionesDeCiudades);
            }
        }

        List<MedicionesDeCiudad> ciudadesSeleccionadas = new ArrayList<>();
        for (MedicionesDeCiudad medicionesDeCiudad : medicionesDeCiudades){
            if (sonMedicionesDeCiudadValidas(
                    medicionesDeCiudad,
                    provincias,
                    cantidadMinimaDeMediciones,
                    amplitudMinima)){
                ciudadesSeleccionadas.add(medicionesDeCiudad);
            }
        }

        ordenarMedicionesDeCiudad(ciudadesSeleccionadas);

        List<Ciudad> ciudades = new ArrayList<>();
        for (MedicionesDeCiudad medicionesDeCiudad : ciudadesSeleccionadas){
            ciudades.add(medicionesDeCiudad.getCiudad());
        }
        return ciudades;
    }

    private boolean esMedicionValida(Medicion medicion){
        return medicion.getEstado() == EstadoMedicion.VALIDA;
    }

    private void agregarMedicionDeCiudad(Medicion medicion, List<MedicionesDeCiudad> medicionesDeCiudades){
        MedicionesDeCiudad nuevaMedicionDeCiudad = new MedicionesDeCiudad(medicion);
        for (int i = 0; i < medicionesDeCiudades.size(); i++){
            MedicionesDeCiudad medicionesDeCiudad = medicionesDeCiudades.get(i);
            if (medicionesDeCiudad.equals(nuevaMedicionDeCiudad)){
                medicionesDeCiudad.getMediciones().add(medicion);
                return;
            }
        }

        medicionesDeCiudades.add(nuevaMedicionDeCiudad);
    }

    private boolean sonMedicionesDeCiudadValidas(
            MedicionesDeCiudad medicionesDeCiudad,
            List<String> provincias,
            int cantidadMinimaDeMediciones,
            double amplitudMinima){
        return medicionesDeCiudad.getMediciones().size() >= cantidadMinimaDeMediciones
                && provincias.contains(medicionesDeCiudad.getCiudad().getProvincia())
                && obtenerAmplitudTermica(medicionesDeCiudad) > amplitudMinima;
    }

    private double obtenerAmplitudTermica(MedicionesDeCiudad medicionesDeCiudad){
        List<Medicion> mediciones = medicionesDeCiudad.getMediciones();
        double temperaturaMinima = mediciones.get(0).getTemperatura();
        double temperaturaMaxima = temperaturaMinima;

        for (Medicion medicion : mediciones){
            temperaturaMinima = Math.min(temperaturaMinima, medicion.getTemperatura());
            temperaturaMaxima = Math.max(temperaturaMaxima, medicion.getTemperatura());
        }

        return temperaturaMaxima - temperaturaMinima;
    }

    private void ordenarMedicionesDeCiudad(List<MedicionesDeCiudad> medicionesDeCiudades){
        medicionesDeCiudades.sort(
                Comparator.comparingDouble(this::obtenerAmplitudTermica).reversed());
    }
}
