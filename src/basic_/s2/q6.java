package basic_.s2;

import java.util.Scanner;

public class q6 {

    private static Integer reverse(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 10);
            n /= 10;
        }
        return Integer.parseInt(sb.toString());
    }

    private static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        for (int i = 2; i < ((int) Math.sqrt(n)) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            int n = in.nextInt();
            Integer reversed = reverse(n);
            if (isPrime(reversed)) {
                System.out.print(reversed + " ");
            }
        }
    }
}
