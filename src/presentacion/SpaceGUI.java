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

import aplicacion.*;
import expecion.*;

public class SpaceGUI extends JFrame {
    public Space space2;

    //aributos menu
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem open, save, saveAs, exit,importe,exporte;
    private JFileChooser fileChooser;
    
    //Atributos tablero
    private JPanel infoHUD;
    private JLabel puntaje;
    private JLabel vidas;
    private Pintar invaders;

    public SpaceGUI(Space space){
        this.space2 = space;
        this.setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prepareElementos();
        prepareAcciones();
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
        saveAs = new JMenuItem("Guardar como");
        importe = new JMenuItem("Importar");
        exporte = new JMenuItem("Exportar");
        exit = new JMenuItem("Salir");

        setJMenuBar(barra);

        barra.add(menu);
        menu.add(open);
        menu.add(save);
        menu.add(saveAs);
        menu.add(exit);
        menu.add(importe);
        menu.add(exporte);
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
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(infoHUD,BorderLayout.NORTH);
        getContentPane().add(invaders,BorderLayout.CENTER);   
    }

    private void prepareAcciones(){

        WindowListener w = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                salga();
            }
        };
        this.addWindowListener(w);

        ActionListener accionMenu = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == exit){
                    salga();
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
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    Nave nave = space2.getNaves().get(0);
                    space2.disparo(nave);
                }
            }
        
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    int dx = -5;
                    Nave nave = space2.getNaves().get(0);
                    space2.mover(nave, nave.getPosicionInt()[0] + dx, nave.getPosicionInt()[1]);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    int dx = 5;
                    Nave nave = space2.getNaves().get(0);
                    space2.mover(nave, nave.getPosicionInt()[0] + dx, nave.getPosicionInt()[1]);
                }
                refresque();
            }
        };
        this.addKeyListener(accionNave);
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
			System.out.println(automata.abra(abre)); 
			//AutomataCelular ac=automata.abra(abre);

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

    private void refresque(){
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

    }
    
    public void pintarInvasores(Graphics g){
        TreeMap<String, Invasor> invasores = space3.getInvasores();
        g.setColor(Color.white);
        for (String i: invasores.keySet()){
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
}