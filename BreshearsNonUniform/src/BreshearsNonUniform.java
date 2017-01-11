import java.util.*;
import java.math.*;
/* there will be 12 tests total
 * 3 differnt algorithims for 2 different array sizes for 2 differnt sorts
 * 6 arrays total
 */
public class BreshearsNonUniform {
	public static void main(String args[]){
		// creating the arrays
		int array1_2048 [] = new int[2048]; // this array will be populated with 1's and 0's 
		int array2_2048 [] = new int[2048];
		int array3_2048 [] = new int[2048];
		
		int array1_4096 [] = new int[4096];
		int array2_4096 [] = new int[4096];
		int array3_4096 [] = new int[4096];
		
		// populating the arrays
		array1_2048 = populate1(array1_2048);
		array1_4096 = populate1(array1_4096);
		
		array2_2048 = populate2(array2_2048);
		array2_4096 = populate2(array2_4096);
		
		array3_2048 = populate3(array3_2048);
		array3_4096 = populate3(array3_4096);
		
		// shuffling the arrays
		array1_2048 = shuffle(array1_2048);
		array1_4096 = shuffle(array1_4096);
		
		array2_2048 = shuffle(array2_2048);
		array2_4096 = shuffle(array2_4096);
		
		array3_2048 = shuffle(array3_2048);
		array3_4096 = shuffle(array3_4096);
		
		// doing the sorting 12 Total
		array1_2048 = insertionSort(array1_2048); // I think this will be 0(n) because it grows linearlly
		System.out.println(" using half the data 0/1");
		array1_2048 = selectionSort(array1_2048);// I think this will also be 0(n) as well
		System.out.println(" using half the data 0/1");
		
		array1_4096 = insertionSort(array1_4096);// I think this will be 0(n) because it grows linearlly
		System.out.println(" using half the data 0/1");
		array1_4096 = selectionSort(array1_4096);// I think this will be 0(n) because it grows linearlly
		System.out.println(" using half the data 0/1");
		
		array2_2048 = insertionSort(array2_2048); // I think this will be 0(n^2) because it keeps halving 
		System.out.println(" using half the data 0/1/2...");
		array2_2048 = selectionSort(array2_2048);// I think this will be 0(n^2) because it keeps halving  as well
		System.out.println(" using half the data 0/1/2...");
		
		array2_4096 = insertionSort(array2_4096);// I think this will be 0(n^2) because it keeps halving 
		System.out.println(" using half the data 0/1/2...");
		array2_4096 = selectionSort(array2_4096);// I think this will be 0(n^2) because it keeps halving 
		System.out.println(" using half the data 0/1/2...");
		
		array3_2048 = insertionSort(array3_2048);// I think this will be 0(n^3) because of the way it grows
		System.out.println(" using half the data 0/Random");
		array3_2048 = selectionSort(array3_2048);// I think this will be 0(n^3) because of the way it grows
		System.out.println(" using half the data 0/Random");
		
		array3_4096 = insertionSort(array3_4096);// I think this will be 0(n^3) because of the way it grows
		System.out.println(" using half the data 0/Random");
		array3_4096 = selectionSort(array3_4096);// I think this will be 0(n^3) because of the way it grows
		System.out.println(" using half the data 0/Random");
		
		
	}
	
	//this will populate the array half 0's half 1's
	public static int[] populate1(int array[]){
		for (int i = 0; i <  (array.length)/2 ; i++){
			array[i] = 0;
		}
		for (int i = (array.length/2) ; i < (array.length)-1; i++){
			array[i]= 1;
		}
		return array;
	}
	
	//this will populate the array half 0's remainer 1's ramainer 2's and so on
	public static int[] populate2(int array[]){
		int l = 0;
		int i = 0;
		int length = array.length;
		while (i < array.length){
			for (int k = length; k > (length/2); k--){
				array [i] = l;
				i ++;
			}
			length = length/2;
			l++;
			
		}
		return array;
	}
	
	//this will populate the array half 0's half random numbers between 0 and 9;
	public static int[] populate3(int array[]){
		Random randomNumber = new Random();
		for (int i = 0; i <  (array.length)/2 ; i++){
			array[i] = 0;
		}
		for (int i = (array.length/2) ; i < (array.length)-1; i++){
			array[i]= randomNumber.nextInt(9);
		}
		
		return array;
	}
	
	public static int[] shuffle(int[] array) {
		int n = array.length;
		for (int i = 0; i < array.length; i++) {
		    
		    int random = i + (int) (Math.random() * (n - i));// Get a random index of the array past i.
		    int randomElement = array[random];// Swap the random element with the present element.
		    array[random] = array[i];
		    array[i] = randomElement;
			}
		return array;
	    }
	
	public static int[] insertionSort(int[] array){
        Stopwatch stopwatch = new Stopwatch();
        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                	}
            	}
        	}
        double time = stopwatch.elapsedTime();
        System.out.print(time + " Insertion Sort" + " for array length " + array.length);
        return array;

}
	public static int [] selectionSort (int[] array)
	{
		Stopwatch stopwatch = new Stopwatch();
	     int index; 
	     for (int i = 0; i < array.length - 1; i++)
	        {
	           index = i;
	            for (int j = i + 1; j < array.length; j++)
	                if (array[j] < array[index])
	                    index = j;
	      
	            int smallNum = array[index]; 
	            array[index] = array[i];
	            array[i] = smallNum;
	      } 
	     double time = stopwatch.elapsedTime();
	     System.out.print(time +" Selection Sort" + " for array length " + array.length);
	     return array;
	}
}


class Stopwatch { 

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    } 

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
