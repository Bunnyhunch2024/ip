import java.util.Scanner;
import java.util.ArrayList;

public class Wan {
    public static void printLine(){
        System.out.println("    ____________________________________________________________");
    }

    private static void printTaskStatus(Task task, int size,String action) {
        printLine();
        if(action.equals("add")){
            System.out.println("    Got it. I've added this task: ");
        }else{
            System.out.println("    Got it. I've removed this task: ");
        }
        System.out.println("      " + task);
        System.out.println("    Now you have " + size + " tasks in the list");
        printLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        boolean isRunning = true;

        printLine();
        System.out.println("    Hello I'm Wan");
        System.out.println("    What can I do for you?");
        printLine();

        while(isRunning){
            String input = scanner.nextLine();
            try {
                String[] parts = input.split(" ", 2);
                String command = parts[0];

                switch (command) {
                    case "todo":
                        if(parts.length < 2){
                            throw new WanException("Exception: todo needs a description :(");
                        }
                        tasks.add(new Todo(parts[1]));
                        printTaskStatus(tasks.get(tasks.size() - 1), tasks.size(), "add");
                        break;

                    case "deadline":
                        if(parts.length < 2){
                            throw new WanException("Exception: deadline needs a description :(");
                        }
                        if(!parts[1].contains(" /by ")){
                            throw new WanException("Exception: deadline needs a /by :(");
                        }
                        String[] deadlineParts = parts[1].split(" /by ", 2);
                        tasks.add(new Deadline(deadlineParts[0], deadlineParts[1]));
                        printTaskStatus(tasks.get(tasks.size() - 1), tasks.size(), "add");
                        break;

                    case "event":
                        if(parts.length < 2){
                            throw new WanException("Exception: event needs a description :(");
                        }
                        if(!parts[1].contains(" /from ") || !parts[1].contains(" /to ")){
                            throw new WanException("Exception: event needs a /from and a /to :(");
                        }
                        String[] eventParts = parts[1].split(" /from ", 2);
                        String[] timeParts = eventParts[1].split(" /to ", 2);
<<<<<<< HEAD
                        tasks[numbers] = new Event(eventParts[0], timeParts[0], timeParts[1]);
                        numbers += 1;
                        printTaskAdded(tasks[numbers - 1], numbers);
=======
                        tasks.add(new Event(eventParts[0], timeParts[0], timeParts[1]));
                        printTaskStatus(tasks.get(tasks.size() - 1), tasks.size(), "add");
>>>>>>> branch-level-6
                        break;

                    case "list":
                        printLine();
                        System.out.println("    Here are the tasks in your list:");
                        for (int i = 0; i < tasks.size(); i += 1) {
                            System.out.println("    " + (i + 1) + "." + tasks.get(i));
                        }
                        printLine();
                        break;
                    case "delete":
                    case "mark":
                    case "unmark":
                        if (parts.length < 2) {
                            throw new WanException("Exception: mark/unmark needs a number :(");
                        }
                        int index = Integer.parseInt(parts[1]) - 1;
<<<<<<< HEAD
                        if(index < 0||index >= numbers||tasks[index] == null){
                            throw new WanException("Exception: task number doesn't exist :(");
                        }
                        printLine();
                        if(command.equals("mark")){
                            tasks[index].markAsDone();
=======
                        if (index < 0 || index >= tasks.size()) {
                            throw new WanException("Exception: task number doesn't exist :(");
                        }
                        if (command.equals("mark")) {
                            printLine();
                            tasks.get(index).markAsDone();
>>>>>>> branch-level-6
                            System.out.println("    Nice! I've marked this task as done:");
                            System.out.println("      " + tasks.get(index));
                            printLine();
                        } else if (command.equals("unmark")){
                            printLine();
                            tasks.get(index).markAsUnDone();
                            System.out.println("    Nice! I've marked this task as undone:");
                            System.out.println("      " + tasks.get(index));
                            printLine();
                        } else {
                            Task removedTask = tasks.remove(index);
                            printTaskStatus(removedTask, tasks.size(), "delete");
                        }
                        break;

                    case "bye":
                        printLine();
                        System.out.println("    Bye. Hope to see you again soon!");
                        printLine();
                        isRunning = false;
                        break;

                    default:
                        throw new WanException("    Invalid input.");
                }
            }catch(WanException e){
                printLine();
                System.out.println("     " + e.getMessage());
                printLine();
            }catch(ArrayIndexOutOfBoundsException e){
                printLine();
                System.out.println("     Exception: Array index is out of bound :(");
                printLine();
            }catch(NumberFormatException e){
                printLine();
                System.out.println("     Exception: Number format gone wrong :(");
                printLine();
            }
        }
        scanner.close();
    }
}
