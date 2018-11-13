package aplicacion;

public class Pulpo extends Invasor{
    public Pulpo(Color color, int posicionX, int posicionY){
        super(color, posicionX, posicionY);
        setDano();
        setPuntaje();
        setResistencia();
    }

    public void setDano(){
        this.dano = 1;
    }
    public void setPuntaje(){
        this.puntaje = 10;
    }
    public void setResistencia(){
        this.resistencia = 1;
    }
    public int getDano(){
        return dano;
    }
}