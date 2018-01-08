package com.zues.master;

public class human {
	protected String name;
	protected int strength = 3;
	protected int stealth = 3;
	protected int intelligence =3;
	protected int health =100;

	
	
	public human(String name){
		this.name = name;
	}
	public void damege(int damage) {
		this.health -= damage;
	}
	
	public human attack(human opponent) {
		int damage = this.strength;
		opponent.damege(damage);
		return this;
	}
	public human showHealth(){
		if(this.health <= 0) {
			System.out.println(this.name + " is death");
		}else {
			System.out.println(this.name + " has " + this.health + " health left.");
		}
		return this;
	}
	

}
