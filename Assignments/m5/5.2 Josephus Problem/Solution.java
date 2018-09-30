import java.util.Scanner;
class LinkedList {
    private Node head;
    private class Node {
        private char item;
        private Node next;
    }
    LinkedList() {
        this.head = null;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    public char pop() {
        if (head != null) {
            char value = head.item;
            head = head.next;
            return value;
        }
        return '\0';
    }
    public void push(final char value) {
        Node oldHead = head;
        head = new Node();
        head.item = value;
        head.next = oldHead;
    }
}
public final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int j = 0;
        while (j < n) {
            boolean value = check(scan);
            if (value) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            j++;
        }
    }
public static boolean check(final Scanner scan) {
        boolean res = false;
        LinkedList llist = new LinkedList();
        String str = scan.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                llist.push(ch);
            } else if (llist.isEmpty()) {
                res = false;
                return res;
            } else if (ch == ')') {
                if (llist == null || llist.pop() != '(') {
                    res = false;
                    return res;
                }
            } else if (ch == ']') {
                if (llist == null || llist.pop() != '[') {
                    res = false;
                    return res;
                }
            } else if (ch == '}') {
                if (llist == null || llist.pop() != '{') {
                    res = false;
                    return res;
                }
            }
        }
        if (llist.isEmpty()) {
            res = true;
            return res;
        } else {
            return res;
        }
    }
}
