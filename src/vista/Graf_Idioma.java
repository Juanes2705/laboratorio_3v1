
package vista;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.BasicStroke;
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
import java.text.DecimalFormat;
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

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;


public class Graf_Idioma extends JFrame{

    JButton jbPDF; //crear PDF con la grafica
    JLabel jlMensaje; //mostrar posible mensaje de error
    
    JFreeChart chart;
    int contadores[] = new int[3];
    
    
    public Graf_Idioma() {
        // crear el JFame
        super("Grafico - Idioma");
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
        if(!cant_X_idioma("GuardarDatos.csv")){        
            //entonces, asignar los datos en el dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            dataset.addValue(contadores[0], "Idioma", "Español");
           
            
            dataset.addValue(contadores[1], "Idioma", "Ingles");
            
            
            dataset.addValue(contadores[2], "Idioma", "Frances");
           
            
           
            
      
            chart = ChartFactory.createBarChart3D(
                    "Nivel de Idioma", 
                    "Idioma",
                    "Cantidad", 
                    dataset, // 
                    PlotOrientation.VERTICAL, 
                    true, 
                    true,
                    false
            );
            
           
            TextTitle subtitle1 = new TextTitle("Datos");
            chart.addSubtitle(subtitle1);
                        
          
            ChartPanel panel = new ChartPanel(chart, false);
            panel.setBounds(10, 20, 760, 450);
            add(panel);
            
            jbPDF.setVisible(true);
        }
    }
    
    public boolean cant_X_idioma(String fileName) {
        FileReader fr = null; 
        boolean error = false; 

        try {
            fr = new FileReader(fileName);
        } catch (IOException e) {
            error = true;
            JOptionPane.showMessageDialog(this, 
                    "Error al tratar de abrir el archivo '" + fileName + "'");
        }

        if (!error) {
            
            
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];

            try {
                while ((linea = br.readLine()) != null) {
                    
                    tokens = linea.split(";");
                    
                    switch(tokens[3]){ 
                            case "Españo":       contadores[0]++; break;
                            case "Ingles":     contadores[1]++; break;
                            case "Frances": contadores[2]++; break;
                           
                        }
                    }
                    
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error al tratar de leer el archivo '" + fileName + "'");
            }

            try {
                fr.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error al tratar de cerrar el archivo '" + fileName + "'");
            }
        }
        
        return error;
    }
    
    private void evento_jbPDF() {
        try {
            ChartUtilities.saveChartAsPNG(
            
                    new File("Grafico-Idioma (Fac Ing).png"),
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
                    new FileOutputStream("Grafico-Idioma (Fac Ing).pdf"));

       
            document.open();
            
           
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
                        
            Font font1 = new Font("Tahoma", Font.BOLD, 25);
            g.setFont(font1);

            g.setColor(Color.RED);
            g.drawString("Informe de Idioma", 165, 30);
                                    
            ImageIcon img1 = new ImageIcon("Grafico-Idioma (Fac Ing).png");
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
            "Se creo el archivo 'Grafico-Idioma (Fac Ing).pdf' en la carpeta del proyecto.\n\n¿Desea ver el archivo?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){
            File fl = new File("Grafico-Idioma (Fac Ing).pdf");
            try {
                Desktop.getDesktop().open(fl);// abrir el documento con el programa por defecto para el tipo archivo PDF
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                    "Error al tratar de abrir el archivo 'Grafico-Idioma (Fac Ing).pdf'");
            }
        }
    }
    
    
}
