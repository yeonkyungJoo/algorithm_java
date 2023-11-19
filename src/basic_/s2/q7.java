package basic_.s2;

import java.util.Scanner;

public class q7 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int[] scores = new int[N];
        scores[0] = array[0];
        int total = scores[0];
        for (int i = 1; i < N; i++) {
            if (array[i] == 1) {
                scores[i] = scores[i - 1] + 1;
            }
            total += scores[i];
        }

        System.out.println(total);
    }
}
