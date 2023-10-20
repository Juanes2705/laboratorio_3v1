
package vista;

import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import Controlador.controladorListado;
import javax.swing.JButton;


public class Jlistado extends JFrame{
    
    public MenuPrincipal MP;
    public JButton ListadoG,Listado1,Listado2,Jvolver;
    
    public Jlistado(MenuPrincipal MP){
        super("Ingresar");
        this.MP = MP;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        
        crearGUI();
        
        setVisible(true);
    }
    public void crearGUI(){
        controladorListado cLd =new controladorListado(this, MP);
        
        ListadoG = new JButton("Listado General");
        ListadoG.setBounds(300, 120, 200, 40);
        ListadoG.setMnemonic('I');
        ListadoG.addActionListener(cLd);
        ListadoG.setBackground(Color.BLACK);
        ListadoG.setForeground(Color.WHITE);
        
        add(ListadoG);
        
        Listado1 = new JButton("Listado informe");
        Listado1.setBounds(300, 220, 200, 40);
        Listado1.setMnemonic('I');
        Listado1.addActionListener(cLd);
        Listado1.setBackground(Color.BLACK);
        Listado1.setForeground(Color.WHITE);
        
        add(Listado1);
        
        Listado2 = new JButton("Listado estudio");
        Listado2.setBounds(300, 320, 200, 40);
        Listado2.setMnemonic('I');
        Listado2.addActionListener(cLd);
        Listado2.setBackground(Color.BLACK);
        Listado2.setForeground(Color.WHITE);
        
        add(Listado2);
        
        Jvolver = new JButton("Volver al menu");
        Jvolver .setBounds(550, 500, 200, 30);
        Jvolver .setMnemonic('V');
        Jvolver .addActionListener(cLd);
        Jvolver .setBackground(Color.BLACK);
        Jvolver .setForeground(Color.WHITE);
        
        add(Jvolver );
    }
    
}
