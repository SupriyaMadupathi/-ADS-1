import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	MaxPQ<Stock> max = new MaxPQ<Stock>();
    	MinPQ<Stock> min = new MinPQ<Stock>();
    	int n = Integer.parseInt(sc.nextLine());
    	for (int i = 0; i < 6 * n; i++) {
    		String lines = sc.nextLine();
    		String[] token= lines.split(",");
    		Stock s = new Stock(token[0],Float.parseFloat(token[1]));
    		max.insert(s);
        }
        int a = Integer.parseInt(sc.nextLine());
    }
}