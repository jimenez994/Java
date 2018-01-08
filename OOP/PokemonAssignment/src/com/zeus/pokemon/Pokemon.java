package com.zeus.pokemon;

public class Pokemon {
	private String name;
	private int health = 0;
	private String type;
	public static int count;
	
	
	public Pokemon(String name, int health, String type) {
		this.setName(name);
		this.setHealth(health);
		this.setType(type);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health += health;
	}
}
