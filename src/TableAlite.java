
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

}
