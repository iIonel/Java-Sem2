import java.util.*;
public class Network {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Person Dani = new Person("Dani Mocanu");
        Designer Florin = new Designer("Florin Salam");
        Programmer Tzanca = new Programmer("Tzanca Uraganu");
        Company UrziSoft = new Company("UrziSoft");
        Company Smecheria = new Company("Scmecheria2000");
        Company Fabrica = new Company("Fabrica de compot Arnold Schwarzenegger");

        nodes.add(Dani);
        nodes.add(Florin);
        nodes.add(Tzanca);
        nodes.add(UrziSoft);
        nodes.add(Smecheria);
        nodes.add(Fabrica);

        for(int i = 0; i < nodes.size(); ++i){
            int count = 0;
            if(nodes.get(i) instanceof Person){
                List<Person> friends = ((Person) nodes.get(i)).getFriends();
                if(friends != null)
                    count += ((Person) nodes.get(i)).getFriends().size();
                Company employer = ((Person) nodes.get(i)).getEmployer();
                if(employer != null) count++;
            }
            else {
                Map<String, String> employees = ((Company) nodes.get(i)).getEmployees();
                if (employees != null)
                    count += ((Company) nodes.get(i)).getEmployees().size();
            }
        }
        System.out.println(nodes);

    }
}