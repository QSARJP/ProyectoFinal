package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class Nave extends Elemento implements Serializable{

    private int[][] forma = {{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    protected ArrayList<String> disparos;
    
    
    public Nave(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        disparos = new ArrayList<String>();
        
    }

    public int[][] getBinarios(){
        return forma;
    }

    public abstract Color getColor();
    
    public abstract void changeColor(Color newColor);

    public ArrayList<String> getDisparos(){
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
    public abstract void disminuirResistencia(boolean bo);

    public abstract void stratHUD(HUD hud);
    public abstract HUD getHUD();
    
    public abstract void setPuntajeHUD(int puntaje);


    
}