import java.util.Scanner;

/**
 * Handles all interactions with the user, including reading input and displaying output.
 */
public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prints a horizontal divider line.
     */
    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Displays the welcome message when the chatbot starts.
     */
    public void showWelcome() {
        printLine();
        System.out.println("    Hello I'm Wan");
        System.out.println("    What can I do for you?");
        printLine();
    }

    /**
     * Displays the goodbye message when the user exits.
     */
    public void showBye() {
        printLine();
        System.out.println("    Bye. Hope to see you again soon!");
        printLine();
    }

    /**
     * Displays a warning message when tasks fail to load from file.
     */
    public void showLoadingError() {
        System.out.println("    Warning: Could not load existing tasks. Starting fresh.");
    }

    /**
     * Displays an error message to the user.
     *
     * @param message the error message to display
     */
    public void showError(String message) {
        printLine();
        System.out.println("     " + message);
        printLine();
    }

    /**
     * Displays a confirmation message after a task has been added.
     *
     * @param task the task that was added
     * @param size the current number of tasks in the list
     */
    public void showTaskAdded(Task task, int size) {
        printLine();
        System.out.println("    Got it. I've added this task: ");
        System.out.println("      " + task);
        System.out.println("    Now you have " + size + " tasks in the list");
        printLine();
    }

    /**
     * Displays a confirmation message after a task has been deleted.
     *
     * @param task the task that was removed
     * @param size the current number of tasks remaining in the list
     */
    public void showTaskDeleted(Task task, int size) {
        printLine();
        System.out.println("    Got it. I've removed this task: ");
        System.out.println("      " + task);
        System.out.println("    Now you have " + size + " tasks in the list");
        printLine();
    }

    /**
     * Displays a confirmation message after a task has been marked as done.
     *
     * @param task the task that was marked as done
     */
    public void showTaskMarked(Task task) {
        printLine();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("      " + task);
        printLine();
    }

    /**
     * Displays a confirmation message after a task has been marked as not done.
     *
     * @param task the task that was marked as undone
     */
    public void showTaskUnmarked(Task task) {
        printLine();
        System.out.println("    Nice! I've marked this task as undone:");
        System.out.println("      " + task);
        printLine();
    }

    /**
     * Displays all tasks currently in the list.
     *
     * @param tasks the task list to display
     */
    public void showTaskList(TaskList tasks) {
        printLine();
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("    " + (i + 1) + "." + tasks.get(i));
        }
        printLine();
    }

    /**
     * Displays all tasks whose descriptions contain the given keyword.
     *
     * @param tasks   the task list to search through
     * @param keyword the keyword to match against task descriptions
     */
    public void showMatchingTasks(TaskList tasks, String keyword) {
        printLine();
        System.out.println("     Here are the matching tasks in your list:");
        int count = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(keyword)) {
                System.out.println("     " + count + "." + tasks.get(i));
                count++;
            }
        }
        printLine();
    }

    /**
     * Reads a line of input from the user.
     *
     * @return the user's input as a string
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Closes the scanner and releases resources.
     */
    public void close() {
        scanner.close();
    }
}