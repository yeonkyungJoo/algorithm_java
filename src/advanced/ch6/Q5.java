package advanced.ch6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q5 {

    private String s;
    private Set<String> answer = new HashSet<>();

    private void dfs(int part, int startIndex, String str) {

        if (part > 4) {
            if (startIndex == s.length()) {
                answer.add(str);
            }
            return;
        }

        for (int n = 0; n < 3; n++) {

            int exclusiveEndIndex = startIndex + n + 1;
            if (exclusiveEndIndex <= s.length()) {

                String strNum = s.substring(startIndex, exclusiveEndIndex);
                if (strNum.length() >= 2 && strNum.startsWith("0")) {
                    continue;
                }

                int num = Integer.parseInt(strNum);
                if (num < 0 || num > 255) {
                    continue;
                }

                String next = str.length() == 0 ? strNum : str + "." + strNum;
                dfs(part + 1, exclusiveEndIndex, next);
            }

        }

    }

    public String[] solution(String s){

        this.s = s;
        dfs(1, 0, "");
        return answer.toArray(String[]::new);
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(new Q5().solution("2025505")));
        System.out.println(Arrays.toString(new Q5().solution("0000")));
        System.out.println(Arrays.toString(new Q5().solution("255003")));
        System.out.println(Arrays.toString(new Q5().solution("155032012")));
        System.out.println(Arrays.toString(new Q5().solution("02325123")));
        System.out.println(Arrays.toString(new Q5().solution("121431211")));
    }
}
