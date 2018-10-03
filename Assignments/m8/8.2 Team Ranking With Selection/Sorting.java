import java.util.Scanner;
import java.util.Arrays;
class Ranking {
    
    String teamname;
    int win;
    int loss;
    int draw;
    Ranking(String name,int winn, int lost, int draws) {
        this.teamname = name;
        this.win = winn;
        this.loss = lost;
        this.draw = draws;
    }
    public String getTeamName() {
        return this.teamname;
    }
    public int getwinn() {
        return this.win;
    }
    public int getLost() {
        return this.loss;
    }
    public int getDraw() {
        return this.draw;
    }
    public int compareTo(Ranking comp) {
        if(this.win > comp.win) {
            return 1;
        }
        if(this.win < comp.win) {
            return -1;
        }
        if(this.loss < comp.loss) {
            return 1;
        }
        if(this.loss > comp.loss) {
            return -1;
        }
        if(this.draw > comp.draw) {
            return 1;
        }
        if(this.draw < comp.draw) {
            return -1;
        }
        return 0;
    }
    
}
class Sorting {
    Ranking[] teams;
    int size;
    Sorting() {
        size = 0;
        teams = new Ranking[10];
    }
    void add(Ranking objcricket) {
        teams[size++] = objcricket;
        if(size > 10) {
            resize();
        }
    }
    void resize() {
        teams = Arrays.copyOf(teams, size * 2);
    }
    void exchange(Ranking[] a, int i, int min) {

        Ranking temp = a[min];
        a[min] = a[i];
        a[i] = temp;
    }
    String display() {
        String s = "";
        for(int i = 0; i < size; i++) {
            s += teams[i].teamname + ",";

        }
        return s.substring(0, s.length() - 1);
    }

    void SelectionSort() {
        for(int i = 0; i < size-1; i++) {
            int min = i; 
            for(int j = i+1; j < size; j++) {
                if(less(teams,j,min)) {
                    min = j;
                }
            }
            exchange(teams,i,min);
            
        }
    }
    boolean less(Ranking[] teams, int j, int min) {
        return teams[j].compareTo(teams[min]) > 0;
    }
}
