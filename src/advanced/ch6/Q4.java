package advanced.ch6;

import java.util.*;

public class Q4 {

    private String s;
    private int length;
    private char[] chars;
    private int[] checked;
    private Set<String> answer = new HashSet<>();

    private boolean check(String str) {
        boolean result = true;

        char[] chars = str.toCharArray();
        int l = 0;
        int r = str.length() - 1;

        while (l <= r) {
            if (chars[l] != chars[r]) {
                result = false;
                break;
            }
            l += 1;
            r -= 1;
        }

        return result;
    }

    private void dfs(String str) {

        if (str.length() == length) {

            if (check(str)) {
                answer.add(str);
            }
            return;
        }

        for (int i = 0; i < length; i++) {
            if (checked[i] == 0) {
                checked[i] = 1;
                dfs(str + chars[i]);
                checked[i] = 0;
            }
        }

    }

    public String[] solution(String s){

        this.s = s;
        this.chars = s.toCharArray();
        this.length = s.length();
        this.checked = new int[length];

        dfs("");

        return answer.toArray(String[]::new);
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(new Q4().solution("aaaabb")));
        System.out.println(Arrays.toString(new Q4().solution("abbcc")));
        System.out.println(Arrays.toString(new Q4().solution("abbccee")));
        System.out.println(Arrays.toString(new Q4().solution("abbcceee")));
        System.out.println(Arrays.toString(new Q4().solution("ffeffaae")));
    }
}
