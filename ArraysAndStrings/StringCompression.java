/**
* @author Ferruccio Sisti
* @since April 22, 2020
* Problem:
* String Compression: Implement a method to perform basic string compression
* using the counts of repeated characters. For example, the string aabcccccaaa
* would become a2blc5a3. If the "compressed" string would not become smaller
* than the original string, your method should return the original string.
* You can assume the string has only uppercase and lowercase letters (a - z).
*/

import java.util.*;

public class StringCompression
{
    public static void main(String args[])
    {
        //test the method
        System.out.println(strCompressor("aabcccccaaa"));
    }

    /**
    * @param s the string we are compressing
    * @return either the compressed string with a number representing the sequential character count OR the original string (if compression is bigger)
    */
    public static String strCompressor(String s)
    {
        //turn the string into a character array so we can iterate through it
        char[] ch = s.toCharArray();
        //make an arraylist of characters for the new string
        ArrayList<Character> arr = new ArrayList<Character>();
        int count = 1;

        //iterate through the character array
        for (int i = 1; i < ch.length; i++)
        {
            //if the current character is the same as the previous one increment counter
            if (ch[i] != ch[i - 1] || i == ch.length - 1)
            {
                //special check for last member of string
                if (ch[i] == ch[i - 1] && i == ch.length - 1)
                {
                    count++;
                }

                arr.add(ch[i - 1]);
                arr.add((char)(count+'0'));
                //reset the counter
                count = 1;
            }
            else
            {
                //increment counter because sequential characters are the same
                count++;
            }
        }

        //Change the arrayList  to a string
        StringBuilder sb = new StringBuilder();
        for (char c : arr)
        {
            sb.append(c);
        }
        String ret = sb.toString();

        //if new string is not smaller than original then return original
        if (ret.length() >= s.length())
        {
            return s;
        }
        else
        {
            return ret;
        }
    }
}
