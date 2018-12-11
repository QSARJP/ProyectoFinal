package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * clase invasor es la encargada de contener todo lo pertinente con los invasores 
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 8/11/18)
 */
public abstract class Invasor extends Elemento implements Serializable{

    protected ArrayList<String> disparos = new ArrayList<String>();
    /**
     * Es el constructor de los Invasores con la posicion deseada
     * @param space
     * @param posicionX
     * @param posicionY
     */
    public Invasor(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

    public abstract void setResistencia();
    public abstract int[][] getBinarios();
    /**
     * es la responsable de agregar el invasor al al contenedeor de invasores en space
     */
    public void addInvasor(Invasor invasor){
        space.addInvasor(invasor);
    }
    /**
     * disminuye la resistencia si es afectada por un disparo
     * @return
     */
    public abstract boolean disminuirResistencia();

    public abstract int getResistencia();

    /**
     * Es la encargada de mover el invasor de posicion segun se le indique
     */
    public abstract int mover(int posicionX, int posicionY);

    /**
     * como esta clase no da puntaje no se realiza ninguna accion
     */
    public  void setPuntajeHUD(int puntaje){}

    public abstract int getPuntaje();
    /**
     * retrona los disparos especiales de los invasores
     */
    public ArrayList<String> getDisparos(){
		int aleatorio=(int) (Math.random()*5) + 1;
		if (aleatorio==2){
			disparos.add("aplicacion.DisparoPlasma");
		}
        return disparos;
    }
    /**
     * retorna el sentido de la posicion de disparo
     */
    public int disparo(){
        return 2;
    }
    public  void mejoraNave(){}
    


}