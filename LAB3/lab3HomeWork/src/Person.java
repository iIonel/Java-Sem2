import java.util.*;
public class Person implements Node,Comparable<Person>{
    private String name;
    private List<Person> friend;
    private Company employer;
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    public void setName(String name) {
        this.name = name;
    }
}
