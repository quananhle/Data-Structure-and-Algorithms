package introAlgorithms;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

/* HEAP-SORT (A) 

1   BuildHeap(A)

2   for i <- length(A) downto 2 

3      exchange A[1] <-> A[i]

4      heapsize <- heapsize -1

5      Heapify(A, 1)

6 	BuildHeap(A) 

7   	heapsize <- length(A)

8   	for i <- floor( length/2 ) downto 1

9      		Heapify(A, i)

10	Heapify(A, i)

11   le <- left(i)

12   ri <- right(i)

13   if (le<=heapsize) and (A[le]>A[i])

14      largest <- le

15   else

16      largest <- i 

17   if (ri<=heapsize) and (A[ri]>A[largest])

18      largest <- ri

19   if (largest != i) {

20      exchange A[i] <-> A[largest]

21      Heapify(A, largest)

*/
public class heapSort {
	protected static ArrayList<Integer> heapSort (ArrayList<Integer> list) {
		ArrayList<Integer> dup = list;
		int size = dup.size();
		buildHeap (dup);
		for (int i = size - 1; i >= 0; i--) {
			Collections.swap (dup, 0, i);
			Heapify (dup, 0, i);
		}
		return dup;
	}
	private static void buildHeap (ArrayList<Integer> list) {
		ArrayList<Integer> dup = list;
		int size = dup.size();		
		for (int i = size/2 - 1; i >= 0; i--) {
			Heapify (dup, i, size);
		}
	}
	private static void Heapify (ArrayList<Integer> list, int i, int size) {
		ArrayList<Integer> dup = list;		
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if (left < size && dup.get(left) > dup.get(largest)) {
			largest = left;
		}
		if (right < size && dup.get(right) > dup.get(largest)) {
			largest = right;
		}
		if (largest != i) {
			Collections.swap(dup, i, largest);
			Heapify(dup, largest, size);
		}
	}	
/*
    public static void main(String args[]) { 
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
		heapSort(list);
		System.out.println(list);
    }
*/

}