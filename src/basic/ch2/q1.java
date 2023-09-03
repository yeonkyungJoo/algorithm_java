package basic.ch2;

import java.util.Scanner;

public class q1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int before = 0;
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();

            if (i == 0) {
                System.out.print(n + " ");
            } else {
                if (before < n) {
                    System.out.print(n + " ");
                }
            }
            before = n;
        }
    }
}
