package advanced.ch7;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    static class Move {
        // 0 : front, 1 : back
        int direction;
        int location;

        public Move(int direction, int location) {
            this.direction = direction;
            this.location = location;
        }

        @Override
        public String toString() {
            return "{ " + location + " }";
        }
    }

    private boolean find(int[] array, int element) {

        for (int e : array) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }

    public int solution(int[] pool, int a, int b, int home){

        int count = 0;
        Queue<Move> queue = new LinkedList<>();
        int[][] visited = new int[10001][2];

        queue.add(new Move(0, 0));
        visited[0][0] = 1;
        visited[0][1] = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Move poll = queue.poll();

                int front = poll.location + a;
                if (front >= 0 && front <= 10000
                        && visited[front][0] == 0
                        && !find(pool, front)
                ) {

                    if (front == home) {
                        return count + 1;
                    }

                    visited[front][0] = 1;
                    queue.add(new Move(0, front));
                }

                int back = poll.location - b;
                if (back >= 0 && back <= 10000
                        && visited[back][1] == 0
                        && !find(pool, back)
                        && poll.direction != 1
                ) {

                    if (back == home) {
                        return count + 1;
                    }

                    visited[back][1] = 1;
                    queue.add(new Move(1, back));
                }
            }
            count++;
        }


        return -1;
    }

    public static void main(String[] args){
        Q2 T = new Q2();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
