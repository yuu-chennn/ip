package duke.exception;

public class ParserException {
    /**
     * Thrown when string fails to process.
     */
    public static class StringProcessorException extends DukeException {
        public StringProcessorException() {
        }

        public StringProcessorException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when input is invalid.
     */
    public static class InvalidInputException extends DukeException {
        public InvalidInputException() {
        }

        public InvalidInputException(String message) {
            super(message);
        }
    }

    /**
     * Thrown when file is not saved.
     */
    public static class FileNotSavedException extends DukeException {
        public FileNotSavedException() {
        }

        public FileNotSavedException(String message) {
            super(message);
        }
    }

}
