
package metier;
import java.sql.Date;
//Bibliothèque
import java.sql.Time;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Evenements {
    //Initialisation des variables 
	private IntegerProperty id_evt;
    private StringProperty nomEvt;
    private ObjectProperty<Date> jour_d;
    private ObjectProperty<Date> jour_f;
    private ObjectProperty<Time> h_debut;
    private ObjectProperty<Time> h_fin;
    private StringProperty type;
    private StringProperty lieu;
    Salle_Reunion salle ;
    
    //Constructeur par defaut JavaFX
   public Evenements(){
	   this.id_evt = new SimpleIntegerProperty();
    this.nomEvt = new SimpleStringProperty();
    this.jour_d = new SimpleObjectProperty<Date>();
    this.jour_f = new SimpleObjectProperty<Date>();
    this.h_debut = new SimpleObjectProperty<Time>();
    this.h_fin = new SimpleObjectProperty<Time>();
    this.type    = new SimpleStringProperty();
    this.lieu     = new SimpleStringProperty();
   
   }
    //Constructeur
    /*public Evenements(String nomEvt,LocalDate jour, String type, String lieu){
        this.nomEvt = nomEvt;
        this.jour = jour;
        this.type = type;
        this.lieu = lieu;
    }*/
       
   // Cr�ation des getters et setters Property
   public IntegerProperty getId_evtPro() {
	   return id_evt;
   }
   public void setId_evtPro(IntegerProperty id_evt) {
	   this.id_evt = id_evt;
   }
   
    public StringProperty getNomEvtPro(){
        return nomEvt;
    }
    public void setNomEvtPro(StringProperty nomEvt){
         this.nomEvt = nomEvt;
    }
    
    public ObjectProperty<Date> getJour_dPro(){
        return jour_d;
    }
    public void setJour_dPro(ObjectProperty<Date> jour_d){
        this.jour_d = jour_d;
    }
    public ObjectProperty<Date> getJour_fPro(){
        return jour_f;
    }
    public void setJour_fPro(ObjectProperty<Date> jour_f){
        this.jour_f = jour_f;
    }
    public ObjectProperty<Time> getH_debutPro(){
    	return h_debut;
    }
    public void setH_debutPro(ObjectProperty<Time> h_debut) {
    	this.h_debut = h_debut;
    }
    public ObjectProperty<Time> getH_finPro(){
    	return h_fin;
    }
    public void setH_finPro(ObjectProperty<Time> h_fin) {
    	this.h_fin = h_fin;
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
    public int getId_evt() {
    	return id_evt.get();
    }
    public void setId_evt(int id_evt) {
    	this.id_evt.set(id_evt);
    }
    public String getNomEvt(){
        return nomEvt.get();
    }
    public void setNomEvt(String nomEvt){
         this.nomEvt.set(nomEvt);
    }
    
    public Date getJour_d(){
        return jour_d.get();
    }
    public void setJour_d(Date jour_d){
        this.jour_d.set(jour_d);
    }
        public Date getJour_f(){
        return jour_f.get();
    }
    public void setJour_f(Date jour_f){
        this.jour_f.set(jour_f);
    }
    public Time getH_debut() {
    	return h_debut.get();
    }
    public void setH_debut(Time h_debut) {
    	this.h_debut.set(h_debut);
    }
    public Time getH_fin() {
    	return h_fin.get();
    }
    public void setH_fin(Time h_fin) {
    	this.h_fin.set(h_fin);
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
        this.lieu.set(lieu);
    }

    public Salle_Reunion getSalle() {
        return salle;
    }

    public void setSalle(Salle_Reunion salle) {
        this.salle = salle;
    }

 
    
}
