package article;
/**
 * Classe MatelasAir
 * 
 * @author Thibault Beillevaire, Pierre Biermann
 * @version 1.0
 */
public class MatelasAir extends Article {
	
	//Attributs
	private String dimension;
	private int poidMax;
	private int tempsGonfl;
	
	//Constructeur
	public MatelasAir(int reference, String marque, String modele, int prixJour, int nbStock, String dimension,
			int poidMax, int tempsGonfl) {
		super(reference, marque, modele, prixJour, nbStock);
		this.dimension = dimension;
		this.poidMax = poidMax;
		this.tempsGonfl = tempsGonfl;
	}

	//Accesseurs
	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public int getPoidMax() {
		return poidMax;
	}

	public void setPoidMax(int poidMax) {
		this.poidMax = poidMax;
	}

	public int getTempsGonfl() {
		return tempsGonfl;
	}

	public void setTempsGonfl(int tempsGonfl) {
		this.tempsGonfl = tempsGonfl;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Dimensions : "+this.dimension+
						   "\nPoids max : "+this.poidMax+
						   "\nTemps de gonflage : "+this.tempsGonfl);
	}
	
	
	

}
