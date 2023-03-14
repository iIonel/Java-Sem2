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

        Dani.addFriend(Florin);
        Dani.addFriend(Tzanca);
        Dani.setEmployer(UrziSoft);
        Florin.setEmployer(Smecheria);
        Tzanca.setEmployer(Fabrica);
        UrziSoft.addEmployee(Dani,"Smecher");
        Smecheria.addEmployee(Florin,"BOSS");
        Fabrica.addEmployee(Tzanca,"viata mea");
        System.out.println(nodes);

    }
}