package ch9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q1 {

    static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Person[] array = new Person[N];
        int h, w;
        for (int i = 0; i < N; i++) {
            h = in.nextInt();
            w = in.nextInt();
            array[i] = new Person(h, w);
        }

        Arrays.sort(array, Comparator.comparingInt(o -> o.height * (-1)));
        int max = array[0].weight;
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (max < array[i].weight) {
                max = array[i].weight;
            } else {
                // max >= array[i].weight
                count += 1;
            }
        }

        System.out.println(N - count);
    }
}
