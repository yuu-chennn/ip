package duke.command;

import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;

import static duke.command.TaskList.*;

/**
 * Class that handles user inputs and carries out the appropriate action
 * Throws relevant errors
 */
public class Parser {
    /**
     * Method to handle the user input. Splits "input" into the command.
     * @param input user input
     * @param tasks task list containing the tasks
     */
    public static void stringProcessor(String input, ArrayList<Task> tasks) throws IOException {
        String command;
        if (input.contains(" ")) {
            command = input.substring(0, input.indexOf(" "));
            String removeCommand = input.substring(input.indexOf(" ") + 1);
            removeCommand.trim();
            handleUserInput(removeCommand, command);
        } else if (input.contains("\t")) {
            command = input.substring(1, input.indexOf(" "));
            String removeCommand = input.substring(input.indexOf(" ") + 1);
            removeCommand.trim();
            handleFileData(removeCommand, command);
        } else if (input.equals("list")){
            list(tasks);
        } else {
            System.out.println("☹ OOPS!!! Please use the correct format :-(");
        }
    }

    /**
     * Method to handle the user input.
     * @param input user input
     * @param command the command from the user
     */
    public static void handleUserInput(String input, String command) {
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
        }
    }
    /**
     * Method to handle data read in from file and carry out the relevant method
     * @param input input data from file
     * @param taskType type of task read from file
     */
    public static void handleFileData(String input, String taskType) {
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
        }
    }
}
