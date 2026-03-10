import java.util.Scanner;


public class Wan {
    public static void printLine(){
        System.out.println("    ____________________________________________________________");
    }

    private static void printTaskAdded(Task task, int numbers) {
        printLine();
        System.out.println("    Got it. I've added this task: ");
        System.out.println("      " + task);
        System.out.println("    Now you have " + numbers + " tasks in the list");
        printLine();
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
            try {
                String[] parts = input.split(" ", 2);
                String command = parts[0];

                switch (command) {
                    case "todo":
                        if(parts.length < 2){
                            throw new WanException("Exception: todo needs a description :(");
                        }
                        tasks[numbers] = new Todo(parts[1]);
                        numbers += 1;
                        printTaskAdded(tasks[numbers - 1], numbers);
                        break;

                    case "deadline":
                        if(parts.length < 2){
                            throw new WanException("Exception: deadline needs a description :(");
                        }
                        if(!parts[1].contains(" /by ")){
                            throw new WanException("Exception: deadline needs a /by :(");
                        }
                        String[] deadlineParts = parts[1].split(" /by ", 2);
                        tasks[numbers] = new Deadline(deadlineParts[0], deadlineParts[1]);
                        numbers += 1;
                        printTaskAdded(tasks[numbers - 1], numbers);
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
                        tasks[numbers] = new Event(eventParts[0], eventParts[0], timeParts[1]);
                        numbers += 1;
                        printTaskAdded(tasks[numbers - 1], numbers);
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

                    case "mark":
                    case "unmark":
                        if(parts.length < 2){
                            throw new WanException("Exception: mark/unmark needs a number :(");
                        }
                        int index = Integer.parseInt(parts[1]) - 1;
                        printLine();
                        if(command.equals("mark")){
                            tasks[index].markAsDone();
                            System.out.println("    Nice! I've marked this task as done:");
                        }
                        else{
                            tasks[index].markAsUnDone();
                            System.out.println("    Nice! I've marked this task as undone:");
                        }
                        System.out.println("      " + tasks[index].toString());
                        printLine();
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
