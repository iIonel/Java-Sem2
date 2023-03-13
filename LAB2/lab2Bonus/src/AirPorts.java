public class AirPorts extends Location {
    private int terminals;

    public AirPorts(String name, double x, double y, int terminals) {
        super(name, x, y);
        this.terminals = terminals;
    }
}
