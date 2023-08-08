package ch7;

public class q9 {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
        }
    }

    private static int dfs(Node node, int minCount) {

        if (node.lt == null && node.rt == null) {
            return minCount;
        }
        return Integer.min(dfs(node.lt, minCount + 1), dfs(node.rt, minCount + 1));
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(dfs(root, 0));
    }
}
