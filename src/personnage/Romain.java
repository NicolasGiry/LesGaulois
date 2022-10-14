package personnage;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0 : "la force doit �tre positive";
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
		assert force>0 : "pr�condition : force doit �tre positive";
		int forceDepart = force;
		force -= forceCoup;
		if (force > 0) {
		parler("A�e");
		} else {
		parler("J'abandonne...");
		}
		assert forceDepart > force : "postcondition : la force doit diminuer";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
		minus.prendreParole();
		minus.parler("Bonjour ");
		minus.recevoirCoup(2);
	}
}