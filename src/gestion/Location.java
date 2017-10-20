package gestion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import article.Article;
import client.Client;
/**
 * Classe Location
 * 
 * @author Thibault Beillevaire, Pierre Biermann
 * @version 1.0
 */
public class Location {
		
	private ArrayList<Article> listeArticles;
	private Date dateDebut;
	private Date dateFin;
	private Client client;
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	
	//Acesseur
	/**
	 * Getter de l'attribut this.client
	 * @return this.client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * Setter de l'attribut this.client
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * Getter de l'attribut this.listeArticles
	 * @return this.listeArticles
	 */
	public ArrayList<Article> getListeArticles() {
		return this.listeArticles;
	}
	/**
	 * Setter de l'attribut this.listeArticles
	 * @param listeArticles
	 */
	public void setListeArticles(ArrayList<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}
	/**
	 * Getter de l'attribut this.dateDebut
	 * @return this.dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}
	/**
	 * Setter de l'attribut this.dateDebut
	 * @param dateDebut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * Getter de l'attribut this.dateFin
	 * @return this.dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}
	/**
	 * Setter de l'attribut this.dateFin
	 * @param dateFin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	 
	/**
	 * Constructeur
	 * @param dateDebut
	 * @param dateFin
	 * @param c
	 * 
	 * Construit une nouvelle location
	 */
	public Location(Date dateDebut, Date dateFin, Client c) {
		this.listeArticles = new ArrayList<Article>();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = c;
	}
	
	/**
	 * ajoute un article à la liste d'article de la location
	 * @param a article a ajouter a la liste
	 */
	public void ajoutArticle(Article a) {
		this.listeArticles.add(a); 
	}
	
	/**
	 * convertie la date de début et de fin pour retourner le nombre de jour
	 * @return durée de la location en jour
	 */
	public long dureeLocation(){
		long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24; 
		long diff = Math.abs(dateDebut.getTime() - dateFin.getTime()); 
		long result = diff/CONST_DURATION_OF_DAY;
		return result;
	}
	
	
	/**
	 * calcul du montant total à facturer pour la location courante
	 * @return montant total de la location
	 */
	public double calculMontantAFacturer(){
		double total = 0;
		for(Article a : listeArticles){
			total += a.calculLoc((int) dureeLocation());
		}
		return total;
	}
	
	/**
	 * affiche les informations de la location (liste des article, date début et fin, cordonnées client) 
	 * et le montant de la facture  
	 * @return string qui contient toutes les informations de la location 
	 */
	public String afficheLocation() {
		return "Location"+ 
				"\n listeArticles: " + listeArticles + 
				"\n dateDebut: " + dateformat.format(dateDebut) + 
				"\n dateFin: " + dateformat.format(dateFin) +
				"\n coordonneesClient:  " + client.getCoordonnesClient() + 
				"\n montantFacture: " + this.calculMontantAFacturer();
	}
}
