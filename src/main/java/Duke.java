import duke.command.Ui;

import static duke.command.Parser.stringProcessor;
import static duke.command.Storage.fileReader;
import static duke.command.TaskList.tasks;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    /**
     * Method to run the main loop of the program
     * Accepts user input and carries out relevant command until user says "bye"
     */
    public static void main(String[] args) {
        Ui.greeting();
        // Load the data from the hard disk when Duke starts up.
        fileReader();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (true) {
            if (input.equals("bye")) {
                break;
            } else {
                try {
                    stringProcessor(input, tasks);
                } catch (IOException e) {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
            System.out.println();
            input = in.nextLine();
        }
        Ui.goodbye();
    }
}
