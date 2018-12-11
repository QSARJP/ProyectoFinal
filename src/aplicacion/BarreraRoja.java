package aplicacion;

import java.util.TreeMap;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class BarreraRoja extends Barrera implements Serializable{

    private Color color;
    private int[][] forma = {{0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1},{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1}};
    private ArrayList<Material>  materiales;

    public BarreraRoja(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.red;
        materiales = new ArrayList<Material> ();
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
    public  void disminuirResistencia(int poX,int poY, int dy,boolean bo){
        if (dy < 0){
            for (int i =0; i<materiales.size();i++){
                Material ma = materiales.get(i);
                int x = ma.getPosicionInt()[0];
                int y = ma.getPosicionInt()[1];
                boolean a =  poX>= x && poX <= x+40;
                boolean b = poY <= y+40 && poY >= y;
                if (a && b ){
                    space.getBarreras().remove(this);
                }
            }
        }else if(dy >0){
			for (int i =0; i<materiales.size();i++){
                Material ma = materiales.get(i);
                int x = ma.getPosicionInt()[0];
                int y = ma.getPosicionInt()[1];
                boolean a =  poX>= x && poX <= x+40;
                boolean b = poY <= y+40 && poY >= y;
                if (a && b ){
					if (bo){
						space.getBarreras().remove(this);
					}
                }
            }
			
			
		}
		
    }
}