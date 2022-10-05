package duke.task;

public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }
    /**
     * Method to print todo
     * @return todo in print format
     */
    @Override
    public String toString() {
        return "[T] " + super.toString() + "";
    }
}