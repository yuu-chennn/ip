package duke.command;

import duke.task.Task;

import java.io.*;
import java.util.ArrayList;

import static duke.command.TaskManager.tasks;

public class FileManager {
    private static final String FILE_DIRECTORY = "data";
    private static final String FILE_PATH = "data/duke.txt";

    public static void fileReader() {
        try {
            fileReader(FILE_PATH, FILE_DIRECTORY);
        } catch (IOException e) {
            System.out.println("☹ OOPS!!! This file does not exist :-(");
        }
    }

    public static void fileReader(String filePath, String fileDirectory) throws IOException {
        File fileDir = new File(fileDirectory);
        if (fileDir.mkdir()) {
            System.out.println("File created: " + fileDir.getName());
        }
        File file = new File(filePath);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        }
        ArrayList<Task> reader = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                TaskManager.stringProcessor(currentLine, reader);
            }
        } catch (IOException e) {
            System.out.println("☹ OOPS!!! Something went wrong :-(");
        }
    }

    public static void fileUpdate() {
        try {
            fileUpdate(FILE_PATH, tasks);
        } catch (IOException e) {
            System.out.println("☹ OOPS!!! Something went wrong :-(");
        }
    }

    public static void fileUpdate(String filePath, ArrayList<Task> tasks) throws IOException {
        Writer w = new BufferedWriter(new FileWriter(filePath));
        for (Task task : tasks) {
            w.write("\t" + task.toString() + "\n");
        }
        w.close();
    }
}