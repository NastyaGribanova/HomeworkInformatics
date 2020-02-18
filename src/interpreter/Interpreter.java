package interpreter;

import facade.FacadeJSON;
import facade.FacadeXML;
import iterator.IteratorBFS;
import structure.Structure.Node;
import structure.Structure.Type;
import structure.Tree;

import java.util.LinkedList;
import java.util.List;

public class Interpreter {

    Tree tree;

    public Interpreter(Tree tree) {
        this.tree = tree;
    }

    public void interpreter(String string){
        String[] words = string.split(" ");
        if(string.startsWith("return children")){
            Type type = Type.valueOf(words[2]);
            String name = words[3];
            returnChildren(type, name);
        } else if(string.startsWith("add")){
            String[] address = words[1].split(",");
            String parent = address[address.length - 1];
            String name = words[2];
            Type type = Type.valueOf(words[3]);
            int priority = Integer.parseInt(words[4]);
            addNode(parent, name, type, priority);
        } else if(string.startsWith("save")){
            String format = words[1];
            save(format);
        } else if(string.startsWith("delete")){
            String[] address = words[1].split(",");
            String name = address[address.length - 1];
            delete(name);
        }
    }

    private List<Node> returnChildren(Type type, String name){
        IteratorBFS iteratorBFS = new IteratorBFS(tree);
        Node node = iteratorBFS.next();
        while ((!node.getName().equals(name))&&(!node.getType().equals(type))){
            node = iteratorBFS.next();
        }
        for (Node child: node.getChildren()) {
            System.out.println(child.getName());
        }
        return node.getChildren();
    }

    private void addNode(String parent, String name, Type type, int priority){
        IteratorBFS iteratorBFS = new IteratorBFS(tree);
        Node node1 = iteratorBFS.next();
        while ((!node1.getName().equals(name))&&(!node1.getType().equals(type))){
            node1 = iteratorBFS.next();
            if (node1!=null) {
                System.out.println("The same node is already exist");
            }
        }
        Node parentNode = iteratorBFS.next();
        while (!parentNode.getName().equals(parent)) {
            parentNode = iteratorBFS.next();
            if (parentNode == null) {
                System.out.println("Parent node is not exist");
            }
        }
        Node node = Node.builder().parent(parentNode).name(name).type(type).priority(priority).build();
        List<Node> child = new LinkedList<>();
        child.add(node);
        parentNode.builder().children(child).build();

    }

    private void save(String format){
        if (format.equals("xml")){
            FacadeXML.getInstance().writeTree(tree);
        } else if (format.equals("json")){
            FacadeJSON.getInstance().writeTree(tree);
        }
    }

    private void delete(String name){
        IteratorBFS iteratorBFS = new IteratorBFS(tree);
        Node node = iteratorBFS.next();
        while (!node.getName().equals(name)){
            node = iteratorBFS.next();
            if(node == null){
                System.out.println("This node is not exist");
            }
        }
        Node parentNode = node.getParent();
        parentNode.getChildren().remove(node);
    }
}
