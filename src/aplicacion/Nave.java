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

public abstract class Nave {

    private int numeroVidas;
    private int numeroDisparos;
    private int posicionX;
    private int posicionY;
    protected Color color;

    public Nave (int newNumeroVidas, int newNumeroDisparos, int newPosicionX, int newPosicionY, Color newColor){
        this.numeroVidas=newNumeroVidas;
        this.numeroDisparos=newNumeroDisparos;
        this.posicionX=newPosicionX;
        this.color=newColor;
        this.posicionY = newPosicionY;


    }
    public abstract void setPosicionX();

    public void getColor{
        
    }
    
}
