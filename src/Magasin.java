import java.util.ArrayList;

public class Magasin {
	
	private ArrayList<Article> stock = new ArrayList<Article>();
	
	public void ajoutMateriel(Article a) {
		stock.add(a); 
	}

	public static void main(String[] args) {
		Article a = new Article(1234, "bleu", "ts-34", 34, 45);
		TableAlite ta = new TableAlite(0, null, null, 0, 0, 0, null, false);
		ta.afficher();
		float res = ta.calculLoc(12);
		System.out.println(res);

	}

}
