import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {

    private List<String> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
        run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n ******************** To Do List ****************** \n");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            System.out.println("4. Quit");
            System.out.println("\nEnter choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void addTask() {
        System.out.println("\nEnter Task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added Successfully");
    }

    private void deleteTask() {
        System.out.println("\nEnter the task number to delete");
        int taskNum;
        try {
            taskNum = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
            return;
        }

        if (taskNum > 0 && taskNum <= tasks.size()) {
            tasks.remove(taskNum - 1);
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Invalid Task Number");
        }
    }

    private void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        new ToDoList();
    }
}