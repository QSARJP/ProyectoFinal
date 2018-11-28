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
        while (true){
            for (int i = 0; i < space.getInvasores().size(); i++){
                Invasor invasor = space.getInvasores().get(i);
                if (invasor.getPosicionInt()[0] >= 750 || invasor.getPosicionInt()[0] <= 50){
                    n = n*-1;
                }
                space.mover(invasor, 3, 0);
            }
            esperar();
        }
    }

    private void esperar(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}