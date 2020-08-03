package introAlgorithms;

import java.util.ArrayList;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

/*

1 countingSort(array, size)

2	max <- find largest element in array

3	initialize count array with all zeros

4	for j <- 0 to size

5		find the total count of each unique element and 

6 		store the count at jth index in count array

7	for i <- 1 to max

8		find the cumulative sum and store it in count array itself

9	for j <- size down to 1

10		restore the elements to array

11		decrease count of each element restored by 1

*/


public class countingSort {
	protected static ArrayList<Integer> countingSort (ArrayList<Integer> list) {
		ArrayList<Integer> dup = list;
		int size = list.size();
		int[] array = new int[size];	
		int length = array.length;
		for (int i = 0; i < length; ++i) {
			array[i] = dup.get(i);
		}
		return sort (array, length);
	}
	private static ArrayList<Integer> sort (int[] arr, int length) {
		ArrayList<Integer> list = new ArrayList<Integer>();		
		int[] output = new int[length + 1];
		int maxNum = arr[0];

		for (int i = 1; i < length; i++) {
			if (arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}

		int[] count = new int[maxNum + 1];

		for (int i = 0; i < maxNum; ++i) {
			count[i] = 0;
		}
		for (int i = 0; i < length; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i <= maxNum; i++) {
			count[i] += count[i - 1];
		}
		for (int i = length - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < length; i++) {
			arr[i] = output[i];
		}
		for (int i = 0; i < arr.length; i++)  {
			list.add(arr[i]);			
		}		
		return list;
	}

	// public static void main(String args[]) {
	// 	ArrayList<Integer> list = new ArrayList<Integer>();
	// 	ArrayList<Integer> dup = new ArrayList<Integer>();
	// 	list.add(12);
	// 	list.add(34);
	// 	list.add(457);
	// 	list.add(5348);
	// 	list.add(342);
	// 	list.add(83);
	// 	list.add(6257);
	// 	list.add(910);
	// 	System.out.println(list);		
	// 	dup = countingSort(list);
	// 	System.out.println(dup);
	// }	
}
