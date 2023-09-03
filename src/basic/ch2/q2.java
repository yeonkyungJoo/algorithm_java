package basic.ch2;

import java.util.Scanner;

public class q2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = in.nextInt();
        }

        int max = heights[0];
        int count = 1;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
                count += 1;
            }
        }
        System.out.println(count);
    }
}
