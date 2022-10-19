package duke.command;

public class Ui {
    private static final String GREETING = "Hello! I'm Duke\n" + "What can I do for you?";
    private static final String GOODBYE = "Bye. Hope to see you again soon!\n";
    public static final String LOGO =
            " █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████     ▓█████▄  █    ██  ██ ▄█▀▓█████\n" +
            "▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒   ▒██▀ ██▌ ██  ▓██▒ ██▄█▒ ▓█   ▀\n" +
            "▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒   ░██   █▌▓██  ▒██░▓███▄░ ▒███\n" +
            "░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░   ░▓█▄   ▌▓▓█  ░██░▓██ █▄ ▒▓█  ▄\n" +
            "░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░   ░▒████▓ ▒▒█████▓ ▒██▒ █▄░▒████▒\n" +
            "░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░     ▒▒▓  ▒ ░▒▓▒ ▒ ▒ ▒ ▒▒ ▓▒░░ ▒░ ░\n" +
            "▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░     ░ ▒  ▒ ░░▒░ ░ ░ ░ ░▒ ▒░ ░ ░  ░\n" +
            "░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒      ░ ░  ░  ░░░ ░ ░ ░ ░░ ░    ░";

    public static final String DASH =
            "________________________________________________________________________________________________________________________\n";

    public static final String MESSAGE = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";

    /**
     * Method to greet user
     */
    public static void greeting() {
        System.out.println(GREETING);
        System.out.println(DASH);
        System.out.println(LOGO);
        System.out.println(DASH);
    }
    /**
     * Method to bid user goodbye
     */
    public static void goodbye() {
        System.out.println(GOODBYE);
        System.out.println(DASH);
    }
}
