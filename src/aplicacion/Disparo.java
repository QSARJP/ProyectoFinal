package aplicacion;

import java.awt.*;
import java.io.Serializable;
import java.util.*;

/**
 * clase Disparo es la encargada de generar la fuincionalidades de la bala en general  
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 8/11/18)
 */
public abstract class Disparo extends Elemento implements Serializable{

    protected Elemento elemento;
    private ArrayList<String> disparos = new ArrayList<String>();
    /**
     * Constructor de la calse Disparo
     * @param space
     * @param posicionX
     * @param posicionY
     */
    public Disparo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        
    }

    public void setElemento(Elemento elemento){
        this.elemento = elemento;
    }
    public Elemento getElemento(){
        return elemento;
    }
    public void addDisparo(Disparo newDisparo){
        space.addDisparo(newDisparo);
    }


    public abstract Color getColor();

    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }
    /**
     * Es la encargda de mover la bala
     */
    public abstract int mover(int posicionX, int posicionY);

    public int disparo(){
        return 0;
    }
    public  ArrayList<String> getDisparos(){
        return disparos;
    }
    public  void setPuntajeHUD(int puntaje){}

    public  void mejoraNave(){}
}