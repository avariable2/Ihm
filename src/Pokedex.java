import java.util.ArrayList;

public class Pokedex {
	// Propriétés
	private ArrayList<Pokemon> listePokemon;

	// Constructeur, Initialise une nouvelle instance de la classe Pokedex
	public Pokedex() {
		this.listePokemon = new ArrayList<Pokemon>();
	}

	// Accesseurs
	public int getNombreAnimaux() {
		return this.listePokemon.size();
	}

	// Methode presentation des Pokemons
	public String presente() {
		String chaine = "** PRESENTATION DES POKEBALLS **\n";
		if (this.listePokemon.size() == 0) {
			chaine += "\nLe pokedex ne possède aucun Pokemon.";
		} else {
			for (int i = 0; i < this.listePokemon.size(); i++) {
				chaine += "\n" + this.listePokemon.get(i).toString();
			}
		}
		return chaine;
	}

	// Methode recherche Pokemon
	public Pokemon recherche(String unPokemon) {
		int i = 0;
		Pokemon rep = null;
		while (i < listePokemon.size()
				&& unPokemon.equals(this.listePokemon.get(i).getNom())) {
			i++;
		}
		if (i < listePokemon.size()) {
			rep = this.listePokemon.get(i);
		}
		return rep;
	}

	// Methode ajout Pokemon
	public void arriver(String rep1, String rep2) {
		Pokemon unPokemon = new Pokemon(rep1, rep2);
		this.listePokemon.add(unPokemon);
	}

	// Methode supprimer un pokemon
	public String partir(String nomAnimal) {
		Pokemon rep = recherche(nomAnimal);
		String reponse;
		if (this.listePokemon.contains(rep)) {
			this.listePokemon.remove(rep);
			reponse = "Le Pokemon a été supprimé ! ";
		} else
			reponse = "Ce Pokemon n'existe pas !";
		return reponse;

	}
}