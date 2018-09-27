import java.util.Scanner;
class  Stack{
		int n; 
		String[] array;
		Stack() {
			n = 0;
			array = new String[20];
		}
		void push(String item) {
			array[n++] = item;
		}
		String pop() {
			if (n == 0) {
				System.out.println("Stack is empty");
				return null;
			}
			return array[--n];
		}
	}
class Solution {
	public static void main(String[] args) {
		Stack stack = new Stack();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String line = s.nextLine();
			if (line.equals("-")) {
				System.out.println(stack.pop());
			} else {
				stack.push(line);
			}
		}
	}
}
