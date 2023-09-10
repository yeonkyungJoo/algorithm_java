package advanced.ch6;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    private int n;
    private Integer[] array;
    private int size;

    private int[] checked;
    private int answer = Integer.MAX_VALUE;

    private void dfs(int idx, int number) {

        if (idx == this.size) {
            if (number > n) {
                answer = Integer.min(answer, number);
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            if (checked[i] == 0) {
                checked[i] = 1;
                dfs(idx+1, number * 10 + array[i]);
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
        this.checked = new int[this.size];
        dfs(0, 0);

        if (this.answer == Integer.MAX_VALUE) {
            return -1;
        }
        return this.answer;
    }

    // TODO - 동시성 체크
    public static void main(String[] args){
//        Q1 T = new Q1();
        System.out.println(new Q1().solution(123));
        System.out.println(new Q1().solution(321));
        System.out.println(new Q1().solution(20573));
        System.out.println(new Q1().solution(27711));
        System.out.println(new Q1().solution(54312));
    }
}
