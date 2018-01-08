package com.zeus.pokemon;

public abstract class PokemonTest extends Pokeabstract{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokedex p = new Pokedex();
		
		Pokemon Pikachu = p.createPokemon("Pikachu", 55, "Electric");
		
		Pokedex a = new Pokedex();
		Pokemon Armaldo = a.createPokemon("Armaldo", 155, "Rock");
		
		a.attackPokemon(Pikachu);
		p.pokemonInfo(Pikachu);
		a.pokemonInfo(Armaldo);
		


	}

}
