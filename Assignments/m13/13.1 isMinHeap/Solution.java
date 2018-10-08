import java.util.Scanner;
/**
 * Class for minimum heap.
 *
 * @param      <E>   { parameter_description }
 */
class MinHeap<E extends Comparable<E>> {
    /**
     * { arr }.
     */
    private E[] arr;
    /**
     * Constructs the object.
     *
     * @param      a  The arr
     */
    MinHeap(final E[] a) {
        this.arr = a;
    }
    //this method has complexity of n.
    // time complexity is O(n)
    /**
     * Determines if minimum heap.
     *
     * @param      a1  The a1.
     *
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap(final E[] a1) {
        for (int i = 0; i < a1.length - 1; i++) {
            if (!less(a1[i], a1[i + 1])) {
                return false;
            }
        }
        return true;
    }
    //this method takes constant time complexity
    // time complexity is O(1) 
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final E i, final E j) {
        return i.compareTo(j) <= 0;
    }

}
/**
 * Client program.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
        //for check style purpose.
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        switch (line) {
            case "String":
            int n = Integer.parseInt(s.nextLine());
            for (int i = 0; i < n; i++) {
                String[] tokens = s.nextLine().split(",");
                MinHeap<String> m = new MinHeap<String>(tokens);
                System.out.println(m.isMinHeap(tokens));

            }
            break;
            case "Integer":
            int a = Integer.parseInt(s.nextLine());
            for (int i = 0; i < a; i++) {
                String str = s.nextLine();
                String[] tokens = str.split(",");
                Integer[] intarr = new Integer[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    intarr[j] = Integer.parseInt(tokens[j]);
                }
            MinHeap<Integer> m = new MinHeap<Integer>(intarr);
                System.out.println(m.isMinHeap(intarr));
            }
            break;
            case "Float":
            int b = Integer.parseInt(s.nextLine());
            for (int i = 0; i < b; i++) {
                String string = s.nextLine();
                if (string.equals("")) {
                    System.out.println("false");
                } else {
                String[] tokens = string.split(",");
                Float[]  floarr = new Float[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    floarr[j] = Float.parseFloat(tokens[j]);
                }
                MinHeap<Float> m = new MinHeap<Float>(floarr);
                System.out.println(m.isMinHeap(floarr));
            }
            }
            break;
            case "Double":
            int c = Integer.parseInt(s.nextLine());
            for (int i = 0; i < c; i++) {
                String st = s.nextLine();
                String[] tokens = st.split(",");
                Double[]  douarr = new Double[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    douarr[j] = Double.parseDouble(tokens[j]);
                }
                MinHeap<Double> m = new MinHeap<Double>(douarr);
                System.out.println(m.isMinHeap(douarr));
            }
            break;
            default:
            break;
        }
    }
}
