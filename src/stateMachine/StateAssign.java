package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateAssign extends State {

    public StateAssign(TaskInterface task) {
        super(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateInProgress(getContext()));
    }

    @Override
    void down(Object... param) {
        getContext().setState(new StateOpen(getContext()));
        getContext().setDevelopment(null);
    }

    @Override
    public State copy() {
        StateAssign copyState = new StateAssign(StateAssign.this.getContext());
        return copyState;
    }
}
