package introAlgorithms;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

import java.util.ArrayList;

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
public class insertionSort {
	//Create a static method called insertionSort associated with the class insertionSort() 
		//so that the method can be called without the need of an object.
	//The method insertionSort takes the parameter of an array of integer numbers and returns nothing 
	protected static ArrayList<Integer> insertionSort(ArrayList<Integer> A) {
		//Call a for loop that increments by count of 1 starting from the beginning until the end of the array of integer numbers 
		for (int i = 1; i < A.size(); ++i) {
			//Pass the value of the integer number at index 'i' of the array 'A' into the int data type variable 'key'
			Integer key = A.get(i);
			//Initialize an int data type variable 'j' that equals 'i - 1' 
			int j = i - 1;
			//Call a while loop that runs over and over again as long as 'j >= 0' 
			//and compare the value of the integer number at index j of the array 'A' if it is higher than the value of the variable 'key'
			while (j >= 0 && A.get(j) > key) {
				//Update the value at the index 'j+1' of the array 'A' with the value at the index 'j' 
				//or moving the element at the left side to one position forward
				A.set(j + 1, A.get(j));
				//Update 'j' to 'j-1'
				j--;
			}
			//Update the value of key to the index 'j+1' of the array 'A'
			//or moving the current element to its correct position
			A.set(j+1,key);
		}
		return A;
	}
	/* public static void main(String args[]) 
    { 
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(8);
		list.add(6);
		list.add(9);
		System.out.println(list);
		insertionSort(list);
		System.out.println(list);
    } */
}
