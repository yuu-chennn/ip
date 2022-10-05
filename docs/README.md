# User Guide

Duke is a desktop app for managing tasks, optimized for use via a Command Line Interface (CLI).

## Quick-start
Setting up your application in Intellij.
- Prerequisites: JDK 11, update Intellij to the most recent version.
- Open Intellij (if you are not in the welcome screen, click File > Close Project to close the existing project first)
- Open the project into Intellij as follows:
  - Click Open.
  - Select the project directory, and click OK.
  - If there are any further prompts, accept the defaults.
- Configure the project to use JDK 11 (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
- In the same dialog, set the Project language level field to the SDK default option.
- After that, locate the `src/main/java/duke.Duke.java` file, right-click it, and choose `Run duke.Duke.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
```
  Hello! I'm Duke
  What can I do for you?
  ________________________________________________________________________________________________________________________

  █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████     ▓█████▄  █    ██  ██ ▄█▀▓█████
  ▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒   ▒██▀ ██▌ ██  ▓██▒ ██▄█▒ ▓█   ▀
  ▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒   ░██   █▌▓██  ▒██░▓███▄░ ▒███
  ░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░   ░▓█▄   ▌▓▓█  ░██░▓██ █▄ ▒▓█  ▄
  ░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░   ░▒████▓ ▒▒█████▓ ▒██▒ █▄░▒████▒
  ░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░     ▒▒▓  ▒ ░▒▓▒ ▒ ▒ ▒ ▒▒ ▓▒░░ ▒░ ░
  ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░     ░ ▒  ▒ ░░▒░ ░ ░ ░ ░▒ ▒░ ░ ░  ░
  ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒      ░ ░  ░  ░░░ ░ ░ ░ ░░ ░    ░
  ________________________________________________________________________________________________________________________
```

- Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
  Some example commands you can try:

  - `todo watch lecture` : Adds a todo "watch lecture" to the Task List. 
  - `deadline cs2113t assignment/friday 2359` : Adds a deadline "cs2113t assignment" due by "friday 2359" to the Task List.
  - `event mom's birthday/tuesday 6pm` : Adds an event "mom's birthday" at "tuesday 6pm" to the Task List.
  - `list` : Lists all tasks.
  - `delete 1` : Deletes the 1st task shown in the current list. 
  - `mark 2` : Marks the 2nd task shown in the current list as done.
  - `unmark 2` : Marks the 2nd task shown in the current list as not done.
  - `bye` : Exits the app.

- Refer to the Features below for details of each command.

## Features

### `todo TASKNAME` : Add a todo
Add a todo to the Task List.

Example of usage:

`todo watch lecture`

Expected outcome:

Add "watch lecture" to the Task List as a todo.

```
Got it. I've added this task: 
	[T] [ ] watch lecture
Now you have 1 tasks in the list.
```

### `deadline TASKNAME/DUE` : Add a deadline
Add a deadline to the Task List.

Example of usage:

`deadline cs2113t assignment/friday 2359`

Expected outcome:

Add cs2113t assignment to the Task List as a deadline due by friday 2359.

```
Got it. I've added this task: 
	[D] [ ] cs2113t assignment (by: friday 2359)
Now you have 2 tasks in the list.
```

### `event TASKNAME/TIME` : Add an event
Add an event to the Task List.

Example of usage:

`event mom's birthday/tuesday 6pm`

Expected outcome:

Add mom's birthday to the Task List as an event at 6pm on Tuesday.

```
Got it. I've added this task: 
	[E] [ ] mom's birthday (at: tuesday 6pm)
Now you have 3 tasks in the list.
```

### `list` - List all tasks
Generates a list of all tasks currently saved in the Task List.

Example of usage:

`list`

Expected outcome:

```
Here are the tasks in your list: 

1. [T] [ ] watch lecture
2. [D] [ ] cs2113t assignment (by: friday 2359)
3. [E] [ ] mom's birthday (at: tuesday 6pm)
```

### `delete INDEX` : Delete a task
Delete a task from the Task List.
- Deletes the task at the specified INDEX.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, ...

Example of usage:

`delete 1`

Expected outcome:

Deletes "watch lecture" from the Task List.

```
Noted. I've removed this task:
	[T] [ ] watch lecture
Now you have 2 tasks in the list.
```

### `mark INDEX` : Marks a task as done
Mark a task from the Task List as done.
- Marks the person at the specified INDEX as done.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, ...

Example of usage:

`mark 2`

Expected outcome:

Marks "mom's birthday" from the Task List as done.

```
Nice! I've marked this task as done: 
	[E] [X] mom's birthday (at: tuesday 6pm)
```

### `unmark INDEX` : Marks a task as not done
Mark a task from the Task List as not done.
- Marks the person at the specified INDEX as not done.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, ...

Example of usage:

`unmark 2`

Expected outcome:

Marks "mom's birthday" from the Task List as not done.

```
OK, I've marked this task as not done yet: 
	[E] [ ] mom's birthday (at: tuesday 6pm)
```

### `bye` : Exits the app
Exits the program.

### Saving the data
Duke's task data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file
Duke's task data are saved as a TXT file `[JAR file location]/data/duke.txt`. Advanced users are welcome to update data directly by editing that data file.