package memento;

import java.util.Deque;
import java.util.List;


public class Browser {

    private Page currentPage;
    private List<Page> allPages;
    private Position currentPosition;

    private Data data;

    Deque<Memento> backDeque;
    Deque<Memento> forwardDeque;

    public Browser(Page currentPage, List<Page> allPages, Position currentPosition) {
        this.currentPage = currentPage;
        this.allPages = allPages;
        this.currentPosition = currentPosition;
    }

    public void goTo(String namePage){
        clearForwardHistory();
        backDeque.push(new Memento());
        this.currentPage = data.getPage(namePage);
    }

    private void clearForwardHistory() {
        this.forwardDeque.clear();
    }

    public void link(Page page) {
        clearForwardHistory();
        backDeque.push(new Memento());
        this.currentPage = page;
    }

    public void goToPosition(int position) {
        this.currentPosition = this.currentPage.getPositions().get(position);
        if (currentPosition != null)
            this.currentPosition.show(this);
    }

    public void back() {
        if (backDeque.isEmpty())
            throw new IllegalStateException("You can not go back");
        forwardDeque.push(new Memento());
        Memento memento = backDeque.pop();
        memento.restore();
    }

    public void forward() {
        if (forwardDeque.isEmpty())
            throw new IllegalStateException("You can not go forward");
        backDeque.push(new Memento());
        Memento memento = forwardDeque.pop();
        memento.restore();
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Memento createMemento(){
        return new Memento();
    }

    public class Memento{
        private Position position;
        private Page page;

        public Memento() {
            this.position = position;
            this.page = page;
        }

        private void restore() {
            currentPage = page;
            currentPosition = position;
        }
    }
}
