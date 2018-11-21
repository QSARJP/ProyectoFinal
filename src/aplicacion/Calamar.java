package aplicacion;
import java.util.*;
import java.awt.*;

public final  class Calamar extends Invasor{

    private Material[][] materiales;
    private int[][] forma = {{0,0,0,1,1,0,0,0},{0,0,1,1,1,1,0,0},{0,1,1,1,1,1,1,0},{1,1,0,1,1,0,1,1},{1,1,1,1,1,1,1,1},{0,0,1,0,0,1,0,0},{0,1,0,1,1,0,1,0},{1,0,1,0,0,1,0,1}};
    private int[][] forma2;
    public Calamar(Color color, int fila, int columna){
        super(color, fila, columna);
        setResistencia();
        setPuntaje(50);
        setDano(2);

    }
    public void setResistencia(){
        this.resistencia = (int)Math.random()*3 + 1;
    }
    public void setForma(){
        forma = new int[8][8];
        // = {0,0,0,1,1,0,0,0},{0,0,1,1,1,1,0,0},{0,1,1,1,1,1,1,0},{1,1,0,1,1,0,1,1},{1,1,1,1,1,1,1,1},{0,0,1,0,0,1,0,0},{0,1,0,1,1,0,1,0},{1,0,1,0,0,1,0,1}};
    }
    public  int getBinario(int f, int c){
        return forma[f][c];   
    }


}