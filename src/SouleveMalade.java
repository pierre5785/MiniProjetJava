
public class SouleveMalade extends Article {
	
	//Attributs
	private int capaLev;
	private int degrePiv;
	
	//Constructeur
	public SouleveMalade(int reference, String marque, String modele, int prixJour, int nbStock, int capaLev,
			int degrePiv) {
		super(reference, marque, modele, prixJour, nbStock);
		this.capaLev = capaLev;
		this.degrePiv = degrePiv;
	}
	
	//Accesseurs
	public int getCapaLev() {
		return capaLev;
	}

	public void setCapaLev(int capaLev) {
		this.capaLev = capaLev;
	}

	public int getDegrePiv() {
		return degrePiv;
	}

	public void setDegrePiv(int degrePiv) {
		this.degrePiv = degrePiv;
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Capacité de levage : "+this.capaLev+
						   "\nDegré de pivottement : "+this.degrePiv);
	}
	
	
	

}
