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

public class SpaceGUI extends JFrame{
    public Space space2;

    //aributos menu
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem open, save, saveAs, exit;
    private JFileChooser file;
    
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
    private void prepareAcciones(){

        WindowListener w = new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                salga();
            }
        };
        this.addWindowListener(w);
        KeyListener accionNave = new KeyListener(){
        
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
        
            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    int dx = -1;
                    moveNave(dx);
                    refresque();
                }
                if (key == KeyEvent.VK_RIGHT) {
                    int dx = 1;
                    moveNave(dx);
                    refresque();
                }             
            }  
        };
        invaders.addKeyListener(accionNave);

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
                }
            }
        };
        exit.addActionListener(accionMenu);
        open.addActionListener(accionMenu);
        save.addActionListener(accionMenu);
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
        exit = new JMenuItem("Salir");

        setJMenuBar(barra);

        barra.add(menu);
        menu.add(open);
        menu.add(save);
        menu.add(saveAs);
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
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(infoHUD,BorderLayout.NORTH);
        getContentPane().add(invaders,BorderLayout.CENTER);
        //getContentPane().add(game,BorderLayout.SOUTH);
        
    }
    //es el metodo responsable de repintar el juego cuando es necesario
    private void refresque(){
        invaders.repaint();
    }
    private void moveNave(int dx){
        Nave n = space2.getNave(0);
        n.movePosicionX(dx);
    }
    private void moveNave2(int dx){
        Nave n = space2.getNave(1);
        n.movePosicionX(dx);
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
        file = new JFileChooser();
        file.showOpenDialog(this);
        File abre = file.getSelectedFile();
    }
    private void salvar(){
        file = new JFileChooser();
        file.showSaveDialog(this);
        File guardar = file.getSelectedFile();
    }
    public static void main(String[] args) {
        Space space = new Space(1, 1);
        SpaceGUI s = new SpaceGUI(space);
        s.setVisible(true);
    }
}

class Pintar extends JPanel {
    private Space space3;
    public Pintar(Space space){
        space3 = space;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Barrera
        for (int i = 0; i < 3; i++){
            Barrera b = space3.getBarrera(i);
            g.setColor(b.getColor());
            for (int j = 0; j < 5; j++){
                for (int k = 0; k < 5; k++){
                    g.fillOval(i*200+175+k*5,400+j*5,5,5);
                    b.getMaterial(j, k).setPosicionX(100+i*200+j*5);
                    b.getMaterial(j, k).setPosicionY(300+k*5);
                }
            }
        }
        //nave
        for (int i = 0; i<1; i++)
        {
            Nave n = space3.getNave(i);
            g.setColor(n.getColor());
            //space3.setNave(space.getNave(i));
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 9; k++){
                    if (j == 0){
                        if (k == 5){
                            g.fillRect(170+k*5,n.getPosition()+j*5,5,5);
                            System.out.println(n.getPosition());
                        }
                    }else{
                        g.fillRect(175+k*5,n.getPosition()+j*5,5,5);
                        n.getMaterial(j, k).setPosicionX(n.getPosition()+j*5);
                        n.getMaterial(j, k).setPosicionY(175+k*5);
                    }
                        
                }
            }



        }






        //invasores
        for (int s = 0; s < 1; s ++){
            for (int i = 0; i < 1; i++){
                Invasor f = space3.getInvasor(s,i);
                for (int j = 0; j < 8; j++){
                    for (int k = 0; k < 8; k++){
                        if (f.getBinario(j,k) == 1){
                            g.fillRect(300+i*20+k*2, 300+s*20+j*2, 2, 2);
                        }
                    }
                }
            }
        }











    }
}