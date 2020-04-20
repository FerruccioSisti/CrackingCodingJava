/**
* @author Ferruccio Sisti
* @since April 20, 2020
* Problem:
* URLify: Write a method to replace all spaces in a string with '%20'. You may
* assume that the string has sufficient space at the end to hold the additional
* characters,and that you are given the "true" length of the string.
* (Note: If implementing in Java,please use a character array so that you can
*           perform this operation in place.)
* EXAMPLE
* Input: "Mr John Smith     ", 13 Output: "Mr%20John%20Smith"
*/

import java.util.*;

public class URLify
{

    public static void main(String args[])
    {
        //Test the method
        System.out.println(urlChange("Mr John Smith     ", 13));
    }

    /**
    * Method replaces all occurances of a space in a string to '%20'
    * @param s The string we are editing
    * @param size the 'true' size of the string not including the extra spacing at the end
    * @return an updated string with '%20' where any spaces previously were
    */
    public static String urlChange(String s, int size)
    {
        //instead of using a char array, we could just use the replace method on the string
        char[] arr = s.toCharArray();
        System.out.println(arr);

        //Loop through the char array to replace any occurances of a space with '%20'
        //Because of all the extra space at the end we can just use the 'true' size of the string
        //For our loop counter
        for (int i = 0; i < size; i++)
        {
            if (arr[i] == ' ')
            {
                //need to move everything 2 spaces to the right so we have room to replace the space
                restructArr(arr, i, size);
                //Need to increase size because our array just got bigger (for usage with restructArr)
                size += 2;
                arr[i] = '%';
                arr[i + 1] = '2';
                arr[i + 2] = '0';
                i +=2;
            }
        }

        //Change the charArray back to a string
        String ret = new String(arr);
        return ret;
    }

    /**
    * Method shifts everything after the space found in the urlChange method 2 index's to the right
    * @param arr the array we are editing
    * @param i the index we want to start the shift after (everything from the next index onwards will be shifted)
    * @param size the true size of the string (does not include all the extra space after the last character)
    * @return the shifted array
    */
    public static char[] restructArr(char[] arr, int i, int size)
    {
        //start at the end of the string (before all the extra spaces) and shift everything
        //2 index's to the right
        for (int j = size; j > i; j--)
        {
            arr[j + 2] = arr[j];

        }

        return arr;
    }
}
