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
import java.lang.*;
import java.lang.reflect.InvocationTargetException;

public class Space {
	
	private int alto;
	private int ancho;
	public Invasor[][] invasoresMatriz;
	public Barrera[] barreraArray;
	public Nave[] naveArray;
	//public Platillo platilloArray;
	private Color colorInvaders;
	private Color colorNave;
	private Color colorBarrera;
	private int cantidadBarrera;
	private Nave naveSpace;
		
	public Space(int newAlto , int newAncho) {
		this.alto=newAlto;
	    this.ancho=newAncho;
	    this.colorInvaders = Color.GRAY;
	    this.colorBarrera = Color.red;
		this.colorNave = Color.BLUE;
		this.cantidadBarrera = 3;
	  
	    prepareMatrizInvaders();
	    prepareArrayBarrera();
	    prepararNave();
	    //preparePlatillo();
	    
	}
	private void prepareMatrizInvaders(){
		invasoresMatriz = new Invasor[alto][ancho];
		try{
			addInvaders("aplicacion.Calamar", Color.blue, 0, 0);
		}catch(Exception e){
			throw new RuntimeException(e); //mala práctica: esconder excepciones
		   

		}
        
        /*for (int i = 0; i < alto; i++){
            for (int j = 0; j < ancho; j++){
				
            	
            }
        } */
	}
	private void prepareArrayBarrera(){
		barreraArray = new Barrera[cantidadBarrera];
        
        for (int i = 0; i < cantidadBarrera; i++){
            barreraArray[i] = new Roja(i);
            
        } 
	}
	public void addInvaders(String invasores,Color newColorInvaders,int fila,int columna) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
		invasoresMatriz[fila][columna]=(Invasor)(Class.forName(invasores).getConstructors()[0].newInstance(newColorInvaders,fila,columna));

	}
	public Barrera getBarrera(int i){
		return barreraArray[i];
	}
	private void prepararNave() {
		naveArray = new Nave[1];
				
		naveArray[0]= new NormalNave(0,0,475,500,colorNave);
	}
	public Nave getNave(int i){
		return naveArray[i];
	}
	/*private void preparePlatillo() {
		platilloArray = new Platillo(Color.RED, 0,0);
		
		
	}*/

	//invasor

	public Invasor getInvasor(int f, int c){
		return invasoresMatriz[f][c];
	}


















	//nave
	public void moveNave(int i,int newPosicionX){
		naveSpace = getNave(i);
		naveSpace.movePosicionX(newPosicionX);
	}






















}
