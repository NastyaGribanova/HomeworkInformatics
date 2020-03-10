package memento.Factory;

import memento.Page;
import memento.Position;

public class TextFactory implements Factory {

    @Override
    public Position create(Page page) {
        return new TextAdvPage(page);
    }
}
