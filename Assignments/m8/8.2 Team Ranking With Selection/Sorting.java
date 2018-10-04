import java.util.Arrays;
/**
 * Class for ranking.
 */
class Ranking {

    /**
     * { this is a variable for country }.
     */
    private String name;
    /**
     * {this variable for winning }.
     */
    private int win;
    /**
     * { this ariable for lost matches }.
     */
    private int loss;
    /**
     * { this variable for draw matches}.
     */
    private int draw;
    /**
     * Constructs the object.
     * time complexity is 1.
     * @param      n     { country name }.
     * @param      w     { no of wins }.
     * @param      l     { no of losses }.
     * @param      d     { no of draws }.
     */
    Ranking(final String n, final int w, final int l, final int d) {

        this.name = n;
        this.win = w;
        this.loss = l;
        this.draw = d;

    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {

        return this.name;
    }
    /**
     * Gets the win.
     *
     * @return     The win.
     */
    int getWin() {

        return this.win;
    }
    /**
     * Gets the loss.
     *
     * @return     The loss.
     */
    int getLoss() {

        return this.loss;
    }
    /**
     * Gets the draw.
     *
     * @return     The draw.
     */
    int getDraw() {

        return this.draw;
    }
    /**
     * {method to compare elements}.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Ranking that) {

        if (this.getWin() < that.getWin()) {
            return -1;
        } else if (this.getWin() > that.getWin()) {
            return 1;
        } else {
        if (this.getLoss() < that.getLoss()) {
            return 1;
        } else if (this.getLoss() > that.getLoss()) {
            return -1;
        } else {
            if (this.getDraw() < that.getDraw()) {
                return -1;
            } else if (this.getDraw() > that.getDraw()) {
                return 1;
            }
        }
        }
        return 0;
    }
    }
    /**
     * Class for sorting.
     */
    class Sorting {
        /**
         * { var_description }.
         */
    private final int twenty = 20;
    /**
     * { var_description }.
     */
    private Ranking[] team;
    /**
     * { int size }.
     */
    private int size;

    /**
     * Constructs the object.
     * time complexity is 1.
     */
    Sorting() {

        team = new Ranking[twenty];
        size = 0;
    }
    //this method has constant time.
    //takes O(1) time complexity.
    /**
     * { method for adding }.
     *
     * @param      r     { parameter_description }
     */
    public void add(final Ranking r) {

        team[size++] = r;
        if (size > twenty) {
            resize();
        }
    }

    /**
     * { method for resizing the array}
     * this method takes constant time.
     * takes O(1) complexity.
     */
    void resize() {

        team = Arrays.copyOf(team, size * 2);
    }
    //takes O(1) time complexity.
    /**this method has constant time complexity.
     * { method for swapping }.
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      min   The minimum
     */
    void exchange(final Ranking[] a, final int i, final int min) {

        Ranking temp = a[min];
        a[min] = a[i];
        a[i] = temp;
    }
    // this method has a complexity of n
    //takes O(n^2) time complexity
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {

        String s = "";
        for (int i = 0; i < size; i++) {
            s += team[i].getName() + ",";
        }
        return s.substring(0, s.length() - 1);
    }
    //this method has a complexity of n
    //it takes O(n^2) time complexity.
    /**
     * {method for insertion sort }.
     */
    void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(team, j, min)) {
                    min = j;
                }
            }
            exchange(team, i, min);
        }
    }
    // this method has constant time complexity.
    // takes O(1) time complexity.
    /**
    * @param      teams  The teams
    * @param      j      { parameter_description }
    * @param      min    The minimum
    *
    * @return     { description_of_the_return_value }
    */
    boolean less(final Ranking[] teams, final int j, final int min) {

        return team[j].compareTo(team[min]) > 0;
    }
}

