package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.io.Serializable;
public class Ofensivo extends Nave implements Serializable{
    
    private Color color;
    private int  vidas;
    private HUD hud;

    public Ofensivo(Space space, int posicionX, int posicionY){
        super(space, posicionX, posicionY);
        this.color = Color.BLUE;
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
            space.setMaquina();
            
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
    public int mover(int X, int Y){
        this.posicionX += X;
        this.posicionY += Y;
        if(this.posicionX == 750 || this.posicionX == 0){return 1;}
        else{return 0;}
    }
    public int aleatoria(){
        int aleatorio=(int) (Math.random()*100) + 1;
        return aleatorio;
    }


 
}