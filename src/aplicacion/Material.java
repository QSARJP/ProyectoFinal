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
import java.io.Serializable;


public class Material extends Elemento implements Serializable{
    public Material(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }
    public void mover(int posicionX, int posicionY){
        this.posicionX += posicionX;
        this.posicionY += posicionY;
    }
}