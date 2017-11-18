
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import metier.Evenements;

public class EvenementsDAO {
    public static void ajoutEvent(Evenements event) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `evenement`(`nomEvt`,`jour`, `type`, `lieu`, `id_SR`)"
                + "VALUES (?,?,?,?,?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setString(1, event.getNomEvt());
         pst.setDate(2, Date.valueOf(event.getJour()));
         pst.setString(3, event.getType());
         pst.setString(4, event.getLieu());
        // faire un GetId_SR   avec le nom dans salle de réunion et appeler pou renvoyer les données requètes
         pst.setInt(5, Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR()));
         
         //Récupère et vérifier la clé étrangère de la table Salle de Réunion id_SR
         
         //pst.setInt(4, RoleDAO.GetIdRole(pers.getRole().getNom_role()));       
               
       int nbligne =  pst.executeUpdate();
    
    }
 
    public static void SuppEvent(Evenements event ) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `evenement` WHERE nomEvt = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
          //renvoyer et verifier les données de la requête
         pst.setString(1, event.getNomEvt());
     
         
        int i = pst.executeUpdate();
    
    }
}
