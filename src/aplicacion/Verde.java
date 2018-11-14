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

public class Verde extends Barrera{


    public Verde(Color color, int fila, int columna){
        super(color, fila, columna);
        prepareMatriz();
    }
    public void prepareMatriz(){
        materiales = new Material[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j ++){
                material[i][j] = new Material(color, true);
            }
        }
    }
}

