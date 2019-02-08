import java.util.Scanner;
public final class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<String, Double> bst = new BinarySearchTree();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i< m; i++) {
        	String stu = sc.nextLine();
        	String[] data = stu.split(",");
        	// System.out.println(data);
        	String key = new String(data[1]);
        	double value = Double.parseDouble(data[2]);
        	bst.put(key, value);
        }
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i< n; i++){
        	String stu = sc.nextLine();
        	System.out.println(stu);


        }
    }
}

