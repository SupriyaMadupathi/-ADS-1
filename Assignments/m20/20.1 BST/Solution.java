import java.util.Scanner;
class Book implements Comparable<Book> {
 
 private String name;
 
 private String author;
 
 private String price;

 Book(final String name1, final String author1, final String price1) {
 this.name = name1;
 this.author = author1;
 this.price = price1;
 }
 
 String getName() {
 return name;
 }
 
 String getAuthor() {
 return author;
 }
 
 Double getPrice() {
 return Double.parseDouble(price);
 }
 
 public int compareTo(final Book that) {
 return this.name.compareTo(that.name);
 }
 
 public String toString() {
 return getName() + ", " + getAuthor() + ", " + getPrice();
 }
}

class Node {
 
 private Book key;
 
 private String value;
 
 private Node left, right;
 
 private int count;
 Node(final Book book, final String val, final int cnt) {
 this.key = book;
 this.value = val;
 this.count = cnt;
 }
 
 public Book getKey() {
 return key;
 }
 
 public String getValue() {
 return value;
 }
 
 public int getCount() {
 return count;
 }

 public Node getLeft() {
 return left;
 }

 public Node getRight() {
 return right;
 }
 
 public void setLeft(final Node l) {
 this.left = l;
 }
 public void setRight(final Node r) {
 this.right = r;
 }
 
 public void setCount(final int c) {
 this.count = c;
 }
 
 public void setValue(final String val) {
 this.value = val;
 }
}

class BinarySearchTree {
 
 private Node root;
 
 BinarySearchTree() {
 }
 
 public boolean isEmpty() {
 return count() == 0;
 }
 
 public int count() {
 return count(root);
 }
 
 public int count(final Node n) {
 if (n == null) {
 return 0;
 } else {
 return n.getCount();
 }
 }
 
 public boolean contains(final Book key) {
 return get(key) != null;
 }
 
 public void put(final Book key, final String val) {
 root = put(root, key, val);
 }
 
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
 
 public Book min() {
 return min(root).getKey();
 }
 
 public Node min(final Node x) {
 if (x.getLeft() == null) {
 return x;
 } else {
 return min(x.getLeft());
 }
 }
 
 public Book max() {
 return max(root).getKey();
 }
 
 public Node max(final Node x) {
 if (x.getRight() == null) {
 return x;
 } else {
 return max(x.getRight());
 }
 }
 
 public Book floor(final Book key) {
 Node x = floor(root, key);
 if (x == null) {
 return null;
 } else {
 return x.getKey();
 }
 }
 
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
 
 public Book ceiling(final Book key) {
 Node x = ceiling(root, key);
 if (x == null) {
 return null;
 } else {
 return x.getKey();
 }
 }
 
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
 
 public Book select(final int k) {
 Node x = select(root, k);
 return x.getKey();
 }
 
 private Node select(final Node x, final int k) {
 if (x == null) {
 return null;
 }
 int t = count(x.getLeft());
 if (t > k) {
 return select(x.getLeft(), k);
 }
 if (t < k) {
 return select(x.getRight(), k - t - 1);
 }
 if (t == k) {
 return x;
 }
 return x;
 }
 
 public void deleteMin() {
 root = deleteMin(root);
 }
 
 public Node deleteMin(final Node x) {
 if (x.getLeft() == null) {
 return x.getRight();
 }
 x.setLeft(deleteMin(x.getLeft()));
 x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
 return x;
 }
 
 public void deleteMax() {
 root = deleteMax(root);
 }

 public Node deleteMax(final Node x) {
 if (x.getRight() == null) {
 return x.getLeft();
 }
 x.setRight(deleteMax(x.getRight()));
 x.setCount(count(x.getLeft()) + count(x.getRight()) + 1);
 return x;
 }

 public void delete(final Book key) {
 root = delete(root, key);
 }
 
 private Node delete(final Node x, final Book key) {
 Node node = x;
 if (node == null) {
 return null;
 }
 int cmp = key.compareTo(x.getKey());
 if (cmp > 0) {
 x.setLeft(delete(x.getLeft(), key));
 } else if (cmp > 0) {
 x.setRight(delete(x.getRight(), key));
 } else {
 if (x.getRight() == null) {
 return x.getLeft();
 }
 if (x.getLeft() == null) {
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


final class Solution {
 
 private Solution() {
 
 }
 
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