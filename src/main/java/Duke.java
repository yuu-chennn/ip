import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static void add(String input, ArrayList<Task> tasks) {
        Task t = new Task();
        tasks.add(t);
        t.taskName = input;
        t.taskNum = tasks.size();
        t.isDone = false;
        System.out.println("added: " + input);
    }
    public static void list(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.print(task.taskNum + ". [");
            if (task.isDone) {
                System.out.println("X] " + task.taskName);
            } else {
                System.out.println(" ] " + task.taskName);
            }
        }
    }
    public static void markAsDone(String input, ArrayList<Task> tasks) {
        int markNum = Integer.parseInt(input.substring(input.length() - 1)) - 1;
        if (markNum < tasks.size()) {
            tasks.get(markNum).isDone = true;
            System.out.println("Nice! I've marked this task as done: \n\t[X] " + tasks.get(markNum).taskNum);
        }
    }
    public static void markAsNotDone(String input, ArrayList<Task> tasks) {
        int markNum = Integer.parseInt(input.substring(input.length() - 1)) - 1;
        if (markNum < tasks.size() && tasks.get(markNum).isDone) {
            tasks.get(markNum).isDone = false;
            System.out.println("OK, I've marked this task as not done yet: \n\t[ ] " + tasks.get(markNum).taskNum);
        }
    }
    public static void main(String[] args) {
        String greeting = "Hello! I'm Duke\n"
                        + "What can I do for you?\n";
        System.out.println(greeting);
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (true) {
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                list(tasks);
            } else if (input.startsWith("mark")){
                markAsDone(input, tasks);
            } else if (input.startsWith("unmark")) {
                markAsNotDone(input, tasks);
            } else {
                add(input, tasks);
            }
            System.out.println();
            input = in.nextLine();
        }
        String farewell = "Bye. Hope to see you again soon!\n";
        System.out.println(farewell);
    }
}

