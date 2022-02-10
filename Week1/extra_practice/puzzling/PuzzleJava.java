package week1.extra_practice.puzzling;

import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    Random myRands = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++){
            result.add(myRands.nextInt(20) + 1);
        }
        return result;
    }

    public char getRandomLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        return alphabet[myRands.nextInt(alphabet.length)];
    }

    public String generatePassword(){
        String result = "";
        for (int i = 0; i < 8; i++){
            result += getRandomLetter();
        }
        return result;
    }

    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < length; i++){
            result.add(generatePassword());
        }
        return result;
    }

    //Made more generic, along the lines of the Collections.shuffle
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void shuffleArray(ArrayList<?> list){
        int count = list.size();
        int size = list.size();
        final ArrayList l = list;
        while (count-- > 0){
            int i = myRands.nextInt(size);
            int j = myRands.nextInt(size);

            l.set(i, l.set(j, l.get(i)));
        }
    }
}
