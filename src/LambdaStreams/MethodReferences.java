package LambdaStreams;

import mfaella.Employee;

import java.util.Comparator;
import java.util.function.Function;

interface ThreadSupplier{
    Thread getThread();
}

public class MethodReferences {

    public static void actions(){
        // static method - public static native Thread currentThread();
        Supplier<Thread> s1 = Thread::currentThread;
        ThreadSupplier ts = Thread::currentThread;

        // instance method (instance initialised)
        Employee frank = new Employee("Frank", 3000);
        Supplier<Integer> s2 = frank::getSalary;
        Integer i1 = s2.get();

        // instance method (instance not initialised)
        // public interface Function<T, R> {R apply(T t);}
        Function<Employee, Integer> f1 = Employee::getSalary;
        Integer i2 = f1.apply(frank);
        System.out.println(i2);

        Comparator<Employee> byName = Comparator.comparing(f1);
        Comparator<Employee> byName2 = Comparator.comparing(Employee::getName);
    }


    public static <T> void printAllEmpl(T[] array, Function<T, String> toNewString){
        int i = 0;
        for (T t: array){
            System.out.println(i++ + ":\t" + toNewString.apply(t));
        }
    }


    public static void main(String[] args) {
        Employee e1 = new Employee("Name", 1000);
        e1.buildDept();
        printAllEmpl(e1.getDept(), Employee::getName);

        actions();
    }


    public static class Employee{
        private String name;
        private int salary;
        public Employee[] dept = new Employee[5];

        public Employee(String name, int salary){
            this.name = name;
            this.salary = salary;
        }

        public void buildDept(){
            dept[0] = new Employee("Mike", 2500);
            dept[1] = new Employee("Frank", 3000);
            dept[2] = new Employee("Hannah", 2500);
            dept[3] = new Employee("Rajeev", 2000);
            dept[4] = new Employee("Jessica", 1500);
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public Employee[] getDept() {
            return dept;
        }
    }
}
