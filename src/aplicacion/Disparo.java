package aplicacion;

import java.awt.*;
import java.io.Serializable;
import java.util.*;


public abstract class Disparo extends Elemento implements Serializable{

    protected Elemento elemento;
    private ArrayList<Disparo> disparos = new ArrayList<Disparo>();

    public Disparo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        
    }

    public void setElemento(Elemento elemento){
        this.elemento = elemento;
    }
    public Elemento getElemento(){
        return elemento;
    }


    public abstract Color getColor();

    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }

    public abstract int mover(int posicionX, int posicionY);

    public int disparo(){
        return 0;
    }
    public  ArrayList<Disparo> getDisparos(){
        return disparos;
    }
    public  void setPuntajeHUD(int puntaje){}
}