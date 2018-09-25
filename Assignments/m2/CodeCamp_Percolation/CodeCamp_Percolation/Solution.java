import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
	/**
	 * { var_description }
	 */
	private WeightedQuickUnionUF wqf;

	private int n;
	private int size;
	private int row;
	private int col;
	private boolean[] connected;
	private int count;
	// create n-by-n grid, with all sites blocked
   public Percolation(int n1) {
   	this.n = n1;
   	this.count = 0;
   	this.size = n1 * n1;
   	this.row = size;
   	this.col = size + 1;
   	connected = new boolean[size];
   	wqf = new WeightedQuickUnionUF(size + 2);
   	for (int i = 0; i < n; i++) {
   		wqf.union(row, i);
   		wqf.union(col, size - i - 1);
   	}
   }   

   public int component(int i, int j) {
   		return n * (i - 1) + j - 1;
   }

   private void LinkOpenSites(int row, int col) {
   	if (connected[col] && !wqf.connected(row, col))
   	{
   		wqf.union(row, col);
   	}
   }

   public int numberOfOpenSites() {
   	return count;
   }       
   public void open(int row, int col) {
   	int index = component(row, col);
   	connected[index] = true;
   	count++;
   	int bottom = index + n;
   	int top = index - n;
   	if (n == 1) {
   		wqf.union(row, index);
   		wqf.union(col, index);

   	}
   	if (bottom < size) {
   		LinkOpenSites(index, bottom);
   	} 
   	if (top >= 0) {
   		LinkOpenSites(index, top);
   	}
   	if(col == 1) {
   		if(col != n) {
   			LinkOpenSites(index, index + 1);
   		}
   		return;
   	} if (col == n) {
   		LinkOpenSites(index, index - 1);
   		return;
   	}
   	LinkOpenSites(index, index + 1);
   	LinkOpenSites(index, index - 1);


   } 
   public boolean isOpen(int row, int col) {
   	return connected[component(row, col)];
   }
   public boolean percolates() {
   	return wqf.connected(row, col);

   }             
}



public final class Solution {

	private Solution() {

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Percolation p = new Percolation(n);
		// int i = 0;
		while(sc.hasNext()) {
			String [] tokens = sc.nextLine().split(" ");
			p.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			// i++;
		}
		System.out.println(p.percolates() && p.numberOfOpenSites() != 0);

	}
}