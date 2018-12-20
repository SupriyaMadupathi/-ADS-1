/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * Name string.
     */
    private String name;
    /**
     * Author of book.
     */
    private String author;
    /**
     * Price of the book.
     */
    private String price;
    /**
     * Constructs the object.
     *
     * @param      name1    The name 1
     * @param      author1  The author 1
     * @param      price1   The price 1
     */
    Book(final String name1, final String author1, final String price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    Double getPrice() {
        return Double.parseDouble(price);
    }
    /**
     * Compares the name of the books.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Book that) {
        return this.name.compareTo(that.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for node.
 */
class Node {
    /**
     * Keys in book format.
     */
    private Book key;
    /**
     * Values in a string.
     */
    private String value;
    /**
     * Left and right nodes.
     */
    private Node left, right;
    /**
     * Count of the insertions for each and every node.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      book  The book
     * @param      val   The value
     * @param      cnt   The count
     */
    Node(final Book book, final String val, final int cnt) {
        this.key = book;
        this.value = val;
        this.count = cnt;
    }
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Book getKey() {
        return key;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public String getValue() {
        return value;
    }
    /**
     * Gets the count.
     *
     * @return     The count.
     */
    public int getCount() {
        return count;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Sets the left.
     *
     * @param      l     { parameter_description }
     */
    public void setLeft(final Node l) {
        this.left = l;
    }
    /**
     * Sets the right.
     *
     * @param      r     { parameter_description }
     */
    public void setRight(final Node r) {
        this.right = r;
    }
    /**
     * Sets the count.
     *
     * @param      c     { parameter_description }
     */
    public void setCount(final int c) {
        this.count = c;
    }
    /**
     * Sets the value.
     *
     * @param      val   The value
     */
    public void setValue(final String val) {
        this.value = val;
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * Root node.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return count() == 0;
    }
    /**
     * Count of the value of the key.
     *
     * @return     int value.
     */
    public int count() {
        return count(root);
    }
    /**
     * Count of the number of nodes under a particular node.
     *
     * @param      n     Node.
     * time complexity - O(n) for worst case.
     * @return     count value.
     */
    public int count(final Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.getCount();
        }
    }
    /**
     * Checks if the given node is present or not.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Book key) {
        return get(key) != null;
    }
    /**
     * Puts the value according to specific order.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final String val) {
        root = put(root, key, val);
    }
    /**
     * Puts the node in its place.
     * @param      x     Node x.
     * @param      key   The key.
     * @param      val   The value.
     *time complexity - O(n) for worst case.
     * @return     Node value.
     */
    public Node put(final Node x, final Book key, final String val) {
        if (x == null) {
            return new Node(key, val, 1);
        }

        int comp = key.getName().compareTo(x.getKey().getName());
        if (comp < 0) {
            x.setLeft(put(x.getLeft(), key, val));
        }

        if (comp > 0) {
            x.setRight(put(x.getRight(), key, val));
        }

        if (comp == 0) {
            x.setValue(val);
        }

        x.setCount(1 + count(x.getLeft()) + count(x.getRight()));
        return x;
    }
    /**
     * Gets the rank of the particular node.
     * time complexity - O(n) for worst case.
     *
     * @param      key   The key
     *
     * @return   String.
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int comp = key.getName().compareTo(x.getKey().getName());
            if (comp > 0) {
                x = x.getRight();
            }

            if (comp < 0) {
                x = x.getLeft();
            }

            if (comp == 0) {
                return x.getValue();
            }
        }

        return null;
    }
    /**
     * Returns the minimum value.
     * Complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public Book min() {
        return min(root).getKey();
    }
    /**
     * Returns the min value.
     * Complexity is 1.
     *
     * @param      x     Node x.
     *
     * @return     Node
     */
    public Node min(final Node x) {
        if (x.getLeft() == null) {
            return x;
        } else {
            return min(x.getLeft());
        }
    }
    /**
     * Returns the max value.
     *
     * @return     { description_of_the_return_value }
     */
    public Book max() {
        return max(root).getKey();
    }
    /**
     * Returns the maximium value.
     * Complexity is N.
     *
     * @param      x     { parameter_description }
     *
     * @return     Node.
     */
    public Node max(final Node x) {
        if (x.getRight() == null) {
            return x;
        } else {
            return max(x.getRight());
        }
    }
    /**
     * Returns the least nearest value of the given node.
     * time complexity - O(n) for worst case.
     *
     * @param      key   The key
     *
     * @return     Book.
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }
    /**
     * Returns the least nearest value of the given node.
     * time complexity - O(n) for worst case.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     Node.
     */
    public Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }

        if (cmp < 0) {
            return floor(x.getLeft(), key);
        }

        Node t = floor(x.getRight(), key);

        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * Returns the nearest highest value of the given node.
     * time complexity - O(n) for worst case.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }.
     */
    public Book ceiling(final Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }
    /**
     * Returns the nearest highest value of the given node.
     * time complexity - O(n) for worst case.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }

        if (cmp < 0) {
            Node t = ceiling(x.getLeft(), key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.getRight(), key);
    }
    /**
     * Select gives the key n the particlar index.
     * time complexity - O(n) for worst case.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.getKey();
    }
    /**
     * Select gives the key n the particlar index.
     * time complexity - O(n) for worst case.
     *
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = count(x.getLeft());
        if (t > k) {
            return select(x.getLeft(),  k);
        }
        if (t < k) {
            return select(x.getRight(), k - t - 1);
        }
        if (t == k) {
            return x;
        }
        return x;
    }
    /**
     * Delete Min.
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * Delete min value.
     * time complexity - O(n) for worst case.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Node deleteMin(final Node x) {
        if (x.getLeft() == null) {
            return x.getRight();
        }
        x.setLeft(deleteMin(x.getLeft()));
        x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
        return x;
    }
    /**
     * Deletion of max.
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * Deletion of max.
     * time complexity - O(n) for worst case.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Node deleteMax(final Node x) {
        if (x.getRight() == null) {
            return x.getLeft();
        }
        x.setRight(deleteMax(x.getRight()));
        x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
        return x;
    }
    /**
     * Deletion of a particular key.
     *
     * @param      key   The key
     */
    public void delete(final Book key) {
        root = delete(root, key);
    }
    /**
     * Deletion of a particular key.
     * time complexity - O(n) for worst case.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node delete(final Node x, final Book key) {
        Node node = x;
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) {
            x.setLeft(delete(x.getLeft(),  key));
        } else if (cmp > 0) {
            x.setRight(delete(x.getRight(), key));
        } else {
            if (x.getRight() == null) {
                return x.getLeft();
            }
            if (x.getLeft()  == null) {
                return x.getRight();
            }
            Node t = x;
            node = min(t.getRight());
            x.setRight(deleteMin(t.getRight()));
            x.setLeft(t.getLeft());
        }
        x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
        return node;
    }

}

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(",");
            switch (input[0]) {
                case "put":
                Book book = new Book(input[1], input[2], input[2 + 1]);
                bst.put(book, input[2 + 2]);
                break;
                case "get":
                book = new Book(input[1], input[2], input[2 + 1]);
                System.out.println(bst.get(book));
                break;
                case "max":
                System.out.println(bst.max());
                break;
                case "min":
                System.out.println(bst.min());
                break;
                case "select":
                System.out.println(bst.select(Integer.parseInt(input[1])));
                break;
                case "floor":
                book = new Book(input[1], input[2], input[2 + 1]);
                System.out.println(bst.floor(book));
                break;
                case "ceiling":
                book = new Book(input[1], input[2], input[2 + 1]);
                System.out.println(bst.ceiling(book));
                break;
                case "deleteMin":
                bst.deleteMin();
                break;
                case "deleteMax":
                bst.deleteMax();
                break;
                case "delete":
                book = new Book(input[1], input[2], input[2 + 1]);
                bst.delete(book);
                break;
                default:
                break;
            }
        }
    }
}





