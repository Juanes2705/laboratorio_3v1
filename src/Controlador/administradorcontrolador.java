package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Administrador;
import datos.DatosA;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class administradorcontrolador implements ActionListener {

    Administrador a;

    public administradorcontrolador(Administrador a) {
        this.a = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(a.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(a.jbLimpiar)) {
            limpiar();
        }
        if (e.getSource().equals(a.jbGuardar)) {

            String id = a.Jid.getText();
            String info = a.Jinfo.getText();
            String horario = (String) a.Jhorario.getSelectedItem();
            String nivel = (String) a.Jidioma.getSelectedItem();
            boolean informe = a.Jinforme.isSelected();

            boolean fro1Selected = a.FRO1.isSelected();
            boolean fro2Selected = a.FRO2.isSelected();
            boolean fro3Selected = a.FRO3.isSelected();
            boolean nv1Selected = a.NV1.isSelected();
            boolean nv2Selected = a.NV2.isSelected();
            boolean nv3Selected = a.NV3.isSelected();

            DatosA D = new DatosA(id, info, horario, nivel, nivel, informe, fro1Selected, fro2Selected, fro3Selected, nv1Selected, nv2Selected, nv3Selected);
            D.setInforme(informe);
            D.setFRO1(fro1Selected);
            D.setFRO2(fro2Selected);
            D.setFRO3(fro3Selected);
            D.setNV1(nv1Selected);
            D.setNV2(nv2Selected);
            D.setNV3(nv3Selected);
            

            a.MP.Datosa.add(D);

            guardarDatosEnCSV(D);

            int resp = JOptionPane.showConfirmDialog(
                    a,
                    "Se guardaron los datos.\n¿Desea ingresar otros datos?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.YES_OPTION) {
                limpiar();
            } else {
                volver();
            }
        }
    }

    private void volver() {
        a.setVisible(false);
        a.dispose();
        a.MP.setVisible(true);
    }

    private void limpiar() {
        a.Jid.setText("");
        a.Jinfo.setText("");
        a.Jhorario.setSelectedItem("Mañana");
        a.Jidioma.setSelectedItem("Español");
        a.Jinforme.setSelected(true);

        a.FRO1.setSelected(false);
        a.FRO2.setSelected(false);
        a.FRO3.setSelected(false);
        a.NV1.setSelected(false);
        a.NV2.setSelected(false);
        a.NV3.setSelected(false);
    }

    private void guardarDatosEnCSV(DatosA datos) {
    FileWriter fw = null;
    BufferedWriter bw = null;
    boolean error = false;
    try {
        
        fw = new FileWriter("C:"+File.separator+
                "prueba"+File.separator+
                "laboratorio_3"+File.separator+
                "GuardarDatos.csv", true);
        

        bw = new BufferedWriter(fw);

        String lineaCSV = datos.getID()+ ";" + datos.getINfo()+ ";" + datos.getHOrario()+ ";" + datos.getNIvel()+ ";" +
                datos.isINforme()+ ";" + datos.isFRO1() + ";" + datos.isFRO2() + ";" + datos.isFRO3() + ";" +
                datos.isNV1() + ";" + datos.isNV2() + ";" + datos.isNV3();

        bw.write(lineaCSV);
        bw.newLine(); 

        bw.close();

        JOptionPane.showMessageDialog(null, "Datos guardados en el archivo CSV correctamente.");

    } catch (IOException e) {
        error = true;
        JOptionPane.showMessageDialog(null, "Error al guardar datos en el archivo CSV:\n" + e.getMessage());
    } finally {
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar BufferedWriter y FileWriter:\n" + e.getMessage());
        }
    }
}
}


