package ch10;

import java.util.Arrays;
import java.util.Scanner;

public class q4 {

    static class Brick implements Comparable<Brick> {
        int area;
        int height;
        int weight;

        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.area - this.area;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Brick[] array = new Brick[N];
        int a, h, w;
        for (int i = 0; i < N; i++) {
            a = in.nextInt();
            h = in.nextInt();
            w = in.nextInt();
            array[i] = new Brick(a, h, w);
        }

        Arrays.sort(array);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = array[i].height;
            for (int j = i-1; j >= 0; j--) {
                if (array[j].weight > array[i].weight) {
                    tmp = Integer.max(array[i].height + answer[j], tmp);
                }
            }
            answer[i] = tmp;
        }

        int result = Integer.MIN_VALUE;
        for (int n : answer) {
            if (n > result) {
                result = n;
            }
        }
        System.out.println(result);
    }
}
