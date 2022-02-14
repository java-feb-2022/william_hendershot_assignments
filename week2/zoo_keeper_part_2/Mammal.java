package week2.extra_practice.zoo_keep_part_1;

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
