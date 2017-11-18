
package metier;

import java.util.ArrayList;


public class RespEvent implements GestionEvent{
    ArrayList<Evenements> listeEvt;


    public RespEvent(ArrayList<Evenements> listeEvt) {
        this.listeEvt = listeEvt; 
    }  

   @Override
    public void creationEvent(Evenements event) {
         listeEvt.add(event);
    }
       
}
