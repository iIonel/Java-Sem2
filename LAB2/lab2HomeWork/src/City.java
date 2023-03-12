public class City extends Location {
    private double population;

    public City(String name,  double x, double y, double population) {
        super(name,  x, y);
        this.population = population;
    }
}
