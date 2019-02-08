class Student {
	String rollno;
	String name;
	Double marks;

	Student() {

	}
	Student(String na, String r, Double m) {
		this.rollno = r;
		this.name = na;
		this.marks = m;
	}
	String getRollno() {
		return this.rollno;
	}
	String getName() {
		return this.name;
	}
	Double getMarks() {
		return this.marks;
	}
	
}
class Node {
	Student data;
	int val;
	Node n1;
	Node n2;
	Node(Student k, int v) {
		this.data = (k);
		this.val = v;
	}
}

class BinarySt<Key extends Comparable<Key>, Value> {
	Node root;
	Student Student;
	int value;
	BinarySt() {

	}
	void put(Student key, int val) {
		root = put(root, key, val);
	}
	//this method has the complexity of n log n.
	//the complexity is O(n log n)
	Node put(Node x, Student key, int val) {
		if (x == null) {
			return new Node(key, val);
		}
		int temp = key.getName().compareTo(x.data.getName());
		if (temp < 0) {
			x.n1 = put(x.n1, key, val);
		}
		else if (temp > 0) {
			x.n2 = put(x.n2, key, val);
		}
		else if (temp == 0) {
			x.val = val;
		}
		return x;
	}
	//this method has the complexity of n log n.
	//the complexity is O(n log n)
	Integer get(Student key) {
		Node x = root;
		while (x != null) {
			int cmp = key.getName().compareTo(x.data.getName());
			if (cmp < 0) {
				x = x.n1;
			}
	        if (cmp > 0) {
	        	x = x.n2;
	        }
	        if (cmp == 0) {
	        	return x.val;
	        } 	
		}
		return null;
	}
}
