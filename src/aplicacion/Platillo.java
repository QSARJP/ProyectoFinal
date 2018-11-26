package aplicacion;

public class Platillo extends Invasor{
    private int resistencia;
    private int[][] forma = {{0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},{0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0}};

    public Platillo(Space space, int posicionX, int posicionY){
        super(space,posicionX,posicionY);
        addInvasor(this);
    }

    public void setResistencia(){}

    public int getResistencia(){
        return resistencia;
    }

    public int[][] getBinarios(){
        return forma;
    }
}