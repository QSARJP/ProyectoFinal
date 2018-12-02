package aplicacion;

import presentacion.SpaceGUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.InvocationTargetException;

public class MoverInvaders extends Thread{

    private Space space;
    private SpaceGUI spaceGUI;

    public MoverInvaders(SpaceGUI spaceGUI, Space space){
        this.space = space;
        this.spaceGUI = spaceGUI;
        //prepareAccionTeclado();
    }

    @Override
    public void run(){
        
        int n = 1;
        while(spaceGUI.flag){
            if (moverTodosInvasores(1*n,0) >= 1){
                moverTodosInvasores(0,5);
                n = n*-1;
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
            if(space.getInvasores().size() == 0){spaceGUI.flag = false;}
        }

        
    }
    public void prepareAccionTeclado(){
        KeyListener accionNave2 = new KeyListener(){
        
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
        
            @Override
            public void keyReleased(KeyEvent e) {

            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_A){
                    int dx = -5;
                    Nave nave = space.getNaves().get(1);
                    space.mover(nave, dx, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    int dx = 5;
                    Nave nave = space.getNaves().get(1);
                    space.mover(nave, dx, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_W){
                    Nave nave = space.getNaves().get(1);
                    space.disparo(nave);
                }
                spaceGUI.refresque();
            }
        };
        spaceGUI.juego.addKeyListener(accionNave2);
    }

    public int moverTodosInvasores(int x, int y){
        int cont = 0;
        for (int i = 0;i< space.getInvasores().size();i++){
            Invasor invasor = space.getInvasores().get(i);
            int aleatorio=(int) (Math.random()*100) + 1;
            if (aleatorio == 22 ){
                space.disparo(invasor);
            }
            cont += space.mover(invasor, x, y);
        }
        return cont;
    }

    private void esperar(){
        try{
            Thread.sleep(15);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}