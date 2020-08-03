package introAlgorithms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

public class countingSortGraph implements Runnable {
	private static boolean running = false; 
	private boolean visualize = true;
	private static ArrayList<Integer> arrayList; 
	private static final int largestValue = 250;
	private int array[];
	static Random rnd = new Random();	
	sortingGraphics graph;	
	ArrayList<arrayStore> list;	

	countingSortGraph (int i, sortingGraphics graph, boolean visualize, ArrayList<arrayStore> list) {
		this.array = new int[i];
		this.graph = graph;
		this.visualize = visualize;
		this.list = list;		
	}
	public void sort() {
		running = true;
		fillArray(array);

		long startTime = System.nanoTime();
		countingSort(array, array.length);
		long endTime = System.nanoTime();

		long timeTaken = (endTime - startTime) / 1000;

		if (visualize == false) {
			this.list.add(new arrayStore(array.length, timeTaken));
		}
		running = false;		
	}
	private void countingSort (int[] arr, int length) {
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
			if (visualize == true) {
				graph.draw(array);
				try { Thread.sleep(5);} catch (Exception ex) {}
			}			
			count[arr[i]]++;
		}
		for (int i = 1; i <= maxNum; ++i) {
			if (visualize == true) {
				graph.draw(array);
				try { Thread.sleep(5);} catch (Exception ex) {}
			}			
			count[i] += count[i - 1];		
		}
		for (int i = length - 1; i >= 0; i--) {			
			output[count[arr[i]] - 1] = arr[i];		
			if (visualize == true) {
				graph.draw(array);
				try { Thread.sleep(5);} catch (Exception ex) {}
			}				
			count[arr[i]]--;
		}
		for (int i = 0; i < length; ++i) {
			if (visualize == true) {
				graph.draw(array);
				try { Thread.sleep(5);} catch (Exception ex) {}
			}			
			arr[i] = output[i];			
		}
	}
	private void fillArray (int[] a) {
		for (int i = 0; i < a.length; ++i) {
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

	// public static void main(String args[]) {
	// 	int[] data = { 4, 2, 2, 8, 3, 3, 1, 9, 0, 6, 7 };
	// 	int size = data.length;
	// 	System.out.println(Arrays.toString(data));	
	// 	countingSort(data, size);
	// 	System.out.println("Sorted Array in Ascending Order: ");
	// 	System.out.println(Arrays.toString(data));
	// }
}
