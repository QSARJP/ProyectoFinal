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
    private boolean maquina;
    private int numMaquina;
    public int opcion;

    /**
     * Constructor de la clase space
     */
    public Space(){
        invasores = new ArrayList<Invasor>();
        barreras = new ArrayList<Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparo>();
		platillos = new ArrayList<Platillo>();
        leerElemento();
        pausa=false;
        maquina=false;
        numMaquina=0;
        opcion=0;
    }

    /**
     * Añade un invasor a la coleccion de invasores dentro del juego
     * @param invasor invasor que se va a añadir a la coleccion de invasores
     */
    public void addInvasor(Invasor invasor){
        invasores.add(invasor);
    }

    /**
     * Añade una barrera a la coleccion de barreras dentro del juego
     * @param barrera barrera que se va a añadir a la coleccion de barreras
     */
    public void addBarrera(Barrera barrera){
        barreras.add(barrera);
    }
    /**
     * Añade una nave a la coleccion de nave dentro del juego
     * @param nave nave que se va a añadir a la coleccion de naves
     */
    public void addNave(Nave nave){
        naves.add(nave);
    }
    /**
     * Añade un platillo a la coleccion de platillos dentro del juego
     * @param platillo platillo que se va a añadir a la coleccion de platillos
     */
	public void addPlatillo(Platillo platillo){
        platillos.add(platillo);
    }

    /**
     * Se encarga de agregar los elementos que se va a usar dentro del juego, este puede estar definido por un archivo de texto o por los niveles que se diseñaron para el juego
     */
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
    /**
     * Metodo que se encarga de crear un disparo, cuando la tecla especificada es oprimida
     * @param elemento elemento que disparo la bala
     * @param bo indica que tipo de bala disparar
     */
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
    /**
     * limpia las collecciones de barreras, invasores, naves y platillos
     */
    public void niveles(){

        invasores = new ArrayList<Invasor>();
        barreras = new ArrayList<Barrera>();
        disparos = new ArrayList<Disparo>();
        platillos = new ArrayList<Platillo>();
        leerElemento();
        flag = true;
    }
    /**
     * Crea una instancia de la clase a la cual pertenece el string, para luego añadirla en las colecciones respectivas
     * @param objeto nombre de la clase, de la cual se va a hacer la respectiva instancia
     * @param posicionX posicion en x donde se va a ubicar el objeto
     * @param posicionY posicion en y donde se va a ubicar el objeto
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void addElemento(String objeto, int posicionX, int posicionY) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        Elemento elemento = (Elemento)Class.forName(objeto).getConstructors()[0].newInstance(this, posicionX, posicionY);
    }

    /**
     * mueve el elemento una cantidad determinada de pixeles en la coordenada x y/o en la coordenada y
     * @param elemento elemento que se va a mover
     * @param posicionX cantidad de pixeles en x, que se mueve
     * @param posicionY cantidad de pixeles en y, que se mueve
     * @return retorna 1 o 0, depenediendo de so el elemento llego al borde permitido
     */
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

    /**
     * Guarda el proceso que se lleva en un archivo
     * @param archivo archivo, en el cual se va a guardar el proceso
     * @throws spaceExcepcion
     */
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
    
    /**
     * Abre un archivo con elementos en una determinada posicion
     * @param file archivo de donde se va a abrir
     * @throws spaceExcepcion
     */
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
    /**
     * 
     * @param abre archivo que contiene los objetos a importar
     * @throws spaceExcepcion
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
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
    /**
     * Reinicia los contenedores
     */
    private void reiniciar(){
        invasores = new ArrayList<Invasor>();
        barreras = new ArrayList<Barrera>();
        naves = new ArrayList<Nave>();
        disparos = new ArrayList<Disparo>();
        platillos = new ArrayList<Platillo>();
        maquina=false;
        numMaquina=0;
        opcion=0;
    }
    public void cargar(){
        reiniciar();
        leerElemento();
    }

    /**
     * permite seleccionar la cantidad de naves, dependiendo del modo de juego
     * @param numero numero de naves que se va a adicionar
     */
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
    /**
     * 
     * @param numero 
     * @param name
     * @param i
     */
    public void selectMa(int numero, String name,int i){
        try{
            maquina=true;
            numMaquina+=1;
            opcion+=1;
            char[] caract = name.toCharArray();
            caract[0] = Character.toUpperCase(caract[0]);
            name = new String(caract);
            System.out .println("aplicacion."+name);
            if (numero == 1){
                addElemento("aplicacion."+name,400*i+100, 480);
                getNaves().get(numero).stratHUD(new HUD());
            }else{
                addElemento("aplicacion."+name,400*i+100, 480);
                getNaves().get(i).stratHUD(new HUD());
            }
            
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    /**
     * Pausa el thread que realiza el movimiento de los elementos
     */
    public void pausa(){
        this.pausa = !pausa;
    }
    public boolean hayMaquina(){
        if (numMaquina == 0){
            maquina=false;
        }
        return maquina;
    }
    public int numerosM(){
        return numMaquina;
    }
    public void setMaquina(){
        numMaquina-=1;
    }


}