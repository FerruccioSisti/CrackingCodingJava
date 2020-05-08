/**
* @author Ferruccio Sisti
* @since May 7, 2020
*
* Problem: Return Kth to Last: Implement an algorithm to find the kth to last
* element of a singly linked list.
*/

public class KthToLast
{

    /**
    * Method prints out the kth to last element in the linked list
    * If you want to retrieve the actual element then you need a wrapper class to mimic
    * passing by memory like you could in C
    * @param head The head node of the linked list
    * @param k the element before the end of the linked list you want to retrieve
    * @return an int representing the current index (for a recursive solution)
    */
    public static int printKthToLast(LinkedListNode head, int k)
    {
        if (head == null)
        {
            //return -1 because if k is 0 then we want the last node returned from
            //our index declaration
            return -1;
        }

        //need to add one because eventually when we reach the end the value returned is 0
        int index = printKthToLast(head.next, k) + 1;
        if (index == k)
        {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }
}
