
package metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Service {
//initialisation des variable de la classe Service
    private StringProperty type_service;
    
    /*//Constructeur
   public Service(String type_service){
        this.type_service = type_service;
    }*/
    public Service(){
        this.type_service = new SimpleStringProperty();
    }
    
      //Création des getters et setters Property
    public StringProperty getType_servicePro(){
        return type_service;
    }
    public void setType_servicePro(StringProperty type_service){
        this.type_service = type_service;
    }
    
    //Création des getters et setters
    public String getType_service(){
        return type_service.get();
    }
    public void setType_service(String type_service){
        this.type_service.set(type_service);
    }

	
}
