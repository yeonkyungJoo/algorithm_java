package basic_.s2;

import java.util.Scanner;

public class q3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }

        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                System.out.println("D");
            } else {
                if (A[i] == 3 && B[i] == 1) {
                    System.out.println("B");
                } else if (A[i] == 1 && B[i] == 3) {
                    System.out.println("A");
                } else {

                    if (A[i] < B[i]) {
                        System.out.println("B");
                    } else {
                        System.out.println("A");
                    }
                }
            }
        }
    }
}
