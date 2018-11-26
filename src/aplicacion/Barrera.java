package aplicacion;

import java.awt.Color;
import java.util.TreeMap;

public abstract class Barrera extends Elemento{

    public Barrera(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

    public abstract void addMateriales();
    public abstract TreeMap<String, Material> getMateriales();
    public abstract Color getColor();

}