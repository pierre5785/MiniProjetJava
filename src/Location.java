import java.util.ArrayList;
import java.util.Date;

public class Location {
		
	ArrayList<Article> listeArticles;
	Date dateDebut;
	Date dateFin;
	String coordonneesClient;
	int montantFacture;
	
	//Acesseur
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
	public String getCoordonneesClient() {
		return coordonneesClient;
	}
	public void setCoordonneesClient(String coordonneesClient) {
		this.coordonneesClient = coordonneesClient;
	}
	public int getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(int montantFacture) {
		this.montantFacture = montantFacture;
	}
	//Contructeur 
	public Location(ArrayList<Article> listeArticles, Date dateDebut, Date dateFin, String coordonneesClient,
			int montantFacture) {
		this.listeArticles = listeArticles;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.coordonneesClient = coordonneesClient;
		this.montantFacture = montantFacture;
	}
	public void saveLoc(){
		
	}
	public void removeLoc(){
		
	}
	public void louer(){
		
	}
	@Override
	public String toString() {
		return "Location [listeArticles=" + listeArticles + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", coordonneesClient=" + coordonneesClient + ", montantFacture=" + montantFacture + "]";
	}
	public void archiverLoc(){
		
	}
}
