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
        boolean b= true;
        while(true){
            for (int i = 0;i< space.getInvasores().size();i++){
                Invasor invasor = space.getInvasores().get(i);
                space.mover(invasor, 1*n, 0);
                //System.out.println(invasor.getClass().getName()+" "+invasor.getPosicionInt()[0]+" "+invasor.getPosicionInt()[1]);
                if(invasor.getPosicionInt()[0]+50 == 750 || invasor.getPosicionInt()[0] == 0){
                    if (b){
                        n = n*-1;
                        b = false;
                    }

                }  
            }
            if (!b){
                for (int j = 0;j< space.getInvasores().size();j++){
                    Invasor invasor2 = space.getInvasores().get(j);
                    space.mover(invasor2, 0, 5);
                }
                b=true;
            }
            esperar();
            spaceGUI.refresque();
        }
    }

    private void esperar(){
        try{
            Thread.sleep(5);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}