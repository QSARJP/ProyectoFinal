package aplicacion;

import java.awt.Color;
import java.util.ArrayList;

public class NaveJugador extends Nave{
    
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

    

 
}