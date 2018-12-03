package aplicacion;
import java.io.Serializable;



public class HUD implements Serializable{
    private int vidas;
    private int puntaje;
    private float presicion;
    private int fallo;


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
