package personnage;
import lieu.Musee;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'' " + texte + " ''");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de "
//		+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		Equipement[] tropheesTemp = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesTemp != null && i < tropheesTemp.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesTemp[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois decuple.");
	}
	
	public void faireUneDonation(Musee musee) {
		musee.donnerTrophees(this, trophees);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
		+ ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus = new Romain("Minus", 3);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		System.out.println(asterix.getNom());
		
		System.out.println(asterix);
		
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour");
		asterix.frapper(minus);

		panoramix.preparerPotion();
		asterix.boirePotion(panoramix.getForcePotion());
	}
}
