import java.util.*;
// public class percocolation {
//    public percocolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percocolates()              // does the system percocolate?
// }


// You can implement the above API to solve the problem
 class percocolation {
		int[][] grid;
		int openSite;
		WeightedQuickUnionUF wqu;
		int n;
	 percocolation(int n)
	{
		grid = new int[n][n];
		openSite = 0;
		wqu = new WeightedQuickUnionUF((n*n)+2);
		n = n;
	}
	public void open(int row, int col){
		row = row -1;
		col = col -1;
		grid[row][col] = 1;
		openSite++;
		if (row == 0) {
			wqu.union(0, component(row, col));
		}
		if (row == n -1) {
			wqu.union(((n*n)+1), component(row, col));			
		}
		if (row == 1) {
			if (grid[row+1][col] == 1) {
				wqu.union(component(row,col), component(row+1,col));
			}
		}

		if (row <= n-1) {
			if (grid[row-1][col] == 1) {
				wqu.union(component(row,col), component(row-1,col));
			}
		}
		if (col ==1) {
			if (grid[row][col+1] == 1) {
				wqu.union(component(row,col), component(row,col+1));
			}
		}
		if (col <= n-1) {
			if (grid[row][col-1] == 1) {
				wqu.union(component(row,col), component(row,col-1));
			}
		}
	}
	public int component(int a, int b) {
		return ((a*n)+b)+1;
	}
	public boolean isOpen(int row, int col) {
		return grid[row-1][col-1] == 1;
	}
	public boolean isFull(int row, int col) {
		return grid[row-1][col-1] == 0;
	}
	public int numberOfOpenSites() {
		return openSite;
	}
	public boolean percocolates() {
		return wqu.connected(0, (n*n)+1);
	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		percocolation perco = new percocolation(size);
		while (s.hasNext()) {
			perco.open(s.nextInt(), s.nextInt());
		}
		System.out.println(perco.percocolates());
	}
}