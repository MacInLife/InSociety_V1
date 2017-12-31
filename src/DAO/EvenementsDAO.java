
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Evenements;
import metier.Salle_Reunion;

@SuppressWarnings("unused")
public class EvenementsDAO {
	
    public static int GetIdEvent(String nomEvt) throws ClassNotFoundException, SQLException
   {
        int i =0 ;
        Connection co = Connect.getInstance().getConnection();
       // constitution d'une commande basée sur une requête SQL 
       // en vue d'être exécutée sur une connexion donnée     
       String req = "SELECT `id_event` FROM `evenement` WHERE nomEvt = ?";
      
       PreparedStatement pst = co.prepareStatement(req);
       pst.setString(1, nomEvt);
     
       ResultSet table = pst.executeQuery();
       
       while(table.next())
       {
           i = table.getInt("id_event");
       }
       return i;
   }
	
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
         pst.setDate(2, event.getJour());
         pst.setString(3, event.getType());
         pst.setString(4, event.getLieu());
        // faire un GetId_SR   avec le nom dans salle de réunion et appeler pou renvoyer les données requètes
         pst.setInt(5, Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR()));
         
         //Récupère et vérifier la clé étrangère de la table Salle de Réunion id_SR
         
         //pst.setInt(4, RoleDAO.GetIdRole(pers.getRole().getNom_role()));       
               
       int nbligne =  pst.executeUpdate();
    
    }
    
	public static void ModifEvent(Evenements event) throws SQLException, ClassNotFoundException {
		// Je me connecte
		Connection co = Connect.getInstance().getConnection();
System.out.println(event.getId_evt());
		// Création de la requête inserer new pers
		String requeteSQL = "UPDATE `evenement` SET `nomEvt`= ?,`jour`= ?,`type`= ?,`lieu`= ?,`id_SR`= ?";

		// préparer la requête
		PreparedStatement pst = co.prepareStatement(requeteSQL);

		// renvoyer et verifier les données de la requête
		pst.setString(1, event.getNomEvt());
		pst.setDate(2, event.getJour());
		pst.setString(3, event.getType());
		pst.setString(4, event.getLieu());
		//Recup�re et verif cl� etrang�re de la table Salle_Reunion
		pst.setInt(5, Salle_ReunionDAO.GetIdSR(event.getSalle().getNomSR()));


		int nbligne = pst.executeUpdate();

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
    
    public static ObservableList<Evenements> GetListeEvent() throws ClassNotFoundException, SQLException {
		ObservableList<Evenements> EvtList = FXCollections.observableArrayList();
		// constitution d'une commande bas�e sur une requ�te SQL
		// en vue d'�tre ex�cut�e sur une connexion donn�e
		String req = "select * from evenement";
		Connection cnx = Connect.getInstance().getConnection();
		//Integer id;
		String nomEvt;
		String type;
		Date jour;
		
		String lieu;
		int idSR;
	
		PreparedStatement pst = cnx.prepareStatement(req);

		ResultSet table = pst.executeQuery();
		while (table.next()) {
			
		//	id = table.getInt("id");
			nomEvt = table.getString("nomEvt");
			type = table.getString("type");
			jour = table.getDate("jour");
		
			lieu = table.getString("lieu");
			idSR = table.getInt("idSR");
		
			Evenements event = new Evenements();
			//event.setId_evt(id_evt);
			event.setNomEvt(nomEvt);
			event.setType(type);
			event.setJour(jour);
			//salle.setHoraire(horaire);
			event.setLieu(lieu);
			//Salle_Reunion salle = new Salle_Reunion();
			//salle.setIdSR(Salle_ReunionDAO.GetIdSR(nomSR));
			//salle.setNomSR(salle);
			
	

		}
		table.close();
		pst.close();
		cnx.close();
		return EvtList;
	}
    
}
