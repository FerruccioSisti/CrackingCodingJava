/**
* @author Ferruccio Sisti
* @since April 19, 2020
* Problem:
* Is Unique: Implement an algorithm to determine if a string has all unique characters.
* What if you cannot use additional data structures?
*/

import java.util.ArrayList;

public class IsUnique
{

    public static void main(String args[])
    {
        //Test to make sure it works
        String s = "test", s1 = "asd";

        System.out.println(checkString(s) + "\n" + checkString(s1));
    }

    /** Method that checks if a string is entirely unique
    * @param s the string that we are confirming uniqueness of
    * @return boolean value representing if the string is unique or not
    */
    public static Boolean checkString(String s)
    {
        //Create an arraylist to store the characters we have already encountered
        //ArrayList needs boxed data types (not primitive like char, int, etc)
        ArrayList<Character> charHolder = new ArrayList<Character>();

        //Check each character in the string
        for (int i = 0; i < s.length(); i++)
        {
            //check if we have already encountered that character
            if (charHolder.contains(s.charAt(i)))
            {
                //if character is already in list then the string is not unique
                return false;
            }
            else //if the character is not currently in the arraylist then add it
            {
                charHolder.add(s.charAt(i));
            }
        }
        //if the method is still continued to this point then the string is unique
        return true;
    }
}
