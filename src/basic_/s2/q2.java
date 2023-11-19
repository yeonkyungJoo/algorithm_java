package basic_.s2;

import java.util.Scanner;

public class q2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();
            if (n > max) {
                max = n;
                count++;
            }
        }

        System.out.println(count);
    }
}
