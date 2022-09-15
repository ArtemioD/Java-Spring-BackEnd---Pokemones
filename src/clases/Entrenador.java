package clases;

import java.util.ArrayList;

public class Entrenador {
	
	private String name;
	private ArrayList<Pokemon> pokebola;
	
	public Entrenador(String name, ArrayList<Pokemon> pokebola) {
		super();
		this.name = name;
		this.pokebola = pokebola;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Pokemon> getPokebola() {
		return pokebola;
	}
	
	public void setPokebola(ArrayList<Pokemon> pokebola) {
		this.pokebola = pokebola;
	}
	
	public void atraparPokemon(Pokemon pokemon) {
		pokebola.add(pokemon);
	}

	@Override
	public String toString() {
		return "Entrenador [name=" + name + ", pokebola=" + pokebola + "]";
	}	

}
