public class Parser {

    public static void parse(String input, TaskList tasks, Ui ui, Storage storage) throws WanException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch (command) {
        case "todo":
            if (parts.length < 2) {
                throw new WanException("Exception: todo needs a description :(");
            }
            tasks.add(new Todo(parts[1]));
            ui.showTaskAdded(tasks.get(tasks.size() - 1), tasks.size());
            storage.save(tasks.getAll());
            break;

        case "deadline":
            if (parts.length < 2) {
                throw new WanException("Exception: deadline needs a description :(");
            }
            if (!parts[1].contains(" /by ")) {
                throw new WanException("Exception: deadline needs a /by :(");
            }
            String[] deadlineParts = parts[1].split(" /by ", 2);
            tasks.add(new Deadline(deadlineParts[0], deadlineParts[1]));
            ui.showTaskAdded(tasks.get(tasks.size() - 1), tasks.size());
            storage.save(tasks.getAll());
            break;

        case "event":
            if (parts.length < 2) {
                throw new WanException("Exception: event needs a description :(");
            }
            if (!parts[1].contains(" /from ") || !parts[1].contains(" /to ")) {
                throw new WanException("Exception: event needs a /from and a /to :(");
            }
            String[] eventParts = parts[1].split(" /from ", 2);
            String[] timeParts = eventParts[1].split(" /to ", 2);
            tasks.add(new Event(eventParts[0], timeParts[0], timeParts[1]));
            ui.showTaskAdded(tasks.get(tasks.size() - 1), tasks.size());
            storage.save(tasks.getAll());
            break;

        case "list":
            ui.showTaskList(tasks);
            break;

        case "mark":
            if (parts.length < 2) {
                throw new WanException("Exception: mark needs a number :(");
            }
            int markIndex = Integer.parseInt(parts[1]) - 1;
            tasks.get(markIndex).markAsDone();
            ui.showTaskMarked(tasks.get(markIndex));
            storage.save(tasks.getAll());
            break;

        case "unmark":
            if (parts.length < 2) {
                throw new WanException("Exception: unmark needs a number :(");
            }
            int unmarkIndex = Integer.parseInt(parts[1]) - 1;
            tasks.get(unmarkIndex).markAsUnDone();
            ui.showTaskUnmarked(tasks.get(unmarkIndex));
            storage.save(tasks.getAll());
            break;

        case "delete":
            if (parts.length < 2) {
                throw new WanException("Exception: delete needs a number :(");
            }
            int deleteIndex = Integer.parseInt(parts[1]) - 1;
            Task removed = tasks.remove(deleteIndex);
            ui.showTaskDeleted(removed, tasks.size());
            storage.save(tasks.getAll());
            break;

        case "find":
            if (parts.length < 2) {
                throw new WanException("Exception: needs a keyword pls type it :(");
            }
            ui.showMatchingTasks(tasks, parts[1]);
            break;

        default:
            throw new WanException("Invalid input.");
        }
    }
}
