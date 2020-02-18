package facade;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import structure.Structure.Node;
import structure.Tree;

import java.io.FileWriter;
import java.io.IOException;

public class FacadeJSON implements Facade {

    private static FacadeJSON instance;

    private FacadeJSON() {
    }

    public static FacadeJSON getInstance(){
        if(instance == null){
            instance = new FacadeJSON();
        }
        return instance;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void readTree(String file) {

    }

    @Override
    public void writeTree(Tree tree) {
        Node startNode = tree.getRoot();
        try(FileWriter writer = new FileWriter("json.txt", false))
        {
            String json = mapper.writeValueAsString(startNode);
            writer.write(json);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
