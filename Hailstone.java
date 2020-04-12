import java.util.ArrayList;

public class Hailstone {
	ArrayList<Long> sequence;
	
	public Hailstone (long startNo, ArrayList<Long> passedList) {	// Constructor
		sequence = passedList;
		if (startNo <= 0) {					// Fixes negative or zero input
			startNo = 1;
			System.out.println("An invalid starting number was entered. It was changed to 1.");
		}
		
		hailstoneSequencer(startNo);
	}
	
	public void hailstoneSequencer (long progressNo) {				// Creates a hailstone sequence starting with the passed integer using recursion
		sequence.add(progressNo);
		if (progressNo == 1) {				// Exit condition
			System.exit(0);
		}
		else {
			if (progressNo % 2 == 0) {		// If even
				hailstoneSequencer(progressNo / 2);
			}
			else if (progressNo % 2 == 1) { // If odd
				hailstoneSequencer(progressNo * 3 + 1);
			}
		}
	}
}
