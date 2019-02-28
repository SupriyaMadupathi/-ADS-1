import java.util.Scanner;
class Node {
    String item;
    Node link;
    Node() {

    }
    Node(String i) { 
        this.item = i;
    }
    public String getData() {
        return item;
    }
}
class LinkedList {
    Node start;
    int size;
    LinkedList() {
        size = 0;
    }
    public  void insert(String data) {
        Node obj = new Node(data);
        if(size==0){
            start = obj;
            size++;
            return ;
        }
        Node temp = start;
        while(temp.link!=null){
            temp = temp.link;
        }
        temp.link = obj;
        size++;
    }
    // public String remove() {
    //  String temp = first.data;
    //  first = first.link;
    //  size--;
    //  return temp;
    // }
    public String getdata() {
        String str = "";
        Node tem = start;
        while (tem.link != null) {
            str += tem.item;
            tem = tem.link;
        }
        str += tem.item;
        return str;
    }
}
class Stack {
    int[] data;
    int size;
    Stack(String data) {
        this.data = new int[data.length()];
        size = 0;
    }
    Stack(int data) {
        this.data = new int[data+1];
        size = 0;
    }
    public void push(int item) {
        data[size++] = item;
    }
    public int pop() {
        int s = data[--size];
        return s;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
class AddLargeNumbers {
    LinkedList list = new LinkedList();
    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        String[] num = number.split("");
        for (int i = 0; i < num.length; i++) {
            list.insert(num[i]);
        }
        // list.insert(number);
            return list;
    }
    public static String digitsToNumber(LinkedList list) {
        String s = "";
            s += list.getdata();
        return s;
    }
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList res = new LinkedList();
        String no1 = list1.getdata();
        String no2 = list2.getdata();
        int max = 0;
        Stack s1 = new Stack(list1.getdata());
        Stack s2 = new Stack(list2.getdata());
        if (list1.getdata().length() > list2.getdata().length()) {
            max = list1.getdata().length();
        } else {
            max = list2.getdata().length();
        }
        for (int i = 0; i < no1.length(); i++) {
            char c = no1.charAt(i);
            s1.push(Integer.parseInt(String.valueOf(c)));
        }
        for (int j = 0; j < no2.length(); j++) {
            char ch = no2.charAt(j);
            s2.push(Integer.parseInt(String.valueOf(ch)));
        }
        Stack s3 = new Stack(max);
        int carry = 0;
        int total = 0;
        int oper1;
        int oper2;
        while (true) {
            oper1 = 0;
            oper2 = 0;
            if (s1.isEmpty() && s2.isEmpty()) {
                break;
            }
            if (!s1.isEmpty()) {
                oper1 = s1.pop();
            }
            if (!s2.isEmpty()) {
                oper2 = s2.pop();
            }
            total = oper1 + oper2 + carry;
            if (total > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            s3.push(total%10);
        }
        if (list1.getdata().length() == list2.getdata().length()) {
            s3.push(carry);
        }
        while (!s3.isEmpty()) {
            res.insert(Integer.toString(s3.pop()));
        }
        return res;
    }
}
public class Solution1 {
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
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}