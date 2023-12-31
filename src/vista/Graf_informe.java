
package vista;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;



public class Graf_informe extends JFrame{

    JButton jbPDF; 
    JLabel jlMensaje; 
    
    JFreeChart chart;
    int contadores[] = new int[3];
    
    
    public Graf_informe() {
 
        super("Grafico - De Turno ");
        setSize(800, 580);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        crearGUI();
        crearGrafico();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        jlMensaje = new JLabel(""); 
        jlMensaje.setBounds(1, 300, 800, 30);
        jlMensaje.setFont(new Font("Tahoma", Font.BOLD, 20));
        jlMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlMensaje);
        
        ImageIcon img = new ImageIcon(getClass().getResource("imagenes/pdf-icon.png"));
        jbPDF = new JButton("Crear PDF con la gráfica", img);
        jbPDF.setBounds(540, 480, 230, 50);
        jbPDF.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbPDF.setBorderPainted(false);
        jbPDF.setContentAreaFilled(false);
        jbPDF.setFocusPainted(false);        
        jbPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbPDF();
            }
        });
        jbPDF.setVisible(false);
        add(jbPDF);
    }

    public void crearGrafico() {        
        if(!cant_X_turno("GuardarDatos.csv")){       
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Mañana", contadores[0]);
            data.setValue("Tarde", contadores[1]);
            data.setValue("Noche", contadores[2]);
            

            chart = ChartFactory.createPieChart3D("Nivel de Turno", data,true,true,false);
            
   
            TextTitle subtitle1 = new TextTitle("Turnos de trabajo");
            chart.addSubtitle(subtitle1);
            
           
            PiePlot pieplot = (PiePlot) chart.getPlot();  
            pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));   
            
           
            ChartPanel panel = new ChartPanel(chart, false);
            panel.setBounds(10, 20, 760, 450);
            add(panel);
            
            jbPDF.setVisible(true);
        }
    }
    
    public boolean cant_X_turno(String fileName) {
        FileReader fr = null; 
        boolean error = false; 

        try {
            fr = new FileReader(fileName);
        } catch (IOException e) {
            error = true;
            jlMensaje.setText("Error al tratar de abrir el archivo '" + fileName + "'");
        }

        if (!error) {
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];

            try {
                while ((linea = br.readLine()) != null) {
                    
                    tokens = linea.split(";");
                    
                    switch(tokens[2]){
                        case "Mañana":       contadores[0]++; break;
                        case "Tarde":     contadores[1]++; break;
                        case "Noche": contadores[2]++; break;
                        
                    }
                }
            } catch (IOException e) {
                jlMensaje.setText("Error al tratar de leer el archivo '" + fileName + "'");
            }

            try {
                fr.close();
            } catch (IOException e) {
                jlMensaje.setText("Error al tratar de cerrar el archivo '" + fileName + "'");
            }
        }
        
        return error;
    }
    
    private void evento_jbPDF() {
        try {
            ChartUtilities.saveChartAsPNG(
            
                    new File("Grafico-Turno (Fac Ing).png"), 
                    chart, //la grafica
                    760,//ancho 
                    450);//alto
            
            crearPDF();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error creando grafico.");
        }
    }
    
    public void crearPDF() {
           
        Document document = new Document();

        try {
           
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("Grafico-Turno (Fac Ing).pdf"));

           
            document.open();
            
            
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
                        
            Font font1 = new Font("Tahoma", Font.BOLD, 25);
            g.setFont(font1);

            g.setColor(Color.RED);
            g.drawString("Informe de Turno", 165, 30);
                                    
            ImageIcon img1 = new ImageIcon("Grafico-Turno (Fac Ing).png");
            g.drawImage(img1.getImage(), 40, 60, 520, 320, null);
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        
        document.close();

        pregunta();
    }
    
    private void pregunta() {
        int res = JOptionPane.showConfirmDialog(this, 
            "Se creo el archivo 'Grafico-Turno (Fac Ing).pdf' en la carpeta del proyecto.\n\n¿Desea ver el archivo?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){
            File fl = new File("Grafico-Turno (Fac Ing).pdf");// cargar el documento PDF
            try {
                Desktop.getDesktop().open(fl);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                    "Error al tratar de abrir el archivo 'Grafico-Turno (Fac Ing).pdf'");
            }
        }
    }
    
    
}
