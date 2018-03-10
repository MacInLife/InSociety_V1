
package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ServiceDAO {

      public static int GetIdServ(String type_service) throws ClassNotFoundException, SQLException
     {
          int i =0 ;
          //Je me connecte
          Connection co = Connect.getInstance().getConnection();
         // constitution d'une commande basée sur une requête SQL 
         // en vue d'être exécutée sur une connexion donnée     
         String req = "SELECT `id_service` FROM `service` WHERE type_service = ?";
        
       
         PreparedStatement pst = co.prepareStatement(req);
         pst.setString(1, type_service);
       
         ResultSet table = pst.executeQuery();
         
         while(table.next())
         {
             i = table.getInt("id_service");
         }
         return i;
     }
      
      public static void ajoutServ(Service serv) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `service`(`type_service`) "
                + "VALUES (?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setString(1, serv.getType_service());    
           
               
       int nbligne =  pst.executeUpdate();
    
    }
 
    public static void SuppServ(Service serv) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `service` WHERE nom = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
           //renvoyer et verifier les données de la requête
         pst.setString(1, serv.getType_service());  
         
        int i = pst.executeUpdate();
    
    }

	public static String getTypeService(int id_service) throws SQLException, ClassNotFoundException {
		// TODO Stub de la m�thode g�n�r� automatiquement
		String i = "" ;
         //Je me connecte
         Connection co = Connect.getInstance().getConnection();
        // constitution d'une commande basée sur une requête SQL 
        // en vue d'être exécutée sur une connexion donnée     
        String req = "SELECT `type_service` FROM `service` WHERE id_service = ?";
       
      
        PreparedStatement pst;
		
			pst = co.prepareStatement(req);
	
        pst.setInt(1, id_service);
      
        ResultSet table = pst.executeQuery();
        
        while(table.next())
        {
            i = table.getString("type_service");
        }
        return i;
	}
	
	public static ObservableList<String> getServiceList() throws SQLException {
		ObservableList<String> slist = FXCollections.observableArrayList();
        Connection co = Connect.getInstance().getConnection();
        String requeteSQL = "SELECT `type_service` FROM `service`";
        PreparedStatement pst = co.prepareStatement(requeteSQL);
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
        	slist.add(rs.getString("type_service"));
        }
		
	    return slist;
		
	}
	

}
