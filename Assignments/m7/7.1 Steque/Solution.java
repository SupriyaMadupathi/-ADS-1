import java.util.Scanner;

class Node {
	String data;
	Node next;
	Node() {

	}
	Node(String data1) {
		this.data = data1;
	}
}
class Steque{
	Node start;
	Node end;
	int size;
	Steque() {
		size = 0;
		start = new Node();
		 end = new Node();
	}
	void push(String item) {
		//System.out.println("BHOOM");
		Node oldstart = new Node(item);
        if (size == 0) {
            start.data = item;
            start.next = null;
            end = start;
            size++;
            return;
        } 
        
        //start.data = item;
        oldstart.next = start;
        start = oldstart;
        size++;
        //System.out.println(start.data);
    }
    void enque(String items) {
        if (size == 0) {
            end.data = items;
            end.next = null;
            start = end;
            size++;
            return;
        } 
            Node oldend = new Node(items);
            end.next = null;
            end.next = oldend;
            end = oldend;
            size++;
        
        
    }
    String pop() throws Exception{
    	if (size == 0) {
    		throw new Exception("Steque is empty.");
    	}
		String data = start.data;
		start = start.next;
		size--;
		return data;
	}
	boolean isEmpty(){
		if (size==0) {
			return true;
		}else 
		return false;
	}
	public String toString() {
		if (size != 0) {
			String str = "";
            Node temp = start;
            while (temp != null) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
		}
        	//System.out.println("Helle");
            
        
      return "[]";
    }
}
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int lines =  Integer.parseInt(s.nextLine());
		Steque sq = new Steque();
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(" ");
			switch (tokens[0]) {
				case "push":
				sq.push(tokens[1]);
				System.out.println(sq.toString());
				break;
				case "pop":
				try{
			        sq.pop();
			        if (!sq.isEmpty()) {
			            System.out.println(sq);	
			        } else {
			        	System.out.println("Steque is empty.");
			        }
					} catch(Exception e){
					System.out.println(e.getMessage());
			}
			break;
				case "enqueue":
				sq.enque(tokens[1]);
				System.out.println(sq);
				break;
				default :
				sq = new Steque();
				System.out.println();
				break;
			}
	}
}
}