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

public abstract class Barrera {
    
    private int posicionX, posicionY, columna;
    protected Material[][] materiales;
    protected Color color;
    protected int[][] forma;


    public Barrera(int columna){
        this.columna = columna;
    }

    public void prepareMatriz(Color color){
		materiales = new Material[20][20];
		for (int i = 0; i < 20; i++){
			for (int j = 0; j < 20; j++){
				materiales[i][j] = new Material(color,true);
			}
		}
	}

	public Material getMaterial(int f, int c){
		return materiales[f][c];
    }
    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }
    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }
    public Color getColor(){
        return color;
    }
    public abstract int getBinario(int f, int c);
}