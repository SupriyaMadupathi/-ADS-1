import java.util.Scanner;

class Student {
    
    private String roll_number;
    
    private String name;
    
    private double marks;
    
    Student() {
    }
    
    Student(final String roll_number1, final String name1, final double marks1) {
        roll_number = roll_number1;
        name = name1;
        marks = marks1;
    }
    
    public String getName() {
        return name;
    }
    
    public String gerRollnumber() {
        return roll_number;
    }
    
    public Double getTotal() {
        return marks;
    }
}

final class Solution {
    
    private Solution() {

    }
    
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Student details = new Student();
        LinearProbingHashST<String, String> l1 = new LinearProbingHashST();
        LinearProbingHashST<String, Double> l2 = new LinearProbingHashST();
        int range = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < range; i++) {
             String stu = sc.nextLine();
             String[] tokens = stu.split(",");
             details = new Student(tokens[0], tokens[1],
                Double.parseDouble(tokens[2]));
             l1.put(tokens[0], tokens[1]);
             l2.put(tokens[0], Double.parseDouble(tokens[2]));
            }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String stu = sc.nextLine();
            String[] query = stu.split(" ");
            
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