package stateMachine.proxy;

import stateMachine.State;
import stateMachine.Task;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Proxy implements TaskInterface {

    private TaskInterface task;

    private static Logger logger =  Logger.getLogger(Proxy.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("handler.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public Proxy(TaskInterface task) {
        this.task = task;
        logger.info("Proxy is initialized");
    }

    @Override
    public TaskInterface copy() {
        logger.info("Task's copy was created");
        return task.copy();
    }

    @Override
    public Integer getDevelopment() {
        logger.info("Task's developer id is " + task.getDevelopment());
        return task.getDevelopment();
    }

    @Override
    public void setDevelopment(Integer development) {
        task.setDevelopment(development);
        logger.info("Task's developer id was updated");
    }

    @Override
    public Integer getTesterId() {
        logger.info("Task's tester id is " + task.getTesterId());
        return task.getTesterId();
    }

    @Override
    public void setTesterId(Integer testerId) {
        task.setTesterId(testerId);
        logger.info("Task's tester id was updated");
    }

    @Override
    public String getText() {
        logger.info("Task's text is " + task.getText());
        return task.getText();
    }

    @Override
    public void setText(String text) {
        task.setText(text);
        logger.info("Task's text was updated");
    }

    @Override
    public String getError() {
        logger.info("Task's error is " + task.getError());
        return task.getError();
    }

    @Override
    public void setError(String error) {
        task.setError(error);
        logger.info("Task's error was updated");
    }

    @Override
    public Integer getId() {
        logger.info("Task's id is " + task.getId());
        return task.getId();
    }

    @Override
    public void setId(Integer id) {
        task.setId(id);
        logger.info("Task's id was updated");
    }

    @Override
    public State getState() {
        logger.info("Task's state is " + task.getState());
        return task.getState();
    }

    @Override
    public void setState(State state) {
        task.setState(state);
        logger.info("Task's state was updated");
    }

    @Override
    public void up() {
        task.up();
        logger.info("Up is successfully");
    }

    @Override
    public void down() {
        task.down();
        logger.info("Down is successfully");
    }
}
