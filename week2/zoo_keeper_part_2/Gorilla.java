package week2.zoo_keeper_part_2;

public class Gorilla extends Mammal{
    
    public Gorilla() {
        super();
    }

    public void throwSomething(String missile, String target) {
        System.out.printf("The Gorilla has thrown a %s at %s!%n", missile, target);
        this.energyLevel += -5;
    }

    public void eatBananas() {
        System.out.println("The Gorilla seems content with the bannanna.");
        this.energyLevel += 10;
    }

    public void climb() {
        System.out.println("The Gorilla has climbed a tree.");
        this.energyLevel += -10;
    }
}
