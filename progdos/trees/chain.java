import java.util.*;
public class chain<T> {
    protected T info;
    protected LinkedList<chain<T>> children = new LinkedList<chain<T>>();
    
    public chain(T info)
    { this.info = info; }
    
    public T info()
    { return this.info; }
    public void info(T info)
    { this.info = info; }
    
    public void add(chain<T> child)
    { this.children.add(child);  }

    public LinkedList<chain<T>> children()
    { return this.children;    }
    
    public LinkedList<chain<T>> tree() {
        LinkedList<chain<T>> tree = new LinkedList<chain<T>>();
        for (chain<T> node : this.children)
            for (chain<T> link : node.tree()) {
                tree.add(link);
            }
        tree.add(this);
        return tree;
    }
    
    public void traverse() {
        for (chain<T> node : this.children)
            node.traverse();
        System.out.println(this.info);
    }
    
    public void depth() {
        System.out.println(this.info);
        for (chain<T> node : this.children)
            node.depth();
    }
    
    public void breadth() {
        Queue<chain<T>> lineup = new LinkedList<chain<T>>();
        lineup.add(this);
        while (lineup.size() > 0) {
            chain<T> removed = lineup.remove();
            for (chain<T> node : removed.children())
                lineup.add(node);
            System.out.println(removed.info());
        }
    }
}