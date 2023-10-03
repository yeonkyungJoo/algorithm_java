package advanced.ch3;

import java.util.*;

public class Q5_A {

    public int[] solution(int[][] tasks){

        int n = tasks.length;
        int[] answer = new int[n];
        Map<Integer, List<int[]>> map = new HashMap();
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            map.putIfAbsent(task[0], new ArrayList<>());
            // 작업번호, 호출시간, 실행시간
            map.get(task[0]).add(new int[]{i, task[0], task[1]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        });
        int cur = -1;
        int finishTime = -1;
        for (int t = 0, order = 0; order < n ; t++) {

            if (finishTime == t) {
                answer[order] = cur;
                order++;
            }

            if (map.containsKey(t)) {
                queue.addAll(map.get(t));
            }

            // 현재 실행중인 작업이 없는 경우
            if (finishTime <= t) {

                if (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    cur = poll[0];
                    finishTime = t + poll[2];
                }

            }

        }

        return answer;
    }

    public static void main(String[] args){
        Q5_A T = new Q5_A();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
