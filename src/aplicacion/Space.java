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
    private TreeMap<String, Invasor> invasores;
    private TreeMap<String, Barrera> barreras;
    private ArrayList<Nave> naves;
    private ArrayList<Disparo> disparos;

    public Space(){
        invasores = new TreeMap<String, Invasor>();
        barreras = new TreeMap<String, Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparo>();
        leerElemento();
    }

    public void addInvasor(Invasor invasor){
        invasores.put(invasor.getPosicion(), invasor);
    }

    public void addBarrera(Barrera barrera){
        barreras.put(barrera.getPosicion(), barrera);
    }

    public void addNave(Nave nave){
        naves.add(nave);
    }

    private void leerElemento(){
        try{
            addElemento("aplicacion.Platillo", 330, 10);
            addElemento("aplicacion.Calamar", 210, 50);
            addElemento("aplicacion.Calamar", 250, 50);
            addElemento("aplicacion.Calamar", 290, 50);
            addElemento("aplicacion.Cangrejo", 330, 50);
            addElemento("aplicacion.Cangrejo", 370, 50);
            addElemento("aplicacion.Cangrejo", 410, 50);
            addElemento("aplicacion.Pulpo", 450, 50);
            addElemento("aplicacion.Pulpo", 490, 50);
            addElemento("aplicacion.Pulpo", 530, 50);
            addElemento("aplicacion.BarreraVerde",300,400);
            addElemento("aplicacion.BarreraRoja",200,400);
            addElemento("aplicacion.BarreraRoja",400,400);
            addElemento("aplicacion.BarreraVerde",500,400);
            addElemento("aplicacion.NaveJugador",400, 480);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void disparo(Nave nave){
        ArrayList<Disparo> disp = nave.getDisparos();
        if (disp.size() != 0){
            int[] posicion = nave.getPosicionInt();
            Disparo disparo = disp.remove(0);
            disparo.setPosicionX(posicion[0]+21);
            disparo.setPosicionY(posicion[1]);
            disparos.add(disparo);
        }






    }

    private void addElemento(String objeto, int posicionX, int posicionY) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        Elemento elemento = (Elemento)Class.forName(objeto).getConstructors()[0].newInstance(this, posicionX, posicionY);
    }

    public void mover(Elemento elemento, int posicionX, int posicionY){
        elemento.mover(posicionX, posicionY);
    }

    public TreeMap<String, Invasor> getInvasores(){
        return invasores;
    }

    public TreeMap<String, Barrera> getBarreras(){
        return barreras;
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
                System.out.println(object.preuba());
                save.writeObject(object);
                save.close();
                JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }             

        }catch(IOException ex)
		   {
			 JOptionPane.showMessageDialog(null,"Por que no da ","Advertencia",JOptionPane.WARNING_MESSAGE);
		   }
		
		
	}
    public Space abra(File file) throws spaceExcepcion {
        Space space = null ;
        try{
			
            FileInputStream archivos=new FileInputStream(file);
            ObjectInputStream lee=new ObjectInputStream(archivos);
            space = (Space)lee.readObject();
            lee.close();
            
        }catch(IOException ex){
          JOptionPane.showMessageDialog(null,ex+"" +
                  "\nNo se ha encontrado el archivo",
                  "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }catch(ClassNotFoundException ex){
          JOptionPane.showMessageDialog(null,ex+"" +
                  "\nNo se ha encontrado el archivo",
                  "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
        return space;
		
		//throw new automataExcepcion(automataExcepcion.CONSTRUCCION_ABRA);
	}
	public void exporte(File archivo) throws spaceExcepcion{
        try {
            if (archivo != null){
                FileWriter  save=new FileWriter(archivo+".txt");
                BufferedWriter save2 = new BufferedWriter(save);

                for (String i : invasores.keySet()){
                    save2.write(invasores.get(i).getClass().getName()+" "+Integer.toString(invasores.get(i).getPosicionInt()[0])+" "+Integer.toString(invasores.get(i).getPosicionInt()[1]));
                    save2.newLine();
                }
                for (int i = 0;i<naves.size() ; i++){
                    save2.write(naves.get(i).getClass().getName()+" "+Integer.toString(naves.get(i).getPosicionInt()[0])+" "+Integer.toString(naves.get(i).getPosicionInt()[1]));
                    save2.newLine();
                }
                for (String i : barreras.keySet()){
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
                reiniciarImport();
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
    
    private void reiniciarImport(){
        invasores = new TreeMap<String, Invasor>();
        barreras = new TreeMap<String, Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparo>();
    }
    public int preuba(){
        return 1;
    }

}