import duke.command.TaskManager;
import static duke.command.FileManager.fileReader;
import static duke.command.TaskManager.tasks;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String greeting = "Hello! I'm Duke\n"
                        + "What can I do for you?\n";
        System.out.println(greeting);

        // Load the data from the hard disk when Duke starts up.
        fileReader();

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (true) {
            if (input.equals("bye")) {
                break;
            } else {
                try {
                    TaskManager.stringProcessor(input, tasks);
                } catch (IOException e) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
            System.out.println();
            input = in.nextLine();
        }
        String farewell = "Bye. Hope to see you again soon!\n";
        System.out.println(farewell);
    }
}
