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
	
	
	public Space(int newAlto , int newAncho) {
		this.alto=newAlto;
	    this.ancho=newAncho;
	    this.colorInvaders = Color.GRAY;
	    this.colorBarrera = Color.red;
		this.colorNave = Color.BLUE;
		this.cantidadBarrera = 3;
	  
	    //prepareMatrizInvaders();
	    prepareArrayBarrera();
	    //prepararNave();
	    //preparePlatillo();
	    
	}
	private void prepareMatrizInvaders(){
		invasoresMatriz = new Invasor[alto][ancho];
        
        for (int i = 0; i < alto; i++){
            for (int j = 0; j < ancho; j++){
            	invasoresMatriz[i][j] = new Calamar(colorInvaders, i,j);
            }
        } 
    }
	private void prepareArrayBarrera(){
		barreraArray = new Barrera[cantidadBarrera];
        
        for (int i = 0; i < cantidadBarrera; i++){
            barreraArray[i] = new Roja(i);
            
        } 
    }
	
	public Barrera getBarrera(int i){
		return barreraArray[i];
	}
	private void prepararNave() {
		naveArray = new Nave[1];
				
		naveArray[0]= new NormalNave(750,200,0,0,colorNave);
	}
	public Nave getNave(int i){
		return naveArray[i];
	}
	/*private void preparePlatillo() {
		platilloArray = new Platillo(Color.RED, 0,0);
		
		
	}*/

	//invasor






















//nave






















}
