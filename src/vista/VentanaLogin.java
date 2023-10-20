
package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import vista.MenuPrincipal;



public class VentanaLogin extends JFrame{

    JTextField jtLogin;
    JPasswordField jpPassw;
    JToggleButton jtVer; // para ver u ocultar el password
    JButton jbCancelar, jbIngresar;
    ImageIcon ver, no_ver;
    
    public VentanaLogin(){
        super("Ingreso al sistema");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        ImageIcon im = new ImageIcon(getClass().getResource(
                "imagenes/icons8-registro-50.png"));
        JLabel jlTitulo = new JLabel("Ingreso al sistema", im, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 400, 75);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.WHITE);
        jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jlTitulo);
        
        JLabel jlLogin = new JLabel("Login");
        jlLogin.setBounds(10, 90, 100, 30);
        jlLogin.setHorizontalAlignment(JLabel.RIGHT);
        add(jlLogin);
        
        jtLogin = new JTextField();
        jtLogin.setBounds(120, 90, 150, 30);
        jtLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpPassw.requestFocus(); 
            }
        });
        add(jtLogin);
        
        JLabel jlPass = new JLabel("Password");
        jlPass.setBounds(10, 140, 100, 30);
        jlPass.setHorizontalAlignment(JLabel.RIGHT);
        add(jlPass);
        
        jpPassw = new JPasswordField();
        jpPassw.setBounds(120, 140, 150, 30);
        jpPassw.setEchoChar(' ');
        jpPassw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_validar();
            }
        });
        add(jpPassw);
                
        ver = new ImageIcon(getClass().getResource("imagenes/icons8-ver-48.png"));
        no_ver = new ImageIcon(getClass().getResource("imagenes/no_ver.png"));
        jtVer = new JToggleButton(no_ver); 
        jtVer.setBounds(275, 140, 50, 30);
        jtVer.setBorderPainted(false); 
        jtVer.setContentAreaFilled(false); 
        jtVer.setFocusPainted(false); 
        jtVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jtVer(); 
            }
        });
        add(jtVer); 
        
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(45, 200, 150, 35);
        jbCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(jbCancelar);
        
        jbIngresar = new JButton("Ingresar");
        jbIngresar.setBounds(205, 200, 150, 35);
        jbIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_validar();
            }
        });
        add(jbIngresar);
    }
    
    public  void evento_jtVer(){
        if(jtVer.isSelected()){
            jtVer.setIcon(ver); 
            jpPassw.setEchoChar((char) 0);
        }else{
            jtVer.setIcon(no_ver);
            jpPassw.setEchoChar(' ');
        }
        jpPassw.requestFocus(); 
    }
    
    public void evento_validar() {
        String login = jtLogin.getText();
        char caracteres[] = jpPassw.getPassword();
        String passw = String.valueOf(caracteres);

        System.out.println(login + " " + passw);

        if (login.equals("") || passw.equals("")) {
            JOptionPane.showMessageDialog(this, "Login y/o password no pueden ser vacíos");
        } else {
            if (login.equals("root") && passw.equals("123456")) {
                JOptionPane.showMessageDialog(this, "Ingreso correcto");

                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true); 

                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Ingreso incorrecto. Login y/o password incorrecto",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
     public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaLogin frame = new VentanaLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}