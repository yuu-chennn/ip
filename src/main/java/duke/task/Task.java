public class Task {
    protected String taskName;
    protected int taskNum;
    protected boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getStatus() {
        if (isDone) {
            return "X";
        } else {
            return " ";
        }
    }

    public String toString() {
        return "[" + getStatus() + "] " + taskName;
    }
}