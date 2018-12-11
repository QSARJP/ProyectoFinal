package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * clase Nave contiene todo lo referente a las naves con las aprtes escenciales como su forma y tipo de dispaso
 *
 * @author Ospina-Rivera
 * 
 * @version (a version 8/11/18)
 */
public abstract class Nave extends Elemento implements Serializable{

    private int[][] forma = {{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    protected ArrayList<String> disparos = new ArrayList<String>();
    
    /**
     * E el contructro de la clase nave la cual posee informacion del space y posicion inical de la nave 
     * @param space
     * @param posicionX
     * @param posicionY
     */
    public Nave(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        disparos = new ArrayList<String>();
        
    }

    public int[][] getBinarios(){
        return forma;
    }

    public abstract Color getColor();
    
    public abstract void changeColor(Color newColor);

    public ArrayList<String> getDisparos(){
        return disparos;
    }
    
    /**
     * Es la encargada de mover las naves al ser abstarata podra ser usada de diferentes maneras 
     */
    public abstract int mover(int posicionX, int posicionY);
    
    /**
     * genera la direccion de la bala
     */
    public int disparo(){
        return -2;
    }
    /**
     * disminuye la resistencia de la bala si el boleano es verdadero se destruye autoamticamente
     * @param bo
     */
    public abstract void disminuirResistencia(boolean bo);
    /**
     * comienza la informacion de la nave
     */
    public abstract void stratHUD(HUD hud);
    /**
     * retorna el HUD de cada nave
     * @return
     */
    public abstract HUD getHUD();
    /**
     * cambia de puntaje
     */
    public abstract void setPuntajeHUD(int puntaje);
    /**
     * si la bala de una nave imapcta el platillo este metodo agrega dos vidas a la nave y genera dos balas
     */
    public abstract void mejoraNave();
    /**
     * tiene como fin generar un numero aletaroio para la frecuencia de disparo
     * @return
     */
    public abstract int aleatoria();


    
}