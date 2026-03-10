import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void showWelcome() {
        printLine();
        System.out.println("    Hello I'm Wan");
        System.out.println("    What can I do for you?");
        printLine();
    }

    public void showBye() {
        printLine();
        System.out.println("    Bye. Hope to see you again soon!");
        printLine();
    }

    public void showLoadingError() {
        System.out.println("    Warning: Could not load existing tasks. Starting fresh.");
    }

    public void showError(String message) {
        printLine();
        System.out.println("     " + message);
        printLine();
    }

    public void showTaskAdded(Task task, int size) {
        printLine();
        System.out.println("    Got it. I've added this task: ");
        System.out.println("      " + task);
        System.out.println("    Now you have " + size + " tasks in the list");
        printLine();
    }

    public void showTaskDeleted(Task task, int size) {
        printLine();
        System.out.println("    Got it. I've removed this task: ");
        System.out.println("      " + task);
        System.out.println("    Now you have " + size + " tasks in the list");
        printLine();
    }

    public void showTaskMarked(Task task) {
        printLine();
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("      " + task);
        printLine();
    }

    public void showTaskUnmarked(Task task) {
        printLine();
        System.out.println("    Nice! I've marked this task as undone:");
        System.out.println("      " + task);
        printLine();
    }

    public void showTaskList(TaskList tasks) {
        printLine();
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("    " + (i + 1) + "." + tasks.get(i));
        }
        printLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
