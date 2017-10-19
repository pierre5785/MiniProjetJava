package article;
/**
 * Classe Article
 * 
 * @author Thibault Beillevaire, Pierre Biermann
 * @version 1.0
 */
public class Article {
	
	//Attributs
	protected int reference;
	protected String marque;
	protected String modele;
	protected float prixJour;
	protected int nbStock;
	
	//Constructeur
	public Article(int reference, String marque, String modele, int prixJour, int nbStock) {
		this.reference = reference;
		this.marque = marque;
		this.modele = modele;
		this.prixJour = prixJour;
		this.nbStock = nbStock;
	}

	//Accesseurs
	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public float getPrixJour() {
		return this.prixJour;
	}

	public void setPrixJour(int prixJour) {
		this.prixJour = prixJour;
	}

	public int getNbStock() {
		return nbStock;
	}

	public void setNbStock(int nbStock) {
		this.nbStock = nbStock;
	}
	
	public void afficher(){
		System.out.println(
				"Reference : "+this.reference+
				"\nMarque : "+this.marque+
				"\nModele : "+this.modele+
				"\nPrix/Jour : "+this.prixJour+
				"\nNombre en stock : "+this.nbStock);
	}
	
	//methode qui calcule le prix de la location de l'article en fonction du nombre de jour 
	public float calculLoc(int nbJour){
		return this.prixJour*nbJour;
	}
	
	
	
	
	
	
	
	
	

}
