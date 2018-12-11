package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.io.Serializable;
public class NaveJugador extends Nave implements Serializable{
    
    private Color color;
    private int  vidas;
    private HUD hud;

    public NaveJugador(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.green;
        space.addNave(this);
        setVida();
    }

    public Color getColor(){
        return color;
    }
    public void setVida(){
        this.vidas = 3;
        //
    }

    public void changeColor(Color newColor){
        this.color=newColor;
    }
    public  void disminuirResistencia(boolean bo){
        this.vidas-=1;
        muere(bo);
    }
    private void muere(boolean bo){
        hud.setVidas(vidas);
		if (bo){
			this.vidas=0;
		}
        if (this.vidas == 0){
            space.getNaves().remove(this);
            
        }
    }

    public void stratHUD(HUD newHud){
        this.hud = newHud;
        hud.setVidas(vidas);
    }
    public  void setPuntajeHUD(int puntaje){
        hud.setPuntaje(puntaje);
    }
    public  HUD getHUD(){
        return hud;
    }
    public  void mejoraNave(){
        this.vidas += 1;
        hud.setVidas(vidas);
        for (int i = 0; i < 3 ;i++){
            disparos.add("aplicacion.DisparoEspecial");
        }
    
    }


 
}