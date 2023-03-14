import java.util.HashMap;
import java.util.Map;
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
        this.employees = new HashMap<String, String>();
    }
    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    public void addEmployee(Person p,String job){
        this.employees.put(p.getName(),job);
        p.setEmployer(this);
    }

    @Override
    public String getName() {
        return null;
    }
}