package aplicacion;

import java.awt.color.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class DisparoEspecial extends Disparo implements Serializable{

    private Color color;

    public DisparoEspecial(Space space, int posicionX, int posicionY){
        super(space,posicionX,posicionY);
        this.color = Color.RED;
        
    }

    public Color getColor(){
        return color;
    }

    
    public int mover(int newPosicionX, int newPosicionY){
        this.posicionX += newPosicionX;
        this.posicionY += newPosicionY;
        if(this.posicionY == 0){return 1;}
        else if (lePegue(newPosicionY)){
            return 1;
        }
        else{return 0;}
    }

    private boolean lePegue(int dy){
        boolean si = false;
        ArrayList<Invasor> invasores = space.getInvasores();
        ArrayList<Nave> naves = space.getNaves();
        ArrayList<Barrera> barreras = space.getBarreras();
        if (dy < 0){
            for(int i = 0; i < space.getInvasores().size(); i ++){
                Invasor invasor = space.getInvasores().get(i);
                int x = invasor.getPosicionInt()[0];
                int y = invasor.getPosicionInt()[1];
                boolean a = this.posicionX >= x && this.posicionX <= x + 33;
                boolean b = this.posicionY >= y-24 && this.posicionY <= y;
                if (a&&b){
                    si = true;
                    if (invasor.disminuirResistencia()){
                        elemento.setPuntajeHUD(invasor.getPuntaje());
                    }
                }
            }
            
            for (int i = 0; i< space.getBarreras().size();i++){
                Barrera barrera = space.getBarreras().get(i);
                int x = barrera.getPosicionInt()[0];
                int y = barrera.getPosicionInt()[1];
                
                boolean a = this.posicionX >= x && this.posicionX <= x + 40;
                boolean b = this.posicionY >= y && this.posicionY <= y+40;
                if (a&&b){
                    si = true;
                    barrera.disminuirResistencia(this.posicionX,this.posicionY,dy,false);
                }
            }
            for (int i = 0; i< space.getPlatillo().size();i++){
                Platillo pla = space.getPlatillo().get(i);
                int x = pla.getPosicionInt()[0];
                int y = pla.getPosicionInt()[1];
                boolean a = this.posicionX >= x && this.posicionX <= x + 48;
                boolean b = this.posicionY >= y && this.posicionY <= y+21;
                if (a&&b){
                    si = true;
                    if (pla.disminuirResistencia()){
                        elemento.setPuntajeHUD(pla.getPuntaje());
                        elemento.mejoraNave();
                    }
                }
            }
        }
        
        return si;
    }
}