import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        final int thousand = 1000;
        while (sc.hasNextLine()) {
            String[] token = sc.nextLine().split(" ");
            int ip1 = Integer.parseInt(token[0]);
            int ip2 = Integer.parseInt(token[1]);
            int n = thousand;
            MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
                for (int i = 1; i <= n; i++) {
                pq.insert(new Taxicab(i, i));
            }
            int pair = 1;
            Taxicab previous = new Taxicab(0, 0);
            int match = 0;
            while (!pq.isEmpty()) {
                Taxicab cs = pq.delMin();
                if (previous.sum == cs.sum) {
                    pair++;
                    if (pair == ip2) {
                        match = match + 1;
                    }
                    if (match == ip1) {
                        System.out.println(previous.sum);
                        break;
                    }
                } else {
                    pair = 1;
                }
                previous = cs;
                if (cs.j < n) {
                    pq.insert(new Taxicab(cs.i, cs.j + 1));
                }
            }
        }
    }
}
