/**
* @author Ferruccio Sisti
* @since May 7, 2020
*
* Problem: Remove Dups! Write code to remove duplicates from an unsorted linked list.
*/

import java.util.*;

public class RemoveDups
{

    /**
    * Method removes all duplicate nodes from a linked list
    * @param n the head node of the linked list we are removing duplicates from
    * @return Nothing. The duplicate elements are removed
    */
    public static void removeCopy(LinkedListNode n)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        //Create a pointer for the previous node
        LinkedListNode previous = null;
        while(n != null)
        {
            //if this is a duplicate node
            if (set.contains(n.data))
            {
                //previous node now points to next node and current node is abandoned
                previous.next = n.next;
            }
            else
            {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
}
