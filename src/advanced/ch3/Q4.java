package advanced.ch3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q4 {

    private int parseTime(String time) {
        String[] splits = time.split(":");
        int h = Integer.parseInt(splits[0]);
        int m = Integer.parseInt(splits[1]);
        return h * 60 + m;
    }

    public int solution(int[] laser, String[] enters){
        int answer = 0;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < enters.length; i++) {

            String enter = enters[i];

            String[] splits = enter.split(" ");
            String enterTime = splits[0];
            int laserIndex = Integer.parseInt(splits[1]);

            int parsedEnterTime = parseTime(enterTime);
            list.add(new int[]{parsedEnterTime, laserIndex});
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(list.get(0)[1]);
        int finishTime = list.get(0)[0];
        for (int t = finishTime, i = 1; t <= 1200; t++) {

            if (i < enters.length && t == list.get(i)[0]) {
                if (queue.isEmpty() && list.get(i)[0] > finishTime) {
                    finishTime = list.get(i)[0];
                }
                queue.add(list.get(i)[1]);
                i++;
            }

            if (t == finishTime) {
                if (!queue.isEmpty()) {
                    int laserIndex = queue.poll();
                    finishTime += laser[laserIndex];
                }
            }
            answer = Integer.max(answer, queue.size());
        }
        return answer;
    }

    public static void main(String[] args){
        Q4 T = new Q4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
