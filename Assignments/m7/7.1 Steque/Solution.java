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
		Node oldstart = new Node();
        if (start == null) {
            start.data = item;
            start.next = null;
            end = start;
            size++;
            return;
        } 
        oldstart = start;
        start.data = item;
        start.next = oldstart;
        size++;
        //System.out.println(start.data);
    }
    void enque(String items) {
        if (end == null) {
            end.data = items;
            end.next = null;
            start = end;
            size++;
        } else {
            Node oldend = end;
            end.data = items;
            end.next = null;
            oldend.next = end;
        }
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

        	//System.out.println("Helle");
            String str = "";
            Node temp = start;
            while (temp != end) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        
       // return "[]";
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
					System.out.println(sq);
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