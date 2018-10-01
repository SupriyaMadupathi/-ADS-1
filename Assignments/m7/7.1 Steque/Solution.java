import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constrcutor.
    }

    /**
     * { main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int lines =  Integer.parseInt(s.nextLine());
        Steque sq = new Steque();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            switch (tokens[0]) {
                case "push":
                sq.push(tokens[1]);
                System.out.println(sq.toString());
                break;
                case "pop":
                try {
                    sq.pop();
                    if (!sq.isEmpty()) {
                        System.out.println(sq);
                    } else {
                        System.out.println("Steque is empty.");
                    }
                    } catch (Exception e) {
                    System.out.println(e.getMessage());
            }
            break;
                case "enqueue":
                sq.enque(tokens[1]);
                System.out.println(sq);
                break;
                default :
                sq = new Steque();
                System.out.println();
                break;
            }
    }
}
}