package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.io.Serializable;
public class NaveJugador extends Nave implements Serializable{
    
    private Color color;
    

    public NaveJugador(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.green;
        space.addNave(this);
        this.disparosNormales = 60;
        prepareDisparos();
    }

    public Color getColor(){
        return color;
    }

    public void changeColor(Color newColor){
        this.color=newColor;
    }
    

 
}