
public class Article {
	
	//Attributs
	protected int reference;
	protected String marque;
	protected String modele;
	protected int prixJour;
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

	public int getPrixJour() {
		return prixJour;
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
				"Marque : "+this.marque+
				"Modele : "+this.modele+
				"Prix/Jour : "+this.prixJour+
				"Nombre en stock : "+this.nbStock);
	}
	
	public float calculLoc(int nbJour){
		return this.prixJour*nbJour;
	}
	
	
	
	
	
	
	
	
	

}
