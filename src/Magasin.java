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
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat dateformatMY = new SimpleDateFormat("MM-yyyy");
	
	public void ajoutMateriel(Article a) {
		stock.add(a); 
	}
	
	public void saveLoc(Location location){
		this.listeLoc.add(location);
		System.out.println("Location ajouter pour le client : " +location.getClient().getCoordonnesClient());
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
			
			PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter("./archiveLoc/" + dateformatMY.format(loc.getDateFin()) + ".loc", true)));
			pw.write("Coordonnées Client : " + loc.getClient().getCoordonnesClient());
			pw.write("\nDate Debut : " + dateformat.format(loc.getDateDebut()));
			pw.write("\nDate Fin : " + dateformat.format(loc.getDateFin()));
			pw.write("\nMontant a facturer : " + loc.calculMontantAFacturer() + " Euros");
			pw.write("\n\nArticle loué :");
			
			for (Article a : loc.getListeArticles()){
				pw.write("\n\nType d'article = "+ a.getClass().getName()+"\nMarque = " + a.getMarque() + "\nModele = " + a.getModele() + "\nReference = " + a.getReference() + "\nPrix Jour = " + a.getPrixJour());

			}
			pw.write("\n\n--------------------------------\n\n");
			
			pw.close();
			System.out.println("Archive enregistre : " + dateformatMY.format(loc.getDateFin()) + ".loc");
		}
	}
	
	public void calculRecette(String dateDebut, String dateFin) throws ParseException{
		double res = 0.0;
		for(int i = 0; i<listeLoc.size(); i++) {
			listeLoc.get(i).calculMontantAFacturer();
			
			if (listeLoc.get(i).getDateDebut().compareTo(dateformat.parse(dateDebut)) >= 0 &&
				listeLoc.get(i).getDateFin().compareTo(dateformat.parse(dateFin)) <= 0) 
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
	
	public void afficheEnsLocClient(Client client){
		for (Location loc : this.listeLoc){
			if (loc.getClient()==client)
				System.out.println(loc);
			
			
		}
	}
	

	public static void main(String[] args) throws ParseException, IOException {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy"); 
		
		Magasin m = new Magasin();
		Client cl = new Client(1, "Dupont", "Jean", "5 rue des roses Nantes", 0210121314);
		TableAlite ta = new TableAlite(2585, "AlitTable", "TA-190", 10, 4, 150, "190x90x65", false);
		MatelasAir ma = new MatelasAir(2369, "MatAir", "MA-85", 5, 3, "192x90x20", 150, 2);
		
		m.ajoutMateriel(ta);
		m.ajoutMateriel(ma);
		m.afficheEnsArticle(2);
		
		
		Location l1 = new Location(date.parse("10-10-2017"),date.parse("13-10-2017"),cl);
		l1.ajoutArticle(ta);
		
		Location l2 = new Location(date.parse("15-10-2017"),date.parse("18-10-2017"),cl);
		l2.ajoutArticle(ma);
		
		m.saveLoc(l1);
		m.saveLoc(l2);
		m.archiveLoc();
		
		m.calculRecette("10-10-2017", "13-10-2017");
		
		m.afficheEnsLocClient(cl);

	}

}
