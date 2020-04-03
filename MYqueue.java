import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MYqueue {
	LinkedList<Player> theQueue;
	
	public MYqueue() {
		theQueue = new LinkedList<Player>();
	}
	
	public void insert(Player elem) {
		theQueue.add(elem);
	}
	
	public String remove() {
		if (theQueue.getFirst() == null) {
			System.exit(0);
		}
		
		return theQueue.removeFirst().toString();
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
		String queueString = "";
		Player[] saveVals = new Player[100];
		int saveSize = 0;
		while(!theQueue.isEmpty()) {
			saveVals[saveSize] = theQueue.getFirst();
			queueString = queueString + theQueue.removeFirst().toString() + " ";
			saveSize++;
		}
		
		for (Player i : saveVals) {
			theQueue.add(i);
		}
		
		return queueString;
	}
}
