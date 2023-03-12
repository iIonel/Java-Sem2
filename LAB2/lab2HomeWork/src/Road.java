import java.util.Objects;

public abstract class Road {
    protected String name;
    private double length;
    private double speedLimit;
    public Road(String name, double length, double speedLimit) {
        this.name = name;
        this.length = length;
        this.speedLimit = speedLimit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Double.compare(road.length, length) == 0 && name.equals(road.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length);
    }
}

