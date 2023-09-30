package advanced.ch6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2 {

    private int[] checked = new int[8];
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private int answer = 0;

    private void dfs(int idx, int last) {

        if (idx >= 7) {
            answer += 1;
            return;
        }

        for (int i = 1; i <= 7; i++) {

            if (!map.containsKey(last) ||
                    (checked[i] == 0 && !map.get(last).contains(i))) {

                if (checked[i] == 0) {
                    checked[i] = 1;
                    dfs(idx + 1, i);
                    checked[i] = 0;
                }
            }
        }
    }

    public int solution(int[][] fight){

        for (int i = 0; i < fight.length; i++) {

            map.putIfAbsent(fight[i][0], new ArrayList<>());
            map.get(fight[i][0]).add(fight[i][1]);

            map.putIfAbsent(fight[i][1], new ArrayList<>());
            map.get(fight[i][1]).add(fight[i][0]);
        }

//        for (Integer key : map.keySet()) {
//            System.out.println(key + " " + map.get(key));
//        }
        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args){
        System.out.println(new Q2().solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(new Q2().solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(new Q2().solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(new Q2().solution(new int[][]{{1, 7}}));
        System.out.println(new Q2().solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
