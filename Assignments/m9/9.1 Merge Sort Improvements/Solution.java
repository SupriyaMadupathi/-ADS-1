import java.util.Scanner;
final class Solution {
    private Solution() { }
    public static void main(final String[] args) {
        Merge m = new Merge();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String tokens = s.nextLine();
            String[] lines = tokens.split(",");
            m.sort(lines);
            System.out.println(m.toString(lines));
            System.out.println();
        }
    }
}

