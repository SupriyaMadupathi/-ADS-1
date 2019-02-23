import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution{
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        String[] line = new String[20];
        Double[] onlyscores = new Double[n];
        Map<Integer, Double> scores = new HashMap<>();
        Map<Integer, Double> percentiles = new HashMap<>();

        for (int i=0;i<n ;i++) {
            line = sc.nextLine().split(",");
            scores.put(Integer.parseInt(line[0]),Double.parseDouble(line[1]));
            onlyscores[i]=Double.parseDouble(line[1]);
        }
        m = sc.nextInt();
        sc.nextLine();
        int temp;
        int[] queries = new int[m];
        Double percent=0.0;


        for (int i=0;i<m ;i++ ) {
            queries[i] = sc.nextInt();
        }

        for (Integer key : scores.keySet()) {
            percent = getPercent(scores.get(key),n,onlyscores);
            percentiles.put(key,percent);

        }

        for (Integer each :queries ) {
            Double answer = percentiles.get(each);
            System.out.println((answer*100.0)/100.0);
        }

        // System.out.println(percentiles);
        // for (int i=0;i<n ;i++ ) {

        //     // percentiles.put(queries[i],);
        // }

        // System.out.println(Arrays.toString(line));
        // Double percent = (100 * )/n;
    }

    static Double getPercent(Double val,int totalcount,Double[] myarr){
        Double ans=0.0;
        int count=0;

        for (int i=0;i<myarr.length ;i++ ) {
            if(myarr[i]<=val){
                count++;
            }
        }

        ans = (100 * count)/Double.valueOf(totalcount);
        return ans;
    }

    // static int getCount(int val,int[] myarr){
    //     int count=0;
    //     for (int i=0;i<myarr.length ;i++ ) {
    //         if(myarr[i]<=val){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}
