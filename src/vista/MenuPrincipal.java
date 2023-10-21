
package vista;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import datos.DatosA;
import Controlador.controladorMenu;
import java.awt.EventQueue;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public final class MenuPrincipal extends JFrame {
    
    public JButton Jnuevo,Jconsultar,Jacerca,Jactualiazar,mostrar,Jlistado,Jgrafica;
    public ArrayList<DatosA> Datosa = new ArrayList<>();
    
    
    public MenuPrincipal() {
        super("Menu Principal");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        
        Guia();
        
    }
    public void Guia() {
        controladorMenu ctm = new controladorMenu(this);
        
        Jnuevo = new JButton("Nuevo");
        Jnuevo.setBounds(450, 20, 200, 40);
        Jnuevo.setMnemonic('I');
        Jnuevo.addActionListener(ctm);
        Jnuevo.setBackground(Color.BLACK);
        Jnuevo.setForeground(Color.WHITE);
        
        add(Jnuevo);
        
        Jconsultar = new JButton("Consultar");
        Jconsultar.setBounds(450, 120, 200, 40);
        Jconsultar.setMnemonic('I');
        Jconsultar.addActionListener(ctm);
        Jconsultar.setBackground(Color.BLACK);
        Jconsultar.setForeground(Color.WHITE);
        add(Jconsultar);
        
        Jactualiazar = new JButton("Actualizar");
        Jactualiazar.setBounds(450, 220, 200, 40);
        Jactualiazar.setMnemonic('I');
        Jactualiazar.addActionListener(ctm);
        Jactualiazar.setBackground(Color.BLACK);
        Jactualiazar.setForeground(Color.WHITE);
        add(Jactualiazar);
        
        Jlistado = new JButton("listado ");
        Jlistado .setBounds(450, 320, 200, 40);
        Jlistado .setMnemonic('I');
        Jlistado .addActionListener(ctm);
        Jlistado .setBackground(Color.BLACK);
        Jlistado .setForeground(Color.WHITE);
        add(Jlistado );
        
        Jgrafica= new JButton("Graficas ");
        Jgrafica .setBounds(450, 420, 200, 40);
        Jgrafica .setMnemonic('I');
        Jgrafica .addActionListener(ctm);
        Jgrafica .setBackground(Color.BLACK);
        Jgrafica .setForeground(Color.WHITE);
        add(Jgrafica );
        
        Jacerca = new JButton("Acerca");
        Jacerca.setBounds(450, 520, 200, 40);
        Jacerca.setMnemonic('l');
        Jacerca.addActionListener(ctm);
        Jacerca.setBackground(Color.BLACK);
        Jacerca.setForeground(Color.WHITE);
        add(Jacerca);
        
    }
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
