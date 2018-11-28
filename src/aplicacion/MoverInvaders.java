package aplicacion;

import presentacion.SpaceGUI;

public class MoverInvaders extends Thread{

    private Space space;
    private SpaceGUI spaceGUI;

    public MoverInvaders(SpaceGUI spaceGUI, Space space){
        this.space = space;
        this.spaceGUI = spaceGUI;
    }

    @Override
    public void run(){
        int n = 1;
        while(true){
            for (String i: space.getInvasores().keySet()){
                Invasor invasor = space.getInvasores().get(i);
                if(invasor.getPosicionInt()[0] >= 750 || invasor.getPosicionInt()[0] <= 50){
                    n = n*-1;
                    space.mover(invasor,0,50);
                }
                space.mover(invasor, 2*n, 0);
            }
            esperar();
            spaceGUI.refresque();
        }
    }

    private void esperar(){
        try{
            Thread.sleep(10);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}