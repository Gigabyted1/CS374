// Radix and merge sort implemented by Wayne Bloom
// Radix was found on geeksforgeeks.org (cont. by Devesh Agrawal) and tweaked to suit us
// Merge was found in the book and tweaked to suit us

import java.io.*; 
import java.util.*; 

class Sorts { 
	
	public static void mergeSort (String[] dataInput) {
		 String[] workSpace = new String[dataInput.length];
		 
		 recMergeSort(workSpace, dataInput, 0, dataInput.length - 1);
		 
	 }
	
	// The main function to that sorts data[] using 
	// Radix Sort 
	public static void radixSort(String[] data, int stringMaxLength) {

		// Do counting sort for every letter at char position pos for data
		for (int pos = stringMaxLength - 1; pos >= 0; pos--) {
			countSort(data, pos); 
		}
	} 
	
	// A function to do counting sort of data[] according to 
	// descending char positions
	public static void countSort(String[] data, int position) { 
		String output[] = new String[data.length]; // output array 
		int i; 
		int count[] = new int[26];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[] 
		for (i = 0; i < data.length; i++) {
			if (data[i].length() - 1 >= position) {
				count[ data[i].charAt(position) - 97 ]++;
			}
			else {
				count[25]++;
			}
		}

		// Change count[i] so that count[i] now contains 
		// actual position of this digit in output[] 
		for (i = 1; i < count.length; i++) {
			count[i] += count[i - 1]; 
		}

		// Build the output array 
		for (i = data.length - 1; i >= 0; i--) { 
			if (data[i].length() - 1 >= position) {
				output[count[ data[i].charAt(position) - 97 ] - 1] = data[i]; 
				count[ data[i].charAt(position) - 97 ]--;
			}
			else {
				output[count[25] - 1] = data[i]; 
				count[25]--;
			}
		} 

		// Copy the output array to data[], so that data[] now 
		// contains sorted strings according to current char position 
		for (i = 0; i < data.length; i++) {
			data[i] = output[i]; 
		}
	}
	
	private static void recMergeSort(String[] workSpace, String[] data, int lowerBound, int upperBound) {
		 if(lowerBound == upperBound) {		// if range is 1,
			 return;						// no use sorting
		 }
		 else {
			 								// find midpoint 
			 int mid = (lowerBound + upperBound) / 2;
			 								// sort low half 
			 recMergeSort(workSpace, data, lowerBound, mid);
			 								// sort high half 
			 recMergeSort(workSpace, data, mid + 1, upperBound);
			 								// merge them 
			 merge(workSpace, data, lowerBound, mid + 1, upperBound);
		 } // end else 
	 } // end recMergeSort()
	 //----------------------------------------------------------- 
	 private static void merge(String[] workSpace, String[] data, int lowPtr, int highPtr, int upperBound) {
		 int j = 0;	// workspace index 
		 int lowerBound = lowPtr; 
		 int mid = highPtr - 1; 
		 int n = upperBound - lowerBound + 1;	// # of items
		 
		 while (lowPtr <= mid && highPtr <= upperBound) {
			 if (data[lowPtr].compareTo(data[highPtr]) < 0) {
				 workSpace[j++] = data[lowPtr++]; 
			 }
			 else {
				 workSpace[j++] = data[highPtr++];
			 }
		 }
					 
		 while (lowPtr <= mid) {
			 workSpace[j++] = data[lowPtr++];
		 }
		 while (highPtr <= upperBound) {
			 workSpace[j++] = data[highPtr++];
		 }
		 for (j = 0; j < n; j++) {
			 data[lowerBound + j] = workSpace[j];
		 }
	 } // end merge()

	// A utility function to print the array 
	public static void print(String[] data) { 
		for (String i : data) {
			System.out.print(i + "\n"); 
		}
	} 

	/*public static void main (String[] args) throws IOException{ 
		File stringInputFile = new File("/Users/gigabyted/Documents/Projects/Eclipse/CS 374 Paper Program/src/Input Strings.txt");
		BufferedReader input = new BufferedReader(new FileReader(stringInputFile));
		String[] data = new String[100000];
		String strIn;
		
		for (int i = 0; i < data.length; i++) {
			if ((strIn = input.readLine()) != null) {
				data[i] = strIn;
			}
		}
		
		input.close();
		
		mergeSort(data);
		print(data);
	} */
} 



