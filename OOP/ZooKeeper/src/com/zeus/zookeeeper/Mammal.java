package com.zeus.zookeeeper;

public class Mammal {
    private int energyLevel = 100;
    
    public int displayEnergy() {
        System.out.println("Energy Level: " + getEnergyLevel());
        return getEnergyLevel();
    }
	public int getEnergyLevel() {
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
   
}
