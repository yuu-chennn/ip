package duke.command;

import duke.exception.DukeException;
import duke.exception.ParserException;
import duke.task.Task;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import static duke.command.TaskManager.tasks;
import static duke.command.TaskManager.addTodo;
import static duke.command.TaskManager.addDeadline;
import static duke.command.TaskManager.addEvent;
import static duke.command.TaskManager.list;
import static duke.command.TaskManager.markAsDone;
import static duke.command.TaskManager.markAsNotDone;
import static duke.command.TaskManager.deleteTask;
import static duke.command.TaskManager.findTask;

/**
 * Class that handles user inputs and carries out the appropriate action
 * Throws relevant errors
 */
public class Parser {
    // private static final boolean hasSpace = input.contains(" ");

    /**
     * Method to handle the user input. Splits "input" into the command.
     * @param input user input
     * @param tasks task list containing the tasks
     */
    public static void stringProcessor(String input, ArrayList<Task> tasks) throws ParserException.StringProcessorException {
        String command;
        if (input.contains("\t")) {
            try {
                command = input.substring(1, input.indexOf(" "));
                String removeCommand = input.substring(input.indexOf(" ") + 1);
                removeCommand.trim();
                handleFileData(removeCommand, command);
            } catch (ParserException.FileNotSavedException e) {
                System.out.println(e.getMessage());
            }
        } else if (input.contains(" ")) {
            try {
                command = input.substring(0, input.indexOf(" "));
                String removeCommand = input.substring(input.indexOf(" ") + 1);
                removeCommand.trim();
                handleUserInput(removeCommand, command);
            } catch (ParserException.InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid integer argument.");
            }
        } else if (input.equals("list")){
            list(tasks);
        } else {
            throw new ParserException.StringProcessorException();
        }
    }

    /**
     * Method to handle the user input.
     * @param input user input
     * @param command the command from the user
     */
    public static void handleUserInput(String input, String command) throws NumberFormatException, ParserException.InvalidInputException {
        switch(command) {
            case "mark":
                markAsDone(input, tasks);
                break;
            case "unmark":
                markAsNotDone(input, tasks);
                break;
            case "todo":
                addTodo(input, tasks);
                break;
            case "deadline":
                addDeadline(input, tasks);
                break;
            case "event":
                addEvent(input, tasks);
                break;
            case "delete":
                deleteTask(input, tasks);
                break;
            case "find":
                findTask(input, tasks);
                break;
            default:
                throw new ParserException.InvalidInputException();
        }
    }
    /**
     * Method to handle data read in from file and carry out the relevant method
     * @param input input data from file
     * @param taskType type of task read from file
     */
    public static void handleFileData(String input, String taskType) throws ParserException.FileNotSavedException {
        switch(taskType) {
            case "[T]":
                addTodo(input, tasks);
                break;
            case "[D]":
                addDeadline(input, tasks);
                break;
            case "[E]":
                addEvent(input, tasks);
                break;
            default:
                throw new ParserException.FileNotSavedException();
        }
    }
}
