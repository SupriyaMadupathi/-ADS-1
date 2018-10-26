import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        LinearProbingHashST<String, Integer> l = new
        LinearProbingHashST<>();
        for (int i = 0; i <= r; i++) {
            String[] temp = sc.nextLine().split(" ");
            switch (temp[0]) {
                case "put": l.put(temp[1],
                    Integer.parseInt(temp[2]));
                break;
                case "display":
                    if (l.size() == 0) {
                    System.out.println("{}");
                } else {
                    String str = "";
                    for (String s1: l.keys()) {
                        str += s1 + ":" + l.get(s1) + ", ";
                    }
                    System.out.println("{" + str.substring(
                        0, str.length() - 2) + "}");
                }
                break;
                case "delete":
                l.delete(temp[1]);
                break;
                case "get":
                System.out.println(l.get(temp[1]));
                break;
                default:
                break;
            }
        }
    }
}
