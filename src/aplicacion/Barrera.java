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
    
    private int posicionX;
    private int posicionY;
    private Color color;
    private int estado;


    public Barrera(Color newColor, int posicionX, int posicionY){

        this.posicionX=posicionX;
        this.posicionY = posicionY;
        this.color=newColor;

    }

    


}