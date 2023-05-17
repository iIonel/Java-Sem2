package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args)
    {
        List<Node> networkMain = new ArrayList<Node>();

        Node programmer1 = new Programmer("Ion", LocalDate.of(2000, 10, 10), 2750, ProgrammerType.MID);
        Node programmer2 = new Programmer("Vasile", LocalDate.of(2002, 5, 16), 500, ProgrammerType.INTERN);
        Node programmer3 = new Programmer("Mircea", LocalDate.of(1980, 9, 12), 10090, ProgrammerType.SENIOR);
        Node programmer4 = new Programmer("Stefan", LocalDate.of(2002, 8, 7), 1000, ProgrammerType.JUNIOR);
        Node programmer5 = new Programmer("Mihai", LocalDate.of(1970, 10, 15), 12000, ProgrammerType.SENIOR);

        Node company1 = new Company("Bitdefender", 6000);
        Node company2 = new Company("Vitesco", 4000);
        Node company3 = new Company("Continental", 4000);
        //Node company4 = new Company("Endava", 5000);
        //Node company5 = new Company("Mambu", 7000);

        //Node person1 = new Person("Mihut", LocalDate.of(1999,12,2));
        //Node person2 = new Person("Andrew", LocalDate.of(1997,12,11));

        networkMain.add(programmer1);
        networkMain.add(programmer2);
        networkMain.add(programmer3);
        networkMain.add(programmer4);
        networkMain.add(programmer5);
        //networkMain.add(person1);
        //networkMain.add(person2);

        networkMain.add(company1);
        networkMain.add(company2);
        networkMain.add(company3);
        //networkMain.add(company4);
        //networkMain.add(company5);

        Network network = new Network(networkMain);

        network.addRelationship(programmer1, programmer2, " Coleg de serviciu");
        network.addRelationship(programmer1, programmer3, " Coleg de serviciu");
        network.addRelationship(programmer2, programmer3, " Coleg de serviciu");
        //network.addRelationship(programmer1, company1, " angajat");
        //network.addRelationship(programmer2, company2, " patron");
        //network.addRelationship(programmer4, programmer5, " Coleg de serviciu");
        network.addRelationship(programmer4, company3, " angajat");
        network.addRelationship(programmer5, company3, " ceo");
        network.addRelationship(company2, programmer4, " partener");
        network.addRelationship(company2, programmer5, " partener");

        network.findArticulationPoints();
        network.findBlocks();

        System.out.println(network);
    }
}
