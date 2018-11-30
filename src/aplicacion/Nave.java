package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class Nave extends Elemento implements Serializable{

    private int[][] forma = {{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    protected int disparosNormales;
    protected ArrayList<Disparo> disparos;

    public Nave(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        disparos = new ArrayList<Disparo>();
        
    }

    public int[][] getBinarios(){
        return forma;
    }

    public abstract Color getColor();

    public void prepareDisparos(){
        for (int i = 0; i < disparosNormales; i++){
            disparos.add(new DisparoNormal(space, 0, 0));
        }
    }
    public ArrayList<Disparo> getDisparos(){
        return disparos;
    }
    public void mover(int posicionX, int posicionY){
        this.posicionX += posicionX;
        this.posicionY += posicionY;
    }

    
}