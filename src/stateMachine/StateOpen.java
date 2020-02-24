package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateOpen extends State {

    public StateOpen(TaskInterface task) {
        super(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateAssign(getContext()));
        getContext().setDevelopment(Integer.parseInt((String)param[1]));
    }

    @Override
    void down(Object... param) {
        getContext().setState(new StateBackLog(getContext()));
    }

    @Override
    public State copy() {
        StateOpen copyState = new StateOpen(StateOpen.this.getContext());
        return copyState;
    }
}
