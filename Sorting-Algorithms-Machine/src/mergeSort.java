package introAlgorithms;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

import java.util.ArrayList;
/* MergeSort(ArrayList[], left,  right)

If right > left

	1. Find the middle point to divide the ArrayList into two halves:  
 				middle = (left+right)/2
  	2. Call mergeSort for first half:   
          	Call mergeSort(ArrayList, left, middle)
  	3. Call mergeSort for second half:
             	Call mergeSort(ArrayList, middle+1, right)
  	4. Merge the two halves sorted in step 2 and 3:
             	Call merge(ArrayList, left, middle, right)
*/
public class mergeSort {
	// Call a public static method mergeSort() that takes an argument as the ArrayList of integers data type and return an ArrayList of integer data type.
	// The method can be used in the different class.
	protected static ArrayList<Integer> mergeSort(ArrayList<Integer> list){
		// Call the method sort() that takes an argument as the ArrayList of integer. 
		// Return the data type returned from sort()
		return sort(list);
	}
	// Call a static method sort() that takes an argument as the ArrayList of integers data type and return an ArrayList of integer data type 
	private static ArrayList<Integer> sort(ArrayList<Integer> list){
		//Find the middle point
		int middle;
		//Create a new ArrayList of integer number 'Left'
		ArrayList<Integer> Left = new ArrayList<>();
		//Create a new ArrayList of integer number 'Right'
		ArrayList<Integer> Right = new ArrayList<>();
		//Check if the size of the ArrayList 'list' is larger than 1 element ArrayList
		if (list.size() > 1) {
			//Find the middle point of the array list 'list'
			middle = list.size() / 2;
			//Run the for loop from index 0 to the middle
			for (int i = 0; i < middle; i++) {
				//Copy all the elements of ArrayList 'list' into a new ArrayList 'Left'
				Left.add(list.get(i));
			}
			//Run the for loop from middle index toward the end of the array list 'A'
			for (int j = middle; j < list.size(); j++) {
				//Copy all the elements of ArrayList 'A' into a new ArrayList 'Right'
				Right.add(list.get(j));
			}
			//Call the method sort that take the ArrayList 'Left' to recursively break down the ArrayList 'Left'
			sort(Left);
			//Call the method sort that take the ArrayList 'Right' to recursively break down the ArrayList 'Right'
			sort(Right);
			//Call the method merge() to merge all the ArrayLists after they were sorted
			list = merge(list, Left, Right);
		}
		return list;
	}
	private static ArrayList<Integer> merge(ArrayList<Integer> list, ArrayList<Integer> Left, ArrayList<Integer> Right){
		//initialize an ArrayList to build the merge list
		ArrayList<Integer> dup = new ArrayList<>(); 

		int num = 0;    
		int low = 0;
		int high = 0;
		//Run the while loop so long as low is smaller than the size of the ArrayList 'Left' and high is smaller the size of the ArrayList 'Right' 
		while (low < Left.size() && high < Right.size()) {
			//Check if the index 'low' of the ArrayList 'Left' is smaller than the index 'high' of the ArrayList 'Right'
			//'low' and 'high' iterate from 0
			if (Left.get(low) < Right.get(high) ) {
				//Set the 'low' index of ArrayList 'Left' to the 'num' index of the ArrayList 'A'
				list.set(num, Left.get(low));
				//Keep iterating 'low' so long as the condition is met
				low++;
			} else {
				//Otherwise, set the 'high' index of ArrayList 'Right' to the 'num' index of the ArrayList 'A'
				list.set(num, Right.get(high));
				//Keep iterating 'high' so long as the condition is met
				high++;
			}
			//Iterating num until the condition of while loop is satisfied
			num++;
		}
   
		int tmp = 0;
		//Check if the size of the ArrayList 'Left' is higher than 'low'
		if (low >= Left.size()) {
			//Copy the ArrayList 'Right' into the ArrayList 'list'
			dup = Right;
			//Copy 'high' into 'tmp'
			tmp = high;
		} 
		else {
			//Otherwise, copy the ArrayList 'Left' into the ArrayList 'list' 
			dup = Left;
			//Copy 'low' into 'tmp'
			tmp = low;
		}
		//Run the for loop so long as i = tmp is smaller than the size of the ArrayList 'list' and keep iterating until i is no longer smaller than  the size of the ArrayList 'list'		
		for (int i = tmp; i < dup.size(); i++) {
			//Merge the index 'i' of the ArrayList into the 'num' index of ArrayList 'A'
			list.set(num, dup.get(i));
			//Keep iterating num
			num++;
		}
		return list;
	}
	/*public static void sort (ArrayList<Integer> A, int low, int high) {
		//Check if the left index smaller than the its right
		if (low < high) {
			//Find the middle point
			int middle = (low + high) / 2;
			//Divide the ArrayList into two smaller sub-ArrayLists until the left is no longer smaller or equal to the right
			//The first sub-ArrayList has all the indices from the leftmost index of the ArrayList 'A' to the the middle index of the ArrayList 'A'
			//The second sub-ArrayList has the rest, from 'middle + 1' index to the rightmost index of the ArrayList 'A'
			sort (A, low, middle);	//Call the method sort() to sort the first ArrayList
			sort (A, middle + 1, high);  //Call the method sort() to sort the second ArrayList
			merge (A, low, middle, high); //Call the method merge() to merge all the ArrayLists after they were sorted
			//merge (low, middle, high);
		}
	}
	public static void merge (ArrayList<Integer> A, int low, int middle, int high) {
		//public static void merge (int low, int middle, int high) {
		//Pass the size of the first ArrayList into an int data type variable size1
		int size1  = middle - low + 1; //E.g: If the ArrayList has 5 indices, the middle is 2, the left is 0, hence the size of the first sub-ArrayList is 3
		//Pass the size of the second ArrayList into an int data type variable size2
		int size2  = high - middle; //E.g: If the ArrayList has 5 indices, the middle is 2, the right is 4, hence the size of the second sub-ArrayList is 2
		//Create a new ArrayList of integer number called Left which has the size of the first ArrayList
		ArrayList<Integer>Left  = new ArrayList<>(size1);
		//Create a new ArrayList of integer number called Right which has the size of the second ArrayList
		ArrayList<Integer>Right = new ArrayList<>(size2);
		int i, j, k;
		//Call a for loop that increments by count of 1 starting from 0 until it reaches the value of size1 
		for (i = 0; i < size1; ++i) {
			//Update the values of ArrayList Left with the values of ArrayList 'A' starting from index 0
			Left.set(i, A.get(low + i));
		}
		//Call a for loop that increments by count of 1 starting from 0 until it reaches the value of size2
		for (j = 0; j < size2; ++j) {
			//Update the values of ArrayList Right with the values of ArrayList 'A' starting from index 'middle + 1'
			Right.set(j, A.get(middle + 1 + j));
		}
		i = 0; j = 0; k = low;
		//Call a while loop that runs over and over again starting from 0 until it reaches both the value of size1 and size2 simultaneously
		while (i < size1 && j < size2) {
			//Check if the value of the ArrayList Left at the index 'i' is smaller than or equal to the value of the ArrayList Right at the index 'j'
			if (Left.get(i) <= Right.get(j)) {
				//Pass the value of the index 'i' of the ArrayList Left to the index 'k' of the ArrayList 'A'
				A.set(k, Left.get(i));
				//Increment 'i' by count of 1
				i++;
			} //Check if the value of the Right ArrayList at the index 'j' is higher than the value of at the index 'k' of the ArrayList A
			else {
				//Pass the value of the index 'j' of the ArrayList Right to the index 'k' of the ArrayList 'A'
				A.set(k, Right.get(j));
				//Increment 'j' by count of 1
				j++;
			}
			//Increment 'k' by count of 1
			k++;
		}
 		//Call a while loop that runs over and over again starting from 0 until it reaches both the value of size1
		while (i < size1) {
		
			//Pass the value of the index 'i' of the ArrayList Left to the index 'k' of the ArrayList 'A'
			A.set(k, Left.get(i));
			//Increment 'i' and 'k' until the end of the ArrayList 'A' and ArrayList 'Left'
			i++;
			k++;
		}
 		//Call a while loop that runs over and over again starting from 0 until it reaches both the value of size2
		while (j < size2) {
			//Pass the value of the index 'j' of the ArrayList Right to the index 'k' of the ArrayList 'A'
			A.set(k, Right.get(j));
			//Increment 'i' and 'k' until the end of the ArrayList 'A' and ArrayList 'Left'
			j++;
			k++;
		}
	}*/
	// public static void main(String args[]) { 
	// 	ArrayList<Integer> list = new ArrayList<Integer>();
	//     list.add(30);
	//     list.add(10);
	//     list.add(16);
	//     list.add(17);
	//     list.add(19);
	//     list.add(50);
	//     list.add(70);
	//     list.add(86);
	//     list.add(7);
	// 	System.out.println(list);
	// 	mergeSort(list);
	// 	System.out.println(list);
 //    }	
}