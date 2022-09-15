package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clases.Ataque;
import clases.Entrenador;
import clases.Pokemon;

class EntrenadorTest {
	
	// 3 pasos a seguir:
	// 		1. Generar los recursos necesarios para hacer las pruebas
	//		2. Ejecutamos el metodo de prueba
	//		3. Realizamos las comprabaciones con assert

	
	@DisplayName("Dado un pokemon credo esperamos obtenerlo")
	@Test
	void testAtraparPokemon() {
		Entrenador entrenador = new Entrenador("Alma", new ArrayList<>());
		Pokemon pokemonEsperado = new Pokemon("Charizard", new ArrayList<Ataque>());
		entrenador.atraparPokemon(pokemonEsperado);
		Pokemon pokemonObtenido = entrenador.getPokebola().get(0);
		
		Assert.assertEquals(pokemonEsperado, pokemonObtenido);
	}
	
	@DisplayName("Dado un pokemon credo esperamos obtener otro y que falle")
	@Test
	void testFailAtraparPokemon() {
		Entrenador entrenador = new Entrenador("Alma", new ArrayList<>());
		Pokemon pokemonEsperado = new Pokemon("Charizard", new ArrayList<Ataque>());
		Pokemon pokemonFailEsperado = new Pokemon("Pikachu", new ArrayList<Ataque>());
		entrenador.atraparPokemon(pokemonEsperado);
		Pokemon pokemonObtenido = entrenador.getPokebola().get(0);
		
		Assert.assertEquals(pokemonFailEsperado, pokemonObtenido);
	}

}
