import java.util.Scanner;

class Student  {
	 String name;
	 int roll_number;
	 double marks;

	 Student(){

	 }
	 Student(String name1, int roll1, double marks1){
	 	this.name= name1;
	 	this.roll_number = roll1;
	 	this.marks = marks1;
	 }
	 public String getName(){
	 	return name;
	 }
	 public int getRoll_number(){
	 	return roll_number;
	 }
	 public double getMarks(){
	 	return marks;
	 }
	 
}
class Solution {
	Solution(){

	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Student details = new Student();
		LinearProbingHashST<String, Integer> l1 = new LinearProbingHashST();
		LinearProbingHashST<String, Double> l2 = new LinearProbingHashST();
        int lines = Integer.parseInt(sc.nextLine());
        for (int i=0; i<lines;i++){
        	String stu = sc.nextLine();
        	String[] tokens = stu.split(",");
        	details = new Student(tokens[0], Integer.parseInt(tokens[1]),
                Double.parseDouble(tokens[2]));
             l1.put(tokens[0], Integer.parseInt(tokens[1]));
             l2.put(tokens[0], Double.parseDouble(tokens[2]));
            }
            int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String que = sc.nextLine();
            String[] query = que.split(" ");
            switch (query[2]) {
                case "1":
                    System.out.println(l1.get(query[1]));
                break;
                case "2":
                System.out.println(l2.get(query[1]));
                break;
                default:
                break;
            }
        }

	}
}