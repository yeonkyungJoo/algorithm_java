package advanced.ch4;

import java.util.*;

public class Q7_ {

    static class Meeting {
        int beginTime;
        int endTime;

        public Meeting(int beginTime, int endTime) {
            this.beginTime = beginTime;
            this.endTime = endTime;
        }
    }

    public int solution(int[][] meetings){
        int answer = 0;
        // [2, 5]
        // [0, 10]
        // [5, 15]
        // [12, 25]

        List<Meeting> list = new LinkedList<>();
        for (int i = 0; i < meetings.length; i++) {
            list.add(new Meeting(meetings[i][0], meetings[i][1]));
        }
        list.sort(Comparator.comparingInt(o -> o.endTime));

        Queue<Meeting> queue = new LinkedList<>(list);
        int cur = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            answer++;

            for (int i = 0; i < size; i++) {

                Meeting meeting = queue.poll();
                if (meeting.beginTime >= cur) {
                    cur = meeting.endTime;
                } else {
                    queue.add(meeting);
                }
            }
            cur = 0;

        }

        return answer;
    }

    public static void main(String[] args){
        Q7_ T = new Q7_();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
