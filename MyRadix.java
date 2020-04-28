// Radix sort Java implementation
// Found on geeksforgeeks.org and tweaked to suit us

import java.io.*; 
import java.util.*; 

class MyRadix { 
	// A function to do counting sort of data[] according to 
	// descending char positions
	static void countSort(String[] data, int position) { 
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
				count[ 25 ]++;
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
				output[count[ 25 ] - 1] = data[i]; 
				count[ 25 ]--;
			}
		} 

		// Copy the output array to data[], so that data[] now 
		// contains sorted strings according to current char position 
		for (i = 0; i < data.length; i++) {
			data[i] = output[i]; 
		}
	} 

	// The main function to that sorts data[] using 
	// Radix Sort 
	static void radixsort(String[] data, int stringMaxLength) {

		// Do counting sort for every letter at char position pos for data
		for (int pos = stringMaxLength - 1; pos >= 0; pos--) {
			countSort(data, pos); 
		}
	} 

	// A utility function to print the array 
	static void print(String[] data) { 
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\n"); 
		}
	} 

	public static void main (String[] args) throws IOException{ 
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
		
		radixsort(data, 8); 
		print(data); 
	} 
} 
// This code is contributed by Devesh Agrawal and tweaked for CS 374 by Wayne Bloom


