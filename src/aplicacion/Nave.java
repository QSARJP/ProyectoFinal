package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class Nave extends Elemento implements Serializable{

    private int[][] forma = {{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    protected ArrayList<Disparo> disparos;
    
    
    public Nave(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        disparos = new ArrayList<Disparo>();
        
    }

    public int[][] getBinarios(){
        return forma;
    }

    public abstract Color getColor();
    
    public abstract void changeColor(Color newColor);

    public ArrayList<Disparo> getDisparos(){
        return disparos;
    }
    public int mover(int posicionX, int posicionY){
        this.posicionX += posicionX;
        this.posicionY += posicionY;
        return 0;
    }
    public int disparo(){
        return -2;
    }

    
}