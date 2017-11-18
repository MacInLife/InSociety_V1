
package metier;
//Bibliothèque
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Evenements {
    //Initialisation des variables 
    private StringProperty nomEvt;
    private ObjectProperty<LocalDate> jour;
    private StringProperty type;
    private StringProperty lieu;
    private Salle_Reunion salle ;
    
    //Constructeur par defaut JavaFX
   public Evenements(){
    this.nomEvt = new SimpleStringProperty();
    this.jour = new SimpleObjectProperty<LocalDate>();
    this.type    = new SimpleStringProperty();
    this.lieu     = new SimpleStringProperty();
    salle = new Salle_Reunion();
   }
    //Constructeur
    /*public Evenements(String nomEvt,LocalDate jour, String type, String lieu){
        this.nomEvt = nomEvt;
        this.jour = jour;
        this.type = type;
        this.lieu = lieu;
    }*/
       
   // Cr�ation des getters et setters Property
    public StringProperty getNomEvtPro(){
        return nomEvt;
    }
    public void setNomEvtPro(StringProperty nomEvt){
         this.nomEvt = nomEvt;
    }
    
    public ObjectProperty<LocalDate> getJourPro(){
        return jour;
    }
    public void setJourPro(ObjectProperty<LocalDate> jour){
        this.jour = jour;
    }
    
    public StringProperty getTypePro(){
        return type;
    }
    public void setTypePro(StringProperty type){
        this.type = type;
    }
    
    public StringProperty getLieuPro(){
        return lieu;
    }
    public void setLieuPro(StringProperty lieu){
        this.lieu = lieu;
    }
   
    
    //Création des getters et setters basique
    public String getNomEvt(){
        return nomEvt.get();
    }
    public void setNomEvt(String nomEvt){
         this.nomEvt.set(nomEvt);
    }
    
    public LocalDate getJour(){
        return jour.get();
    }
    public void setJour(LocalDate jour){
        this.jour.set(jour);
    }
    
    public String getType(){
        return type.get();
    }
    public void setType(String type){
        this.type.set(type);
    }
    
    public String getLieu(){
        return lieu.get();
    }
    public void setLieu(String lieu){
        this.lieu.get();
    }

    public Salle_Reunion getSalle() {
        return salle;
    }

    public void setSalle(Salle_Reunion salle) {
        this.salle = salle;
    }

 
    
}
