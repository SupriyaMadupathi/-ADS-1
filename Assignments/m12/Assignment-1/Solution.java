import java.util.Scanner;
import java.util.*;
class Student implements Comparable<Student> {
    String name;
    String dob;
    int sub1;
    int sub2;
    int sub3;
    int total;
    String caste;
    Student(String nm, String d, int s1, int s2, int s3,int t, String c) {
        this.name = nm;
        this.dob = d;
        this.sub1 = s1;
        this.sub2 = s2;
        this.sub3 = s3;
        this.total = t;
        this.caste = c;
    }
    public String toString() {
        return this.name + this.total;
    }
    public String getdob() {
        return this.dob;
    }
    public int getSub1() {
        return this.sub1;
    }

    public int getSub2() {
        return this.sub2;
    }
    public int getSub3() {
        return this.sub3;
    }
    public int getTotal() {
        return this.total;
    }
    public String getc() {
        return this.caste;
    }


    public int compareTo(Student that){
        if(this.total < that.total){
            return -1;
        }else if(this.sub3 > that.sub3){
            return 1;
        }else if(this.sub2 < that.sub2){
            return 1;
        }
        return 0;
    }
}
class Sorting {
    
    public Sorting() {

    }
 
    public void selectionSort(Comparable[] array, int size) {
        int n = size;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(array, i, j)) {
                    exchange(array, j, min);
                }
            }
        }
    }

    public boolean less(Comparable[] arr, int index1, int index2) {
        return arr[index1].compareTo(arr[index2]) < 0;
    }
 
    public void exchange(Comparable[] a, int index1, int index2) {
        Comparable temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
 
    public String show(Comparable[] array, int size) {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += array[i].toString() + ",";
        }
        return s.substring(0, s.length() - 1);
    }
}
/**.
 *Class for Solution.
 */
public final class Solution {
     
    private Solution() {
    }
    public static void main(final String[] args) {
        Student[] student = new Student[25];
        int size = 0;
        Scanner sc = new Scanner(System.in);
        Sorting t = new Sorting();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
           /* System.out.println(Arrays.toString(line));*/
            if (line.length > 1) {
                student[size] = new Student(line[0], line[1],
                     Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]),Integer.parseInt(line[5]), line[6]);
        }
        }
        System.out.println(t.show(student, size ));
    }
}
