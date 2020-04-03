import java.util.LinkedList;

public class MYqueue {
	LinkedList<Player> theQueue;
	
	public MYqueue() {
		theQueue = new LinkedList<Player>();
	}
	
	public void insert(Player elem) {
		theQueue.add(elem);
	}
	
	public String remove() {
		String temp = theQueue.getFirst().toString();
		theQueue.removeFirst();
		
		return temp;
	}
	
	public String peek() {
		return theQueue.getFirst().toString();
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
			queueString = queueString + temp.getFirst().toString() + " ";
			temp.removeFirst();
		}
		
		return queueString;
	}
}
