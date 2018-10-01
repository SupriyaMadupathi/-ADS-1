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
        if (start == null) {
            start.data = item;
            start.next = null;
            end = start;
        } else {
            Node oldstart = start;
            start.data = item;
            start.next = oldstart;
        }
        size++;
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
        if (size != 0) {
            String str = "";
            Node end = start;
            while (end != null) {
                str += end.data + ", ";
                end = end.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "[]";
    }
}
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int lines =  Integer.parseInt(s.nextLine());
		Steque str = new Steque();
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(" ");
			switch (tokens[0]) {
				case "push":
				str.push(tokens[1]);
				System.out.println(str);
				break;
				case "pop":
				try{
			        str.pop();
					System.out.println(str);
					} catch(Exception e){
					System.out.println(e.getMessage());
			}
			break;
				case "enque":
				str.push(tokens[1]);
				System.out.println(str);
				break;
				default :
				str = new Steque();
				System.out.println();
				break;
			}
	}
}
}