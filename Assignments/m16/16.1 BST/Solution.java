import java.util.Scanner;
final class Solution {
    protected Solution() {

    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySt bt = new BinarySt();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            switch (line[0]) {
                case "put":
                Book old = new Book(line[1], line[2],
                 Float.parseFloat(line[1 + 2]));
                bt.put(old, Integer.parseInt(line[2 + 2]));
                break;
                case "get":
                Book old1 = new Book(line[1], line[2],
                 Float.parseFloat(line[1 + 2]));
                Integer c = bt.get(old1);
                    System.out.println(c);
                break;
                default:
                break;
            }
        }
    }
}
