package com.zeus.pokemon;

public abstract class Pokeabstract implements pokeFace{
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon p = new Pokemon(name,health,type);
		return p;
	}
	public void attackPokemon(Pokemon pokemon) {
		pokemon.setHealth(-10);
		
	}

}
