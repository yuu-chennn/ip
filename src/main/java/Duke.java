import java.util.Scanner;
public class Duke {
    static String[] tasks = new String[100];
    static int taskCount = 0;
    static void add(String input) {
        tasks[taskCount] = input;
        taskCount++;
        System.out.println("added: " + input);
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
                for (int i = 0; i < taskCount; i++) {
                    System.out.println(i + ". " + tasks[i]);
                }
            } else {
                add(input);
            }
            System.out.println();
            input = in.nextLine();
        }
        String farewell = "Bye. Hope to see you again soon!\n";
        System.out.println(farewell);
    }
}