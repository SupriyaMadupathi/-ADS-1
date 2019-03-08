import java.util.Scanner;
import java.util.ArrayList;


class Solution{
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int days = Integer.parseInt(sc.nextLine());
    // Candidate[] cad_array = new
    CreateList cl = new CreateList();
    int sno=0;
    ArrayList<Candidate> cad_array = new ArrayList<>();
    // Candidate cd =
    while(sc.hasNext()){
        String[] line = sc.nextLine().split(" ");
        switch(line[0]){
            case "Apply":
            // System.out.println("hello ="+line[1]+"\n\n");
                String[] tokens = line[1].split(",");
                Candidate cd = new Candidate(tokens[0],tokens[1],tokens[2],
                    Double.parseDouble(tokens[3]),sno++);
                cl.addToList(cd);
                cl.selectionSort();
                break;
                // cad_array.add(cd);
            case "Recruit_Top_Candidate":
            // System.out.println("");
            // cl.printRest();
            // cl.printTop();
            // System.out.println(cl.candidate_arr[0]);
            cl.removeTop();
            break;
            case "Ranking":
            System.out.println();
            cl.printRest();
            break;



        }
    }
  }
}

class Candidate{
    String cid,name,degree;
    int sno;
    Double percent;
    Candidate(String _cid,String _name,String _degree,Double _percent,int _sno){
        this.cid = _cid;
        this.name = _name;
        this.degree = _degree;
        this.percent = _percent;
        this.sno = _sno;
    }
    public String toString(){
        return this.cid+ "," + this.name + "," + this.degree + "," +this.percent ;
    }

    public int compareTo(Candidate c){
        if (this.percent > c.percent) {
            return 1;
        }
        if (this.percent < c.percent) {
            return -1;
        }
        if (this.sno > c.sno) {
            return 1;
        }
        if (this.sno < c.sno) {
            return -1;
        }

        return 0;
    }
}


class CreateList{
    Candidate[] candidate_arr;
    int size;

    CreateList() {
        size = 0;
        candidate_arr = new Candidate[100];
    }
    // void printTop(){
    //     System.out.println(candidate_arr[0]);
    // }

    void printRest(){
                for(int i=0;i<size-1;i++){
                    System.out.println( i +": "+candidate_arr[i]);
        }
    }
    void addToList(Candidate c) {
        // // System.out.println("\n\n\n"+size+"\n\n\n");
        // System.out.println("qwerfghj");
        // System.out.println(candidate_arr[0]);
        // System.out.println("Legn " + candidate_arr.length);
        // candidate_arr[0] = new Candidate("10www001","Deepak","ME",92.3,2);
        // // size++;

        // // System.out.println(candidate_arr[0]);

        candidate_arr[size++] = c;
        // size++;
    }

    void removeTop(){
                System.out.println(candidate_arr[0]);

        for(int i=0;i<size-1;i++){
            candidate_arr[i] = candidate_arr[i+1];
            size--;
        }
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += candidate_arr[i].cid + "," + candidate_arr[i].name + "," + candidate_arr[i].percent + "\n";
        }
        return s;
    }
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(candidate_arr, j, min)) {
                    min = j;
                }
            }
            exch(candidate_arr, i, min);
        }

    }
    public void exch(Candidate[] candidate_arr, int i, int j) {
        Candidate ct = candidate_arr[j];
        candidate_arr[j] = candidate_arr[i];
        candidate_arr[i] = ct;
    }

    boolean less(Candidate[] arr, int i, int j) {
        return  arr[i].compareTo(arr[j]) > 0;
    }

}