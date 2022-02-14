package week2.zoo_keeper_part_2;

public class Bat extends Mammal {
    
    public Bat() {
        this.energyLevel = 300;
    }

    public void fly() {
        System.out.println("*Snapping leather wings*");
        this.energyLevel += -50;
    }

    public void eatHumans() {
        System.out.println("*Unpleasant eating sounds*");
        this.energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("*Sounds of a burning town*");
        this.energyLevel += -100;
    }
}
