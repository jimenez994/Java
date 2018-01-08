package com.zeus.zookeeeper;

public class Dragon extends Mammal{
	public void dragon() {
		setEnergyLevel(getEnergyLevel() + 200);
	}

	public Dragon fly() {
		setEnergyLevel(getEnergyLevel() - 50);
		System.out.println("The Dragon is flying! and just lost 50 energy");
		return this;
	}
	public Dragon eatHumans() {
		setEnergyLevel(getEnergyLevel() + 25);
		System.out.println("The Dragon just eat a human and energy increased by 25");
		return this;
	}
	public Dragon attacktown() {
		setEnergyLevel(getEnergyLevel() - 100);
		System.out.println("The Dragon deestroyed a town and lost 100 energy");
		return this;
	}

	
}
