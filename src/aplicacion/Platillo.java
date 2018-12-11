package aplicacion;
import java.io.Serializable;
import java.util.*;
public class Platillo extends Elemento implements Serializable{
    private int resistencia;
    private ArrayList<String> disparos = new ArrayList<String>();
    private int[][] forma = {{0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},{0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0}};
    private int puntaje;
    private boolean flag;
    public Platillo(Space space, int posicionX, int posicionY){
        super(space,posicionX,posicionY);
        setPuntaje();
        addPlatillo(this);
        setResistencia();
    }
    public void setResistencia(){
        this.resistencia = 1;
    }

    public boolean disminuirResistencia(){
        this.resistencia -= 1;
        return muere();
    }

    private boolean muere(){
        flag = false;
        if (this.resistencia == 0){
            space.getPlatillo().remove(this);
            flag=true;
        }
        return flag;
    }

    public int getResistencia(){
        return resistencia;
    }
    public void setPuntaje(){
        this.puntaje=200;
    }

    public int[][] getBinarios(){
        return forma;
    }
    public int mover(int X, int Y){
        this.posicionX += 2*X;
		if(this.posicionX == 750 || this.posicionX == 0){return 1;}
		else{return 0;}
    }
    public int disparo(){
        return 2;
    }
    public  ArrayList<String> getDisparos(){
        int aleatorio=(int) (Math.random()*5) + 1;
		if (aleatorio==2){
			disparos.add("aplicacion.DisparoAniquilador");
		}
        return disparos;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public void setPuntajeHUD(int puntaje){}

	public void addPlatillo(Platillo platillo){
        space.addPlatillo(platillo);
    }
    public  void mejoraNave(){}
    
}