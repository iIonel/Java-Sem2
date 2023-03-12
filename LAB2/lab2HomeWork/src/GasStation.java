public class GasStation extends Location {
    private double gasPrize;

    public GasStation(String name,  double x, double y, double gasPrize) {
        super(name,  x, y);
        this.gasPrize = gasPrize;
    }
}
