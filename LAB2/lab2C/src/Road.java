enum RoadTypes{
    highways, express, country
}
public class Road {
    private RoadTypes type;
    private double length;

    public Road() {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    private double speedLimit;

    public RoadTypes getType() {
        return type;
    }

    public void setType(RoadTypes type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
