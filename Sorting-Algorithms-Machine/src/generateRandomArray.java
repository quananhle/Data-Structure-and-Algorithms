package introAlgorithms;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

//Calling the library java.util to initialize ArrayList
//The reason to use ArrayList instead of Array is to only hold object values. 
//The size of the array after it is constructed can not be changed. 
//The number of elements in an ArrayList can be updated after it is constructed.
import java.util.ArrayList;
//Calling the library util to use method java.util.Random class
import java.util.Random;

public class generateRandomArray {
	//Implementing the method 'generate' that takes an integer number 'n' as an argument and return an ArrayList of integer numbers
	protected static ArrayList<Integer> generate(int n){
		//Initializing an ArrayList of integer numbers 'list' with the size of 'n'
	    ArrayList<Integer> list = new ArrayList<Integer>(n);
	    //Creating the object random of the Random() method
	    Random random = new Random();
	    //Using for loop to run 'n' times
	    for (int i = 0; i < n; i++)
	    {	
	    	//Using method add() to append the number to ArrayList datatype 'list'
	    	//random.nextInt(1000) generates a random number from the range 0 to 1000
	        list.add(random.nextInt(1000));
	    }
	return list;
	}  
}