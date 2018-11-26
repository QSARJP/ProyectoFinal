package aplicacion;

import java.awt.Color;

public abstract class Nave extends Elemento{

    private int[][] forma = {{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

    public Nave(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

    public int[][] getBinarios(){
        return forma;
    }

    public abstract Color getColor();
}