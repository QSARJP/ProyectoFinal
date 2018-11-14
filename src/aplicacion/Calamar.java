package aplicacion;
import java.util.*;
import java.awt.*;

public class Calamar extends Invasor{
    public Calamar(Color color, int posicionX, int posicionY){
        super(color, posicionX, posicionY);
        setResistencia();
        setPuntaje(50);
        setDano(2);
    }
    public void setResistencia(){
        this.resistencia = (int)Math.random()*3 + 1;
    }
}