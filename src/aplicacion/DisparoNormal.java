package aplicacion;

import javafx.scene.paint.Color;


public class DisparoNormal extends Disparo{

    private Color color = Color.WHITE;

    public DisparoNormal(Space space, int posicionX, int posicionY){
        super(space,posicionX,posicionY);
        
    }

    public Color getColor(){
        return color;
    }

    

}