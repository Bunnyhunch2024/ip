import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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
        String[] p = line.split(" \\| ");
        if (p.length < 3) {
            return null;
        }
        String type    = p[0].trim();
        boolean isDone = p[1].trim().equals("1");
        String desc    = p[2].trim();

        Task task;
        switch (type) {
            case "T":
                task = new Todo(desc);
                break;
            case "D":
                if (p.length < 4) return null;
                task = new Deadline(desc, p[3].trim());
                break;
            case "E":
                if (p.length < 5) return null;
                task = new Event(desc, p[3].trim(), p[4].trim());
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