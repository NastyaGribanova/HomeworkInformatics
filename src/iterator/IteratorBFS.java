package iterator;

import structure.Tree;

import structure.Structure.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class IteratorBFS implements Iterator<Node> {

    private Node root;
    private Node current;
    private Deque<Node> deque;

    public IteratorBFS(Tree tree) {
        deque = new ArrayDeque<Node>();
        setRoot(tree);
        reset();
    }

    public void setRoot(Tree tree){
        root = tree.getRoot();
    }

    public void reset(){
        current = root;
        deque.add(current);
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    @Override
    public Node next() {
        current = deque.pollFirst();
        if (current.getChildren() != null) {
            if (!current.getChildren().isEmpty())
            deque.addAll(current.getChildren());
        }
        return current;
    }
}
