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
    public Space space;

    //aributos menu
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem open, save, saveAs, exit;
    private JFileChooser file;
    
    //Atributos tablero
    private JPanel infoHUD;
    private JPanel game;
    private JLabel puntaje;
    private JLabel vidas;

    public SpaceGUI(Space space){
        this.space = space;
        this.setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
        Pintar invaders = new Pintar(space);
        infoHUD = new JPanel();
        game = new JPanel();
        puntaje = new JLabel("Puntaje:");
        vidas = new JLabel("Vidas:");
        infoHUD.setBorder(new EmptyBorder(5,50,5,50));
        infoHUD.setLayout(new BorderLayout());
        infoHUD.add(puntaje,BorderLayout.EAST);
        infoHUD.add(vidas,BorderLayout.WEST);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(infoHUD,BorderLayout.NORTH);
        getContentPane().add(game,BorderLayout.SOUTH);
        
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
    }
}

class Pintar extends JPanel {
    private Space space;
    public Pintar(Space space){
        this.space = space;
    }

    public void paintComponent(Graphics g){
        Super.paintComponent(g);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 5; j++){
                for (int k = 0; k < 5; k++){
                    
                }
            }
        }
    }
}