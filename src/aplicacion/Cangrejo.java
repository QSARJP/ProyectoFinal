package aplicacion;
import java.awt.*;

public class Cangrejo extends Invasor{
    public Cangrejo(Color color, int posicionX, int posicionY){
        super(color, posicionX, posicionY);
        setDano(1);
        setPuntaje(30);
        setResistencia();
    }
    public void setResistencia(){
        this.resistencia = 2;
    }
    public void setForma(){}
    public  int getBinario(int f, int c){
        return forma[f][c];   
    }
}