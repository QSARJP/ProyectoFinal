package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Elemento implements Serializable {
    protected int posicionX;
	protected int posicionY;
    protected Space space;


    public Elemento(Space space, int posicionX, int posicionY){

        this.space = space;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public abstract int mover(int posicionX, int posicionY);
    public abstract ArrayList<Disparo> getDisparos();
    public abstract int disparo();
    public abstract void setPuntajeHUD(int puntaje);
        
    
    public String getPosicion(){
        String posicion = Integer.toString(posicionX) +","+Integer.toString(posicionY);
        return posicion;
    }

    public int[] getPosicionInt(){
        int[] posicion = {posicionX,posicionY};
        return posicion;
    }

    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }

    

}