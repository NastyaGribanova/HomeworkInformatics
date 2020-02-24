package stateMachine;

import stateMachine.proxy.TaskInterface;

public class StateDraft extends State {

    public StateDraft(TaskInterface task) {
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
        StateDraft copyState = new StateDraft(StateDraft.this.getContext());
        return copyState;
    }
}
