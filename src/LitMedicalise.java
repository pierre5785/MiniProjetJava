
public class LitMedicalise extends MobilierMedical {
	
	//Attributs
	private boolean potence;
	
	//Constructeur
	public LitMedicalise(int reference, String marque, String modele, int prixJour, int nbStock, int poidMaxAdm,
			String dimension, boolean potence) {
		super(reference, marque, modele, prixJour, nbStock, poidMaxAdm, dimension);
		this.potence = potence;
	}
	
	//Accesseurs
	public boolean isPotence() {
		return potence;
	}

	public void setPotence(boolean potence) {
		this.potence = potence;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Potence : "+this.potence);
	}
	
	

}
