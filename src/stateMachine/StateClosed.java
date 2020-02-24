package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateClosed extends State {

    public StateClosed(TaskInterface task) {
        super(task);
    }

    @Override
    void up(Object... param) {
    }

    @Override
    void down(Object... param) {
    }

    @Override
    public State copy() {
        StateClosed copyState = new StateClosed(StateClosed.this.getContext());
        return copyState;
    }
}
