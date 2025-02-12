import java.util.Random;
import java.util.Arrays;

public class BubbleSort
{
	public static void main(String[] args) {
		//Generates array of random numbers and sets length as variable
		int randArray[] = makeRandomArray();
		int randLength = randArray.length;
		
		//Performs bubble sort on the array
		sortArray(randArray, randLength);
		
		//Prints sorted array
		System.out.println("Sorted Array:");
		System.out.println(Arrays.toString(randArray));
	}
	
	public static int[] makeRandomArray() {
	    Random rand = new Random();
	    int n = 25;
	    int[] arr = new int[n];
	    
	    //Generates random set of 25 numbers from 1 to 1000 and puts it into the array
	    for (int i = 0; i < n; i++) {
	        arr[i] = (rand.nextInt(1000) + 1);
	    }
	    
	    //Prints unsorted array
	    System.out.println("Unsorted Array:");
	    System.out.println(Arrays.toString(arr));
	    System.out.println();
	    
	    return arr;
	}
	
	public static void sortArray (int[] array, int len) {
	    int i, j, temp;
	    boolean numSwap;
	    
	    for (i = 0; i < len - 1; i++) {
	        numSwap = false;
	        for (j = 0; j < len - i - 1; j++) {
	            if (array[j] > array[j + 1]) {
	                //If array[j] is bigger than array[j + 1], swap
	                temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	                numSwap = true;
	            }
	        }
	        
	        //End sorting if numbers were not swapped
	        if (numSwap == false)
	            break;
	    }
	}
}