package ch6;

import java.util.Arrays;
import java.util.Scanner;

public class q7 {

    static class Pointer {
        private int x;
        private int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Pointer[] pointers = new Pointer[N];
        int x, y;
        for (int i = 0; i < N; i++) {
            x = in.nextInt();
            y = in.nextInt();
            pointers[i] = new Pointer(x, y);
        }

        Arrays.sort(pointers, (o1, o2) -> {
            if (o1.getX() < o2.getX()) {
                return -1;
            } else if (o1.getX() == o2.getX()) {
                if (o1.getY() < o2.getY()) {
                    return -1;
                } else if (o1.getY() > o2.getY()) {
                    return 1;
                }
            }
            return 1;
        });

        for (Pointer pointer : pointers) {
            System.out.println(pointer.getX() + " " + pointer.getY());
        }
    }
}
