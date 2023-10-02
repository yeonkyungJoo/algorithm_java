package advanced.ch5;

public class Q3_ {

    public int solution(int n, int[] nums){
        int answer = 0;
// (-1, 1),
// (0, 2),
// (1, 3),
// (1, 5),
// (3, 5),
// (4, 6),
// (4, 8),
// (6, 8),
// (7, 9)
        return answer;
    }

    public static void main(String[] args){
        Q3_ T = new Q3_();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
