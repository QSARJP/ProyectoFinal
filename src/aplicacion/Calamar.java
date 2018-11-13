package aplicacion;
import java.util.*;

public class Calamar extends Invasor{
    public Calamar(Color color, int posicionX, int posicionY){
        super(color, posicionX, posicionY);
        setResistencia();
        setPuntaje();
        setDano();
    }
    public void setResistencia(){
        this.resistencia = (int)Math.random()*3 + 1;
    }
    public void setDano(){
        this.dano = 2;
    }
    public void setPuntaje(){
        this.puntaje = 50;
    }

}