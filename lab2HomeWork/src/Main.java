public class Main {
    public static void DFS(Location a, Route[] routes){
        a.setVisited(true);
        for(int i = 0; i < routes.length; ++i){
            if(routes[i].getFirstNode() == a)
                if(routes[i].getSecondNode().isVisited() == false)
                    DFS(routes[i].getSecondNode(),routes);
            if(routes[i].getSecondNode() == a)
              if(routes[i].getFirstNode().isVisited() == false)
                  DFS(routes[i].getFirstNode(),routes);
        }
    }
    public static void main(String[] args) {

        Location[] locations = new Location[5];
        locations[0] = new City("Botosani",1241.123,521.4,12212);
        locations[1] = new City("Iasi",2985.41,6475.1,151231);
        locations[2] = new City("Suceava",245.9,8623.5,54321);
        locations[3] = new AirPorts("Henri Coanda",151213.123,12412,5);
        locations[4] = new GasStation("OMV",23124,86.2,5.5);
        for(int i = 0; i < 5; ++i){
            locations[i].setVisited(false);
        }

        Road[] roads = new Road[7];
        roads[0] = new HighWay("N23",156,150);
        roads[1] = new HighWay("N12",220,150);
        roads[2] = new HighWay("N75",142,150);
        roads[3] =  new Express("E41",60,120);
        roads[4] = new Express("E32",55,120);
        roads[5] = new Express("E9",75,120);
        roads[6] = new Country("Narciselor", 22,60);

        Route[] routes = new Route[7];
        routes[0] = new Route(locations[0], locations[1], roads[1]);
        routes[1] = new Route(locations[0], locations[2], roads[2]);
        routes[2] = new Route(locations[1], locations[2], roads[0]);
        routes[3] = new Route(locations[1], locations[4], roads[4]);
        routes[4] = new Route(locations[0], locations[4], roads[3]);
        routes[5] = new Route(locations[2], locations[4], roads[5]);
        routes[6] = new Route(locations[1], locations[3], roads[6]);

        Problem pb = new Problem(locations,roads,routes);
        if(pb.ValidProblem(locations,roads,routes) == true){
            System.out.println("Valid Problem");

            Location start = locations[0];
            Location finish = locations[3];
            DFS(start,routes);

            for(int i = 0; i < locations.length; ++i)
                System.out.print(locations[i].isVisited() + " ");
            System.out.println();

            if(finish.isVisited() == true)
                System.out.print("Possible Road");
            else System.out.print("Impossible Road");

        }
        else System.out.println("Nevalid Problem");
    }
}