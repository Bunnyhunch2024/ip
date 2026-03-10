public class Wan {

    private static final String FILE_PATH = "data" + java.io.File.separator + "wan.txt";

    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Wan(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    public void run() {
        ui.showWelcome();
        boolean isRunning = true;

        while (isRunning) {
            try {
                String input = ui.readCommand();
                if (input.equals("bye")) {
                    ui.showBye();
                    isRunning = false;
                } else {
                    Parser.parse(input, tasks, ui, storage);
                }
            } catch (WanException e) {
                ui.showError(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                ui.showError("Exception: Array index is out of bound :(");
            } catch (NumberFormatException e) {
                ui.showError("Exception: Number format gone wrong :(");
            }
        }
        ui.close();
    }

    public static void main(String[] args) {
        new Wan(FILE_PATH).run();
    }
}