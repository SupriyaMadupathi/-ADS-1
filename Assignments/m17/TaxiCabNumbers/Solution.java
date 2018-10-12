import java.util.*;
/**
 * Class for solution.
 */
class Solution {
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int n = 1000;
            MinPQ<Taxicab> pq = new MinPQ<Taxicab>();
                for (int i = 1; i <= n; i++) {
                pq.insert(new Taxicab(i, i));
            }
        int pair = 1;
        Taxicab previous = new Taxicab(0, 0);
        int match = 0;
        while (!pq.isEmpty()) {
            Taxicab curr = pq.delMin();
            if (previous.sum == curr.sum) {
                pair++;
                if (pair == M){
                    match = match+1;
                }
                if(match == N){
                    System.out.println(previous.sum);
                    break;
                }
            }
            else {
                pair = 1;
            }
            previous = curr;
            if (curr.j < n) pq.insert(new Taxicab(curr.i, curr.j + 1));
        }
    }
    }
    }