package aplicacion;

import presentacion.SpaceGUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;

public class MoverInvaders extends Thread{

    private Space space;
    private SpaceGUI spaceGUI;
    /**
     * Constructor de la clase MoverInvaders
     * @param spaceGUI SpaceGUI
     * @param space Space que tiene la imformacion de la aplicacion
     */
    public MoverInvaders(SpaceGUI spaceGUI, Space space){
        this.space = space;
        this.spaceGUI = spaceGUI;
    }

    @Override
    /**
     * ejecuta el movimiento de los elementos
     */
    public void run(){
        
        int n = 1;
        int n2=1;
        int n3=1;
        while(space.flag){
            if (moverTodosInvasores(1*n,0) >= 1){
                moverTodosInvasores(0,5);
                n = n*-1;
            }
            for (int i= 0;i<2;i++){
                if (moverPlatillo(1*n2,0) >= 1){
                    n2 = n2*-1;
                }
            }
            if (space.hayMaquina()){
                if (moveMaquinas(n3)>=1){
                    n3 = n3*-1;
                }
            }
            for(int i = 0; i < space.getDisparos().size();i++){
                Disparo disparo = space.getDisparos().get(i);
                int dx = disparo.getElemento().disparo();
                if(space.mover(disparo,0,dx) == 1){
                    space.getDisparos().remove(disparo);
                }                
            }
            esperar();
            spaceGUI.refresque();
            if(space.getInvasores().size() == 0 ){
                space.niveles();
            }
            if(space.getNaves().size()==0){
                space.flag = false;
                JOptionPane.showMessageDialog(null, "Se termino el juego ");
            }
            while (space.pausa){
                esperar();
            }
        }

        
    }
    /**
     * Metodo que se encarga de mover los invasores y las maquinas
     * @param x posicion x que se va a mover
     * @param y posicion y que se va a over
     * @return retorna 1 o 0 dependiendo de si el elemento esta en los limites permitidos
     */
    public int moverTodosInvasores(int x, int y){
        int cont = 0;
        for (int i = 0;i< space.getInvasores().size();i++){
            Invasor invasor = space.getInvasores().get(i);
            int aleatorio=(int) (Math.random()*1000) + 1;
            if (aleatorio == 22 ){
                space.disparo(invasor,false);
            }
            cont += space.mover(invasor, x, y);
        }
        
        return cont;
    }
    /**
     * mueve el platillo
     * @param x  posicion x que se va a mover
     * @param y posicion y que se va a over
     * @return retorna 1 o 0 dependiendo de si el elemento esta en los limites permitidos
     */
    public int moverPlatillo(int x, int y){
        int cont = 0;
        for (int i = 0;i< space.getPlatillo().size();i++){
            Platillo pla = space.getPlatillo().get(i);
            int aleatorio=(int) (Math.random()*100) + 1;
            if (aleatorio == 22 ){
                space.disparo(pla,true);
            }
            cont += space.mover(pla, x, y);
        }
        return cont;
    }
    /**
     * mueve las maquinas
     * @param n determina el sentido del movimiento
     * @return
     */
    private int moveMaquinas(int n){
        int cont = 0;
        if (space.opcion==1){
            Nave nave = space.getNaves().get(1);
            int aleatorio=(int) (Math.random()*100) + 1;
            
            if (nave.aleatoria() == 50){
                space.disparo(nave,false);
            }
            
            cont += space.mover(nave, 1*n, 0);
        }else if (space.opcion==2){
            for (int i =0; i<space.getNaves().size();i++){
                Nave nave = space.getNaves().get(i);
                
                if (nave.aleatoria() == 50){
                    space.disparo(nave,false);
                }
                
                cont += space.mover(nave, 1*n, 0);
            }
        }
        return cont;
    }
    /**
     * Detiene el thread los milisegundos asignados
     */
    private void esperar(){
        try{
            Thread.sleep(15);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}