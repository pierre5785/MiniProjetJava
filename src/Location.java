import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private double montantFacture;
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	
	//Acesseur
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}
	
	public ArrayList<Article> getListeArticles() {
		return listeArticles;
	}
	public void setListeArticles(ArrayList<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public double getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(int montantFacture) {
		this.montantFacture = montantFacture;
	}
	//Contructeur 
	public Location(Date dateDebut, Date dateFin, Client c) {
		this.listeArticles = new ArrayList<Article>();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = c;
		this.montantFacture = 0;
	}
	
	//methode qui ajoute un article a la liste d'article de la location
	public void ajoutArticle(Article a) {
		this.listeArticles.add(a); 
	}
	
	//methode qui convertie la date de debut et de fin pour retourner le nombre de jour
	public long dureeLocation(){
		long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24; 
		long diff = Math.abs(dateDebut.getTime() - dateFin.getTime()); 
		long result = diff/CONST_DURATION_OF_DAY;
		return result;
	}
	
	//calcul du montant total a facturer pour la location courante 
	public double calculMontantAFacturer(){ 
		for(Article a : listeArticles){
			this.montantFacture += a.calculLoc((int) dureeLocation());
		}
		return this.getMontantFacture();
	}
	
	@Override
	public String toString() {
		return "Location"+ 
				"\n listeArticles: " + listeArticles + 
				"\n dateDebut: " + dateformat.format(dateDebut) + 
				"\n dateFin: " + dateformat.format(dateFin) +
				"\n coordonneesClient:  " + client.getCoordonnesClient() + 
				"\n montantFacture: " + montantFacture + "]";
	}
}
