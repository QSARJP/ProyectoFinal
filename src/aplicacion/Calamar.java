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

    public void disminuirResistencia(){
        this.resistencia -= 1;
        muere();
    }

    private void muere(){
        if (this.resistencia == 0){
            space.getInvasores().remove(this);
        }
    }

    public int mover(int X, int Y){
        this.posicionX += X;
        this.posicionY += Y;
        if(this.posicionX == 750 || this.posicionX == 0){return 1;}
        else{return 0;}
    }
}