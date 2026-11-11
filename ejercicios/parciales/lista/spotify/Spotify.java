package parciales.lista.spotify;

import java.util.ArrayList;
import java.util.List;

public class Spotify {

    /*
     * pre:  playlists y generosBuscados no son nulos.
     * post: devuelve una NUEVA lista con todas las playlists que cumplen
     *       simultáneamente:
     *       1. TODAS sus canciones pertenecen a alguno de los géneros buscados.
     *       2. NO son premium.
     *       3. Su duración total es menor o igual a minutosMaximos.
     */
    public List<Playlist> recomendarPlaylists(List<Playlist> playlists, List<String> generosBuscados, double minutosMaximos) {
        if (playlists == null || generosBuscados == null) {
            throw new IllegalArgumentException("Las listas no pueden ser nulas");
        }

        List<Playlist> recomendadas = new ArrayList<>();
        for (Playlist playlist : playlists) {
            if (esBuena(playlist, generosBuscados, minutosMaximos)) {
                recomendadas.add(playlist);
            }
        }

        return recomendadas;
    }

    /*
     * post: devuelve true si la playlist no es premium, todas sus canciones
     *       son de alguno de los géneros buscados y su duración total no
     *       supera minutosMaximos.
     */
    private boolean esBuena(Playlist playlist, List<String> generosBuscados, double minutosMaximos) {
        if (playlist.esPremium()) {
            return false;
        }

        double duracionTotal = 0;
        for (Cancion cancion : playlist.getCanciones()) {
            if (!generosBuscados.contains(cancion.getGenero())) {
                return false;
            }
            duracionTotal += cancion.getDuracion();
        }

        if (duracionTotal > minutosMaximos) {
            return false;
        }

        return true;
    }
}
