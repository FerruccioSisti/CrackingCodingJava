/**
* @author Ferruccio Sisti
* @since April 21, 2020
* Problem:
* One Away: There are three types of edits that can be performed on strings:
* insert a character, remove a character, or replace a character.
* Given two strings, write a function to check if they are one edit (or zero edits) away.
*/

import java.util.*;

public class OneAway
{
    public static void main(String args[])
    {
        //test
        System.out.println(CheckOneAway("tryu", "true"));
    }

    /**
    * @param s1 the first string for comparison
    * @param s2 the second string for comparison
    * @return Boolean value representing if one or less edits are required to make the strings the same
    */
    public static Boolean CheckOneAway(String s1, String s2)
    {
        int smallSize, editCount = 0;
        String smallString, bigString;
        Boolean equal = false;
        ArrayList<Character> s1list = new ArrayList<Character>();
        ArrayList<Character> s2list = new ArrayList<Character>();

        //first check if they are the same string (need 0 edits)
        if (s1.equals(s2))
        {
            return true;
        }

        //Now we should check to see if there is a possibility of the strings being more than one edit away
        if (s1.length() > s2.length() + 1 || s1.length() < s2.length() - 1)
        {
            //if a bigger difference than 1 in length then there needs to be more than 1 edit
            return false;
        }

        //Create both lists (with contents from respective strings)
        for (char c : s1.toCharArray())
        {
            s1list.add(c);
        }
        for (char c : s2.toCharArray())
        {
            s2list.add(c);
        }

        //Find smallest size for exiting the loop
        if (s1.length() < s2.length())
        {
            smallSize = s1.length();
        }
        else if (s1.length() > s2.length())
        {
            smallSize = s2.length();
        }
        else
        {
            //doesnt matter because they are the same size
            smallSize = s1.length();
            equal = true;
        }

        //remove current character from each list, if one does not have the other
        //then increment editCount
        for (int i = 0; i < smallSize; i++)
        {

            System.out.println(s1list + "\n" + s2list);
            //compare each character to see if an edit is required
            if (s1list.get(i) != s2list.get(i))
            {
                if (smallSize == s1.length() && !equal)
                {
                    //insert the element and continue
                    s1list.add(i, s2list.get(i));
                    editCount++;
                }
                else if (smallSize == s2.length() && !equal)
                {
                    //insert edit
                    s2list.add(i, s1list.get(i));
                    editCount++;
                }
                else
                {
                    //replace the character in one list
                    s1list.remove(i);
                    s1list.add(i, s2list.get(i));
                    editCount++;
                }
            }

            if (editCount > 1)
            {
                return false;
            }
        }

        return true;
    }
}
