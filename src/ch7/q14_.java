package ch7;

import java.util.*;

public class q14_ {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] visited = new int[N+1];
        int s, e;
        for (int i = 0; i < M; i++) {
            s = in.nextInt();
            e = in.nextInt();

            if (!graph.containsKey(s)) {
                graph.put(s, new ArrayList<>());
            }
            graph.get(s).add(e);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = 1;

        int count = 0;
        Map<Integer, Integer> answer = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer v = queue.poll();

                if (graph.containsKey(v)) {
                    for (Integer n : graph.get(v)) {
                        if (visited[n] == 0) {
                            answer.put(n, count + 1);
                            queue.offer(n);
                            visited[n] = 1;
                        }
                    }
                }

            }
            count++;
        }

        for (Integer key : answer.keySet()) {
            System.out.println(key + " : " + answer.get(key));
        }
    }
}
