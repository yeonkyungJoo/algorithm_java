package advanced.ch8;

import java.util.*;

public class Q2_A {

    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        // 역, 해당 역을 지나는 호선
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int line = 0; line < routes.length; line++) {
            for (int i = 0; i < routes[line].length; i++) {
                int stop = routes[line][i];
                graph.putIfAbsent(stop, new ArrayList<>());
                graph.get(stop).add(line);
            }
        }


        int[] counts = new int[1000001];
        Arrays.fill(counts, Integer.MAX_VALUE);

        int[] visited = new int[1000001];
        // 역, 환승횟수
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 0});
        visited[s] = 1;

        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] poll = queue.poll();
                int curStop = poll[0];

                List<Integer> lines = graph.get(curStop);
                for (int line : lines) {
                    int[] stops = routes[line];
                    for (int stop : stops) {
                        if (visited[stop] == 0) {
                            visited[stop] = 1;
                            counts[stop] = count;
                            if (stop == e) {
                                return counts[e];
                            }
                            queue.add(new int[]{stop, counts[stop]});
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args){
        Q2_A T = new Q2_A();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
