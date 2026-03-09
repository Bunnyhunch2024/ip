import java.util.Scanner;

public class Wan {
    public static void printLine(){
        System.out.println("    ____________________________________________________________");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] storage = new String[100];
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
                for (int i = 0; i < numbers; i += 1) {
                    System.out.print("    " + (i + 1) + ": ");
                    System.out.println(storage[i]);
                }
                printLine();
            }else{
                printLine();
                storage[numbers] = input;
                numbers += 1;
                System.out.println("    added: " + input);
                printLine();
            }
        }

        scanner.close();
    }
}
