package aplicacion;

public abstract class Invasor {
    protected int resistencia;
    private Color color;
    private int posicionX;
    private int posicionY;
    protected int puntaje;
    protected int dano;
    protected boolean destroid;

    public Invasor(Color color, int posicionX, int posicionY){
        this.color = color;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    public abstract void setResistencia();
    public abstract void setPuntaje();
    public abstract void setDano();

    public void destroid(){
        this.destroid = false;
    }
    public int getDano(){
        return dano;
    }
    public int getResistencia(){
        return resistencia;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public boolean isDestroid(){
        return destroid;
    }
}
