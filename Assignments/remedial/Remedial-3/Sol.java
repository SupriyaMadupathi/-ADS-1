import java.util.Scanner;
import java.util.HashMap;

class Student {
    
    private String rollNo;
    
    private String name;
    
    private Double marks;
    
    Student(final String r, final String n, final Double m) {
        this.rollNo = r;
        this.name = n;
        this.marks = m;
    }
    
    public String getRollNo() {
        return rollNo;
    }
   
    public String getName() {
        return name;
    }
    
    public Double getMarks() {
        return marks;
    }
}

final class Solution {
    
    private Solution() {
        
  }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashMap<String, Student> hm = new HashMap<String, Student>();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] inputs = sc.nextLine().split(",");
            hm.put(inputs[0], new Student(inputs[0], inputs[1],
                Double.valueOf(inputs[2])));
        }
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String inputs = sc.nextLine();
            switch (inputs[2]) {
                case "1":
                Student s = (hm.get(inputs[2]));
                if (s == null) {
                    System.out.println("This marks are not awarded to any student");
                    break;
                }
                System.out.println(s.getName());
                break;
                case "2":
                Student st = hm.get(inputs[2]);
                if (st == null) {
                    System.out.println(
                        "This marks are not awarded to any student");
                    break;
                }
                System.out.println(st.getMarks());
                break;
                default:
                break;
            }
        }
    }
    }
