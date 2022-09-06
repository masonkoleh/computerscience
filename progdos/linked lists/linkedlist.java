import java.util.*;

public class linkedlist
{
    public static void main(String args[])
    {
        // Creates and links the first four nodes
        chain<String> node1 = new chain<String>("Eric");
        chain<String> node2 = new chain<String>("Roman");
        node1.before(node2);
        chain<String> node3 = new chain<String>("Chris");
        node2.before(node3);
        chain<String> node4 = new chain<String>("Casey");
        node3.before(node4);

        // Head will always be the first node
        chain<String> head = node1;
        
        // Traverse the list
        chain<String> listiterator = head;
        while (listiterator.before() != null)
            listiterator = listiterator.before();
        
        // Insert an item at the beginning of the list
        chain<String> node5 = new chain<String>("Robbie");
        node5.before(head);
        head = node5;
        
        // Insert a node at the end of the list
        chain<String> node6 = new chain<String>("Kraig");
        chain<String> lastnode = head;
        while (lastnode.before() != null)
            lastnode = lastnode.before();
        lastnode.before(node6);
        
        // Insert a node in the middle of the list
        chain<String> node7 = new chain<String>("Pete");
        chain<String> search = head;
        while (!search.info().equals("Eric"))
            search = search.before();
        node7.before(search.before());
        search.before(node7);
        
        // Check to see if the list is empty
        chain<String> thelist = head;
        while (thelist.before() != null) {
            System.out.println(thelist.info());
            thelist = thelist.before();
        }
        System.out.println(thelist.info());
    }
}