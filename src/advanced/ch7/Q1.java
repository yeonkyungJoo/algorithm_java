package advanced.ch7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class Q1 {

    class Location {
        int idx;
        int count;

        public Location(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

    public int solution(int[] nums){

        int[] visited = new int[nums.length];
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0, 0));
        visited[0] = 1;
        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {

                Location cur = queue.poll();
                int curIndex = cur.idx;
                if (curIndex == nums.length - 1) {
                    return cur.count;
                }

                int jumpCount = nums[curIndex];
                for (int j = 1; j <= jumpCount; j++) {

                    int nextIdx = curIndex + j;
                    if (nextIdx < nums.length && visited[nextIdx] == 0) {
                        visited[nextIdx] = 1;
                        queue.offer(new Location(nextIdx, cur.count + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Q1 T = new Q1();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
