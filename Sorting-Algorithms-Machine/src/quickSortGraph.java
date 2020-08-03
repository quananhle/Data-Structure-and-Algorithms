package introAlgorithms;

import java.util.ArrayList;
import java.util.Random;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

public class quickSortGraph implements Runnable {
	private static boolean running = false; 
	private boolean visualize = true;
	static Random rnd = new Random();
	static final int largestValue = 250;
	sortingGraphics graph;
	private int array[];

	ArrayList<arrayStore> list;

	quickSortGraph (int i, sortingGraphics graph, boolean visualize, ArrayList<arrayStore> list) {
		this.array = new int[i];
		this.graph = graph;
		this.visualize = visualize;
		this.list = list;
	}

	public void sort() {
		running = true;
		fillArray(array);

		long startTime = System.nanoTime();
		quickSort(array, 0, array.length - 1);
		long endTime = System.nanoTime();

		long timeTaken = (endTime - startTime) / 1000;

		if (visualize == false) {
			this.list.add(new arrayStore(array.length, timeTaken));
		}
		running = false;
	}

	private void quickSort(int[] a, int left, int right) {
		int index = partition(a, left, right);

		if (running == true) {
			if (left < index - 1){
				quickSort(a, left, index - 1);
			}
		}
		if (running == true) {
			if (index < right){
				quickSort(a, index, right);
			}
		}
	}

	private int partition(int[] a, int left, int right) {
		int i = left;
		int j = right;
		int pivot = a[(left + right) / 2];

		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		return i;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		if (visualize == true ) {
			graph.draw(a);
			try{ Thread.sleep(10); }  catch (InterruptedException e) {}
		}
	}

	private static void fillArray (int[] a) {
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
