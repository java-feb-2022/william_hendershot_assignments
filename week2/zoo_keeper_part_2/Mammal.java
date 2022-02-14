package week2.zoo_keeper_part_2;

public class Mammal {
    
    protected int energyLevel;

    public Mammal () {
        this.energyLevel = 100;
    }

    public int displayEnergy() {
        System.out.printf("My enegry level is: %d%n", this.energyLevel);
        return this.energyLevel;
    }

    public int getEnergyLevel() {
        return this.energyLevel;
    }
}
