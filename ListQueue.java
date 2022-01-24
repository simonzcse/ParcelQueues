/**
 * Title:       ListQueue.java
 * Description: A Queue class implemented using (inheriting) LinkedList class
 * Company:     ICT HKIVE(TY)
 * @author      Patrick Tong
 */

public class ListQueue extends LinkedList {

    public ListQueue() {
		super();
    }

	public boolean empty() {
		return isEmpty();
	}

	public void enqueue(Object item) {
		addToTail(item);
	}

	public Object dequeue() {
		return removeFromHead();
	}

	public Object peek() {
		return get(count());
	}
	public Object peekFront() {
			return get(1);
	}
} // class ListQueue