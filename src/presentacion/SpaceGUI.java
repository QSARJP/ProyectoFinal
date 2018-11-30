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
    private JFrame juego;
    private JPanel infoMenu;
    //private JLabel spaceInvaders;
    private JButton unJugador;
    private JButton dosJugadores;
    private JButton unovsma;
    private JButton mavsma;
    //preuba
    private MoverInvaders m;

    public SpaceGUI(Space space){
        this.space2 = space;
        this.setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepareElementosVentanaInicial();
        prepareAccionesVentanaInicial();
        

    }
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

    private void unJugadorP(){
        juego = new JFrame();
        juego.setSize(800,600);
        juego.setVisible(true);
        prepareElementos();
        prepareAcciones();
        m = new MoverInvaders(this,space2);
        m.start();


    }
    private void dosJugadoresP(){
    }
    private void unovsmaP(){
    }
    private void mavsmaP(){
    }
    private void prepareElementos(){
        prepareElementosMenu();
        prepareElementosJuego();
    }

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

    private void prepareAcciones(){

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
        KeyListener accionNave = new KeyListener(){
        
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
        
            @Override
            public void keyReleased(KeyEvent e) {

            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    int dx = -5;
                    Nave nave = space2.getNaves().get(0);
                    space2.mover(nave, dx, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    int dx = 5;
                    Nave nave = space2.getNaves().get(0);
                    space2.mover(nave, dx, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    Nave nave = space2.getNaves().get(0);
                    space2.disparo(nave);
                }
                refresque();
            }
        };
        juego.addKeyListener(accionNave);
    }
    private void salga2(){
        int i = JOptionPane.showConfirmDialog(null, "Desea salir","Salir",JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.NO_OPTION){
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else{
            juego.dispose();
            space2.cargar();
            m.interrupt();
        }
    }
    private void salga(){
        int i = JOptionPane.showConfirmDialog(null, "Desea salir","Salir",JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.NO_OPTION){
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else{
            System.exit(0);
        }
    }

    private void abra(){
        try {
			archivo = new JFileChooser();
			archivo.showOpenDialog(this);
            File abre=archivo.getSelectedFile();
            space2.abra(abre); 
            refresque();

		}catch(spaceExcepcion e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Construccion",JOptionPane.ERROR_MESSAGE);
		}
    }
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
    private void importe(){
        try {
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

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pintarInvasores(g);
        pintarBarreras(g);
        pintarNaves(g);
        pintarDisparos(g);

    }
    
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

    public void pintarBarreras(Graphics g){
        TreeMap<String, Barrera> barreras = space3.getBarreras();
        for (String i: barreras.keySet()){
            g.setColor(barreras.get(i).getColor());
            TreeMap<String, Material> materiales = barreras.get(i).getMateriales();
            for (String j: materiales.keySet()){
                int[] posicion = materiales.get(j).getPosicionInt();
                g.fillRect(posicion[0], posicion[1], 2, 2);
            }
        }
    }

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
}