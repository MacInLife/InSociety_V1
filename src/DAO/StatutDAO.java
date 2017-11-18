
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import metier.Statut;

public class StatutDAO {
    
         public static int GetIdStat(String libeller) throws ClassNotFoundException, SQLException
     {
          int i =0 ;
          Connection co = Connect.getInstance().getConnection();
         // constitution d'une commande basée sur une requête SQL 
         // en vue d'être exécutée sur une connexion donnée     
         String req = "SELECT `id_statut` FROM `statut` WHERE libeller = ?";
        
         PreparedStatement pst = co.prepareStatement(req);
         pst.setString(1, libeller);
       
         ResultSet table = pst.executeQuery();
         
         while(table.next())
         {
             i = table.getInt("id_statut");
         }
         return i;
     }
         
         public static void ajoutStatut(Statut statu) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `statut`(`libeller`)"
                + " VALUES (?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setString(1, statu.getLibeller());
                               
         //Récupère et vérifier la clé étrangère de la table Salle de Réunion id_SR
         
         //pst.setInt(4, RoleDAO.GetIdRole(pers.getRole().getNom_role()));       
               
       int nbligne =  pst.executeUpdate();
    
    }
 
    public static void SuppStatut(Statut statu ) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `statut` WHERE nom = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
          //renvoyer et verifier les données de la requête
         pst.setString(1, statu.getLibeller());
         
        int i = pst.executeUpdate();
    
    }
    
    
	public static String getLibeller(int id_statut) throws SQLException, ClassNotFoundException {
		// TODO Stub de la m�thode g�n�r� automatiquement
		String i = "" ;
         //Je me connecte
         Connection co = Connect.getInstance().getConnection();
        // constitution d'une commande basée sur une requête SQL 
        // en vue d'être exécutée sur une connexion donnée     
        String req = "SELECT `libeller` FROM `statut` WHERE id_statut = ?";
       
      
        PreparedStatement pst;
		
			pst = co.prepareStatement(req);
	
        pst.setInt(1, id_statut);
      
        ResultSet table = pst.executeQuery();
        
        while(table.next())
        {
            i = table.getString("libeller");
        }
        return i;
	}
}
