package basic.ch2;

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

        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                result[i] = 'D';
                System.out.println(result[i]);
                continue;
            }

            if (A[i] == 1 && B[i] == 3) {
                result[i] = 'A';
            } else if (A[i] == 3 && B[i] == 1) {
                result[i] = 'B';
            } else {
                if (A[i] < B[i]) {
                    result[i] = 'B';
                } else {
                    result[i] = 'A';
                }
            }
            System.out.println(result[i]);
        }
    }
}
