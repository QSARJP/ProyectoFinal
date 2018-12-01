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
            if (moverTodosInvasores(1*n,0) >= 1){
                moverTodosInvasores(0,5);
                n = n*-1;
            }
            esperar();
            spaceGUI.refresque();
        }
    }

    public int moverTodosInvasores(int x, int y){
        int cont = 0;
        for (int i = 0;i< space.getInvasores().size();i++){
            Invasor invasor = space.getInvasores().get(i);
            cont += space.mover(invasor, x, y);
        }
        return cont;
    }

    private void esperar(){
        try{
            Thread.sleep(20);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}