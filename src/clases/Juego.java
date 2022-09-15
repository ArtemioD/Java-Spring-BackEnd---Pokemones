package clases;

import java.util.ArrayList;
import java.util.Scanner;


public class Juego {
	private Entrenador entrenador;
	private ArrayList<Pokemon> pokemones = new ArrayList<>();
	private Scanner entry = new Scanner(System.in);
	
	public Juego() {	
		pokemonesList();
		start();
		text("Fin del juego...");
	}
	
	/*** 
	 * Add the pokemons to arrayList
	 * 
	 * @return
	 */
	private ArrayList<Pokemon> pokemonesList() {
		pokemones.add(new Pokemon("Charizard", new ArrayList<Ataque>()));
		pokemones.add(new Pokemon("Pikachu", new ArrayList<Ataque>()));
		pokemones.add(new Pokemon("Psyduck", new ArrayList<Ataque>()));
		return pokemones;
	}
	
	/***
	 *  start the game
	 */
	private void start() {
		entrenador = welcome();
		entrenador.atraparPokemon(pokemonAppears());	
		menu();
		System.out.println(entrenador);
	}
	
	/***
	 * Pedimos el nombre por consola,
	 * Instanciamos objeto Entrenador y devolvemos
	 * 
	 * @return
	 */
	private Entrenador welcome() {
		text("*** Bienvenidos ***");
		text("Por favor ingrese su nombre...");
		String name = entry();
		text("Muy bien " + name + " ya empieza el juego");
		return new Entrenador(name, new ArrayList<>());
	}
	
	/***
	 * Menu con opciones cuando aparece un pokemon
	 * 
	 * @return
	 */
	private Pokemon pokemonAppears() {
		boolean flag = true;
		Pokemon poke = null;
		
		text("Atencion " + entrenador.getName() + "!! Aparece un pokemon...");
		while (flag) {			
			text("Que vas hacer ?");
			text("1. Salir corriendo!");
			text("2. Atrapar al pokemon..");
			
			String option = entry();
			
			if (option.equals("1"))
				text("ATENCION " + entrenador.getName() + ", Aparece un pokemon"); 
			else if (option.equals("2")) {
				int i = random();
				poke = pokemones.get(i);
				text(pokemones.get(i).getName() + " atrapado. Felicitaciones!!\n");
				pokemones.remove(i);
				flag = false;
			} else 
				text("Error! Opcion incorrecta, intenta otra vez!\n");		
		}
		return poke;		 
	}
	
	/***
	 * Menu con opciones cuando por lo menos
	 * hay un pokemon atrapado
	*/
	private void menu() {	
		boolean flag = true;
		while (flag) {
			text("Que queres hacer ahora:");
			text("1. Salir del Juego");
			text("2. Entrenar al pokemon");
			if (pokemones.size() != 0)
				text("3. Buscar a otro pokemon");
			
			String scanner = entry();
			
			if (scanner.equals("2")) 
				trainPokemon();
			else if (scanner.equals("3") && pokemones.size() != 0) 
				entrenador.atraparPokemon(pokemonAppears());
			else if (scanner.equals("1")) 
				break;
			else 
				text("Error! Opcion incorrecta, intenta otra vez!\n");
		}
				
	}
	
	/***
	 * Menu con opciones para elegir al pokemon
	 * que queremos a etrenar 
	 */
	private void trainPokemon() {
		text("Que pokemon queres a entrenar..");
		for (int i = 0; i < entrenador.getPokebola().size(); i++) {
			text(i + 1 + ". " + entrenador.getPokebola().get(i).getName());
		}
		boolean flag = true;
		while (flag) {
			String options = entry();
			for (int i = 0; i < entrenador.getPokebola().size(); i++) {
				String a = "" + (i + 1);
				if(options.equals(a)) {
					learnAttack(i);
					flag = false;
					break;
				}
			}	
		}
	}
	
	/***
	 * Depende del pokemon aprende los ataques
	 * 
	 * @param i
	 */
	private void learnAttack(int i) {
		String name = entrenador.getPokebola().get(i).getName();
		ArrayList<Ataque> ataques = entrenador.getPokebola().get(i).getAtaques();
		int level = entrenador.getPokebola().get(i).getNivelAtaque();
		switch (name) {
		case "Psyduck":
			text(name + " es un pokemon de agua y no tiene ataques.");
			text("El nivel de ataque es: " + level);
			break;
		case "Charizard":
			if (ataques.size() < 2) {
				entrenador.getPokebola().get(i).aprenderAtaque(Ataque.LANZALLAMAS);
				text(name + " Aprendio un nuevo ataque : " + Ataque.LANZALLAMAS.getName());
				text("El nivel de ataque es: " + entrenador.getPokebola().get(i).getNivelAtaque());
			} else text(name + " ya aprendio todos los ataques");
			break;
		case "Pikachu":
			Ataque ataque = ataquesPikachu(i, ataques);
			if (ataques.size() < 3) {
				entrenador.getPokebola().get(i).aprenderAtaque(ataque);
				text(name + " Aprendio un nuevo ataque : " + ataque.getName());
				text("El nivel de ataque es: " + entrenador.getPokebola().get(i).getNivelAtaque());
			} else text(name + " ya aprendio todos los ataques");
			break;
		}
		
	}
	
	/***
	 * Todos los ataques del pikachu
	 * 
	 * @param i
	 * @param ataques
	 * @return
	 */
	private Ataque ataquesPikachu(int i, ArrayList<Ataque> ataques) {	
		if (ataques.isEmpty()) 
			return Ataque.COLA_DE_HIERRO;
		else if (ataques.size() < 2) 
			return Ataque.AGILIDAD;
		else 
			return Ataque.TRUENO;
	}
	
	/***
	 * Emprimimos texto por consola
	 * 
	 * @param text
	 */
	private void text(String text) {
		System.out.println(text);
	}
	
	/**
	 * Obj Scanner para enteractuar con usuario
	 * 
	 * @return
	 */
	private String entry() {
		return entry.nextLine();
	}
	
	/***
	 * Random para que aparesca un pokemon aleatorio
	 * 
	 * @return
	 */
	private int random() {
		return (int)(Math.random() * ((pokemones.size() - 1) + 1) + 0);
	}
	
}
