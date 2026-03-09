import java.util.Scanner;


public class Wan {
    public static void printLine(){
        System.out.println("    ____________________________________________________________");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int numbers = 0;
        boolean isRunning = true;

        printLine();
        System.out.println("    Hello I'm Wan");
        System.out.println("    What can I do for you?");
        printLine();

        while(isRunning){
            String input = scanner.nextLine();
            String[] parts = input.split(" ",2);
            String command = parts[0];
            String description;

            switch(command){
                case "todo":
                    description = input.substring(5);
                    tasks[numbers] = new Todo(description);
                    numbers += 1;
                    printLine();
                    System.out.println("    Got it.I've added this task: ");
                    System.out.println("    " + tasks[numbers - 1].toString());
                    System.out.println("    Now you have " + numbers + " in the list");
                    printLine();
                    break;

                case "deadline":
                    String deadlineContent = input.substring(9);
                    String[] deadlineParts = deadlineContent.split(" /by ",2);
                    description = deadlineParts[0];
                    String by = deadlineParts[1];
                    tasks[numbers] = new Deadline(description,by);
                    numbers += 1;
                    printLine();
                    System.out.println("    Got it.I've added this task: ");
                    System.out.println("    " + tasks[numbers - 1].toString());
                    System.out.println("    Now you have " + numbers + " in the list");
                    printLine();
                    break;

                case "event":
                    String eventContent = input.substring(6);
                    String[] eventParts = eventContent.split(" /from ",2);
                    description = eventParts[0];
                    String[] timeParts = eventParts[1].split(" /to ",2);
                    String start = timeParts[0];
                    String end = timeParts[1];
                    tasks[numbers] = new Event(description,start,end);
                    numbers += 1;
                    printLine();
                    System.out.println("    Got it.I've added this task: ");
                    System.out.println("    " + tasks[numbers - 1].toString());
                    System.out.println("    Now you have " + numbers + " in the list");
                    printLine();
                    break;

                case "list":
                    printLine();
                    System.out.println("    Here are the tasks in your list:");
                    for (int i = 0; i < numbers; i += 1) {
                        System.out.print("    " + (i + 1) + ".");
                        System.out.println(tasks[i].toString());
                    }
                    printLine();
                    break;

                case "unmark":
                    int unmarkIndex = Integer.parseInt(parts[1]) - 1;
                    tasks[unmarkIndex].markAsUnDone();
                    printLine();
                    System.out.println("    Nice! I've marked this task as not done yet:");
                    System.out.println("      " + tasks[unmarkIndex].toString());
                    printLine();
                    break;

                case "mark":
                    int markIndex = Integer.parseInt(parts[1]) - 1;
                    tasks[markIndex].markAsDone();
                    printLine();
                    System.out.println("    Nice! I've marked this task as done:");
                    System.out.println("      " + tasks[markIndex].toString());
                    printLine();
                    break;

                case "bye":
                    printLine();
                    System.out.println("    Bye. Hope to see you again soon!");
                    printLine();
                    isRunning = false;
                    break;

                default:
                    tasks[numbers] = new Task(input);
                    numbers += 1;
                    printLine();
                    System.out.println("    Got it.I've added this task: ");
                    System.out.println("    " + tasks[numbers - 1].toString());
                    System.out.println("    Now you have " + numbers + " in the list");
                    printLine();
                    break;
            }
        }
        scanner.close();
    }
}
