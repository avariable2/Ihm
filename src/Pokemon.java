public class Pokemon {
	private String type;
	private String nom;

	public Pokemon(String unNom) {
		this.nom = unNom;
	}

	public Pokemon(String unNom, String type) {
		this.nom = unNom;
		this.type = type;
	}

	public Pokemon() {
	}

	// Accesseurs
	/**
	 * @return retourne le type du Pokemon
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Permet d'initialiser le nom du Pokemon
	 * 
	 * @param uneEspece
	 */
	public void setType(String unType) {
		this.type = unType;
	}

	/**
	 * @return retourne le nom du Pokemon
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Permet d'initialiser le nom du Pokemon
	 * 
	 * @param unNom
	 */
	public void setNom(String unNom) {
		this.nom = unNom;
	}

	// Methodes

	/**
	 * Renvoie tout en chaine de caractère
	 */
	public String toString() {
		String chaine = "Nom : " + this.nom + "\n";
		if (this.type != null) {
			chaine = chaine + "Type : " + this.type;
		}
		return chaine;
	}
}