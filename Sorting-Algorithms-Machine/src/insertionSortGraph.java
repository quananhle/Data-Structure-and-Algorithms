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

/* INSERTION-SORT (A)

1  for j <- 2 to length[A]

2       do key <- A[j]

3         Insert A[j] into the sorted sequence A[1 . . j - 1].

4        i <- j - 1

5        while i > 0 and A[i] > key

6           do A[i + 1] <- A[i]

7              i <- i - 1

8        A[i + 1] <- key
*/
public class insertionSortGraph implements Runnable {
	private static boolean running = false; 
	private boolean visualize = true;
	private static ArrayList<Integer> arrayList;
	private static final int largestValue = 250;
	static Random rnd = new Random();
	private int array[];
	sortingGraphics graph;
	ArrayList<arrayStore> list;

	insertionSortGraph (int i, sortingGraphics graph, boolean visualize, ArrayList<arrayStore> list) {
		this.array = new int[i];
		this.graph = graph;
		this.visualize = visualize;
		this.list = list;
	}

	public void sort() {
		running = true;
		fillArray(array);

		long startTime = System.nanoTime();
		insertionSort(array);
		long endTime = System.nanoTime();

		long timeTaken = (endTime - startTime) / 1000;

		if (visualize == false) {
			this.list.add(new arrayStore(array.length, timeTaken));
		}
		running = false;	
	}

	//Create a static method called insertionSort associated with the class insertionSort() 
		//so that the method can be called without the need of an object.
	//The method insertionSort takes the parameter of an array of integer numbers and returns nothing 
	private void insertionSort(int arr[]) { 
		int n = arr.length; 
		for (int i = 1; i < n; ++i) { 
			if (running == true) {
				int key = arr[i]; 
				int j = i - 1; 
				/* Move elements of arr[0..i-1], that are 
					greater than key, to one position ahead 
					of their current position */
				while (j >= 0 && arr[j] > key) { 
					arr[j + 1] = arr[j];
					j = j - 1; 
					if (visualize == true ) {
						graph.draw(arr);
						// sleep statement required to make the animation run at a visible speed
						try{ Thread.sleep(1); }  catch (InterruptedException e) {}
					}					
				}	 								
				arr[j + 1] = key; 
			}
		} 
	} 

	private void fillArray (int[] a){
		for (int i = 0; i < a.length; i++){
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
