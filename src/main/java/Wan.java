import java.util.Scanner;

public class Wan {
    public static void printLine(){
        System.out.println("    ____________________________________________________________");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

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
            }
            printLine();
            System.out.println("    " + input);
            printLine();

        }

        scanner.close();
    }
}
