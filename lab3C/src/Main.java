import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Person Dani = new Person("Dani Mocanu");
        Person Florin = new Person("Florin Salam");
        Person Tzanca = new Person("Tzanca Uraganu");

        nodes.add(Dani);
        nodes.add(Florin);
        nodes.add(Tzanca);

        System.out.println(nodes);

    }
}