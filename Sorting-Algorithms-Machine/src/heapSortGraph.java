package introAlgorithms;

import java.util.Random;
import java.util.ArrayList;

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
public class heapSortGraph implements Runnable {
	private static boolean running = false; 
	private boolean visualize = true;
	private static ArrayList<Integer> arrayList;
	private static final int largestValue = 250;
	static Random rnd = new Random();
	private int array[];
	sortingGraphics graph;
	ArrayList<arrayStore> list;	

	heapSortGraph (int i, sortingGraphics graph, boolean visualize, ArrayList<arrayStore> list) {
		this.array = new int[i];
		this.graph = graph;
		this.visualize = visualize;
		this.list = list;
	}
	
	public void sort() {
		running = true;
		fillArray(array);

		long startTime = System.nanoTime();
		heapSort(array);
		long endTime = System.nanoTime();

		long timeTaken = (endTime - startTime) / 1000;

		if (visualize == false) {
			this.list.add(new arrayStore(array.length, timeTaken));
		}
		running = false;	
	}

	public void heapSort(int arr[]) { 
		int n = arr.length; 
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i); 
		}

		for (int i=n-1; i>=0; i--) {  
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp;
			if (visualize == true ) {
				graph.draw(arr);
				try{ Thread.sleep(10); }  catch (InterruptedException e) {}
			}
			heapify(arr, i, 0); 
		} 
	} 

	public void heapify(int arr[], int n, int i) { 
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;

		if (l < n && arr[l] > arr[largest]) {
			largest = l; 
		}

		if (r < n && arr[r] > arr[largest]) {
			largest = r; 
		}

		if (largest != i) { 
			int swap = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = swap; 
			if (visualize == true ) {
				graph.draw(arr);
				try{ Thread.sleep(10); }  catch (InterruptedException e) {}
			}
			heapify(arr, n, largest); 
		}
	}

	private void fillArray (int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = rnd.nextInt(largestValue);
		}
	}
	public void stop() {
		running = false;
	}
	@Override
	public void run() {
		sort();
	}
}	