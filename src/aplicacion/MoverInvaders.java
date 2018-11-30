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
            for (int i = 0;i< space.getInvasores().size();i++){
                Invasor invasor = space.getInvasores().get(i);
                space.mover(invasor, 1*n, 0);
                if(invasor.getPosicionInt()[0] == 750 || invasor.getPosicionInt()[0] == 0){
                    n = n*-1;
                }
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