package aplicacion;

import java.awt.Color;
import java.util.TreeMap;
import java.io.Serializable;

public abstract class Barrera extends Elemento implements Serializable{

    public Barrera(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

    public abstract void addMateriales();
    public abstract TreeMap<String, Material> getMateriales();
    public abstract Color getColor();

}