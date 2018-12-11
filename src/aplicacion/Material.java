package aplicacion;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.io.Serializable;


public class Material extends Elemento implements Serializable{
    private ArrayList<String> disparos = new ArrayList<String>();
    public Material(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }
    public int mover(int posicionX, int posicionY){
        return 0;
    }
    public int disparo(){
        return 0;
    }
    public  ArrayList<String> getDisparos(){
        return disparos;
    }
    public  void setPuntajeHUD(int puntaje){
        
    }
    public  void mejoraNave(){}
}