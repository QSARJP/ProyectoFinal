package aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;

public class Space implements Serializable {
    private TreeMap<String, Invasor> invasores;
    private TreeMap<String, Barrera> barreras;
    private ArrayList<Nave> naves;
    private ArrayList<Disparo> disparos;

    public Space(){
        invasores = new TreeMap<String, Invasor>();
        barreras = new TreeMap<String, Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparos>();
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

    public void addDisparo(Disparo disparo){
        diaparos.add(disparo);
    }
    public void salvar(File archivo) throws spaceExcepcion {
        try {
            if (archivo != null){
                System.out.println(archivo+".dat");
                ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(archivo+".dat"));
                Space object = this;
                save.writeObject(object);
                save.close();
                JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }             

        }catch(IOException ex)
		   {
			 JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Advertencia",JOptionPane.WARNING_MESSAGE);
		   }
		
		
	}
    public AutomataCelular abra(File file) throws spaceExcepcion {
        AutomataCelular au = null ;
        try{
            				
            FileInputStream archivos=new FileInputStream(file);
            ObjectInputStream lee=new ObjectInputStream(archivos);
            au = (AutomataCelular)lee.readObject();
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
        return au;
		
		//throw new automataExcepcion(automataExcepcion.CONSTRUCCION_ABRA);
	}
	public void exporte(File archivo) throws spaceExcepcion{
        try {
            if (archivo != null){
                FileWriter  save=new FileWriter(archivo+".txt");
                BufferedWriter save2 = new BufferedWriter(save);
                
                for (int f=0;f<LONGITUD;f++){
                    for (int c=0;c<LONGITUD;c++){
                        if (getElemento(f, c)!=null){
                            save2.write(getElemento(f, c).getClass().getName()+" "+Integer.toString(f)+" "+Integer.toString(c));
                            save2.newLine();
                        }
                    }
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
        String [][] texto= new String [20][3];
         
        try{
            if(abre!=null){ 				
                FileReader archivos=new FileReader(abre);
                BufferedReader lee=new BufferedReader(archivos);
                int i = 0;
                reiniciarImport();
                while((aux=lee.readLine())!=null){
                    texto[i]=aux.trim().split(" ");
                    setElemento(Integer.valueOf(texto[i][1]),Integer.valueOf(texto[i][2]), (Elemento)(Class.forName(texto[i][0]).getConstructors()[0].newInstance(this,Integer.valueOf(texto[i][1]),Integer.valueOf(texto[i][2]))));
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
//98
}