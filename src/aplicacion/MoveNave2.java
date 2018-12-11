package aplicacion;


import presentacion.SpaceGUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.InvocationTargetException;

public class MoveNave2 extends Thread{

    private Space space;
    private SpaceGUI spaceGUI;
    private Nave nave;

    public MoveNave2(SpaceGUI spaceGUI, Space space){
        this.space = space;
        this.spaceGUI = spaceGUI;
        nave = space.getNaves().get(1);
    }

    @Override
    public void run(){
        KeyListener accionNave = new KeyListener(){
        
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
        
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    space.disparo(nave,false);
                }
                spaceGUI.refresque();
            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_A){
                    int dx = -5;
                    space.mover(nave, dx, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    int dx = 5;
                    space.mover(nave, dx, 0);
                }
                spaceGUI.refresque();
            }
        };
        spaceGUI.juego.addKeyListener(accionNave);
    }


}