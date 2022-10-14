package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0 : "la force doit être positive";
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "'' " + texte + "''");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force>0 : "précondition : force doit être positive";
		int forceDepart = force;
		force -= forceCoup;
		if (force > 0) {
		parler("Aïe");
		} else {
		parler("J'abandonne...");
		}
		assert forceDepart > force : "postcondition : la force doit diminuer";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Equipement bouclier = Equipement.BOUCLIER;
		Equipement casque = Equipement.CASQUE;
		
		minus.prendreParole();
		minus.parler("Bonjour ");
		minus.recevoirCoup(2);
		
		System.out.println(bouclier.toString() + " " + casque.toString());
	}
}