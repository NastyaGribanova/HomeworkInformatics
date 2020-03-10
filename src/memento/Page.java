package memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page {

    private String name;
    private List<Page> links;
    private Map<Integer, Position> positions;

    public List<Page> getLinks() {
        return links;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Position> getPositions() {
        return positions;
    }

    public Page(String name, List<Page> links, Map<Integer, Position> positions) {
        this.name = name;
        this.links = links;
        this.positions = positions;
    }

    public Page(String name) {
        this(name, new ArrayList<>(), new HashMap<>());
    }
}
