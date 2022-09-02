public class Task {
    protected String taskName;
    protected int taskNum;
    protected boolean isDone;

    public Task() {
        this("", 0);
    }

    public Task(String taskName, int taskNum) {
        this.taskName = taskName;
        this.taskNum = taskNum;
        this.isDone = false;
    }
}