import java.util.*;
class Node{
    String data;
    Node next;
    Node(String val) {
        this.data=val;
    }
}
class LinkedList {
    Node head;
    int size;
    LinkedList() {
        head = null;
        size =0;
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    void insertAt(int pos, String val)throws Exception{
        if (pos<0 || pos>size) {
        throw new Exception();          
        }
        Node obj = new Node(val);
        /*if (pos==0) {
            obj.next =head;
            head =obj;
            size++;
            return;
        }*/
        head=insertAt(pos,head,obj,0);
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    Node insertAt(int pos, Node first, Node obj, int count) throws Exception{
        if (pos == count) {
            obj.next =first;
            size++;
            return obj;
        }
        first.next = insertAt(pos,first.next,obj,count+1);
        return first;
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    void reverse(){
        reverse(null,head);
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    void reverse(Node previous, Node current){
        if (current!=null) {
            reverse(current,current.next);
            current.next= previous;
        }else {
            head =previous;
        }
    }
    // time complexity for this method is constant
    //takes O(1) time complexity
    void display(){
        Node temp = head;
        String str = "";
        while(temp!=null){
            str += temp.data+ ", ";
            temp = temp.next;
        }
        System.out.println(str.substring(0, str.length() - 2));

    }
    } 