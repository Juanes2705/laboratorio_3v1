
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import java.awt.Color;

public class StackedBarChart3DDemo extends JFrame {

    JFreeChart chart;//declaramos un objeto de la clase JFreeChart para construir el grafico

    public StackedBarChart3DDemo() {
        //crear el JFrame
        super("Ejemplo de StackedBarChart3D");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGrafico();//metodo para cargar los datos y crear el grafico

        ChartPanel panel = new ChartPanel(chart, false);//ChartPanel es una clase del paquete JFreeChart
        //es igual que JPanel de swing. Sobre el ChartPanel se crea el grafico
        panel.setBounds(10, 20, 760, 520);//damos ubicacion y tamano al panel
        add(panel); //anadimos el panel al JFrame

        setVisible(true); //mostrar el JFrame  
    }

    public void crearGrafico() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, "Mazda", "Jaime");//ventas de Mazda de Jaime
        dataset.addValue(4.0, "Mazda", "Valeria");//ventas de Mazda de Valeria
        dataset.addValue(3.0, "Mazda", "Sebastian");//ventas de Mazda de Sebastian
        dataset.addValue(5.0, "Mazda", "Valentina");//ventas de Mazda de Valentina
        dataset.addValue(5.0, "Mazda", "Carlos");//ventas de Mazda de Carlos

        dataset.addValue(5.0, "Renault", "Jaime");
        dataset.addValue(7.0, "Renault", "Valeria");
        dataset.addValue(6.0, "Renault", "Sebastian");
        dataset.addValue(8.0, "Renault", "Valentina");
        dataset.addValue(4.0, "Renault", "Carlos");

        dataset.addValue(4.0, "Ford", "Jaime");
        dataset.addValue(3.0, "Ford", "Valeria");
        dataset.addValue(2.0, "Ford", "Sebastian");
        dataset.addValue(3.0, "Ford", "Valentina");
        dataset.addValue(6.0, "Ford", "Carlos");
        
        chart = ChartFactory.createStackedBarChart3D(
                "Ventas 2014", 
                "Vendedores", 
                "Cantidad de Vehiculos", 
                dataset,
                PlotOrientation.VERTICAL, 
                true, true, false);
        
        chart.setBackgroundPaint(new Color(249, 231, 236));
    }
    
    public static void main(String[] args) {
        StackedBarChart3DDemo demo = new StackedBarChart3DDemo();
    }
}
