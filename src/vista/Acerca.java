package vista;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import Controlador.Acercacontrolador;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Acerca extends JFrame{
    
    public JButton jbVolver;
    public MenuPrincipal MP;
    public JTextField jNombres;
    
    public Acerca(MenuPrincipal MP){
        
        super("Informacion programadores");
        this.MP = MP;
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        crearGUI();
        
        setVisible(true);
        
    }
    private void crearGUI(){
        Acercacontrolador acd =new Acercacontrolador(this);
        
        JLabel jNombre = new JLabel("<html>Juan Esteban Guerrero Rivera-2257726"
                + "<br>Juan Carlos Salgado Velásquez-2257857"
                + "<br>Juan Pablo Calderón Gallego-2257594"
                + "<br>José Lindsay Bohada Linares-2257840</html>");
        jNombre.setBounds(40, 100, 320, 60); 
        jNombre.setForeground(Color.BLACK);
        add(jNombre);
        
        
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(400, 420, 200, 30);
        jbVolver.setMnemonic('V');
        jbVolver.addActionListener(acd);
        jbVolver.setBackground(Color.BLACK);
        jbVolver.setForeground(Color.WHITE);
        add(jbVolver);
    }

    
}