import java.util.Scanner;
class Deque {
    private Node start;
    
    private Node end;
    
    private int size;
    
    private class Node {
        
        private int item;
        
        private Node next;
    }
    
    Deque() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public int Size() {
        return size;
    }
    
    public void pushFront(final int int1) {
        if (start == null) {
            start = new Node();
            start.item = int1;
            start.next = null;
            end = start;
        } else {
            Node oldstart = start;
            start = new Node();
            start.item = int1;
            start.next = oldstart;
        }
        size++;
    }
    
    public void pushBack(final int item1) {
        if (end == null) {
            end = new Node();
            end.item = item1;
            end.next = null;
        } else {
            Node oldend = end;
            end = new Node();
            end.item = item1;
            end.next = null;
            oldend.next = end;
        }
        size++;
    }
    
    public void popFront() {
        if (start != null) {
            start = start.next;
            size--;
        }
    }
    
    public void popBack() {
        if (end != null) {
            Node old = start;
            while (old.next.next != null) {
                old = old.next;
            }
            old.next = null;
            end = old;
            size--;
        }
    }
    
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String s = "[";
            Node old1 = start;
            while (old1 != null) {
                s += old1.item + ", ";
                old1 = old1.next;
            }
            return s.substring(0, s.length() - 2) + "]";
        }
    }
}

public final class Solution {
    
    private Solution() {
        
    }
    
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Deque deque = new Deque();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "size":
                int a = deque.Size();
                System.out.println(a);
                break;
            case "pushLeft":
                deque.pushFront(Integer.parseInt(tokens[1]));
                System.out.println(deque);
                break;
            case "pushRight":
                deque.pushBack(Integer.parseInt(tokens[1]));
                System.out.println(deque);
                break;
            case "popLeft":
                if (!(deque.isEmpty())) {
                    deque.popFront();
                    System.out.println(deque);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight":
                if (!(deque.isEmpty())) {
                    deque.popBack();
                    System.out.println(deque);
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            default:
                break;
            }
        }
    }
}
