package histoire;

import personnage.Gaulois;
import personnage.Romain;

public class Scenario {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 5);
		
		asterix.parler("Bonjour à tous !");
		minus.parler("UN GAU... UN GAUGAU...");
		while (minus.getForce() > 0)
		{
			asterix.frapper(minus);
		}
	}
}
