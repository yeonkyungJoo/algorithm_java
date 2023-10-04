package advanced.ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Q6_A {

    public int solution(int n, int[][] meetings){

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        TreeSet<Integer> availableRooms = new TreeSet<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }

        // 5, 7,
        PriorityQueue<int[]> ends = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int[] count = new int[n];
        for (int i = 0; i < meetings.length; i++) {
            int st = meetings[i][0];
            int et = meetings[i][1];

            while (!ends.isEmpty() && ends.peek()[0] <= st) {
                availableRooms.add(ends.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                Integer availableRoom = availableRooms.pollFirst();
                ends.add(new int[]{et, availableRoom});
                count[availableRoom] += 1;
            } else {
                int[] end = ends.poll();
                ends.add(new int[]{et + (end[0] - st), end[1]});
                count[end[1]] += 1;
            }

        }

        int answer = 0;
        Integer maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (maxCount < count[i]) {
                maxCount = count[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Q6_A T = new Q6_A();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
