package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateInTesting extends State {

    public StateInTesting(TaskInterface task) {
        super(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateClosed(getContext()));
        getContext().setTesterId(null);
        getContext().setDevelopment(null);
    }

    @Override
    void down(Object... param) {
        getContext().setState(new StateAssign(getContext()));
        getContext().setError((String)param[1]);
    }

    @Override
    public State copy() {
        StateInTesting copyState = new StateInTesting(StateInTesting.this.getContext());
        return copyState;
    }
}
