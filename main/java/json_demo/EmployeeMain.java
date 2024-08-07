package json_demo;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> emp=new ArrayList<>();
        Gson gson=new Gson();
        try(FileReader reader=new FileReader("src/main/java/json_demo/employee.json"); ){
            Employee[] emp1 = gson.fromJson(reader, Employee[].class);
            emp.addAll(Arrays.asList(emp1));
            System.out.println(emp);
            //updates a specific field
            System.out.println("Enter the Employee id: ");
            Scanner s=new Scanner(System.in);
            int id=s.nextInt();
            for(Employee employee :emp){
                if(employee.id==id){
                    System.out.println("Enter new City: ");
                    s.nextLine();
                    employee.setCity(s.nextLine());
                }
            }

        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        try(FileWriter writer=new FileWriter("src/main/java/json_demo/employee.json")){
            gson.toJson(emp.toArray(),writer);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
