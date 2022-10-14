package lieu;
import personnage.Chef;
import personnage.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public int getNbVillageois() {
		return nbVillageois;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois ++;
		} else {
			System.out.println("Le village est plein, vous ne pouvez plus ajouter de gaulois");
		}
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef.getNom() + " vivent les légendaires gaulois :");
		for (int i=0; i<nbVillageois; i++) {
			System.out.println("-" + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		// renvoie une erreur car 30 est un indice en dehors du tableau villageois[]
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		// renvoie 'null' car il n'y a pas encore de gaulois dans la case 1 de villageois[]
		village.afficherVillageois();
	}
}
