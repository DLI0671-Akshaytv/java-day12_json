package TaskManagementSystem;

import java.util.Scanner;

public class TaskManagementMain {
    public static void main(String[] args) {
        TaskManager man=new TaskManager();
        System.out.println("Welcome to Task Management System.");
        Scanner s=new Scanner(System.in);
        do{
            System.out.println("1. Add a new Task");
            System.out.println("2. View all tasks");
            System.out.println("3. Update Task Details");
            System.out.println("4. Delete task details");
            System.out.println("5. Mark Task completed");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            switch(s.nextInt()){
                case 1:
                    System.out.println("Enter TaskId:");
                    int id=s.nextInt();
                    System.out.println("Enter Task description: ");
                    s.nextLine();
                    String desc= s.nextLine();
                    System.out.println("Enter due Date(dd-mm-yyyy)");
                    String date=s.next();
                    Task t=new Task(id,desc,date,false);
                    man.addTask(t);
                    break;
                case 2:man.viewAllTasks();
                break;
                case 4:
                    System.out.print("Enter task id: ");
                    man.delete(s.nextInt());
                    break;
                case 5:
                    System.out.println("Enter task id");
                    man.mark_completed(s.nextInt());
                    break;

                case 6:return;
                default:
                    System.out.println("Invalid Input!");
                    break;

            }


        }while(true);
    }
}
