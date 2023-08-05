package ch2;

import java.util.Scanner;

public class q6 {

    private static boolean isPrime(int n) {

        int sqrt = ((int) Math.sqrt(n)) + 1;

        if (n == 1) {
            return false;
        }

        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int n = array[i];
            String reversed = new StringBuilder().append(n).reverse().toString();
            int num = Integer.parseInt(reversed);
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
