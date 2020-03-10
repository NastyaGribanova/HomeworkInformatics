package memento.Factory;

import memento.Page;
import memento.Position;

public class VideoFactory implements Factory{

    @Override
    public Position create(Page page) {
        return new VideoAdvPage(page);
    }
}
