package introAlgorithms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

public class sortingGraphics extends JPanel {
	int count = 0;
	int array[];
	int visualizeY = 400;
	int analyzeY = 500;
	Boolean visualize = true;
	ArrayList<arrayStore> insertionSort, heapSort, selectSort, bubbleSort, mergeSort, quickSort, radixSort, countingSort;

	public sortingGraphics(){
		setPreferredSize(new Dimension(750, 550));
		setBackground(new java.awt.Color(0, 0, 128));
		setBorder(BorderFactory.createEtchedBorder());
	}

	public void draw(int[] arr){
		this.array = arr;
		this.visualize = true;
		repaint();
	}

	public void sortingGraphics(ArrayList<arrayStore> iSort, ArrayList<arrayStore> hSort, ArrayList<arrayStore> bSort, 
						  ArrayList<arrayStore> sSort, ArrayList<arrayStore> mSort, ArrayList<arrayStore> qSort, 
						  ArrayList<arrayStore> rSort, ArrayList<arrayStore> cSort) {
		this.visualize = false;
		this.insertionSort = iSort;
		this.heapSort = hSort;
		this.bubbleSort = bSort;
		this.selectSort = sSort;
		this.mergeSort = mSort;
		this.quickSort = qSort;
		this.radixSort = rSort;
		this.countingSort = cSort;
		repaint();
	}

	public void drawIGraph(ArrayList<arrayStore> iSort) {
		this.insertionSort = iSort;
		this.visualize = false;
		repaint();
	}	

	public void drawHGraph(ArrayList<arrayStore> hSort) {
		this.heapSort = hSort;
		this.visualize = false;
		repaint();
	}	

	public void drawBGraph(ArrayList<arrayStore> bSort) {
		this.bubbleSort = bSort;
		this.visualize = false;
		repaint();
	}

	public void drawSGraph(ArrayList<arrayStore> sSort) {
		this.selectSort = sSort;
		this.visualize = false;
		repaint();
	}

	public void drawMGraph(ArrayList<arrayStore> mSort) {
		this.mergeSort = mSort;
		this.visualize = false;
		repaint();
	}

	public void drawQGraph(ArrayList<arrayStore> qSort) {
		this.quickSort = qSort;
		this.visualize = false;
		repaint();
	}

	public void drawRGraph(ArrayList<arrayStore> rSort) {
		this.radixSort = rSort;
		this.visualize = false;
		repaint();
	}

	public void drawCGraph(ArrayList<arrayStore> cSort) {
		this.countingSort = cSort;
		this.visualize = false;
		repaint();
	}

	public void paintComponent(Graphics graph){
		super.paintComponent(graph);

		if (array != null && visualize == true) {
			setBackground(new java.awt.Color(0, 0, 128));
			graph.setColor(new java.awt.Color(255,215,0));
			int x1 = 0;

			for (int i = 0; i < array.length; i++){
				x1 = x1 + 2;
				graph.drawLine(x1, (visualizeY - array[i]), x1, visualizeY);
			}
		}

		if (visualize == false) {
			setBackground(Color.LIGHT_GRAY);			
			//Graph Grid
			graph.setColor(Color.DARK_GRAY);
			int y = 475;
			for (int i = 0; i < 17; i++) {
				graph.drawLine(50, y, 600, y);
				y = y - 25;
			}
				
			//Vertical axis
			graph.setColor(Color.BLACK);
			graph.drawLine(50, analyzeY, 50, 50);
			//Horizontal axis
			graph.drawLine(50, analyzeY, 600, analyzeY);

			//Axis Labels
			graph.drawString("Size of array of " + 5500 + " elements", 250, 540);
			graph.drawString("Time", 5, 270);
			graph.drawString("(ms)", 9, 280);

			//x-axis Figures
			graph.setColor(Color.GRAY);
			int j = 0;
			int x = 40;
			for (int i = 0; i < 11; i ++) {
				j = j + 500;
				String s = Integer.toString(j);
				x = x + 50;
				graph.drawString(s, x, analyzeY + 15);
			}
			
			//y-axis Figures
			j = 0;
			y = analyzeY + 5;
			for (int i = 0; i < 9; i ++) {
				String s = Integer.toString(j);
				graph.drawString(s, 30, y);
				j = j + 5;
				y = y - 50;	
			}

			//Graph keys
			graph.setColor(Color.black);
			graph.drawString("Insertion Sort", 650, 50);
			graph.drawString("Heap Sort", 650, 100);
			graph.drawString("Merge Sort", 650, 150);
			graph.drawString("Quick Sort", 650, 200);
			graph.drawString("Radix Sort", 650, 250);
			graph.drawString("Counting Sort", 650, 300);
			// g.drawString("Bubble Sort", 650, 350);
			// g.drawString("Selection Sort", 650, 400);

			
			graph.setColor(Color.red);
			graph.fillRect(630, 40, 10, 10);
			graph.setColor(Color.cyan);
			graph.fillRect(630, 90, 10, 10);			
			graph.setColor(Color.orange);
			graph.fillRect(630, 140, 10, 10);
			graph.setColor(Color.yellow);
			graph.fillRect(630, 190, 10, 10);
			graph.setColor(Color.green);
			graph.fillRect(630, 240, 10, 10);
			graph.setColor(Color.blue);
			graph.fillRect(630, 290, 10, 10);						
			// g.setColor(Color.black);
			// g.fillRect(620, 350, 10, 10);
			// g.setColor(Color.blue);
			// g.fillRect(620, 400, 10, 10);			

			// Graph plotting for Insertion Sort algorithm
			if (insertionSort != null){
				graph.setColor(Color.RED);
				int stime2 = 0;
				int x2 = 0;
				// Cycles through every member of the ArrayList and plots a point in relation to the data provided
				for (arrayStore i : insertionSort) {
					long l1 = i.sortTime / 100;
					int stime = (int) l1;
					int x1 = i.arraySize / 10;

					graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
					graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

					stime2 = stime;
					x2 = x1;
				}
			}
			
			// Graph plotting for Heap Sort algorithm
			if (heapSort != null){
				graph.setColor(Color.CYAN);
				int stime2 = 0;
				int x2 = 0;
				// Cycles through every member of the ArrayList and plots a point in relation to the data provided
				for (arrayStore h : heapSort) {
					long l1 = h.sortTime / 100;
					int stime = (int) l1;
					int x1 = h.arraySize / 10;

					graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
					graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

					stime2 = stime;
					x2 = x1;
				}
			}

			// // Graph plotting for Bubble Sort algorithm
			// if (bubbleSort != null){
			// 	graph.setColor(Color.GREEN);
			// 	int stime2 = 0;
			// 	int x2 = 0;
			// 	// Cycles through every member of the ArrayList and plots a point in relation to the data provided
			// 	for (arrayStore b: bubbleSort) {
			// 		long l1 = b.sortTime / 100;
			// 		int stime = (int) l1;
			// 		int x1 = b.arraySize / 10;

			// 		graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
			// 		graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

			// 		stime2 = stime;
			// 		x2 = x1;
			// 	}
			// }
			
			// // Graph plotting for Selection Sort algorithm
			// if (selectSort != null) {
			// 	graph.setColor(Color.BLUE);
			// 	int stime2 = 0;
			// 	int x2 = 0;
			// 	// Cycles through every member of the ArrayList and plots a point in relation to the data provided
			// 	for (arrayStore s : selectSort) {
			// 		long l1 = s.sortTime / 100;
			// 		int stime = (int) l1;
			// 		int x1 = s.arraySize / 10;

			// 		graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
			// 		graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

			// 		stime2 = stime;
			// 		x2 = x1;
			// 	}
			// }
			
			// Graph plotting for Merge Sort algorithm
			if (mergeSort != null){
				graph.setColor(Color.ORANGE);
				int stime2 = 0;
				int x2 = 0;
				// Cycles through every member of the ArrayList and plots a point in relation to the data provided
				for (arrayStore m : mergeSort) {
					long l1 = m.sortTime / 100;
					int stime = (int) l1;
					int x1 = m.arraySize / 10;

					graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
					graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

					stime2 = stime;
					x2 = x1;
				}
			}

			// Graph plotting for Quick Sort algorithm
			if (quickSort != null){
				graph.setColor(Color.YELLOW);
				int stime2 = 0;
				int x2 = 0;
				// Cycles through every member of the ArrayList and plots a point in relation to the data provided
				for (arrayStore q : quickSort) {
					long l1 = q.sortTime / 100;
					int stime = (int) l1;
					int x1 = q.arraySize / 10;

					graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
					graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

					stime2 = stime;
					x2 = x1;
				}
			}

			// Graph plotting for Radix Sort algorithm
			if (radixSort != null){
				graph.setColor(Color.GREEN);
				int stime2 = 0;
				int x2 = 0;
				// Cycles through every member of the ArrayList and plots a point in relation to the data provided
				for (arrayStore r : radixSort) {
					long l1 = r.sortTime / 100;
					int stime = (int) l1;
					int x1 = r.arraySize / 10;

					graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
					graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

					stime2 = stime;
					x2 = x1;
				}
			}
			// Graph plotting for Counting Sort algorithm
			if (countingSort != null){
				graph.setColor(Color.BLUE);
				int stime2 = 0;
				int x2 = 0;
				// Cycles through every member of the ArrayList and plots a point in relation to the data provided
				for (arrayStore c : countingSort) {
					long l1 = c.sortTime / 100;
					int stime = (int) l1;
					int x1 = c.arraySize / 10;

					graph.drawLine(x2 + 50, analyzeY - stime2, x1 + 50, analyzeY - stime);
					graph.drawOval(x1 + 50 - 2, analyzeY - 2 - stime, 4, 4);

					stime2 = stime;
					x2 = x1;
				}
			}			
		}
	}
	
}