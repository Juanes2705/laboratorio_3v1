
package datos;


public class DatosA {
    private String Id;
    private String Info;
    private String Horario;
    private String Idioma;
    private String Nivel;
    private boolean Informe;
    private boolean fro1Selected;
    private boolean fro2Selected;
    private boolean fro3Selected;
    private boolean nv1Selected;
    private boolean nv2Selected;
    private boolean nv3Selected;
    private boolean fro1;
    private boolean fro2;
    private boolean fro3;
    private boolean nv1;
    private boolean nv2;
    private boolean nv3;
    
    public DatosA(String Id, String Info, String Horario, String Idioma, String Nivel, boolean Informe, boolean fro1Selected, boolean fro2Selected, boolean fro3Selected, boolean nv1Selected, boolean nv2Selected, boolean nv3Selected) {
    this.Id = Id;
    this.Info = Info;
    this.Idioma = Idioma;
    this.Horario = Horario;
    this.Nivel = Nivel;
    this.Informe = Informe; 
    this.fro1Selected = fro1Selected;
    this.fro2Selected = fro2Selected;
    this.fro3Selected = fro3Selected;
}
    public void setInforme(boolean informe) {
        this.Informe = Informe;
    
    }
    
    public String getID(){
        return Id;
    }
    public String getINfo(){
        return Info;
    }
    public String getIDioma(){
        return Idioma;
    }
    public String getHOrario(){
        return Horario;
    }
    public String getNIvel(){
        return Nivel;
    }
    public boolean getINforme(){
        return Informe;
    }

    public boolean isINforme() {
        return Informe;
    }
    
    public void setFRO1(boolean fro1) {
        this.fro1 = fro1;
    }

    public void setFRO2(boolean fro2) {
        this.fro2 = fro2;
    }

    public void setFRO3(boolean fro3) {
        this.fro3 = fro3;
    }

    public void setNV1(boolean nv1) {
        this.nv1 = nv1;
    }

    public void setNV2(boolean nv2) {
        this.nv2 = nv2;
    }

    public void setNV3(boolean nv3) {
        this.nv3 = nv3;
    }

    public boolean isFRO1() {
        return fro1;
    }

    public boolean isFRO2() {
        return fro2;
    }

    public boolean isFRO3() {
        return fro3;
    }

    public boolean isNV1() {
        return nv1;
    }

    public boolean isNV2() {
        return nv2;
    }

    public boolean isNV3() {
        return nv3;
    

    }


    public void setId(String Id) {
        this.Id = Id;
    }
    

    public void setINfo(String Info) {
        this.Info = Info;
    }


    public void setHOrario(String Horario) {
        this.Horario = Horario;
    }

    public void setIDioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public void setNIvel(String Nivel) {
        this.Nivel = Nivel;
    }

    
    
}
