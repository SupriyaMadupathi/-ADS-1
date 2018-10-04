import java.util.Scanner;
/**
 * { item_description }
 */
final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
     }
    /**
     * { main method }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Merge m = new Merge();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String tokens = s.nextLine();
            String[] lines = tokens.split(",");
            m.sort(lines);
            System.out.println(m.toString(lines));
            System.out.println();
        }
    }
}

