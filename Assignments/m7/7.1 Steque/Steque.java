import java.util.Scanner;

/**
 * Class for node.
 */
class Node {
    /**
     * { data}.
     */
    String data;
    /**
     * { next}.
     */
    Node next;
    /**
     * Constructs the object.
     */
    Node() {
    }
    /**
     * Constructs the object.
     *
     * @param      data1  The data 1
     */
    Node(final String data1) {

        this.data = data1;
    }
}
/**
 * Class for steque.
 */
class Steque {
    /**
     * start.
     */
    private Node start;
    /**
     * end.
     */
    private Node end;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Steque() {

        size = 0;
        start = new Node();
         end = new Node();

    }
    /**
     * { method to push elements}.
     *
     * @param      item  The item
     */
    void push(final String item) {

        //System.out.println("BHOOM");
        Node oldstart = new Node(item);
        if (size == 0) {
            start.data = item;
            start.next = null;
            end = start;
            size++;
            return;
        }
        //start.data = item;
        oldstart.next = start;
        start = oldstart;
        size++;
        //System.out.println(start.data);
    }
    /**
     * { enque method }.
     *
     * @param      items  The items
     */
    void enque(final String items) {

        if (size == 0) {
            end.data = items;
            end.next = null;
            start = end;
            size++;
            return;
        }
            Node oldend = new Node(items);
            end.next = null;
            end.next = oldend;
            end = oldend;
            size++;
    }
    /**
     * { pop method to remove elements}.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    String pop() throws Exception {

        if (size == 0) {
            throw new Exception("Steque is empty.");
        }
        String data = start.data;
        start = start.next;
        size--;
        return data;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
        return false;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {

        if (size != 0) {
            String str = "";
            Node temp = start;
            while (temp != null) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
            //System.out.println("Helle");
      return "[]";
    }
}