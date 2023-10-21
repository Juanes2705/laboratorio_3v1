package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import Controlador.administradorcontrolador;
import datos.DatosA;
import javax.swing.JCheckBox;


public class consultaPK extends JFrame {

    private JTextField Jid, Jinfo, Jhorario, Jidioma;
    private JButton jbConsultar, jbLimpiar, jbVolver;
    private JCheckBox Jinforme, FRO1, FRO2, FRO3, NV1, NV2, NV3;
    private MenuPrincipal MP;
    private Administrador admin;
    private DatosA datosSeleccionados;

    public consultaPK(MenuPrincipal MP, Administrador admin) {
        super("Consulta por por clave primaria");
        this.MP = MP;
        this.admin = admin;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        crearGUI();
        setVisible(true);
        
        JLabel jin = new JLabel("Informacion del usuario:");
        jin.setBounds(50, 150, 200, 30);
        jin.setForeground(Color.BLACK);
        add(jin);
        
        JLabel jho = new JLabel("Jornada:");
        jho.setBounds(50, 200, 200, 30);
        jho.setForeground(Color.BLACK);
        add(jho);
        
        JLabel jfo = new JLabel("Idioma:");
        jfo.setBounds(50, 250, 200, 30);
        jfo.setForeground(Color.BLACK);
        add(jfo);
        
        JLabel jf = new JLabel("Formacion:");
        jf.setBounds(50, 350, 200, 30);
        jf.setForeground(Color.BLACK);
        add(jf);
        
        JLabel jnv = new JLabel("Nivel de idioma:");
        jnv.setBounds(50, 450, 200, 30);
        jnv.setForeground(Color.BLACK);
        add(jnv);

        Jinfo = new JTextField();
        Jinfo.setBounds(200, 150, 120, 30);
        add(Jinfo);

        Jhorario = new JTextField();
        Jhorario.setBounds(160, 200, 120, 30);
        add(Jhorario);

        Jidioma = new JTextField();
        Jidioma.setBounds(160, 250, 120, 30);
        add(Jidioma);

        Jinforme = new JCheckBox();
        Jinforme.setBounds(160, 300, 120, 30);
        add(Jinforme);

        FRO1 = new JCheckBox("Bachiller");
        FRO1.setBounds(160, 350, 120, 30);
        add(FRO1);

        FRO2 = new JCheckBox("Pregrado");
        FRO2.setBounds(160, 380, 120, 30);
        add(FRO2);

        FRO3 = new JCheckBox("Posgrado");
        FRO3.setBounds(160, 410, 120, 30);
        add(FRO3);

        NV1 = new JCheckBox("Básico");
        NV1.setBounds(160, 450, 120, 30);
        add(NV1);

        NV2 = new JCheckBox("Intermedio");
        NV2.setBounds(160, 480, 120, 30);
        add(NV2);

        NV3 = new JCheckBox("Avanzado");
        NV3.setBounds(160, 510, 120, 30);
        add(NV3);
    }

    private void crearGUI() {
        administradorcontrolador ad = new administradorcontrolador(admin);

        JLabel jid = new JLabel("ID trabajador:");
        jid.setBounds(50, 50, 120, 30);
        jid.setForeground(Color.BLACK);
        add(jid);

        Jid = new JTextField();
        Jid.setDocument(new ListadorCaracteres(Jid, 5, 0));
        Jid.setBounds(160, 50, 120, 30);
        add(Jid);

        jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(50, 100, 120, 30);
        jbConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idValue = Jid.getText();
                datosSeleccionados = buscarPorID(idValue);
                if (datosSeleccionados != null) {
                    Jinfo.setText(datosSeleccionados.getINfo());
                    Jhorario.setText(datosSeleccionados.getHOrario());
                    Jidioma.setText(datosSeleccionados.getIDioma());
                    Jinforme.setSelected(datosSeleccionados.isINforme());
                    FRO1.setSelected(datosSeleccionados.isFRO1());
                    FRO2.setSelected(datosSeleccionados.isFRO2());
                    FRO3.setSelected(datosSeleccionados.isFRO3());
                    NV1.setSelected(datosSeleccionados.isNV1());
                    NV2.setSelected(datosSeleccionados.isNV2());
                    NV3.setSelected(datosSeleccionados.isNV3());
                } else {
                    JOptionPane.showMessageDialog(consultaPK.this, "No se encontró la clave primaria.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                }
            }
        });
        add(jbConsultar);

        jbLimpiar = new JButton("Limpiar");
        jbLimpiar.setBounds(180, 100, 120, 30);
        jbLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        add(jbLimpiar);

        jbVolver = new JButton("Volver al menú");
        jbVolver.setBounds(310, 100, 150, 30);
        jbVolver.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
               dispose(); // Cierra la ventana actual
               MP.setVisible(true);  
            }
        });
        add(jbVolver);
    }

    private void limpiarCampos() {
        Jid.setText("");
        Jinfo.setText("");
        Jhorario.setText("");
        Jidioma.setText("");
        Jinforme.setSelected(false);
        FRO1.setSelected(false);
        FRO2.setSelected(false);
        FRO3.setSelected(false);
        NV1.setSelected(false);
        NV2.setSelected(false);
        NV3.setSelected(false);
    }

    private DatosA buscarPorID(String id) {
        for (DatosA dato : MP.Datosa) {
            if (dato.getID().equalsIgnoreCase(id)) {
                return dato;
            }
        }
        return null;
    }
}





