package stateMachine;

import stateMachine.proxy.TaskInterface;

public class InterpreterTask {

    StateMachine tasks;

    public InterpreterTask(StateMachine tasks) {
        this.tasks = tasks;
    }

    public void interpreter(String string) {
        String[] words = string.split(" ");
        if (string.startsWith("new task")){
            String text = buildParams(words, 2);
            makeTask(text);
        } else if (string.startsWith("up")){
            Integer id = Integer.parseInt(words[1]);
            String param = buildParams(words, 2);
            up(id, param);
        } else if (string.startsWith("down")){
            Integer id = Integer.parseInt(words[1]);
            String param = buildParams(words, 2);
            down(id, param);
        } else if (string.startsWith("copy")){
            Integer id = Integer.parseInt(words[1]);
            copy(id);
        }
    }

    private String buildParams(String[] message, int index){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < message.length; i++) {
            stringBuilder.append(message[i]).append(" ");
        }
        String text = stringBuilder.toString();
        return text;
    }

    private Integer makeTask(String text){
        TaskInterface task = new Task(text);
        StateDraft stateDraft = new StateDraft(task);
        task.setState(stateDraft);
        addTask(task);
        return tasks.getTasks().indexOf(task);
    }

    private void addTask(TaskInterface task){
        tasks.getTasks().add(task);
    }

    private void up(Integer id, Object... param){
        tasks.getTasks().get(id).getState().up(param);
    }

    private void down(Integer id, Object... param){
        tasks.getTasks().get(id).getState().down(param);
    }

    private Integer copy(Integer id){
        TaskInterface copyTask = tasks.getTasks().get(id).copy();
        addTask(copyTask);
        return tasks.getTasks().indexOf(copyTask);
    }
}
