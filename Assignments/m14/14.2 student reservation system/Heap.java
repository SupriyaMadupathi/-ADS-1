import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Class for Heap.
 */
class Heap {
//this method has constant time complexity.
// time complexity is O(1)
  /**
   * { function_description }.
   *
   * @param      v     { parameter_description }
   * @param      w     { parameter_description }
   *
   * @return     { description_of_the_return_value }
   */
  private static boolean less(final Comparable v, final Comparable w) {
    return v.compareTo(w) < 0;
  }
//this method has constant time complexity.
// time complexity is O(1)
  /**
   * { function_description }.
   *
   * @param      a     { parameter_description }
   * @param      i     { parameter_description }
   * @param      j     { parameter_description }
   */
  private static void exchange(final Comparable[] a, final int i, final int j) {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }
//this method has complexity of n.
// time complexity is O(n)
  /**
   * Sorts the elements using insertion sort.
   * @param a contains elements that are to be sorted.
   */
  public static void sort(final Comparable[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j > 0; j--) {
        if (less(a[j], a[j - 1])) {
          exchange(a, j, j - 1);
        } else {
          break;
        }
      }
    }
  }
}
