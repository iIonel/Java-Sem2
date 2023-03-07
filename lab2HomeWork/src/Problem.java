
public class Problem {
    private Location[] locations;
    private Road[] roads;
    private Route[] routes;

    public Problem(Location[] locations, Road[] roads, Route[] routes) {
        this.locations = locations;
        this.roads = roads;
        this.routes = routes;
    }

    public boolean ValidProblem(Location[] locations, Road[] roads, Route[] routes){
        for(int i = 0; i < locations.length; ++i){
            Location currentLocation = locations[i];
            boolean reached = false;
            for(int j = 0; j < routes.length; ++j)
            {
                Route currentRoute = routes[j];
                if(currentRoute == null)
                    return false;
                if(currentRoute.getFirstNode() == null)
                    return false;
                if(currentRoute.getSecondNode() == null)
                    return false;
                if(currentLocation == currentRoute.getFirstNode() || currentLocation == currentRoute.getSecondNode())
                    reached = true;
            }
            if(reached == false) return false;
        }

        for(int i = 0; i < roads.length; ++i){
            Road currentRoad = roads[i];
            boolean reached = false;
            for(int j = 0; j < routes.length; ++j)
            {
                Route currentRoute = routes[j];
                if(currentRoute == null)
                    return false;
                if(currentRoute.getEdge() == null)
                    return false;
                if(currentRoad == currentRoute.getEdge())
                    reached = true;
            }
            if(reached == false) return false;
        }
        return true;
    }
    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public Road[] getRoads() {
        return roads;
    }

    public void setRoads(Road[] roads) {
        this.roads = roads;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public void setRoutes(Route[] routes) {
        this.routes = routes;
    }
}
