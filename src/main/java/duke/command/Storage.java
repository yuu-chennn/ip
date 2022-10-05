package duke.command;

import duke.task.Task;

import java.io.*;
import java.util.ArrayList;

import static duke.command.Parser.stringProcessor;
import static duke.command.TaskList.tasks;

/**
 * Class that handles data file and carries out the appropriate action as instructed by parser
 */
public class Storage {
    private static final String FILE_DIRECTORY = "data";
    private static final String FILE_PATH = "data/duke.txt";
    /**
     * Method to read a file
     * Saves data from file into task list
     * Catches relevant exceptions
     */
    public static void fileReader() {
        try {
            fileReader(FILE_PATH, FILE_DIRECTORY);
        } catch (IOException e) {
            System.out.println("☹ OOPS!!! This file does not exist :-(");
        }
    }
    /**
     * Method to read a file
     * Saves data from file into task list
     * Throws relevant exceptions
     * @param filePath the path of the targeted data file
     * @param fileDirectory the directory of the targeted data file
     */
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
                stringProcessor(currentLine, reader);
            }
        } catch (IOException e) {
            System.out.println("☹ OOPS!!! Something went wrong :-(");
        }
    }
    /**
     * Method to update a file with new data
     * Saves data from task list into file
     * Catches relevant exceptions
     */
    public static void fileUpdate() {
        try {
            fileUpdate(FILE_PATH, tasks);
        } catch (IOException e) {
            System.out.println("☹ OOPS!!! Something went wrong :-(");
        }
    }
    /**
     * Method to update a file with new data
     * Saves data from task list into file
     * Throws relevant exceptions
     * @param filePath the path of the targeted data file
     * @param tasks the directory of the targeted data file
     */
    public static void fileUpdate(String filePath, ArrayList<Task> tasks) throws IOException {
        Writer w = new BufferedWriter(new FileWriter(filePath));
        for (Task task : tasks) {
            w.write("\t" + task.toString() + "\n");
        }
        w.close();
    }
}