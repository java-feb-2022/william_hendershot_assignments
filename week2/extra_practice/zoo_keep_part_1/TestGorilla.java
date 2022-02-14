package week2.extra_practice.zoo_keep_part_1;

public class TestGorilla {
    
    public static void main(String[] args){
        Gorilla testGorilla = new Gorilla();

        testGorilla.throwSomething("rock", "bird");
        testGorilla.throwSomething("rock", "bird");
        testGorilla.throwSomething("rock", "bird");
        testGorilla.displayEnergy();

        testGorilla.eatBananas();
        testGorilla.eatBananas();
        testGorilla.displayEnergy();

        testGorilla.climb();
        testGorilla.displayEnergy();
    }
}
