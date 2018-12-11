package aplicacion;
import java.io.Serializable;

/**
 * clase HUD Contiene toda la informacion de una nave como lo es la vida y su puntaje
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 8/11/18)
 */

public class HUD implements Serializable{
    private int vidas;
    private int puntaje;
    private float presicion;
    private int fallo;

    /**
     * Constructor del HUD
     */
    public HUD(){
        this.vidas = 0;
        this.puntaje=0;
        this.presicion=0;

    }

    public void setVidas(int vidas){
        this.vidas=vidas;

    }
    public void setPuntaje(int newPuntaje){
        this.puntaje+= newPuntaje;
    }
    public void setPresicion(int numeroBalas,int newFallo){
        this.fallo+=newFallo;
        this.presicion=fallo/numeroBalas;

    }
    public int getPuntaje(){
        return puntaje;
    }

    public int getVidas(){
        return vidas;
    }


}
