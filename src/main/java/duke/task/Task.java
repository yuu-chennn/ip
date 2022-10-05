package duke.task;

public class Task {
    public String name;
    public int num;
    public boolean isDone;


    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }
    /**
     * Method to get status of completion of task
     * @return status of completion of task in print format
     */
    public String getStatus() {
        if (isDone) {
            return "X";
        } else {
            return " ";
        }
    }
    /**
     * Method to print task
     * @return task in print format
     */
    public String toString() {
        return "[" + getStatus() + "] " + name;
    }
}