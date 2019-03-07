import java.util.*;
import java.util.Arrays;
import java.util.TreeSet;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		//BST bst = new BST();
		int[] a = new int[n];
		TreeSet<Student> set = new TreeSet<Student>();
		Student[] student = new Student[n];

		 Double[] num = new Double[n]; 
		for (int i = 0; i<n ; i++ ) {
			String[] s = sc.nextLine().split(","); 
			set.add(new Student(Integer.parseInt(s[0]), s[1], Double.parseDouble(s[2])));
		}
		int m = Integer.parseInt(sc.nextLine());
		Double[] number = new Double[m];
		int start = 0;
		int end = 0;
        for (int i = 0; i < m; i++) {
        	number[i] = Double.parseDouble(sc.nextLine());

        }   
        //System.out.println(Arrays.toString(number));
        /*int i = 0;
    	for (Student e : set) {
    		//System.out.println(e.getmarks());
    		if (e.getmarks().compareTo(number[i]) == 0) {
    			System.out.println(set.headSet(e).size());
    			i++;
    		}
    	}*/
    	for (int  i= 0; i <n ; i++ ) {
    		for (int j = 0; j < m; j++) {
    			if (student[i].getmarks().compareTo(number[j]) == 0) {
    			 	a[j] = i;
    			 } 
    			 System.out.println(Arrays.toString(a));
    		}
    	}
    	
	}
	
}
class Student implements Comparable<Student>{
	String name ;
	int roll;
	Double marks;

	Student(int i, String n, double m){
		this.name = n;
		this.roll = i;
		this.marks = m;
	}
	int getroll(){
		return this.roll;
	}
	int setroll(int r){
		return this.roll = r;
	}
	String getName(){
		return this.name;
	}
	String setName(String n){
		return this.name = n;
	}
	Double getmarks() {
		
		return this.marks;
	}
	Double setmarks(double m){
		return this.marks=m;
	}
	public int compareTo(Student that){
		
		if (this.getmarks() < that.getmarks()) {
			//System.out.println("getmarsks compare 1");
            
            return -1;
        } else if (this.getmarks() > that.getmarks()) {
        	//System.out.println("getmarks 2");
            return 1;
        } else {
            if (this.getName().compareTo(that.getName()) < 0) {
            	//System.out.println("getname  1");
                return -1;
            } else if (this.getName().compareTo(that.getName()) > 0) {
            	//System.out.println("getname 2");
                return 1;
            } else {
                if (this.getroll() < that.getroll()) {
                	//System.out.println("get roll1");
                    return -1;
                } else if (this.getroll() > that.getroll()) {
                	//System.out.println("getroll 2");
                    return 1;
                } 
                return 0;
            }
        }

	}
	String print(){
		return  this.getroll()+","+this.getName()+","+this.getmarks();
	}
}