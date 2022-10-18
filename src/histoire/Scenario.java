package histoire;

import personnage.Gaulois;
import personnage.Romain;
import personnage.Druide;
import personnage.Equipement;

public class Scenario {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 100);
		Romain minus = new Romain("Minus", 5);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);

		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		while (minus.getForce() > 0)
		{
			asterix.frapper(minus);
		}
	}
}
