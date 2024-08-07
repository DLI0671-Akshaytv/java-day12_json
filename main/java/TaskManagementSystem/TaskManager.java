package TaskManagementSystem;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TaskManager {
    Set<Integer>uniqueID=new HashSet<>();
    List<Task> tasks=new ArrayList<>();
    Gson gson=new Gson();
    public void addTask(Task task){
        tasks.add(task);
        if(uniqueID.contains(task.getTaskId())){
            System.out.println("Task with ID " + task.getTaskId() + " already exists. Please choose a different ID.");
            tasks.remove(task);
        }else{
            uniqueID.add(task.getTaskId());
            saveTasks(tasks);
            System.out.println("Task Added successfully!");

        }

    }
    public void saveTasks(List<Task> t){
        try(FileWriter writer=new FileWriter("src/main/java/TaskManagementSystem/task.json")){
            gson.toJson(t,writer);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void viewAllTasks(){
        List<Task>taskList=new ArrayList<>();
        try(FileReader reader=new FileReader("src/main/java/TaskManagementSystem/task.json")){
            Task[] task=gson.fromJson(reader,Task[].class);
            taskList.addAll(Arrays.asList(task));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        for(Task i:taskList){
            System.out.println(i);
        }

    }

    public void delete(int id){
        List<Task>taskList_delete=new ArrayList<>();
        try(FileReader reader=new FileReader("src/main/java/TaskManagementSystem/task.json")){
            Task[] task=gson.fromJson(reader,Task[].class);
            taskList_delete.addAll(Arrays.asList(task));
            Task delete_task=null;
            for(Task i:taskList_delete){
                if(i.getTaskId()==id){
                    delete_task=i;
                    break;
                }
            }
            if(delete_task!=null){
                taskList_delete.remove(delete_task);
                uniqueID.remove(id);
                saveTasks(taskList_delete);
                System.out.println("Task deleted!");
            }
            else {
                System.out.println("Task with ID " + id + " not found.");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void mark_completed(int id){
        List<Task>taskList_completed=new ArrayList<>();
        try(FileReader reader=new FileReader("src/main/java/TaskManagementSystem/task.json")){
            Task[] task=gson.fromJson(reader,Task[].class);
            taskList_completed.addAll(Arrays.asList(task));
            Task complete_task=null;
            for(Task i:taskList_completed){
                if(i.getTaskId()==id){
                    complete_task=i;
                    break;
                }
            }
            if(complete_task!=null){
                complete_task.setCompleted(true);
                saveTasks(taskList_completed);
                System.out.println("Task marked as Completed!");
            }
            else {
                System.out.println("Task with ID " + id + " not found.");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
