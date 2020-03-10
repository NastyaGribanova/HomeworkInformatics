package memento.Factory;

import memento.Browser;
import memento.Page;
import memento.Position;

public class TextAdvPage implements Position {
    private Page page;

    @Override
    public void goToAdv(Browser browser) {
        browser.link(page);
    }

    @Override
    public void show(Browser browser) {
    }

    public TextAdvPage(Page page) {
        this.page = page;
    }
}
