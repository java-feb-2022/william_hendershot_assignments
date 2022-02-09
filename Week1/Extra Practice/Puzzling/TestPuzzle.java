import java.util.ArrayList;

public class TestPuzzle {
    
    public static void main(String[] args){
        PuzzleJava myPuzzle = new PuzzleJava();

        System.out.println("\n---- getTenRolls() ----");
        System.out.println(myPuzzle.getTenRolls().toString());
        System.out.println(myPuzzle.getTenRolls().toString());
        System.out.println(myPuzzle.getTenRolls().toString());

        System.out.println("\n---- generatePassword() ----");
        System.out.println(myPuzzle.generatePassword());
        System.out.println(myPuzzle.generatePassword());
        System.out.println(myPuzzle.generatePassword());

        System.out.println("\n---- getNewPasswordSet() ----");
        System.out.println(myPuzzle.getNewPasswordSet(5).toString());
        System.out.println(myPuzzle.getNewPasswordSet(5).toString());
        System.out.println(myPuzzle.getNewPasswordSet(5).toString());

        System.out.println("\n---- shuffleArray() ----");
        ArrayList<String> myPasswordArray = myPuzzle.getNewPasswordSet(5);
        System.out.println(myPasswordArray.toString());
        System.out.println("Shuffle:");
        myPuzzle.shuffleArray(myPasswordArray);
        System.out.println(myPasswordArray.toString());
        System.out.println("Shuffle:");
        myPuzzle.shuffleArray(myPasswordArray);
        System.out.println(myPasswordArray.toString());
        System.out.println("Shuffle:");
        myPuzzle.shuffleArray(myPasswordArray);
        System.out.println(myPasswordArray.toString());
        System.out.println("Shuffle:");
        myPuzzle.shuffleArray(myPasswordArray);
        System.out.println(myPasswordArray.toString());
    }
}
