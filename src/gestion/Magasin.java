package gestion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import article.Article;
import article.MatelasAir;
import article.TableAlite;
import client.Client;
/**
 * Classe Magasin
 * 
 * @author Thibault Beillevaire, Pierre Biermann
 * @version 1.0
 */
public class Magasin {
	
	private ArrayList<Article> stock = new ArrayList<Article>();
	private ArrayList<Location> listeLoc = new ArrayList<Location>();
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat dateformatMY = new SimpleDateFormat("MM-yyyy");
	
	/**
	 * ajoute un article à la liste du stock du magasin
	 * @param a article à ajouter au stock du magasin
	 */
	public void ajoutMateriel(Article a) {
		
		stock.add(a); 
	}
	
	/**
	 * ajoute une location à la liste de location du magasin
	 * @param location location a ajouter à la liste 
	 */
	public void saveLoc(Location location){
		
		this.listeLoc.add(location);
		System.out.println("Location ajouter pour le client : " +location.getClient().getCoordonnesClient());
	}
	
	/**
	 * supprime un fichier d'archive de location
	 * @param f fichier de sauvegarde de type .loc
	 */
	public void removeLoc(File f){
		
		for (File c : f.listFiles()){
			c.delete();
		}
	}
	
	/**
	 * archive dans un fichier .loc les locations
	 * @throws IOException
	 */
	public void archiveLoc() throws IOException{
		
		new File("./archiveLoc/").mkdir();
		removeLoc(new File("./archiveLoc"));

		for (Location loc : this.listeLoc){
			PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter("./archiveLoc/" + dateformatMY.format(loc.getDateFin()) + ".loc", true)));
			pw.write("Coordonnées Client : " + loc.getClient().getCoordonnesClient());
			pw.write("\nDate Debut : " + dateformat.format(loc.getDateDebut()));
			pw.write("\nDate Fin : " + dateformat.format(loc.getDateFin()));
			pw.write("\nMontant a facturer : " + loc.calculMontantAFacturer() + " Euros");
			pw.write("\n\nArticle loué :");
			
			for (Article a : loc.getListeArticles()){
				pw.write("\n\nType d'article = "+ a.getClass().getName()+"\nMarque = " + a.getMarque() + "\nModele = " + a.getModele() + "\nReference = " + a.getReference() + "\nPrix Jour = " + a.getPrixJour());
			}
			pw.write("\n\n--------------------------------\n\n");
			pw.close();
			System.out.println("Archive enregistre : " + dateformatMY.format(loc.getDateFin()) + ".loc");
		}
	}
	
	/**
	 * calcule la recette du magasin sur une période donnée
	 * @param dateDebut date début de période
	 * @param dateFin date fin de période
	 * @throws ParseException
	 */
	public void calculRecette(String dateDebut, String dateFin) throws ParseException{
		
		double res = 0.0;
		for(int i = 0; i<listeLoc.size(); i++) {
			if (listeLoc.get(i).getDateDebut().compareTo(dateformat.parse(dateDebut)) >= 0 &&
				listeLoc.get(i).getDateFin().compareTo(dateformat.parse(dateFin)) <= 0) {
				res += listeLoc.get(i).calculMontantAFacturer();
			}
		}
		System.out.println("La recette comprise entre " + dateDebut + " et " + dateFin + " est de : " + res + " euros");
	}
	
	/**
	 * affiche l'ensemble des articles dans le stock du magasin
	 * il faut entrer en paramètre si l'on veut les afficher par référence ou par marque ou par modele
	 * ou par prix au jour
	 * @param choix int entre 1 et 4
	 */
	public void afficheEnsArticle(int choix){
		
		switch(choix) {
			case 1:
				for(Article a : stock){
					System.out.println("Reference de l'article : " + a.getReference());
				}
				break;
			case 2:
				for(Article a : stock){
					System.out.println("Marque de l'article : " + a.getMarque());
				}
				break;
			case 3:
				for(Article a : stock){
					System.out.println("Modele de l'article : " + a.getModele());
				}
				break;
			case 4:
				for(Article a : stock){
					System.out.println("Prix par jour de location de l'article : " + a.getPrixJour());
				}
			default: 
				System.out.println("Valeur souhaite non correcte ! \n Veuillez relancer la commande.");
				break;
			}
	}
	
	/**
	 * affiche les locations que le client passé en paramètre a effectué
	 * @param client client pour lequel on veut afficher ses locations
	 */
	public void afficheEnsLocClient(Client client){
		
		for (int i=0; i<listeLoc.size();i++){
			if (listeLoc.get(i).getClient()==client)
				System.out.println(listeLoc.get(i).afficheLocation());	
		}
	}
	

	public static void main(String[] args) throws ParseException, IOException {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy"); 
		
		Magasin m = new Magasin();
		Client cl = new Client(1, "Dupont", "Jean", "5 rue des roses Nantes", 0210121314);
		TableAlite ta = new TableAlite(2585, "AlitTable", "TA-190", 10, 4, 150, "190x90x65", false);
		MatelasAir ma = new MatelasAir(2369, "MatAir", "MA-85", 5, 3, "192x90x20", 150, 2);
		
		m.ajoutMateriel(ta);
		m.ajoutMateriel(ma);
		m.afficheEnsArticle(2);
		
		
		Location l1 = new Location(date.parse("10-10-2017"),date.parse("13-10-2017"),cl);
		l1.ajoutArticle(ta);
		
		Location l2 = new Location(date.parse("15-10-2017"),date.parse("18-10-2017"),cl);
		l2.ajoutArticle(ma);
		
		m.saveLoc(l1);
		m.saveLoc(l2);
		//m.archiveLoc();
		
		m.calculRecette("10-10-2017", "18-10-2017");
		
		m.afficheEnsLocClient(cl);

	}

}
