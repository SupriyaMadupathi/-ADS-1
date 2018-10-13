import java.util.Scanner;
import java.util.NoSuchElementException;
class Stock implements Comparable<Stock>{
	String name;
	float  change;
	Stock() {

	}
	Stock(String n, float ch) {
		this.name = n;
		this.change = ch;
	}
	public String getName() {
		return this.name;
	}
	public float getChange() {
		return this.change;
	}
	public int compareTo(Stock that) {
		if (this.change < that.change) {
			return -1;
		}else if (this.change > that.change) {
			return 1;
		}
		return this.name.compareTo(that.name);
	}
}
class BinarySearchSymbolTable {
	BinarySearchSymbolTable(){

	}
class Query {
	Stock[] keys;
	int n;
	Query() {
		keys = new Stock[500];
		n = 0;
	}
	int size() {
		return  n;
	}
	boolean isEmpty() {
		return size() == 0;
	}
	float get(Stock key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to get() is null");
		}
		if (isEmpty()) {
			return 0;
		}
		int i = rank(key);
            if (i < n && keys[i].getName().compareTo(key.name) == 0) {
                return keys[i].getChange();
     	    }
     	    return 0;
	}
	int rank(Stock key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to get() is null");
		}
		int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
            hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
	}
}
}
	
