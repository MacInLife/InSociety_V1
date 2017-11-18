package metier;
import java.sql.Date;
//Bibliothèque
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;

public class Personnel {
  // Initialisation des variables
  //Création de la classe Statut, Role, Service

    Statut statut ;
    Role role ; 
    Service service ;
    private IntegerProperty id;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty adresse;
    private StringProperty mail;
    private StringProperty tel;
    private StringProperty login;
    private ObjectProperty<Date> date_naissance;
    private StringProperty localisation;
    private StringProperty mdp;
   
 //Initialisation des variables arraylist d'évènement
    
public Personnel (){
 this.id = new SimpleIntegerProperty() ;
    this.nom = new SimpleStringProperty();
    this.prenom = new SimpleStringProperty();
    this.adresse = new SimpleStringProperty();
    this.mail = new SimpleStringProperty();
    this.tel = new SimpleStringProperty();
    this.login = new SimpleStringProperty();
    this.date_naissance = new SimpleObjectProperty<Date>();
    this.localisation = new SimpleStringProperty();
    this.mdp = new SimpleStringProperty();
}

//Constructeur
    /*
 public Personnel(String nom, String prenom, String adresse, String tel,
        LocalDate date_naissance, String lieu, Role role, Service service){
 this.nom = nom;
 this.prenom = prenom;
 this.adresse = adresse;
 //initialisation de la variable login par défaut = 1ere Lettre du Prénom et Nom 
 this.login = prenom.substring(0, 1)+nom;
 //initialisation de la variable mail par défault = login+@+nom_dom_ent+.com
 this.mail = login+"@"+/*entreprise*//*".com";
 this.tel = tel;
 this.date_naissance = date_naissance;
 this.localisation = localisation;
 this.role = role;
 this.service = service;
 
 //initialisation de la variable statut par défault en hors_ligne
 this.statut = new Statut("hors_ligne");
 
 }
 */

//Création des getters et setters Property
public IntegerProperty getIdPro(){
    return id;
}
public void setIdPro(IntegerProperty id){
    this.id = id;
}
    public StringProperty getNomPro(){
        return nom;
    }
    public void setNomPro(StringProperty nom){
        this.nom = nom;
    }
    
    public StringProperty getPrenomPro(){
        return prenom;
    }
    public void setPrenomPro(StringProperty prenom){
        this.prenom = prenom;
    }
    
    public StringProperty getAdressePro(){
        return adresse;
    }
    public void setAdressePro(StringProperty adresse){
        this.adresse = adresse;
    }
    
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
        
    public StringProperty getLoginPro(){
        return login;
    }
    public void setLoginPro(StringProperty login){
        this.login = login;
    }
    
    public ObjectProperty<Date> getDate_naissancePro(){
        return date_naissance;
    }
    public void setDate_naissancePro(ObjectProperty<Date> date_naissance){
        this.date_naissance = date_naissance;
    }
    
    public StringProperty getLocalisationPro(){
        return localisation;
    }
    public void setLocalisationPro(StringProperty localisation){
        this.localisation = localisation;
    }
    
    public StringProperty getMdpPro(){
        return localisation;
    }
    public void setMdpPro(StringProperty mdp){
        this.mdp = mdp;
    }
    
    //Getters et setters des classes Role, Service, Statut
    public Role getRole(){
        return role;
    }
    public void setRole(Role role){
        this.role = role;
    }
    
    public Service getService(){
        return service;
    }
    public void setService(Service service){
        this.service = service;
    }
    
    public Statut getStatut(){
        return statut;
    }
    public void setStatut(Statut statut){
        this.statut = statut;
    }
  
 //Création des getters et setters
    public int getId(){
        return id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    
    public String getNom(){
        return nom.get();
    }
    public void setNom(String nom){
        this.nom.set(nom);
    }
    
    public String getPrenom(){
        return prenom.get();
    }
    public void setPrenom(String prenom){
        this.prenom.set(prenom);
    }
    
    public String getAdresse(){
        return adresse.get();
    }
    public void setAdresse(String adresse){
        this.adresse.set(adresse);
    }
    
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
        
    public String getLogin(){
        return login.get();
    }
    public void setLogin(String login){
        this.login.set(login);
    }
    
    public Date getDate_naissance(){
        return date_naissance.get();
    }
    public void setDate_naissance(Date date){
        this.date_naissance.set(date);
    }
    
    public String getLocalisation(){
        return localisation.get();
    }
    public void setLocalisation(String localisation){
        this.localisation.set(localisation);
    }
    
    public String getMdp(){
        return mdp.get();
    }
    public void setMdp(String mdp){
        this.mdp.set(mdp);
    }

    @Override
    public String toString() {
    	return "Personnel [statut=" + statut + ", role=" + role + ",service="
    			+ service + ",nom=" + nom + ",mail=" + mail + ",tel=" + tel 
    			+",login=" + login + ",date_naissance=" + date_naissance 
    			+ ",localisation=" + localisation + "mdp=" + mdp + "]";
    }
   
     
    
}
