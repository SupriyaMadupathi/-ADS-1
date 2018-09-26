import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted array.
 */
class SortedArray {
     /**
     * {Initializing an integer array1}.
     */
    private int[] array1;
    /**
     * {Size of 1st array}.
     */
    private int[] array2;
    /**
     * {Initializing an integer array2}.
     */
    private int size1;
    /**
     * {Size of 2nd array}.
     */
    private int size2;
    /**
     * {Initializing an integer array3}.
     */
    private int[] resultant;
    /**
     * Constructs the object.
     *
     * @param      ar1   The archive 1
     * @param      ar2   The archive 2
     */
    SortedArray(final int[] ar1, final int[] ar2) {

        this.array1 = ar1;
        this.array2 = ar2;
        this.size1 = array1.length;
        this.size2 = array2.length;
        this.resultant = new int[size1 + size2];
    }
    /**
     * {method to sort ayyars}.
     *
     * @param      a1    A 1
     * @param      a2    A 2
     *
     * @return     { description_of_the_return_value }
     */
    public int[] sort(final int[] a1, final int[] a2) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < size1 && j < size2) {
            if (a1[i] < a2[j]) {
                this.resultant[k++] = a1[i++];
            } else {
                this.resultant[k++] = a2[j++];
            }
        }
        while (j < size2) {
            this.resultant[k++] = a2[j++];
        }
        return this.resultant;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        int sc1 = Integer.parseInt(scan.nextLine());
        int sc2 = Integer.parseInt(scan.nextLine());
        int[] ar1 = new int[sc1];
        int[] ar2 = new int[sc2];
        if (sc1 > 0) {
            String[] tokens = scan.next().split(",");
            for (int i = 0; i < sc1; i++) {
                ar1[i] = Integer.parseInt(tokens[i]);
            }
        }
        if (sc2 > 0) {
            String[] tokensc1 = scan.next().split(",");
            for (int i = 0; i < sc2; i++) {
                ar2[i] = Integer.parseInt(tokensc1[i]);
            }
        }
        SortedArray sa = new SortedArray(ar1, ar2);
        int[] a = sa.sort(ar1, ar2);
        System.out.println(Arrays.toString(a).substring(
            1, Arrays.toString(a).length() - 1).replace(" ", ""));
    }
}



