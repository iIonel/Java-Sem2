public class Route {
    private Location firstNode;
    private Location secondNode;
    private Road edge;

    public Route(Location firstNode, Location secondNode, Road edge) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.edge = edge;
    }

    public Location getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Location firstNode) {
        this.firstNode = firstNode;
    }

    public Location getSecondNode() {
        return secondNode;
    }

    public void setSecondNode(Location secondNode) {
        this.secondNode = secondNode;
    }

    public Road getEdge() {
        return edge;
    }

    public void setEdge(Road edge) {
        this.edge = edge;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
