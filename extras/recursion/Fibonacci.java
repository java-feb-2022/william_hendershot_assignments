package extras.recursion;

import java.util.HashMap;

/*
    Example showing recurison and memoization using the Fibonacci sequence
    F(n) = F(n - 1) + F(n - 2)
    F(0) = 0
    F(1) = 1
*/
public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(naieve(10));
        long endTime = System.currentTimeMillis();
        System.out.printf("The call took %d ms to finish.%n", endTime - startTime);

        // System.out.println("\n--------------------------\n");
        // for (int i = 0; i <= 48; i++){
        //     System.out.printf("Trying naieve(%d): ", i);
        //     startTime = System.currentTimeMillis();
        //     System.out.println(naieve(i));
        //     endTime = System.currentTimeMillis();
        //     System.out.printf("The call took %d ms to finish.%n", endTime - startTime);
        // }

        System.out.println("\n--------------------------\n");
        for (int i = 0; i <= 200; i++){
            System.out.printf("Trying memo(%d): ", i);
            startTime = System.currentTimeMillis();
            System.out.println(memo(i));
            endTime = System.currentTimeMillis();
            System.out.printf("The call took %d ms to finish.%n", endTime - startTime);
        }
    }

    public static int naieve(int n) {
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }
        return naieve(n - 1) + naieve(n - 2);
    }


    public static int memo(int n) {
        HashMap<Integer, Integer> memory = new HashMap<Integer, Integer>();
        return memo(n, memory);
    }

    //Note all function calls in Java are pass-by-value.
    public static int memo(int n, HashMap<Integer, Integer> memory) {
        if (memory.containsKey(n)) { return memory.get(n); }
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }
        memory.put(n, memo(n - 1, memory) + memo(n - 2, memory));
        return memory.get(n);
    }
}
