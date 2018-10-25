import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * client class.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> hash =
        new SeparateChainingHashST<String, Integer>();
        String integer = scan.nextLine();
        String[] arr = scan.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (hash.contains(arr[i])) {
                hash.put(arr[i], hash.get(arr[i]) + 1);
            } else {
                hash.put(arr[i], 1);
            }
        }
        String[] search = scan.nextLine().split(" ");
        for (int i = 0; i < search.length; i++) {
            if (hash.contains(search[i])) {
                if (hash.get(search[i]) == 0) {
                    System.out.print("No");
                    return;
                } else {
                    hash.put(search[i], hash.get(search[i]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}