
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Role;



public class RoleDAO {
    
    
    
     public static int GetIdRole(String nom_role) throws ClassNotFoundException, SQLException
     {
          int i =0 ;
          Connection co = Connect.getInstance().getConnection();
         // constitution d'une commande basée sur une requête SQL 
         // en vue d'être exécutée sur une connexion donnée     
         String req = "SELECT `id_role` FROM `role` WHERE nom_role = ?";
        
       
         PreparedStatement pst = co.prepareStatement(req);
         pst.setString(1, nom_role);
       
         ResultSet table = pst.executeQuery();
         
         while(table.next())
         {
             i = table.getInt("id_role");
         }
         return i;
     }
	
     
     public static void ajoutRole(Role rol) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `role`(`nom_role`) VALUES (?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setString(1, rol.getNom_role());
                                    
             
         //pst.setInt(4, RoleDAO.GetIdRole(pers.getRole().getNom_role()));       
               
       int nbligne =  pst.executeUpdate();
    
    }
 
    public static void SuppRole(Role rol ) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `role` WHERE nom = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
          //renvoyer et verifier les données de la requête
         pst.setString(1, rol.getNom_role());
         
        int i = pst.executeUpdate();
    
    }
    
    
	public static String getNomRole(int id_role) throws SQLException, ClassNotFoundException {
		// TODO Stub de la m�thode g�n�r� automatiquement
		String i = "" ;
         //Je me connecte
         Connection co = Connect.getInstance().getConnection();
        // constitution d'une commande basée sur une requête SQL 
        // en vue d'être exécutée sur une connexion donnée     
        String req = "SELECT `nom_role` FROM `role` WHERE id_role = ?";
       
      
        PreparedStatement pst;
		
			pst = co.prepareStatement(req);
	
        pst.setInt(1, id_role);
      
        ResultSet table = pst.executeQuery();
        
        while(table.next())
        {
            i = table.getString("nom_role");
        }
        return i;
	}
	
	public static ObservableList<String> getRoleNameList() throws SQLException {
		ObservableList<String> slist = FXCollections.observableArrayList();
        Connection co = Connect.getInstance().getConnection();
        String requeteSQL = "SELECT `nom_role` FROM `role`";
        PreparedStatement pst = co.prepareStatement(requeteSQL);
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
        	slist.add(rs.getString("nom_role"));
        }
		
	    return slist;
		
	}
}
