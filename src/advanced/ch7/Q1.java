package advanced.ch7;

import java.util.LinkedList;
import java.util.Queue;

public class Q1 {

    public int solution(int[] nums){

        int[] visited = new int[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 1;

        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Integer curIdx = queue.poll();
                int jumpCount = nums[curIdx];
                for (int j = 1; j <= jumpCount; j++) {

                    int nextIdx = curIdx + j;
                    if (nextIdx == nums.length - 1) {
                        return count + 1;
                    }
                    if (nextIdx < nums.length && visited[nextIdx] == 0) {
                        visited[nextIdx] = 1;
                        queue.offer(nextIdx);
                    }
                }
            }
            count++;
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
