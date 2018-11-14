package presentacion;
import javax.swing.JFrame;

import aplicacion.*;

public class SpaceGUI extends JFrame{
    public Space space;
    public SpaceGUI(Space space){
        this.space = space;
        this.setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        Space space = new Space(10, 10);
        SpaceGUI s = new SpaceGUI(space);
    }
}