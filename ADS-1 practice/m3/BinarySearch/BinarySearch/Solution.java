import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static int Binarysearch(int[] array, int num) {
        int searchvalue = 0;
        int temp = 0;
        int start = 0;
        int size = array.length;
        int end = size;
        for (int j = 0; j < size; j++) {
            temp = (start + end)/2;
            if (array[temp] == num) {
                searchvalue = array[temp];
                break;
            } else {
                if (array[temp] > num) {
                    end = temp;
                } else {
                    start = temp;
                }
            }
        }
        return searchvalue;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the required num to be found");
        int num = sc.nextInt();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Binarysearch(array, num));
    }
}