package basic.ch9;

import java.util.*;

public class q5 {

    static class Node {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int v1, v2, c;
        Map<Integer, ArrayList<Node>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            v1 = in.nextInt();
            v2 = in.nextInt();
            c = in.nextInt();

            if (!map.containsKey(v1)) {
                map.put(v1, new ArrayList<>());
            }
            map.get(v1).add(new Node(v2, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        boolean[] visited = new boolean[N + 1];
        int[] answer = new int[N + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[1] = 0;
        pq.offer(new Node(1, 0));

        Node node;
        while (!pq.isEmpty()) {
            node = pq.poll();
            if (visited[node.v]) {
                continue;
            }
            visited[node.v] = true;

            ArrayList<Node> list = map.get(node.v);
            if (list != null) {
                for (Node n : list) {
                    answer[n.v] = Integer.min(answer[n.v], answer[node.v] + n.c);
                    pq.offer(n);
                }
            }

        }

        for (int i = 2; i < N + 1; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + answer[i]);
            }
        }
    }
}
