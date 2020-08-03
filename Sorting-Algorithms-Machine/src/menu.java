package introAlgorithms;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/
 
import java.util.concurrent.TimeUnit;
//Calling the library javax.swing.* to use the class JPanel, JButton, JRadioButton, JCheckBox, JButton, JTextField, JTextArea, JScrollPane
import javax.swing.*;
//Calling the library javax.swing.border to use the class TitledBorder
import javax.swing.border.TitledBorder;
//Calling the library java.awt.* to use the setBackGround() method, BorderLayout, GridLayout
import java.awt.*;
//Calling the library java.util to initialize ArrayList
//The reason to use ArrayList instead of Array is to only hold object values. 
//The size of the array after it is constructed can not be changed. 
//The number of elements in an ArrayList can be updated after it is constructed.
import java.util.ArrayList;
//Calling the library java.awt.event.* to use the ActionListener() method, ActionEvent data type and Listener class
import java.awt.event.*;
//Calling the DecimalFormat and NumberFormat methods from the library java.text
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class menu extends JFrame {
	ButtonGroup checkBoxes = new ButtonGroup();
	private boolean running = false, messageSwitchOn = true, atLeastOneChecked = false;
	//Initializing JPanel data type variables to construct the panel of the software
	private JPanel rightPanel, topPanel, leftPanel, bottomPanel;
	//Initializing JButton, JRadioButton, and JCheckBox data type variables to construct the radio buttons/option buttons of the software
	private JCheckBox iSort, mSort, qSort, hSort, rSort, cSort;
	private JButton all, stop; 
	private JRadioButton visualize, analyze;
	//Initializing JButton data type variables to construct the buttons of the software
	private JButton generate, run; 
	private static JButton reset;
	private int horizontal, vertical;
	//Initializing JTextField data type variables to receive input from the users
	private JTextField nums;
	//Initializing JScrollPane data type variables to have the scroll pane function
	private JScrollPane scrollPane;
	//Initializing ArrayList<JCheckBox> data type variables to group all JRadioButtons
	// private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
	//Initializing JTextArea data type variables to display the text
	private final JTextArea TEXT_AREA_EAST = new JTextArea(30,40);
	private final JTextArea TEXT_AREA_WEST = new JTextArea(30,40);
	//Set up the format of the number
	private static final NumberFormat NUMBER_FORMAT = new DecimalFormat("#00.00");
//=========================================================================================================================================//
	// Variable and Swing components
	private int gPoints = 55;
	// Object creation
	Thread t;
	insertionSortGraph i;
	heapSortGraph h;
	mergeSortGraph m;
	quickSortGraph q;
	radixSortGraph r;
	countingSortGraph c;
	sortingGraphics graph = new sortingGraphics();
	// ArrayList creation
	ArrayList<arrayStore> insertionStore;
	ArrayList<arrayStore> heapStore;
	ArrayList<arrayStore> mergeStore;
	ArrayList<arrayStore> quickStore;
	ArrayList<arrayStore> radixStore;
	ArrayList<arrayStore> countingStore;
//=========================================================================================================================================//

	//Size of panel
	public void psize() {
		vertical = 10;
		horizontal = 5;
	}
	//Method display() to construct the panel, layout, border, background, and text areas
	private void display() {
		//Setting the name of software
		setTitle ("Sorting Algorithm Runtime Calculator");
		//setDefaultCloseOperation() method is used to specify exit the application at close
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				int reply = JOptionPane.showConfirmDialog(menu.this,
						"Are you sure you want to quit?",
						"Exit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (reply == JOptionPane.YES_OPTION) {
					System.out.print("\033[H\033[2J");
					System.out.flush();
					// dispose();
					System.exit(0);  
				} else {
					return;
				}
			}
		});
		//Set the size of panel
		setSize(500,300);
		//setLocationRelativeTo(null) is used to center the GUI on the screen
		setLocationRelativeTo(null);
		//Setting the layout of the panel
		setLayout(new GridLayout(5,2,5,5));

		//Constructing the content panel
		JPanel contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.white);
		contentPane.setBorder(
		BorderFactory.createEmptyBorder(horizontal, horizontal, horizontal, horizontal));
		contentPane.setLayout(new BorderLayout(horizontal, vertical));
		//Initializing a ButtonGroup variable bg 
		ButtonGroup bg = new ButtonGroup();
		// ButtonGroup vg = new ButtonGroup();

		//Constructing the top panel
		topPanel = new JPanel();
		topPanel.setOpaque(true);
		topPanel.setBackground(Color.red);
		TitledBorder border = BorderFactory.createTitledBorder("Enter the size of the list");
		border.setTitleJustification(TitledBorder.CENTER);
		topPanel.setBorder(border);
		//Constructing the text field to receive the input from user. 
		//The text field can display up to 5 integer at a time
		nums = new JTextField(5);
		nums.setBorder(BorderFactory.createLoweredBevelBorder());
		//Setting the empty field in the text field
		nums.setText("");
		//Setting radio buttons 'analyze' and 'visualize'
		visualize = new JRadioButton ("Visualize");
		analyze = new JRadioButton ("Analyze");
		//Adding the text field to the top panel
		topPanel.add(nums);
		topPanel.add(visualize);
		topPanel.add(analyze);
 
		//Constructing the left panel
		leftPanel = new JPanel();
		leftPanel.setOpaque(true);
		leftPanel.setBackground(Color.yellow);
		//Setting the attributes for border
		border = BorderFactory.createTitledBorder("Unsorting List");
		border.setTitleJustification(TitledBorder.CENTER);
		leftPanel.setBorder(border);     
		//Creating a button
		generate = new JButton ("Generate");
		//Adding the button to the button group data type
		bg.add(generate);
		//Adding the button to top alignment of the left panel
		leftPanel.add(generate, JPanel.TOP_ALIGNMENT);
		leftPanel.add(TEXT_AREA_WEST, BorderLayout.WEST);
		//Adding a scroll bar to the left panel
		scrollPane = new JScrollPane(TEXT_AREA_WEST, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		leftPanel.add(scrollPane);

		//Constructing the right panel        
		rightPanel = new JPanel();
		rightPanel.setOpaque(true);
		rightPanel.setBackground(Color.yellow);
		//Setting the attributes for border        
		border = BorderFactory.createTitledBorder("Sorted List");
		border.setTitleJustification(TitledBorder.CENTER);
		rightPanel.setBorder(border);
		//Creating a button        
		run = new JButton("Run");
		//Adding the button to top alignment of the left panel        
		rightPanel.add(run, JPanel.TOP_ALIGNMENT);
		rightPanel.add(TEXT_AREA_EAST, BorderLayout.EAST);
		//Adding a scroll bar
		scrollPane = new JScrollPane(TEXT_AREA_EAST, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rightPanel.add(scrollPane);

		// TextArea to display the list of all the numbers
		TEXT_AREA_WEST.setBackground(Color.CYAN);
		TEXT_AREA_WEST.setEditable(false);
		TEXT_AREA_EAST.setBackground(Color.CYAN);
		TEXT_AREA_EAST.setEditable(false);

		//Constructing the bottom panel        
		bottomPanel = new JPanel();
		bottomPanel.setOpaque(true);
		bottomPanel.setBackground(Color.red);
		bottomPanel.setLayout(new GridBagLayout());
		//Setting the attributes for border                
		border = BorderFactory.createTitledBorder("Sorting Algorithms");
		border.setTitleJustification(TitledBorder.CENTER);
		bottomPanel.setBorder(border);
		//Creating buttons to select the type of algorithm or reset the software        
		iSort = new JCheckBox ("Insertion Sort");
		mSort = new JCheckBox ("Merge Sort");
		hSort = new JCheckBox ("Heap Sort");
		qSort = new JCheckBox ("Quick Sort");
		rSort = new JCheckBox ("Radix Sort");
		cSort = new JCheckBox ("Counting Sort");
		all = new JButton ("Select All");
		reset = new JButton("Reset");
		// Setting checkboxes
		iSort.setMnemonic(KeyEvent.VK_I);
		mSort.setMnemonic(KeyEvent.VK_M);
		hSort.setMnemonic(KeyEvent.VK_H);
		qSort.setMnemonic(KeyEvent.VK_Q);
		rSort.setMnemonic(KeyEvent.VK_R);
		cSort.setMnemonic(KeyEvent.VK_C);
		//Adding all the buttons to the button group data type        	
		bg.add(all);
		bg.add(reset);		
//=========================================================================================================================================//
		//Adding the all the buttons to the bottom panel 		
		GridBagConstraints gc = new GridBagConstraints();

		//first Column upper JPanel
		gc.weightx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 0;
		gc.gridy = 0;
		bottomPanel.add(iSort, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		bottomPanel.add(mSort, gc);

		gc.gridx = 2;
		gc.gridy = 0;		
		bottomPanel.add(qSort, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		bottomPanel.add(hSort, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		bottomPanel.add(rSort, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		bottomPanel.add(cSort, gc);		

		gc.gridx = 3;
		gc.gridy = 0;
		bottomPanel.add(all, gc);

		gc.gridx = 3;
		gc.gridy = 1;
		bottomPanel.add(reset, gc);		
//=========================================================================================================================================//

		//Splitting the pane horizontally to the left panel and the right panel
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel );
		contentPane.add(topPanel, BorderLayout.PAGE_START);
		contentPane.add(pane, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.PAGE_END);

		setContentPane(contentPane);
		pack();
		setLocationByPlatform(true);
		setVisible(true);

		//Initializing the object of ListernerClass        	
		ListenerClass listener = new ListenerClass();
		//Calling the method addActionListener that takes object ListenerClass as the argument for the buttons 'generate', 'run', 'reset'
		generate.addActionListener(listener);
		run.addActionListener(listener);
		reset.addActionListener(listener);

		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				boolean toCheck = true;
				if(all.getText().toString().equalsIgnoreCase("Select All")) {
					checkAll();
					toCheck = true;
					all.setText("Clear All");
				} else if (all.getText().toString().equalsIgnoreCase("Clear All")) {
					uncheckAll();					
					toCheck = false;
					all.setText("Select All");
				} 
			}
		});

		visualize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (visualize.isSelected()) {
					analyze.setSelected(false);
					enableAll();
					uncheckAll();

					nums.setText("375");
					nums.setEnabled(false);
					generate.setEnabled(false);
					all.setEnabled(false);

					checkBoxes.add(iSort);
					checkBoxes.add(mSort);
					checkBoxes.add(hSort);
					checkBoxes.add(qSort);
					checkBoxes.add(rSort);
					checkBoxes.add(cSort);					
					//===========================================//
					// for (JCheckBox checkBox : checkBoxes) {
					// 	if (checkBox.isSelected()) {
					// 		for(int i = 0; i < checkBoxes.size(); i++) {
					// 			if (!checkBoxes.get(i).isSelected()) {
					// 				checkBoxes.get(i).setEnabled(false);
					// 				checkBoxes.get(i).setSelected(false);
					// 			}
					// 		}
					// 	}
					// }
					//===========================================//
				}
				else {
					enableAll();
					uncheckAll();

					nums.setText("");
					nums.setEnabled(true);
					generate.setEnabled(true);
					all.setEnabled(true);

					checkBoxes.remove(iSort);
					checkBoxes.remove(mSort);
					checkBoxes.remove(hSort);
					checkBoxes.remove(qSort);
					checkBoxes.remove(rSort);
					checkBoxes.remove(cSort);
				}
			}
		});

		analyze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
				if (!analyze.isSelected()) {
					enableAll();
					uncheckAll();

					nums.setText("");
					nums.setEnabled(true);
					generate.setEnabled(true);
					all.setEnabled(true);
				} else {
					checkBoxes.remove(iSort);
					checkBoxes.remove(mSort);
					checkBoxes.remove(hSort);
					checkBoxes.remove(qSort);
					checkBoxes.remove(rSort);
					checkBoxes.remove(cSort);

					visualize.setSelected(false);
					checkAll();
					disableAll();
					
					nums.setText("5500");					
					nums.setEnabled(false);	
					generate.setEnabled(false);	
					all.setEnabled(false);					
				}
			}
		});

	}
	//Implementing the class 'ListenerClass' implements 'ActionListener'
	private class ListenerClass implements ActionListener {
		//Calling the method actionPerformed that takes ActionEvent data type
		public void actionPerformed(ActionEvent e) {
			//If the user select button 'generate'
			if (e.getSource() == generate) {
				//Run the 'generate()' method
				generate();
			}
			//If the user select button 'run'
			if (e.getSource() == run) {
				//Run the 'operate()' method
				operate();		
			}
			//If the user select button 'reset'
			if (e.getSource() == reset) {
				//Run the 'reset()' method
				reset();
			}
		}
	}	
	//Initializing an ArrayList 'list' of integer numbers
	private ArrayList<Integer> list = new ArrayList<Integer>();
	//Implementing the 'generate()' method
	private ArrayList<Integer> generate() {
		try {
			//Parsing the int data type from text input by user into the text field 'nums' and save it to 'arraySize'
			int arraySize = Integer.parseInt(nums.getText());
			//Generating random array of number with the size of arraySize into the ArrayList 'list' of integer numbers
			list = generateRandomArray.generate(arraySize);
			//Set the text for the text area of the left panel
			TEXT_AREA_WEST.setText("Random List\n");
			System.out.println("\nRandom List\n" + list + "\n");
			TEXT_AREA_WEST.append("\n[");
			//Running a for loop that iterating from index 0 until the end of the ArrayList 'list'
			for (int i = 0; i < list.size(); i++) {
				//Saving the index 'i' of the ArrayList 'list' into 'num'
				Integer num = list.get(i);
				//Separating each number in the list with ',', and end the list with no comma
				//Check if index i is not the second to the last index of the ArrayList 'list'
				if (i != (list.size() - 1)) {
					//Appending the integer 'num' and separating each number with ','
					TEXT_AREA_WEST.append(num + ", ");
				//If the index i is the second to the last index of the ArrayList 'list'	
				} else {
					//Copying the element at index 'i' of the ArrayList 'list' into 'num'
					num = list.get(i);
					//End the list with "]" with the comma at the end
					TEXT_AREA_WEST.append(num + "]" + "\n");
				}
				//For every 20 elements in the list, break into a new line
				if ((i + 1) % 20 == 0) {
					TEXT_AREA_WEST.append("\n");
				}
			}
		//Throwing the exception
		} catch (Exception e) {
			if ((list.isEmpty()) && (running == true)) {} 
				else if ( (list.isEmpty()) && (visualize.isSelected()) ) {}
					else if ( (list.isEmpty()) && (analyze.isSelected()) ) {}
			else {
				//Showing the warning dialog
				JOptionPane.showMessageDialog(null, " Please enter numeric values for the size of the list.", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
			}
		}
		return list;
	}	
	public ArrayList<Integer> operate() {
		atLeastOneChecked = false;
		long startTime, endTime;
		long duration = 0; 
		long duration1 = 0;
		long duration2 = 0;
		
		//Initializing an ArrayList 'list1' and 'list2' of integer numbers
		ArrayList<Integer> iList = new ArrayList<Integer> ();
		ArrayList<Integer> mList = new ArrayList<Integer> ();
		ArrayList<Integer> qList = new ArrayList<Integer> ();
		ArrayList<Integer> hList = new ArrayList<Integer> ();
		ArrayList<Integer> rList = new ArrayList<Integer> ();
		ArrayList<Integer> cList = new ArrayList<Integer> ();

		try {
			//Checking if the 'Insertion Sort' option is selected by the users
			if ( (iSort.isSelected()) && (!visualize.isSelected()) && (!analyze.isSelected()) )  {	
				if ((list.isEmpty()) && (running == true)) {}
					else if ((list.isEmpty()) && (running == false)) {
					JOptionPane.showMessageDialog(null, " Please generate the list", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
				}
				else {
					//Initializing the time counter for the insertion sort algorithm
					//Only measuring the time that passed during the execution of sort(ArrayList<Integer)
					startTime = System.currentTimeMillis();
					iList = insertionSort.insertionSort(list);
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					
					System.out.println("\nInsertion Sorted List\n" + iList + "\n");
					System.out.println("The running time of the Insertion-Sort Algorithm on a list of " + iList.size() 
					+ " elements" + "\n" +" is "+ duration + " milliseconds.");			

		    		//Display text in the right panel
		    		TEXT_AREA_EAST.append("Insertion-Sort Sorted List\n\n");
					TEXT_AREA_EAST.append("[");
					//Running a for loop that iterating from index 0 until the end of the ArrayList 'list'			
					for (int i = 0; i < iList.size(); i++) {
						//Saving the index 'i' of the ArrayList 'list' into 'num'		    	
						Integer num = iList.get(i);
						//Separating each number in the list with ',', and end the list with no comma
						//Check if index i is not the second to the last index of the ArrayList 'list'
						if (i != (iList.size() - 1)) {
							//Appending the integer 'num' and separating each number with ','
							TEXT_AREA_EAST.append(num + ", ");
						//If the index i is the second to the last index of the ArrayList 'list'
						} else {
							//Copying the element at index 'i' of the ArrayList 'list' into 'num'
							num = iList.get(i);
							//End the list with "]" with the comma at the end
							TEXT_AREA_EAST.append(num + "]" + "\n\n");
						}
						//For every 30 elements in the list, break into a new line
						if ((i + 1) % 30 == 0) {
							TEXT_AREA_EAST.append("\n");
						}
					}
					//Displaying the running time of the algorithm
					TEXT_AREA_EAST.append("The running time of the Insertion Sort Algorithm on a list of " + iList.size() 
											+ " random" + "\n" + "integer numbers ranging from 0 to 10000 is "+ duration + " milliseconds.\n\n");
				}
				atLeastOneChecked = true;
			}
			else if ( (iSort.isSelected()) && (visualize.isSelected()) ) {
				createWindow();
				runGraphic();
				atLeastOneChecked = true;
			}
			//Checking if the 'Merge Sort' option is selected by the users	
			if ( (mSort.isSelected()) && (!visualize.isSelected()) && (!analyze.isSelected()) ) {
				if ((list.isEmpty()) && (running == true)) {} else if ((list.isEmpty()) && (running == false)) {
					JOptionPane.showMessageDialog(null, " Please generate the list", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
				}
				else {
					//Initializing the time counter for the merge sort algorithm		
					//Only measuring the time that passed during the execution of sort(ArrayList<Integer)
					startTime = System.currentTimeMillis();
					mList = mergeSort.mergeSort(list);
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					
					System.out.println("\nMerge Sorted List\n" + mList + "\n");
					System.out.println("The running time of the Merge-Sort Algorithm on a list of " + mList.size() 
					+ " elements" + "\n" + " is "+ duration + " milliseconds.");

					//Display text in the right panel	    		
					TEXT_AREA_EAST.append("Merge-Sort Sorted List\n\n");    	
					TEXT_AREA_EAST.append("[");
					//Running a for loop that iterating from index 0 until the end of the ArrayList 'list2'			
					for (int i = 0; i < mList.size(); i++) {
						//Saving the index 'i' of the ArrayList 'list2' into 'num'
						Integer num = mList.get(i);
						//Separating each number in the list with ',', and end the list with no comma
						//Checking if index i is not the second to the last index of the ArrayList 'list2'
						if (i != (mList.size() - 1)) {
							TEXT_AREA_EAST.append(num + ", ");
						//If the index i is the second to the last index of the ArrayList 'list2'
						} else {
							//Copying the element at index 'i' of the ArrayList 'list2' into 'num'
							num = mList.get(i);
							//End the list with "]" with the comma at the end
							TEXT_AREA_EAST.append(num + "]" + "\n\n");
						}
						//For every 30 elements in the list, break into a new line				
						if ((i + 1) % 30 == 0) {
							TEXT_AREA_EAST.append("\n");
						}
					}
					//Displaying the running time of the algorithm
					TEXT_AREA_EAST.append("The running time of the Merge Sort Algorithm on a list of " + mList.size() 
											+ " random" + "\n" + "integer numbers ranging from 0 to 10000 is "+ duration + " milliseconds.\n\n");	
				}
				atLeastOneChecked = true;
			}
			else if ( (mSort.isSelected()) && (visualize.isSelected()) ) {
				createWindow();
				runGraphic();				
				atLeastOneChecked = true;
			}			
			//Checking if the 'Quick Sort' option is selected by the users					
			if ( (qSort.isSelected()) && (!visualize.isSelected()) && (!analyze.isSelected()) ) {
				if ((list.isEmpty()) && (running == true)) {} else if ((list.isEmpty()) && (running == false)) {
					JOptionPane.showMessageDialog(null, " Please generate the list", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					//Initializing the time counter for the quick sort algorithm		
					//Only measuring the time that passed during the execution of sort(ArrayList<Integer)
					startTime = System.currentTimeMillis();
					qList = quickSort.quickSort(list);
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					
					System.out.println("\nQuick Sorted List\n" + qList + "\n");
					System.out.println("The running time of the Quick-Sort Algorithm on a list of " + qList.size() 
					+ " elements" + "\n" + " is "+ duration + " milliseconds.");

					//Display text in the right panel	    		
					TEXT_AREA_EAST.append("Quick-Sort Sorted List\n\n");    	
					TEXT_AREA_EAST.append("[");
					//Running a for loop that iterating from index 0 until the end of the ArrayList 'list2'			
					for (int i = 0; i < qList.size(); i++) {
						//Saving the index 'i' of the ArrayList 'list2' into 'num'
						Integer num = qList.get(i);
						//Separating each number in the list with ',', and end the list with no comma
						//Checking if index i is not the second to the last index of the ArrayList 'list2'
						if (i != (qList.size() - 1)) {
							TEXT_AREA_EAST.append(num + ", ");
						//If the index i is the second to the last index of the ArrayList 'list2'
						} else {
							//Copying the element at index 'i' of the ArrayList 'list2' into 'num'
							num = qList.get(i);
							//End the list with "]" with the comma at the end
							TEXT_AREA_EAST.append(num + "]" + "\n\n");
						}
						//For every 30 elements in the list, break into a new line				
						if ((i + 1) % 30 == 0) {
							TEXT_AREA_EAST.append("\n");
						}
					}
					//Displaying the running time of the algorithm
					TEXT_AREA_EAST.append("The running time of the Quick Sort Algorithm on a list of " + qList.size() 
											+ " random" + "\n" + "integer numbers ranging from 0 to 10000 is "+ duration + " milliseconds.\n\n");
				}
				atLeastOneChecked = true;
			}
			else if ( (qSort.isSelected()) && (visualize.isSelected()) ) {
				createWindow();
				runGraphic();				
				atLeastOneChecked = true;
			}			
			//Checking if the 'Heap Sort' option is selected by the users
			if ( (hSort.isSelected()) && (!visualize.isSelected()) && (!analyze.isSelected()) ) {
				if ((list.isEmpty()) && (running == true)) {} else if ((list.isEmpty()) && (running == false)) {
					JOptionPane.showMessageDialog(null, " Please generate the list", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					//Initializing the time counter for the heap sort algorithm		
					//Only measuring the time that passed during the execution of sort(ArrayList<Integer)
					startTime = System.currentTimeMillis();
					hList = heapSort.heapSort(list);
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					
					System.out.println("\nHeap Sorted List\n" + hList + "\n");
					System.out.println("The running time of the Heap-Sort Algorithm on a list of " + hList.size() 
					+ " elements" + "\n" + " is "+ duration + " milliseconds.");

					//Display text in the right panel	    		
					TEXT_AREA_EAST.append("Heap-Sort Sorted List\n\n");    	
					TEXT_AREA_EAST.append("[");
					//Running a for loop that iterating from index 0 until the end of the ArrayList 'list2'			
					for (int i = 0; i < hList.size(); i++) {
						//Saving the index 'i' of the ArrayList 'list2' into 'num'
						Integer num = hList.get(i);
						//Separating each number in the list with ',', and end the list with no comma
						//Checking if index i is not the second to the last index of the ArrayList 'list2'
						if (i != (hList.size() - 1)) {
							TEXT_AREA_EAST.append(num + ", ");
						//If the index i is the second to the last index of the ArrayList 'list2'
						} else {
							//Copying the element at index 'i' of the ArrayList 'list2' into 'num'
							num = hList.get(i);
							//End the list with "]" with the comma at the end
							TEXT_AREA_EAST.append(num + "]" + "\n\n");
						}
						//For every 30 elements in the list, break into a new line				
						if ((i + 1) % 30 == 0) {
							TEXT_AREA_EAST.append("\n");
						}
					}
					//Displaying the running time of the algorithm
					TEXT_AREA_EAST.append("The running time of the Heap Sort Algorithm on a list of " + hList.size() 
											+ " random" + "\n" + "integer numbers ranging from 0 to 10000 is "+ duration + " milliseconds.\n\n");
				}
				atLeastOneChecked = true;				
			}
			else if ( (hSort.isSelected()) && (visualize.isSelected()) ) {
				createWindow();
				runGraphic();				
				atLeastOneChecked = true;
			}
			//Checking if the 'Radix Sort' option is selected by the users
			if ( (rSort.isSelected()) && (!visualize.isSelected()) && (!analyze.isSelected()) )  {	
				if ((list.isEmpty()) && (running == true)) {}
					else if ((list.isEmpty()) && (running == false)) {
					JOptionPane.showMessageDialog(null, " Please generate the list", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
				}
				else {
					//Initializing the time counter for the radix sort algorithm
					//Only measuring the time that passed during the execution of sort(ArrayList<Integer)
					startTime = System.currentTimeMillis();
					rList = radixSort.radixSort(list);
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					
					System.out.println("\nRadix-Sorted List\n" + rList + "\n");
					System.out.println("The running time of the Radix Sort Algorithm on a list of " + rList.size() 
					+ " elements" + "\n" +" is "+ duration + " milliseconds.");			

		    		//Display text in the right panel
		    		TEXT_AREA_EAST.append("Radix-Sort Sorted List\n\n");
					TEXT_AREA_EAST.append("[");
					//Running a for loop that iterating from index 0 until the end of the ArrayList 'list'			
					for (int i = 0; i < rList.size(); i++) {
						//Saving the index 'i' of the ArrayList 'list' into 'num'		    	
						Integer num = rList.get(i);
						//Separating each number in the list with ',', and end the list with no comma
						//Check if index i is not the second to the last index of the ArrayList 'list'
						if (i != (rList.size() - 1)) {
							//Appending the integer 'num' and separating each number with ','
							TEXT_AREA_EAST.append(num + ", ");
						//If the index i is the second to the last index of the ArrayList 'list'
						} else {
							//Copying the element at index 'i' of the ArrayList 'list' into 'num'
							num = rList.get(i);
							//End the list with "]" with the comma at the end
							TEXT_AREA_EAST.append(num + "]" + "\n\n");
						}
						//For every 30 elements in the list, break into a new line
						if ((i + 1) % 30 == 0) {
							TEXT_AREA_EAST.append("\n");
						}
					}
					//Displaying the running time of the algorithm
					TEXT_AREA_EAST.append("The running time of the Radix Sort Algorithm on a list of " + rList.size() 
											+ " random" + "\n" + "integer numbers ranging from 0 to 10000 is "+ duration + " milliseconds.\n\n");
				}
				atLeastOneChecked = true;
			}
			else if ( (rSort.isSelected()) && (visualize.isSelected()) ) {
				createWindow();
				runGraphic();
				atLeastOneChecked = true;
			}
			//Checking if the 'Counting Sort' option is selected by the users
			if ( (cSort.isSelected()) && (!visualize.isSelected()) && (!analyze.isSelected()) )  {	
				if ((list.isEmpty()) && (running == true)) {}
					else if ((list.isEmpty()) && (running == false)) {
					JOptionPane.showMessageDialog(null, " Please generate the list", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
				}
				else {
					//Initializing the time counter for the counting sort algorithm
					//Only measuring the time that passed during the execution of sort(ArrayList<Integer)
					startTime = System.currentTimeMillis();
					cList = countingSort.countingSort(list);
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					
					System.out.println("\nCounting-Sorted List\n" + cList + "\n");
					System.out.println("The running time of the Counting Sort Algorithm on a list of " + cList.size() 
					+ " elements" + "\n" +" is "+ duration + " milliseconds.");			

		    		//Display text in the right panel
		    		TEXT_AREA_EAST.append("Counting-Sort Sorted List\n\n");
					TEXT_AREA_EAST.append("[");
					//Running a for loop that iterating from index 0 until the end of the ArrayList 'list'			
					for (int i = 0; i < cList.size(); i++) {
						//Saving the index 'i' of the ArrayList 'list' into 'num'		    	
						Integer num = cList.get(i);
						//Separating each number in the list with ',', and end the list with no comma
						//Check if index i is not the second to the last index of the ArrayList 'list'
						if (i != (cList.size() - 1)) {
							//Appending the integer 'num' and separating each number with ','
							TEXT_AREA_EAST.append(num + ", ");
						//If the index i is the second to the last index of the ArrayList 'list'
						} else {
							//Copying the element at index 'i' of the ArrayList 'list' into 'num'
							num = cList.get(i);
							//End the list with "]" with the comma at the end
							TEXT_AREA_EAST.append(num + "]" + "\n\n");
						}
						//For every 30 elements in the list, break into a new line
						if ((i + 1) % 30 == 0) {
							TEXT_AREA_EAST.append("\n");
						}
					}
					//Displaying the running time of the algorithm
					TEXT_AREA_EAST.append("The running time of the Counting Sort Algorithm on a list of " + cList.size() 
											+ " random" + "\n" + "integer numbers ranging from 0 to 10000 is "+ duration + " milliseconds.\n\n");
				}
				atLeastOneChecked = true;
			}
			else if ( (cSort.isSelected()) && (visualize.isSelected()) ) {
				createWindow();
				runGraphic();
				atLeastOneChecked = true;
			}

			if (analyze.isSelected()) {
				createWindow();
				runGraphic();				
				atLeastOneChecked = true;
			}

		//Throwing the exception
		} catch (Exception e) {
			//If the list is not generated and the reset button is clicked, it will do nothing. 
			//If the list is generated randomlly, but no algorithm option is selected, show warning 
			if ((list.isEmpty()) && (running = true)) {} else {
			//Showing the warning message dialog
			JOptionPane.showMessageDialog(null, " Please select at least 1 sorting algorithm or all", "Uh-Oh", JOptionPane.WARNING_MESSAGE); 
			}
		}
		if (running == true) {
			messageSwitchOn = false;
		}
		else {
			messageSwitchOn = true;			
		}
		if (!atLeastOneChecked && (messageSwitchOn == true)) {
		// if (!atLeastOneChecked) {
			JOptionPane.showMessageDialog(null, " Please select at least 1 sorting algorithm or all", "Uh-Oh", JOptionPane.WARNING_MESSAGE);
		}
	    return list;
	}

//=========================================================================================================================================//
/* Visulization */
	public void createWindow() {
		//Create and set up the window for graphic.
		JDialog dialog = new JDialog();
		dialog.setTitle ("Sorting Algorithmx Graphics");
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// try { i.stop();} catch (Exception ex) {}
		// try { h.stop();} catch (Exception ex) {}
		// try { m.stop();} catch (Exception ex) {}
		// try { q.stop();} catch (Exception ex) {}
		// try { r.stop();} catch (Exception ex) {}
		// try { c.stop();} catch (Exception ex) {}

		dialog.add(graph);
		//Display the window.
		dialog.setSize(1000,800);
		dialog.pack();
		dialog.setVisible(true);
	}
	private void runGraphic() {
		if (iSort.isSelected() && visualize.isSelected()){
			InsertionSort();
		} else if (hSort.isSelected() && visualize.isSelected()){
			HeapSort();
		} else if (mSort.isSelected() && visualize.isSelected()){
			MergeSort();
		} else if (qSort.isSelected() && visualize.isSelected()){
			QuickSort();
		} else if (rSort.isSelected() && visualize.isSelected()){
			RadixSort();
		} else if (cSort.isSelected() && visualize.isSelected()){
			CountingSort();			
		} else if (analyze.isSelected()){
			insertionCompare();
			heapCompare();
			mergeCompare();
			quickCompare();
			radixCompare();
			countingCompare();
		}
	}

	private void InsertionSort() {
		i = new insertionSortGraph(375, graph, true, null);
		t = new Thread(i);
		t.start();
	}
	private void HeapSort() {
		h = new heapSortGraph(375, graph, true, null);
		t = new Thread(h);
		t.start();
	}
	private void MergeSort() {
		m = new mergeSortGraph(375, graph, true , null);
		t = new Thread(m);
		t.start();
	}
	private void QuickSort() {
		q = new quickSortGraph(375, graph, true, null);
		t = new Thread(q);
		t.start();
	}
	private void RadixSort() {
		r = new radixSortGraph(375, graph, true, null);
		t = new Thread(r);
		t.start();
	}	
	private void CountingSort() {
		c = new countingSortGraph(375, graph, true, null);
		t = new Thread(c);
		t.start();
	}	

	private void insertionCompare() {
		insertionStore = new ArrayList<arrayStore>();
		insertionSortGraph[] insertion = new insertionSortGraph[gPoints];
		Thread[] t = new Thread[gPoints];
		int j = 100;
		for (int i = 0; i < gPoints; i++){
			insertion[i] = new insertionSortGraph(j, graph, false, insertionStore);
			t[i] = new Thread(insertion[i]);
			t[i].start();
			try { TimeUnit.MILLISECONDS.sleep(20); } catch (Exception e) {}
			j = j + 100;
		}
		graph.drawIGraph(insertionStore);
	}

	private void heapCompare() {
		heapStore = new ArrayList<arrayStore>();
		heapSortGraph[] heap = new heapSortGraph[gPoints];
		Thread[] t = new Thread[gPoints];
		int j = 100;
		for (int i = 0; i < gPoints; i++){
			heap[i] = new heapSortGraph(j, graph, false, heapStore);
			t[i] = new Thread(heap[i]);
			t[i].start();
			try { TimeUnit.MILLISECONDS.sleep(20); } catch (Exception e) {}
			j = j + 100;
		}
		graph.drawHGraph(heapStore);
	}

	private void mergeCompare() {
		mergeStore = new ArrayList<arrayStore>();
		mergeSortGraph[] merge = new mergeSortGraph[gPoints];
		Thread[] t = new Thread[gPoints];
		int j = 100;
		for (int i = 0; i < gPoints; i++){
			merge[i] = new mergeSortGraph(j, graph, false, mergeStore);
			t[i] = new Thread(merge[i]);
			t[i].start();
			try { TimeUnit.MILLISECONDS.sleep(20); } catch (Exception e) {}
			j = j + 100;
		}
		graph.drawMGraph(mergeStore);
	}

	private void quickCompare() {
		quickStore = new ArrayList<arrayStore>();
		quickSortGraph[] quick = new quickSortGraph[gPoints];
		Thread[] t = new Thread[gPoints];
		int j = 100;
		for (int i = 0; i < gPoints; i++){
			quick[i] = new quickSortGraph(j, graph, false, quickStore);
			t[i] = new Thread(quick[i]);
			t[i].start();
			try { TimeUnit.MILLISECONDS.sleep(20); } catch (Exception e) {}
			j = j + 100;
		}
		graph.drawQGraph(quickStore);
	}

	private void radixCompare() {
		radixStore = new ArrayList<arrayStore>();
		radixSortGraph[] radix = new radixSortGraph[gPoints];
		Thread[] t = new Thread[gPoints];
		int j = 100;
		for (int i = 0; i < gPoints; i++){
			radix[i] = new radixSortGraph(j, graph, false, radixStore);
			t[i] = new Thread(radix[i]);
			t[i].start();
			try { TimeUnit.MILLISECONDS.sleep(20); } catch (Exception e) {}
			j = j + 100;
		}
		graph.drawRGraph(radixStore);
	}

	private void countingCompare() {
		countingStore = new ArrayList<arrayStore>();
		countingSortGraph[] counting = new countingSortGraph[gPoints];
		Thread[] t = new Thread[gPoints];
		int j = 100;
		for (int i = 0; i < gPoints; i++){
			counting[i] = new countingSortGraph(j, graph, false, countingStore);
			t[i] = new Thread(counting[i]);
			t[i].start();
			try { TimeUnit.MILLISECONDS.sleep(20); } catch (Exception e) {}
			j = j + 100;
		}
		graph.drawCGraph(countingStore);
	}		

//=========================================================================================================================================//


	//==================== Helper methods =================================//

	/*
	private void setCheckBoxesState() {
		ButtonGroup checkBoxes = new ButtonGroup();
		if ((visualize.isSelected()) || (!analyze.isSelected())) {
			checkBoxes.add(iSort);
			checkBoxes.add(mSort);
			checkBoxes.add(hSort);
			checkBoxes.add(qSort);
		}
		if (!visualize.isSelected() || (analyze.isSelected())) {
			checkBoxes.remove(iSort);
			checkBoxes.remove(mSort);
			checkBoxes.remove(hSort);
			checkBoxes.remove(qSort);
		} 
	}
	*/

	private void enableAll() {
		iSort.setEnabled(true);
		mSort.setEnabled(true);
		hSort.setEnabled(true);
		qSort.setEnabled(true);
		rSort.setEnabled(true);
		cSort.setEnabled(true);
	}
	private void disableAll() {
		iSort.setEnabled(false);
		mSort.setEnabled(false);
		hSort.setEnabled(false);
		qSort.setEnabled(false);
		rSort.setEnabled(false);
		cSort.setEnabled(false);		
	}
	private void checkAll() {
		iSort.setSelected(true);
		mSort.setSelected(true);
		hSort.setSelected(true);
		qSort.setSelected(true);
		rSort.setSelected(true);
		cSort.setSelected(true);		
	}
	private void uncheckAll() {
		iSort.setSelected(false);
		mSort.setSelected(false);
		hSort.setSelected(false);
		qSort.setSelected(false);
		rSort.setSelected(false);
		cSort.setSelected(false);		
	}
	private void resetHelper() {
		ButtonGroup checkBoxes = new ButtonGroup();
		visualize.setSelected(false);
		checkBoxes.remove(iSort);
		checkBoxes.remove(mSort);
		checkBoxes.remove(hSort);
		checkBoxes.remove(qSort);
		checkBoxes.remove(rSort);
		checkBoxes.remove(cSort);		
		analyze.setSelected(false);
		nums.setEnabled(true);
		generate.setEnabled(true);
		all.setEnabled(true);		
		enableAll();
		generate().clear();
		operate().clear();
		nums.setText("");
		uncheckAll();
	}
	//==================== End helper methods =================================//	

	//Implementing the reset() method
	public void reset() {
		running = true;
		int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?", "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (reply == JOptionPane.YES_OPTION) {
			resetHelper();
			if ((all.getText().toString().equalsIgnoreCase("Clear All")) && (running == true)) {
				all.setText("Select All");
			}
			TEXT_AREA_EAST.selectAll();
			TEXT_AREA_EAST.replaceSelection("");
			TEXT_AREA_WEST.selectAll();
			TEXT_AREA_WEST.replaceSelection("");
			System.out.print("\033[H\033[2J");  
			System.out.flush();
		} else {
 			return;
		}
		running = false;
	}
	
 	//Implementing the main() method
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Calling the display() method of the class menu
				new menu().display();
			}
		});
	}
}
