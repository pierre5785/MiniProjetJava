package article;
/**
 * Classe TableAlite
 * 
 * @author Thibault Beillevaire, Pierre Biermann
 * @version 1.0
 */
public class TableAlite extends MobilierMedical {
	
	//Attributs
	private boolean plateauIncli;
	
	//Constructeur
	public TableAlite(int reference, String marque, String modele, int prixJour, int nbStock, int poidMaxAdm,
			String dimension, boolean plateauIncli) {
		super(reference, marque, modele, prixJour, nbStock, poidMaxAdm, dimension);
		this.plateauIncli = plateauIncli;
	}
	
	//Accesseurs
	public boolean isPlateauIncli() {
		return plateauIncli;
	}

	public void setPlateauIncli(boolean plateauIncli) {
		this.plateauIncli = plateauIncli;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Plateau inclinable : "+this.plateauIncli);
	}
	
	

}
