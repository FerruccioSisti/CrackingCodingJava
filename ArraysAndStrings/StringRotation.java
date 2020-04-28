/**
* @author Ferruccio Sisti
* @since April 28, 2020
* Problem:
* String Rotation: Assume you have a method isSubstring which checks if one word is
* a substring of another. Given two strings, sl and s2, write code to check if s2
* is a rotation of sl using only one call to isSubstring (e.g.,"waterbottle" is a
* rotation of"erbottlewat").
*/

public class StringRotation
{
    public static void main(String args[])
    {
        //test the method
        String s1 = "waterbottle", s2 = "erbottlewat";
        System.out.println(isRotation(s1, s2));
    }

    public static Boolean isRotation(String s1, String s2)
    {
        //concatenate one string to itself, and then the original string should be in there
        //aka it should be a substring that can be checked
        //ex. erbottlewaterbottlewat is the concat of s2 to itself and contains s1
        
        String strcat = s2;
        //This string should contain the original word, if there is a possible rotation
        strcat = strcat.concat(s2);

        //if this method returns true then there is a possible rotation that can be done
        //str.contains() basically does what isSubstring would do
        return strcat.contains(s1);
    }
}
