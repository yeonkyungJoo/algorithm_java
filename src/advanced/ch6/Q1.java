package advanced.ch6;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    private int n;
    private Integer[] array;
    private int size;

    private int[] checked;
    private int[] result;
    private int answer = Integer.MAX_VALUE;

    private void dfs(int idx) {

        if (idx == this.size) {
            StringBuilder sb = new StringBuilder();
            for (int n : result) {
                sb.append(n);
            }

            int rv = Integer.parseInt(sb.toString());
            if (rv > n) {
                answer = Integer.min(answer, rv);
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            if (checked[i] == 0) {
                checked[i] = 1;
                result[idx] = array[i];
                dfs(idx+1);
                checked[i] = 0;
            }
        }
    }

    private Integer[] getArray(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        return list.toArray(new Integer[0]);
    }

    public int solution(int n){

        this.n = n;
        this.array = getArray(n);
        this.size = array.length;
//        System.out.println(Arrays.toString(getArray(n)));

        this.checked = new int[this.size];
        this.result = new int[this.size];
        dfs(0);

        if (this.answer == Integer.MAX_VALUE) {
            return -1;
        }
        return this.answer;
    }

    // TODO - 동시성 체크
    public static void main(String[] args){
        Q1 T = new Q1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
