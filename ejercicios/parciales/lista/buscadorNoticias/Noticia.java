package parciales.lista.buscadorNoticias;

import java.util.List;
import java.util.ArrayList;

public class Noticia {
    private String titulo;
    private String cuerpo;
    private List<Categoria> categorias;

    /*
     * post: inicializa la noticia con el título y cuerpo
     *       indicados, sin categorias asociadas.
     */
    public Noticia(String titulo, String cuerpo) {
        if (titulo == null || cuerpo == null || titulo.isEmpty() || titulo.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.categorias = new ArrayList<>();
    }

    /*
     * post: devuelve el título de la noticia.
     */
    public String getTitulo() {
        return titulo;
    }

    /*
     * post: devuelve el cuerpo de la noticia.
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /*
     * post: devuelve las categorias asociadas a la noticia.
     */
    public List<Categoria> getCategorias() {
        return categorias;
    }
}
