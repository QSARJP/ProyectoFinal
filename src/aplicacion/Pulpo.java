package aplicacion;
import java.awt.*;

public class Pulpo extends Invasor{
    public Pulpo(Color color, int posicionX, int posicionY){
        super(color, posicionX, posicionY);
        setDano(1);
        setPuntaje(10);
        setResistencia();
    }
    public void setResistencia(){
        this.resistencia = 1;
    }
}