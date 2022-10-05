package duke.task;

public class Event extends Task {
    protected String time;

    public Event(String name, String time) {
        super(name);
        this.time = time;
    }
    /**
     * Method to print event
     * @return event in print format
     */
    @Override
    public String toString() {
        return "[E] " + super.toString() + " (at: " + time + ")";
    }
}

