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
public class NormalNave extends Nave{


    public NormalNave(int newNumeroVidas, int newNumeroDisparos, int newPosicionX, int newPosicionY, Color newColor){
        super(newNumeroVidas, newNumeroDisparos, newPosicionX, newPosicionY, newColor);
        prepareMatriz(newColor);
    }
    public void movePosicionX(int newPostitionX){
        this.posicionX+=newPostitionX;
    }


}