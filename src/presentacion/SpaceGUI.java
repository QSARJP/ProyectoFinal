

package presentacion;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;


import java.lang.reflect.InvocationTargetException;


import aplicacion.*;
import excepcion.*;

public class SpaceGUI extends JFrame {
    public Space space2;
    //archivo
	private JFileChooser archivo;

    //aributos menu
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem open, save, exit,importe,exporte;
    private JFileChooser fileChooser;
    
    //Atributos tablero
    private JPanel infoHUD;
    private JLabel puntaje;
    private JLabel vidas;
    private Pintar invaders;

    //Atributos ventana inicial
    public JFrame juego;
    private JPanel infoMenu;
    //private JLabel spaceInvaders;
    private JButton unJugador;
    private JButton dosJugadores;
    private JButton unovsma;
    private JButton mavsma;
    //preuba
    private Set<Integer> pressed = new HashSet<Integer>();
    private MoverInvaders m;
    
    /**
     * Constructor de la clase SpaceGUI
     * @param space clase Space donde esta la información del juego
     */
    public SpaceGUI(Space space){
        this.space2 = space;
        this.setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepareElementosVentanaInicial();
        prepareAccionesVentanaInicial();
        

    }
    /**
     * Prepara los elementos del menu inicial
     */
    private void prepareElementosVentanaInicial(){
        infoMenu = new JPanel();
        infoMenu.setBorder(new CompoundBorder(new EmptyBorder(30,30,30,30),new TitledBorder("Opciones")));
        infoMenu.setLayout(new GridLayout(4, 1, 5, 5));
        unJugador = new JButton("1 Jugador");
        dosJugadores=new JButton("2 Jugadores");
        unovsma=new JButton("1 vs Maquina");
        mavsma = new JButton("Maquina vs Maquina");
        infoMenu.add(unJugador);
        infoMenu.add(dosJugadores);
        infoMenu.add(unovsma);
        infoMenu.add(mavsma);
        getContentPane().setLayout(new GridLayout(4,1,5,5));
        getContentPane().add(unJugador);
        getContentPane().add(dosJugadores);  
        getContentPane().add(unovsma);
        getContentPane().add(mavsma);  

    }

    /**
     * Prepara las acciones correspondientes a la ventana inicial
     */
    private void prepareAccionesVentanaInicial(){

        WindowListener w = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                salga();
            }
        };
        this.addWindowListener(w);
        ActionListener accionPrincipal = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == unJugador){
                    unJugadorP();
                }
                else if(e.getSource() == dosJugadores){
                    dosJugadoresP();
                }
                else if(e.getSource() == unovsma){
                    unovsmaP();
                }else if(e.getSource() == mavsma){
                    mavsmaP();
                }
            }
        };
        unJugador.addActionListener(accionPrincipal);
        dosJugadores.addActionListener(accionPrincipal);
        unovsma.addActionListener(accionPrincipal);
        mavsma.addActionListener(accionPrincipal);

    }
    /**
     * Prepara los elementos para un jugador
     */
    private void unJugadorP(){
        juego = new JFrame();
        juego.setSize(800,600);
        juego.setVisible(true);
        space2.selectNave(1);
        Nave nave = space2.getNaves().get(0);
        prepareElementos();
        prepareAcciones(nave,true);
        space2.setFlag();
        m = new MoverInvaders(this,space2);
        m.start();


    }
    /**
     * prepara los elementos para 2 jugadores
     */
    private void dosJugadoresP(){
        juego = new JFrame();
        juego.setSize(800,600);
        juego.setVisible(true);
        space2.selectNave(2);
        Nave nave = space2.getNaves().get(0);
        prepareElementos();
        prepareAcciones(nave,true);
        space2.setFlag();
        m = new MoverInvaders(this,space2);
        m.start();
        MoveNave2 m2 = new MoveNave2(this, space2);
        m2.start();
    }
    /**
     * Crea el ambiente 1 vs maquina
     */
    private void unovsmaP(){
        space2.selectNave(1);
        String maquina = JOptionPane.showInputDialog(null,"Que tipo de maquina desea?");
        space2.selectMa(1,maquina,1);
        juego = new JFrame();
        juego.setSize(800,600);
        juego.setVisible(true);
        Nave nave = space2.getNaves().get(0);
        prepareElementos();
        prepareAcciones(nave,true);
        space2.setFlag();
        m = new MoverInvaders(this,space2);
        m.start();
        
    }
    /**
     * Crea el ambiente para el maquina vs maquina
     */
    private void mavsmaP(){
        for (int i = 0; i<2;i++){
            String maquina = JOptionPane.showInputDialog(null,"Que tipo de maquina desea?");
            space2.selectMa(2,maquina,i);
        }
        juego = new JFrame();
        juego.setSize(800,600);
        juego.setVisible(true);
        Nave nave = space2.getNaves().get(0);
        prepareElementos();
        prepareAcciones(nave,false);
        space2.setFlag();
        m = new MoverInvaders(this,space2);
        m.start();
    }
    /**
     * prepara los elementos del juego
     */
    private void prepareElementos(){
        prepareElementosMenu();
        prepareElementosJuego();
    }
    /**
     * prepara los elementos del menu de la ventana
     */
    private void prepareElementosMenu(){

        barra = new JMenuBar();
        menu = new JMenu("Menu");
        open = new JMenuItem("Abrir");
        save = new JMenuItem("Guardar");
        importe = new JMenuItem("Importar");
        exporte = new JMenuItem("Exportar");
        exit = new JMenuItem("Salir");

        juego.setJMenuBar(barra);

        barra.add(menu);
        menu.add(open);
        menu.add(save);
        menu.add(importe);
        menu.add(exporte);
        menu.add(exit);
        
    }
    /**
     * Prepara los elementos correspondientes al juego
     */
    private void prepareElementosJuego(){

        invaders = new Pintar(space2);
        infoHUD = new JPanel();
        puntaje = new JLabel("Puntaje:");
        vidas = new JLabel("Vidas:");
        infoHUD.setBorder(new EmptyBorder(5,50,5,50));
        infoHUD.setLayout(new BorderLayout());
        infoHUD.add(puntaje,BorderLayout.EAST);
        infoHUD.add(vidas,BorderLayout.WEST);
        juego.setLayout(new BorderLayout());
        juego.add(infoHUD,BorderLayout.NORTH);
        juego.add(invaders,BorderLayout.CENTER);   
    }
    /**
     * prepara las acciones correspondientes a la nave
     * @param nave nave, que le corresponde la accion
     * @param bo Si no hay ususario, no deje usar las teclas
     */
    private void prepareAcciones(Nave nave,boolean bo){

        WindowListener w = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                salga2();
            }
        };
        juego.addWindowListener(w);

        ActionListener accionMenu = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == exit){
                    salga2();
                }
                else if(e.getSource() == open){
                    abra();
                }
                else if(e.getSource() == save){
                    salvar();
                }else if(e.getSource() == importe){
                    importe();
                }
                else if(e.getSource() == exporte){
                    exporte();
                }
            }
        };
        exit.addActionListener(accionMenu);
        open.addActionListener(accionMenu);
        save.addActionListener(accionMenu);
        importe.addActionListener(accionMenu);
        exporte.addActionListener(accionMenu);
        if (bo){
            KeyListener accionNave = new KeyListener(){
        
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }
            
                @Override
                public synchronized void keyReleased(KeyEvent e) {
                    //pressed.remove(e.getKeyCode());
                    if (e.getKeyCode() == KeyEvent.VK_UP){
                        space2.disparo(nave,false);
                    }     
                    refresque();
                }
            
                @Override
                public synchronized void keyPressed(KeyEvent e) {
                    
                    if (e.getKeyCode() == KeyEvent.VK_LEFT){
                        int dx = -10;
                        space2.mover(nave, dx, 0);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                        int dx = 10;
                        space2.mover(nave, dx, 0);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_P){
                        space2.pausa();
                    }
                    refresque();
                }
                        
            };
            juego.addKeyListener(accionNave);
        }
        
    }
    /**
     * accion para salir de la aplicacion
     */
    private void salga2(){
        int i = JOptionPane.showConfirmDialog(null, "Desea salir","Salir",JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.NO_OPTION){
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else{
            juego.dispose();
            space2.cargar();
            space2.changeFlag();

            
        }
    }
    /**
     * Accion que permite salir de la aplicacion
     */
    private void salga(){
        int i = JOptionPane.showConfirmDialog(null, "Desea salir","Salir",JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.NO_OPTION){
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else{
            System.exit(0);
        }
    }
    /**
     * Se encarga de realizar la accion para la opcion abrir del menu
     */
    private void abra(){
        try {
            juego.dispose();
            space2.changeFlag();
			archivo = new JFileChooser();
			archivo.showOpenDialog(this);
            File abre=archivo.getSelectedFile();
            space2.abra(abre); 
            refresque();

		}catch(spaceExcepcion e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}
    }
    /**
     * Se encarga de realizar la accion para la opcion salvar del menu
     */
    private void salvar(){
        try {
			archivo = new JFileChooser();
        	archivo.showSaveDialog(this);
        	File guardar = archivo.getSelectedFile();
			space2.salvar(guardar);
		}catch(spaceExcepcion e){

			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}
    }
    /**
     * Se encarga de realizar la accion para opcion de importar del menu de opciones
     */
    private void importe(){
        try {
            juego.dispose();
            space2.changeFlag();
			archivo = new JFileChooser();
			archivo.showOpenDialog(this);
			File abre=archivo.getSelectedFile();
			space2.importe(abre);
			refresque();
		}catch(spaceExcepcion e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}catch(InstantiationException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}
		catch(IllegalAccessException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}catch(InvocationTargetException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}
		
    }
    /**
     * Se encarga de realizar la accion para la opcion exportar del menu de opciones
     */
    private void exporte(){
        try {
			archivo = new JFileChooser();
        	archivo.showSaveDialog(this);
        	File guardar = archivo.getSelectedFile();
			space2.exporte(guardar);
		}catch(spaceExcepcion e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}
    }

    public void refresque(){
        invaders.repaint();
    }






    /**
     * Funcion principal de la aplicacion
     */
    public static void main(String[] args) {
        Space space = new Space();
        SpaceGUI s = new SpaceGUI(space);
        s.setVisible(true);
        
    }  
}

class Pintar extends JPanel {
    private Space space3;
    public Pintar(Space space){
        this.space3 = space;
        setBackground(Color.black);
    }
    /**
     * Constructor de la clase pintar
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pintarInvasores(g);
        pintarBarreras(g);
        pintarNaves(g);
        pintarDisparos(g);
        pintarHUD(g);
        pintarPlatillo(g);

    }
    /**
     * Se encarga de pintar los invasores en el ambiente de la aplicacion
     * @param g parametro grafics
     */
    public void pintarInvasores(Graphics g){
        ArrayList<Invasor> invasores = space3.getInvasores();
        g.setColor(Color.white);
        for (int i = 0 ;i< invasores.size();i++){
            int[] posicion = invasores.get(i).getPosicionInt();
            int[][] matriz = invasores.get(i).getBinarios();
            for (int j = 0; j < matriz.length; j++){
                for (int k = 0 ; k < matriz[j].length; k++){
                    if(matriz[j][k] == 1){
                        g.fillRect(posicion[0]+k*3,posicion[1]+j*3,3,3);
                    }
                }
            }
        }
    }
    /**
     * pinta las barreras en el ambiente de trabajo
     * @param g
     */
    public void pintarBarreras(Graphics g){
        ArrayList<Barrera> barreras = space3.getBarreras();
        for (int i = 0 ; i<barreras.size();i++){
            g.setColor(barreras.get(i).getColor());
            ArrayList<Material> materiales = barreras.get(i).getMateriales();
            for (int j = 0 ; j<materiales.size();j++){
                int[] posicion = materiales.get(j).getPosicionInt();
                g.fillRect(posicion[0], posicion[1], 2, 2);
            }
        }
    }
    /**
     * pinta los platillos en el ambiente de la aplicacion
     * @param g
     */
	public void pintarPlatillo(Graphics g){
        ArrayList<Platillo> platillo = space3.getPlatillo();
        g.setColor(Color.ORANGE);
        for (int i = 0 ;i< platillo.size();i++){
            int[] posicion = platillo.get(i).getPosicionInt();
            int[][] matriz = platillo.get(i).getBinarios();
            
            for (int j = 0; j < matriz.length; j++){
                for (int k = 0 ; k < matriz[j].length; k++){
                    if(matriz[j][k] == 1){
                        g.fillRect(posicion[0]+k*3,posicion[1]+j*3,3,3);
                    }
                }
            }
        }
    }
    /**
     * pinta las naves en el ambiente de la aplicacion
     * @param g
     */
    public void pintarNaves(Graphics g){
        ArrayList<Nave> naves = space3.getNaves();
        for (int i = 0; i < naves.size(); i++){
            g.setColor(naves.get(i).getColor());
            int[] posicion = naves.get(i).getPosicionInt();
            int[][] matriz = naves.get(i).getBinarios();
            for (int j = 0; j < matriz.length; j++){
                for (int k = 0; k < matriz[j].length; k++){
                    if (matriz[j][k] == 1){
                        g.fillRect(posicion[0]+3*k, posicion[1]+3*j, 3, 3);
                    }
                }
            }
        }
    }
    /**
     * pinta los disparos en el ambiente de la aplicacion
     */
    public void pintarDisparos(Graphics g){
        ArrayList<Disparo> disparos = space3.getDisparos();
        for (int i = 0; i < disparos.size(); i++){
            Disparo d = disparos.get(i);
            int [] posicion = d.getPosicionInt();
            g.setColor(d.getColor());
            for (int j = 0; j < 3; j++){
                g.fillRect(posicion[0], posicion[1]+j*3, 3, 3);
            }
        }
    }
    /**
     * pinta el HUD en el ambiente de la aplicacion
     * @param g
     */
    public void pintarHUD(Graphics g){
        ArrayList<Nave> naves = space3.getNaves();
        for (int i = 0; i < naves.size(); i++){
            g.drawString("Nave "+i+ ": "+Integer.toString(space3.getVidas(naves.get(i))), 10,10+i*10 );
            g.drawString("Nave "+i+ ": "+Integer.toString(space3.getPuntaje(naves.get(i))), 600,10+i*10 );
        }   
    }
}