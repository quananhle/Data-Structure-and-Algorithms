package introAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

/*

1 radixSort(array)

2	d <- maximum number of digits in the largest element

3	create d buckets of size 0-9

4	for i <- 0 to d

5		sort the elements according to ith place digits using countingSort

6 countingSort(array, d)

7	max <- find largest element among dth place elements

8	initialize count array with all zeros

9	for j <- 0 to size

10		find the total count of each unique digit in dth place of elements and

11		store the count at jth index in count array

12	for i <- 1 to max

13		find the cumulative sum and store it in count array itself

14	for j <- size down to 1

15		restore the elements to array

16		decrease count of each element restored by 1


*/


public class radixSort {
	private static final int RADIX = 10;
	protected static ArrayList<Integer> radixSort (ArrayList<Integer> list) {
		ArrayList<Integer> dup = list; 
		int[] array = new int[dup.size()];	
		int length = array.length;
		for (int i = 0; i < length; ++i) {
			array[i] = dup.get(i);
		}
		return radixsort (array, length);
	}
	private static ArrayList<Integer> radixsort (int arr[], int length) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int maxNum = findMax (arr, length);
		for (int place = 1; maxNum / place > 0; place *= RADIX) {
			countingSort (arr, length, place);
		}
		for (int i = 0; i < arr.length; i++)  {
			list.add(arr[i]);			
		}		
		return list;
	}
	private static int findMax (int arr[], int n) {
		int maxNum = arr[0];
		for (int i = 1; i < n; ++i) {
			if (arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		return maxNum;
	}
	private static void countingSort (int arr[], int length, int place) {
		int[] output = new int[length + 1];
		int maxNum = arr[0];
		for (int i = 1; i < length; ++i) {
			if (arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		int[] count = new int[maxNum + 1];
		for (int i = 0; i < maxNum; ++i) {
			count[i] = 0;
		}
		for (int i = 0; i < length; ++i) {
			int listIndex = (arr[i] / place) % RADIX;
			count[listIndex]++;
		}
		for (int i = 1; i < RADIX; ++i) {
			int cntIndex = count[i - 1];
			count[i] += cntIndex;
		}
		for (int i = length - 1; i >= 0; i--) {
			int listIndex = (arr[i] / place) % RADIX;			
			int outputIndex = count[listIndex];
			output[outputIndex - 1] = arr[i];
			count[listIndex]--;			
		}
		for (int i = 0; i < length; ++i) {
			arr[i] = output[i];
		}
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
	// 	dup = radixSort(list);
	// 	System.out.println(dup);
	// }	
}
