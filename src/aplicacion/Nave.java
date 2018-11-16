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
    protected int posicionX;
    private int posicionY;
    private Color color;
    protected Material[][] materiales;

    public Nave (int newNumeroVidas, int newNumeroDisparos, int newPosicionX, int newPosicionY, Color newColor){
        this.numeroVidas=newNumeroVidas;
        this.numeroDisparos=newNumeroDisparos;
        this.posicionX=newPosicionX;
        this.posicionY = newPosicionY;
        this.color = newColor;
        


    }
    public abstract void movePosicionX(int newPostitionX);

    public void prepareMatriz(Color color){
		materiales = new Material[4][9];
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 9; j++){
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
    public int getPosition(){
        return posicionX;
    }
}
