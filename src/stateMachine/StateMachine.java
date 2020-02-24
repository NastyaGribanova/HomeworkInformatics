package stateMachine;

import stateMachine.proxy.TaskInterface;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {

    private List<TaskInterface> tasks ;

    public StateMachine() {
        this.tasks = new ArrayList<>();
    }

    public List<TaskInterface> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskInterface> tasks) {
        this.tasks = tasks;
    }

}
