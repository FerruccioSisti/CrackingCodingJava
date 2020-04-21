/**
* @author Ferruccio Sisti
* @since April 20, 2020
* Problem:
* Palindrome Permutation: Given a string, write a function to check if it is a permutation of a
* palin­drome. A palindrome is a word or phrase that is the same forwards and backwards.
* A permutation is a rearrangement of letters. The palindrome does not need to be limited to
* just dictionary words.
* EXAMPLE
* Input: Tact Coa
* Output: True (permutations: "taco cat", "atco eta", etc.)
*/

import java.util.*;

public class PalindromePerumtation
{

    public static void main(String args[])
    {
        //test the method
        System.out.println(isPalindromePermutation("abcadbc"));
    }

    /**
    * Method attempts to remove all characters from a string (or all but 1 if length is odd)
    * in order to see if the string has a possible palindrome permutation
    * characters are removed in pairs because of the nature of a palindrome
    * @param s the string we are checking for palindrome permutations of
    * @return boolean value regarding if the string has a possible permutation palindrome or not
    */
    public static Boolean isPalindromePermutation(String s)
    {
        char temp;
        //Convert string to arraylist so we can iterate through and check for palindrome status
        ArrayList<Character> arr = new ArrayList<Character>();
        //Add all the elements to our new char arraylist
        //ignore spaces since we are ignoring them when confirming palindrome status (see example)
        for (char c : s.toCharArray())
        {
            if (c != ' ')
            {
                arr.add(c);
            }
        }

        Boolean arrEven;

        //Check if the string is even or odd
        if (arr.size() % 2 == 0)
        {
            arrEven = true;
        }
        else
        {
            arrEven = false;
        }

        //Iterate through the list and remove the current element as well as one additional version of it
        for (int i = 0; i < arr.size(); i++)
        {
            temp = arr.get(i);
            //remove the occurrance of that character
            arr.remove(new Character(temp));
            //if something was not removed the second time then only 1 character exists of that type
            if (!arr.contains(temp))
            {
                //readd that character in order to check at the end for size
                arr.add(0, temp);
            }
            else
            {
                arr.remove(new Character(temp));
                //if we remove an element we have to decrement the index to avoid the index incrementing
                //if we don't do this then characters in the string will be skipped
                i--;
            }
        }

        //if the string was an odd length and there is only 1 character left then it has a palindrome permutation
        if (!arrEven && arr.size() == 1)
        {
            return true;
        }
        else if (arrEven && arr.size() == 0)
        {
            //if the string size was even and there are no elements left then it has a palindrome permutation
            return true;
        }
        else
        {
            return false;
        }
    }
}
