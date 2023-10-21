
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EtchedBorder;


public class MenuGra extends JFrame {
    public MenuPrincipal MP;
    JButton jbGrafNivel, jbGraTurno, jbSalir,jbformacion,Jvolver;

    public MenuGra(MenuPrincipal MP) {
        super("Menu de Graficas");
        this.MP = MP;
        setSize(700, 420);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                evento_salir();
            }
        });

        crearGUI();

        setVisible(true);
    }

    private void crearGUI() {
        JLabel jl = new JLabel("  Menú de gráficas estadísticas");
        jl.setBounds(0, 0, 550, 60);
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        jl.setForeground(Color.BLUE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(jl);

        ImageIcon im1 = new ImageIcon(getClass().getResource("imagenes/pie_chart.png"));
        jbGrafNivel = new JButton("Idiomas", im1);
        jbGrafNivel.setBounds(30, 80, 158, 180);
        jbGrafNivel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbGrafNivel.setBorderPainted(false);
        jbGrafNivel.setContentAreaFilled(false);
        jbGrafNivel.setFocusPainted(false);
        jbGrafNivel.setHorizontalTextPosition(SwingConstants.CENTER);
        jbGrafNivel.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbGrafNivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGraIdioma();
            }
        });
        add(jbGrafNivel);

        ImageIcon im2 = new ImageIcon(getClass().getResource("imagenes/barras.png"));
        jbGraTurno = new JButton("Turnos", im2);
        jbGraTurno.setBounds(190, 80, 158, 180);
        jbGraTurno.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbGraTurno.setBorderPainted(false);
        jbGraTurno.setContentAreaFilled(false);
        jbGraTurno.setFocusPainted(false);
        jbGraTurno.setHorizontalTextPosition(SwingConstants.CENTER);
        jbGraTurno.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbGraTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGraTurno();
            }
        });
        add(jbGraTurno);
        
        ImageIcon im3 = new ImageIcon(getClass().getResource("imagenes/icons8-barras-96.png"));
        jbformacion = new JButton("Formacion", im3);
        jbformacion.setBounds(350, 80, 158, 180);
        jbformacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbformacion.setBorderPainted(false);
        jbformacion.setContentAreaFilled(false);
        jbformacion.setFocusPainted(false);
        jbformacion.setHorizontalTextPosition(SwingConstants.CENTER);
        jbformacion.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGraforma();
            }
        });
        add(jbformacion);
        
        Jvolver = new JButton("Volver al menú");
        Jvolver.setBounds(510, 250, 150, 30);
        Jvolver.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
               dispose(); // Cierra la ventana actual
               MP.setVisible(true);  
            }
        });
        add(Jvolver);

        ImageIcon im4 = new ImageIcon(getClass().getResource("imagenes/exit.png"));
        jbSalir = new JButton("Salir", im4);
        jbSalir.setBounds(510, 80, 158, 180);
        jbSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbSalir.setBorderPainted(false);
        jbSalir.setContentAreaFilled(false);
        jbSalir.setFocusPainted(false);
        jbSalir.setHorizontalTextPosition(SwingConstants.CENTER);
        jbSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_salir();
            }
        });
        add(jbSalir);
    }

    private void evento_jbGraIdioma() {
        Graf_Idioma gn = new Graf_Idioma();
    }

    public void evento_jbGraTurno() {
        Graf_informe gnt = new Graf_informe();
    }
    public void evento_jbGraforma(){
        Graf_formacion gf = new Graf_formacion();
    }

    private void evento_salir() {
        int resp = JOptionPane.showConfirmDialog(this,
                "Desea realmente salir?",
                "Confirmacíon",
                JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    
}
