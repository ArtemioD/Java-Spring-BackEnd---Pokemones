package clases;

import java.util.ArrayList;

public class Pokemon {
	
	private String name;
	private ArrayList<Ataque> ataques;
	private int nivelAtaque = 0;
	
	public Pokemon(String name, ArrayList<Ataque> ataques) {
		this.name = name;
		this.ataques = ataques;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Ataque> getAtaques() {
		return ataques;
	}

	public void setAtaques(ArrayList<Ataque> ataques) {
		this.ataques = ataques;
	}

	public int getNivelAtaque() {
		return nivelAtaque;
	}
	
	public void setNivelAtaque(int nivelAtaque) {
		this.nivelAtaque = nivelAtaque;
	}

	public void aprenderAtaque(Ataque ataque) {	
		ataques.add(ataque);
		nivelAtaque += ataque.getPotencia();
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + 
				", ataques=" + ataques + 
				", nivelAtaque=" + nivelAtaque + "]";
	}	

}
