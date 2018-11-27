package aplicacion;

import java.awt.Color;

public class NaveJugador extends Nave{
    
    private Color color;

    public NaveJugador(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.green;
        
    }

    public Color getColor(){
        return color;
    }

 
}