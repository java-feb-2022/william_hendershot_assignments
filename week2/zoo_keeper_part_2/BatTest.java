package week2.zoo_keeper_part_2;

public class BatTest {
    
    public static void main(String[] args) {

        Bat testBat = new Bat();

        testBat.displayEnergy();
        testBat.attackTown();
        testBat.attackTown();
        testBat.attackTown();
        testBat.displayEnergy();

        testBat.eatHumans();
        testBat.eatHumans();
        testBat.displayEnergy();
        
        testBat.fly();
        testBat.fly();
        testBat.displayEnergy();
    }
}
