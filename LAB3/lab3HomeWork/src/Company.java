import java.util.*;
public class Company implements Node,Comparable<Company>{
    private String name;
    private Map<String, String> employees;

    public Map<String, String> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, String> employees) {
        this.employees = employees;
    }

    public Company(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }

    public void addEmployee(Person person, String job){
        this.employees.put(person.getName(),job);
        person.setEmployer(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
