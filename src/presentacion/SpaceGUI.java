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
        Space space = new Space(10, 10);
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
    }
}