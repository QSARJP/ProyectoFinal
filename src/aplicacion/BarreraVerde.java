package aplicacion;

import java.util.TreeMap;
import java.awt.*;
import java.io.Serializable;

public class BarreraVerde extends Barrera implements Serializable{

    private Color color;
    private int[][] forma = {{0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1},{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1}};
    private TreeMap <String, Material> materiales;

    public BarreraVerde(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.green;
        materiales = new TreeMap<String, Material>();
        addMateriales();
        space.addBarrera(this);

    }

    public void addMateriales(){
        for (int i = 0; i < forma.length; i++){
            for (int j = 0; j < forma[i].length; j++){
                if (forma[i][j] == 1){
                    String posicion = Integer.toString(posicionX+j*2)+","+Integer.toString(posicionY+i*2);
                    materiales.put(posicion, new Material(space, posicionX+j*2, posicionY+i*2));
                }
            }
        }
    }

    public TreeMap<String, Material> getMateriales(){
        return materiales;
    }

    public Color getColor(){
        return color;
    }
}