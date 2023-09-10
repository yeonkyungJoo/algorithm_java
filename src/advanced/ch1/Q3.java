package advanced.ch1;

public class Q3 {

    private class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solution(int[][] board){
        int time = 0;

        // 북, 동, 남, 서
        int[] di = new int[]{-1, 0, 1, 0};
        int[] dj = new int[]{0, 1, 0, -1};

        Point hs = null;
        Point dog = null;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    hs = new Point(i, j);
                }
                if (board[i][j] == 3) {
                    dog = new Point(i, j);
                }
            }
        }

        int hsDirectionIndex = 0;
        int dogDirectionIndex = 0;
        while (true) {

            if (time == 10000) {
                break;
            }

            int hsNi = hs.i + di[hsDirectionIndex % 4];
            int hsNj = hs.j + dj[hsDirectionIndex % 4];
            if ((hsNi >= 0 && hsNi < 10) && (hsNj >= 0 && hsNj < 10)) {

                if (board[hsNi][hsNj] == 0) {

                    board[hs.i][hs.j] = 0;

                    hs.i = hsNi;
                    hs.j = hsNj;
                    board[hs.i][hs.j] = 2;
                } else if (board[hsNi][hsNj] == 3) {
                    time++;
                    break;
                } else if (board[hsNi][hsNj] == 1) {
                    hsDirectionIndex++;
                }

            } else {
                hsDirectionIndex++;
            }


            int dogNi = dog.i + di[dogDirectionIndex % 4];
            int dogNj = dog.j + dj[dogDirectionIndex % 4];
            if ((dogNi >= 0 && dogNi < 10) && (dogNj >= 0 && dogNj < 10)) {

                if (board[dogNi][dogNj] == 0) {

                    board[dog.i][dog.j] = 0;

                    dog.i = dogNi;
                    dog.j = dogNj;
                    board[dog.i][dog.j] = 3;
                } else if (board[dogNi][dogNj] == 2) {
                    time++;
                    break;
                } else if (board[dogNi][dogNj] == 1) {
                    dogDirectionIndex++;
                }
            } else {
                dogDirectionIndex++;
            }


            time++;

        }
        return time;
    }

    public static void main(String[] args){
        Q3 T = new Q3();
        int[][] arr1 = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
