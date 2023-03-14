import java.util.*;
public class Person implements Node,Comparable<Person>{
    private String name;
    private List<Person> friend;
    private Company employer;

    public List<Person> getFriend() {
        return friend;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setFriend(List<Person> friend) {
        this.friend = friend;
    }

    public Person(String name) {
        this.name = name;
        this.friend = new ArrayList<Person>();
        this.employer = null;
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

    public void setEmployer(Company company) {
        this.employer = company;
    }

    public void addFriend(Person f){
        this.friend.add(f);
        f.friend.add(this);
    }

}
