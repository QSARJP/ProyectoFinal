package aplicacion;

import java.awt.*;


public abstract class Disparo extends Elemento{
    public Disparo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        
    }

    public abstract Color getColor();

    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }

}