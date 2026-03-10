/**
 * Represents a general task in the system.
 * A task consists of a description and a completion status.
 */
public class Task {

    protected String description;
    protected boolean isDone;

    /**
     * Initializes a new Task with the specified description.
     * By default, the task is marked as not done.
     *
     * @param description A string describing the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns an icon representing the completion status of the task.
     *
     * @return "X" if the task is done, or a single space if it is not.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as completed.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as incomplete.
     */
    public void markAsUnDone() {
        this.isDone = false;
    }

    /**
     * Formats the task data into a specific string format for file storage.
     * The format used is: "status | description" (where 1 is done, 0 is not done).
     *
     * @return A formatted string suitable for saving to a data file.
     */
    public String toFileString() {
        return (isDone ? "1" : "0") + " | " + description;
    }

    /**
     * Returns a user-friendly string representation of the task,
     * including its status icon and description.
     *
     * @return A string in the format: "[Status] Description".
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}