package memento.Factory;

import memento.Page;
import memento.Position;

public interface Factory {
    Position create(Page page);
}
