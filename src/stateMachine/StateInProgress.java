package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateInProgress extends State {

    public StateInProgress(TaskInterface task) {
        super(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateResolved(getContext()));
    }

    @Override
    void down(Object... param) {
    }

    @Override
    public State copy() {
        StateInProgress copyState = new StateInProgress(StateInProgress.this.getContext());
        return copyState;
    }
}
