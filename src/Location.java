import java.util.ArrayList;
import java.util.Date;

public class Location {
		
	ArrayList<Article> listeArticles;
	Date dateDebut;
	Date dateFin;
	Client client;
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
	
	public int getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(int montantFacture) {
		this.montantFacture = montantFacture;
	}
	//Contructeur 
	public Location(ArrayList<Article> listeArticles, Date dateDebut, Date dateFin, Client c) {
		this.listeArticles = listeArticles;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = c;
		this.montantFacture = 0;
	}
	
	public long dureeLocation(){
		long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24; 
		long diff = Math.abs(dateDebut.getTime() - dateFin.getTime()); 
		long result = diff/CONST_DURATION_OF_DAY;
		return result;
	}
	
	public void calculMontantAFacturer(){ 
		for(Article a : listeArticles){
			this.montantFacture += a.calculLoc((int) dureeLocation());
		}
	}
	
	@Override
	public String toString() {
		return "Location [listeArticles=" + listeArticles + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", coordonneesClient=" + client.getCoordonnesClient() + ", montantFacture=" + montantFacture + "]";
	}
}
