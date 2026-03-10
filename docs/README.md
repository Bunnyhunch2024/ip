# Wan User Guide
```
 __          __          
 \ \        / /          
  \ \  /\  / /_ _ _ __  
   \ \/  \/ / _` | '_ \ 
    \  /\  / (_| | | | |
     \/  \/ \__,_|_| |_|
```

Wan is a command-line task management chatbot that helps you keep track of your todos, deadlines, and events. It is simple, fast, and saves your tasks automatically to disk.

---

## Quick Start

1. Ensure you have **Java 17** or above installed.
2. Download the latest `wan.jar` from the releases page.
3. Open a terminal, navigate to the folder containing the jar file, and run:
```
java -jar wan.jar
```

4. Type commands and press Enter to interact with Wan.

---

## Features

> **Notes about the command format:**
> - Words in `UPPER_CASE` are parameters to be supplied by the user.  
    >   e.g. in `todo DESCRIPTION`, `DESCRIPTION` is a parameter: `todo read book`.
> - Task numbers refer to the index shown in the `list` command.

---

### Adding a Todo: `todo`

Adds a task without any date or time attached.

**Format:** `todo DESCRIPTION`

**Example:**
```
todo read book
```

**Expected output:**
```
    ____________________________________________________________
    Got it. I've added this task: 
      [T][ ] read book
    Now you have 1 tasks in the list
    ____________________________________________________________
```

---

### Adding a Deadline: `deadline`

Adds a task that needs to be done before a specific date or time.

**Format:** `deadline DESCRIPTION /by DATE`

**Examples:**
```
deadline submit report /by Sunday
deadline return book /by June 6th
```

**Expected output:**
```
    ____________________________________________________________
    Got it. I've added this task: 
      [D][ ] submit report (by: Sunday)
    Now you have 2 tasks in the list
    ____________________________________________________________
```

---

### Adding an Event: `event`

Adds a task that starts and ends at specific times.

**Format:** `event DESCRIPTION /from START /to END`

**Examples:**
```
event project meeting /from Mon 2pm /to 4pm
event orientation /from 9am /to 12pm
```

**Expected output:**
```
    ____________________________________________________________
    Got it. I've added this task: 
      [E][ ] project meeting (from: Mon 2pm to: 4pm)
    Now you have 3 tasks in the list
    ____________________________________________________________
```

---

### Listing All Tasks: `list`

Shows all tasks currently in your task list.

**Format:** `list`

**Expected output:**
```
    ____________________________________________________________
    Here are the tasks in your list:
    1.[T][ ] read book
    2.[D][ ] submit report (by: Sunday)
    3.[E][ ] project meeting (from: Mon 2pm to: 4pm)
    ____________________________________________________________
```

---

### Marking a Task as Done: `mark`

Marks the specified task as done.

**Format:** `mark TASK_NUMBER`

**Example:**
```
mark 1
```

**Expected output:**
```
    ____________________________________________________________
    Nice! I've marked this task as done:
      [T][X] read book
    ____________________________________________________________
```

---

### Unmarking a Task: `unmark`

Marks the specified task as not done.

**Format:** `unmark TASK_NUMBER`

**Example:**
```
unmark 1
```

**Expected output:**
```
    ____________________________________________________________
    Nice! I've marked this task as undone:
      [T][ ] read book
    ____________________________________________________________
```

---

### Deleting a Task: `delete`

Removes the specified task from the list permanently.

**Format:** `delete TASK_NUMBER`

**Example:**
```
delete 2
```

**Expected output:**
```
    ____________________________________________________________
    Got it. I've removed this task: 
      [D][ ] submit report (by: Sunday)
    Now you have 2 tasks in the list
    ____________________________________________________________
```

---

### Finding Tasks by Keyword: `find`

Finds all tasks whose descriptions contain the given keyword.

**Format:** `find KEYWORD`

**Example:**
```
find book
```

**Expected output:**
```
    ____________________________________________________________
     Here are the matching tasks in your list:
     1.[T][ ] read book
    ____________________________________________________________
```

---

### Exiting the Program: `bye`

Exits Wan gracefully.

**Format:** `bye`

**Expected output:**
```
    ____________________________________________________________
    Bye. Hope to see you again soon!
    ____________________________________________________________
```

---

## Saving Data

Wan automatically saves your tasks to `data/wan.txt` after every change. There is no need to save manually.

---

## Editing the Data File

Task data is stored in `data/wan.txt`. Advanced users may edit this file directly, but note that **incorrect formatting may cause data to be lost** on the next load.

---

## Command Summary

| Action   | Format                                      |
|----------|---------------------------------------------|
| Todo     | `todo DESCRIPTION`                          |
| Deadline | `deadline DESCRIPTION /by DATE`             |
| Event    | `event DESCRIPTION /from START /to END`     |
| List     | `list`                                      |
| Mark     | `mark TASK_NUMBER`                          |
| Unmark   | `unmark TASK_NUMBER`                        |
| Delete   | `delete TASK_NUMBER`                        |
| Find     | `find KEYWORD`                              |
| Exit     | `bye`                                       |