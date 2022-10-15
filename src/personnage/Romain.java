package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
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

	private void  ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement ++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString());
	}

	public void sEquiper (Equipement equipement) {

		switch (nbEquipement) {
			case 2:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1:
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " porte déjà un " + equipement.toString());
				} else {
					ajouterEquipement(equipement);
				}
				break;
			case 0:
				ajouterEquipement(equipement);
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Equipement bouclier = Equipement.BOUCLIER;
		Equipement casque = Equipement.CASQUE;
		
		minus.prendreParole();
		minus.parler("Bonjour ");
		minus.recevoirCoup(2);
		
		System.out.println(bouclier.toString() + " " + casque.toString());

		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);
	}
}