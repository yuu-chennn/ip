import java.util.ArrayList;

public class TaskManager {
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void addTodo(String input, ArrayList<Task> tasks) {
        Todo t = new Todo(input.substring(5));
        tasks.add(t);
        t.taskNum = tasks.size();
        t.isDone = false;
        System.out.println("Got it. I've added this task: \n" + t);
        System.out.println("Now you have " + t.taskNum + " tasks in the list.");
    }

    public static void addDeadline(String input, ArrayList<Task> tasks) {
        int indexSlash = input.indexOf('/');
        if (indexSlash == -1) {
            return;
        }
        Deadline d = new Deadline(input.substring(9, indexSlash), input.substring(indexSlash + 1));
        tasks.add(d);
        d.taskNum = tasks.size();
        d.isDone = false;
        System.out.println("Got it. I've added this task: \n" + d);
        System.out.println("Now you have " + d.taskNum + " tasks in the list.");
    }

    public static void addEvent(String input, ArrayList<Task> tasks) {
        int indexSlash = input.indexOf('/');
        if (indexSlash == -1) {
            return;
        }
        Event e = new Event(input.substring(6, indexSlash), input.substring(indexSlash + 1));
        tasks.add(e);
        e.taskNum = tasks.size();
        e.isDone = false;
        System.out.println("Got it. I've added this task: \n" + e);
        System.out.println("Now you have " + e.taskNum + " tasks in the list.");
    }

    public static void list(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list: \n");
        for (Task task : tasks) {
            System.out.print(task.taskNum + ". [");
            if (task instanceof Todo) {
                System.out.print("T] ");
            } else if (task instanceof Deadline) {
                System.out.print("D] ");
            } else if (task instanceof Event) {
                System.out.print("E] ");
            }
            if (task.isDone) {
                System.out.println("[X] " + task.taskName);
            } else {
                System.out.println("[ ] " + task.taskName);
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
}
