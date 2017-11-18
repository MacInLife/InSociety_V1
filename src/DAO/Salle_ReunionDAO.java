
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Personnel;
import metier.Role;
import metier.Salle_Reunion;
import metier.Service;
import metier.Statut;

public class Salle_ReunionDAO  {

       public static int GetIdSR(String nomSR) throws ClassNotFoundException, SQLException
     {
          int i =0 ;
          Connection co = Connect.getInstance().getConnection();
         // constitution d'une commande basée sur une requête SQL 
         // en vue d'être exécutée sur une connexion donnée     
         String req = "SELECT `id_SR` FROM `Salle_Reunion` WHERE nomSR = ?";
        
         PreparedStatement pst = co.prepareStatement(req);
         pst.setString(1, nomSR);
       
         ResultSet table = pst.executeQuery();
         
         while(table.next())
         {
             i = table.getInt("id_SR");
         }
         return i;
     }
    
 public static void ajoutSalleReu(Salle_Reunion salleReu) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête inserer new evenements
        String requeteSQL = "INSERT INTO `salle_reunion`(`nb_place`, `horaire`, `jour`, `nomSR`, `id_statut`, `lieu`) "
                + "VALUES (?,?,?,?,?,?)";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
         //renvoyer et verifier les données de la requête
         pst.setString(1, salleReu.getNb_place());
         pst.setDate(2, salleReu.getHoraire()  );
         pst.setDate(3, salleReu.getJour());
         pst.setString(4, salleReu.getNomSR());
         pst.setInt(5,StatutDAO.GetIdStat(salleReu.getStatut().getLibeller()));
         pst.setString(6, salleReu.getLieu());
               
       int nbligne =  pst.executeUpdate();
    
    }
 
    public static void SuppSalleReu(Salle_Reunion salleReu ) throws SQLException, ClassNotFoundException{
        //Je me connecte
        Connection co = Connect.getInstance().getConnection();
           
        //Création de la requête supprimer evenements
        String requeteSQL = "DELETE FROM `salle_reunion` WHERE nomSR = ? ";
        
        //préparer la requête
         PreparedStatement pst = co.prepareStatement(requeteSQL);
         
          //renvoyer et verifier les données de la requête
         pst.setString(1, salleReu.getNomSR());
        
         
        int i = pst.executeUpdate();
    
    }
    
   public static ObservableList<Salle_Reunion> GetListeSalle() throws ClassNotFoundException, SQLException {
		ObservableList<Salle_Reunion> SalleList = FXCollections.observableArrayList();
		// constitution d'une commande bas�e sur une requ�te SQL
		// en vue d'�tre ex�cut�e sur une connexion donn�e
		String req = "select * from salle_reunion";
		Connection cnx = Connect.getInstance().getConnection();
		//Integer id;
		String nomSR;
		String nb_place;
		Date jour;
		Date horaire;
		String lieu;
		int id_statut;
	
		PreparedStatement pst = cnx.prepareStatement(req);

		ResultSet table = pst.executeQuery();
		while (table.next()) {
			
		//	id = table.getInt("id");
			nomSR = table.getString("nomSR");
			nb_place = table.getString("nb_place");
			jour = table.getDate("jour");
			horaire = table.getDate("horaire");
			lieu = table.getString("lieu");
			id_statut = table.getInt("id_statut");
		
			Salle_Reunion salle = new Salle_Reunion();
			//salle.setId(id);
			salle.setNomSR(nomSR);
			salle.setNb_place(nb_place);
			salle.setJour(jour);
			salle.setHoraire(horaire);
			salle.setLieu(lieu);
			Statut statu = new Statut();
			statu.setLibeller(StatutDAO.getLibeller(id_statut));
			salle.setStatut(statu);
	

		}
		table.close();
		pst.close();
		cnx.close();
		return SalleList;
	}
    
}
