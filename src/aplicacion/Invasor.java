package aplicacion;
import java.awt.*;

public abstract class Invasor {
    public Color color;
    private int fila, columna, puntaje, dano, posicionX, posicionY;
    protected int  resistencia;
    protected boolean destroid;
    protected int[][] forma;

    public Invasor(Color color, int fila, int columna){
        this.color = color;
        this.fila = fila;
        this.columna = columna;
    }
    public abstract void setResistencia();
    public abstract void setForma();

    public void setDano(int dano){
        this.dano = dano;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }
    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }
    public void destroid(){
        this.destroid = false;
    }
    public int getDano(){
        return dano;
    }
    public int getResistencia(){
        return resistencia;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public boolean isDestroid(){
        return destroid;
    }
    public int[][] getForma(){
        return forma;
    }

    public int getBinario(int f, int c){
        System.out.println(forma[0][0]);
        return forma[f][c];   
    }
}
