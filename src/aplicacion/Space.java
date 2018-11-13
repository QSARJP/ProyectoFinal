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
	public Invasores[][] invasoresMatriz;
	public Barrera[] barreraArray;
	public Nave[] naveArray;
	public Platillo platilloArray;
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
	  
	    prepareMatrizInvaders();
	    prepareArrayBarrera();
	    prepararNave();
	    preparePlatillo();
	    
	}
	
	
	
	private void prepareMatrizInvaders(){
		invasoresMatriz = new invasoresMatriz[alto][ancho];
        
        for (int i = 0; i < alto; i++){
            for (int j = 0; j < ancho; j++){
            	invasoresMatriz[i][j] = new Invasor(colorInvaders, i,j);
            }
        } 
    }
	private void prepareArrayBarrera(){
		barreraArray = new barreraArray[3][cantidadBarrera];
        
        for (int i = 0; i < cantidadBarrera; i++){
			for (int j = 0; j < 3; j++){
				barreraArray[i] = new Barrera(colorBarrera, i,j);
			}
        } 
    }
	private void prepararNave() {
		naveArray = new naveArray[1]
				
		naveArray[0]= new Nave(0,0,colorNave);
	}
	private void preparePlatillo() {
		platilloArray = new Platillo(Color.RED, 0,0);
		
		
	}


}
