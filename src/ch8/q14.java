package ch8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q14 {

    static int[][] array;
    static int N, M;

    static Point[] chosen;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> stores = new ArrayList<>();
    static List<Point> houses = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
/*
    private static void dfs(int idx) {

        if (idx == M) {
            System.out.println(chosen.size());
            int sum = 0;
            for (Point house : houses) {
                for (Point store: chosen) {
                    sum += Math.abs(house.x - store.x) + Math.abs(house.y - store.y);
                }
            }

            answer = Integer.min(answer, sum);
            return;
        }

        for (int i = idx; i < stores.size(); i++) {
            chosen.add(stores.get(i));
            dfs(i + 1, chosen);
            chosen.remove(stores.get(i));
        }
    }*/

    private static void dfs(int idx, int start) {

        if (idx == M) {

            int sum = 0;
            for (Point house : houses) {
                for (Point store: chosen) {
                    sum += Math.abs(house.x - store.x) + Math.abs(house.y - store.y);
                }
            }

            answer = Integer.min(answer, sum);
            Arrays.stream(chosen).forEach(c -> System.out.printf("(%d, %d)", c.x, c.y));
            System.out.println("-------------> " + sum);
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            chosen[idx] = stores.get(i);
            dfs(idx + 1, i + 1);
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        array = new int[N][N];
        chosen = new Point[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();

                if (array[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if (array[i][j] == 2) {
                    stores.add(new Point(i, j));
                }
            }
        }

        stores.forEach(s -> System.out.printf("(%d, %d)", s.x, s.y));
        System.out.println("------------------------");

        dfs(0, 0);
        System.out.println(answer);

    }
}
