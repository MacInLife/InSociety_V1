
package DAO;

import metier.Message;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MessageDAO {
    public static void  ajoutMsg(Message msg) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new message
        String requeteSQL = "INSERT INTO `message`(`Tel`, `mail`, `statut`,`jour`, `heure`, `lieu`,"
                + " `id_pers`, `id_msgrie`)"
                + "VALUES (?,?,?,?,?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setString(1, msg.getTel());
         pst.setString(2, msg.getMail());
         pst.setInt(3,StatutDAO.GetIdStat(msg.getStatut().getLibeller()));
         pst.setDate(4, Date.valueOf(msg.getJour()));
         pst.setDate(5, Date.valueOf(msg.getHeure()));
         pst.setString(6, msg.getLieu());
        
         //Récupère et vérifier la clé étrangère de la table Statut
         pst.setInt(4,PersonnelDAO.GetIdPers(msg.getPers().getMail()));
         
         //recup id_pers et id_msgrie
         
               
       int nbligne =  pst.executeUpdate();
    
    }
 
    public static void SuppMsg(Message msg ) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `message` WHERE tel,mail = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
          //renvoyer et verifier les données de la requête
         pst.setString(1, msg.getTel());
         pst.setString(2, msg.getMail());
         pst.setDate(1, Date.valueOf(msg.getJour()));
         pst.setDate(1, Date.valueOf(msg.getHeure()));
         pst.setString(3, msg.getLieu());
         
         
        int i = pst.executeUpdate();
    
    }
}
