package aplicacion;

public class Cangrejo extends Invasor{
    public Cangrejo(Color color, int posicionX, int posicionY){
        super(color, posicionX, posicionY);
        setDano();
        setPuntaje();
        setResistencia();
    }
    public void setDano(){
        this.dano = 1;
    }
    public void setPuntaje(){
        this.puntaje = 30;
    }
    public void setResistencia(){
        this.resistencia = 2;
    }
}