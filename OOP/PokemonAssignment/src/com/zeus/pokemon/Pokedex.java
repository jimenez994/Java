package com.zeus.pokemon;

public class Pokedex extends Pokeabstract implements pokeFace{
	public void pokemonInfo(Pokemon pokemon) {
		 System.out.println(pokemon.getName()+" "+pokemon.getHealth()+" "+pokemon.getType());
	}

}
