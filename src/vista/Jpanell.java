package vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Jpanell extends JPanel{
    
    public Jpanell(){
        setLayout(null);
        Border borde = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(borde);
        setBounds(10, 10, 990, 480);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("JPanel con Borde");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        Jpanell panel = new Jpanell();
        frame.add(panel); 

        frame.setVisible(true);
    }
}
