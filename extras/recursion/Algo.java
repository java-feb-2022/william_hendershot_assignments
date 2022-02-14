package extras.recursion;

public class Algo {

    public static void main(String[] args){
        //create an array 1-10
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++){
            array[i] = i+1;
        }

        //print the array
        printArray(array);

        //print the reverse of the array
        reverseArray(array);
        printArray(array);


        //Zero out all evens of an array of ints
        zeroEvens(array);
        printArray(array);

    }

    public static void reverseArray(int[] array) {
        //int[] result = new int[array.length];
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++){
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static void zeroEvens(int[] array){ 
        int i = 0;
        while (i < array.length){
            if (array[i] % 2 == 0){
                array[i] = 0;
            }
            i++;
        }
    }

    public static void printArray(int[] array){
        String result = "[";
        if (array.length > 0){
            result += String.format("%d", array[0]);
            for (int i = 1; i < array.length; i++){
                result += String.format(", %d", array[i]);
            }
        }
        result += "]";
        System.out.println(result);
    }
}
