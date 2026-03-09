import java.util.Scanner;

public class Wan {
    public static void printLine(){
        System.out.println("    ____________________________________________________________");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Task[] tasks = new Task[100];
        int numbers = 0;

        printLine();
        System.out.println("    Hello I'm Wan");
        System.out.println("    What can I do for you?");
        printLine();

        while(true){
            input = scanner.nextLine();
            if(input.equals("bye")) {
                printLine();
                System.out.println("    Bye. Hope to see you again soon!");
                printLine();
                break;
            }else if(input.equals("list")) {
                printLine();
                System.out.println("    Here are the tasks in your list:");
                for (int i = 0; i < numbers; i += 1) {
                    System.out.print("    " + (i + 1) + ".");
                    System.out.println(tasks[i].toString());
                }
                printLine();
            }else if(input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                tasks[index].markAsDone();
                printLine();
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("      " + tasks[index].toString());
                printLine();
            }else if(input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                tasks[index].markAsNotDone();
                printLine();
                System.out.println("    Nice! I've marked this task as not done yet:");
                System.out.println("      " + tasks[index].toString());
                printLine();
            }else{
                tasks[numbers] = new Task(input);
                numbers += 1;
                printLine();
                System.out.println("    added: " + input);
                printLine();
            }
        }

        scanner.close();
    }
}
