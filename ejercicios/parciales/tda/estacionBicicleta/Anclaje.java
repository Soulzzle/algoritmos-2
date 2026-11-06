package parciales.tda.estacionBicicleta;

public class Anclaje {
    //ATRIBUTOS
    private EstadoAnclaje estado;
    private Bicicleta bicicletaActual;

    //CONSTRUCTORES
    public Anclaje(){
        this.estado = EstadoAnclaje.Libre;
        this.bicicletaActual = null;
    }

    public Anclaje(Bicicleta bicicletaActual){
        if (bicicletaActual == null){
            throw new IllegalArgumentException("bicicletaActual no puede ser null");
        }

        this.bicicletaActual = bicicletaActual;
        this.estado = EstadoAnclaje.Ocupado;
    }

    //METODOS DE COMPORTAMIENTO
    public Bicicleta liberar(){
        if (this.estado == EstadoAnclaje.Libre){
            throw new IllegalStateException("No hay bicicleta en el anclaje");
        }
        if (this.bicicletaActual.getEstado() == EstadoBicicleta.Reparacion){
            throw new IllegalStateException("La bicicleta está en reparación");
        }

        this.estado = EstadoAnclaje.Libre;
        return this.bicicletaActual;
    }

    public void ocupar(Bicicleta bicicleta){
        if (this.estado == EstadoAnclaje.Ocupado){
            throw new IllegalStateException("Ya hay bicicleta en el anclaje");
        }

        this.estado = EstadoAnclaje.Ocupado;
        this.bicicletaActual = bicicleta;
    }

    //GETTERS
    public EstadoAnclaje getEstado(){
        return estado;
    }

    public Bicicleta getBicicletaActual(){
        return bicicletaActual;
    }
}
