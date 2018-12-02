package aplicacion;

import java.util.ArrayList;
import java.util.TreeMap;

import java.awt.*;
import java.io.Serializable;

public class BarreraVerde extends Barrera implements Serializable{

    private Color color;
    private int[][] forma = {{0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1},{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1}};
    private ArrayList < Material> materiales;

    public BarreraVerde(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.green;
        materiales = new ArrayList<Material>();
        addMateriales();
        space.addBarrera(this);

    }

    public void addMateriales(){
        for (int i = 0; i < forma.length; i++){
            for (int j = 0; j < forma[i].length; j++){
                if (forma[i][j] == 1){
                    materiales.add(new Material(space, posicionX+j*2, posicionY+i*2));
                }
            }
        }
    }

    public ArrayList<Material> getMateriales(){
        return materiales;
    }

    public Color getColor(){
        return color;
    }
    public  void disminuirResistencia(int poX,int poY, int dy){
        if (dy < 0){
            for (int i =0; i<materiales.size();i++){
                Material ma = materiales.get(i);
                int x = ma.getPosicionInt()[0];
                int y = ma.getPosicionInt()[1];
                boolean a =  poX>= x && poX <= x + 2;
                boolean b = poY >= y && poY <= y-2;
                if (a && b ){
                    //destruirBarrera(x,y);
                    materiales.remove(ma);
                }
            }
        }
    }
    /*private void destruirBarrera(int x, int y){
        int[] r=new int[]{-2,2};
        for (int i:r){
            

        }

    }*/
}