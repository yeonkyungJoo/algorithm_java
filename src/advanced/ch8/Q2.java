package advanced.ch8;

import java.util.*;

public class Q2 {

    public int solution(int[][] routes, int s, int e){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new ArrayList<>());
                graph.get(routes[i][j]).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[1000001];
        queue.add(s);
        visited[s] = 1;

        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Integer curStation = queue.poll();
//                if (curStation == e) {
//                    return count;
//                }

                if (!graph.containsKey(curStation)) {
                    continue;
                }

                List<Integer> lines = graph.get(curStation);
                for (int j = 0; j < lines.size(); j++) {
                    int[] stations = routes[lines.get(j)];
                    for (int k = 0; k < stations.length; k++) {
                        int station = stations[k];

                        if (station == e) {
                            return count;
                        }

                        if (visited[station] == 0) {
                            visited[station] = 1;
                            queue.add(station);
                        }
                    }
                }

            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(new Q2().solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(new Q2().solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(new Q2().solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(new Q2().solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
