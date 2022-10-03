package duke.task;

public class Task {
    public String name;
    public int num;
    public boolean isDone;

    public Task(String name) {
        this.name = name;
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
        return "[" + getStatus() + "] " + name;
    }
}