
public class Joueur {
	private final String pseudo;
	private final Couleur couleurPion;
	
	public Couleur couleurDuJoueur() {
		return couleurPion;
	}

	public Joueur(String Pseudo, Couleur coulPion) {
		pseudo = Pseudo;
		couleurPion = coulPion;
	}
	
	
	public String getPseudo() {
		return pseudo;
	}
	}
