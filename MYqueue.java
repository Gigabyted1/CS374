import java.util.LinkedList;

public class MYqueue {
	LinkedList<Player> theQueue;
	
	public MYqueue() {
		theQueue = new LinkedList<Player>();
	}
	
	public void insert(Player elem) {
		theQueue.addFirst(elem);
	}
	
	public String remove() {
		String temp = theQueue.getLast().toString();
		theQueue.removeLast();
		
		return temp;
	}
	
	public String peek() {
		return theQueue.getLast().toString();
	}
	
	public boolean isEmpty() {
		if (theQueue.isEmpty()) {
			return true;
		} else { return false; }
	}
	
	public String toString() {
		LinkedList<Player> temp = theQueue;
		String queueString = "";
		while(!temp.isEmpty()) {
			queueString = queueString + temp.getLast().toString() + " ";
			temp.removeLast();
		}
		
		return queueString;
	}
}