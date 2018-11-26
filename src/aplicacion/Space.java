package aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;

public class Space{
    private TreeMap<String, Invasor> invasores;
    private TreeMap<String, Barrera> barreras;
    private ArrayList<Nave> naves;
    private ArrayList<Disparo> disparos;

    public Space(){
        invasores = new TreeMap<String, Invasor>();
        barreras = new TreeMap<String, Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparos>();
        leerElemento();
    }

    public void addInvasor(Invasor invasor){
        invasores.put(invasor.getPosicion(), invasor);
    }

    public void addBarrera(Barrera barrera){
        barreras.put(barrera.getPosicion(), barrera);
    }

    public void addNave(Nave nave){
        naves.add(nave);
    }

    private void leerElemento(){
        try{
            addElemento("aplicacion.Platillo", 330, 10);
            addElemento("aplicacion.Calamar", 210, 50);
            addElemento("aplicacion.Calamar", 250, 50);
            addElemento("aplicacion.Calamar", 290, 50);
            addElemento("aplicacion.Cangrejo", 330, 50);
            addElemento("aplicacion.Cangrejo", 370, 50);
            addElemento("aplicacion.Cangrejo", 410, 50);
            addElemento("aplicacion.Pulpo", 450, 50);
            addElemento("aplicacion.Pulpo", 490, 50);
            addElemento("aplicacion.Pulpo", 530, 50);
            addElemento("aplicacion.BarreraVerde",300,400);
            addElemento("aplicacion.BarreraRoja",200,400);
            addElemento("aplicacion.BarreraRoja",400,400);
            addElemento("aplicacion.BarreraVerde",500,400);
            addElemento("aplicacion.NaveJugador",400, 480);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private void addElemento(String objeto, int posicionX, int posicionY) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        Elemento elemento = (Elemento)Class.forName(objeto).getConstructors()[0].newInstance(this, posicionX, posicionY);
    }

    public void mover(Elemento elemento, int posicionX, int posicionY){
        elemento.mover(posicionX, posicionY);
    }

    public TreeMap<String, Invasor> getInvasores(){
        return invasores;
    }

    public TreeMap<String, Barrera> getBarreras(){
        return barreras;
    }

    public ArrayList<Nave> getNaves(){
        return naves;
    }

    public void addDisparo(Disparo disparo){
        diaparos.add(disparo);
    }
}