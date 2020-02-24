package stateMachine;

import stateMachine.proxy.TaskInterface;

public abstract class State {

    TaskInterface task;

    public TaskInterface getContext() {
        return task;
    }

    public State(TaskInterface task) {
        this.task = task;
    }

    abstract void up(Object... param);

    abstract void down(Object... param);

    public abstract State copy();
}
