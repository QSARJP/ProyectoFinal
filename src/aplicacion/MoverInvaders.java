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
        for(int j = 0; j < 50; j++){
            for (String i: space.getInvasores().keySet()){
                //System.out.println(space.getInvasores().get(i).getClass().getName()+" "+space.getInvasores().get(i).getPosicion());
                Invasor invasor = space.getInvasores().get(i);
                space.mover(invasor, 2, 0);
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