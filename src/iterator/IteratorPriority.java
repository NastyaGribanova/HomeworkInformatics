package iterator;

import structure.Structure;
import structure.Tree;
import structure.Structure.Node;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.stream.Collectors;

public class IteratorPriority implements Iterator<Node> {

    private Node root;
    private Node current;
    private Deque<Node> deque;

    public IteratorPriority(Tree tree) {
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
            if (!current.getChildren().isEmpty()){
                deque.addAll(current.getChildren().stream().sorted((o1, o2) -> o2.getPriority() - o1.getPriority()).collect(Collectors.toList()));
            }
        }
        return current;
    }
}
