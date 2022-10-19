package duke.exception;

import static duke.command.Ui.MESSAGE;

public class DukeException extends Exception {
    private String message = MESSAGE;

    /**
     * Initializes a new exception.
     */
    public DukeException() {
    }

    /**
     * Initializes a new exception with a message.
     */
    public DukeException(String message) {
        this.message = message;
    }

    /**
     * Method to get error message
     * @return string containing error message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
