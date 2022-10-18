package personnage;

public class Romain {
	private String nom;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0 : "la force doit etre positive";
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert force>0 : "precondition : force doit etre positive";
//		int forceDepart = force;
//		force -= forceCoup;
//		if (force > 0) {
//		parler("Aie");
//		} else {
//		parler("J'abandonne...");
//		}
//		assert forceDepart > force : "postcondition : la force doit diminuer";
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
//		if (forceCoup > 0) {
//			force -= forceCoup;
//		} else {
//			force += forceCoup;
//		}
		
		force -= forceCoup;
		
		if (force > 0) {
				parler("Aie");
		} else {
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
		}
		// post condition la force a diminue
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace a mon equipement sa force est diminue de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					if (equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					} else {
					// System.out.println("Equipement casque");
					resistanceEquipement += 5;
					}
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		
		if ( forceCoup < 0 ) {
			forceCoup = 0;
		}
		
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L' quipement de " + nom.toString() + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	private void texteEquipementSoldat(String texte) {
		System.out.println("Le soldat" + nom + texte);
	}
		
	private void  ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement ++;
		texteEquipementSoldat(" s'equipe avec un " + equipement.toString());
	}

	public void sEquiper (Equipement equipement) {
		switch (nbEquipement) {
			case 0:
				ajouterEquipement(equipement);
				break;
			case 1:
				if (equipements[0] == equipement) {
					texteEquipementSoldat(" porte deja un " + equipement.toString());
				} else {
					ajouterEquipement(equipement);
				}
				break;
			case 2:
				texteEquipementSoldat(" est deja bien protege !");
				break;
			
			
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