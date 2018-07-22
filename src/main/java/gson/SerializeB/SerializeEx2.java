package gson.SerializeB;

import com.google.gson.*;

import java.lang.reflect.Type;

public class SerializeEx2 {
    static class Date {
        int year;
        int month;
        int day;
        Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
    static class Employee {
        String name;
        Date hireDate;
    }
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "John Doe";
        e.hireDate = new Date(1982, 10, 12);
        GsonBuilder gb = new GsonBuilder();

        class EmployeeSerializer implements JsonSerializer<Employee> {
            // {"emp-name":"John Doe","hire-date":{"year":1982,"month":10,"day":12}}
            @Override
            public JsonElement serialize(Employee emp, Type typeOfSrc,
                                         JsonSerializationContext context) {
                JsonObject jo = new JsonObject();
                jo.addProperty("emp-name", emp.name);
                jo.add("hire-date", context.serialize(emp.hireDate));
                return jo;
            }
        }
        gb.registerTypeAdapter(Employee.class, new EmployeeSerializer());
        Gson gson = gb.create();
        System.out.printf("%s%n%n", gson.toJson(e));
    }
}

