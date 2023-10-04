package advanced.ch8;

public class Q1_dfs {

    private int[][] graph;
    private int k;
    private int answer = Integer.MAX_VALUE;

    private void dfs(int s, int e, int cnt, int totalCost) {

        if (cnt > k) {
            return;
        }

        if (s == e) {
            answer = Integer.min(answer, totalCost);
            return;
        }

        int[] next = graph[s];
        for (int i = 0; i < next.length; i++) {
            if (next[i] == 0) {
                continue;
            }
            dfs(i, e, cnt+1, totalCost + next[i]);
        }
    }


    public int solution(int n, int[][] flights, int s, int e, int k){

        this.graph = new int[n][n];
        this.k = k;
        for (int i = 0; i < flights.length; i++) {
            int start = flights[i][0];
            int end = flights[i][1];
            int cost = flights[i][2];
            this.graph[start][end] = cost;
        }
        dfs(s, e, -1, 0);

        if (this.answer == Integer.MAX_VALUE) {
            return -1;
        }
        return this.answer;
    }

    public static void main(String[] args){
//        Q1 T = new Q1();
        System.out.println(new Q1_dfs().solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(new Q1_dfs().solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(new Q1_dfs().solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(new Q1_dfs().solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(new Q1_dfs().solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
