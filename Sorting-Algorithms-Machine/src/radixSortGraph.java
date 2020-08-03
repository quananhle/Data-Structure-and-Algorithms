package introAlgorithms;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

public class radixSortGraph implements Runnable {
	private static boolean running = false; 
	private boolean visualize = true;
	private static ArrayList<Integer> arrayList; 
	private static final int largestValue = 250;
	static Random rnd = new Random();
	private int array[];
	sortingGraphics graph;	
	ArrayList<arrayStore> list;	
	private final int RADIX = 10;

	radixSortGraph (int i, sortingGraphics graph, boolean visualize, ArrayList<arrayStore> list) {
		this.array = new int[i];
		this.graph = graph;
		this.visualize = visualize;
		this.list = list;		
	}
	public void sort() {
		running = true;
		fillArray(array);

		long startTime = System.nanoTime();
		radixSort(array, array.length);
		long endTime = System.nanoTime();

		long timeTaken = (endTime - startTime) / 1000;

		if (visualize == false) {
			this.list.add(new arrayStore(array.length, timeTaken));
		}
		running = false;		
	}
	private void radixSort (int arr[], int length) {
		int maxNum = findMax (arr, length);
		for (int place = 1; (maxNum / place) > 0; place *= RADIX) {
			if (visualize == true) {
				graph.draw(array);
				try { Thread.sleep(5);} catch (Exception ex) {}
			}
			countingSort (arr, length, place);
		}
	}
	private int findMax (int arr[], int n) {
		int maxNum = arr[0];
		for (int i = 1; i < n; ++i) {
			if (arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		return maxNum;
	}
	private void countingSort (int arr[], int length, int place) {
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
			count[(arr[i] / place) % RADIX]++;
		}
		for (int i = 1; i < RADIX; ++i) {
			count[i] += count[i - 1];
			if (visualize == true) {
				graph.draw(array);
				try { Thread.sleep(5);} catch (Exception ex) {}
			}			
		}
		for (int i = length - 1; i >= 0; i--) {
			output[count[(arr[i] / place) % RADIX] - 1] = arr[i];
			if (visualize == true) {
				graph.draw(array);
				try { Thread.sleep(5);} catch (Exception ex) {}
			}
			count[(arr[i] / place) % RADIX]--;		
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
