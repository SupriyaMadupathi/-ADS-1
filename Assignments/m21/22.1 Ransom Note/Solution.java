import java.util.*;
class SeparateChainingHashST {
    private static final int INIT_CAPACITY = 4;
    int n;                                
    int m;                                
    SequentialSearchST<String, Integer>[] st;  
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    } 

    
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<String, Integer>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<String, Integer>();
    } 

    
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

    
    public int size() {
        return n;
    } 

    
    public boolean isEmpty() {
        return size() == 0;
    }

    
    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    
    public Integer get(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    
    public void put(String key, Integer val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    
    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);
    } 
    
}
class Solution {
	Solution() {

	}

	public static String check(SeparateChainingHashST st, int n, String[] data) {
    	int count = 0;
    	for (int i = 0; i < n; i++) {
			Integer p = st.get(data[i]);
			if (p == null || p == 0) {
				return "No";
			}
			st.put(data[i], --p);
		}
		return "Yes";
    } 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//RansomNote rn = new RansomNote();
		SeparateChainingHashST st = new SeparateChainingHashST();
		String num = sc.nextLine();
		String[] no = num.split(" ");
        int m = Integer.parseInt(no[0]);
		int n = Integer.parseInt(no[1]);
		while (sc.hasNextLine()) {
			String magazine = sc.nextLine();
			String[] magdata = magazine.split(" ");
			st = new SeparateChainingHashST(magdata.length);
			for (int i = 0; i < m; i++) {
				if (st.contains(magdata[i])) {
					int val = st.get(magdata[i]);
					st.put(magdata[i], ++val);
				} else {
					st.put(magdata[i], 1);
				}
			}
			String note = sc.nextLine();
			String[] notedata = note.split(" ");
			System.out.println(check(st, n, notedata));
        }
    }
}