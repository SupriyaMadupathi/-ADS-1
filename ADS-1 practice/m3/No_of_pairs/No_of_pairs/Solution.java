import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution(){

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size");
		int s = sc.nextInt();
		int c = 1;
		int [] array = new int[s];
		System.out.println("enter elements");
		for (int i= 0; i<s; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		int sum = 0;
		System.out.println("sorted array is " +Arrays.toString(array));
		for (int i = 0; i< s-1; i++) {
			if (i == s -2 && array[i] == array[i+1]) {
				c++;
				sum += c * (c -1) /2;
				c = 1;
				break;
			} if (array[i] == array[i+1]) {
				c++;
				continue;
			} if (c>1 && array[i] != array[i+1]) {
				sum += c * (c-1)/2;
				c =1;
				
			}
		}
		System.out.println("count : " + sum);
	}

}