
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

    JButton jbPDF; //crear PDF con la grafica
    JLabel jlMensaje; //mostrar posible mensaje de error
    
    JFreeChart chart;
    int contadores[] = new int[3];
    //contadores[0] conteo de cantidad de Tecnologos
    //contadores[1] conteo de cantidad de Profesionales
    //contadores[2] conteo de cantidad de Especialistas
    //contadores[3] conteo de cantidad de Maestria
    //contadores[4] conteo de cantidad de Doctorado 
    
    public Graf_informe() {
        // crear el JFame
        super("Grafico - Nivel de informe (Facultad de Ingenieria)");
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
        if(!cant_X_informe("GuardarDatos.csv")){//si no hay error al leer el archivo, ....            
            //entonces, asignar los datos en el data        
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("ID", contadores[0]);
            data.setValue("Profesional", contadores[1]);
            data.setValue("Especialización", contadores[2]);
            //data.setValue("Maestria", contadores[3]);
           // data.setValue("Doctorado", contadores[4]);

            // crear el grafico
            chart = ChartFactory.createPieChart3D(
                    "Nivel de estudios", // chart title
                    data, // data
                    true, // include legend
                    true,
                    false
            );
            
            //esto es opcional. Crear subtitulo para el grafico 
            TextTitle subtitle1 = new TextTitle("Facultad de Ingenieria");
            chart.addSubtitle(subtitle1);
            
            // mostrar etiquetas de valores sobre el grafico
            PiePlot pieplot = (PiePlot) chart.getPlot();  
            pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));   
            
            // adicionar el chart al panel
            ChartPanel panel = new ChartPanel(chart, false);
            panel.setBounds(10, 20, 760, 450);
            add(panel);
            
            jbPDF.setVisible(true);// hacer visible el boton para crear el PDF
        }
    }
    
    public boolean cant_X_informe(String fileName) {
        FileReader fr = null; //declaracion de un objeto de la clase FileReader
        boolean error = false; //variable para determinar si existio error al tratar de abrir el archivo

        try {// tratar la excepcion que puede lanzar el constructor
            fr = new FileReader(fileName);// instanciar el objeto
        } catch (IOException e) {// atrapar la excepcion que puede lanzar el constructor
            error = true;// existio un error al tratar de abrir el archivo
            jlMensaje.setText("Error al tratar de abrir el archivo '" + fileName + "'");
        }

        if (!error) {// sino hubo error al tratar de abrir el archivo, entonces leerlo
            
            // crear un objeto de BufferedReader y enviarle el objeto FileReader
            BufferedReader br = new BufferedReader(fr);
            String linea = "";// almacenar toda una linea del documento 
            String tokens[];

            try {// tratar la excepcion que puede lanzar el metodo readLine().
                // leer cada linea del docuemento y almacenarla en en String.
                // el bucle se repite mientras no se llegue al fin del documento
                while ((linea = br.readLine()) != null) {
                    //System.out.println(registro);// imprimir la linea leida
                    tokens = linea.split(";");
                    //tokens[] = {"10", "1", "Especializacion"}
                    //posicion      0    1           2
                    if (tokens.length >= 2) {
                         switch(tokens[1]){ //evaluar la posicion 2 del array tokens, donde esta el nivel de estudios
                        case "id":       contadores[0]++; break;
                        case "informacion":     contadores[1]++; break;
                        case "Turno": contadores[2]++; break;
                       // case "Maestria":        contadores[3]++; break;
                        //case "Doctorado":       contadores[4]++; break;
                    }
                    } else {
    // Manejar el caso en el que no hay suficientes elementos en la línea
}     
                }
            } catch (IOException e) {// atrapar la excepcion que puede lanzar el metodo readLine()
                jlMensaje.setText("Error al tratar de leer el archivo '" + fileName + "'");
            }

            try {// tratar la excepcion que puede lanzar el metodo close()
                fr.close();
            } catch (IOException e) {// atrapar la excepcion que puede lanzar el metodo close()
                jlMensaje.setText("Error al tratar de cerrar el archivo '" + fileName + "'");
            }
        }
        
        return error;
    }
    
    private void evento_jbPDF() {
        try {//Crear grafico como una imagen  
            ChartUtilities.saveChartAsPNG(
            //ChartUtilities.saveChartAsJPEG(
                    //damos la ubicacion donde se guardara la imagen, y su extension
                    new File("Grafico-Nivel estudios (Fac Ing).png"), //la ruta y el nombre de la imagen a crear
                    chart, //la grafica
                    760,//ancho 
                    450);//alto
            
            crearPDF();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error creando grafico.");
        }
    }
    
    public void crearPDF() {
        // step 1: creation of a document-object        
        Document document = new Document();

        try {
            // step 2: creation of the writer
            PdfWriter writer = PdfWriter.getInstance(document, 
                    new FileOutputStream("Grafico-Nivel estudios (Fac Ing).pdf"));

            // step 3: we open the document
            document.open();
            
            // step 4: we grab the ContentByte and do some stuff with it
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
                        
            Font font1 = new Font("Tahoma", Font.BOLD, 25);
            g.setFont(font1);

            g.setColor(Color.RED);
            g.drawString("Informe de Docentes", 165, 30);
                                    
            ImageIcon img1 = new ImageIcon("Grafico-Nivel estudios (Fac Ing).png");
            g.drawImage(img1.getImage(), 40, 60, 520, 320, null);
            
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        // step 5: we close the document
        document.close();

        pregunta();
    }
    
    private void pregunta() {
        int res = JOptionPane.showConfirmDialog(this, 
            "Se creo el archivo 'Grafico-Nivel estudios (Fac Ing).pdf' en la carpeta del proyecto.\n\n¿Desea ver el archivo?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){
            File fl = new File("Grafico-Nivel estudios (Fac Ing).pdf");// cargar el documento PDF
            try {
                Desktop.getDesktop().open(fl);// abrir el documento con el programa por defecto para el tipo archivo PDF
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                    "Error al tratar de abrir el archivo 'Grafico-Nivel estudios (Fac Ing).pdf'");
            }
        }
    }
    
 
}
