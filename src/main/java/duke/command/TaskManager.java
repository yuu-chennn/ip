package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.io.IOException;

public class TaskManager {
    public static ArrayList<Task> tasks = new ArrayList<>();

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

    public static void handleFileData(String input, String command) {
        switch(command) {
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
    public static void addTodo(String input, ArrayList<Task> tasks) {
        if (input.startsWith("[ ]")) {
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
        FileManager.fileUpdate();


    }

    public static void addDeadline(String input, ArrayList<Task> tasks) {
        try {

            if (input.startsWith("[ ]")) {
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
            FileManager.fileUpdate();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array Index Out Of Bounds");
        }
    }

    public static void addEvent(String input, ArrayList<Task> tasks) {
        try {

            if (input.startsWith("[ ]")) {
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
            FileManager.fileUpdate();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array Index Out Of Bounds");
        }
    }

    public static void list(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list: \n");
        int i = 0;
        for (Task task : tasks) {
            i++;
            System.out.print(i + ". " + task + "\n");
        }
        FileManager.fileUpdate();
    }

    public static void markAsDone(String input, ArrayList<Task> tasks) {
        int markNum = Integer.parseInt(input) - 1;
        if (markNum < 0 || markNum >= tasks.size()) {
            System.out.println("Please enter an existing task number.");
        }
        else if (!tasks.get(markNum).isDone) {
            tasks.get(markNum).isDone = true;
            // Save the tasks in the hard disk automatically whenever the task list changes.
            FileManager.fileUpdate();
            System.out.println("Nice! I've marked this task as done: \n\t" + tasks.get(markNum));
        } else {
            System.out.println("Oops! This task is already marked as done: \n\t" + tasks.get(markNum));
        }
    }
    public static void markAsNotDone(String input, ArrayList<Task> tasks) {
        int markNum = Integer.parseInt(input) - 1;
        if (markNum < 0 || markNum >= tasks.size()) {
            System.out.println("Please enter an existing task number.");
        }
        else if (tasks.get(markNum).isDone) {
            tasks.get(markNum).isDone = false;
            // Save the tasks in the hard disk automatically whenever the task list changes.
            FileManager.fileUpdate();
            System.out.println("OK, I've marked this task as not done yet: \n\t" + tasks.get(markNum));
        } else {
            System.out.println("☹ OOPS!!! This task is already marked as not done: \n\t" + tasks.get(markNum));
        }
    }
    public static void deleteTask(String input, ArrayList<Task> tasks) {
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
            FileManager.fileUpdate();
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }
}