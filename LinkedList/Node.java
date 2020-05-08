/**
* @author Ferruccio Sisti
* @since May 7, 2020
*
* Node class for linked lists
*/
class Node
{
    Node next = null;
    int data;

    public Node(int d)
    {
        data = d;
    }

    void appendToTail(int d)
    {
        Node end = new Node(d);
        Node n = this;

        //Iterate through the linked list until you reach the end
        while(n.next != null)
        {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node n, int d)
    {
        Node n = head;

        if (n.data == d)
        {
            return head.next; //Head is moved to next node
        }

        //Iterate through linkedList
        while (n.next != null)
        {
            if (n.data == d)
            {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        //node was not deleted
        return head;
    }
}
