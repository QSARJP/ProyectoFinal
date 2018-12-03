package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Invasor extends Elemento implements Serializable{

    protected ArrayList<Disparo> disparos = new ArrayList<Disparo>();

    public Invasor(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

    public abstract void setResistencia();
    public abstract int[][] getBinarios();

    public void addInvasor(Invasor invasor){
        space.addInvasor(invasor);
    }

    public abstract boolean disminuirResistencia();

    public abstract int getResistencia();

    public abstract int mover(int posicionX, int posicionY);

    public  void setPuntajeHUD(int puntaje){
        
    }

    public abstract int getPuntaje();

    public ArrayList<Disparo> getDisparos(){
        return disparos;
    }
    public int disparo(){
        return 2;
    }
    


}