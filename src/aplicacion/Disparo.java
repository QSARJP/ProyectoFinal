package aplicacion;

import javafx.scene.paint.Color;

public abstract class Disparo extends Elemento{
    public Disparo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        
    }

    public abstract Color getColor();
    public abstract ArrayList<Disparo> getDisparos();

}