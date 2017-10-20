package app;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import article.Article;
import article.FauteuilRoulant;
import article.LitMedicalise;
import article.MatelasAir;
import article.SouleveMalade;
import article.TableAlite;
import client.Client;
/**
 * Classe Vendeur
 * 
 * @author Thibault Beillevaire, Pierre Biermann
 * @version 1.0
 */

public class Vendeur {
	
	//méthode qui permet d'éffacer la console
	public static void clearScreen(){
        for(int clear = 0; clear < 1000; clear++) {
            System.out.println("\n") ;
        }
    }

    public static void main (String[]args) throws IOException, ParseException {
  
        //création du magasin
        Magasin m = new Magasin();
        
        //création de 3 clients
        Client c1 = new Client(1, "Dupont", "Jean", "5 rue des roses Nantes", 0210121314);
        Client c2 = new Client(2, "Delagare", "Patrick", "10 avenue atout sud Reze", 0210121315);
        Client c3 = new Client(3, "Courte", "Jason", "6 rue de la plage Sion", 0210121316);
        
        //création de 5 articles
        Article a1 = new MatelasAir(2369, "MatAir", "MA-85", 5, 3, "192x90x20", 150, 2);
        Article a2 = new SouleveMalade(4563, "SoulMa", "SM-25", 22, 2, 130, 45);
        Article a3 = new FauteuilRoulant(2789, "Roul-ant", "FR-105", 35, 8, 110, 85);
        Article a4 = new TableAlite(2585, "AlitTable", "TA-190", 10, 4, 150, "190x90x65", false);
        Article a5 = new LitMedicalise(9416, "DortBien", "LM-34", 80, 2, 180, "200x100x70", true);
        
        //ajout les articles au stock du magasin
        m.ajoutMateriel(a1);
        m.ajoutMateriel(a2);
        m.ajoutMateriel(a3);
        m.ajoutMateriel(a4);
        m.ajoutMateriel(a5);
        
        //création de 3 locations
        //location du client 1
        Location loc1 = new Location("10-10-2017", "16-10-2017", c1);
        //location du client 2
        Location loc2 = new Location("10-10-2017", "19-10-2017", c2);
        //location du client 3
        Location loc3 = new Location("02-11-2017", "28-11-2017", c3);
        
        //ajout d'article à la location 1
        loc1.ajoutArticle(a1);
        loc1.ajoutArticle(a2);
        loc1.ajoutArticle(a5);
        
        //ajout d'article à la location 2
        loc2.ajoutArticle(a4);
        loc2.ajoutArticle(a5);
        
        //ajout d'article à la location 3
        loc3.ajoutArticle(a3);
        

        boolean res = true;
        Scanner sc = new Scanner(System.in);
        while(res){
            System.out.println("________________________________________________");
            System.out.println("|                     Menu                     |");
            System.out.println("| Entrer le numeros correspondant :            |");
            System.out.println("| 1: Afficher l'ensemble des articles du stock |");
            System.out.println("| 2: Afficher les locations d'un client        |");
            System.out.println("| 3: Enregistrer les locations                 |");
            System.out.println("| 4: Archiver les locations dans un fichier    |");
            System.out.println("| 5: Calculer les recettes                     |");
            System.out.println("| 6: Test du code automatique                  |");
            System.out.println("| 7: Quitter l'application                     |");
            System.out.println("________________________________________________");

            int choix= sc.nextInt();
            if(choix < 1 || choix > 7 ){
                clearScreen();
                System.out.println("Vous vous êtes trompé");
            }
            switch(choix){
                case 1:
                    clearScreen();
                    System.out.println("_________________________________________");
                    System.out.println("| Veuillez choisir comment afficher     |" +
                                       "\n| l'ensemble des articles :             |");
                    System.out.println("\n| 1 : Reference                         | " +
                                       "\n| 2 : Marque                            | " +
                                       "\n| 3 : Modele                            | " +
                                       "\n| 4 : Prix par jour de location         |");
                    System.out.println("_________________________________________");
                    choix = sc.nextInt();

                    clearScreen();
                    m.afficheEnsArticle(choix);
                    break;

                case 2:
                		clearScreen();
                    m.getListeLoc().clear();
                    m.saveLoc(loc1);
                    m.saveLoc(loc2);
                    m.saveLoc(loc3);
                    System.out.print("Listes des clients louant actuellement : \n");
                    for (Location l : m.getListeLoc()) {
                            System.out.println("Prenom : " + l.getClient().getPrenom() + " | Nom : " + l.getClient().getNom());
                    }

                    System.out.println("\nEntrer le nom du client : ");
                    String nom = sc.next();
                    System.out.println("Entrer le prenom du client : ");
                    String prenom = sc.next();
                    m.afficheEnsLocClient(nom, prenom);
                    break;
                    
                case 3:
                		clearScreen();
                    m.saveLoc(loc1);
                    m.saveLoc(loc2);
                    m.saveLoc(loc3);
                    break;
                    
                case 4:
                    clearScreen();
                    m.archiveLoc();
                    break;
                    
                case 5:
                    clearScreen();
                    System.out.println("Veuillez ecrire les dates suivante de cette facon :" +
                            "\nJJ-MM-AAAA");
                    System.out.println("Entrer la date de debut : ");
                    String dateDebut = sc.next();
                    System.out.println("Entrer la date de fin : ");
                    String dateFin = sc.next();
                    m.calculRecette(dateDebut, dateFin);
                    break;
                    
                case 6:
                		clearScreen();
                		//sauvegarde des locations
                		m.saveLoc(loc1);
                    m.saveLoc(loc2);
                    m.saveLoc(loc3);
                    System.out.println("\n");
                    //affichage des article par références 
                    m.afficheEnsArticle(1);
                    System.out.println("\n");
                    //affichage des article par marque 
                    m.afficheEnsArticle(2);
                    System.out.println("\n");
                    //affichage des article par modele 
                    m.afficheEnsArticle(3);
                    System.out.println("\n");
                    //affichage des article par prix 
                    m.afficheEnsArticle(4);
                    System.out.println("\n");
                    //affichage des locations effectué par chaque client
                    m.afficheEnsLocClient("Dupont", "Jean");
                    System.out.println("\n");
                    m.afficheEnsLocClient("Delagare", "Patrick");
                    System.out.println("\n");
                    m.afficheEnsLocClient("Courte", "Jason");
                    System.out.println("\n");
                    //archivage des locations
                    m.archiveLoc();
                    System.out.println("\n");
                    //calcul de la rectte en le 10 et 19 octobre 2017
                    m.calculRecette("10-10-2017", "19-10-2017");
                    break;
                    
                case 7:
                		clearScreen();
                    System.out.println("---------------Fin du programme---------------");
                    res = false;
                    break;
            }
        }
    }
}
        