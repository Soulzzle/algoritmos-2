package parciales.lista.buscadorNoticias;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeNoticias {

    /*
     * post: busca en noticias aquellas Noticias que tengan asociada todas las
     *       categorías dadas en conCategorias y que NO contengan ninguna de las
     *       categorias de sinCategorias,
     *       teniendo un mínimo de categorias.
     *       Devuelve una nueva Lista con todas las Noticias encontradas.
     */
    public List<Noticia> buscarNoticias(List<Noticia> noticias,
                                        List<Categoria> conCategorias,
                                        List<Categoria> sinCategorias,
                                        int cantidadMinimaDeCategorias) {
        List<Noticia> noticiasBuscadas = new ArrayList<>();
        for (Noticia noticia : noticias){
            if (noticia.getCategorias().size() >= cantidadMinimaDeCategorias && tieneTodas(noticia, conCategorias) && !tieneAlguna(noticia, sinCategorias)){
                noticiasBuscadas.add(noticia);
            }
        }

        return noticiasBuscadas;
    }

    private boolean tieneTodas(Noticia noticia, List<Categoria> categorias){
        for (Categoria categoria : categorias){
            if (!noticia.getCategorias().contains(categoria)){
                return false;
            }
        }

        return true;
    }

    private boolean tieneAlguna(Noticia noticia, List<Categoria> categorias){
        for (Categoria categoria : categorias){
            if (noticia.getCategorias().contains(categoria)){
                return true;
            }
        }

        return false;
    }
}
