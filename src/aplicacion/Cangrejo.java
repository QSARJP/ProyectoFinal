package aplicacion;
import java.io.Serializable;

public class Cangrejo extends Invasor implements Serializable{

    private int resistencia;
    private int puntaje;
    private boolean flag;
    private int[][] forma = {{0,0,1,0,0,0,0,0,1,0,0},{0,0,0,1,0,0,0,1,0,0,0},{0,0,1,1,1,1,1,1,1,0,0},{0,1,1,0,1,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,1},{1,0,1,1,1,1,1,1,1,0,1},{1,0,1,0,0,0,0,0,1,0,1},{0,0,0,1,1,0,1,1,0,0,0}};

    public Cangrejo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        setResistencia();
        addInvasor(this);
        setPuntaje();
    }
    
    public boolean disminuirResistencia(){
        this.resistencia -= 1;
        return muere();
    }

    private boolean muere(){
        flag = false;
        if (this.resistencia == 0){
            space.getInvasores().remove(this);
            flag=true;
        }
        return flag;
    }
    public void setResistencia(){
        this.resistencia = 2;
    }
    public int getPuntaje(){
        return puntaje;
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
                boolean a = x >= this.posicionX-3 && x <= this.posicionX+33+3 || x+33 >= this.posicionX-3 && x+33 <= this.posicionX+33+3;
                boolean b = y == this.posicionY+30;
                boolean c = (y > this.posicionY-3 && y < this.posicionY+24+3 || y+24+3 > this.posicionY-3 && y+24+3 < this.posicionY+3+24) && x+40 == this.posicionX;
                boolean d = (y > this.posicionY-3 && y < this.posicionY+24+3 || y+24+3 > this.posicionY-3 && y+24+3 < this.posicionY+3+24) && x-40 == this.posicionX;
               
                if ((a && b) || c || d && invasor != this){
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