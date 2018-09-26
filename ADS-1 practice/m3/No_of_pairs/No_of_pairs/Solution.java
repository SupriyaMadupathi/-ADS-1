import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution(){

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size");
		int s = sc.nextInt();
		int c = 0;
		int [] array = new int[s];
		System.out.println("enter elements");
		for (int i= 0; i<s; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		System.out.println("sorted array is " +Arrays.toString(array));
		for (int i = 1; i< s; i++) {
			if (array[i] == array[i-1]) {
				c++;
			}
		}
		System.out.println("count : " + c);
	}

}