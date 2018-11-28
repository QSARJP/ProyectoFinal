package aplicacion;

import java.io.Serializable;

public class Pulpo extends Invasor implements Serializable{

    private int resistencia;
    private int[][] forma = {{0,0,0,0,1,1,1,1,0,0,0,0},{0,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,0,0,1,1,0,0,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1},{0,0,0,1,1,0,0,1,1,0,0,0},{0,0,1,1,0,1,1,0,1,1,0,0},{1,1,0,0,0,0,0,0,0,0,1,1}};

    public Pulpo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        setResistencia();
        addInvasor(this);
    }

    public void setResistencia(){
        this.resistencia = 1;
    }

    public int[][] getBinarios(){
        return forma;
    }

    public int getResistencia(){
        return resistencia;
    }
}