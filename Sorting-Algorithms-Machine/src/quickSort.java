package introAlgorithms;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

import java.util.ArrayList;
import java.util.Collections;

public class quickSort {
	protected static ArrayList<Integer> quickSort (ArrayList<Integer> list) {
		return sort (list, 0, list.size() - 1);
	}
	private static ArrayList<Integer> sort (ArrayList<Integer> list, int start, int end) {
		if (start < end) {
			int pivot = partition (list, start, end);
			sort (list, start, pivot - 1);
			sort (list, pivot + 1, end);
		}
		return list;
	}
	private static int partition (ArrayList<Integer> list, int start, int end) {
		int pivot = list.get(start);
		int i = start + 1;
		for (int j = start + 1; j <= end; j++) {
			if (list.get(j) < pivot) {
				Collections.swap(list, i, j);
				i++;
			}
		}
		Collections.swap (list, start, i-1);
		return i-1;
	}
	/*public static void main(String args[]) { 
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(30);
	    list.add(10);
	    list.add(16);
	    list.add(17);
	    list.add(19);
	    list.add(50);
	    list.add(70);
	    list.add(86);
	    list.add(7);
		System.out.println(list);
		quickSort(list);
		System.out.println(list);
    }*/
}