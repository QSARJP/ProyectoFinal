package aplicacion;

import java.io.Serializable;

public abstract class Invasor extends Elemento implements Serializable{

    public Invasor(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

    public abstract void setResistencia();
    public abstract int[][] getBinarios();

    public void addInvasor(Invasor invasor){
        space.addInvasor(invasor);
    }

    public abstract void disminuirResistencia();

    public abstract int getResistencia();

    public abstract int mover(int posicionX, int posicionY);

}