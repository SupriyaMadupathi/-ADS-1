import java.util.Scanner;

/**
 * Class for student.
 */
class Student {
    /**
     * { for roll number }.
     */
    private String rollnumber;
    /**
     * { for name }.
     */
    private String name;
    /**
     * {marks }.
     */
    private double marks;
    /**
     * Constructs the object.
     */
    Student() {

    }
    /**
     * Constructs the object.
     *
     * @param      rollnumber1  The roll number 1
     * @param      name1         The name 1
     * @param      marks1        The marks 1
     */
    Student(final String rollnumber1, final String name1, final double marks1) {

        rollnumber = rollnumber1;
        name = name1;
        marks = marks1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * { gets roll_number}.
     *
     * @return     {roll number }
     */
    public String gerRollnumber() {
        return rollnumber;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public Double getTotal() {
        return marks;
    }
}
/**
 * { Solution}.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
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
            if (!l1.contains(query[1])) {
                System.out.println("Student doesn't exists...");
                //break;
            }
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
