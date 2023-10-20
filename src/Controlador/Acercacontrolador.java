package Controlador;

import datos.DatosA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Acerca;



public class Acercacontrolador implements ActionListener {

    Acerca A;
        
    public Acercacontrolador(Acerca A){
        this.A=A;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(A.jbVolver)) {
            volver();
        
        
            }else{
                volver();
            }
       
        
    }
    private void volver() {
        A.setVisible(false);
        A.dispose();
        A.MP.setVisible(true);
    }
    
}