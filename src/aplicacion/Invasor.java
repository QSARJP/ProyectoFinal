package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Invasor extends Elemento implements Serializable{

    protected ArrayList<String> disparos = new ArrayList<String>();

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

    public ArrayList<String> getDisparos(){
		int aleatorio=(int) (Math.random()*5) + 1;
		if (aleatorio==2){
			disparos.add("aplicacion.DisparoPlasma");
		}
        return disparos;
    }
    public int disparo(){
        return 2;
    }
    public  void mejoraNave(){}
    


}