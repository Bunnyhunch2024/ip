import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles loading and saving tasks to a file for persistent storage.
 */
public class Storage {

    private final String filePath;

    /**
     * Constructs a Storage instance with the given file path.
     *
     * @param filePath the path to the file used for saving and loading tasks
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the given list of tasks to the file.
     * Creates the file and any necessary parent directories if they do not exist.
     *
     * @param tasks the list of tasks to save
     */
    public void save(ArrayList<Task> tasks) {
        try {
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            FileWriter writer = new FileWriter(file);
            for (Task task : tasks) {
                writer.write(task.toFileString() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("    Warning: Could not save tasks: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the file and returns them as a list.
     * Returns an empty list if the file does not exist or cannot be read.
     *
     * @return a list of tasks loaded from the file
     */
    public List<Task> load() {
        List<Task> taskList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return taskList;
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                Task task = parseLine(line);
                if (task != null) {
                    taskList.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("    Warning: Could not load tasks: " + e.getMessage());
        }
        return taskList;
    }

    private Task parseLine(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            return null;
        }
        String type = parts[0].trim();
        boolean isDone = parts[1].trim().equals("1");
        String desc = parts[2].trim();
        Task task;
        switch (type) {
            case "T":
                task = new Todo(desc);
                break;
            case "D":
                if (parts.length < 4) {
                    return null;
                }
                task = new Deadline(desc, parts[3].trim());
                break;
            case "E":
                if (parts.length < 5) {
                    return null;
                }
                task = new Event(desc, parts[3].trim(), parts[4].trim());
                break;
            default:
                return null;
        }
        if (isDone) {
            task.markAsDone();
        }
        return task;
    }
}