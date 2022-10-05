package duke.task;

public class Deadline extends Task {
    public String due;

    public Deadline(String name, String due) {
        super(name);
        this.due = due;
    }
    /**
     * Method to print deadline
     * @return deadline in print format
     */
    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + due + ")";
    }
}