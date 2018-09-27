import java.util.Scanner;

/**
 * List of .
 */
class Stack {
    
    /**
     * Class for node.
     */
    class Node {
        
        private Node next;
        private char item;
    }
    private Node head = null;
    public void Push(final char s) {
        Node ll = head;
        head = new Node();
        head.item = s;
        head.next = ll;
    }
    
    public char Pop() {
        if (head == null) {
            return 's';
        }
        
        char m = head.item;
        head = head.next;
        return m;
    }
    public Node gethead() {
        return head;
    }
    public String toString() {
        String str = "";
        Node fun = head;
        while (fun != null) {
            str += fun.item;
            fun = fun.next;
        }
        return str;
    }
}
/**
 * Class for balanced.
 */
class Balanced {
    
    /**
     * Constructs the object.
     */
    Balanced() {

    }
    public boolean balance(final String str) {
        Stack sc = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '('
                || str.charAt(i) == '{') {
                sc.Push(str.charAt(i));
            } else {
                char ch = sc.Pop();
                if ((ch == '(' && str.charAt(i) == ')') || (ch == '['
                    && str.charAt(i) == ']') || (ch == '{'
                    && str.charAt(i) == '}')) {
                    
                    continue;
                } else {
                    return false;
                }
            }
        }
        return sc.gethead() == null;
    }
}

public final class Solution {
    
    /**
     * Constructs the object.
     */
    private Solution() {
        
    }
    
    /**
     * { main function}
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] strarray = new String[n];
        for (int i = 0; i < n; i++) {
            strarray[i] = scan.nextLine();
        }
        Balanced brace = new Balanced();
        for (int i = 0; i < n; i++) {
            if (brace.balance(strarray[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

