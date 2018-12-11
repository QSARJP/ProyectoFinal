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
    /**
     * Añade materiales a la barrera para su construccion
     */
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

    /**
     * disminuye las vidas de la barrera
     * @param poX posicion en x donde golpea la bala
     * @param poY posicion en y donde golpea la bala
     * @param dy sentido del movimiento de la bala + hacia abajo, - hacia arriba
     * @param bo indica la mierte del elemento
     */
    public  void disminuirResistencia(int poX,int poY, int dy,boolean bo){
        if (dy > 0){
			if (bo){
				materiales=new ArrayList<Material>();
			}
            for (int i =0; i<materiales.size();i++){
       5         Material ma = materiales.get(i);
                int x = ma.getPosicionInt()[0];
                int y = ma.getPosicionInt()[1];
                boolean a =  poX>= x && poX <= x+40;
                boolean b = poY <= y && poY >= y-40;
                //System.out.println(a+" "+poY+" "+y);
                if (a && b ){
                    //System.out.println("hola");
                    //System.out.println(poX+" "+x);
                    //System.out.println(poY+" "+y);
                    //destruirBarrera(x,y);
                    materiales.remove(ma);
                }
            }
            if (materiales.size()==0){
                space.getBarreras().remove(this);
            }
        }
    }
    /*private void destruirBarrera(int x, int y){
        int[] r=new int[]{-2,2};
        for (int i:r){
            

        }

    }*/
}