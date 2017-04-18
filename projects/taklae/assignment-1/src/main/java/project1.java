/**
 * Created by evtak_000 on 4/17/2017.
 */
import java.util.LinkedList;

//Taken from https://www.tutorialspoint.com/javaexamples/data_queue.htm

public class project1 {
    public static void main(String[] args) {
        GenQueue<Employee> empList;
        empList = new GenQueue<Employee>();
        GenQueue<HourlyEmployee> hList;

        hList = new GenQueue<HourlyEmployee>();
        hList.enqueue(new HourlyEmployee("T", "D"));
        hList.enqueue(new HourlyEmployee("G", "B"));
        hList.enqueue(new HourlyEmployee("F", "S"));
        empList.addItems(hList);
        System.out.println("The employees' names are:");

        while (!empList.hasItems()) {
            Employee emp = empList.dequeue();
            System.out.println(emp.firstName + " " + emp.lastName);
        }
    }
}
class Employee {
    public String lastName;
    public String firstName;
    public Employee() {
    }
    public Employee(String last, String first) {
        this.lastName = first;                                      //Induced bug #2, they've been switched around
        this.firstName = last;
    }
    public String toString() {
        return firstName + " " + lastName;
    }
}
class HourlyEmployee extends Employee {

    public double hourlyRate;
    public HourlyEmployee(String last, String first) {
        super(last, first);
    }
}