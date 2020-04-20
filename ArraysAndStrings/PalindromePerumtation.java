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
        System.out.println(hasPalindromePermutation("kukaa"));
    }

    /**
    * Method uses isPalindrome method on all possible permutations to see if a given
    *       string has a possible palindrome permutation
    * @param s the string we are checking for palindrome permutations of
    * @return boolean value regarding if the string has a possible permutation palindrome or not
    */
    public static Boolean hasPalindromePermutation(String s)
    {
        //first check the initial string in order to avoid doing unnecessary stuff
        if (isPalindrome(s))
        {
            return true;
        }

        char temp;
        //Make a list to store the already tested permutations
        ArrayList<String> tested = new ArrayList<String>();
        //original string is already tested
        tested.add(s);
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

        //convert current char arraylist to a string to store in tested arraylist
        String test = arr.toString().substring(1, 3*arr.size()-1).replaceAll(", ", "");
        tested.add(test);

        //swap one character with another and check, if false swap back and try again with next index
        for (int i = 0; i < arr.size(); i++)
        {
            for (int j = 0; j < arr.size(); j++)
            {
                //if the elements are the same then we don't need to waste time testing
                if (i == j)
                {
                    continue;
                }

                //Swap i index with current j index and then check if palindrome
                temp = arr.get(j);
                //set element i at index j
                arr.set(j, arr.get(i));
                //set element j at index i
                arr.set(i, temp);
                test = arr.toString().substring(1, 3*arr.size()-1).replaceAll(", ", "");
                System.out.println(test);
                //check to make sure we haven't tested already
                if (!arr.contains(test))
                {
                    //if the one we test is a palindrome then return true for current program execution
                    if (isPalindrome(test))
                    {
                        return true;
                    }
                    else //if not a palindrome, add tested string to the list of tested strings
                    {
                        tested.add(test);
                        //reset the array so we can try another permutation of the string
                        temp = arr.get(j);
                        arr.set(j, arr.get(i));
                        arr.set(i, temp);
                    }
                }
            }
        }

        return false;
    }

    /**
    * Method checks if a string is a palindrome or not
    * @param s the string we are checking the palindrome status of
    * @return boolean value regarding if the string is a palindrome or not
    */
    public static Boolean isPalindrome(String s)
    {
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

        for (int i = 0, j = arr.size() - 1; i < j; i++, j--)
        {
            //if the two opposite indexed elements aren't the same character then
            //its not a palindrome
            if (arr.get(i) != arr.get(j))
            {
                return false;
            }
        }

        return true;
    }
}
