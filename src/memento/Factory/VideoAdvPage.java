package memento.Factory;

import memento.Browser;
import memento.Page;
import memento.Position;

public class VideoAdvPage implements Position {

    private Page page;

    public VideoAdvPage(Page page){
        this.page = page;
    }

    @Override
    public void goToAdv(Browser browser) {
        browser.link(page);
    }

    @Override
    public void show(Browser browser) {
        this.goToAdv(browser);
    }
}
