package com.zues.master;

public class Samurai extends human{
	private static int count = 0;

	public Samurai(String name) {
		super(name);
		this.health = 200;
		count ++;
	}
	public Samurai deathBlow(human target) {
		target.health = 0;
		this.health = this.health/2;
		return this;
		
	}
	public Samurai meditate() {
		this.health += this.health/2;
		return this;
		
	}
	public int howMany(){
		if(count == 1){
			System.out.println(this.name + " is the last samurai!");
		}
		return count;
		
	}

}
