package advanced.ch6;

public class Q3 {

    private int[][] cans;
    private int numOfCans;
    private int[] checked;
    private int answer = Integer.MAX_VALUE;

    private void dfs(int idx) {

        if (idx >= numOfCans / 2) {

            int whiteTotal = 0;
            int blackTotal = 0;

            for (int i = 0; i < numOfCans; i++) {
                if (checked[i] == 0) {
                    whiteTotal += cans[i][0];
                } else {
                    blackTotal += cans[i][1];
                }
            }
            answer = Integer.min(answer, Math.abs(whiteTotal - blackTotal));
            return;
        }

        for (int i = 0; i < numOfCans; i++) {
            if (checked[i] == 0) {
                checked[i] = 1;
                dfs(idx + 1);
                checked[i] = 0;
            }
        }
    }

    public int solution(int[][] cans){

        this.cans = cans;
        numOfCans = cans.length;
        checked = new int[numOfCans];
        dfs(0);

        return answer;
    }

    public static void main(String[] args){
        System.out.println(new Q3().solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(new Q3().solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(new Q3().solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
