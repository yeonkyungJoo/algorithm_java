package basic_.s2;

import java.util.Arrays;
import java.util.Scanner;

public class q8 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = in.nextInt();
        }

        int[] rank = new int[N];
        Arrays.fill(rank, N);

        for (int i = 0; i < N; i++) {

            int cur = scores[i];
            int count = 1;
            for (int j = 0; j < N; j++) {

                if (i == j) {
                    continue;
                }

                if (cur < scores[j]) {
                    count++;
                }

            }
            rank[i] = count;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(rank[i] + " ");
        }

    }
}
