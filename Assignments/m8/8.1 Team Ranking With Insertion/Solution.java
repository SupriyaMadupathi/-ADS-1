import java.util.Scanner;
class Ranking {
	String name;
	int win;
	int loss;
	int draw;
	Ranking(String n, int w, int l, int d) {
		this.name = n;
		this.win = w;
		this.loss = l;
		this.draw = d;
	}
	String getName(){
		return this.name;
	}
	int getWin() {
		return this.win;
	}
	int getLoss() {
		return this.loss;
	}
	int getDraw() {
		return this.draw;
	}
	public int compareTo(final Ranking that) {
        if (this.getWin() < that.getWin()) {
            return 1;
        } else if (this.getWin() > that.getWin()) {
            return -1;
        } else {
        if (this.getLoss() < that.getLoss()) {
            return -1;
        } else if (this.getLoss() > that.getLoss()) {
            return 1;
        } else {
            if (this.getDraw() < that.getDraw()) {
                return 1;
            } else if (this.getDraw() > that.getDraw()) {
                return -1;
            }
        }
        }
        return 0;
    }
    }
    class Sorting {
    private final int twenty = 20;
    private Ranking[] team;
    private int size;
    Sorting() {
        team = new Ranking[twenty];
        size = 0;
    }
    public void add(final Ranking r) {
        team[size++] = r;
    }
    void exchange(Ranking[] a, int i, int min) {
		Ranking temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}
	public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += team[i].getName() + ",";
        }
        return s.substring(0, s.length() - 1);
    }
    void InsertionSort() {
		for(int i = 0; i < size-1; i++) {
			int min = i; 
			for(int j = i+1; j > 0; j--) {
				if(less(team,j,j-1)) {
					exchange(team,j,j-1);		
				}
			}
			
			
		}
	}
	//takes O(1) time complexity.
	boolean less(Ranking[] teams, int j, int min) {
		return team[j].compareTo(team[min]) > 0;
	}
}
public final class Solution {
    
    private Solution() {
        
    }
    
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorting sort = new Sorting();
        final int one = 1;
        final int two = 2;
        final int three = 3;
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(",");
            Ranking cricket = new Ranking(input[0],
                Integer.parseInt(input[one]), Integer.parseInt(input[two]),
                Integer.parseInt(input[three]));
            sort.add(cricket);
        }
        sort.InsertionSort();
        System.out.println(sort.toString());
    }
}