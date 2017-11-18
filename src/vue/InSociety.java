
package vue;


public class InSociety {


   /* public static void main(String[] args) {      
        try {
         
             
            
            //Créer une personne, l'ajouter la supprimer, la modifier
        	//Initialisation des rôles, service, date
            Role role = new Role();
            role.setNom_role("Directeur");
            Service service = new Service();
            service.setType_service(   "Dirigeant");
            Statut statut = new Statut();
            statut.setLibeller("hors_ligne");
            LocalDate date = LocalDate.of(1976, 04, 11);
            
            //Création personne 1
            Personnel pers1 = new Personnel();
            pers1.setNom("Picard");
            pers1.setPrenom("Jean-David");
            pers1.setAdresse("128 Allée des Champs Elysées");
            pers1.setMail(pers1.getLogin()+"@inSociety.com");
            pers1.setTel("01 60 79 18 81");
            pers1.setRole(role);
            pers1.setService(service);
            pers1.setStatut(statut);
            pers1.setLogin(pers1.getPrenom().substring(0,1)+""+pers1.getNom());
            pers1.setDate_naissance(date);
            pers1.setLocalisation("91000 - Evry");
            
           	//Initialisation des rôles, service, date
            Role role1 = new Role();
            role1.setNom_role("Responsable");
            Service service1 = new Service();
            service1.setType_service(   "Informatique");
            Statut statut1 = new Statut();
            statut1.setLibeller("hors_ligne");
            LocalDate date1 = LocalDate.of(1991, 12, 14);
            
            
            //Création personne 2 = Responsable informatique (admin)
            Personnel pers2 = new Personnel();
            pers2.setNom("Coco");
            pers2.setPrenom("Marie-Ange");
            pers2.setAdresse("105 route de la ferté alais");
            pers2.setMail(pers2.getLogin()+"@inSociety.com");
            pers2.setTel("06 50 30 79 98");
            pers2.setRole(role1);
            pers2.setService(service1);
            pers2.setStatut(statut1);
            pers2.setLogin("admin_"+pers2.getPrenom().substring(0,1)+""+pers2.getNom().substring(0,1));
            pers2.setDate_naissance(date1);
            pers2.setLocalisation("91590 Guigneville sur Essonne");
            
            //personnel.setPers1("Picard", "Jean-David", adresse, mail, "01 60 79 18 81", role, statut, login, date, "Evry");
            /*Données = `nom`, `prenom`, `adresse`, `mail`, `Tel`,`id_role`, `id_service`, `id_statut`, `login`, `date_naissance`, `localisation`
            PersonnelDAO.insertPers(pers1);
         //   PersonnelDAO.SuppPers(pers1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InSociety.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //CrÃ©er un Ã©vÃ¨nements 
        //Evenements even1 = new Evenements ("Carrote",date,type,lieu,salle);
        
        
    }
    */
}
