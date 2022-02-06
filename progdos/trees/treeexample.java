import java.util.*;
public class treeexample {
    public static void main(String[] args) {
        // Parent Chain
        chain<String> head = new chain<String>("Aidan");
        
        // Aiden's Children
        chain<String> node2 = new chain<String>("Julian");
        chain<String> node3 = new chain<String>("Adam");
        chain<String> node5 = new chain<String>("Daniel");
        head.add(node2);
        head.add(node3);
        head.add(node5);
        
        // Julian's Children
        chain<String> node4 = new chain<String>("Zach");
        chain<String> node6 = new chain<String>("Ryan");
        node2.add(node4);
        node2.add(node6);
        // Adam's Children
        chain<String> node7 = new chain<String>("Brendan");
        chain<String> node9 = new chain<String>("James");
        node3.add(node7);
        node3.add(node9);
        // Daniel's Child
        chain<String> node11 = new chain<String>("Trent");
        node5.add(node11);
        
        // Ryan's Children
        chain<String> node8 = new chain<String>("Oscar");
        chain<String> node10 = new chain<String>("Nick");
        node6.add(node8);
        node6.add(node10);
        // Brendan's Child
        chain<String> node12 = new chain<String>("Dean");
        node7.add(node12);
        
        //System.out.println("The Mason Special");
        //head.traverse();
        System.out.println("\nDepth First");
        head.depth();
        System.out.println("\nBreadth First");
        head.breadth();
    }
}
