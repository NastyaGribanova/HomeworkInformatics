import structure.Structure;
import structure.Structure.Node;

import java.util.List;

import static structure.Structure.Type.COUNTRY;
import static structure.Structure.Type.REGION;

public class Main {

    public static void main(){
        List<Node> russianChildren = null;
        russianChildren.add(Node.builder().name("Bashkortostan").type(REGION).priority(0).build());
        Node.builder().name("Russia").type(COUNTRY).priority(5).children(russianChildren).build();
    }
}
