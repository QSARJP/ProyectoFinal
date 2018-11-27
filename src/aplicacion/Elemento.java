package aplicacion;


public abstract class Elemento  {
    protected int posicionX;
	protected int posicionY;
    public Space space;

    public Elemento(Space space, int posicionX, int posicionY){

        this.space = space;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public void mover(int posicionX, int posicionY){
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    public String getPosicion(){
        String posicion = Integer.toString(posicionX) +","+Integer.toString(posicionY);
        return posicion;
    }

    public int[] getPosicionInt(){
        int[] posicion = {posicionX,posicionY};
        return posicion;
    }

    public void setPosicionX(int posicionX){
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY){
        this.posicionY = posicionY;
    }
}