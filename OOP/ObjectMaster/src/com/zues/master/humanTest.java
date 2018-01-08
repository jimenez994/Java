package com.zues.master;


public class humanTest {

	public static void main(String[] args) {
		human h = new human("Bod");
		human l = new human("Luke");
		h.attack(l);
		l.showHealth();
		
		Wizard w1 = new Wizard("Juan");
		w1.fireball(l);
		l.showHealth();
		w1.heal(h);
		h.showHealth();
		
		Ninja n1 = new Ninja("Jejjy");
		n1.steal(h);
		h.showHealth();
		n1.showHealth();
		n1.runAway();
		n1.showHealth();
		
		Samurai s1 = new Samurai("Maximus");
		s1.deathBlow(n1);
		n1.showHealth();
		s1.showHealth();
		s1.meditate();
		s1.showHealth();
		s1.howMany();
		
		
		Samurai s2 = new Samurai("Mario");
		s2.howMany();
		int num = s2.howMany();
		System.out.println(num);
		
	}

}
