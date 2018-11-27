package aplicacion;

import java.awt.color.*;
import java.awt.*;

public class DisparoNormal extends Disparo{

    private Color color;

    public DisparoNormal(Space space, int posicionX, int posicionY){
        super(space,posicionX,posicionY);
        this.color = Color.WHITE;
        
    }

    public Color getColor(){
        return color;
    }

    

}