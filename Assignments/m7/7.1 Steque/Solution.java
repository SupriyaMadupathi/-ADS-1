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
class LinkedList {
	Node start;
	Node end;
	int size;
	LinkedList() {
		size = 0;
		start = new Node();
		 end = new Node();
	}
	void insert(String item) {
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

        } else {
            Node oldend = end;
            end.data = items;
            end.next = null;
            oldend.next = end;
        }
        size++;
    }
	String delete(){
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
	int size() {
		return size;
	}
}
class Steque{
	LinkedList ll ;
	Steque (){
		ll = new LinkedList();
	}
	void push(String data){
		ll.insert(data);
	}
	String pop(){
		return ll.delete();
	}
	boolean isEmpty(){
		return ll.isEmpty();
	}
	int size(){
		return ll.size();
	}
	/*public String toString() {
		Node end = start;
		String res = "";
		while(end!=null) {

		}
	}*/
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
				str.pop();
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