import java.util.*;
public class Person implements Node,Comparable<Person>{
    private String name;
    private Company employer;
    private List<Person> friends;
    public Person(String name) {
        this.name = name;
        employer = null;
    }

    public List<Person> getFriends() {
        return friends;
    }

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
    public void addFriend(Person friend) {
        this.friends.add(friend);
        friend.friends.add(this);
    }

    public void setEmployer(Company company) {
        this.employer = company;
    }

    public Company getEmployer() {
        return employer;
    }
}
