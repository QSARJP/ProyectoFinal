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
    private int[][] forma = {{}};
    public Verde(int columna){
        super(columna);
        this.color = Color.green;
        prepareMatriz(color);
    }
}

