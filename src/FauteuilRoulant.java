
public class FauteuilRoulant extends Article {
	
	//Attributs
	private int largeurAss;
	private float poid;
	
	//Constructeur
	public FauteuilRoulant(int reference, String marque, String modele, int prixJour, int nbStock, int largeurAss,
			float poid) {
		super(reference, marque, modele, prixJour, nbStock);
		this.largeurAss = largeurAss;
		this.poid = poid;
	}

	//Accesseurs
	public int getLargeurAss() {
		return largeurAss;
	}

	public void setLargeurAss(int largeurAss) {
		this.largeurAss = largeurAss;
	}

	public float getPoid() {
		return poid;
	}

	public void setPoid(float poid) {
		this.poid = poid;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Largeur d'assise : "+this.largeurAss+
						   "\nPoids de la chaise : "+this.poid);
	}
	
	
	

}
