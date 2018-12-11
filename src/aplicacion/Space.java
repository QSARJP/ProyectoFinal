package aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;
import excepcion.*;
import java.io.Serializable;




public  class Space implements Serializable {
    private ArrayList<Invasor> invasores;
    private ArrayList<Barrera> barreras;
    private ArrayList<Nave> naves;
    private ArrayList<Disparo> disparos;
	private ArrayList<Platillo> platillos;
    public boolean pausa;
    public boolean flag;


    public Space(){
        invasores = new ArrayList<Invasor>();
        barreras = new ArrayList<Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparo>();
		platillos = new ArrayList<Platillo>();
        leerElemento();
        pausa=false;
        
        
    }

    public void addInvasor(Invasor invasor){
        invasores.add(invasor);
    }

    public void addBarrera(Barrera barrera){
        barreras.add(barrera);
    }

    public void addNave(Nave nave){
        naves.add(nave);
    }
	public void addPlatillo(Platillo platillo){
        platillos.add(platillo);
    }

    private void leerElemento(){
        try{
			addElemento("aplicacion.Platillo",300,30);
            int aleatorio2=(int) (Math.random()*8) + 1;
            String[] inv = {"aplicacion.Calamar", "aplicacion.Cangrejo", "aplicacion.Pulpo","aplicacion.Calamar","aplicacion.Rana"};
            for (int i = 0; i< aleatorio2; i++){
                for (int j = 0 ;j<aleatorio2;j++){
                    int aleatorio=(int) (Math.random()*4) + 1;
                    addElemento(inv[aleatorio], 50+i*40, 60+j*30);
                }
            }

            addElemento("aplicacion.BarreraVerde",300,400);
            addElemento("aplicacion.BarreraRoja",200,400);
            addElemento("aplicacion.BarreraRoja",400,400);
            addElemento("aplicacion.BarreraVerde",500,400);
            
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void disparo(Elemento elemento,boolean bo){
        ArrayList<String> disp = elemento.getDisparos();
        int[] posicion = elemento.getPosicionInt();
        if (disp.size() != 0){
			try{
				String disparo = disp.remove(0);
				Disparo d = (Disparo)Class.forName(disparo).getConstructors()[0].newInstance(this, posicion[0]+21, posicion[1]-9);
				d.setElemento(elemento);
				disparos.add(d);
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}
        }else{
            if (!bo){
                Disparo d = new DisparoNormal(this, posicion[0]+21, posicion[1]-9);
                d.setElemento(elemento);
                disparos.add(d);
            }
            
        }




    }

    public void setFlag(){
        this.flag = true;

    }
    public void changeFlag(){
        this.flag = false;
        
    }
    

    public int getPuntaje(Nave nave){
        return nave.getHUD().getPuntaje();
    }
    public int getVidas(Nave nave){
        return nave.getHUD().getVidas();
    }
    public void niveles(){

        invasores = new ArrayList<Invasor>();
        barreras = new ArrayList<Barrera>();
        disparos = new ArrayList<Disparo>();
        platillos = new ArrayList<Platillo>();
        leerElemento();
        flag = true;
    }
    private void addElemento(String objeto, int posicionX, int posicionY) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        Elemento elemento = (Elemento)Class.forName(objeto).getConstructors()[0].newInstance(this, posicionX, posicionY);
    }

    public int mover(Elemento elemento, int posicionX, int posicionY){
        return elemento.mover(posicionX, posicionY);
    }

    public ArrayList<Invasor> getInvasores(){
        return invasores;
    }

    public ArrayList<Barrera> getBarreras(){
        return barreras;
    }
	public ArrayList<Platillo> getPlatillo(){
        return platillos;
    }

    public ArrayList<Nave> getNaves(){
        return naves;
    }

    public ArrayList<Disparo> getDisparos(){
        return disparos;
    }
    public void salvar(File archivo) throws spaceExcepcion {
        try {
            if (archivo != null){
                ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(archivo+".dat"));
                Space object = this;
                save.writeObject(object);
                save.close();
                JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }             

        }catch(IOException ex)
		   {
			 JOptionPane.showMessageDialog(null,"Por que no da ","Advertencia",JOptionPane.WARNING_MESSAGE);
		   }
		
		
	}
    public void abra(File file) throws spaceExcepcion {
        Space space = null ;
        try{
			
            FileInputStream archivos=new FileInputStream(file);
            ObjectInputStream lee=new ObjectInputStream(archivos);
            space = (Space)lee.readObject();
            lee.close();

            reiniciar();
            this.barreras=space.getBarreras();
            this.disparos=space.getDisparos();
            this.invasores=space.getInvasores();
            this.platillos=space.getPlatillo();            
        }catch(IOException ex){
          JOptionPane.showMessageDialog(null,ex+"" +
                  "\nNo se ha encontrado el archivo",
                  "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }catch(ClassNotFoundException ex){
          JOptionPane.showMessageDialog(null,ex+"" +
                  "\nNo se ha encontrado el archivo",
                  "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }

		
		//throw new automataExcepcion(automataExcepcion.CONSTRUCCION_ABRA);
	}
	public void exporte(File archivo) throws spaceExcepcion{
        try {
            if (archivo != null){
                FileWriter  save=new FileWriter(archivo+".txt");
                BufferedWriter save2 = new BufferedWriter(save);

                for (int i=0;i<invasores.size();i++){
                    save2.write(invasores.get(i).getClass().getName()+" "+Integer.toString(invasores.get(i).getPosicionInt()[0])+" "+Integer.toString(invasores.get(i).getPosicionInt()[1]));
                    save2.newLine();
                }
                for (int i = 0;i<platillos.size() ; i++){
                    save2.write(platillos.get(i).getClass().getName()+" "+Integer.toString(platillos.get(i).getPosicionInt()[0])+" "+Integer.toString(platillos.get(i).getPosicionInt()[1]));
                    save2.newLine();
                }
                for (int i = 0;i<barreras.size() ; i++){
                    save2.write(barreras.get(i).getClass().getName()+" "+Integer.toString(barreras.get(i).getPosicionInt()[0])+" "+Integer.toString(barreras.get(i).getPosicionInt()[1]));
                    save2.newLine();
                }
                save2.close();
                JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }             

        }catch(IOException ex)
		   {
			 JOptionPane.showMessageDialog(null,
					 "Su archivo no se ha guardado",
					 "Advertencia",JOptionPane.WARNING_MESSAGE);
		   }

		//throw new automataExcepcion(automataExcepcion.CONSTRUCCION_EXPORTE);
	}
	public void importe(File abre) throws spaceExcepcion,ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        String aux=""; 		
        String [] texto= new String [3];
         
        try{
            if(abre!=null){ 				
                FileReader archivos=new FileReader(abre);
                BufferedReader lee=new BufferedReader(archivos);
                int i = 0;
                reiniciar();
                while((aux=lee.readLine())!=null){
                    texto=aux.trim().split(" ");
                    addElemento(texto[0],Integer.valueOf(texto[1]),Integer.valueOf(texto[2]));
                }
                lee.close();
            } 			
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,ex+"" +
                "\nNo se ha encontrado el archivo",
                "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
        
		//throw new automataExcepcion(automataExcepcion.CONSTRUCCION_IMPORTE);
    }
    
    private void reiniciar(){
        invasores = new ArrayList<Invasor>();
        barreras = new ArrayList<Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparo>();
        platillos = new ArrayList<Platillo>();
    }
    public void cargar(){
        reiniciar();
        leerElemento();
    }


    public void selectNave(int numero){
        try{
        
            for (int i=0;i<numero;i++){
                addElemento("aplicacion.NaveJugador",400*i+100, 480);
                getNaves().get(i).stratHUD(new HUD());
            }
            if (getNaves().size()>1){
                getNaves().get(1).changeColor(Color.red);
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }
    public void pausa(){
        this.pausa = !pausa;
    }

}