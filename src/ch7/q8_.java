package ch7;

import java.util.*;

public class q8_ {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        int E = in.nextInt();
        List<Integer> list = Arrays.asList(1, -1, 5);

        int[] visited = new int[10001];
        Queue<Integer> queue = new LinkedList<>();
        visited[S] = 1;
        queue.offer(S);

        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int move : list) {
                    int nx = x + move;
                    if (nx == E) {
                        System.out.println(count + 1);
                        return;
                    }

                    if (nx >= 1 && nx <= 10000 && visited[nx] == 0) {
                        visited[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            count++;
        }
    }
}
