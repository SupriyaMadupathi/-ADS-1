import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	MaxPQ<Stock> max = new MaxPQ<Stock>();
    	MinPQ<Stock> min = new MinPQ<Stock>();
    	int n = Integer.parseInt(sc.nextLine());
    	for (int i = 0; i < 6 * n; i++) {
    		String[] token = sc.nextLine().split(",");
    		Stock s = new Stock(token[0],Float.parseFloat(token[1]));
    		max.insert(s);
        }
        int a = Integer.parseInt(sc.nextLine());
        System.out.println(max);
    }
}