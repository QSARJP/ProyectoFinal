package aplicacion;

import java.awt.Color;
import java.io.Serializable;
import java.util.*;
/**
 * clase Barrera es la encargada de tener la infromacion necesaria para la construccion de cualquier barrera
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 8/11/18)
 */
public abstract class Barrera extends Elemento implements Serializable{
    protected ArrayList<String> disparos = new ArrayList<String>();
    /**
     * Constructor de la barrera
     * @param space
     * @param posicionX
     * @param posicionY
     */
    public Barrera(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }
    /**
     * Agrega los materiales necesarios para la barrera
     */
    public abstract void addMateriales();
    public abstract ArrayList<Material> getMateriales();

    public abstract Color getColor();
    
    public int mover(int posicionX, int posicionY){
        return 0;
    }
    public int disparo(){
        return 0;
    }
    public  ArrayList<String> getDisparos(){
        return disparos;
    }
    public abstract void disminuirResistencia(int poX,int poY,int dy,boolean bo);
    public  void setPuntajeHUD(int puntaje){}
    public  void mejoraNave(){}

}