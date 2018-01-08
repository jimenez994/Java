package com.zues.master;

public class Wizard extends human{

	public Wizard(String name) {
		super(name);
		this.health = 50;
		this.intelligence = 8;
		// TODO Auto-generated constructor stub
	}
	public Wizard heal(human target) {
		int add = this.intelligence;
		target.health += add;
		return this;
	}
	public Wizard fireball(human target) {
		int damage = this.intelligence * 3;
		target.health -= damage;
		return this;
		
	}

}
