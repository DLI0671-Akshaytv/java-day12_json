package json_demo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> emp=new ArrayList<>();
        Gson gson=new Gson();
        try(FileReader reader=new FileReader("src/main/java/json_demo/employee.json")){
            Employee[] emp1=gson.fromJson(reader,Employee[].class);
            emp.addAll(Arrays.asList(emp1));
            System.out.println(emp);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
