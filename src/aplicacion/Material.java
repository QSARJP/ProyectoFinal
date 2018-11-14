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

public class Material{
    private Color color;
    private boolean estado;
    private int posicionX;
    private int posicionY;
    
    public Material(Color color, boolean estado){
        this.color = color;
        this.estado = estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setPosicionX(int posicionX){
        this.posicionX =posicionX;
    }
    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }
}