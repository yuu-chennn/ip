package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class that handles tasks and carries out the appropriate action as instructed by parser
 */
public class TaskList {
    public static ArrayList<Task> tasks = new ArrayList<>();
    /**
     * Method to add a todo from user input or saved file data
     * Saves new data into file
     * @param input user input or saved file date without command
     * @param tasks task list containing the tasks
     */
    public static void addTodo(String input, ArrayList<Task> tasks) {
        if (Objects.equals(input, "") || Objects.equals(input, " ") || Objects.equals(input, "\t")) {
            System.out.println("☹ OOPS!!! Please use the correct format :-(");
            return;
        } else if (input.startsWith("[ ]")) {
            Todo t = new Todo(input.substring(4));
            tasks.add(t);
            t.num = tasks.size();
            t.isDone = false;
        } else if (input.startsWith("[X]")) {
            Todo t = new Todo(input.substring(4));
            tasks.add(t);
            t.num = tasks.size();
            t.isDone = true;
        } else {
            Todo t = new Todo(input);
            tasks.add(t);
            t.num = tasks.size();
            t.isDone = false;
            System.out.println("Got it. I've added this task: \n\t" + t);
            System.out.println("Now you have " + t.num + " tasks in the list.");
        }
        // Save the tasks in the hard disk automatically whenever the task list changes.
        Storage.fileUpdate();
    }
    /**
     * Method to add a deadline from user input or saved file data
     * Saves new data into file
     * @param input user input or saved file date without command
     * @param tasks task list containing the tasks
     */
    public static void addDeadline(String input, ArrayList<Task> tasks) {
        try {
            if (Objects.equals(input, "") || Objects.equals(input, " ") || Objects.equals(input, "\t")) {
                System.out.println("☹ OOPS!!! Please use the correct format :-(");
                return;
            } else if (input.startsWith("[ ]")) {
                int indexDelimiter = input.indexOf("(by: ");
                Deadline d = new Deadline(input.substring(4, indexDelimiter), input.substring(indexDelimiter + 5));
                tasks.add(d);
                d.num = tasks.size();
                d.isDone = false;
            } else if (input.startsWith("[X]")) {
                int indexDelimiter = input.indexOf("(by: ");
                Deadline d = new Deadline(input.substring(4, indexDelimiter), input.substring(indexDelimiter + 5));
                tasks.add(d);
                d.num = tasks.size();
                d.isDone = true;
            } else {
                int indexSlash = input.indexOf('/');
                if (indexSlash == -1) {
                    System.out.println("☹ OOPS!!! Please use the correct format :-(");
                    return;
                } Deadline d = new Deadline(input.substring(0, indexSlash), input.substring(indexSlash + 1));
                tasks.add(d);
                d.num = tasks.size();
                d.isDone = false;
                System.out.println("Got it. I've added this task: \n\t" + d);
                System.out.println("Now you have " + d.num + " tasks in the list.");
            }
            // Save the tasks in the hard disk automatically whenever the task list changes.
            Storage.fileUpdate();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array Index Out Of Bounds");
        }
    }
    /**
     * Method to add a event from user input or saved file data
     * Saves new data into file
     * @param input user input or saved file date without command
     * @param tasks task list containing the tasks
     */
    public static void addEvent(String input, ArrayList<Task> tasks) {
        try {
            if (Objects.equals(input, "") || Objects.equals(input, " ") || Objects.equals(input, "\t")) {
                System.out.println("☹ OOPS!!! Please use the correct format :-(");
                return;
            } else if (input.startsWith("[ ]")) {
                int indexDelimiter = input.indexOf("(at: ");
                Event e = new Event(input.substring(4, indexDelimiter), input.substring(indexDelimiter + 5));
                tasks.add(e);
                e.num = tasks.size();
                e.isDone = false;
            } else if (input.startsWith("[X]")) {
                int indexDelimiter = input.indexOf("(at: ");
                Event e = new Event(input.substring(4, indexDelimiter), input.substring(indexDelimiter + 5));
                tasks.add(e);
                e.num = tasks.size();
                e.isDone = true;
            } else {
                int indexSlash = input.indexOf('/');
                if (indexSlash == -1) {
                    System.out.println("☹ OOPS!!! Please use the correct format :-(");
                    return;
                } Event e = new Event(input.substring(0, indexSlash), input.substring(indexSlash + 1));
                tasks.add(e);
                e.num = tasks.size();
                e.isDone = false;
                System.out.println("Got it. I've added this task: \n\t" + e);
                System.out.println("Now you have " + e.num + " tasks in the list.");
            }
            // Save the tasks in the hard disk automatically whenever the task list changes.
            Storage.fileUpdate();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array Index Out Of Bounds");
        }
    }
    /**
     * Method to print a list from saved file data
     * @param input user input or saved file date without command
     * @param tasks task list containing the tasks
     */
    public static void list(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list: \n");
        int i = 0;
        for (Task task : tasks) {
            i++;
            System.out.print(i + ". " + task + "\n");
        }
    }
    /**
     * Method to mark a task in the task list as instructed by the mark command
     * @param input task number to be marked, from user input
     * @param tasks task list containing the tasks
     */
    public static void markAsDone(String input, ArrayList<Task> tasks) {
        if (Objects.equals(input, "") || Objects.equals(input, " ") || Objects.equals(input, "\t")) {
            System.out.println("☹ OOPS!!! Please use the correct format :-(");
            return;
        }
        int markNum = Integer.parseInt(input) - 1;
        if (markNum < 0 || markNum >= tasks.size()) {
            System.out.println("Please enter an existing task number.");
        }
        else if (!tasks.get(markNum).isDone) {
            tasks.get(markNum).isDone = true;
            // Save the tasks in the hard disk automatically whenever the task list changes.
            Storage.fileUpdate();
            System.out.println("Nice! I've marked this task as done: \n\t" + tasks.get(markNum));
        } else {
            System.out.println("Oops! This task is already marked as done: \n\t" + tasks.get(markNum));
        }
    }
    /**
     * Method to unmark a task in the task list as instructed by the unmark command
     * @param input task number to be unmarked, from user input
     * @param tasks task list containing the tasks
     */
    public static void markAsNotDone(String input, ArrayList<Task> tasks) {
        if (Objects.equals(input, "") || Objects.equals(input, " ") || Objects.equals(input, "\t")) {
            System.out.println("☹ OOPS!!! Please use the correct format :-(");
            return;
        }
        int markNum = Integer.parseInt(input) - 1;
        if (markNum < 0 || markNum >= tasks.size()) {
            System.out.println("Please enter an existing task number.");
        }
        else if (tasks.get(markNum).isDone) {
            tasks.get(markNum).isDone = false;
            // Save the tasks in the hard disk automatically whenever the task list changes.
            Storage.fileUpdate();
            System.out.println("OK, I've marked this task as not done yet: \n\t" + tasks.get(markNum));
        } else {
            System.out.println("☹ OOPS!!! This task is already marked as not done: \n\t" + tasks.get(markNum));
        }
    }
    /**
     * Method to delete a task in the task list as instructed by the delete command
     * @param input task number to be deleted, from user input
     * @param tasks task list containing the tasks
     */
    public static void deleteTask(String input, ArrayList<Task> tasks) {
        if (Objects.equals(input, "") || Objects.equals(input, " ") || Objects.equals(input, "\t")) {
            System.out.println("☹ OOPS!!! Please use the correct format :-(");
            return;
        }
        int taskNum = Integer.parseInt(input) - 1;
        if (taskNum < 0 || taskNum >= tasks.size()) {
            System.out.println("Please enter an existing task number.");
        } else {
            System.out.println("Noted. I've removed this task:\n\t" + tasks.get(taskNum));
            tasks.remove(taskNum);
            // Reassign task numbers
            for (int i = taskNum + 1; i < tasks.size(); i++) {
                tasks.get(i).num = i - 1;
            }
            // Save the tasks in the hard disk automatically whenever the task list changes.
            Storage.fileUpdate();
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }
}