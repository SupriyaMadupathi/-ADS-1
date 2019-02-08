import java.util.Scanner;
import java.util.Arrays;

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
	
public int compareTo(final Student that) {

        if (this.getName() == that.getName()) {
            return 1;
        } else if (this.getName() != that.getName()) {
            return -1;
        } else {
        if (this.getRollno() == that.getRollno()) {
            return -1;
        } else if (this.getRollno() != that.getRollno()) {
            return 1;
        } else {
            if (this.getMarks() < that.getMarks()) {
                return 1;
            } else if (this.getMarks() > that.getMarks()) {
                return -1;
            }
        }
        }
        return 0;
    }
    class Sorting {
        
    private final int fifty = 50;
    
    private Student[] marks;
    
    private int size;

    
    Sorting() {

        marks = new Student[fifty];
        size = 0;
    }
    public void add(final Student r) {

        marks[size++] = r;
        if (size > fifty) {
            resize();
        }
    }
    void resize() {

        marks = Arrays.copyOf(marks, size * 2);
    }
    void exchange(final Student[] a, final int i, final int min) {

        Student temp = a[min];
        a[min] = a[i];
        a[i] = temp;
    }
    public String toString() {

        String s = "";
        for (int i = 0; i < size; i++) {
            s += marks[i].getName() + ",";
        }
        return s.substring(0, s.length() - 1);
    }
    public void insertionSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (!less(marks, j - 1, j)) {
                    break;
                } else {
                    exchange(marks, j - 1, j);
                }
                }
            }
        }

    boolean less(final Student[] marks, final int j, final int min) {

        return marks[j].compareTo(marks[min]) > 0;
    }
}
class Solution{
	Solution() {

	}
	public  void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	Sorting  s = new Sorting();
    	while (sc.hasNextLine()) {
    		String stu = sc.nextLine();
    		String[] data = stu.split(",");
    		Student marks = new Student(data[0],
                (data[1]), Double.parseDouble(data[2]));
    		s.add(marks);

    	}
    	s.insertionSort();
    	System.out.println(s.toString());
	}
}
}
       

