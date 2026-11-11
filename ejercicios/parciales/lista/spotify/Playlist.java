package parciales.lista.spotify;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String titulo;
    private boolean premium;
    private List<Cancion> canciones;

    /*
     * post: inicializa la playlist con el título indicado, premium o no,
     *       y sin canciones.
     */
    public Playlist(String titulo, boolean premium) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo o vacío");
        }
        this.titulo = titulo;
        this.premium = premium;
        this.canciones = new ArrayList<>();
    }

    /*
     * post: devuelve el título de la playlist
     */
    public String getTitulo() {
        return titulo;
    }

    /*
     * post: devuelve si es premium
     */
    public boolean esPremium() {
        return premium;
    }

    /*
     * post: devuelve las canciones de la playlist
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }
}
