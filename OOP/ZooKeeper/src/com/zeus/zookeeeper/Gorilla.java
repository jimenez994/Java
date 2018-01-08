package com.zeus.zookeeeper;

public class Gorilla extends Mammal{
	public Gorilla throwSomething() {
		setEnergyLevel(getEnergyLevel() - 5);
		System.out.println("Gorilla threw a rock and lost 5 energy");
		return this;
	}
	public Gorilla eatBananas() {
		setEnergyLevel(getEnergyLevel() + 10);
		System.out.println("Gorilla just a Banana and gain 10 energy");
		return this;
	}
	public Gorilla climb() {
		setEnergyLevel(getEnergyLevel() - 10);
		System.out.println("Gorilla just climb the tree and lost 10 energy");
		return this;
	}
	

}
