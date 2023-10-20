package vista;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import Controlador.administradorcontrolador;
import datos.DatosA;
import java.awt.Font;
import vista.Jpanell;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.ButtonGroup;



public class Administrador extends JFrame {
    
    public JButton jbVolver, jbGuardar, jbLimpiar;
    public JTextField Jid;
    public JTextArea Jinfo;
    public JComboBox Jhorario,Jidioma;
    
    
    public JCheckBox Jinforme;
    public MenuPrincipal MP;
    public JRadioButton FRO1, FRO2, FRO3,NV1,NV2,NV3;
    private ButtonGroup grupoRadioBotones;;
    
    public Administrador(MenuPrincipal MP){
        
        super("Ingresar");
        this.MP = MP;
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        crearGUI();
        
        Jpanell panel = new Jpanell();
        add(panel);
        
        setVisible(true);
    }
    
    
    
    
    private void crearGUI(){
        administradorcontrolador ad=new administradorcontrolador(this);
        
        JLabel jid = new JLabel("Id trabajador:");
        jid.setBounds(50, 50, 120, 30);
        jid.setForeground(Color.BLACK);
        jid.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jid);
        
        Jid =new JTextField();
        Jid.setBackground(Color.LIGHT_GRAY);
        Jid.setFont(new Font("Arial", Font.PLAIN, 14));
        Jid.setBounds(50, 80, 120, 30);
        add(Jid);
        
        JLabel jin = new JLabel("Informacion del usuario:");
        jin.setBounds(50, 120, 200, 30);
        jin.setForeground(Color.BLACK);
        jin.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jin);
        
        Jinfo=new JTextArea();
        Jinfo.setBackground(Color.LIGHT_GRAY);
        Jinfo.setFont(new Font("Arial", Font.PLAIN, 14));
        Jinfo.setBounds(50, 150, 200,80);
        add(Jinfo);
        
        JLabel jho = new JLabel("Jornada:");
        jho.setBounds(50, 240, 200, 30);
        jho.setForeground(Color.BLACK);
        jho.setFont(new Font("Arial", Font.PLAIN, 14)); 
        add(jho);
        
        Jhorario = new JComboBox<>();
        Jhorario.addItem("Mañana");
        Jhorario.addItem("Tarde");
        Jhorario.addItem("Noche");
        Jhorario.setBounds(50, 270, 150, 30);
        Jhorario.setBackground(Color.LIGHT_GRAY);
        Jhorario.setFont(new Font("Arial", Font.PLAIN, 14));    
        add(Jhorario);
        
        JLabel jfo = new JLabel("Formación:");
        jfo.setBounds(50, 310, 200, 30);
        jfo.setForeground(Color.BLACK);
        jfo.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jfo);

        FRO1 = new JRadioButton("Bachiller");
        FRO1.setBounds(50, 340, 120, 30);
        FRO1.setFont(new Font("Arial", Font.PLAIN, 14));
        add(FRO1);

        FRO2 = new JRadioButton("Pregrado");
        FRO2.setBounds(50, 370, 120, 30);
        FRO2.setFont(new Font("Arial", Font.PLAIN, 14));
        add(FRO2);

        FRO3 = new JRadioButton("Posgrado");
        FRO3.setBounds(50, 400, 120, 30);
        FRO3.setFont(new Font("Arial", Font.PLAIN, 14));
        add(FRO3);

        grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(FRO1);
        grupoRadioBotones.add(FRO2);
        grupoRadioBotones.add(FRO3);
        
        JLabel jnv = new JLabel("Nivel de idioma:");
        jnv.setBounds(650, 50, 200, 30);
        jnv.setFont(new Font("Arial", Font.PLAIN, 14));
        jnv.setForeground(Color.BLACK);
        add(jnv);

        NV1 = new JRadioButton("Basico");
        NV1.setBounds(650, 80, 120, 30);
        NV1.setFont(new Font("Arial", Font.PLAIN, 14));
        add(NV1);

        NV2 = new JRadioButton("Intermedio");
        NV2.setBounds(650, 110, 120, 30);
        NV2.setFont(new Font("Arial", Font.PLAIN, 14));
        add(NV2);

        NV3 = new JRadioButton("Avazado");
        NV3.setBounds(650, 140, 120, 30);
        NV3.setFont(new Font("Arial", Font.PLAIN, 14));
        add(NV3);

        grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(NV1);
        grupoRadioBotones.add(NV2);
        grupoRadioBotones.add(NV3);
        
        jbLimpiar = new JButton("Limpiar");
        jbLimpiar.setBounds(640, 550, 150, 30);
        jbLimpiar.setMnemonic('L');
        jbLimpiar.addActionListener(ad);
        jbLimpiar.setBackground(Color.BLACK);
        jbLimpiar.setForeground(Color.WHITE);
        add(jbLimpiar);
        
        jbGuardar = new JButton("Guardar");
        jbGuardar.setBounds(480, 550, 150, 30);
        jbGuardar.setMnemonic('G');
        jbGuardar.addActionListener(ad);
        jbGuardar.setBackground(Color.BLACK);
        jbGuardar.setForeground(Color.WHITE);
        add(jbGuardar);
        
        jbVolver = new JButton("Volver al menu");
        jbVolver.setBounds(800, 550, 200, 30);
        jbVolver.setMnemonic('V');
        jbVolver.addActionListener(ad);
        jbVolver.setBackground(Color.BLACK);
        jbVolver.setForeground(Color.WHITE);
        
        add(jbVolver);
        
        JLabel jidi = new JLabel("Idioma:");
        jidi.setBounds(650, 170, 200, 30);
        jidi.setForeground(Color.BLACK);
        jidi.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jidi);
        
        Jidioma = new JComboBox<>();
        Jidioma.addItem("Español");
        Jidioma.addItem("Ingles");
        Jidioma.addItem("Frances");
        Jidioma.setBounds(650, 200, 150, 30);
        Jidioma.setBackground(Color.LIGHT_GRAY);
        Jidioma.setFont(new Font("Arial", Font.PLAIN, 14));
        add(Jidioma);
        
        JLabel jinf = new JLabel("Acceso:");
        jinf.setBounds(650, 240, 200, 30);
        jinf.setForeground(Color.BLACK);
        jinf.setFont(new Font("Arial", Font.PLAIN, 14));
        add(jinf);

        Jinforme = new JCheckBox("Restaurante");
        Jinforme.setBounds(650, 270, 100, 30);
        Jinforme.setFont(new Font("Arial", Font.PLAIN, 14));
        Jinforme.setBackground(Color.LIGHT_GRAY); 
      
        add(Jinforme);

        JCheckBox JinformeNo = new JCheckBox("Hotel");
        JinformeNo.setBounds(750, 270, 100, 30);
        JinformeNo.setFont(new Font("Arial", Font.PLAIN, 14));
        JinformeNo.setBackground(Color.LIGHT_GRAY);
        add(JinformeNo);
        
        
        

        
    }
    
}

    

