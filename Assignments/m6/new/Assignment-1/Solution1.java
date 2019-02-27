import java.util.Scanner;
class Linkedlistexample {
    class Node {
        String data;
        Node next;
    }
    Node head = null, tail;
    public void addbeg(String data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        // if(head == null) tail = node;
        head = node;
    }
    public void deletebeg() {
        Node temp=head;
        head = temp.next;
        // if(head==null){
        //     return head;
        // }
        // else if(head.data.equals(d)) {
        //     // System.out.println("hi");
        //     temp = head;
        //     head = head.next;
        //     return temp;
        // } 
        // return temp;
        
    }
    public void deleteend() {
        Node temp=head;
        // temp.next = head;
        
        // if(head==null){
        //     return head;
        // }
        // else{
            while(temp.next == null) {
                Node prev = null;
                
            }
        // }
    }
    public String returnNumber(  ) {
        String numer = "";
        Node thead = head;
        while(thead != null) {
            numer += thead.data + " ";
            thead = thead.next;
        }
        return numer;
    }
    
}
public class Solution1 {
	public static void main(String[] args) {
    	Linkedlistexample e = new Linkedlistexample();
    	Scanner scan = new Scanner(System.in);
    	int temp = scan.nextInt();
        scan.nextLine();
    	for(int i = 0; i  < temp; i++) {
            String[] tempst = scan.nextLine().split(" "); 
    		if(tempst[0].equals("add")) {
    			e.addbeg(tempst[1]);
    		}
            if(tempst[0].equals("deletebeg")) {
                e.deletebeg();
            }
            if(tempst[0].equals("deleteend")) {
                e.deleteend();
            }
            System.out.println(e.returnNumber());

    	}

    	

    }
}
