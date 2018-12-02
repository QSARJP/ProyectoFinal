package aplicacion;

import java.awt.color.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class DisparoNormal extends Disparo implements Serializable{

    private Color color;

    public DisparoNormal(Space space, int posicionX, int posicionY){
        super(space,posicionX,posicionY);
        this.color = Color.WHITE;
        
    }

    public Color getColor(){
        return color;
    }

    
    public int mover(int posicionX, int posicionY){
        this.posicionX += posicionX;
        this.posicionY += posicionY;
        if(this.posicionY == 0){return 1;}
        else if (lePegue(posicionY)){
            return 1;
        }
        else{return 0;}
    }

    private boolean lePegue(posicionY){
        boolean si = false;
        ArrayList<Invasor> invasores = space.getInvasores();
        ArrayList<Nave> naves = space.getNaves();
        if (invasores.size()>0 && posicionY < 0){
            for(int i = 0; i < space.getInvasores().size(); i ++){
                Invasor invasor = space.getInvasores().get(i);
                int x = invasor.getPosicionInt()[0];
                int y = invasor.getPosicionInt()[1];
                boolean a = this.posicionX >= x && this.posicionX <= x + 33;
                boolean b = this.posicionY >= y-24 && this.posicionY <= y;
                if (a&&b){
                    si = true;
                    invasor.disminuirResistencia();
                }
            }
        }
        else if(invasores.size()>0 && posicionY > 0){
            
        }
        return si;
    }
}