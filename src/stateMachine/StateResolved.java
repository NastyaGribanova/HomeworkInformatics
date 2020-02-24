package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateResolved extends State {

    public StateResolved(TaskInterface task) {
        super(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateInTesting(getContext()));
        getContext().setTesterId(Integer.parseInt((String)param[1]));
    }

    @Override
    void down(Object... param) {
    }

    @Override
    public State copy() {
        StateResolved copyState = new StateResolved(StateResolved.this.getContext());
        return copyState;
    }
}
