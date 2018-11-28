package aplicacion;
import java.io.Serializable;

public class Calamar extends Invasor implements Serializable{

    private int[][] forma = {{0,0,0,0,1,1,0,0,0,0,0},{0,0,0,1,1,1,1,0,0,0,0},{0,0,1,1,1,1,1,1,0,0,0},{0,1,1,0,1,1,0,1,1,0,0},{0,1,1,1,1,1,1,1,1,0,0},{0,0,0,1,0,0,1,0,0,0,0},{0,0,1,0,1,1,0,1,0,0,0},{0,1,0,1,0,0,1,0,1,0,0}};
    private int resistencia;

    public Calamar(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        setResistencia();
        addInvasor(this);
    }

    public void setResistencia(){
        this.resistencia = (int)Math.random()*3 + 1;
    }

    public int[][] getBinarios(){
        return forma;
    }
    
    public int getResistencia(){
        return resistencia;
    }
}