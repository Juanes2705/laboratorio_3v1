
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

    JButton jbGrafNivel, jbGrafNivelTipo, jbSalir;

    public MenuGra() {
        super("Menu de Graficas");
        setSize(550, 320);
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
        jbGrafNivel = new JButton("Nivel de estudios", im1);
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
                evento_jbGrafNivel();
            }
        });
        add(jbGrafNivel);

        ImageIcon im2 = new ImageIcon(getClass().getResource("imagenes/barras.png"));
        jbGrafNivelTipo = new JButton("<html><center>Nivel de estudios<br>x Tipo</html>", im2);
        jbGrafNivelTipo.setBounds(190, 80, 158, 180);
        jbGrafNivelTipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbGrafNivelTipo.setBorderPainted(false);
        jbGrafNivelTipo.setContentAreaFilled(false);
        jbGrafNivelTipo.setFocusPainted(false);
        jbGrafNivelTipo.setHorizontalTextPosition(SwingConstants.CENTER);
        jbGrafNivelTipo.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbGrafNivelTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbGrafNivelTipo();
            }
        });
        add(jbGrafNivelTipo);

        ImageIcon im3 = new ImageIcon(getClass().getResource("imagenes/exit.png"));
        jbSalir = new JButton("Salir", im3);
        jbSalir.setBounds(350, 80, 158, 180);
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

    private void evento_jbGrafNivel() {
        //Graf_general gn = new Graf_general();
    }

    public void evento_jbGrafNivelTipo() {
        Graf_informe gnt = new Graf_informe();
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

    public static void main(String[] args) {
        MenuGra mg = new MenuGra();
    }
}
