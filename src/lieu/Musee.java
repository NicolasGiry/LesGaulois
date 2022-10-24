package lieu;

import personnage.Trophee;
import personnage.Gaulois;
import personnage.Equipement;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement[] tropheesGaulois) {
		int i = 0;
		if (tropheesGaulois[i]!=null) {
			gaulois.parler("Je donne au musee tous mes trophees :");
			while (tropheesGaulois[i] != null) {
				trophees[nbTrophee] = new Trophee(gaulois, tropheesGaulois[i]);
				System.out.println("- "+tropheesGaulois[i].toString());
				nbTrophee ++;
				i++;
			}
		} else { 
			System.out.println("Oups, je n'ai pas de trophees...");
		}
	}

	public String extraireInstructionsCaml() {
		String contenuMusee = "";

		for (int i=0; i<trophees.length && trophees[i] != null ; i++) {
			contenuMusee += "＂" + trophees[i].donnerNom() + "＂, ＂" + trophees[i].getEquipement().toString() + "＂; \n";
		}

		return "let musee = [ \n" + contenuMusee.substring(0, contenuMusee.length()-3) + "\n]";
	}
}
