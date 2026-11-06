package parciales.tda.estacionBicicleta;

public class EstacionDeBicicletas {
    //ATRIBUTOS
    private Anclaje[] anclajes;

    //CONSTRUCTORES
    public EstacionDeBicicletas(int cantidadDeAnclajes){
        if (cantidadDeAnclajes <= 0){
            throw new IllegalArgumentException("cantidadDeAnclajes tiene que ser mayor a 0");
        }

        this.anclajes = new Anclaje[cantidadDeAnclajes];
        for (int i = 0; i < cantidadDeAnclajes; i++){
            Bicicleta bicicleta = new Bicicleta(i);
            anclajes[i] = new Anclaje(bicicleta);
        }
    }

    //METODOS DE COMPORTAMIENTO
    public Bicicleta retirarBicicleta(Anclaje anclaje){
        if (anclaje == null){
            throw new IllegalArgumentException("anclaje no puede ser null");
        }

        Bicicleta bicicleta = null;
        for (int i = 0; i < anclajes.length; i++){
            if (anclajes[i].equals(anclaje)){
                bicicleta = anclajes[i].liberar();
                bicicleta.aumentarRetiro();
            }
        }
        if (bicicleta == null){
            throw new IllegalArgumentException("anclaje no forma parte de de la estacion");
        }
        return bicicleta;
    }

    public void devolverBicicleta(Bicicleta bicicleta){
        if (bicicleta == null){
            throw new IllegalArgumentException("bicicleta no puede ser null");
        }
        if (getAnclajesLibres() == 0){
            throw new IllegalStateException("La estacion está llena");
        }

        for (int i = 0; i < anclajes.length; i++){
            if (anclajes[i].getEstado() == EstadoAnclaje.Libre){
                anclajes[i].ocupar(bicicleta);
                return;
            }
        }
    }

    //GETTERS
    public Anclaje[] getAnclajes(){
        return anclajes;
    }

    public int getAnclajesLibres(){
        int resultado = 0;
        for (int i = 0; i < anclajes.length; i++){
            if (anclajes[i].getEstado() == EstadoAnclaje.Libre){
                resultado++;
            }
        }
        return resultado;
    }

    public Bicicleta getBicicletaMasUsada(){
        Bicicleta bicicleta = null;
        int kmDeUso = -1;
        for (int i = 0; i < anclajes.length; i++){
            if (anclajes[i].getBicicletaActual().getKmDeUso() > kmDeUso){
                bicicleta = anclajes[i].getBicicletaActual();
                kmDeUso = anclajes[i].getBicicletaActual().getKmDeUso();
            }
        }

        return bicicleta;
    }

    public Bicicleta getBicicletaMasRetirada(){
        Bicicleta bicicleta = null;
        int vecesRetirada = -1;
        for (int i = 0; i < anclajes.length; i++){
            if (anclajes[i].getBicicletaActual().getVecesRetirada() > vecesRetirada){
                bicicleta = anclajes[i].getBicicletaActual();
                vecesRetirada = anclajes[i].getBicicletaActual().getVecesRetirada();
            }
        }

        return bicicleta;
    }

    public double getPorcentajeDeOcupacion(){
        return 100 - ((getAnclajesLibres() * 100) / anclajes.length);
    }
}
