import java.util.*;
 
class Solution {
 
    static void printVector(Vector<Integer> v, int i)
    {
        for (int j = i; j < v.size(); j++)
            System.out.print(v.get(j) + " ");
        System.out.println();
    }

    static class Node {
        int data;
        Node left, right;
        Node(int x)
        {
            data = x;
            left = right = null;
        }
    };
    static Vector<Integer> path = new Vector<Integer>();
 
    static void printKPathUtil(Node root, int k)
    {
        if (root == null)
            return;
 
        path.add(root.data);
 
        printKPathUtil(root.left, k);
 
        printKPathUtil(root.right, k);
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);
            if (f == k)
                printVector(path, j);
        }
        path.remove(path.size() - 1);
    }
    static void printKPath(Node root, int k)
    {
        path = new Vector<Integer>();
        printKPathUtil(root, k);
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
 
        int k = 5;
        printKPath(root, k);
    }
}