package parciales.tda.estacionBicicleta;

public class Bicicleta {
    //ATRIBUTOS
    private int numeroSerie;
    private int kmDeUso;
    private EstadoBicicleta estado;
    private int vecesRetirada;

    //CONSTRUCTORES
    public Bicicleta(int numeroSerie){
        if (numeroSerie < 0){
            throw new IllegalArgumentException("numeroSerie no puede ser menor a 0");
        }

        this.numeroSerie = numeroSerie;
        this.kmDeUso = 0;
        this.estado = EstadoBicicleta.Activa;
        this.vecesRetirada = 0;
    }

    //METODOS DE COMPORTAMIENTO
    public void reparar(){
        this.estado = EstadoBicicleta.Reparacion;
    }

    public void activar(){
        this.estado = EstadoBicicleta.Activa;
    }

    public void aumentarUso(int km){
        if (km < 0){
            throw new IllegalArgumentException("km no puede ser menor a 0");
        }

        this.kmDeUso += km;
    }

    public void aumentarRetiro(){
        this.vecesRetirada++;
    }

    //GETTERS
    public int getNumeroSerie(){
        return numeroSerie;
    }

    public int getKmDeUso(){
        return kmDeUso;
    }

    public EstadoBicicleta getEstado(){
        return estado;
    }

    public int getVecesRetirada(){
        return vecesRetirada;
    }
}
