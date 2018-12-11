package aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * clase Elemento es la clase mas importate ya que cualqueir elmento se puede dibujar gracias a esta clase 
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 8/11/18)
 */
public abstract class Elemento implements Serializable {
    protected int posicionX;
	protected int posicionY;
    protected Space space;

    /**
     * Constructor del elemento
     * @param space
     * @param posicionX
     * @param posicionY
     */
    public Elemento(Space space, int posicionX, int posicionY){

        this.space = space;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    /**
     * es la encargada de mover los elementos
     * @param posicionX
     * @param posicionY
     * @return
     */
    public abstract int mover(int posicionX, int posicionY);
    /**
     * Es la encargada de retronar los disparos
     * @return
     */
    public abstract ArrayList<String> getDisparos();
    /**
     * Indica la posicion del disparo
     * @return
     */
    public abstract int disparo();
    /**
     * si es invasor retorna el puntaje al momento de morir
     * @param puntaje
     */
    public abstract void setPuntajeHUD(int puntaje);
    /**
     * indica las mejoras de la nave
     */
    public abstract void mejoraNave();
        
    
    public String getPosicion(){
        String posicion = Integer.toString(posicionX) +","+Integer.toString(posicionY);
        return posicion;
    }

    public int[] getPosicionInt(){
        int[] posicion = {posicionX,posicionY};
        return posicion;
    }

    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }
    

    

}