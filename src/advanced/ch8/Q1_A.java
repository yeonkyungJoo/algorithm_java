package advanced.ch8;

import java.util.*;

public class Q1_A {

    public int solution(int n, int[][] flights, int s, int e, int k){

        int[][] graph = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int start = flights[i][0];
            int end = flights[i][1];
            int cost = flights[i][2];
            graph[start][end] = cost;
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 0});
        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] poll = queue.poll();
                int curCity = poll[0];
                int nowCost = poll[1];

                for (int j = 0; j < graph[curCity].length; j++) {

                    if (graph[curCity][j] > 0) {
                        int nextCity = j;
                        int newCost = nowCost + graph[curCity][nextCity];
                        if (newCost < cost[nextCity]) {
                            cost[nextCity] = newCost;
                            queue.add(new int[]{nextCity, cost[nextCity]});
                        }
                    }

                }
            }
            count++;

            if (count > k) {
                break;
            }

        }

        if (cost[e] == Integer.MAX_VALUE) {
            return -1;
        }
        return cost[e];
    }

    public static void main(String[] args){
//        Q1 T = new Q1();
        System.out.println(new Q1_A().solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(new Q1_A().solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(new Q1_A().solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(new Q1_A().solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(new Q1_A().solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
