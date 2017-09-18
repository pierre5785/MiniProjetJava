
public class MobilierMedical extends Article {
	
	//Attributs
	protected int poidMaxAdm;
	protected String dimension;
	
	//Constructeur
	public MobilierMedical(int reference, String marque, String modele, int prixJour, int nbStock, int poidMaxAdm,
			String dimension) {
		super(reference, marque, modele, prixJour, nbStock);
		this.poidMaxAdm = poidMaxAdm;
		this.dimension = dimension;
	}

	//Accesseurs
	public int getPoidMaxAdm() {
		return poidMaxAdm;
	}

	public void setPoidMaxAdm(int poidMaxAdm) {
		this.poidMaxAdm = poidMaxAdm;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

}
