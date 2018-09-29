import java.util.Scanner;
import java.lang.String;
class Node {
    char data;
    Node next;

    Node() {}

    Node(char item1) {
        this.data = item1;
        this.next = null;
    }
}
class Iterator {
    Node top;

    public Iterator(Node head) {
        top = head;
    }

    public boolean hasNext() {
        return top != null;
    }

    public char next() {
        char dt = top.data;
        top = top.next;
        return dt;
    }
}

class LinkedList {


    private Node head;

    public void insert(char item) {
        Node temp = new Node(item);
        temp.next = head;
        head = temp;
    }

    public boolean isEmpty1() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    public char getData(Node node) {
        return node.data;
    }

    public Node getNext(Node node) {
        return node.next;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
class AddLargeNumbers {
    AddLargeNumbers() {

    }
    
    public static LinkedList numberToDigits(String number) {
        LinkedList digits = new LinkedList();
        for(int i =0; i < number.length(); i++) {
            digits.insert(number.charAt(i));
        }
    return digits;
}

    public static String digitsToNumber(LinkedList list) {
        String num = "";
        String num1 = "";
        Iterator flow = new Iterator(list.getHead());
        while (flow.hasNext()) {
            num += flow.next();
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            num1 += num.charAt(i);
        }
        return num1;
    }


    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return null;
}

public class Solution {
    Solution() {
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                LinkedList pDigits1 = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits1 = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits1, qDigits1);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
            default:
                break;
        }
    }
    
}
}
