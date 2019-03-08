import java.util.*;
import java.util.TreeSet;
import java.util.PriorityQueue;
class Solution{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(sc.nextLine());
		MaxPQ<Student> max = new MaxPQ();
		while(sc.hasNext()){
			String[] data = sc.nextLine().split(" ");
			if (data[0].equals("Apply") ) {
				// System.out.println(data);
				String[] s2 = data[1].split(",");
				max.insert(new Student(Integer.parseInt(s2[0]), s2[1], s2[2], Double.parseDouble(s2[3])));
			} else if (data[0].equals("Recruit_Top_Candidate")) {
				System.out.println(max.delMax());
			} else if (data[0].equals("Ranking")) {
				System.out.println();
				int j = 1;
				while(!max.isEmpty()){
					System.out.println(j+": "+max.delMax());
					j++;
				}

				 
			}

			
		}
	}
}
class Student implements Comparable<Student>{
	int roll;
	String name;
	String degree;
	Double percentage;
	Student(int r, String n, String d, Double p){
		this.roll = r;
		this.name = n;
		this. degree = d;
		this.percentage = p;
	}
	int getroll(){
		return this.roll;
	}
	String getname(){
		return this.name;
	}
	String getdegree(){
		return this.degree;
	}
	Double getpercent(){
		return this.percentage;
	}
	public int compareTo(Student that){
		if (this.getpercent().compareTo(that.getpercent()) > 0) {
			return 1;
		} else if (this.getpercent().compareTo(that.getpercent()) < 0) {
			return -1;
		} else{
			
				if (this.getroll() > that.getroll()) {
					return -1;
				} else if (this.getroll() < that.getroll()) {
					return 1;
				}
			
		}
		return -1;
	}
	public String toString(){
		return this.getroll()+","+this.getname()+","+this.getdegree()+","+this.getpercent();
	}
}