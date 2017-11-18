
package metier;

import java.util.ArrayList;

public class RespInfo  implements  GestionPers{
    ArrayList<Personnel> listePers  ;

    public RespInfo(ArrayList<Personnel> listePers) {
        this.listePers = listePers;
    }  

    @Override
    public void creationPers(Personnel pers) {
         listePers.add(pers);
    }
       
    
    
    
}
