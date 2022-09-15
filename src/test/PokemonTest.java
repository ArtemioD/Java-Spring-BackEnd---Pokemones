package test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clases.Ataque;
import clases.Pokemon;

//	3 pasos a seguir:
//		1. Generar los recursos necesarios para hacer las pruebas
//		2. Ejecutamos el metodo de prueba
//		3. Realizamos las comprabaciones con assert


class PokemonTest {
	
	Pokemon pokemon;
	Ataque ataqueEsperado;
	Ataque ataqueFailEsperado;

	@BeforeEach
	void before() {
		pokemon = new Pokemon("Charizard", new ArrayList<Ataque>());
		ataqueEsperado = Ataque.COLA_DE_HIERRO;
		ataqueFailEsperado = Ataque.TRUENO;
	}
	
	@DisplayName("Dado un ataque esperamos obtenerlo")
	@Test
	void testAprenderAtaque() {
		pokemon.aprenderAtaque(ataqueEsperado);
		Ataque ataqueObtenido = pokemon.getAtaques().get(0);
		
		Assert.assertEquals(ataqueEsperado, ataqueObtenido);	
	}
	
	
	@DisplayName("Dado un ataque esperamos obtener otro y que falle")
	@Test
	void testFailAprenderAtaque() {
		pokemon.aprenderAtaque(ataqueEsperado);
		Ataque ataqueObtenido = pokemon.getAtaques().get(0);
		
		Assert.assertEquals(ataqueFailEsperado, ataqueObtenido);	
	}
	
	@DisplayName("Dado un pokemon esperamos obtener el nivel de ataque")
	@Test
	void testGetNivelAtaque() {
		pokemon.aprenderAtaque(ataqueEsperado);
		int nivelAtaqueEsperado = ataqueEsperado.getPotencia();
		int nivelAtaqueObtenido = pokemon.getNivelAtaque();
		
		Assert.assertEquals(nivelAtaqueEsperado, nivelAtaqueObtenido);	
	}
	
	@DisplayName("Dado un pokemon esperamos obtener el otro nivel de ataque y que falle")
	@Test
	void testFaulGetNivelAtaque() {
		pokemon.aprenderAtaque(ataqueEsperado);
		int nivelFailAtaqueEsperado = ataqueFailEsperado.getPotencia();
		int nivelAtaqueObtenido = pokemon.getNivelAtaque();
		
		Assert.assertEquals(nivelFailAtaqueEsperado, nivelAtaqueObtenido);	
	}
	

}
