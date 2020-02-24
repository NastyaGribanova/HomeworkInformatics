package stateMachine.proxy;

import stateMachine.State;
import stateMachine.Task;

public interface TaskInterface {
    TaskInterface copy();
    Integer getDevelopment();
    void setDevelopment(Integer development);
    Integer getTesterId();
    void setTesterId(Integer testerId);
    String getText();
    void setText(String text);
    String getError();
    void setError(String error);
    Integer getId();
    void setId(Integer id);
    State getState();
    void setState(State state);
    void up();
    void down();
}
