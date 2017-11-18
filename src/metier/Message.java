
package metier;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Message {
    //Initialisation des variables 
    private StringProperty mail;
    private StringProperty tel;
    private ObjectProperty<LocalDate> jour;
    private ObjectProperty<LocalDate> heure;
    private StringProperty lieu;
    private Personnel pers;
    private Statut statut;
    
    //Constructeur
    public Message(){
        this.mail = new SimpleStringProperty();
        this.tel = new SimpleStringProperty();
       this.jour = new SimpleObjectProperty<LocalDate>();
        this.heure = new SimpleObjectProperty<LocalDate>();
        this.lieu     = new SimpleStringProperty();
    }
    
        //Création des getters et setters Property
    public StringProperty getMailPro(){
        return mail;
    }
    public void setMailPro(StringProperty mail){
        this.mail = mail;
    }
    
    public StringProperty getTelPro(){
        return tel;
    }
    public void setTelPro(StringProperty tel){
        this.tel = tel;
    }
     
    public ObjectProperty<LocalDate> getJourPro(){
        return jour;
    }
    public void setJourPro(ObjectProperty<LocalDate> jour){
        this.jour = jour;
    }
    
    public ObjectProperty<LocalDate> getHeurePro(){
        return heure;
    }
    public void setHeurePro(ObjectProperty<LocalDate> heure){
        this.heure = heure;
    }
    
    public StringProperty getLieuPro(){
        return lieu;
    }
    public void setLieuPro(StringProperty lieu){
        this.lieu = lieu;
    }
    
    //Création des getters et setters
    public String getMail(){
        return mail.get();
    }
    public void setMail(String mail){
        this.mail.set(mail);
    }
    
    public String getTel(){
        return tel.get();
    }
    public void setTel(String tel){
        this.tel.set(tel);
    }
      public Personnel getPers() {
        return pers;
    }

    public void setPers(Personnel  pers) {
        this.pers = pers;
    }
         public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut  statut) {
        this.statut = statut;
    }
     
    public LocalDate getJour(){
        return jour.get();
    }
    public void setJour(LocalDate jour){
        this.jour.set(jour);
    }
    
    public LocalDate getHeure(){
        return heure.get();
    }
    public void setHeure(LocalDate heure){
        this.heure.set(heure);
    }
    
    public String getLieu(){
        return lieu.get();
    }
    public void setLieu(String lieu){
        this.lieu.set(lieu);
    }
   
}
