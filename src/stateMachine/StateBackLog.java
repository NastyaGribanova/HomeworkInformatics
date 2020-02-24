package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateBackLog extends State {

    public StateBackLog(TaskInterface task) {
        super(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateOpen(getContext()));
    }

    @Override
    void down(Object... param) {
    }

    @Override
    public State copy() {
        StateBackLog copyState = new StateBackLog(StateBackLog.this.getContext());
        return copyState;
    }
}
