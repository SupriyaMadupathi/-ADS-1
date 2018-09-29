
public class Stacks<E> {

	/**
	 * Using Linked Lists.
	 */
	LinkedListGeneric<E> newlist;

	Stacks() {
		newlist = new LinkedListGeneric<>();
	}

	public boolean isEmpty() {
		return newlist.isEmpty1();
	}

	public void push(E e) {
		newlist.add1(e);
	}

	public E pop() {
		E c = newlist.remove();
		return c;
	}
}