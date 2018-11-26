package aplicacion;

public abstract class Invasor extends Elemento{

    public Invasor(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
    }

    public abstract void setResistencia();
    public abstract int[][] getBinarios();

    public void addInvasor(Invasor invasor){
        space.addInvasor(invasor);
    }

    public abstract int getResistencia();

}