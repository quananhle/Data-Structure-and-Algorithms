package introAlgorithms;

/**
=================================================
 *
 * @author Quan Le
 *
 =================================================
 **/

public class arrayStore {
	
	int arraySize;
	long sortTime;

	arrayStore(int size, long time){
		this.arraySize = size;
		this.sortTime = time;
	}

	public void print(){
		System.out.println(this.arraySize + " and " + this.sortTime);
	}

}
