package aplicacion;

import java.awt.Color;
import java.io.Serializable;
import java.util.*;

public abstract class Barrera extends Elemento implements Serializable{
    protected ArrayList<String> disparos = new ArrayList<String>();

    public Barrera(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

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

}