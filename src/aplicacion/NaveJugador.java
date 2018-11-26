package aplicacion;

import java.awt.Color;

public class NaveJugador extends Nave{
    
    private Color color;
    private ArrayList<Disparo> disparos;

    public NaveJugador(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.green;
        prepareDisparos();
        space.addNave(this);
        
    }

    public Color getColor(){
        return color;
    }

    public void prepareDisparos(){
        for (int i = 0; i < 60; i++){
            DisparoNormal d = new DisparoNormarl(space, posicionX+21, posicionY);
        }
    }
}