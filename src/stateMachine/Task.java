package stateMachine;

import stateMachine.proxy.TaskInterface;

public class Task implements TaskInterface {
    Integer development;
    Integer testerId;
    String text;
    String error;
    Integer id;

    State state;

    public Task(String text) {
        this.text = text;
    }

    public Task copy(){
        Task copyTask = new Task(Task.this.getText());
        copyTask.setState(Task.this.getState().copy());
        copyTask.setError(Task.this.getError());
        copyTask.setTesterId(Task.this.getTesterId());
        copyTask.setDevelopment(Task.this.getDevelopment());
        return copyTask;
    }

    public Integer getDevelopment() {
        return development;
    }

    public void setDevelopment(Integer development) {
        this.development = development;
    }

    public Integer getTesterId() {
        return testerId;
    }

    public void setTesterId(Integer testerId) {
        this.testerId = testerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void up(){
        state.up();
    }

    public void down(){
        state.down();
    }
}
