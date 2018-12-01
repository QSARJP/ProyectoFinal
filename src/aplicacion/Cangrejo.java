package aplicacion;
import java.io.Serializable;

public class Cangrejo extends Invasor implements Serializable{

    private int resistencia;
    private int[][] forma = {{0,0,1,0,0,0,0,0,1,0,0},{0,0,0,1,0,0,0,1,0,0,0},{0,0,1,1,1,1,1,1,1,0,0},{0,1,1,0,1,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,1},{1,0,1,1,1,1,1,1,1,0,1},{1,0,1,0,0,0,0,0,1,0,1},{0,0,0,1,1,0,1,1,0,0,0}};

    public Cangrejo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        setResistencia();
        addInvasor(this);
    }

    public void setResistencia(){
        this.resistencia = 2;
    }

    public int[][] getBinarios(){
        return forma;
    }

    public int getResistencia(){
        return resistencia;
    }
    public int mover(int X, int Y){
        //if (sePuede())
        this.posicionX += X;
        this.posicionY += Y;
        if(this.posicionX == 750 || this.posicionX == 0){return 1;}
        else{return 0;}
    }

    private boolean sePuede(){
        for(int i = 0; i < space.getInvasores().size();i++){
            Invasor invasor = space.getInvasores()
        }
        return true;
    }
}