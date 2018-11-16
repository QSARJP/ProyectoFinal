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


public class Roja extends Barrera{
    public Roja( int columna){
		super(columna);
		this.color = Color.red;
		prepareMatriz(color);
    }
	
	
	
}