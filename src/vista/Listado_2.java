
package vista;


import datos.DatosA;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EtchedBorder;


public class Listado_2 extends JFrame{
    
    public Jlistado JL;
    public MenuPrincipal MP;
    public ModeloTabla mt;
    public JTable tabla;
    private JButton Jvolver;
    
    public Listado_2(Jlistado JL,MenuPrincipal MP){
        super("Ingresar");
        this.JL = JL;
        this.MP = MP;
        setSize(900, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        

        
        crearGUI();
        llenarTabla();
        
        setVisible(true);
    }
        
    private void crearGUI() {
        JLabel jl = new JLabel("  Listado de personas");
        jl.setBounds(0, 0, 900, 50);
        jl.setBorder(new EtchedBorder());
        jl.setOpaque(true);
        jl.setBackground(Color.WHITE);
        jl.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(jl);
        
        String encabezados[] = {"bachiller","Pregrado","posgrado","idioma","basico","intermendio","avanzado"};
        String datos[][] = {{"", "", "", "", "", "", ""}};
        
        mt = new ModeloTabla(datos, encabezados);
        tabla = new JTable(mt);
        
        tabla.setSelectionBackground(Color.lightGray);
        tabla.setSelectionForeground(Color.RED);
        
        
        JScrollPane js = new JScrollPane(tabla);
        js.setBounds(20, 60, 850, 150);
        
        add(js);
        
        Jvolver = new JButton("Volver al menú");
        Jvolver.setBounds(720, 220, 150, 30);
        Jvolver.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
               dispose(); // Cierra la ventana actual
               JL.setVisible(true);  
            }
        });
        add(Jvolver);
    }
    
    public void llenarTabla(){
        mt.removeRow(0);
        for (int i = 0; i < MP.Datosa.size(); i++) {
            DatosA p = MP.Datosa.get(i);
            //System.out.println(p.getNombre());
            Object datos[] = new Object[7];            
            
            datos[0] = p.isFRO1();
            datos[1] = p.isFRO2();
            datos[2] = p.isFRO3();
            datos[3] = p.getIDioma();
            datos[4] = p.isNV1();
            datos[5] = p.isNV2();
            datos[6] = p.isNV3();
           
            
            mt.addRow(datos);
        }
    }
}