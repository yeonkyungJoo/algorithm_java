package ch2;

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
        Arrays.fill(rank, -1);
        rank[0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (scores[j] < scores[i]) {
                    int tmp = rank[j];
                    rank[j] += 1;
                    rank[i] = tmp;
                } else if (scores[j] == scores[i]) {
                    rank[i] = rank[j];
                } else {
                    rank[i] = Integer.max(rank[i], rank[j] + 1);
                }
            }
        }

        for (int n : rank) {
            System.out.print(n + " ");
        }
    }
}
