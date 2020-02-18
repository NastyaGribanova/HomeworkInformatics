package iterator;

import structure.Tree;
import structure.Structure.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class IteratorDFS implements Iterator<Node> {

    private Node root;
    private Node current;
    private Deque<Node> deque;

    public IteratorDFS(Tree tree) {
        deque = fillDeque();
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
        current = deque.pollLast();
        if (deque.peekLast() != null){
            Node parent = current.getParent();
            if (parent != null){
                parent.getChildren().remove(current);
                if (!deque.contains(parent)){
                    deque.add(parent);
                }
                if (!parent.getChildren().isEmpty()){
                    if(!deque.containsAll(parent.getChildren())){
                        deque.addAll(parent.getChildren());
                    }
                }
            }
            while(!current.getChildren().isEmpty()){
                if(!deque.containsAll(current.getChildren())){
                    Node helpNode = current;
                    deque.add(current);
                    deque.addAll(current.getChildren());
                    current = deque.pollLast();
                    helpNode.getChildren().remove(current);
                }
            }
        }
        return current;
    }

    public Deque<Node> fillDeque(){
        deque = new ArrayDeque<Node>();
        deque.add(root);
        current = root;
        while(current.getChildren().isEmpty()) {
            if (current.getChildren() != null) {
                Node child = current.getChildren().get(0);
                deque.add(child);
                current = child;
            }
        }
        return deque;
    }
}
