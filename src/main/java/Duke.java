import java.util.Scanner;

public class Duke {
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
                TaskManager.list(TaskManager.tasks);
            } else if (input.startsWith("mark")){
                TaskManager.markAsDone(input, TaskManager.tasks);
            } else if (input.startsWith("unmark")) {
                TaskManager.markAsNotDone(input, TaskManager.tasks);
            } else if (input.startsWith("todo")) {
                TaskManager.addTodo(input, TaskManager.tasks);
            } else if (input.startsWith("deadline")) {
                TaskManager.addDeadline(input, TaskManager.tasks);
            } else if (input.startsWith("event")) {
                TaskManager.addEvent(input, TaskManager.tasks);
            } else {
                System.out.println("Please enter a valid command.");
            }
            System.out.println();
            input = in.nextLine();
        }
        String farewell = "Bye. Hope to see you again soon!\n";
        System.out.println(farewell);
    }
}
