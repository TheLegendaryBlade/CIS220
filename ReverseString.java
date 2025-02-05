//Colton Owen
//Chpt 2 PA

import java.util.Scanner;

public class ReverseString {

   public static String reverseString(String input) {
	   if ((input == null) || (input.length() <= 1)) {              //checks if there is more text to reverse
		   return input;                                            //if one or less, display the text
	   }
	   return reverseString(input.substring(1)) + input.charAt(0);  //cut first letter of text out of string and put it on the right
   }
   
   
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input, result;
		
		System.out.print("Enter the string to be reversed: ");
		input = scnr.nextLine();
		
		result = reverseString(input);
		
		System.out.printf("Reversed: %s\n", result);
	}
}