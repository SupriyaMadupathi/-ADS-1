import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {

    /**
     * { var_description }
     */
    private WeightedQuickUnionUF wqf;

    private int n;
    private int size;
    private int row;
    private int col;
    private boolean[] connected;
    private int count;
    //
    // create n-by-n grid, with all sites blocked
    //
    // @param      n1    The n 1
    //
   public Percolation(final int n1) {

    this.n = n1;
    this.count = 0;
    this.size = n1 * n1;
    this.row = size;
    this.col = size + 1;
    connected = new boolean[size];
    wqf = new WeightedQuickUnionUF(size + 2);
    for (int i = 0; i < n; i++) {
        wqf.union(row, i);
        wqf.union(col, size - i - 1);
    }
   }   

   /**
    * { function_description }
    *
    * @param      i     { parameter_description }
    * @param      j     { parameter_description }
    *
    * @return     { description_of_the_return_value }
    */
   public int component(final int i, final int j) {

        return n * (i - 1) + j - 1;
   }

   /**
    * Links open sites.
    *
    * @param      r   The row
    * @param      c   The col
    */
   private void linkOpenSites(final int r, final int c) {

    if (connected[c] && !wqf.connected(r, c)) {
        wqf.union(r, c);
    }
   }
   /**
    * { function_description }
    *
    * @return     { description_of_the_return_value }
    */
   public int numberOfOpenSites() {

    return count;
   }   
   /**
    * { returns void}.
    *
    * @param      r   The row
    * @param      c   The col
    */
   public void open(final int r, final int c) {

    int index = component(r, c);
    connected[index] = true;
    count++;
    int bottom = index + n;
    int top = index - n;
    if (n == 1) {
        wqf.union(r, index);
        wqf.union(c, index);

    }
    if (bottom < size) {
        linkOpenSites(index, bottom);
    }
    if (top >= 0) {
        linkOpenSites(index, top);
    }
    if (c == 1) {
        if (c != n) {
            linkOpenSites(index, index + 1);
        }
        return;
    }
        if (c == n) {
        linkOpenSites(index, index - 1);
        return;
    }
    linkOpenSites(index, index + 1);
    linkOpenSites(index, index - 1);


   }
   /**
    * Determines if open.
    *
    * @param      r   The row
    * @param      c   The col
    *
    * @return     True if open, False otherwise.
    */
   public boolean isOpen(final int r, final int c) {

    return connected[component(r, c)];
   }
   /**
    * { returns bool }.
    *
    * @return     { description_of_the_return_value }
    */
   public boolean percolates() {
    return wqf.connected(row, col);
   }
}
/**
 * { item_description }.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * { main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Percolation p = new Percolation(n);
        // int i = 0;
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            p.open(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]));
            // i++;
        }
        System.out.println(p.percolates()
            && p.numberOfOpenSites() != 0);

    }
}