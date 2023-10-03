package advanced.ch3;

import java.util.LinkedList;
import java.util.Queue;

public class Q4_ {

    private int parseTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h * 60 + m;
    }

    private int[] getTime(String enter, int[] laser) {
        String enterTime = enter.split(" ")[0];
        int parsedEnterTime = parseTime(enterTime);
        int laserIndex = Integer.parseInt(enter.split(" ")[1]);
        return new int[]{parsedEnterTime, parsedEnterTime + laser[laserIndex]};
    }

    public int solution(int[] laser, String[] enters){
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        int i = 0;
        while (i < enters.length) {

            if (queue.isEmpty()) {
                queue.add(getTime(enters[i], laser));
                i++;
            } else {

                int[] cur = queue.poll();
                int curEndTime = cur[1];

                while (i < enters.length
                        && getTime(enters[i], laser)[0] < curEndTime) {
                    queue.add(getTime(enters[i], laser));
                    i++;
                }
            }

            if (queue.size() >= 2) {
                answer = Integer.max(answer, queue.size());
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q4_ T = new Q4_();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
