import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String greeting = "Hello! I'm Duke\n"
                        + "What can I do for you?\n";
        System.out.println(greeting);
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (!input.equals("bye")) {
            System.out.println(input);
            System.out.println();
            input = in.nextLine();
        }
        String farewell = "Bye. Hope to see you again soon!\n";
        System.out.println(farewell);
    }
}