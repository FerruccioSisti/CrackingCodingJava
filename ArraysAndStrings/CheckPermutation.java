/**
* @author Ferruccio Sisti
* @since April 19, 2020
*
* Problem:
* Check Permutation: Given two strings,write a method to decide if one is a permutation of the other.
*/

import java.util.Arrays;

public class CheckPermutation
{
    public static void main (String args[])
    {
        String s1 = "test", s2 = "sett";

        System.out.println(isPermutation(s1, s2));
    }

    /**
    * @param s1 originial string we are comparing to
    * @param s2 new string which we are checking for permutation status
    * @return boolean value representing if s2 is a permutation of s1
    */
    public static Boolean isPermutation(String s1, String s2)
    {

        //First check to make sure that the strings are the same length
        //If they are different we already know they aren't permutations
        if (s1.length() != s2.length())
        {
            return false;
        }

        //Change each string into a charArray
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();

        //Now we sort both arrays for comparison
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //iterate through both sorted arrays and compare each character
        for (int i = 0; i < arr1.length; i++)
        {
            //if characters are not the same then its not a permutation
            if (arr1[i] != arr2[i])
            {
                return false;
            }
        }

        //if we finished the loop then we know everything matched and the strings are permutations
        return true;
    }
}
