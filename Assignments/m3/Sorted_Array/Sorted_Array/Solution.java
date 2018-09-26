import java.util.Scanner;
import java.util.Arrays;
class SortedArray {
	private int[] array1;
	private int[] array2;
	int size1;
	int size2;
	private int[] resultant;
	SortedArray(int[] ar1, int[] ar2) {
		this.array1 = ar1;
		this.array2 = ar2;
		this.size1 = array1.length;
		this.size2 = array2.length;
		this.resultant = new int[size1+size2];
	}
	public int[] sort(int[] a1,  int[] a2) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < size1 && j <size2) {
            if (a1[i] < a2[j]) {
                this.resultant[k++] = a1[i++];
            } else {
                this.resultant[k++] = a2[j++];
            }
        }
        while (i < size1) {
            this.resultant[j++] = a1[i++];
        }
        while (j <size2) {
            this.resultant[k++] = a2[j++];
        }
        return this.resultant;
    }
}

public final class Solution {
    
    private Solution() {
    }
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


