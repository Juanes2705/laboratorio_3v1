package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuPrincipal;
import vista.Administrador;
import vista.consultaPK;
import vista.Actualizar;
import datos.DatosA;
import vista.Acerca;
import java.util.ArrayList;
import vista.consultaPK;
import vista.Jlistado;
import vista.MenuGra;

public class controladorMenu implements ActionListener {
    public MenuPrincipal MP;
    private Administrador admin;
    private ArrayList<DatosA> data; 

    public controladorMenu(MenuPrincipal MP) {
        this.MP = MP;

        this.data = new ArrayList<>(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(MP.Jnuevo)) {
            Administrador f = new Administrador(MP);

            MP.setVisible(false);
        }
        
        if (e.getSource().equals(MP.Jconsultar)) {
        consultaPK ventanaConsulta = new consultaPK(MP, admin);
        ventanaConsulta.setVisible(true);
    }
        if (e.getSource().equals(MP.Jactualiazar)) {
            Actualizar a = new Actualizar(MP, data);
           
        }
        if (e.getSource().equals(MP.Jlistado)) {
            Jlistado f = new Jlistado(MP);

            MP.setVisible(false);
        }
        if (e.getSource().equals(MP.Jgrafica)) {
            MenuGra M = new MenuGra(MP);

            MP.setVisible(false);
        }
        if (e.getSource().equals(MP.Jacerca)) {
            Acerca  L = new Acerca(MP);

        }
    }
}

