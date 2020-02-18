package facade;

import structure.Tree;
import structure.Structure.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;

public class FacadeXML implements Facade {

    private static FacadeXML instance;

    private FacadeXML() {
    }

    public static FacadeXML getInstance(){
        if(instance == null){
            instance = new FacadeXML();
        }
        return instance;
    }

    @Override
    public void readTree(String file) {

    }

    @Override
    public void writeTree(Tree tree) {
        Node startNode = tree.getRoot();
        try(FileWriter writer = new FileWriter("xml.xml", false))
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Node.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(startNode, writer);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
