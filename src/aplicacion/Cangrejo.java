package aplicacion;
import java.io.Serializable;

public class Cangrejo extends Invasor implements Serializable{

    private int resistencia;
    private int puntaje;
    private int[][] forma = {{0,0,1,0,0,0,0,0,1,0,0},{0,0,0,1,0,0,0,1,0,0,0},{0,0,1,1,1,1,1,1,1,0,0},{0,1,1,0,1,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,1},{1,0,1,1,1,1,1,1,1,0,1},{1,0,1,0,0,0,0,0,1,0,1},{0,0,0,1,1,0,1,1,0,0,0}};

    public Cangrejo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        setResistencia();
        addInvasor(this);
        setPuntaje();
    }
    
    public void disminuirResistencia(){
        this.resistencia -= 1;
        muere();
    }

    private void muere(){
        if (this.resistencia == 0){
            space.getInvasores().remove(this);
            space.actualizarPuntaje(puntaje);
        }
    }
    public void setResistencia(){
        this.resistencia = 2;
    }
    public void setPuntaje(){
        this.puntaje=30;
    }

    public int[][] getBinarios(){
        return forma;
    }

    public int getResistencia(){
        return resistencia;
    }
    public int mover(int X, int Y){
        if (sePuede()){
            this.posicionY += 1;
            return 0;
        }
        else{
            this.posicionX += X;
            this.posicionY += Y;
            if(this.posicionX == 750 || this.posicionX == 0){return 1;}
            else{return 0;}
        }
    }

    private boolean sePuede(){
        boolean ok = true;
        if (this.posicionY == maxY()){
            ok = false;
        }
        else{
            for(int i = 0; i < space.getInvasores().size();i++){
                Invasor invasor = space.getInvasores().get(i);
                int x = invasor.getPosicionInt()[0];
                int y = invasor.getPosicionInt()[1];
                boolean a = x >= this.posicionX && x <= this.posicionX+33 || x+33 >= this.posicionX && x+33 <= this.posicionX+33;
                boolean b = y == this.posicionY+30;
                if (a && b && invasor != this){
                    ok = false;
                    break;
                }
            }
        }
        return ok;
    }

    private int maxY(){
        int max = 0;
        for(int i = 0; i < space.getInvasores().size(); i++){
            Invasor invasor = space.getInvasores().get(i);
            if (invasor.getPosicionInt()[1] > max){
                max = invasor.getPosicionInt()[1];
            }
        }
        return max;
    }
}