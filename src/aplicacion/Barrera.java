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
    
    protected int posicionX;
    protected Color color;
    protected int estado;


    public Barrera(int newPosicionX, Color newColor){

        this.posicionX=newPosicionX;
        this.color=newColor;

    }

    


}
