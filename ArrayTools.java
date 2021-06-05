/*
    Naval Sharma
    A00241484


		This program has certain array tools like -

		1. Ecryption/Decryption by ceaser cipher.
		2. average of an int array
		3. search an element in tha int ArrayTools
		4. Reversee the int array

*/


import java.util.*;
import java.lang. *;

public class ArrayTools
{
	public static void main(String[] args) {

    // get the input string from the user to encrypt
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a String to encrypt");
    String inputVal = sc.next();


    // get the shift value from the user..
    System.out.println("Enter the shift value");
    int shiftValue = sc.nextInt();
    String result = encrypt(inputVal, shiftValue);
    System.out.println("the ecrypted string is " + result);

    // decrypt the string with the same shift value and show results.
    String decryptStr = decrypt(result, shiftValue);
    System.out.println("The decrypted string is " + decryptStr);

    // get the length of the int array to perform functions on..
    int size = 0;
    System.out.println("Enter the length of the numeric array");
    size = sc.nextInt();
    int[] nums = new int[size];
    System.out.println("Enter the integer array to get the average vaulue");
    for(int i=0;i<size;++i){
      nums[i] = sc.nextInt();
    }

    // call function to get average of the int array items..
    double average = avgArray(nums);
    System.out.println("The average integer from the array is" + average);

    // get the item to search from the array from the user..
    System.out.println("Enter the value to search in the array");
    int searchTerm = sc.nextInt();


    // call funvtion to figure out if the array contains the value.
    boolean contains = arrayContains(nums, searchTerm);
    if(contains){
      System.out.println("The Array contains " + searchTerm);
    } else
      {
      System.out.println("The value was not present in the array");
    }

    // call function to reverse the array items and then print the values.
    int[] reversedArray = reverseArray(nums);
    System.out.println("The reversedArray is " + Arrays.toString(reversedArray));

  }



  public static String encrypt(String input, int shiftValue){
      char[] newStr = new char[input.length()];

			// shititng the characrers by the shiftvalue and adjusting the value
			// if it goes beyond 'z'
      for(int i =0;i<input.length(); ++i){
          char newCharValue = (char)(input.charAt(i) + shiftValue);
          if(newCharValue >'z'){
            newStr[i] = (char)(input.charAt(i) - (26 - shiftValue));
          }
          else{
          newStr[i] = (char)(input.charAt(i) + shiftValue);
          }
      }
      return new String(newStr);

  }

  public static String decrypt(String input, int shiftValue){
    char[] newStr = new char[input.length()];

		// decrypting the string with the same shiftvalue ..
    for(int i =0;i<input.length(); ++i){
        char newCharValue = (char)(input.charAt(i) - shiftValue);
        if(newCharValue < 'a'){
          newStr[i] = (char)(input.charAt(i) + (26 - shiftValue));
        }
        else{
        newStr[i] = (char)(input.charAt(i) - shiftValue);
        }
    }
    return new String(newStr);
  }

  public static double avgArray(int[] nums){

		// calculate the average of the int array elements..
    double avg = 0;
    double sum = 0.0;
    double size = nums.length;
      for (int i = 0;i < nums.length;++i) {
          sum = sum + nums[i];
      }

			// adding the int array vlues and divinding by size to the average..
      avg = sum/size;
      return avg;
  }

  public static boolean arrayContains(int[] nums, int searchValue){

		// search the value in the array an return the appropriate boolean
    for(int i=0;i<nums.length;++i){
      if(nums[i] == searchValue){
        return true;
      }

    }
    return false;
  }

  public static int[] reverseArray(int[] nums){
      int len = nums.length;

      // iterating till half of the array and replacing the values from index
      // 0 with last index and so on..
      for(int i=0;i<len/2; ++i){
        int tmp = nums[i];
        nums[i] = nums[len - i -1];
        nums[len - i -1]= tmp;

      }
      return nums;
    }
  }
