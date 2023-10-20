
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Administrador;
import vista.Jlistado;
import vista.ListadoGeneral;
import vista.Listado_1;
import vista.Listado_2;
import vista.MenuPrincipal;

public class controladorListado implements ActionListener{

    public Jlistado JL;
    public MenuPrincipal MP;
    
    public controladorListado(Jlistado JL,MenuPrincipal MP){
        this.JL=JL;
        this.MP=MP;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(JL.ListadoG)) {
            ListadoGeneral f = new ListadoGeneral(JL, MP);

            JL.setVisible(false);
        }
        if (e.getSource().equals(JL.Listado1)) {
            Listado_1 f = new Listado_1(JL, MP);

            JL.setVisible(false);
        }
        if (e.getSource().equals(JL.Listado2)) {
            Listado_2 f = new Listado_2(JL, MP);

            JL.setVisible(false);
        }
        if (e.getSource().equals(JL.Jvolver)) {
            volver();
        }
        
    }
    private void volver() {
        JL.setVisible(false);
        JL.dispose();
        MP.setVisible(true);
    }
    
}
