public class Main {
    public static void main(String[] args) {
        Location a = new Location("Botosani",LocationType.cities,1241.123,521.4);
        System.out.println(a);

        Road b = new Road();
        b.setType(RoadTypes.express);
        b.setLength(230);
        b.setSpeedLimit(150);
        System.out.println(b);
    }
}