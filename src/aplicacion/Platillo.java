package aplicacion;
import java.io.Serializable;
import java.util.*;
public class Platillo extends Elemento implements Serializable{
    private int resistencia;
    private ArrayList<Disparo> disparos = new ArrayList<Disparo>();
    private int[][] forma = {{0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},{0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0}};
    private int puntaje;
    public Platillo(Space space, int posicionX, int posicionY){
        super(space,posicionX,posicionY);
        setPuntaje();
    }

    public void setResistencia(){}

    public int getResistencia(){
        return resistencia;
    }
    public void setPuntaje(){
        this.puntaje=200;
    }

    public int[][] getBinarios(){
        return forma;
    }
    public int mover(int posicionX, int posicionY){
        this.posicionX += posicionX;
        this.posicionY += posicionY;
        return 0;
    }
    public int disparo(){
        return 0;
    }
    public  ArrayList<Disparo> getDisparos(){
        return disparos;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public void setPuntajeHUD(int puntaje){}
    
}