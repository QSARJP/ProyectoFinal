package aplicacion;

import java.awt.*;
import java.io.Serializable;


public abstract class Disparo extends Elemento implements Serializable{

    protected Elemento elemento;

    public Disparo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        
    }

    public void setElemento(Elemento elemento){
        this.nave = nave;
    }

    public abstract Color getColor();

    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }

    public abstract int mover(int posicionX, int posicionY);
}