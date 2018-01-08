package com.zues.master;

public class Ninja extends human{

	public Ninja(String name) {
		super(name);
		this.stealth = 10;
		// TODO Auto-generated constructor stub
	}
	public Ninja steal( human target) {
		int steal = this.stealth;
		target.health -= steal;
		this.health += steal;
		return this;
	}
	public Ninja runAway() {
		this.health -= 10;
		return this;
	}
	

}
