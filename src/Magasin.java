import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Magasin {
	
	private ArrayList<Article> stock = new ArrayList<Article>();
	private ArrayList<Location> listeLoc = new ArrayList<Location>();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public void ajoutMateriel(Article a) {
		stock.add(a); 
	}
	
	public void saveLoc(Location location){
		this.listeLoc.add(location);
		System.out.println("Location ajouter pour le client : " +location.client.getCoordonnesClient());
	}
	
	public void removeLoc(File f){
		for (File c : f.listFiles()){
			c.delete();
		}
	}
	
	public void archiveLoc() throws IOException{
		new File("./archiveLoc/").mkdir();
		removeLoc(new File("./archiveLoc"));

		for (Location loc : this.listeLoc){
			
			PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter("./archiveLoc/" + format.format(loc.getDateFin()) + ".loc", true)));
			pw.write("Coordonnées Client : " + loc.client.getCoordonnesClient());
			pw.write("\nDate Debut : " + loc.getDateDebut());
			pw.write("\nDate Fin : " + loc.getDateFin());
			pw.write("\nMontant a facturer : //" + loc.montantFacture + "//");
			pw.write("\n\nArticle loué :");
			
			for (Article a : loc.getListeArticles()){
				pw.write("\n\nType d'article = "+ a.getClass().getName()+"\nMarque = " + a.getMarque() + "\nModele = " + a.getModele() + "\nReference = " + a.getReference() + "\nPrix Jour = " + a.getPrixJour());

			}
			pw.write("\n\n--------------------------------\n\n");
			
			pw.close();
			System.out.println("Archive done : " + format.format(loc.getDateFin()) + ".loc");
		}
	}
	
	public void calculRecette(String dateDebut, String dateFin) throws ParseException{
		double res = 0.0;
		for(int i = 0; i<listeLoc.size(); i++) {
			listeLoc.get(i).calculMontantAFacturer();
			
			if (listeLoc.get(i).getDateDebut().compareTo(format.parse(dateDebut)) >= 0 &&
				listeLoc.get(i).getDateFin().compareTo(format.parse(dateFin)) <= 0) 
				res += listeLoc.get(i).getMontantFacture();
		}
		System.out.println("La recette comprise entre " + dateDebut + " et " + dateFin + " est de : " + res);
	}
	
	public void afficheEnsArticle(int ref_mar_mod_ppj){
		
		if (ref_mar_mod_ppj == 1){
			for(Article a : stock){
				System.out.println("Reference de l'article : " + a.getReference());
			}
		} else if (ref_mar_mod_ppj == 2){
			for(Article a : stock){
				System.out.println("Marque de l'article : " + a.getMarque());
			}
		} else if (ref_mar_mod_ppj == 3){
			for(Article a : stock){
				System.out.println("Modele de l'article : " + a.getModele());
			}
		} else if (ref_mar_mod_ppj == 4){
			for(Article a : stock){
				System.out.println("Prix par jour de location de l'article : " + a.getPrixJour());
			}
		} else {
			System.out.println("Valeur souhaite non correcte ! \n Veuillez relancer la commande.");
		}
	}
	

	public static void main(String[] args) {
		Article a = new Article(1234, "bleu", "ts-34", 34, 45);
		TableAlite ta = new TableAlite(0, null, null, 0, 0, 0, null, false);
		Magasin m = new Magasin();
		m.ajoutMateriel(a);
		m.afficheEnsArticle(2);

	}

}
